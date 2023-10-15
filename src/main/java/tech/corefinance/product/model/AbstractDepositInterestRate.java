package tech.corefinance.product.model;

import lombok.Data;
import tech.corefinance.product.enums.DepositBalanceInterestCalculation;
import tech.corefinance.product.enums.InterestCalculationMethod;
import tech.corefinance.product.enums.InterestDayInYear;

@Data
public class AbstractDepositInterestRate implements InterestRate {
    private InterestCalculationMethod interestCalculationMethod;
    private DepositBalanceInterestCalculation balanceInterestCalculation;
    private DepositInterestCalculationDateOption calculationDateOption;
    private InterestDayInYear interestDayInYear;
}
