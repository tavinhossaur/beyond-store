package com.ifsp.components.provided.menu;

import java.util.List;

public interface ProvidedMenuViewInterface {
    public List<String> getSalesStatisticsMenuOptions();
    public List<String> getCustomerMenuOptions();
    public List<String> getProductMenuOptions();
    public double doStatisticOperation(String operation, List<Double> arg) throws RuntimeException;
    public Object doCustomerOperation(String operation, String arg) throws RuntimeException;
    public Object doProductOperation(String operation, String arg) throws RuntimeException;
}
