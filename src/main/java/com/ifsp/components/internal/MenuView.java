package com.ifsp.components.internal;

import java.util.List;

import com.ifsp.components.required.menu.MenuViewStandardPortOutbox;

public class MenuView {
    
    private MenuViewStandardPortOutbox outbox;

    public List<String> getSalesStatisticsMenuOptions() {
        return List.of(
            "1 - Total of sales", 
            "2 - Average of sales", 
            "3 - Highest sale",
            "4 - Lowest sale",
            "0 - Return to main menu"
        );
    }

    public List<String> getCustomerMenuOptions() {
        return List.of(
            "1 - Add customer",
            "2 - List customers",
            "3 - Count customers",
            "0 - Return to main menu"
        );
    }

    public List<String> getProductMenuOptions() {
        return List.of(
            "1 - Add product",
            "2 - List products",
            "3 - Find product by name",
            "0 - Return to main menu"
        );
    }

    public void setOutBox(MenuViewStandardPortOutbox standardOutbox) {
        this.outbox = standardOutbox;
    }

    public double doStatisticOperation(String operation, List<Double> arg) throws RuntimeException {
        if (arg == null || arg.isEmpty()) throw new RuntimeException("The sales list is empty.");
        
        if (operation.equals("total")) return this.outbox.total(arg);
        if (operation.equals("average")) return this.outbox.average(arg);
        if (operation.equals("max")) return this.outbox.max(arg);
        if (operation.equals("min")) return this.outbox.min(arg);

        throw new RuntimeException("No valid statistic found.");
    }

    public Object doCustomerOperation(String operation, String arg) throws RuntimeException {      
        if (operation.equals("add")) return this.outbox.addCustomer(arg);
        if (operation.equals("list")) return this.outbox.listCustomers();
        if (operation.equals("count")) return this.outbox.countCustomers();

        throw new RuntimeException("No valid customer operation found.");
    }

    public Object doProductOperation(String operation, String arg) throws RuntimeException {
        if (operation.equals("add")) return this.outbox.addProduct(arg);
        if (operation.equals("list")) return this.outbox.listProducts();
        if (operation.equals("find")) return this.outbox.findProductByName(arg);

        throw new RuntimeException("No valid product operation found.");
    }
    
}
