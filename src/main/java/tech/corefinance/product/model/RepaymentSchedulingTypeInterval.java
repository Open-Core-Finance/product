package tech.corefinance.product.model;

import lombok.Data;
import tech.corefinance.product.enums.IntervalOption;

@Data
public class RepaymentSchedulingTypeInterval implements RepaymentSchedulingType {
    private int intervalValue;
    private IntervalOption intervalOption;
}
