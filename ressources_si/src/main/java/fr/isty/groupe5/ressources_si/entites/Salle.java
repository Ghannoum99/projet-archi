package fr.isty.groupe5.ressources_si.entites;

import java.io.Serializable;

public class Salle implements Serializable {

	private static final long serialVersionUID = 1L;

	private long identifiant;
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

	public long getIdentifiant() { return identifiant; }
	public String getNom() { return nom; }
	public int getCapacite() { return capacite; }

	@Override
	public String toString() {
		return "Salle [identifiant=" + identifiant + ", nom=" + nom + ", capacite=" + capacite + "]";
	}

}
