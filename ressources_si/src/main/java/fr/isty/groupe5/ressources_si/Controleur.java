package fr.isty.groupe5.ressources_si;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.isty.groupe5.ressources_si.entites.Creneau;
import fr.isty.groupe5.ressources_si.entites.CreneauRepo;
import fr.isty.groupe5.ressources_si.entites.Personne;
import fr.isty.groupe5.ressources_si.entites.Personne.Genre;
import fr.isty.groupe5.ressources_si.entites.PersonneRepo;
import fr.isty.groupe5.ressources_si.entites.Reservation;
import fr.isty.groupe5.ressources_si.entites.ReservationRepo;
import fr.isty.groupe5.ressources_si.entites.Salle;
import fr.isty.groupe5.ressources_si.entites.SalleRepo;

public class Controleur {

	/* Méthodes liées aux créneaux */
	public static ArrayList<Creneau> getCreneauRepo() {
		return CreneauRepo.repo();
	}

	public static Creneau accederCreneau(long identifiant) {
		return CreneauRepo.getCreneau(identifiant);
	}

	public static void ajouterCreneau(long identifiant, String debut, String fin) {
		CreneauRepo.ajouter(new Creneau(identifiant, debut, fin));
	}

	public static void supprimerCreneau(long identifiant) {
		CreneauRepo.supprimer(identifiant);
	}

	public static void razCreneaux() {
		CreneauRepo.raz();
	}

	public static void sauvegarderFichierCreneaux() {
		CreneauRepo.sauvegarder();
	}

	public static void chargerFichierCreneaux() {
		CreneauRepo.charger();
	}

	public static void supprimerFichierCreneaux() {
		CreneauRepo.supprimerFichier();
	}

	public static void afficherCreneauxString() {
		System.out.println(CreneauRepo.repo().toString());
	} // pour débugger

	/* Méthodes liées aux personnes */
	public static ArrayList<Personne> getPersonneRepo() {
		return PersonneRepo.repo();
	}

	public static Personne accederPersonne(long identifiant) {
		return PersonneRepo.getPersonne(identifiant);
	}

	public static void ajouterPersonne(long identifiant, String nom, String prenom, int age, String genre) {
		PersonneRepo.ajouter(new Personne(identifiant, nom, prenom, age, Genre.valueOf(genre)));
	}

	public static void supprimerPersonne(long identifiant) {
		PersonneRepo.supprimer(identifiant);
	}

	public static void razPersonnes() {
		PersonneRepo.raz();
	}

	public static void sauvegarderFichierPersonnes() {
		PersonneRepo.sauvegarder();
	}

	public static void chargerFichierPersonnes() {
		PersonneRepo.charger();
	}

	public static void supprimerFichierPersonnes() {
		PersonneRepo.supprimerFichier();
	}

	public static void afficherPersonnesString() {
		System.out.println(PersonneRepo.repo().toString());
	} // pour débugger

	public static ArrayList<String> getGenres() {
		return new ArrayList<>(Stream.of(Genre.values()).map(Genre::name).collect(Collectors.toList()));
	}

	/* Méthodes liées aux réservations */
	public static ArrayList<Reservation> getReservationRepo() {
		return ReservationRepo.repo();
	}

	public static Reservation accederReservation(long identifiant) {
		return ReservationRepo.getReservation(identifiant);
	}

	public static void ajouterReservation(long identifiant, Salle salle, ArrayList<Creneau> creneaux,
			Personne personne) {
		ReservationRepo.ajouter(new Reservation(identifiant, salle, creneaux, personne));
	}

	public static void supprimerReservation(long identifiant) {
		ReservationRepo.supprimer(identifiant);
	}

	public static void razReservations() {
		ReservationRepo.raz();
	}

	public static void sauvegarderFichierReservations() {
		ReservationRepo.sauvegarder();
	}

	public static void chargerFichierReservations() {
		ReservationRepo.charger();
	}

	public static void supprimerFichierReservations() {
		ReservationRepo.supprimerFichier();
	}

	public static void afficherReservationsString() {
		System.out.println(ReservationRepo.repo().toString());
	} // pour débugger

	/* Méthodes liées aux salles */
	public static ArrayList<Salle> getSalleRepo() {
		return SalleRepo.repo();
	}

	public static Salle accederSalle(long identifiant) {
		return SalleRepo.getSalle(identifiant);
	}

	public static void ajouterSalle(long identifiant, String nom, int capacite) {
		SalleRepo.ajouter(new Salle(identifiant, nom, capacite));
	}

	public static void supprimerSalle(long identifiant) {
		SalleRepo.supprimer(identifiant);
	}

	public static void razSalles() {
		SalleRepo.raz();
	}

	public static void sauvegarderFichierSalles() {
		SalleRepo.sauvegarder();
	}

	public static void chargerFichierSalles() {
		SalleRepo.charger();
	}

	public static void supprimerFichierSalles() {
		SalleRepo.supprimerFichier();
	}

	public static void afficherSallesString() {
		System.out.println(SalleRepo.repo().toString());
	} // pour débugger

}
