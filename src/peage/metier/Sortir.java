package peage.metier;

import java.io.BufferedReader;
import java.io.IOException;

import peage.domaine.Autoroute;
import peage.domaine.BorneSortie;
import peage.domaine.Ticket;

public class Sortir implements PeageAction {

	public Sortir() {

	}

	public void action(BufferedReader br) throws IOException {
		System.out.print("    --> nom de la sortie : ");
		String city = br.readLine().toLowerCase().trim();
		if (Autoroute.current().cityExitExist(city)) {
			this.tryExitAt(city, br);
		} else {
			System.out.println("Cette ville n'est pas une sortie valide. Villes possibles: ");
			Autoroute.current().printExitCities();
			this.action(br);
		}
	}
	
	public void tryExitAt(String city, BufferedReader br) throws IOException{
		System.out.print("    --> votre ticket : ");
		String ticket = br.readLine().toLowerCase().trim();
		BorneSortie borne = Autoroute.current().exitBorneFor(city);
		if (borne.checkTicket(ticket)){
			this.validExit(borne, ticket);
		}else{
			System.out.println("Ticket invalide.");
			this.action(br);
		}
	}
	
	public void validExit(BorneSortie borne, String ticket){
		borne.removeTicket(ticket);
		String city = ticket.split(Ticket.delimiter())[0];
		Integer price = borne.priceFor(city);
		System.out.println("    --> le prix à payer est de " + price.toString() + " euros.");
	}
}
