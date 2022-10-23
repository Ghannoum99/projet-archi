package fr.isty.groupe5.ressources_ihm;

import javax.swing.*;

import fr.isty.groupe5.ressources_si.controleur.Controleur;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class MenuSupprimerPersonne extends MiniMenuSupprimer {
    private final JComboBox<Entites> personnes;
    private final ArrayList<Entites> listePersonnes;

    public MenuSupprimerPersonne(String titre) {
        super(titre);

        listePersonnes = Controleur.getPersonneRepo().stream().map(personne -> new Entites(personne.getNom() + " " + personne.getPrenom(), personne.getIdentifiant())).collect(Collectors.toCollection(ArrayList::new));
        personnes = new JComboBox<>();
        for (Entites personne : listePersonnes) {
            personnes.addItem(personne);
        }
        personnes.setBounds(150, 50, 130, 27);
        panelPrincipal.add(personnes);
    }

    @Override
    public void ajouterActionBoutonSupprimer() {
        boutonSupprimer.addActionListener(e -> {
            if (listePersonnes.isEmpty()) {
                return;
            }
            Controleur.supprimerPersonne(((Entites) Objects.requireNonNull(personnes.getSelectedItem())).valeur());
            dispose();
        });
    }
}
