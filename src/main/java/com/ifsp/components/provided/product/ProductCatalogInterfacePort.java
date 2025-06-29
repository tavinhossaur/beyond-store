package com.ifsp.components.provided.product;

import java.util.List;

import com.ifsp.components.internal.ProductCatalog;
import com.ifsp.components.provided.boilerplate.InterfacePort;

public class ProductCatalogInterfacePort extends InterfacePort implements ProvidedProductCatalogInterface {

    private ProductCatalog catalog;

    public ProductCatalogInterfacePort(String portId) {
        this.id = portId;
        this.catalog = new ProductCatalog();
    }

    public void setProductCatalogReference(ProductCatalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void initialize() { } // There are no outbox ports.

    @Override
    public String addProduct(String name) {
        return this.catalog.addProduct(name);
    }

    @Override
    public List<String> listProducts() {
        return this.catalog.listProducts();
    }

    @Override
    public String findProductByName(String name) {
        return this.catalog.findProductByName(name);
    }

} 