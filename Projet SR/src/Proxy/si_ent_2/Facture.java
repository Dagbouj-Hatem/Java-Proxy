/**
 * Facture.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Proxy.si_ent_2;

public interface Facture extends java.rmi.Remote {
    public java.lang.String findFacture(int code) throws java.rmi.RemoteException;
    public java.lang.String afficher() throws java.rmi.RemoteException;
    public boolean updateFacture(int arg0, int arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public boolean deleteFacture(int arg0) throws java.rmi.RemoteException;
    public boolean addFacture(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException;
}
