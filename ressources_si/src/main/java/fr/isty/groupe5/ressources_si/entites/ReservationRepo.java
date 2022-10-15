package fr.isty.groupe5.ressources_si.entites;

import fr.isty.groupe5.ressources_si.persistance.Sauvegarde;

import java.util.ArrayList;

public class ReservationRepo {
    private static final String NOM_FICHIER = "reservations.dat";

    private static ArrayList<Reservation> repo = new ArrayList<>();

    public static ArrayList<Reservation> repo() {
        return repo;
    }

    public static void ajouter(Reservation reservation) {
        repo.add(reservation);
    }

    public static void supprimer(Reservation reservation) {
        repo.remove(reservation);
    }

    public static void raz() {
        repo = new ArrayList<>();
    }

    public static void sauvegarder() {
        Sauvegarde.enregistrer(repo, NOM_FICHIER);
    }

    @SuppressWarnings("unchecked")
    public static void charger() {
        repo = (ArrayList<Reservation>) Sauvegarde.charger(NOM_FICHIER);
    }

    public static void supprimerFichier() {
        Sauvegarde.supprimer(NOM_FICHIER);
    }
}
