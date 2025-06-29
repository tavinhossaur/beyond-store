package com.ifsp.components.beyond_store.provided.product;

import com.ifsp.components.beyond_store.internal.ProductCatalog;

import com.ifsp.tavinho.beyond_boilerplate.provided.ComponentInterface;

public class ProductCatalogInterface extends ComponentInterface {
    
    protected ProductCatalog productCatalog;

    public ProductCatalogInterface() {
        this.initialize();
    }

    @Override
    public void initialize() {
        this.id = "interface.product";

        ProductCatalogInterfacePort productPort = new ProductCatalogInterfacePort("port.product");
        this.ports.add(productPort);

        ProductCatalog productCatalog = new ProductCatalog();
        productPort.setProductCatalogReference(productCatalog);
    }

} 