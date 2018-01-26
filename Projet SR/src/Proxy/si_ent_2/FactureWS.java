/**
 * FactureWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Proxy.si_ent_2;

public interface FactureWS extends javax.xml.rpc.Service {
    public java.lang.String getFacturePortAddress();

    public Proxy.si_ent_2.Facture getFacturePort() throws javax.xml.rpc.ServiceException;

    public Proxy.si_ent_2.Facture getFacturePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
