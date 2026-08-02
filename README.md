# Part E: Reflection & Concepts

## Multiple-Choice Questions & Answers

### 1. What is the primary role of Inversion of Control (IoC) in Spring Boot?
* [ ] A. It allows the terminal user to reverse menu navigation at runtime.
* **[x] B. It delegates the responsibility of object creation, lifecycle management, and dependency wiring to the framework instead of the developer.**
* [ ] C. It dynamically converts SQL relational tables back into Java class inheritance structures.
* [ ] D. It automatically compiles Java bytecode into native machine code.

---

### 2. Which annotation is used to designate a class as a business logic component in Spring Boot's service layer?
* [ ] A. @Repository
* [ ] B. @Component
* **[x] C. @Service**
* [ ] D. @Configuration

---

### 3. How does Spring Data JPA execute a repository method like `List<ProductEntity> findByPriceLessThan(double price)` without any manual SQL implementation?
* [ ] A. It scans the database on startup and matches columns to local variable names.
* [ ] B. It relies on a local XML dictionary file that matches method names to raw SQL queries.
* **[x] C. It parses the method name at runtime using strict naming conventions and dynamically generates the target SQL query.**
* [ ] D. It requires the developer to compile the project using a native database dialect compiler.

---

### 4. What is the main purpose of implementing the `CommandLineRunner` interface in a Spring Boot application?
* [ ] A. To execute Java code sequentially before the Spring IoC container boots up.
* [ ] B. To compile external SQL scripts from the command line on application startup.
* **[x] C. To run custom application logic (such as a CLI loop) automatically as soon as the Spring ApplicationContext is fully initialized.**
* [ ] D. To prevent the application from closing when an unhandled runtime database exception is thrown.

---

### 5. Which property in the master `application.properties` file is used to specify that the local H2 profile (dev) should be active?
* [ ] A. spring.active.profile=dev
* **[x] B. spring.profiles.active=dev**
* [ ] C. spring.environment.active=dev
* [ ] D. spring.profiles.dev=active

---

### 6. What is the Spring "ApplicationContext"?
* [ ] A. The persistent database context configured in persistence.xml.
* [ ] B. The internal component that compiles .java source files to platform-independent bytecode.
* **[x] C. The container that instantiates, configures, assembles, and manages Spring Beans and their dependencies.**
* [ ] D. A local configuration file used to store database credentials securely.

---

### 7. What occurs if a database operation fails within a service method decorated with `@Transactional`?
* [ ] A. The console displays a warning, but other successful changes in the method are committed anyway.
* [ ] B. Spring Boot catches the exception, re-runs the failed statement, and attempts a second commit.
* [ ] C. The database engine locks up, requiring a system restart to release resource sockets.
* **[x] D. All database operations executed within that transactional boundary are rolled back completely, returning the database to its pre-transaction state.**

---

### 8. The `@SpringBootApplication` annotation is a meta-annotation that combines which three core annotations?
* **[x] A. @Configuration, @EnableAutoConfiguration, and @ComponentScan**
* [ ] B. @Service, @Repository, and @Controller
* [ ] C. @Id, @Entity, and @Table
* [ ] D. @Component, @Autowired, and @Transactional

---

### 9. What is the default path scanning behavior of Spring's `@ComponentScan`?
* [ ] A. It scans all classes inside the src/main directory regardless of package boundaries.
* **[x] B. It scans only the package where the main class containing the @SpringBootApplication annotation resides, as well as all of its sub-packages.**
* [ ] C. It scans only standard Java packages like java.util.* and java.io.* for configuration.
* [ ] D. It requires every package to be explicitly declared inside the persistence.xml file.

---

### 10. Why is Constructor Injection preferred over Field Injection (using `@Autowired` directly on fields) in modern Spring development?
* [ ] A. It makes the code execute faster because constructors compile to shorter bytecode instructions.
* **[x] B. It facilitates easier unit testing by allowing developers to inject mock dependencies directly through constructors without starting the entire Spring container.**
* [ ] C. It prevents the JVM from garbage collecting active database repository beans.
* [ ] D. It automatically deletes unreferenced database rows upon object destruction.

---

### 11. What is a strict structural requirement for any persistent class decorated with `@Entity` in Spring Data JPA?
* [ ] A. It must implement the CommandLineRunner interface.
* **[x] B. It must have a public or protected zero-argument (no-arg) constructor so Hibernate can instantiate it via reflection.**
* [ ] C. It must declare all fields as final to protect data integrity.
* [ ] D. It must inherit from the InMemoryMapRepository class.

---

### 12. What are the key characteristics of an H2 Database as used in the dev profile?
* [ ] A. It is a persistent SQL engine that writes tables directly to physical database servers on Port 3333.
* **[x] B. It is a transient, in-memory database that executes SQL operations inside the JVM's RAM and is completely wiped when the application stops.**
* [ ] C. It is a NoSQL key-value store that does not support JPQL or standard transactions.
* [ ] D. It is a secondary class-loading system used to secure database connections.

---

### 13. Why is it considered an anti-pattern (and violation of the Single Responsibility Principle) to put terminal Scanner inputs or System.out statements inside a database `@Entity` class?
* [ ] A. It dramatically increases the physical file size of the generated .jar file.
* [ ] B. It makes the entity class incompatible with MySQL, restricting it to only H2.
* **[x] C. It tightly couples database models to a console UI, preventing the reuse of those database tables if the app transitions to a Web interface later.**
* [ ] D. It causes Hibernate to automatically generate empty columns named scanner in the SQL database.

