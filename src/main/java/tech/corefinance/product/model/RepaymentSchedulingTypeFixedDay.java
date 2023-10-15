package tech.corefinance.product.model;

import lombok.Data;

import java.util.List;

@Data
public class RepaymentSchedulingTypeFixedDay implements RepaymentSchedulingType {
    private List<Integer> repaymentDays;
}
