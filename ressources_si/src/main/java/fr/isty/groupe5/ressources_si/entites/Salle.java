package fr.isty.groupe5.ressources_si.entites;

public class Salle {

	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Salle [nom=" + nom + "]";
	}

}
