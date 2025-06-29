package com.ifsp.components.beyond_store.internal;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    
    private List<String> products = new ArrayList<>();

    public String addProduct(String name) {
        products.add(name);
        return products.stream().filter(p -> p.equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public List<String> listProducts() {
        return new ArrayList<>(products);
    }

    public String findProductByName(String name) {
        return products.stream().filter(p -> p.equalsIgnoreCase(name)).findFirst().orElse(null);
    }

} 