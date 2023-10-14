package tech.corefinance.product.model;

import lombok.Data;

@Data
public class FixedDepositInterestRate extends AbstractDepositInterestRate {
    private boolean applyWithholdingTaxes;
    private boolean allowNegativeInterestRate;

    private Double minInterest;
    private Double maxInterest;
    private Double defaultInterest;
}
