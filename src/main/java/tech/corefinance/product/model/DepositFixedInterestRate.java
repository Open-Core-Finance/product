package tech.corefinance.product.model;

import lombok.Data;

@Data
public class DepositFixedInterestRate extends AbstractDepositInterestRate {
    private boolean applyWithholdingTaxes;
    private boolean allowNegativeInterestRate;

    private InterestRateConstraint interestRateConstraint;
}
