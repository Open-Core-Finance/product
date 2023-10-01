package tech.corefinance.product.model;

import jakarta.persistence.*;
import lombok.Data;
import tech.corefinance.common.model.GenericModel;

@Data
@Entity
@Table(name = "deposit_product")
public class DepositProduct implements GenericModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
