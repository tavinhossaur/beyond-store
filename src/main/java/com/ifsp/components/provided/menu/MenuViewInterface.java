package com.ifsp.components.provided.menu;

import com.ifsp.components.internal.MenuView;
import com.ifsp.components.provided.boilerplate.ComponentInterface;
import com.ifsp.components.required.menu.MenuViewStandardPortOutbox;

public class MenuViewInterface extends ComponentInterface {

    protected MenuView menuInternal;

    public MenuViewInterface() {
        this.initialize();
    }

    @Override
    public void initialize() {
        this.id = "interface.menu";

        MenuViewInterfacePort menuPort = new MenuViewInterfacePort("port.menu");

        this.ports.add(menuPort);

        MenuView menuInternal = new MenuView();

        menuPort.setMenuInternalReference(menuInternal);

        MenuViewStandardPortOutbox outbox = (MenuViewStandardPortOutbox) menuPort.getOutbox();

        menuInternal.setOutBox(outbox);
    }

}
