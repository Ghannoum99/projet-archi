package fr.isty.groupe5.ressources_si;

import fr.isty.groupe5.ressources_si.entites.Salle;
import fr.isty.groupe5.ressources_si.entites.SalleRepo;

public class Main {

	public static void main(String[] args) {
		System.out.println("Lancement du main");
		try {
			SalleRepo.ajouter(new Salle("S11", -1));
		} catch (final AssertionError e) {
			System.err.println("Salle invalide");
		}
		SalleRepo.ajouter(new Salle("S11", 60));
		System.out.println(SalleRepo.repo());
	}

}
