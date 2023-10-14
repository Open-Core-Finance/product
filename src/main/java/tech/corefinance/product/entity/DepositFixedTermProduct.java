package tech.corefinance.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import tech.corefinance.product.enums.DepositTermUnit;

/**
 * <b>Fixed Deposit: </b><br/>
 * As the name suggests, fixed deposits have a fixed term after which they should be withdrawn or closed.
 * With this type of product, clients are able to make deposits until the minimum opening balance has been reached.
 * At this point, you can begin the maturity period, during which they will be unable to deposit, but will be able to withdraw.
 * Before the maturity date, you have the option to undo maturity. <br/><br/>
 * <b>Savings Plan: </b><br/>Uses a maturity period like fixed deposits,
 * but once the minimum opening balance has been reached, they will still be able to make deposits,
 * even during the maturity period itself. However, they will no longer be able to make deposits once the maturity period has ended.
 */
@Data
@Entity
public class DepositFixedTermProduct extends DepositProduct {
    @Enumerated(EnumType.STRING)
    private DepositTermUnit termUnit;
    private Double minTermLength;
    private Double maxTermLength;
    private Double defaultTermLength;
    private boolean allowDepositAfterMaturityDate;
}
