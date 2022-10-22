package fr.isty.groupe5.ressources_si.entites;

import java.util.ArrayList;
import java.util.stream.Collectors;

import fr.isty.groupe5.ressources_si.persistance.Sauvegarde;

public class SalleRepo {

    private static final String NOM_FICHIER = "salles.dat";
    private static ArrayList<Salle> repo = new ArrayList<>();
    
    public static ArrayList<Salle> repo() {
        return repo;
    }
    
    public static Salle getSalle(long identifiant) {
        return repo.stream().filter(salle -> salle.getIdentifiant() == identifiant).limit(1).collect(Collectors.toList()).get(0); 
    }

    public static void ajouter(Salle salle) {
        repo.add(salle);
    }

    public static void supprimer(long identifiant) {
        repo.removeIf(salle -> (salle.getIdentifiant() == identifiant) );
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
