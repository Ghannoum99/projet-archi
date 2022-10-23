package fr.isty.groupe5.ressources_ihm;

import fr.isty.groupe5.ressources_si.controleur.Controleur;

import javax.swing.*;

public class MenuAjouterCreneau extends MiniMenu {
    private JTextField debut;
    private JTextField fin;
    public MenuAjouterCreneau(String titre) {
        super(titre);

        ajouterDebut();
        ajouterFin();
    }

    private void ajouterDebut() {
        JLabel labelDebut = new JLabel("Début (dd/MM/aa - HH:mm) : ");
        labelDebut.setBounds(100, 50, 175, 30);
        panelPrincipal.add(labelDebut);

        debut = new JTextField();
        debut.setBounds(300, 50, 130, 30);
        panelPrincipal.add(debut);
    }

    private void ajouterFin() {
        JLabel labelFin = new JLabel("Fin (dd/MM/aa - HH:mm) : ");
        labelFin.setBounds(100, 150, 175, 30);
        panelPrincipal.add(labelFin);

        fin = new JTextField();
        fin.setBounds(300, 150, 130, 30);
        panelPrincipal.add(fin);
    }

    @Override
    public void ajouterActionBoutonValider() {
        boutonValider.addActionListener(e -> {
            if(debut.getText().isBlank() || fin.getText().isBlank()) {
                return;
            }
            Controleur.ajouterCreneau(Identifiant.genererIdentifiant(), debut.getText(), fin.getText());
            dispose();
        });
    }
}
