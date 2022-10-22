package fr.isty.groupe5.ressources_ihm;

import fr.isty.groupe5.ressources_si.Controleur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class MenuSupprimerPersonne extends MiniMenuSupprimer {
    private final JComboBox<Entites> personnes;
    private final ArrayList<Entites> listePersonnes;

    public MenuSupprimerPersonne(String titre) {
        super(titre);

        listePersonnes = (ArrayList<Entites>) Controleur.getPersonneRepo().stream().map(personne -> { return new Entites(personne.getNom() + " " + personne.getPrenom(), personne.getIdentifiant()); }).collect(Collectors.toList());
        personnes = new JComboBox<>();
        for(Entites personne: listePersonnes) {
            personnes.addItem(personne);
        }
        personnes.setBounds(150, 50, 130, 27);
        panelPrincipal.add(personnes);
    }

    @Override
    public void ajouterActionBoutonSupprimer() {
        boutonSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(listePersonnes.isEmpty()) {
                    return;
                }
                Controleur.supprimerPersonne(((Entites) Objects.requireNonNull(personnes.getSelectedItem())).valeur());
                dispose();
            }
        });
    }
}
