package com.ifsp.components.provided.customer;

import java.util.List;

public interface ProvidedCustomerManagerInterface {
    String addCustomer(String name);
    List<String> listCustomers();
    int countCustomers();
} 