package peage.domaine;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import peage.factory.Distributeur;

public class Autoroute {

	protected static Autoroute CURRENT = new Autoroute();

	protected Distributeur distributeur;

	protected static final String PATH = "ressources/prix.txt";

	protected Map<String, BorneEntree> bornesEntrees;

	protected Map<String, BorneSortie> bornesSorties;

	public static Autoroute current() {
		return CURRENT;
	}

	public Autoroute() {
		this.distributeur = new Distributeur();
		this.bornesEntrees = new HashMap<String, BorneEntree>();
		this.bornesSorties = new HashMap<String, BorneSortie>();

		String line;
		String[] coll;

		try {
			InputStream stream = new FileInputStream(PATH);
			InputStreamReader readStream = new InputStreamReader(stream);
			BufferedReader br = new BufferedReader(readStream);
			while ((line = br.readLine()) != null) {
				coll = line.split(" ");
				this.addBorneEntree(coll[1]);
				this.addBorneSortie(coll);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void addBorneSortie(String[] coll) {
		if (!this.bornesSorties.containsKey(coll[1])) {
			this.bornesSorties.put(coll[1], new BorneSortie(coll[1]));
		}
		this.bornesSorties.get(coll[1]).addPrice(coll[1], Integer.parseInt(coll[2]));
	}

	public void addBorneEntree(String city) {
		if (!this.bornesEntrees.containsKey(city)) {
			BorneEntree borne = new BorneEntree(city);
			borne.distributeur(this.distributeur);
			this.bornesEntrees.put(city, borne);
		}
	}

	public boolean cityExitExist(String city) {
		return this.bornesSorties.containsKey(city);

	}

	public boolean cityEntranceExist(String city) {
		return this.bornesEntrees.containsKey(city);

	}

	public void printExitCities() {
		for (String city : this.bornesSorties.keySet()) {
			System.out.println(city);
		}
	}
	
	public void printEntranceCities() {
		for (String city : this.bornesEntrees.keySet()) {
			System.out.println(city);
		}
	}

	public Ticket ticketFor(String city) {
		return this.bornesEntrees.get(city).getTicket();
	}
	
	public BorneSortie exitBorneFor(String city){
		return this.bornesSorties.get(city);
	}
}
