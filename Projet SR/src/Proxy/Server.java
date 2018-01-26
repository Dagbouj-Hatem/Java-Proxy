package Proxy;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import SI_Ent_3.Facture;

public class Server {

	public static void main(String[] args) 
	{
		try {
			//System.setProperty("java.rmi.server.hostname","localhost");
			Registry reg= LocateRegistry.createRegistry(6000);
			ProxyImp p=new ProxyImp();
			Naming.rebind("rmi://localhost:6000/P", p);
			System.out.println("\t Proxy : Attente des invocations des clients sur le port 6000 ");
		} catch (Exception e) 
		{ 
			System.out.println(e.getMessage());
		}
	}

}
