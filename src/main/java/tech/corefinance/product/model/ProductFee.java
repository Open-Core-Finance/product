package tech.corefinance.product.model;

import lombok.Data;
import tech.corefinance.product.enums.MonthlyPayOption;

@Data
public class ProductFee {

    private boolean activated;
    private String id;
    private String name;
    private ProductFeeType type;
    private double amount;

    private MonthlyPayOption monthlyPayOption;

    public enum ProductFeeType {
        MANUAL_FEE, MONTHLY_FEE;
    }
}
