package tech.corefinance.product.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import tech.corefinance.product.model.InterestRate;

/**
 * A standard savings account where a client may perform regular deposit and withdrawals and accrue interest over time.
 */
@Data
@Entity
public class DepositSavingAccountProduct extends DepositProduct {
}
