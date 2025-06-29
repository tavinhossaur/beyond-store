package com.ifsp.components.provided.sales;

import java.util.List;

public interface ProvidedSalesStatistics {
    double total(List<Double> sales);
    double average(List<Double> sales);
    double max(List<Double> sales);
    double min(List<Double> sales);
}
