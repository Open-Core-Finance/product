package tech.corefinance.product.entity;

import jakarta.persistence.*;
import lombok.Data;
import tech.corefinance.product.enums.ProductCategoryType;

@Entity
@Table(name = "product_category")
@Data
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ProductCategoryType type;
    private String name;
}
