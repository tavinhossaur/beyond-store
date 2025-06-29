package com.ifsp.components.required.customer;

import java.util.List;

public interface RequiredCustomerManager {
    String addCustomer(String name);
    List<String> listCustomers();
    int countCustomers();
} 