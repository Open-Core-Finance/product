package tech.corefinance.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.corefinance.product.entity.LoanProduct;

@Repository
public interface LoanProductRepository extends JpaRepository<LoanProduct, Long> {
}
