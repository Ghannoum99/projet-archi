package fr.isty.groupe5.ressources_ihm;

import java.awt.EventQueue;
import java.util.ArrayList;
import fr.isty.groupe5.ressources_si.Controller;
import fr.isty.groupe5.ressources_si.entites.*;
import fr.isty.groupe5.ressources_si.entites.Personne.Genre;

public class Main {

	public static void main(String[] args) {
	    /*
	    //Test controller
	    Personne personne = new Personne("VIDAL", "Antoine", 23, Genre.HOMME);
	    Personne personne2 = new Personne("a", "b", 45, Genre.FEMME);
	    
	    Controller.ajouterPersonne(personne.getNom(), personne.getPrenom(), personne.getAge(), personne.getGenre());
	    Controller.ajouterPersonne(personne2.getNom(), personne2.getPrenom(), personne2.getAge(), personne2.getGenre());
	    Controller.afficherPersonnesString();
	    Controller.sauvegarderFichierPersonnes();
	    Controller.razPersonnes();
	    Controller.afficherPersonnesString();
	    Controller.chargerFichierPersonnes();
	    Controller.afficherPersonnesString();
	    Controller.supprimerFichierPersonnes();
	    System.out.println();
	    
	    Controller.ajouterCreneau("12:00", "13:00");
	    Controller.ajouterCreneau("16:00", "17:00");
        Controller.afficherCreneauxString();
        System.out.println();
        
	    Controller.ajouterReservation(new Salle("bonjour", 50), CreneauRepo.repo(), personne);
	    Controller.afficherReservationsString();
        //Fin Test controller
*/

		EventQueue.invokeLater(() -> {
			try {
				final MenuPrincipal frame = new MenuPrincipal();
				frame.setVisible(true);
			} catch (final Exception e) {
				e.printStackTrace();
			}
		});

	}
}
