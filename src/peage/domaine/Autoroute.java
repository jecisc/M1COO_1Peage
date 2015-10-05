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
		Map<String, Integer> placesPrices = new HashMap<String, Integer>();
		String ligne, startPlace;
		int price;


			
			try {
				InputStream stream = new FileInputStream(PATH);
				InputStreamReader readStream = new InputStreamReader(stream);
				BufferedReader br = new BufferedReader(readStream);
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*while ((ligne = br.readLine()) != null) {
				if (ligne.split(" ")[1].equals(finishPlace)) {
					startPlace = ligne.split(" ")[0];
					price = Integer.parseInt(ligne.split(" ")[2]);
					placesPrices.put(startPlace, price);
				}
			}*/
	}
}
