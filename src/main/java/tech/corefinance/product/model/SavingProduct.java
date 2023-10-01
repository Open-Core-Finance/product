package tech.corefinance.product.model;

import jakarta.persistence.*;
import lombok.Data;
import tech.corefinance.common.model.GenericModel;

@Data
@Entity
@Table(name = "saving_product")
public class SavingProduct implements GenericModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
