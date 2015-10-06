package peage.domaine;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Autoroute {

	private static Autoroute CURRENT = new Autoroute();

	protected static final String PATH = "ressources/prix.txt";

	protected Map<String, BorneEntree> bornesEntrees;

	protected Map<String, BorneSortie> bornesSorties;

	public static Autoroute current() {
		return CURRENT;
	}

	public Autoroute() {
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
			this.bornesEntrees.put(city, new BorneEntree(city));
		}
	}

	public boolean cityExist(String city) {
		return this.bornesSorties.containsKey(city);

	}
	
	public void printCities(){
		for( String city : this.bornesSorties.keySet()){
			System.out.println(city);
		}
	}
}
