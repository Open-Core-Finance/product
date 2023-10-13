package tech.corefinance.product.model;

import lombok.Data;
import tech.corefinance.product.enums.InterestCalculationMethod;
import tech.corefinance.product.enums.InterestDayInYear;

@Data
public class AbstractInterestRate implements InterestRate {

    private InterestCalculationMethod calculationMethod;
    private InterestCalculationDateOption calculationDateOption;
    private InterestDayInYear interestDayInYear;
}
