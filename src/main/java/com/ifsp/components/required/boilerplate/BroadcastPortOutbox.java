package com.ifsp.components.required.boilerplate;

import java.util.List;

import com.ifsp.components.provided.boilerplate.InterfacePort;

public abstract class BroadcastPortOutbox extends PortOutbox {

    protected List<InterfacePort> externalPorts;
    
    public void connect(InterfacePort externalPort) { }

    public void disconnect(InterfacePort externalPort) { }
    
    public void disconnect() { }
    
}
