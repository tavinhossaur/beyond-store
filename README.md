# Beyond Store

Beyond Store is a modular store management system written in Java, designed to integrate multiple external components for customer management, product catalog, sales statistics, and menu navigation. The project leverages a component-based architecture, making it easy to extend and maintain.

## Features

- **Customer Management**: Add, list, and count customers.
- **Product Catalog**: Add, list, and search for products.
- **Sales Statistics**: Calculate total, average, maximum, and minimum sales values.

## Project Structure

```bash
beyond-store/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── ifsp/
│   │               └── components/
│   │                   └── beyond_store/
│   │                       └── Main.java
│   └── test/
│       └── java/
│           └── com/
│               └── ifsp/
│                   └── components/
│                       └── beyond_store/
│                           └── MainTest.java
```

## Requirements

- Java 17 or higher
- Maven

## Installation & Running

1. **Clone the repository:**

   ```sh
   git clone <repository-url>
   cd beyond-store
   ```

2. **Compile the project:**

   ```sh
   mvn clean compile
   ```

3. **Run the application:**
   Ensure the `exec-maven-plugin` is configured in your `pom.xml`. Then run:

   ```sh
   mvn exec:java -Dexec.mainClass="com.ifsp.components.beyond_store.Main"
   ```

## Main Dependencies

- [beyond-boilerplate](https://github.com/tavinhossaur/beyond-boilerplate)
- [customer-manager-component](https://github.com/tavinhossaur/customer-manager-component)
- [sales_statistics_component](https://github.com/Tavaress17/sales_statistics_component)
- [product_catalog_component](https://github.com/Yuri-DNS/product_catalog_component)
- [menu_view_component](https://github.com/StringKaori/menu_view_component)

All dependencies are fetched from GitHub Packages as specified in the `pom.xml`.

## Usage

Upon running, you will be presented with a CLI menu to choose between Customers, Products, and Sales modules. Each module provides its own set of operations, such as adding or listing entries, or calculating statistics.
