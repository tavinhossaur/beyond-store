package provided.product;

import internal.ProductCatalog;
import provided.boilerplate.ComponentInterface;

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