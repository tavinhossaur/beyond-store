package com.ifsp.components.beyond_store.provided.sales;

import com.ifsp.components.beyond_store.internal.SalesStatistics;

import com.ifsp.tavinho.beyond_boilerplate.provided.ComponentInterface;

public class SalesStatisticsInterface extends ComponentInterface {
    
    protected SalesStatistics salesStatistics;

    public SalesStatisticsInterface() {
        this.initialize();
    }

    @Override
    public void initialize() {
        this.id = "interface.sales";

        SalesStatisticsInterfacePort statisticsPort = new SalesStatisticsInterfacePort("port.sales");
        this.ports.add(statisticsPort);

        this.salesStatistics = new SalesStatistics();
        statisticsPort.setInternalReference(this.salesStatistics);        
    }
    
}
