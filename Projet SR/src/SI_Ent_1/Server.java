package SI_Ent_1;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
	
	public static void main(String  [] args )
	{
		try {
			
			// création d'une connexion coté Serveur  , en  spécifiant un prort d'écoute
			DatagramSocket server = new DatagramSocket(2345);
			
			System.out.println(" UDP : Attente des Clients Sur le port : 2345");
			// écoute 
			while(true)
			{	
				
				// on s'occupe maintenant de l'objet paquet 
				byte [] buffer = new byte[1024]; 
				DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);
				// récuperer le datagramme envoiyé  par  le client
				server.receive(paquet);
				// récuperer le contenu 
				String  msg =  new String(paquet.getData());
				// afficher  le contenue de "Commande " == MSG 
						int  commande =Integer.parseInt(msg.trim()); 
						String[] arguments = null ;
						// lecture des arguments selon la commande 
						switch (commande )
						{
						case 1 :{ 	// addFacture - 3 arguments 
									arguments = new String[3];
										// rénisialiser  la taille du datagramme , pour  les future datagramme
										paquet.setLength(buffer.length);
										
										// recive 1ere arguments 
										server.receive(paquet);
										arguments[0]=new String(paquet.getData()).trim();
										// rénisialiser  la taille du datagramme , pour  les future datagramme
										paquet.setLength(buffer.length);
										// recive 2eme arguments 
										
										server.receive(paquet);
										arguments[1]=new String(paquet.getData()).trim();
										// rénisialiser  la taille du datagramme , pour  les future datagramme
										paquet.setLength(buffer.length);
										
										// recive 3eme arguments 
										server.receive(paquet);
										arguments[2]=new String(paquet.getData()).trim();
									
									break ;
								}
						case 2 :{	// getInfo - 0 arguments 
									break  ; 
								}
						case 3 :{	// getInfo_Code - 1 arguments
									arguments = new String[1];
											// rénisialiser  la taille du datagramme , pour  les future datagramme
											paquet.setLength(buffer.length);
											// recive 1ere arguments 
											server.receive(paquet);
											arguments[0]=new String(paquet.getData()).trim(); 
									break  ; 
								}
						case 4 :{	// getInfo_Nom - 1 arguments
									arguments = new String[1];
											// rénisialiser  la taille du datagramme , pour  les future datagramme
											paquet.setLength(buffer.length);
											// recive 1ere arguments 
											server.receive(paquet);
											arguments[0]=new String(paquet.getData()).trim(); 
									break  ; 
								}
						case 5 :{	// getInfo_Montant - 1 arguments
									arguments = new String[1];
											// rénisialiser  la taille du datagramme , pour  les future datagramme
											paquet.setLength(buffer.length);
											// recive 1ere arguments 
											server.receive(paquet);
											arguments[0]=new String(paquet.getData()).trim(); 
									break  ; 
						}
						case 6 :{	// getRecette - 0 arguments 
									break  ; 
								}
							
						}
				// rénisialiser  la taille du datagramme , pour  les future datagramme
				paquet.setLength(buffer.length);
				
				// Preparer la Réponce du  serveur 
				byte[]  responce =executeCommande(commande,arguments).getBytes();
				DatagramPacket dataResponce = new DatagramPacket(responce, responce.length,paquet.getAddress(),paquet.getPort());
				// envoi la réponce a le client UDP 
				server.send(dataResponce);
				
				
				
				
			}
			
		} catch (Exception e) {
			// afficher  l'exception 
			System.out.println(e.getMessage());
		}
	}
	
	// methode qui traite la demande  du  client  et  retournée le resultat  
	public static String executeCommande(int commande , String[] argument)
	{
		String  result=  null  ;
		Facture facture = new Facture();		
			//  selon la commande on traite 
		switch (commande)
		{
				case 1 :  {		
								result= new String(facture.addFacture(Integer.parseInt(argument[0]), argument[1], Double.parseDouble(argument[2]))) ; break ;
						  }
				case 2 :  {
								result= new String(facture.getInfos()) ; break ;
						  }
				case 3 :  {
								result= new String(facture.getInfo(Integer.parseInt(argument[0]))) ; break ;
						  }
				case 4 :  {
								result= new String(facture.getInfo(argument[0])) ; break ;
						  }
				case 5 :  {
								result= new String(facture.getInfo( Double.parseDouble(argument[0]))) ; break ;
						  }
				case 6 :  {
								result= new String(String.valueOf(facture.getRecette())) ; break ;
						  }
		}
		return  result;
	}
}
