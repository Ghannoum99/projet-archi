package fr.isty.groupe5.ressources_si.entites;

import java.util.ArrayList;
import java.util.stream.Collectors;

import fr.isty.groupe5.ressources_si.persistance.Sauvegarde;

public class PersonneRepo {

    private static final String NOM_FICHIER = "personnes.dat";
    private static ArrayList<Personne> repo = new ArrayList<>();

    public static ArrayList<Personne> repo() {
        return repo;
    }

    public static Personne getPersonne(long identifiant) {
        return repo.stream().filter(personne -> personne.getIdentifiant() == identifiant).limit(1).collect(Collectors.toList()).get(0);
    }

    public static void ajouter(Personne personne) {
        repo.add(personne);
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
        repo = (ArrayList<Personne>) Sauvegarde.charger(NOM_FICHIER);
    }

    public static void supprimerFichier() {
        Sauvegarde.supprimer(NOM_FICHIER);
    }
}
