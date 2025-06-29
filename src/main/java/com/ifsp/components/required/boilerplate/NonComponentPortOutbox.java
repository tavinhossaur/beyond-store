package com.ifsp.components.required.boilerplate;

public abstract class NonComponentPortOutbox extends PortOutbox {
    
    protected Object externalPort;

    public void connect(Object externalReference) { }
    
    public void disconnect() { }
    
}
