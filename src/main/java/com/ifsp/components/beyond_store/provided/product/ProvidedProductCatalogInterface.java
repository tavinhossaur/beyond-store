package com.ifsp.components.beyond_store.provided.product;

import java.util.List;

public interface ProvidedProductCatalogInterface {
    String addProduct(String name);
    List<String> listProducts();
    String findProductByName(String name);
} 