package peage.metier;

import java.io.BufferedReader;
import java.io.IOException;

import peage.domaine.Autoroute;
import peage.domaine.Ticket;

public class Entrer implements PeageAction {

	public Entrer() {

	}

	public void action(BufferedReader br) throws IOException {
		System.out.print("    --> nom de l'entrée : ");
		String city = br.readLine().toLowerCase();
		if (Autoroute.current().cityExist(city)) {
			Ticket ticket = Autoroute.current().ticketFor(city);
			System.out.println( "    --> votre ticket : " + ticket.toString());
		} else {
			System.out.println("Cette ville n'est pas une destination valide. Villes possibles: ");
			Autoroute.current().printCities();
			this.action(br);
		}

	}
}
