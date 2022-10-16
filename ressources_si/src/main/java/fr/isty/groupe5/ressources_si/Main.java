package fr.isty.groupe5.ressources_si;

import fr.isty.groupe5.ressources_si.entites.*;

import java.util.ArrayList;

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
		SalleRepo.sauvegarder();
		SalleRepo.raz();
		System.out.println(SalleRepo.repo());
		SalleRepo.charger();
		System.out.println(SalleRepo.repo());
		SalleRepo.supprimerFichier();

		// Test Reservation
		ArrayList<Creneau> creneaux = new ArrayList<>();
		creneaux.add(new Creneau("12:45", "13:45"));
		creneaux.add(new Creneau("15:00", "17:00"));
		ReservationRepo.ajouter(new Reservation(
				new Salle("S12", 15),
				creneaux,
				"Jacques Tea"
		));
		ReservationRepo.ajouter(new Reservation(
				new Salle("113", 30),
				creneaux,
				"Alex6 Raffière"
		));

		System.out.println(ReservationRepo.repo().toString());
		ReservationRepo.sauvegarder();
		ReservationRepo.raz();
		System.out.println(ReservationRepo.repo().toString());
		ReservationRepo.charger();
		System.out.println(ReservationRepo.repo().toString());
		ReservationRepo.supprimerFichier();
	}

}
