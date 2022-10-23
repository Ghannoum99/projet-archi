package fr.isty.groupe5.ressources_ihm;

import javax.swing.*;

import fr.isty.groupe5.ressources_si.controleur.Controleur;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class MenuSupprimerSalle extends MiniMenuSupprimer {
    private final JComboBox<Entite> salles;
    private final ArrayList<Entite> listeSalles;

    public MenuSupprimerSalle(String titre) {
        super(titre);

        listeSalles = Controleur.getSalleRepo().stream().map(salle -> new Entite(salle.getNom() + " (" + salle.getCapacite() + ")", salle.getIdentifiant())).collect(Collectors.toCollection(ArrayList::new));
        salles = new JComboBox<>();
        for (Entite salle : listeSalles) {
            salles.addItem(salle);
        }
        salles.setBounds(150, 50, 130, 27);
        panelPrincipal.add(salles);
    }

    @Override
    public void ajouterActionBoutonSupprimer() {
        boutonSupprimer.addActionListener(e -> {
            if (listeSalles.isEmpty()) {
                return;
            }
            Controleur.supprimerSalle(((Entite) Objects.requireNonNull(salles.getSelectedItem())).valeur());
            dispose();
        });
    }
}
