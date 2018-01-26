package SI_Ent_3;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	
	public static void main(String[] args)
	{
		try {
			//System.setProperty("java.rmi.server.hostname","localhost");
			Registry reg= LocateRegistry.createRegistry(1099);
			Facture f=new Facture();
			Naming.rebind("rmi://localhost:1099/F", f);
			System.out.println("\t Serveur RMI : Attente des invocations des clients sur le port 1099 ");
		} catch (Exception e) 
		{ 
			System.out.println(e.getMessage());
		}
		
	}

}
