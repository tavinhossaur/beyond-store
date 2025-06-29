package com.ifsp.components.beyond_store.provided.menu;

import com.ifsp.components.beyond_store.internal.MenuView;
import com.ifsp.components.beyond_store.required.menu.MenuViewStandardPortOutbox;

import com.ifsp.tavinho.beyond_boilerplate.provided.ComponentInterface;

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
