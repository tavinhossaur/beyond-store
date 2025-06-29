package com.ifsp.components.beyond_store.required.menu;

import java.util.List;

import com.ifsp.luan.sales_statistics_component.provided.sales.SalesStatisticsInterfacePort;
import com.ifsp.components.beyond_store.provided.product.ProductCatalogInterfacePort;
import com.ifsp.luan.sales_statistics_component.required.sales.RequiredSalesStatistics;
import com.ifsp.components.beyond_store.required.product.RequiredProductCatalog;

import com.ifsp.tavinho.beyond_boilerplate.required.StandardPortOutbox;

import com.ifsp.tavinho.customer_manager_component.provided.customer.CustomerManagerInterfacePort;
import com.ifsp.tavinho.customer_manager_component.required.customer.RequiredCustomerManager;

public class MenuViewStandardPortOutbox extends StandardPortOutbox implements RequiredSalesStatistics, RequiredCustomerManager, RequiredProductCatalog {

    @Override
    public double total(List<Double> sales) {
        return ((SalesStatisticsInterfacePort) this.externalPort).total(sales);
    }

    @Override
    public double average(List<Double> sales) {
        return ((SalesStatisticsInterfacePort) this.externalPort).average(sales);
    }

    @Override
    public double max(List<Double> sales) {
        return ((SalesStatisticsInterfacePort) this.externalPort).max(sales);
    }

    @Override
    public double min(List<Double> sales) {
        return ((SalesStatisticsInterfacePort) this.externalPort).min(sales);
    }

    @Override
    public String addCustomer(String name) {
        return ((CustomerManagerInterfacePort) this.externalPort).addCustomer(name);
    }

    @Override
    public List<String> listCustomers() {
        return ((CustomerManagerInterfacePort) this.externalPort).listCustomers();
    }

    @Override
    public int countCustomers() {
        return ((CustomerManagerInterfacePort) this.externalPort).countCustomers();
    }

    @Override
    public String addProduct(String name) {
        return ((ProductCatalogInterfacePort) this.externalPort).addProduct(name);
    }

    @Override
    public List<String> listProducts() {
        return ((ProductCatalogInterfacePort) this.externalPort).listProducts();
    }

    @Override
    public String findProductByName(String name) {
        return ((ProductCatalogInterfacePort) this.externalPort).findProductByName(name);
    }

}