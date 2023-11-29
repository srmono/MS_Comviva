An example of a Hibernate entity class with comprehensive annotations, and each annotation is described in comments:

```java
@Entity
@Table(name = "books") // Specifies the name of the database table associated with the entity.
public class Book {

    @Id // Marks the field as the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures the strategy for generating primary key values.
    @Column(name = "book_id") // Specifies the mapping of the field to a column in the database.
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "isbn", unique = true, length = 13)
    private String isbn;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne // Defines a many-to-one relationship with the Author entity.
    @JoinColumn(name = "author_id", referencedColumnName = "author_id") // Specifies the join column for the relationship.
    private Author author;

    @ManyToMany // Defines a many-to-many relationship with the Category entity.
    @JoinTable(
        name = "book_category", // Specifies the name of the join table.
        joinColumns = @JoinColumn(name = "book_id"), // Specifies the join columns.
        inverseJoinColumns = @JoinColumn(name = "category_id") // Specifies the inverse join columns.
    )
    private Set<Category> categories = new HashSet<>();

    // Constructors, getters, and setters

    // Additional methods, business logic, and custom queries

    @PrePersist // Executed before the entity is persisted to the database.
    public void prePersist() {
        // Perform actions before the entity is persisted.
    }

    @PreUpdate // Executed before the entity is updated in the database.
    public void preUpdate() {
        // Perform actions before the entity is updated.
    }

    @PostLoad // Executed after the entity is loaded from the database.
    public void postLoad() {
        // Perform actions after the entity is loaded from the database.
    }
}
```

In this annotated entity class:

- Each annotation is described in comments, explaining its purpose and usage.
- The `@Entity` and `@Table` annotations define the entity and specify the associated database table.
- The `@Id` and `@GeneratedValue` annotations declare the primary key and its generation strategy.
- `@Column` annotations define the mapping of fields to columns with additional attributes.
- Relationships with other entities are established using `@ManyToOne` and `@ManyToMany` annotations, along with `@JoinColumn` and `@JoinTable` annotations for customization.
- Lifecycle callbacks are implemented using `@PrePersist`, `@PreUpdate`, and `@PostLoad` annotations.
- Additional methods, business logic, and custom queries can be added to the entity as needed.

These comments provide a clear understanding of how to use Hibernate annotations for advanced entity mapping and behavior customization.