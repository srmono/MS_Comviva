# Commonly Used Spring Boot Annotations

Spring Boot leverages a wide range of annotations to simplify configuration, enhance functionality, and streamline the development of Spring-based applications. Below are some commonly used Spring Boot annotations with descriptions and examples:

## `@SpringBootApplication`

- **Description**: Marks the main class of a Spring Boot application. It combines three annotations: `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`. It auto-configures the application, scans for components, and provides the starting point for the Spring context.

- **Example**:
   ```java
   @SpringBootApplication
   public class MyApplication {
       public static void main(String[] args) {
           SpringApplication.run(MyApplication.class, args);
       }
   }
   ```

## `@Controller`

- **Description**: Identifies a class as a Spring MVC controller, allowing it to handle incoming HTTP requests. It combines the `@Component` annotation, making it a Spring-managed bean.

- **Example**:
   ```java
   @Controller
   public class MyController {
       // Controller methods
   }
   ```

## `@RestController`

- **Description**: Similar to `@Controller`, but specifically designed for RESTful web services. It automatically serializes and deserializes data in response to HTTP requests.

- **Example**:
   ```java
   @RestController
   public class MyRestController {
       // RESTful API endpoints
   }
   ```

## `@RequestMapping`

- **Description**: Maps HTTP requests to methods in controllers. It specifies the URL path, HTTP method, and other attributes for routing requests to specific handler methods.

- **Example**:
   ```java
   @RequestMapping("/api")
   public class MyController {
       @GetMapping("/hello")
       public String sayHello() {
           return "Hello, World!";
       }
   }
   ```

## `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`

- **Description**: Specialized variants of `@RequestMapping` for specific HTTP methods. They simplify mapping of GET, POST, PUT, and DELETE requests, respectively.

- **Example**:
   ```java
   @RestController
   public class MyRestController {
       @GetMapping("/resource")
       public Resource getResource() {
           // Get a resource
       }
   }
   ```

## `@PathVariable`

- **Description**: Binds a method parameter to a URI template variable, allowing you to extract values from the URL.

- **Example**:
   ```java
   @GetMapping("/books/{id}")
   public ResponseEntity<Book> getBookById(@PathVariable Long id) {
       // Retrieve book by ID
   }
   ```

## `@RequestParam`

- **Description**: Binds a method parameter to a query parameter in an HTTP request. It's useful for extracting request parameters from the URL.

- **Example**:
   ```java
   @GetMapping("/search")
   public List<Book> searchBooks(@RequestParam String query) {
       // Search for books based on the query
   }
   ```

## `@Autowired`

- **Description**: Used for automatic dependency injection. It injects Spring-managed beans into other beans.

- **Example**:
   ```java
   @Service
   public class MyService {
       private final MyRepository repository;
   
       @Autowired
       public MyService(MyRepository repository) {
           this.repository = repository;
       }
   }
   ```

## `@Configuration`

- **Description**: Indicates that a class provides Spring configuration. It's often used with `@Bean` methods to define beans.

- **Example**:
   ```java
   @Configuration
   public class MyConfiguration {
       @Bean
       public MyBean myBean() {
           return new MyBean();
       }
   }
   ```

## `@Component`

- **Description**: Marks a class as a Spring component, making it a candidate for Spring's component scanning.

- **Example**:
   ```java
   @Component
   public class MyComponent {
       // Component class
   }
   ```

## `@Service`

- **Description**: Indicates that a class is a service bean. It is typically used for business logic.

- **Example**:
   ```java
   @Service
   public class MyService {
       // Service methods
   }
   ```

## `@Repository`

- **Description**: Marks a class as a data access repository, typically for database interaction.

- **Example**:
   ```java
   @Repository
   public class MyRepository {
       // Data access methods
   }
   ```

## `@EnableAutoConfiguration`

- **Description**: Enables Spring Boot's auto-configuration feature, which automatically configures the application based on the classpath and dependencies.

- **Example**:
   ```java
   @SpringBootApplication
   @EnableAutoConfiguration
   public class MyApplication {
       // Main application class
   }
   ```

These are just a few of the many annotations available in Spring Boot for various tasks such as defining beans, configuring routing, handling requests, and more. Using these annotations simplifies the development of Spring Boot applications and makes them more concise and expressive.
```
