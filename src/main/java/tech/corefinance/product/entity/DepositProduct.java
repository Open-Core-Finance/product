package tech.corefinance.product.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import tech.corefinance.common.model.GenericModel;
import tech.corefinance.product.enums.DepositLimitType;
import tech.corefinance.product.model.*;

import java.util.List;

@Data
@Entity
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "deposit_product")
public abstract class DepositProduct implements GenericModel<Long> {

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
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> supportedCurrencies;
    /**
     * Interest Rate.
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private InterestRate interestRate;

    // Internal control
    private Integer daysToSetToDormant;

    // Product Fees
    private boolean allowArbitraryFees;
    private boolean showInactiveFees;
    @JdbcTypeCode(SqlTypes.JSON)
    private List<ProductFee> productFees;

    /**
     *  Deposit transaction limits.
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private List<DepositLimit> depositLimits;
    /**
     *  Withdrawal Limits.
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private WithdrawalLimit withdrawalLimit;
    /**
     *  Early Closure Period.
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private Integer earlyClosurePeriod;
}
