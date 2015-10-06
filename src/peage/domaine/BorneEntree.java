package peage.domaine;

import peage.factory.Distributeur;

public class BorneEntree extends AbstractBorne {

	protected Distributeur distributeur;

	public BorneEntree(String city) {
		super(city);
	}

	public void distributeur(Distributeur distributeur) {
		this.distributeur = distributeur;
	}

	public Ticket getTicket() {
		return this.distributeur.generateTicketFor(this.city);
	}

}
