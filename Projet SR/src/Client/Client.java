package Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import Proxy.IProxy;

public class Client {

	public static void main(String[] args)
	{ 
		int menuSelection = 0;  // choix  nemu 1
		int choix =0 ; // choix menu 2 
		Scanner in=new Scanner(System.in);
		
		while (menuSelection != 5) 
		{
			if (menuSelection==0)
			// 1ere menu 
			menuSelection = mainMenu();

			// if 5, exit program
			if (menuSelection == 5) {
				System.out.println("Quitting.");
				System.exit(0);
			}
			// 2eme menu 
			choix =sousMenu(menuSelection);
			/*--------------------------------------------------------------------------------------------------------------
			*  Récuperer l instance distant 
			*/
	
						 try {
							    IProxy stub= (IProxy) Naming.lookup("rmi://localhost:6000/P");
						    
			//--------------------------------------------------------------------------------------------------------------
			if(choix==6)
			{
				// ne faire rien pour revenir a menu précedant 
				menuSelection=0;
			}
			else
			{		
					 
				    // SI entreprise 1
					if(menuSelection==1)
					{		
						
							if(choix==1)
							{    // Get Infos
								System.out.println(" --------------- Liste des Factures --------");
								System.out.println(stub.getInfos());
								System.out.println(" --------------------- Fin Liste -----------");
							}
							if(choix==2)
							{    // Add Facture
								in.nextLine();
								System.out.println(" --------------- info du  facture ----------");
								System.out.print("\tDonner le Code          :");int code=in.nextInt();in.nextLine();
								System.out.print("\tDonner le Nom           :");String nom =in.nextLine();
								System.out.print("\tDonner le Montant       :");double montant=in.nextDouble();
								System.out.println(stub.addFacture(code, nom, montant));
								System.out.println(" --------------------- Fin Ajout -----------");
							}
							if(choix==3)
							{    // Get Facture (Montant)
								System.out.print("\tDonner le Montant       :");
								double montant=in.nextDouble();
								System.out.println(stub.getInfo(montant));
							}
							if(choix==4)
							{    //Get Facture (Code)
								System.out.print("\tDonner le Code          :");
								int code=in.nextInt();
								System.out.println(stub.getInfo(code));
							}
							if(choix==5)
							{    // Get Facture (Nom)
								System.out.print("\tDonner le Nom           :");
								String nom=in.nextLine();
								System.out.println(stub.getInfo(nom));
							}
					}
					// SI entreprise 2
					if(menuSelection==2)
					{
							if(choix==1)
							{    //Rechercher une Facture a partir de son code
								System.out.print("\n\tDonner le code du facture :");
								int Code=in.nextInt();
								System.out.println("\n"+stub.findFacture2(Code));
							}
							if(choix==2)
							{    // Afficher tout les factures
								System.out.println("\n"+stub.findFactures2());
							}
							if(choix==3)
							{    // Mise à jours d'une facture
								System.out.print("\n\tDonner le code du facture :");
								int Code=in.nextInt();
								int numero_att=0;
								while ((numero_att <= 0) || (numero_att > 5)) {
									System.out.print("\n\t 1. Modifier le Nom du Client :");
									System.out.print("\n\t 2. Modifier le Prénom du Client :");
									System.out.print("\n\t 3. Modifier la Marque de Voiture :");
									System.out.print("\n\t 4. Modifier le Numéro immatriculation :");
									System.out.println("\n\t 5. Modifier le Prix :");
									
									System.out.print("\n\t Choisir un attribut par Son numéro correspondant :");

									 numero_att=in.nextInt();
								}
								in.nextLine();
								System.out.print("\n\t Donner la valeur souhaitée :");
								String value=in.nextLine();
								if(stub.updateFacture2(Code, numero_att, value))
									System.out.println("\n\t Modification avec Succée .\n");
								else
									System.out.println("\n\t Echec de Modification .\n");
							}
							if(choix==4)
							{    //Supprimer  une facture
								System.out.print("\n\tDonner le code du facture :");
								int Code=in.nextInt();
								if (stub.deleteFacture2(Code))
									System.out.println("\n\t Suppression avec Succée .\n");
								else
									System.out.println("\n\t Echec de Suppression .\n");
							}
							if(choix==5)
							{    // Ajouter un facture
								in.nextLine();
								System.out.print("\n\t Donner le Nom du Client          :");  	String NomC=in.nextLine();
								System.out.print("\t Donner le Prénom du Client       :");	String PrenomC=in.nextLine();
								System.out.print("\t Donner la Marque de Voiture      :");	String marque=in.nextLine();
								System.out.print("\t Donner le Numéro immatriculation :");	String num_immat=in.nextLine();
								System.out.print("\t Donner le Prix                   :");	String prix=in.nextLine();
								if( stub.addFacture2(NomC, PrenomC, marque, num_immat, prix))
									System.out.println("\n\t Ajout avec Succée .\n");
								else
									System.out.println("\n\t Echec lors de l'ajout .\n");
							}
					}
					// SI entreprise 3
					if(menuSelection==3)
					{
							if(choix==1)
							{    // Rechercher une Facture a partir de son code
								System.out.print("\n\tDonner le code du facture :");
								int Code=in.nextInt();
								System.out.println("\n"+stub.findFacture(Code));
							}
							if(choix==2)
							{    // Afficher tout les factures
									System.out.println("\n"+stub.findFacture());
								
							}
							if(choix==3)
							{    // Mise à jours d'une facture
								System.out.print("\n\tDonner le code du facture :");
								int Code=in.nextInt();
								int numero_att=0;
								while ((numero_att <= 0) || (numero_att > 5)) {
									System.out.print("\n\t 1. Modifier le Nom du Client :");
									System.out.print("\n\t 2. Modifier le Prénom du Client :");
									System.out.print("\n\t 3. Modifier la Marque de Voiture :");
									System.out.print("\n\t 4. Modifier le Numéro immatriculation :");
									System.out.println("\n\t 5. Modifier le Prix :");
									
									System.out.print("\n\t Choisir un attribut par Son numéro correspondant :");

									 numero_att=in.nextInt();
								}
								in.nextLine();
								System.out.print("\n\t Donner la valeur souhaitée :");
								String value=in.nextLine();
								if(stub.updateFacture(Code, numero_att, value))
									System.out.println("\n\t Modification avec Succée .\n");
								else
									System.out.println("\n\t Echec de Modification .\n");
							}
							if(choix==4)
							{    //Supprimer  une facture
								System.out.print("\n\tDonner le code du facture :");
								int Code=in.nextInt();
								if (stub.deleteFacture(Code))
									System.out.println("\n\t Suppression avec Succée .\n");
								else
									System.out.println("\n\t Echec de Suppression .\n");
								
							}
							if(choix==5)
							{    // Ajouter un facture
								in.nextLine();
								System.out.print("\n\t Donner le Nom du Client          :");  	String NomC=in.nextLine();
								System.out.print("\t Donner le Prénom du Client       :");	String PrenomC=in.nextLine();
								System.out.print("\t Donner la Marque de Voiture      :");	String marque=in.nextLine();
								System.out.print("\t Donner le Numéro immatriculation :");	String num_immat=in.nextLine();
								System.out.print("\t Donner le Prix                   :");	String prix=in.nextLine();
								if( stub.addFacture(NomC, PrenomC, marque, num_immat, prix))
									System.out.println("\n\t Ajout avec Succée .\n");
								else
									System.out.println("\n\t Echec lors de l'ajout .\n");
							}
					}
					//  Claculer la recette des 3 entreprise 
					if(menuSelection==4)
					{
						System.out.println("\n Recette de : "+stub.calculRecette()+" Dinars Tunisien .\n");
						// revenir a menu principal 
							menuSelection=0;

					}
					
					
			//------------------------------------------ end Catch ----------------------------------------------------------------------------------------------
			}
			} 
		 	catch (MalformedURLException | RemoteException | NotBoundException e)
		 	{ 
		 			System.out.println(e.getMessage());
		 	}
					
			}
			
		in.close();
		
		}
	//-------------------------------------------------------------    End Main   -------------------------------------------------------------------------------
	public static int mainMenu() {
		int menuSelection = 0;
		// loop (and prompt again) until the user's input is an integer between 1 and 8
		while ((menuSelection <= 0) || (menuSelection > 5)) {
			System.out.println("==================================     MENU PRINCIPAL        ===========================================");
			System.out.println(  "1. Service la récupération des factures de ventes de produits parapharmaceutiques .\n"
								+"2. Service la récupération des factures de ventes de véhicules de transport (JAX-WS) .\n"
								+"3. Service la récupération des factures de ventes de véhicules de transport (RMI) .\n"
								+"4. Calculer la recette globale des 3 entreprises .\n" 
								+"5. Quitter ." );
			System.out.println("========================================================================================================");
			System.out.print("\tChoisir un service par Son numéro correspondant : ");
			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) menuSelection = sc.nextInt();
		}
		return menuSelection;
	}
	public static int sousMenu(int menuSelection ) {
		 int choix =0;
		Scanner sc = new Scanner(System.in);
			if(menuSelection==1)
			{   
				while ((choix <= 0) || (choix > 6)) {
					System.out.println("=================== Menu des factures de ventes de produits parapharmaceutiques ========================");
					System.out.println(  "\t 1. Get Infos . \n"
										+"\t 2. Add Facture .\n"
										+"\t 3. Get Facture (Montant).\n"
										+"\t 4. Get Facture (Code) .\n"
										+"\t 5. Get Facture (Nom) .\n"
										+"\t 6. Back to principal Menu. " );
					System.out.println("========================================================================================================");
					System.out.print("\tChoisir une Action par Son numéro correspondant : "); 
					if (sc.hasNextInt()) choix = sc.nextInt();
				}
			}
			if(menuSelection==2)
			{
				while ((choix <= 0) || (choix > 6)) {
					System.out.println("=================== Menu des factures de ventes de véhicules de transport ( JAX-WS ) ===================");
					System.out.println(  "\t 1. Rechercher une Facture a partir de son code . \n"
										+"\t 2. Afficher tout les factures .\n"
										+"\t 3. Mise à jours d'une facture.\n"
										+"\t 4. Supprimer  une facture  .\n"
										+"\t 5. Ajouter un facture.\n"
										+"\t 6. Back to principal Menu. " );
					System.out.println("========================================================================================================");
					System.out.print("\tChoisir une Action par Son numéro correspondant : "); 
					if (sc.hasNextInt()) choix = sc.nextInt();
				}
			}
			if(menuSelection==3)
			{
				while ((choix <= 0) || (choix > 6)) {
					System.out.println("=================== Menu des factures de ventes de véhicules de transport (RMI)  =======================");
					System.out.println(  "\t 1. Rechercher une Facture a partir de son code . \n"
										+"\t 2. Afficher tout les factures .\n"
										+"\t 3. Mise à jours d'une facture.\n"
										+"\t 4. Supprimer  une facture  .\n"
										+"\t 5. Ajouter un facture.\n"
										+"\t 6. Back to principal Menu. " );
					System.out.println("========================================================================================================");
					System.out.print("\tChoisir une Action par Son numéro correspondant : "); 
					if (sc.hasNextInt()) choix = sc.nextInt();
				}
			}
			 	 
		return choix;
	}

}
