package fr.isty.groupe5.ressources_si.entites;

public class Salle {

	private String nom;
	private int capacite;

	@SuppressWarnings("unused") // Constructeur par défaut interdit
	private Salle() {
		throw new RuntimeException();
	}

	public Salle(String nom, int capacite) {
		if (nom.isBlank() || (capacite < 0)) {
			throw new AssertionError();
		}
		this.nom = nom;
		this.capacite = capacite;

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	@Override
	public String toString() {
		return "Salle [nom=" + nom + ", capacite=" + capacite + "]";
	}

}
