package com.ifsp.components.beyond_store.required.product;

import java.util.List;

public interface RequiredProductCatalog {
    String addProduct(String name);
    List<String> listProducts();
    String findProductByName(String name);
} 