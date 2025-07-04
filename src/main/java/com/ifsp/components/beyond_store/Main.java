package com.ifsp.components.beyond_store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.ifsp.tavinho.beyond_boilerplate.provided.ComponentInterface;

import com.ifsp.sleep.menu_view_component.provided.MenuViewInterface;
import com.ifsp.sleep.menu_view_component.provided.MenuViewInterfacePort;
import com.ifsp.luan.sales_statistics_component.provided.sales.SalesStatisticsInterface;
import com.ifsp.tavinho.customer_manager_component.provided.customer.CustomerManagerInterface;
import com.ifsp.yuri.product_catalog_component.provided.product.ProductCatalogInterface;

@SuppressWarnings("unchecked")
public class Main {

    private static MenuViewInterface menuView;
    private static SalesStatisticsInterface salesStatistics;
    private static CustomerManagerInterface customerManager;
    private static ProductCatalogInterface productCatalog;

    public static void main(String[] args) {
        menuView = new MenuViewInterface();
        salesStatistics = new SalesStatisticsInterface();
        customerManager = new CustomerManagerInterface();
        productCatalog = new ProductCatalogInterface();

        mainMenu();

        menuView.disconnect("port.menu");
    }

    private static void mainMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= MAIN MENU =========");
            System.out.println("Choose the module you want to access:");
            System.out.println("1 - Customers");
            System.out.println("2 - Products");
            System.out.println("3 - Sales");
            System.out.println("0 - Exit");
            System.out.print("Option: ");

            String option = scanner.nextLine().trim().toLowerCase();
            switch (option) {
                case "1": customersMenu(customerManager, scanner);
                    break;
                case "2": productsMenu(productCatalog, scanner);
                    break;
                case "3": salesMenu(salesStatistics, scanner);
                    break;
                case "0": endProgram(scanner); return;
                default: System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void customersMenu(CustomerManagerInterface customerManager, Scanner scanner) {
        MenuViewInterfacePort menuPort = switchConnection(customerManager, "customer");

        while (true) {
            System.out.println("\n--- CUSTOMERS MODULE ---");
            printMenuOptions(menuPort.getCustomerMenuOptions());
            System.out.print("Option: ");

            String option = scanner.nextLine().trim().toLowerCase();

            switch (option) {
                case "1":
                    System.out.print("Enter the customer name: ");

                    String name = scanner.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty!");
                        break;
                    }

                    menuPort.doCustomerOperation("add", name);
                    System.out.println("Customer added successfully!");

                    break;
                case "2":
                    Object customers = menuPort.doCustomerOperation("list", null);

                    if (customers instanceof List && ((List<?>) customers).isEmpty()) System.out.println("No customer registered.");
                    else System.out.println("Customers registered:\n" + String.join("\n", (List<String>) customers));
                    
                    break;
                case "3":
                    System.out.println("Total customers registered: " + menuPort.doCustomerOperation("count", null));
                    break;
                case "0":
                    menuView.disconnect("port.menu");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void productsMenu(ProductCatalogInterface productCatalog, Scanner scanner) {
        MenuViewInterfacePort menuPort = switchConnection(productCatalog, "product");
        
        while (true) {
            System.out.println("\n--- PRODUCTS MODULE ---");
            printMenuOptions(menuPort.getProductMenuOptions());
            System.out.print("Option: ");

            String option = scanner.nextLine().trim().toLowerCase();

            switch (option) {
                case "1":
                    System.out.print("Enter the product name: ");

                    String product = scanner.nextLine().trim();

                    if (product.isEmpty()) {
                        System.out.println("Name cannot be empty!");
                        break;
                    }

                    menuPort.doProductOperation("add", product);
                    System.out.println("Product added successfully!");

                    break;
                case "2":
                    Object products = menuPort.doProductOperation("list", null);

                    if (products instanceof List && ((List<?>) products).isEmpty()) System.out.println("No product registered.");
                    else System.out.println("Products registered:\n" + String.join("\n", (List<String>) products));

                    break;
                case "3":
                    System.out.print("Enter the product name to search: ");

                    String queryName = scanner.nextLine().trim();
                    String result = (String) menuPort.doProductOperation("find", queryName);

                    if (result != null) System.out.println("Product found: " + result);
                    else System.out.println("Product not found.");

                    break;
                case "0":
                    menuView.disconnect("port.menu");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void salesMenu(SalesStatisticsInterface salesStatistics, Scanner scanner) {
        MenuViewInterfacePort menuPort = switchConnection(salesStatistics, "sales");

        while (true) {
            String input = "";

            System.out.println("\n--- SALES STATISTICS MODULE ---");
            System.out.println("Enter the list of sales values (separated by space or comma) or 'return' to return to the main menu:");
            System.out.println("example: 100, 200, 300 or 100 200 300");

            input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("return")) {
                menuView.disconnect("port.menu");
                return;
            }
            
            List<Double> salesList = new ArrayList<>();
            try {
                salesList = Arrays.stream(input.replace(",", " ").split("\\s+")).filter(s -> !s.isBlank()).map(Double::parseDouble).collect(Collectors.toList());
            } catch (Exception e) {
                System.err.println("\nInvalid input. Enter only numbers separated by space or comma.");
                continue;
            }
            
            if (salesList.isEmpty()) {
                System.err.println("\nNo sales values entered. Please try again.");
                continue;
            }

            System.out.println();
            printMenuOptions(menuPort.getSalesStatisticsMenuOptions());
            System.out.print("Option: ");

            input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "1":
                    System.out.println("\nResult of total: " + menuPort.doStatisticOperation("total", salesList));
                    break;
                case "2":
                    System.out.println("\nResult of average: " + menuPort.doStatisticOperation("average", salesList));
                    break;
                case "3":
                    System.out.println("\nResult of max: " + menuPort.doStatisticOperation("max", salesList));
                    break;
                case "4":
                    System.out.println("\nResult of min: " + menuPort.doStatisticOperation("min", salesList));
                    break;
                case "0":
                    menuView.disconnect("port.menu");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void printMenuOptions(List<String> options) {
        options.forEach(option -> System.out.println(option));
    }
    
    private static MenuViewInterfacePort switchConnection(ComponentInterface component, String componentName) {
        menuView.connect(component.getPort("port." + componentName), "port.menu");
        return (MenuViewInterfacePort) menuView.getPort("port.menu");
    }

    private static void endProgram(Scanner scanner) {
        System.out.println("\nEnding the program...");
        scanner.close();
    }
}
