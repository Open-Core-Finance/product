package tech.corefinance.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.corefinance.product.model.SavingProduct;

@Repository
public interface SavingProductRepository extends JpaRepository<SavingProduct, Long> {
}
