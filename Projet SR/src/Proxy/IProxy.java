package Proxy;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.jws.WebParam;

public interface IProxy extends Remote
{
		/*
		 * 1ere entreprise 
		 */
	
		//  ajouter un  facture  
		String addFacture(int code,String nom , double montant) throws RemoteException;
		
		// listter  tous les facture 
		String getInfos()throws RemoteException;
		
		// rechercher  une facture par son code 
		String getInfo(int code ) throws RemoteException;
		
		// rechercher  une facture par son : Nom 
		String getInfo(String nom )throws RemoteException;
		
		// rechercher  une facture par son : Montant 
		String getInfo(double montant )throws RemoteException;
		
 		 //  Claculer la recette de le 1ere entreprise 
		double getReccete() throws RemoteException;
		
		
		/*
		 *  2eme entreprise 
		 */
		
		// ajouter une facture 
		boolean addFacture2(String NomC, String PrenomC, String marque, String num_immat, String prix) throws  RemoteException;
		
		// listter  tous les facture 
		String findFactures2() throws RemoteException;
		
		// rechercher  une facture par son code 
		String findFacture2(int Code) throws RemoteException;
		 
		// mise à jours d'une facture 
		 boolean updateFacture2(int Code, int numero_att , String value)  throws RemoteException;
		 
		//  supprimer  une facture  
		 boolean deleteFacture2(int Code) throws RemoteException;
		 
		 
		/*
		 * 3eme entreprise 
		 */
		
		// ajouter un facture 
		boolean addFacture(String NomC, String PrenomC, String marque ,
				String num_immat , String prix) throws RemoteException ;
		
		//rechercher  une Facture a partir de son code 
		String findFacture(int Code )throws RemoteException;
		
		//afficher tout les facture 
		String findFacture( )throws RemoteException;
		
		// mise à jours d'une facture 
		boolean updateFacture(int Code , int numero_att , String value)throws RemoteException;
		
		// supprimer  une facture 
		boolean deleteFacture(int Code)throws RemoteException;
		
		// Calculer la recette de 2 eme & eme entreprise  
		
		double calculRecette() throws RemoteException;
}
