package tech.corefinance.product.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import tech.corefinance.common.model.GenericModel;
import tech.corefinance.product.enums.CreditArrangementManaged;
import tech.corefinance.product.model.InterestRate;
import tech.corefinance.product.model.ProductAvailability;
import tech.corefinance.product.model.ProductNewAccountSetting;
import tech.corefinance.product.model.RepaymentScheduling;

import java.util.List;

@Data
@Entity
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "loan_product")
public abstract class LoanProduct implements GenericModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String category;
    private String description;
    private boolean activated;
    @NotNull
    @JdbcTypeCode(SqlTypes.JSON)
    private List<ProductAvailability> productAvailabilities;
    @NotNull
    @JdbcTypeCode(SqlTypes.JSON)
    private ProductNewAccountSetting newAccountSetting;
    @NotNull
    private String mainCurrency;

    private double loanMin;
    private double loanMax;
    private double loanDefault;
    private CreditArrangementManaged underCreditArrangementManaged;

    private InterestRate interestRate;
    private RepaymentScheduling repaymentScheduling;
    // TBD
}
