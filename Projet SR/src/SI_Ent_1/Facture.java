package SI_Ent_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class Facture { 
	
	// Constructor ---> ajouter un  facture 
	/* code    --> 3 Octets 
	 * nom     --> 10 Octets 
	 * montant --> 5 Octets 
	 */
	public static String addFacture(int code,String nom , double montant) {  
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String ligne = "Code:"+getFixedLengthString(String.valueOf(code),3)+"Nom:"+getFixedLengthString(String.valueOf(nom),10)+"Montant:"+getFixedLengthString(String.valueOf(montant),5)+"\n";

			fw = new FileWriter("C:\\Users\\acer\\work_space\\Projet SR\\src\\SI_Ent_1\\facture.txt", true );
			bw = new BufferedWriter(fw);
			bw.write(ligne); 
			return " Successfully added\n";

		} catch (IOException e) { System.out.println(e.getMessage()); return " Error \n";}
		finally { 
					try {
							bw.close();
							
							fw.close();
						} 
						catch (IOException e) { System.out.println(e.getMessage()); }
				}
	}
	// listter  tous les facture 
	public static String getInfos()
	{	StringWriter out = new StringWriter();
			try{
			InputStream flux=new FileInputStream("C:\\Users\\acer\\work_space\\Projet SR\\src\\SI_Ent_1\\facture.txt"); 
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff=new BufferedReader(lecture);
			String ligne;
			while ((ligne=buff.readLine())!=null)
			{ 
				 out.write(ligne+"\n");
			}
			buff.close(); 
			}		
			catch (Exception e){
			System.out.println(e.toString());
			}
			
			return  out.toString(); 	
	}
	// rechercher  une facture par son code 
	public static String getInfo(int code )
	{ 
		StringWriter out = new StringWriter();
		int code_ligne;
		 
		try{
		InputStream flux=new FileInputStream("C:\\Users\\acer\\work_space\\Projet SR\\src\\SI_Ent_1\\facture.txt"); 
		InputStreamReader lecture=new InputStreamReader(flux);
		BufferedReader buff=new BufferedReader(lecture);
		String ligne;
		while ((ligne=buff.readLine())!=null)
		{
			    // tester sur le code 
				code_ligne=Integer.parseInt(ligne.substring(5,8).trim());
				if(code_ligne==code)  out.write(ligne+"\n");
			
		}
		buff.close(); 
		}		
		catch (Exception e){
		System.out.println(e.toString());
		}
		
		return  out.toString();
		
	}
	// rechercher  une facture par son : Nom 
	public static String getInfo(String nom )
	{
		StringWriter out = new StringWriter();
		String nom_ligne;
		 
		try{
		InputStream flux=new FileInputStream("C:\\Users\\acer\\work_space\\Projet SR\\src\\SI_Ent_1\\facture.txt"); 
		InputStreamReader lecture=new InputStreamReader(flux);
		BufferedReader buff=new BufferedReader(lecture);
		String ligne;
		while ((ligne=buff.readLine())!=null)
		{
			    // tester sur le code 
				nom_ligne=ligne.substring(12,22).trim(); 
				if(nom_ligne.equals(nom))  out.write(ligne+"\n");
			
		}
		buff.close(); 
		}		
		catch (Exception e){
		System.out.println(e.toString());
		}
		
		return  out.toString();
	}
	// rechercher  une facture par son : Montant 
	public static String getInfo(double montant )
	{
		StringWriter out = new StringWriter();
		double montant_ligne;
		 
		try{
		InputStream flux=new FileInputStream("C:\\Users\\acer\\work_space\\Projet SR\\src\\SI_Ent_1\\facture.txt"); 
		InputStreamReader lecture=new InputStreamReader(flux);
		BufferedReader buff=new BufferedReader(lecture);
		String ligne;
		while ((ligne=buff.readLine())!=null)
		{
			    // tester sur le code 
				montant_ligne=Double.parseDouble(ligne.substring(30).trim());  
				if(montant_ligne==montant)  out.write(ligne+"\n");
			
		}
		buff.close(); 
		}		
		catch (Exception e){
		System.out.println(e.toString());
		}
		
		return  out.toString();
	}
	// Calculer la recette de 1ere entreprise  
	public static double getRecette()
	{
		double recette =0;
		StringWriter out = new StringWriter();
		double montant_ligne;
		 
		try{
		InputStream flux=new FileInputStream("C:\\Users\\acer\\work_space\\Projet SR\\src\\SI_Ent_1\\facture.txt"); 
		InputStreamReader lecture=new InputStreamReader(flux);
		BufferedReader buff=new BufferedReader(lecture);
		String ligne;
		while ((ligne=buff.readLine())!=null)
		{
			    // lire le montant d'une ligne 
				montant_ligne=Double.parseDouble(ligne.substring(30).trim());  
				// ajouter montant à la recette 
				recette+=montant_ligne;
			
		}
		buff.close(); 
		}		
		catch (Exception e){
		System.out.println(e.toString());
		}
			
		
		return recette ;
		
	} 
	// Fixer la taille d'un champs  Du fichier  Plat 
	public static String getFixedLengthString(String pString, int length)
	{
		if (pString.length()==length) return  pString;
		else if (pString.length()<length)
		{
			String format = "%1$-"+String.valueOf(length)+"s";
			String o = String.format(format, new String[]{pString}).replace(' ', ' ');
			return  o;
		}
		else 
		{
			return pString.substring(0,length);
		}
	}
	 


}
