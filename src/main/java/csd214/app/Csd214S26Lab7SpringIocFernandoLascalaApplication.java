package csd214.app;

import csd214.app.entities.ProductEntity;
import csd214.app.entities.SaleLogEntity;
import csd214.app.entities.TireEntity;
import csd214.app.pojos.Tire;
import csd214.app.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "csd214.app.repositories")
public class Csd214S26Lab7SpringIocFernandoLascalaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Csd214S26Lab7SpringIocFernandoLascalaApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(ProductService productService) {
		return args -> {
			System.out.println("\n========== STARTING SPRING IOC & DATA LAB DEMO ==========\n");

			// 1. Create and save sample products (Tires) into the database
			System.out.println("--- 1. Inserting Sample Products into Database ---");
			TireEntity tire1 = new TireEntity("Michelin", 150.00, 17);
			TireEntity tire2 = new TireEntity("Bridgestone", 220.00, 18);
			TireEntity tire3 = new TireEntity("Goodyear", 89.99, 15);

			productService.saveProduct(tire1);
			productService.saveProduct(tire2);
			productService.saveProduct(tire3);

			// Display all persisted products
			List<ProductEntity> allProducts = productService.getAllProducts();
			System.out.println("Total products in database: " + allProducts.size());
			allProducts.forEach(product -> System.out.println("  Saved: " + product));

			// 2. Test derived query methods (price filters)
			System.out.println("\n--- 2. Testing Derived Query Methods ---");

			double thresholdPrice = 100.00;
			System.out.println("Products cheaper than $" + thresholdPrice + ":");
			List<ProductEntity> cheapProducts = productService.getProductsCheaperThan(thresholdPrice);
			cheapProducts.forEach(p -> System.out.println("  Found: " + p));

			System.out.println("\nProducts priced between $100.00 and $200.00:");
			List<ProductEntity> midRangeProducts = productService.getProductsByPriceRange(100.00, 200.00);
			midRangeProducts.forEach(p -> System.out.println("  Found: " + p));

			// 3. Convert entities to domain POJOs
			System.out.println("\n--- 3. Testing Entity to POJO Conversion ---");
			List<Tire> tirePojos = productService.convertAllToPojos(allProducts);
			System.out.println("Converted " + tirePojos.size() + " entities to domain POJOs:");
			tirePojos.forEach(pojo -> System.out.println("  POJO: " + pojo));

			// 4. Process a sale transaction and create audit log
			System.out.println("\n--- 4. Processing Sale Transaction & Audit Logging ---");
			String targetProductId = tire1.getProductId(); // Product ID of Michelin tire
			System.out.println("Attempting sale for product ID: " + targetProductId);

			boolean saleSuccess = productService.processSale(targetProductId);
			if (saleSuccess) {
				System.out.println("Sale successfully processed!");
			} else {
				System.out.println("Sale failed! Product not found.");
			}

			// Display generated audit logs
			System.out.println("\nCurrent Audit Sale Logs in Database:");
			List<SaleLogEntity> logs = productService.getAllSaleLogs();
			logs.forEach(log -> System.out.println("  Log Entry: " + log));

			System.out.println("\n========== LAB DEMO COMPLETED SUCCESSFULLY ==========\n");
		};
	}
}