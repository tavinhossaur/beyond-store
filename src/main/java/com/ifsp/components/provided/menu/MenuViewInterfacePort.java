package com.ifsp.components.provided.menu;

import java.util.List;

import com.ifsp.components.internal.MenuView;
import com.ifsp.components.provided.boilerplate.InterfacePort;
import com.ifsp.components.required.boilerplate.StandardPortOutbox;
import com.ifsp.components.required.menu.MenuViewStandardPortOutbox;

public class MenuViewInterfacePort extends InterfacePort implements ProvidedMenuViewInterface {

   private MenuView menuInternalElement;

   public MenuViewInterfacePort(String portId) {
      this.id = portId;
      this.initialize();
   }

   @Override
   public void initialize() {
      this.outbox = new MenuViewStandardPortOutbox();
   }

   @Override
   public void connect(InterfacePort statisticsInterfacePort) {
      StandardPortOutbox outbox = (StandardPortOutbox) this.getOutbox();
      outbox.connect(statisticsInterfacePort);
   }
   
   public void setMenuInternalReference(MenuView menu) {
      this.menuInternalElement = menu;
   }

   @Override
   public List<String> getSalesStatisticsMenuOptions() {
      return this.menuInternalElement.getSalesStatisticsMenuOptions();
   }

   @Override
   public List<String> getCustomerMenuOptions() {
      return this.menuInternalElement.getCustomerMenuOptions();
   }

   @Override
   public List<String> getProductMenuOptions() {
      return this.menuInternalElement.getProductMenuOptions();
   }

   @Override
   public double doStatisticOperation(String operation, List<Double> arg) throws RuntimeException {
      return this.menuInternalElement.doStatisticOperation(operation, arg);
   }

   @Override
   public Object doCustomerOperation(String operation, String arg) throws RuntimeException {
      return this.menuInternalElement.doCustomerOperation(operation, arg);
   }

   @Override
   public Object doProductOperation(String operation, String arg) throws RuntimeException {
      return this.menuInternalElement.doProductOperation(operation, arg);
   }

}
