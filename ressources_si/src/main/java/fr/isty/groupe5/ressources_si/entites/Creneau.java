package fr.isty.groupe5.ressources_si.entites;

import java.io.Serializable;

public class Creneau implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long identifiant;
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
	
	public long getIdentifiant() { return identifiant; }
	public String getDebut() { return debut; }
	public String getFin() { return fin; }
	
	@Override
	public String toString() {
		return "Creneau [identifiant=" + identifiant + ", de " + debut + " jusqu'à " + fin + "]";
	}

}
