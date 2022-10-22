package fr.isty.groupe5.ressources_ihm;

import fr.isty.groupe5.ressources_si.Controleur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class MenuSupprimerSalle extends MiniMenuSupprimer {
    private final JComboBox<Entites> salles;
    private final ArrayList<Entites> listeSalles;

    public MenuSupprimerSalle(String titre) {
        super(titre);

        listeSalles = (ArrayList<Entites>) Controleur.getSalleRepo().stream().map(salle -> { return new Entites(salle.getNom(), salle.getIdentifiant()); }).collect(Collectors.toList());
        salles = new JComboBox<>();
        for(Entites salle: listeSalles) {
            salles.addItem(salle);
        }
        salles.setBounds(150, 50, 130, 27);
        panelPrincipal.add(salles);
    }

    @Override
    public void ajouterActionBoutonSupprimer() {
        boutonSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(listeSalles.isEmpty()) {
                    return;
                }
                Controleur.supprimerSalle(((Entites) Objects.requireNonNull(salles.getSelectedItem())).valeur());
                dispose();
            }
        });
    }
}
