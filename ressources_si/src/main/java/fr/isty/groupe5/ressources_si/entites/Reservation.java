package fr.isty.groupe5.ressources_si.entites;

import java.io.Serializable;
import java.util.ArrayList;

public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;

    private long identifiant;
    private Salle salle;
    private ArrayList<Creneau> creneaux;
    private Personne personne;

    @SuppressWarnings("unused") // Constructeur par défaut interdit
    private Reservation() {
        throw new RuntimeException();
    }

    public Reservation(long identifiant, Salle salle, ArrayList<Creneau> creneaux, Personne personne) {
        if(salle == null || creneaux.isEmpty() || personne == null) {
            throw new AssertionError();
        }
        
        this.identifiant = identifiant;
        this.salle = salle;
        this.creneaux = creneaux;
        this.personne = personne;
    }

    public long getIdentifiant() { return identifiant; }
    public Salle getSalle() { return salle; }
    public ArrayList<Creneau> getCreneaux() { return creneaux; }
    public void setCreneaux(ArrayList<Creneau> creneaux) { this.creneaux = creneaux; }
    public Personne getPersonne() { return personne; }

    @Override
    public String toString() {
        return "\n" + salle.toString() + "\n" + creneaux.toString() + "\n" + personne.toString() + "\n";
    }
}
