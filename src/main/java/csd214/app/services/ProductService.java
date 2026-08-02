package csd214.app.services;

import csd214.app.entities.ProductEntity;
import csd214.app.entities.SaleLogEntity;
import csd214.app.entities.TireEntity;
import csd214.app.pojos.Tire;
import csd214.app.repositories.ProductRepository;
import csd214.app.repositories.SaleLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class handling core business logic, entity-to-POJO conversions,
 * price filtering, and sale processing.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final SaleLogRepository saleLogRepository;

    /**
     * Constructor injection for required repositories.
     *
     * @param productRepository repository for product persistence operations
     * @param saleLogRepository repository for sale log audit operations
     */
    @Autowired
    public ProductService(ProductRepository productRepository, SaleLogRepository saleLogRepository) {
        this.productRepository = productRepository;
        this.saleLogRepository = saleLogRepository;
    }

    /**
     * Saves or updates a product entity in the database.
     *
     * @param product the product entity to persist
     * @return saved product entity
     */
    public ProductEntity saveProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    /**
     * Retrieves all product entities stored in the database.
     *
     * @return list of all product entities
     */
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Finds a product entity by its primary key database ID.
     *
     * @param id primary key ID
     * @return Optional containing the found product entity
     */
    public Optional<ProductEntity> getProductById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * Finds a product entity by its custom UUID string.
     *
     * @param productId business UUID string identifier
     * @return Optional containing the found product entity
     */
    public Optional<ProductEntity> getProductByProductId(String productId) {
        return productRepository.findByProductId(productId);
    }

    /**
     * Deletes a product entity by its primary key ID.
     *
     * @param id primary key ID to remove
     */
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    /**
     * Retrieves products with a price lower than the specified threshold.
     *
     * @param price maximum price limit
     * @return list of products below the threshold
     */
    public List<ProductEntity> getProductsCheaperThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }

    /**
     * Retrieves products within a specific price range.
     *
     * @param min lower boundary price
     * @param max upper boundary price
     * @return list of products within the price range
     */
    public List<ProductEntity> getProductsByPriceRange(double min, double max) {
        return productRepository.findByPriceBetween(min, max);
    }

    /**
     * Converts a list of ProductEntity objects to a list of domain Tire POJOs.
     * Leverages Tire.fromEntity factory method for conversion.
     *
     * @param entities list of product entities to convert
     * @return list of mapped Tire POJOs
     */
    public List<Tire> convertAllToPojos(List<ProductEntity> entities) {
        List<Tire> tirePojos = new ArrayList<>();
        if (entities == null) {
            return tirePojos;
        }

        for (ProductEntity entity : entities) {
            if (entity instanceof TireEntity tireEntity) {
                // Uses the static factory method defined in Tire.java
                tirePojos.add(Tire.fromEntity(tireEntity));
            }
        }
        return tirePojos;
    }

    /**
     * Processes a product sale by product ID string and logs the sale transaction.
     * Uses SaleLogEntity parameterized constructor to set productId, price, and timestamp.
     *
     * @param productId business UUID string of the item sold
     * @return true if product was found and sale processed, false otherwise
     */
    public boolean processSale(String productId) {
        Optional<ProductEntity> productOptional = productRepository.findByProductId(productId);

        if (productOptional.isPresent()) {
            ProductEntity product = productOptional.get();

            // Create and persist a new sale audit log using SaleLogEntity constructor
            SaleLogEntity saleLog = new SaleLogEntity(product.getProductId(), product.getPrice());

            saleLogRepository.save(saleLog);
            return true;
        }
        return false;
    }

    /**
     * Retrieves all recorded audit sale logs from the database.
     *
     * @return list of all SaleLogEntity records
     */
    public List<SaleLogEntity> getAllSaleLogs() {
        return saleLogRepository.findAll();
    }
}