---

### 14. If you have defined three configuration files—`application.properties`, `application-dev.properties`, and `application-prod.properties`—what naming convention does Spring Boot look for when searching for a profile named `test`?
* [ ] A. application.test.properties
* [ ] B. properties-test.application
* **[x] C. application-test.properties**
* [ ] D. test-application.properties

---

### 15. What will happen during application startup if you omit the `@Service` annotation from `DiscountService`, but still declare it as a constructor dependency inside `BookstoreService`?
* [ ] A. Spring Boot will ignore the missing annotation and instantiate the service anyway using default settings.
* [ ] B. The program will compile successfully but crash with a NullPointerException as soon as the first discount method is invoked.
* **[x] C. Spring Boot's dependency injection phase will fail, throwing an Unsatisfied Dependency or NoSuchBeanDefinitionException and stopping the application.**
* [ ] D. Spring will automatically search Maven Central, download a compatible bean, and inject it.

---

### 16. Which of the following interface declarations correctly defines a Spring Data JPA Product Repository?
* [ ] A. public class ProductRepository extends JpaRepository<ProductEntity, Long> {}
* **[x] B. public interface ProductRepository extends JpaRepository<ProductEntity, Long> {}**
* [ ] C. public interface ProductRepository implements JpaRepository<ProductEntity, String> {}
* [ ] D. public class ProductRepository implements IRepository<ProductEntity> {}

---

### 17. In `application-dev.properties`, what does configuring the Hibernate property `spring.jpa.hibernate.ddl-auto=create-drop` do?
* [ ] A. It updates the database table schemas without deleting any existing data during boot.
* [ ] B. It automatically imports initial mock data using JavaFaker every 5 minutes.
* **[x] C. It drops the existing schema and creates a clean one on startup, then drops that schema again when the application is cleanly shut down.**
* [ ] D. It blocks database connections if a syntax error is detected in custom query methods.

---

### 18. What is a "Circular Dependency" in Spring Boot?
* [ ] A. A database performance bottleneck caused by executing too many nested JOIN operations.
* **[x] B. An error that occurs when Class A requires Class B, and Class B simultaneously requires Class A, causing Spring's bean creation loop to fail on startup.**
* [ ] C. A design pattern used to recursively update stock values in a single-table inheritance structure.
* [ ] D. The process of mapping an auto-incremented database key back to a UUID string.

---

### 19. How do JPQL (Java Persistence Query Language) queries differ from raw SQL queries?
* [ ] A. JPQL queries are executed on the client-side GPU, whereas SQL is executed on the database server.
* **[x] B. JPQL queries refer to Java Classes (Entities) and their properties, whereas native SQL queries refer directly to physical database tables and columns.**
* [ ] C. JPQL queries do not support the WHERE clause or parameter binding.
* [ ] D. JPQL queries are converted to bytecode, whereas SQL queries are kept as strings.

---

### 20. Which command-line argument can be used to run a compiled Spring Boot `.jar` file while overriding the active profile to `prod` without modifying any properties files?
* [ ] A. java -jar app.jar --prod
* **[x] B. java -Dspring.profiles.active=prod -jar app.jar**
* [ ] C. java -jar app.jar -profile prod
* [ ] D. java -jar app.jar --active-profile=prod

---

### 21. When extending `JpaRepository<T, ID>`, what do the generic type parameters `T` and `ID` represent?
* [ ] A. T represents the Type of the Connection, and ID represents the Transaction ID.
* [ ] B. T represents the database table name, and ID represents the driver type.
* **[x] C. T represents the target Entity class, and ID represents the Java data type of that Entity's primary key (@Id).**
* [ ] D. T represents the active Spring Profile, and ID represents the database Port.

---

### 22. In a clean, tiered architecture, what is the primary role of a DTO (Data Transfer Object) in comparison to an Entity?
* [ ] A. DTOs are mapped directly to SQL tables, while Entities handle console scanner inputs.
* **[x] B. DTOs isolate user inputs and validation logic from the database, preventing unvalidated terminal data from corrupting database-mapped Entities.**
* [ ] C. DTOs run on Port 3333, while Entities run inside volatile H2 memory.
* [ ] D. DTOs manage database transaction commits and rollbacks polymorphically.

---

### 23. What does Spring do when it encounters a constructor in `BookstoreService` that requires `ProductRepository`, `SaleLogRepository`, and `DiscountService`?
* [ ] A. It requires the developer to use the new keyword to create them first in Main.java.
* **[x] B. It automatically locates those three managed beans in its IoC container, instantiates them if necessary, and injects them into the constructor at runtime.**
* [ ] C. It throws an error unless all three classes implement the exact same custom interface.
* [ ] D. It automatically merges the three classes into a single multi-threaded background process.

---

### 24. Which JPA annotation is used to mark a specific field as the primary key of a database table?
* [ ] A. @GeneratedValue
* [ ] B. @Column
* **[x] C. @Id**
* [ ] D. @PrimaryKey

---

### 25. What is the main benefit of "Loose Coupling" achieved through Spring Boot's Dependency Injection?
* [ ] A. It makes compilation times significantly faster.
* [ ] B. It reduces the memory footprint of the running JVM.
* **[x] C. It allows you to modify or swap out one part of the system (like changing from H2 to MySQL, or mocking a service) without modifying other parts of the application.**
* [ ] D. It automatically secures all routes against cyberattacks.

