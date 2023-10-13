package tech.corefinance.product.model;

import java.util.List;

public class TieredInterest extends AbstractInterestRate {
    private boolean applyWithholdingTaxes;
    private List<TieredInterestItem> interestItems;
}
