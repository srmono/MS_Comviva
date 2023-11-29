Using the `WebClient` in a Spring Boot application allows you to make HTTP requests to external services or APIs in a non-blocking and reactive way. Below, I'll provide an example of how to use the `WebClient` to make a simple GET request and retrieve data from an external service. I'll also provide the example in a Markdown format for easy reference:

---

# Using WebClient in Spring Boot

## Dependency Configuration

Ensure you have the necessary dependencies in your `pom.xml` (if using Maven) or `build.gradle` (if using Gradle):

```xml
<!-- Spring WebFlux for WebClient -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
```

## Using WebClient

1. **Create a Spring Boot Service:**

   Create a Spring Boot service (e.g., `WebClientService`) where you'll use the `WebClient` to make HTTP requests. You can use this service in your application.

   ```java
   import org.springframework.stereotype.Service;
   import org.springframework.web.reactive.function.client.WebClient;
   import reactor.core.publisher.Mono;

   @Service
   public class WebClientService {
       private final WebClient webClient;

       public WebClientService(WebClient.Builder webClientBuilder) {
           this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
       }

       public Mono<String> fetchData() {
           return webClient.get()
                   .uri("/todos/1")
                   .retrieve()
                   .bodyToMono(String.class);
       }
   }
   ```

2. **Usage in a Controller:**

   You can use the `WebClientService` in a controller to handle HTTP requests.

   ```java
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.web.bind.annotation.GetMapping;
   import org.springframework.web.bind.annotation.RestController;
   import reactor.core.publisher.Mono;

   @RestController
   public class WebController {

       private final WebClientService webClientService;

       @Autowired
       public WebController(WebClientService webClientService) {
           this.webClientService = webClientService;
       }

       @GetMapping("/fetch-data")
       public Mono<String> fetchData() {
           return webClientService.fetchData();
       }
   }
   ```

3. **Application Properties:**

   Make sure to configure the base URL of the external service in your `application.properties` or `application.yml` file:

   ```properties
   # application.properties
   spring.webflux.base-url=https://jsonplaceholder.typicode.com
   ```

   ```yaml
   # application.yml
   spring:
     webflux:
       base-url: https://jsonplaceholder.typicode.com
   ```

## Running the Application

With the above setup, you can run your Spring Boot application and access the `/fetch-data` endpoint. This endpoint will use the `WebClient` to make a GET request to the specified external service (in this case, JSONPlaceholder) and retrieve data from it.

Make sure to adapt the example to your specific use case, including customizing the base URL and handling the retrieved data as needed.

---