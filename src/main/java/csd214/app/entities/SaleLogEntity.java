package csd214.app.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

// Maps the database table used to store sales audit history
@Entity
@Table(name = "sale_logs")
public class SaleLogEntity {

    // Auto-generated primary key for each log record
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Unique identifier of the product that was sold
    private String productId;

    // Final price at which the item was sold
    private double priceSoldAt;

    // Timestamp recording when the transaction took place
    private LocalDateTime timestamp;

    // Default no-argument constructor required by JPA/Hibernate
    public SaleLogEntity() {
    }

    // Helper constructor to quickly create a log entry upon completing a sale
    public SaleLogEntity(String productId, double price) {
        this.productId = productId;
        this.priceSoldAt = price;
        // Capture current date and time automatically
        this.timestamp = LocalDateTime.now();
    }

    // Returns the primary key ID of the log entry
    public Long getId() {
        return id;
    }

    // Sets the primary key ID of the log entry
    public void setId(Long id) {
        this.id = id;
    }

    // Gets the product identifier associated with this sale log
    public String getProductId() {
        return productId;
    }

    // Sets the product identifier associated with this sale log
    public void setProductId(String productId) {
        this.productId = productId;
    }

    // Returns the price at which the item was sold
    public double getPriceSoldAt() {
        return priceSoldAt;
    }

    // Sets the sale price for this log record
    public void setPriceSoldAt(double priceSoldAt) {
        this.priceSoldAt = priceSoldAt;
    }

    // Gets the exact timestamp when the sale occurred
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Sets the exact timestamp for the sale log
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Verifies equality between two SaleLogEntity objects based on field values
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleLogEntity that = (SaleLogEntity) o;
        return Double.compare(that.priceSoldAt, priceSoldAt) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(timestamp, that.timestamp);
    }

    // Generates a hash code for the entity based on its attributes
    @Override
    public int hashCode() {
        return Objects.hash(id, productId, priceSoldAt, timestamp);
    }

    // Returns a readable string representation of the log object for debugging
    @Override
    public String toString() {
        return "SaleLogEntity{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", priceSoldAt=" + priceSoldAt +
                ", timestamp=" + timestamp +
                '}';
    }
}