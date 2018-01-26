package SI_Ent_2;

import javax.xml.ws.*;
import javax.jws.*;
import SI_Ent_2.Facture;

public class ServerWS {

	public static void main(String[] args) {
		 
		try {
			 
				Endpoint.publish("http://localhost:5000/", new Facture()); 
				System.out.println(" Web Service Publier sur le prot 5000 ...");
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
