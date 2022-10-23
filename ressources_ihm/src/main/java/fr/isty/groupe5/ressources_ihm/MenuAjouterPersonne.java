package fr.isty.groupe5.ressources_ihm;

import javax.swing.*;

import fr.isty.groupe5.ressources_si.controleur.Controleur;

import java.util.ArrayList;
import java.util.Objects;

public class MenuAjouterPersonne extends MiniMenu {

    private JTextField nom;
    private JTextField age;
    private JTextField prenom;
    private JComboBox<String> genre;

    public MenuAjouterPersonne(String titre) {
        super(titre);

        afficherNom();
        afficherPrenom();
        afficherAge();
        afficherGenre();

    }

    public void afficherNom() {
        JLabel labelNom = new JLabel("Nom :");
        labelNom.setBounds(34, 39, 61, 16);
        panelPrincipal.add(labelNom);

        nom = new JTextField();
        nom.setBounds(107, 34, 130, 26);
        panelPrincipal.add(nom);
        nom.setColumns(10);
    }

    public void afficherPrenom() {
        JLabel labelPrenom = new JLabel("Prenom :");
        labelPrenom.setBounds(318, 39, 61, 16);
        panelPrincipal.add(labelPrenom);

        prenom = new JTextField();
        prenom.setBounds(391, 34, 130, 26);
        panelPrincipal.add(prenom);
        prenom.setColumns(10);
    }

    public void afficherAge() {
        JLabel labelAge = new JLabel("Age :");
        labelAge.setBounds(34, 134, 61, 16);
        panelPrincipal.add(labelAge);

        JLabel labelGenre = new JLabel("Genre :");
        labelGenre.setBounds(318, 134, 61, 16);
        panelPrincipal.add(labelGenre);
    }

    public void afficherGenre() {
        age = new JTextField();
        age.setBounds(107, 129, 130, 26);
        panelPrincipal.add(age);
        age.setColumns(10);

        ArrayList<String> listeGenre = Controleur.getGenres();
        genre = new JComboBox<>();
        for (String valeur : listeGenre) {
            genre.addItem(valeur);
        }
        genre.setBounds(391, 130, 130, 27);
        panelPrincipal.add(genre);
    }

    @Override
    public void ajouterActionBoutonValider() {
        boutonValider.addActionListener(e -> {
            int valeurAge = Integer.parseInt(age.getText());
            if (nom.getText().isBlank() || prenom.getText().isBlank() || valeurAge <= 0 || !genre.isValid()) {
                return;
            }
            Controleur.ajouterPersonne(Identifiant.genererIdentifiant(), nom.getText(), prenom.getText(), valeurAge, Objects.requireNonNull(genre.getSelectedItem()).toString());
            dispose();
        });
    }
}