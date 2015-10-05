package peage.metier;

import java.io.BufferedReader;

public class Sortir implements PeageAction {

	public Sortir() {

	}

	public void action(BufferedReader br) {
		System.out.print("    --> nom de la sortie : ");
	}
}
