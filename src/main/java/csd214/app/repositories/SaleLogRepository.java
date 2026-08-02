package csd214.app.repositories;

import csd214.app.entities.SaleLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Marks this interface as a Spring Data repository bean for audit log persistence
@Repository
public interface SaleLogRepository extends JpaRepository<SaleLogEntity, Long> {
    // Inherits standard CRUD operations (save, findAll, findById, delete, etc.) from JpaRepository
}