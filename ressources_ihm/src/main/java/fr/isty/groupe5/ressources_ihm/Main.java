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

        System.out.println(Controller.getGenres());
        Controller.ajouterPersonne(0, "VIDAL", "Antoine", 23, "HOMME");
        Controller.afficherPersonnesString();
        
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
