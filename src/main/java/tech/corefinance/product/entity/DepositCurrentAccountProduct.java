package tech.corefinance.product.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import tech.corefinance.product.model.InterestRate;

/**
 * A transactional account where a client may perform regular deposit and withdrawals,
 * accrue interest and may optionally be allowed to go into overdraft.
 */
@Data
@Entity
public class DepositCurrentAccountProduct extends DepositProduct {
    private boolean allowOverdrafts;
    @JdbcTypeCode(SqlTypes.JSON)
    private InterestRate overdraftsInterest;
    private Double maxOverdraftLimit;
}
