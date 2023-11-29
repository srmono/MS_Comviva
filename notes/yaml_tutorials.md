# YAML Syntax Tutorial

YAML (YAML Ain't Markup Language) is a human-readable data serialization format. It is often used for configuration files, data exchange, and defining structured data. YAML uses indentation and colons to represent data structures. Here's a tutorial on YAML syntax, covering both the basics and some advanced features:

## Basics

### 1. Key-Value Pairs

YAML uses a simple key-value pair structure:

```yaml
key: value
```

- Keys are followed by a colon.
- Values can be strings, numbers, or other data types.

### 2. Indentation

Indentation is used to define the hierarchy and structure of data. Use spaces (preferably 2 or 4) for indentation. Do not use tabs.

```yaml
parent:
  child1: value1
  child2: value2
```

### 3. Data Types

YAML supports various data types:

- **Strings**: Plain text, quotes not required unless they contain special characters.
  ```yaml
  name: John Doe
  description: "A string with spaces and special characters: @#$%^&*"
  ```

- **Numbers**: Integers or floats.
  ```yaml
  age: 30
  pi: 3.14159
  ```

- **Booleans**: `true` or `false`.
  ```yaml
  is_active: true
  is_student: false
  ```

- **Lists**: Represented using hyphens.
  ```yaml
  fruits:
    - apple
    - banana
    - cherry
  ```

- **Dictionaries (Nested Structures)**: Nest data structures.
  ```yaml
  person:
    name: Alice
    age: 25
    address:
      city: Wonderland
      postal_code: 12345
  ```

### 4. Comments

Comments start with the `#` symbol and are for documentation:

```yaml
# This is a comment
key: value
```

### 5. Multiline Strings

Use `|` or `>` for multiline strings:

```yaml
description: |
  This is a multiline string.
  It preserves line breaks.

note: >
  This is also a multiline string,
  but it's folded into a single line.
```

## Advanced Features

### 1. Custom Data Types

Define custom data types using tags:

```yaml
birth_date: !!timestamp '1990-01-15'
```

### 2. Multiple Documents

YAML files can contain multiple documents separated by `---`:

```yaml
# Document 1
name: John
age: 30

---
# Document 2
fruits:
  - apple
  - banana
  - cherry
```

### 3. References

Use `&` to create an anchor and `*` to create an alias for referencing data:

```yaml
# Anchor
default_settings: &settings
  key1: value1
  key2: value2

# Alias
config:
  <<: *settings
  key3: value3
```

### 4. Folded Style

Represent multiline strings using the folded style `>`:

```yaml
description: >
  This is a multiline string.
  It preserves line breaks.
```

### 5. Inline Lists and Dictionaries

Represent simple lists and dictionaries in a compact format using `[ ]` and `{ }`:

```yaml
fruits: [apple, banana, cherry]
person: {name: Alice, age: 25}
```

### 6. Mapping of Scalars

Create a mapping of scalar values using the `=` sign:

```yaml
settings: !<tag:yaml.org,2002:map>
  key1 = value1
  key2 = value2
```

Please note that these advanced features may not be supported by all YAML parsers, and their usage should be in accordance with the specific YAML specification and the parser you are using. YAML's flexibility makes it a versatile format for various applications, but it's important to be aware of potential compatibility issues when using advanced features.

---