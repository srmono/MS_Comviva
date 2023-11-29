How to use environment variables in a Spring Boot application with an example:

# Using Environment Variables in a Spring Boot Application

Environment variables provide a flexible way to configure your Spring Boot application without hardcoding values. Spring Boot makes it easy to access environment variables in your application's configuration. Here's how you can use environment variables with a practical example:

## 1. Define Environment Variables

Before using environment variables, set them up according to your needs. You can define environment variables in your local development environment or within your deployment environment.

## 2. Access Environment Variables in Spring Boot

Spring Boot provides a straightforward way to access environment variables in your application.

### Using `@Value` Annotation

- **Description**: You can use the `@Value` annotation to inject values from environment variables into Spring beans.

- **Example**:
   ```java
   @Service
   public class MyService {
       @Value("${myapp.api.key}")
       private String apiKey;

       public String getApiKey() {
           return apiKey;
       }
   }
   ```

### Using `Environment` Bean

- **Description**: You can inject the `Environment` bean and use its `getProperty` method to access environment variables.

- **Example**:
   ```java
   @Service
   public class MyService {
       @Autowired
       private Environment environment;

       public String getApiKey() {
           return environment.getProperty("myapp.api.key");
       }
   }
   ```

### Using `application.properties` or `application.yml`

- **Description**: You can define environment variables in your `application.properties` or `application.yml` file.

- **Example**:
   ```yaml
   myapp.api.key: ${MYAPP_API_KEY}
   ```

## 3. Setting Environment Variables

### In Local Development

In your local development environment, you can set environment variables through your operating system, development IDE, or using a tool like `.env` files.

For example, in Linux or macOS, you can set an environment variable using the `export` command:
   ```shell
   export MYAPP_API_KEY=your_api_key_here
   ```

### In Deployment Environments

In deployment environments (e.g., cloud platforms or container orchestrators), you can configure environment variables through platform-specific methods or deployment scripts.

## 4. Use Environment Variables in Your Application

Now that you've configured environment variables and accessed them in your Spring Boot application, you can use these values to configure your application dynamically.

- **Example**: Using the `MyService` class from the previous examples, you can access the API key in your application and make API requests.

   ```java
   @RestController
   public class MyController {
       @Autowired
       private MyService myService;

       @GetMapping("/data")
       public String fetchData() {
           String apiKey = myService.getApiKey();
           // Use the apiKey to make API requests
           return "Data fetched using API key: " + apiKey;
       }
   }
   ```

By using environment variables, your Spring Boot application can be easily configured for different environments without modifying code.
```