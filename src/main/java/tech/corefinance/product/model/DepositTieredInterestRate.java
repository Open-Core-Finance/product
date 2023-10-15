package tech.corefinance.product.model;

import lombok.Data;

import java.util.List;

@Data
public class DepositTieredInterestRate extends AbstractDepositInterestRate {
    private boolean applyWithholdingTaxes;
    private List<TieredInterestItem> interestItems;
}
