package fr.isty.groupe5.ressources_ihm;

public class Entite {
    private final String libelle;
    private final long valeur;

    public Entite(String libelle, long valeur) {
        this.libelle = libelle;
        this.valeur = valeur;
    }

    public String libelle() {
        return this.libelle;
    }

    public long valeur() {
        return this.valeur;
    }

    @Override
    public String toString() {
        return libelle;
    }

}
