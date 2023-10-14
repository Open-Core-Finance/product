package tech.corefinance.product.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import tech.corefinance.common.model.GenericModel;
import tech.corefinance.product.model.InterestRate;
import tech.corefinance.product.model.ProductAvailability;
import tech.corefinance.product.model.ProductFee;
import tech.corefinance.product.model.ProductNewAccountSetting;

import java.util.List;

@Data
@Entity
@Table(name = "deposit_product")
public class DepositProduct implements GenericModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String category;
    private String description;
    private boolean activated;
    @NotNull
    private List<ProductAvailability> productAvailabilities;
    @NotNull
    private ProductNewAccountSetting newAccountSetting;
    @NotNull
    private String mainCurrency;
    private List<String> supportedCurrencies;
    private InterestRate interestRate;

    // Internal control
    private Integer daysToSetToDormant;

    // Fees.
    private boolean allowArbitraryFees;
    private boolean showInactiveFees;
    private List<ProductFee> productFees;
    /**
     *  Deposit transaction limits
     *  WithdrawalLimits
     *  Dates
     *  Fees
     */
}
