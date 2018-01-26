package Proxy;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

import SI_Ent_3.IFacture;
import Proxy.si_ent_2.*; 

public class ProxyImp extends UnicastRemoteObject implements IProxy {
	
	//public static FactureWS facture;
	public static String hostName = "localhost";
	Socket socket = null; 
	public static Facture stub2; // stub entreprise 2
	public static IFacture stub; // stub entreprise 3

	protected ProxyImp() throws RemoteException 
	{
		super(); 
		
		try
		{	 
			 
			// serveur enteprise 2
			FactureWS facture = new FactureWSLocator();
			stub2= facture.getFacturePort();
			// serveur entreprise 3
			stub = (IFacture) Naming.lookup("rmi://localhost:1099/F");
		}
		catch ( Exception e)
		{
			System.out.println(e.getMessage());
			 
		}
		
	}
	
	/*
	 * 1ere entreprise 
	 */
	
	@Override
	public String addFacture(int code, String nom, double montant) throws RemoteException {
		
		try {
			//on initialise la connexion 
			DatagramSocket client =new DatagramSocket();
			//on  crée notre Datgramme 
			InetAddress adresse= Inet4Address.getByName("127.0.0.1");
			byte[] buffer_commande= new String("1").getBytes() ;
			DatagramPacket packet_commande= new DatagramPacket(buffer_commande , buffer_commande.length , adresse ,2345);
			// mettres les donnée dans le Datagramme à envoiyé 
			packet_commande.setData(buffer_commande);
			// envoiyer aux serveur  
			client.send(packet_commande);
			
			//1ere argument
			byte[] buffer_arg1= new String(String.valueOf(code)).getBytes() ;
			DatagramPacket packet_arg1= new DatagramPacket(buffer_arg1 , buffer_arg1.length , adresse ,2345);
			// mettres les donnée dans le Datagramme à envoiyé 
			packet_commande.setData(buffer_arg1);
			// envoiyer aux serveur  
			client.send(packet_arg1);
			//2eme argument
			byte[] buffer_arg2= new String(nom).getBytes() ;
			DatagramPacket packet_arg2= new DatagramPacket(buffer_arg2 , buffer_arg2.length , adresse ,2345);
			// mettres les donnée dans le Datagramme à envoiyé 
			packet_commande.setData(buffer_arg2);
			// envoiyer aux serveur  
			client.send(packet_arg2);
			//3eme argument
			byte[] buffer_arg3= new String(String.valueOf(montant)).getBytes() ;
			DatagramPacket packet_arg3= new DatagramPacket(buffer_arg3 , buffer_arg3.length , adresse ,2345);
			// mettres les donnée dans le Datagramme à envoiyé 
			packet_commande.setData(buffer_arg3);
			// envoiyer aux serveur  
			client.send(packet_arg3);
			
			//récupére de la reponce du  serveur 
			byte [] buffer_responce = new byte[1024];
			DatagramPacket packet_responce= new DatagramPacket(buffer_responce , buffer_responce.length , adresse ,2345);
			client.receive(packet_responce);
			return(new String(buffer_responce).trim());
			
			
		} catch (Exception e) {
			// affichage du  exception 
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public String getInfos() throws RemoteException {
		try {
			//on initialise la connexion 
			DatagramSocket client =new DatagramSocket();
			//on  crée notre Datgramme 
			InetAddress adresse= Inet4Address.getByName("127.0.0.1");
			byte[] buffer_commande= new String("2").getBytes() ;
			DatagramPacket packet_commande= new DatagramPacket(buffer_commande , buffer_commande.length , adresse ,2345);
			// mettres les donnée dans le Datagramme à envoiyé 
			packet_commande.setData(buffer_commande);
			// envoiyer aux serveur  
			client.send(packet_commande);
			
			//récupére de la reponce du  serveur 
			byte [] buffer_responce = new byte[1024];
			DatagramPacket packet_responce= new DatagramPacket(buffer_responce , buffer_responce.length , adresse ,2345);
			client.receive(packet_responce); 
			return(new String(buffer_responce).trim());
			
		} catch (Exception e) {
			// affichage du  exception 
			System.out.println(e.getMessage());
		}
		 return  null ;
	}

	@Override
	public String getInfo(int code) throws RemoteException {
		try {
			//on initialise la connexion 
			DatagramSocket client =new DatagramSocket();
			//on  crée notre Datgramme 
			InetAddress adresse= Inet4Address.getByName("127.0.0.1");
			byte[] buffer_commande= new String("3").getBytes() ;
			DatagramPacket packet_commande= new DatagramPacket(buffer_commande , buffer_commande.length , adresse ,2345);
			// mettres les donnée dans le Datagramme à envoiyé 
			packet_commande.setData(buffer_commande);
			// envoiyer aux serveur  
			client.send(packet_commande);
			
			byte[] buffer_arg1= new String(String.valueOf(code)).getBytes() ;
			DatagramPacket packet_arg1= new DatagramPacket(buffer_arg1 , buffer_arg1.length , adresse ,2345);
			// mettres les donnée dans le Datagramme à envoiyé 
			packet_commande.setData(buffer_arg1);
			// envoiyer aux serveur  
			client.send(packet_arg1);
			
			//récupére de la reponce du  serveur 
			byte [] buffer_responce = new byte[1024];
			DatagramPacket packet_responce= new DatagramPacket(buffer_responce , buffer_responce.length , adresse ,2345);
			client.receive(packet_responce); 
			return(new String(buffer_responce).trim());
			
		} catch (Exception e) {
			// affichage du  exception 
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public String getInfo(String nom) throws RemoteException {
		try {
			//on initialise la connexion 
			DatagramSocket client =new DatagramSocket();
			//on  crée notre Datgramme 
			InetAddress adresse= Inet4Address.getByName("127.0.0.1");
			byte[] buffer_commande= new String("4").getBytes() ;
			DatagramPacket packet_commande= new DatagramPacket(buffer_commande , buffer_commande.length , adresse ,2345);
			// mettres les donnée dans le Datagramme à envoiyé 
			packet_commande.setData(buffer_commande);
			// envoiyer aux serveur  
			client.send(packet_commande);
			
			byte[] buffer_arg1= new String(nom).getBytes() ;
			DatagramPacket packet_arg1= new DatagramPacket(buffer_arg1 , buffer_arg1.length , adresse ,2345);
			// mettres les donnée dans le Datagramme à envoiyé 
			packet_commande.setData(buffer_arg1);
			// envoiyer aux serveur  
			client.send(packet_arg1);
			
			//récupére de la reponce du  serveur 
			byte [] buffer_responce = new byte[1024];
			DatagramPacket packet_responce= new DatagramPacket(buffer_responce , buffer_responce.length , adresse ,2345);
			client.receive(packet_responce);
			return(new String(buffer_responce).trim());
			
			
		} catch (Exception e) {
			// affichage du  exception 
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public String getInfo(double montant) throws RemoteException {
		try {
			//on initialise la connexion 
			DatagramSocket client =new DatagramSocket();
			//on  crée notre Datgramme 
			InetAddress adresse= Inet4Address.getByName("127.0.0.1");
			byte[] buffer_commande= new String("5").getBytes() ;
			DatagramPacket packet_commande= new DatagramPacket(buffer_commande , buffer_commande.length , adresse ,2345);
			// mettres les donnée dans le Datagramme à envoiyé 
			packet_commande.setData(buffer_commande);
			// envoiyer aux serveur  
			client.send(packet_commande);
			
			byte[] buffer_arg1= new String(String.valueOf(montant)).getBytes() ;
			DatagramPacket packet_arg1= new DatagramPacket(buffer_arg1 , buffer_arg1.length , adresse ,2345);
			// mettres les donnée dans le Datagramme à envoiyé 
			packet_commande.setData(buffer_arg1);
			// envoiyer aux serveur  
			client.send(packet_arg1);
			
			//récupére de la reponce du  serveur 
			byte [] buffer_responce = new byte[1024];
			DatagramPacket packet_responce= new DatagramPacket(buffer_responce , buffer_responce.length , adresse ,2345);
			client.receive(packet_responce);
			return(new String(buffer_responce).trim());
			
			
		} catch (Exception e) {
			// affichage du  exception 
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public double getReccete() throws RemoteException {
		try {
			//on initialise la connexion 
			DatagramSocket client =new DatagramSocket();
			//on  crée notre Datgramme 
			InetAddress adresse= Inet4Address.getByName("127.0.0.1");
			byte[] buffer_commande= new String("6").getBytes() ;
			DatagramPacket packet_commande= new DatagramPacket(buffer_commande , buffer_commande.length , adresse ,2345);
			// mettres les donnée dans le Datagramme à envoiyé 
			packet_commande.setData(buffer_commande);
			// envoiyer aux serveur  
			client.send(packet_commande);
			
			//récupére de la reponce du  serveur 
			byte [] buffer_responce = new byte[1024];
			DatagramPacket packet_responce= new DatagramPacket(buffer_responce , buffer_responce.length , adresse ,2345);
			client.receive(packet_responce);
			return Double.parseDouble(new String(buffer_responce).trim());
			
			
		} catch (Exception e) {
			// affichage du  exception 
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	
	/*
	 *  2eme entreprise 
	 */
	
	// ajouter une facture 
	@Override
	public boolean addFacture2(String NomC, String PrenomC, String marque, String num_immat, String prix)
			throws RemoteException {  
		return stub2.addFacture(NomC, PrenomC, marque, num_immat, prix);
	}
	// listter  tous les facture
	@Override
	public String findFactures2() throws RemoteException { 
		return stub2.afficher();
	}
	// rechercher  une facture par son code
	@Override
	public String findFacture2(int Code) throws RemoteException { 
		return stub2.findFacture(Code);
	}
	// mise à jours d'une facture
	@Override
	public boolean updateFacture2(int Code, int numero_att, String value) throws RemoteException { 
		return stub2.updateFacture(Code, numero_att, value);
	}
//  supprimer  une facture  
	@Override
	public boolean deleteFacture2(int Code) throws RemoteException { 
		return stub2.deleteFacture(Code);
	}

	
	// 3eme entreprise  
	
	@Override
	public boolean addFacture(String NomC, String PrenomC, String marque, String num_immat, String prix)
			throws RemoteException { 
		return stub.addFacture(NomC, PrenomC, marque, num_immat, prix);
	}

	@Override
	public String findFacture(int Code) throws RemoteException { 
		return stub.findFacture(Code);
	}

	@Override
	public String findFacture() throws RemoteException { 
		return stub.findFacture();
	}

	@Override
	public boolean updateFacture(int Code, int numero_att, String value) throws RemoteException { 
		return stub.updateFacture(Code, numero_att, value);
	}

	@Override
	public boolean deleteFacture(int Code) throws RemoteException { 
		return stub.deleteFacture(Code);
	}

	@Override
	public double calculRecette() throws RemoteException { 
		double montantSE1 =  getReccete(); 
		return (stub.calculRecette()+montantSE1);
	}

}
