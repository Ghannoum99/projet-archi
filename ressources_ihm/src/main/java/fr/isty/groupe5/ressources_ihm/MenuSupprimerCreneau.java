package fr.isty.groupe5.ressources_ihm;

import javax.swing.*;

import fr.isty.groupe5.ressources_si.controleur.Controleur;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class MenuSupprimerCreneau extends MiniMenuSupprimer {
    private final JComboBox<Entites> creneaux;
    private final ArrayList<Entites> listeCreneaux;

    public MenuSupprimerCreneau(String titre) {
        super(titre);

        listeCreneaux = Controleur.getCreneauRepo().stream().map(creneau -> new Entites(creneau.getDebut() + " - " + creneau.getFin(), creneau.getIdentifiant())).collect(Collectors.toCollection(ArrayList::new));
        creneaux = new JComboBox<>();
        for (Entites creneau : listeCreneaux) {
            creneaux.addItem(creneau);
        }
        creneaux.setBounds(150, 50, 130, 27);
        panelPrincipal.add(creneaux);
    }

    @Override
    public void ajouterActionBoutonSupprimer() {
        boutonSupprimer.addActionListener(e -> {
            if (listeCreneaux.isEmpty()) {
                return;
            }
            Controleur.supprimerCreneau(((Entites) Objects.requireNonNull(creneaux.getSelectedItem())).valeur());
            dispose();
        });
    }
}
