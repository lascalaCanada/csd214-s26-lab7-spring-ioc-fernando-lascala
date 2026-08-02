package csd214.app.repositories;

import csd214.app.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    // Find by custom UUID/String productId
    Optional<ProductEntity> findByProductId(String productId);

    // Derived Query Methods for price filtering
    List<ProductEntity> findByPriceLessThan(double price);

    List<ProductEntity> findByPriceBetween(double minPrice, double maxPrice);
}