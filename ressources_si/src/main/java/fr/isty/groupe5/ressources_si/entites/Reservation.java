package fr.isty.groupe5.ressources_si.entites;

import java.io.Serializable;
import java.util.ArrayList;

public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;

    private long identifiant;
    private Salle salle;
    private ArrayList<Creneau> creneaux;
    //@todo: Mettre la classe Personne
    private String personne;

    @SuppressWarnings("unused") // Constructeur par défaut interdit
    private Reservation() {
        throw new RuntimeException();
    }

    public Reservation(Salle salle, ArrayList<Creneau> creneaux, String personne) {
        if(salle == null || creneaux.isEmpty()) {
            throw new AssertionError();
        }
        this.salle = salle;
        this.creneaux = creneaux;
        this.personne = personne;
    }

    public long getIdentifiant() { return identifiant; }
    public ArrayList<Creneau> getCreneaux() { return creneaux; }
    public String getPersonne() { return personne; }
}