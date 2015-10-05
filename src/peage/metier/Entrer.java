package peage.metier;

import java.io.BufferedReader;

public class Entrer implements PeageAction {

	public Entrer() {

	}

	public void action(BufferedReader br) {
		System.out.print("    --> nom de l'entrée : ");
	}
}
