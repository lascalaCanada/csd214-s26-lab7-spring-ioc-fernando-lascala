package csd214.app.entities;

import jakarta.persistence.*;

/**
 * Parent entity representing a generic product in the catalog.
 * Uses SINGLE_TABLE inheritance strategy so all subclasses share the same table.
 */
@Entity
@Table(name = "product_entity")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id")
    private String productId;

    // Common attribute required across all product subclasses for derived queries (e.g., price filtering)
    @Column(name = "price")
    private double price;

    /**
     * Default constructor.
     * Automatically generates a fallback UUID for productId upon instantiation.
     */
    public ProductEntity() {
        this.productId = java.util.UUID.randomUUID().toString();
    }

    /**
     * Constructor with custom product ID.
     *
     * @param productId The custom unique identifier string.
     */
    public ProductEntity(String productId) {
        this.productId = productId;
    }

    // --- Getters and Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}