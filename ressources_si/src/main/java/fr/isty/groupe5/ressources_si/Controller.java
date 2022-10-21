package fr.isty.groupe5.ressources_si;

import java.util.ArrayList;

import fr.isty.groupe5.ressources_si.entites.*;
import fr.isty.groupe5.ressources_si.entites.Personne.Genre;

public class Controller {
    
    /* Méthodes liées aux créneaux */
    public static void ajouterCreneau(String debut, String fin) { CreneauRepo.ajouter(new Creneau(debut, fin)); }
    public static void supprimerCreneau(long identifiant) { CreneauRepo.supprimer(identifiant); }
    public static void razCreneaux() { CreneauRepo.raz(); }
    public static void sauvegarderFichierCreneaux() { CreneauRepo.sauvegarder(); }
    public static void chargerFichierCreneaux() { CreneauRepo.charger(); }
    public static void supprimerFichierCreneaux() { CreneauRepo.supprimerFichier(); }
    public static void afficherCreneauxString() { System.out.println(CreneauRepo.repo().toString()); } //pour débugger
    
    /* Méthodes liées aux personnes */
    public static void ajouterPersonne(String nom, String prenom, int age, Genre genre) { PersonneRepo.ajouter(new Personne(nom, prenom, age, genre)); }
    public static void supprimerPersonne(long identifiant) { PersonneRepo.supprimer(identifiant); }
    public static void razPersonnes() { PersonneRepo.raz(); }
    public static void sauvegarderFichierPersonnes() { PersonneRepo.sauvegarder(); }
    public static void chargerFichierPersonnes() { PersonneRepo.charger(); }
    public static void supprimerFichierPersonnes() { PersonneRepo.supprimerFichier(); }
    public static void afficherPersonnesString() { System.out.println(PersonneRepo.repo().toString()); } //pour débugger
    
    /* Méthodes liées aux réservations */
    public static void ajouterReservation(Salle salle, ArrayList<Creneau> creneaux, Personne personne) { ReservationRepo.ajouter(new Reservation(salle, creneaux, personne)); }
    public static void supprimerReservation(long identifiant) { ReservationRepo.supprimer(identifiant); }
    public static void razReservations() { ReservationRepo.raz(); }
    public static void sauvegarderFichierReservations() { ReservationRepo.sauvegarder(); }
    public static void chargerFichierReservations() { ReservationRepo.charger(); }
    public static void supprimerFichierReservations() { ReservationRepo.supprimerFichier(); }
    public static void afficherReservationsString() { System.out.println(ReservationRepo.repo().toString()); } //pour débugger
    
    /* Méthodes liées aux salles */
    public static void ajouterSalle(String nom, int capacite) { SalleRepo.ajouter(new Salle(nom, capacite)); }
    public static void supprimerSalle(long identifiant) { SalleRepo.supprimer(identifiant); }
    public static void razSalles() { SalleRepo.raz(); }
    public static void sauvegarderFichierSalles() { SalleRepo.sauvegarder(); }
    public static void chargerFichierSalles() { SalleRepo.charger(); }
    public static void supprimerFichierSalles() { SalleRepo.supprimerFichier(); }
    public static void afficherSallesString() { System.out.println(SalleRepo.repo().toString()); } //pour débugger
    
}
