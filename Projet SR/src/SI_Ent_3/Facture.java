package SI_Ent_3;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Facture extends UnicastRemoteObject implements IFacture {
	
	// constructor
	public Facture() throws RemoteException 
	{
		super(); 
	}

	/*
	 * redefintition des methods(non-Javadoc)
	 * 
	 */
	//-----------------------------------------------------------------------
	//rechercher  une Facture a partir de son code
	@Override
	public String findFacture(int Code) throws RemoteException
	{
		StringWriter out = new StringWriter();
		try 
		 { 
			java.sql.Connection connect= DriverManager.getConnection("jdbc:mysql://localhost/vente","root","");
			java.sql.Statement st=connect.createStatement();
			String query="SELECT * FROM `facture` WHERE `facture`.`id` = "+Code;;
			ResultSet rs=st.executeQuery(query); 
			// test  si  le  ResultSet est  vide  
			 boolean isEmpty=true;
			// sinon  
			while(rs.next())
			{	if(rs.getInt("id")==Code)
				 {		isEmpty=false;
					out.append("ID :"+rs.getInt("id")+" ");
					out.append("Nom :"+rs.getString("nomC")+" ");
					out.append("Prenom :"+rs.getString("PrenomC")+" ");
					out.append("Marque voiture :"+rs.getString("marqueV")+" ");
					out.append("N° immatriculation :"+rs.getString("num_immat")+" ");
					out.append("Prix :"+rs.getString("prix")+"\n");
				 }
			} 
			if(isEmpty) return " Aucune Facture correspond à le Code : "+String.valueOf(Code)+" .\n";
			
		 } catch (Exception e) 
		 { 
			 System.out.println(e.getMessage());
			 return " Erreur de Connexion .\n";
		 }
		 
		 return out.toString(); 
	}
	
	//afficher tout les facture
	@Override
	public String findFacture() throws RemoteException
	{ StringWriter out = new StringWriter();
		try 
		 {
			java.sql.Connection connect= DriverManager.getConnection("jdbc:mysql://localhost/vente","root","");
			java.sql.Statement st=connect.createStatement();
			String query="SELECT * FROM `facture`";
			ResultSet rs=st.executeQuery(query); 
			// test  si  le  ResultSet est  vide  
			 boolean isEmpty=true;
			// sinon  
			while(rs.next())
			{	isEmpty=false;
			
				out.append("ID :"+rs.getInt("id")+" ");
				out.append("Nom :"+rs.getString("nomC")+" ");
				out.append("Prenom :"+rs.getString("PrenomC")+" ");
				out.append("Marque voiture :"+rs.getString("marqueV")+" ");
				out.append("N° immatriculation :"+rs.getString("num_immat")+" ");
				out.append("Prix :"+rs.getString("prix")+"\n");
			} 
			
			if(isEmpty) return " Aucune Facture  .\n";
			
		 } catch (Exception e) 
		 { 
			 System.out.println(e.getMessage());
			 return " Erreur de Connexion .\n";
		 }
		 
		 return out.toString(); 
	}
	
	// mise à jours d'une facture 
	@Override
	public boolean updateFacture(int Code, int numero_att , String value) throws RemoteException
	{	String query = null;
		try 
		 {
			java.sql.Connection connect= DriverManager.getConnection("jdbc:mysql://localhost/vente","root","");
			java.sql.Statement st=connect.createStatement();
			if(numero_att==1)
				query="UPDATE `vente`.`facture` SET `nomC` = '"+value+"' WHERE `facture`.`id` = "+Code;
			else if(numero_att==2)
				query="UPDATE `vente`.`facture` SET `PrenomC`  = '"+value+"' WHERE `facture`.`id` = "+Code;
			else if(numero_att==3)
				query="UPDATE `vente`.`facture` SET `marqueV`  = '"+value+"' WHERE `facture`.`id` = "+Code;
			else if(numero_att==4)
				query="UPDATE `vente`.`facture` SET `num_immat`  = '"+value+"' WHERE `facture`.`id` = "+Code;
			else 
				query="UPDATE `vente`.`facture` SET `prix`  = '"+value+"' WHERE `facture`.`id` = "+Code;
			
			if( st.executeUpdate(query)>0) return true;
			else return false ;
		 } catch (Exception e) 
		 { 
			 System.out.println(e.getMessage());
			 return false;
		 }
	}
	
	// supprimer  une facture 
	@Override
	public boolean deleteFacture(int Code) throws RemoteException 
	{
		try 
		 {
			java.sql.Connection connect= DriverManager.getConnection("jdbc:mysql://localhost/vente","root","");
			java.sql.Statement st=connect.createStatement();
			String query="DELETE FROM `vente`.`facture` WHERE `facture`.`id` = "+Code;
			if( st.executeUpdate(query)>0) return true;
			else return false ;
		 } catch (Exception e) 
		 { 
			 System.out.println(e.getMessage());
			 return false;
		 }
		
	}
	
	// ajouter un facture
	@Override
	public boolean addFacture(String NomC, String PrenomC, String marque, String num_immat, String prix)
			throws RemoteException 
	{
		try 
		 {
			java.sql.Connection connect= DriverManager.getConnection("jdbc:mysql://localhost/vente","root","");
			java.sql.Statement st=connect.createStatement();
			String query="INSERT INTO `vente`.`facture` (`id`, `nomC`, `PrenomC`, `marqueV`, `num_immat`, `prix`)"
					+ " VALUES (NULL, '"+NomC+"', '"+PrenomC+"', '"+marque+"', '"+num_immat+"', '"+prix+"')";
			if( st.executeUpdate(query)>0) return true;
			else return false ; 
			
		 } catch (Exception e) 
		 {  System.out.println(e.getMessage());
		 return false;
		 }
			
		
	}
	
	
	
	// Calculer la recette de 2 eme & 3eme entreprise  
	@Override
	public double calculRecette() throws RemoteException
	{
		try 
		 {
			java.sql.Connection connect= DriverManager.getConnection("jdbc:mysql://localhost/vente","root","");
			java.sql.Statement st=connect.createStatement();
			String query="SELECT SUM(`prix`) as recette FROM `facture`";
			ResultSet r=st.executeQuery(query); 
			if( r.next())
			{
				return r.getDouble("recette") ;
			}
			else 
				return -1;
			
		 } catch (Exception e) 
		 {  System.out.println(e.getMessage());
		 	return -1;
		 }
		 

 	}
	
}
