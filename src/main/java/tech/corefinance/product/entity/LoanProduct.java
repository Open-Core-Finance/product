package tech.corefinance.product.entity;

import jakarta.persistence.*;
import lombok.Data;
import tech.corefinance.common.model.GenericModel;

@Data
@Entity
@Table(name = "loan_product")
public class LoanProduct implements GenericModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
