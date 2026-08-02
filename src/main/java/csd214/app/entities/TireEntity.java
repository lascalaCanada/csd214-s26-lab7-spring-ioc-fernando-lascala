package csd214.app.entities;

import jakarta.persistence.Entity;

/**
 * Subclass entity representing a Tire product.
 * Inherits primary key (id), UUID (productId), and price from ProductEntity.
 */
@Entity
public class TireEntity extends ProductEntity {

    private int wheelSize;
    private String brand;

    /**
     * Default constructor required by JPA.
     */
    public TireEntity() {
        super();
    }

    /**
     * Parameterized constructor to initialize a Tire instance.
     *
     * @param brand     The manufacturer brand of the tire.
     * @param price     The monetary price of the tire (passed to parent entity).
     * @param wheelSize The wheel size/diameter in inches.
     */
    public TireEntity(String brand, double price, int wheelSize) {
        super();
        this.brand = brand;
        this.setPrice(price); // Sets the price property inherited from ProductEntity
        this.wheelSize = wheelSize;
    }

    // --- Getters and Setters ---
    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "TireEntity{" +
                "id=" + getId() +
                ", productId='" + getProductId() + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + getPrice() +
                ", wheelSize=" + wheelSize +
                '}';
    }
}