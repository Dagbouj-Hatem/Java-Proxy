package SI_Ent_2;

import java.io.StringWriter;
import java.rmi.RemoteException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlType;
 

@WebService (serviceName="FactureWS")
@XmlType(name="Facture", namespace="http://SI_Ent_2/")
public class Facture {
	
	
	//rechercher  une Facture a partir de son code
		@WebMethod
		public String findFacture(@WebParam(name="code") int Code)  
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
		@WebMethod (operationName="afficher")
		public String findFactures()
		{ StringWriter out = new StringWriter();
		try 
		 {
			java.sql.Connection connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/vente","root","");
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
		@WebMethod
		public boolean updateFacture(int Code, int numero_att , String value) 
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
		@WebMethod
		public boolean deleteFacture(int Code) 
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
		@WebMethod
		public boolean addFacture(String NomC, String PrenomC, String marque, String num_immat, String prix)
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
		
		
		 
	}

