package tech.corefinance.product.model;

import lombok.Data;

import java.util.List;

@Data
public class TieredInterest extends AbstractInterestRate {
    private boolean applyWithholdingTaxes;
    private List<TieredInterestItem> interestItems;
}
