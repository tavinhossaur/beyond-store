package com.ifsp.components.beyond_store.provided.sales;

import java.util.List;

import com.ifsp.components.beyond_store.internal.SalesStatistics;

import com.ifsp.tavinho.beyond_boilerplate.provided.InterfacePort;

public class SalesStatisticsInterfacePort extends InterfacePort implements ProvidedSalesStatistics {

    private SalesStatistics statistics;

    public SalesStatisticsInterfacePort(String portId) {
        this.id = portId;
        this.initialize();
    }

    public void setInternalReference(SalesStatistics statisticsOperationsInternal) {
        this.statistics = statisticsOperationsInternal;
    }

    @Override
    public void initialize() { } // There are no outbox ports.

    @Override
    public double total(List<Double> sales) {
        return this.statistics.total(sales);
    }

    @Override
    public double average(List<Double> sales) {
        return this.statistics.average(sales);
    }

    @Override
    public double max(List<Double> sales) {
        return this.statistics.max(sales);
    }

    @Override
    public double min(List<Double> sales) {
        return this.statistics.min(sales);
    }

}
