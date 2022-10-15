package fr.isty.groupe5.ressources_si.entites;

import java.util.ArrayList;

public class SalleRepo {

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

}
