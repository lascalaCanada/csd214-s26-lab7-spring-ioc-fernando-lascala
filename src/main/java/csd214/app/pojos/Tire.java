package csd214.app.pojos;

import csd214.app.entities.TireEntity;

import java.util.Objects;
import java.util.Scanner;

/**
 * Domain POJO representing a Tire in the system.
 * Inherits common vehicle part properties from VehiclePart.
 */
public class Tire extends VehiclePart {
    private int diameter;

    /**
     * Default constructor required for instantiation.
     */
    public Tire() {
    }

    /**
     * Parameterized constructor specifying diameter.
     *
     * @param diameter wheel diameter value
     */
    public Tire(int diameter) {
        this.diameter = diameter;
    }

    /**
     * Parameterized constructor for manufacturer, price, and diameter.
     *
     * @param manufacturer manufacturer name string
     * @param price product price
     * @param diameter wheel diameter value
     */
    public Tire(String manufacturer, double price, int diameter) {
        super(manufacturer, price);
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "Tire{" +
                "diameter=" + diameter +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tire tire = (Tire) o;
        return diameter == tire.diameter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diameter);
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public void initialize(Scanner input) {
        // Pass scanner up to parent
        super.initialize(input);

        System.out.println("Enter Diameter:");
        this.diameter = getInput(input, 0);
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);
        System.out.println("Enter Diameter:");
        this.diameter = getInput(input, getDiameter());
    }

    @Override
    public void sellItem() {
        System.out.println("Selling a Tire");
    }

    /**
     * Converts this POJO instance to a TireEntity persistence object.
     *
     * @return populated TireEntity instance
     */
    public TireEntity toEntity() {
        TireEntity entity = new TireEntity();
        entity.setId(this.getDbId()); // Map base Long primary key
        entity.setProductId(this.getProductId()); // Map base String UUID
        entity.setBrand(this.getManufacturer()); // Maps manufacturer to brand field in TireEntity
        entity.setPrice(this.getPrice()); // Maps price inherited from ProductEntity
        entity.setWheelSize(this.getDiameter()); // Maps diameter to wheelSize field in TireEntity
        return entity;
    }

    /**
     * Static factory method to map a TireEntity to a domain Tire POJO.
     *
     * @param entity TireEntity source instance
     * @return mapped Tire POJO instance
     */
    public static Tire fromEntity(TireEntity entity) {
        Tire tire = new Tire(
                entity.getBrand(), // Reads brand from TireEntity
                entity.getPrice(), // Reads price from ProductEntity
                entity.getWheelSize() // Reads wheelSize from TireEntity
        );
        tire.setDbId(entity.getId());
        tire.setProductId(entity.getProductId());
        return tire;
    }
}