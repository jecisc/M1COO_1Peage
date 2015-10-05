package peage.metier;

import java.io.BufferedReader;
import java.io.IOException;

public class Quitter implements PeageAction {

	public Quitter() {

	}

	public void action(BufferedReader br) throws IOException {
		br.close();
		System.out.print("Fin de l'application.");
		System.exit(0);
	}
}
