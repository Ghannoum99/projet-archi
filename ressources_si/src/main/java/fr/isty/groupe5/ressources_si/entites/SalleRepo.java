package fr.isty.groupe5.ressources_si.entites;

import java.util.ArrayList;

import fr.isty.groupe5.ressources_si.persistance.Sauvegarde;

public class SalleRepo {

	private static final String NOM_FICHIER = "salles.dat";
	private static ArrayList<Salle> repo = new ArrayList<>();

	public static ArrayList<Salle> repo() {
		return repo;
	}

	public static void ajouter(Salle salle) {
		repo.add(salle);
	}

	public static void supprimer(Salle salle) {
		repo.remove(salle);
	}

	public static void raz() {
		repo = new ArrayList<>();
	}

	public static void sauvegarder() {
		Sauvegarde.enregistrer(repo, NOM_FICHIER);
	}

	@SuppressWarnings("unchecked")
	public static void charger() {
		repo = (ArrayList<Salle>) Sauvegarde.charger(NOM_FICHIER);
	}

	public static void supprimerFichier() {
		Sauvegarde.supprimer(NOM_FICHIER);
	}

}
