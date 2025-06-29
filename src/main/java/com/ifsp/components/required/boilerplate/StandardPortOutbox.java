package com.ifsp.components.required.boilerplate;

import com.ifsp.components.provided.boilerplate.InterfacePort;

public abstract class StandardPortOutbox extends PortOutbox {

    protected InterfacePort externalPort;

    public void connect(InterfacePort externalPort){
        this.externalPort = externalPort;
    }
    
    public void disconnect(){
        this.externalPort = null;
    }
}
