package SI_Ent_3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFacture extends Remote{
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
