package tech.corefinance.product.model;

import lombok.Data;
import tech.corefinance.product.enums.NonWorkingDaysRescheduling;
import tech.corefinance.product.enums.RepaymentScheduleRounding;
import tech.corefinance.product.enums.ShortMonthHandling;

@Data
public class RepaymentScheduling {
    private RepaymentSchedulingType type;
    private ShortMonthHandling shortMonthHandling;
    private MoneyConstraint installmentsConstraint;
    private int collectPrincipalEveryRepayments;
    /**
     * Principal Grace Period. If this option is not null then Pure Grace Period must be null.
     */
    private MoneyConstraint principalGracePeriod;
    /**
     * Pure Grace Period. If this option is not null then Principal Grace Period must be null.
     */
    private MoneyConstraint pureGracePeriod;

    private RepaymentScheduleRounding scheduleRounding;

    private NonWorkingDaysRescheduling nonWorkingDaysRescheduling;

    private RepaymentsScheduleEditing repaymentsScheduleEditing;
}
