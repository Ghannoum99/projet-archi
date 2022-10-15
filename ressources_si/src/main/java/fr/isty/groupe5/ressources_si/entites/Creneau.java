package fr.isty.groupe5.ressources_si.entites;

import java.io.Serializable;


public class Creneau implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long identifinat;
	private String debut;
	private String fin;
	
	@SuppressWarnings("unused") // Constructeur par défaut interdit
    private Creneau() {
        throw new RuntimeException();
    }
	
	public Creneau(String debut, String fin) {
		
        if(debut == null || fin == null) {
            throw new AssertionError();
        }
        
        this.debut = debut;
        this.fin = fin;
    }
	
	
	private long getIdentifiant() {
		return identifiant;
	}
	
	private String getDebut() {
		return debut;
	}
	
	private String getFin() {
		return fin;
	}
	
	@Override
	public String toString() {
		return "Creneau [identifiant=" + identifiant + ", de " + debut + " jusqu'à " + fin + "]";
	}

}
