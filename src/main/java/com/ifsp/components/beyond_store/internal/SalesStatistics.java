package com.ifsp.components.beyond_store.internal;

import java.util.List;

public class SalesStatistics {

    public double total(List<Double> sales) {
        return sales.stream().mapToDouble(Double::doubleValue).sum();
    }

    public double average(List<Double> sales) {
        if (sales.isEmpty()) return 0.0;
        return sales.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public double max(List<Double> sales) {
        return sales.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
    }

    public double min(List<Double> sales) {
        return sales.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
    }
    
}
