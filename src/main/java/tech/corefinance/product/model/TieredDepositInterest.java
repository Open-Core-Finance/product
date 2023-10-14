package tech.corefinance.product.model;

import lombok.Data;

import java.util.List;

@Data
public class TieredDepositInterest extends AbstractDepositInterestRate {
    private boolean applyWithholdingTaxes;
    private List<TieredInterestItem> interestItems;
}
