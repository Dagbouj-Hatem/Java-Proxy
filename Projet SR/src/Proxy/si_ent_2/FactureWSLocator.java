/**
 * FactureWSLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Proxy.si_ent_2;

public class FactureWSLocator extends org.apache.axis.client.Service implements Proxy.si_ent_2.FactureWS {

    public FactureWSLocator() {
    }


    public FactureWSLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FactureWSLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FacturePort
    private java.lang.String FacturePort_address = "http://localhost:5000/";

    public java.lang.String getFacturePortAddress() {
        return FacturePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FacturePortWSDDServiceName = "FacturePort";

    public java.lang.String getFacturePortWSDDServiceName() {
        return FacturePortWSDDServiceName;
    }

    public void setFacturePortWSDDServiceName(java.lang.String name) {
        FacturePortWSDDServiceName = name;
    }

    public Proxy.si_ent_2.Facture getFacturePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FacturePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFacturePort(endpoint);
    }

    public Proxy.si_ent_2.Facture getFacturePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            Proxy.si_ent_2.FacturePortBindingStub _stub = new Proxy.si_ent_2.FacturePortBindingStub(portAddress, this);
            _stub.setPortName(getFacturePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFacturePortEndpointAddress(java.lang.String address) {
        FacturePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (Proxy.si_ent_2.Facture.class.isAssignableFrom(serviceEndpointInterface)) {
                Proxy.si_ent_2.FacturePortBindingStub _stub = new Proxy.si_ent_2.FacturePortBindingStub(new java.net.URL(FacturePort_address), this);
                _stub.setPortName(getFacturePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("FacturePort".equals(inputPortName)) {
            return getFacturePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://SI_Ent_2/", "FactureWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://SI_Ent_2/", "FacturePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FacturePort".equals(portName)) {
            setFacturePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
