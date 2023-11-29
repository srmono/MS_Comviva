An advanced-level guide on using REST API annotations in a Spring Boot application, along with descriptions and examples. This guide covers the use of annotations like `@RestController`, `@RequestMapping`, `@PathVariable`, `@RequestBody`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`, and `@ResponseStatus`.

```java
@RestController // Marks the class as a RESTful controller.
@RequestMapping("/api/books") // Maps all requests under "/api/books" to this controller.
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping // Handles HTTP GET requests to retrieve a list of books.
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}") // Handles HTTP GET requests to retrieve a book by ID.
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping // Handles HTTP POST requests to create a new book.
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/{id}") // Handles HTTP PUT requests to update an existing book by ID.
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}") // Handles HTTP DELETE requests to delete a book by ID.
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        boolean deleted = bookService.deleteBook(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
```

In this advanced-level example:

- `@RestController` annotates the class to make it a RESTful controller, allowing it to handle HTTP requests.
- `@RequestMapping` is used to specify the base path for all the endpoint methods within the class.
- `@Autowired` injects the `BookService`, which provides business logic for handling books.

For each endpoint method:

- `@GetMapping` handles HTTP GET requests to retrieve a list of books and a book by ID.
- `@PostMapping` handles HTTP POST requests to create a new book.
- `@PutMapping` handles HTTP PUT requests to update an existing book by ID.
- `@DeleteMapping` handles HTTP DELETE requests to delete a book by ID.

- `@PathVariable` extracts values from the URL path.
- `@RequestBody` binds the request body to a parameter.

For response customization:

- `ResponseEntity` is used to return custom HTTP status codes and response bodies.
- `@ResponseStatus` specifies the HTTP status code to be returned.

This example demonstrates how to create a robust REST API with advanced-level annotations and response customization in a Spring Boot application.