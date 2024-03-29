package fr.isty.groupe5.ressources_si.entites;

import java.util.ArrayList;
import java.util.stream.Collectors;

import fr.isty.groupe5.ressources_si.persistance.Sauvegarde;

public class CreneauRepo {

    private static final String NOM_FICHIER = "creneaux.dat";
    private static ArrayList<Creneau> repo = new ArrayList<>();

    public static ArrayList<Creneau> repo() {
        return repo;
    }

    public static Creneau getCreneau(long identifiant) {
        return repo.stream().filter(creneau -> creneau.getIdentifiant() == identifiant).limit(1).collect(Collectors.toList()).get(0);
    }

    public static void ajouter(Creneau creneau) {
        repo.add(creneau);
    }

    public static void supprimer(long identifiant) {
        repo.removeIf(creneau -> (creneau.getIdentifiant() == identifiant));
    }

    public static void raz() {
        repo = new ArrayList<>();
    }

    public static void sauvegarder() {
        Sauvegarde.enregistrer(repo, NOM_FICHIER);
    }

    @SuppressWarnings("unchecked")
    public static void charger() {
        repo = (ArrayList<Creneau>) Sauvegarde.charger(NOM_FICHIER);
    }

    public static void supprimerFichier() {
        Sauvegarde.supprimer(NOM_FICHIER);
    }
}
