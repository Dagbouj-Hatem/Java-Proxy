package Proxy.si_ent_2;

public class FactureProxy implements Proxy.si_ent_2.Facture {
  private String _endpoint = null;
  private Proxy.si_ent_2.Facture facture = null;
  
  public FactureProxy() {
    _initFactureProxy();
  }
  
  public FactureProxy(String endpoint) {
    _endpoint = endpoint;
    _initFactureProxy();
  }
  
  private void _initFactureProxy() {
    try {
      facture = (new Proxy.si_ent_2.FactureWSLocator()).getFacturePort();
      if (facture != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)facture)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)facture)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (facture != null)
      ((javax.xml.rpc.Stub)facture)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public Proxy.si_ent_2.Facture getFacture() {
    if (facture == null)
      _initFactureProxy();
    return facture;
  }
  
  public java.lang.String findFacture(int code) throws java.rmi.RemoteException{
    if (facture == null)
      _initFactureProxy();
    return facture.findFacture(code);
  }
  
  public java.lang.String afficher() throws java.rmi.RemoteException{
    if (facture == null)
      _initFactureProxy();
    return facture.afficher();
  }
  
  public boolean updateFacture(int arg0, int arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (facture == null)
      _initFactureProxy();
    return facture.updateFacture(arg0, arg1, arg2);
  }
  
  public boolean deleteFacture(int arg0) throws java.rmi.RemoteException{
    if (facture == null)
      _initFactureProxy();
    return facture.deleteFacture(arg0);
  }
  
  public boolean addFacture(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException{
    if (facture == null)
      _initFactureProxy();
    return facture.addFacture(arg0, arg1, arg2, arg3, arg4);
  }
  
  
}