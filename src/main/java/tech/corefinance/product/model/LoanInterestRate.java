package tech.corefinance.product.model;

import lombok.Data;
import tech.corefinance.product.enums.*;

@Data
public class LoanInterestRate implements InterestRate {
    private InterestCalculationMethod interestCalculationMethod;
    private AccruedInterestPostingFrequency accruedInterestPostingFrequency;
    private LoanInterestType interestType;
    private InterestDayInYear interestDayInYear;
    private InterestRateConstraint interestRateConstraint;
    private RepaymentsInterestCalculation repaymentsInterestCalculation;
}
