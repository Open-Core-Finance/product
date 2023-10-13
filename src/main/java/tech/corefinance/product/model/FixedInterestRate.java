package tech.corefinance.product.model;

public class FixedInterestRate extends AbstractInterestRate {
    private boolean applyWithholdingTaxes;
    private boolean allowNegativeInterestRate;

    private Double minInterest;
    private Double maxInterest;
    private Double defaultInterest;
}
