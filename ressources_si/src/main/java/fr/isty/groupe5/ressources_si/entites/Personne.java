package fr.isty.groupe5.ressources_si.entites;

import java.io.Serializable;

public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;    

    public enum Genre {HOMME, FEMME;}
    
    private long identifiant;
    private String prenom;
    private String nom;
    private int age;
    private Genre genre;
    
    public Personne(long identifiant, String nom, String prenom, int age, Genre genre) {
        if(nom.isBlank() || prenom.isBlank())
        {
            throw new AssertionError();
        }
        
        if(age <= 0)
        {
            throw new AssertionError();
        }

        if(genre != Genre.HOMME && genre != Genre.FEMME)
        {
            throw new AssertionError();
        }
        
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.genre = genre;
    }
    
    public long getIdentifiant() {return identifiant;}
    public String getPrenom() {return prenom;}
    public String getNom() {return nom;}
    public int getAge() {return age;}
    public Genre getGenre() {return genre;}
    
    @Override
    public String toString() {
        return "Personne [identifiant=" + identifiant + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", genre=" + genre + "]";
    }
    
}
