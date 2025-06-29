package com.ifsp.components.provided.sales;

import com.ifsp.components.internal.SalesStatistics;
import com.ifsp.components.provided.boilerplate.ComponentInterface;

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
