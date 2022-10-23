package fr.isty.groupe5.ressources_ihm;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.swing.*;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import fr.isty.groupe5.ressources_si.controleur.Controleur;

public class MenuReservation extends MiniMenu {
    private JComboBox<Entites> listeSalles;
    private JComboBox<Entites> listePersonnes;
    private JList<Entites> listeCreneaux;

    public MenuReservation(String titre) {
        super(titre);

        afficherListeSalles();
        afficherListePersonnes();
        afficherCreneaux();
    }

    public void afficherListeSalles() {
        JLabel labelSalle = DefaultComponentFactory.getInstance().createLabel("Salle :");
        labelSalle.setFont(new Font("Arial", Font.PLAIN, 13));
        labelSalle.setBounds(21, 33, 52, 27);
        this.panelPrincipal.add(labelSalle);

        ArrayList<Entites> salles = Controleur.getSalleRepo().stream().map(salle -> new Entites(salle.getNom() + " (" + salle.getCapacite() + ")", salle.getIdentifiant())).collect(Collectors.toCollection(ArrayList::new));
        listeSalles = new JComboBox<>();
        for (Entites salle : salles) {
            listeSalles.addItem(salle);
        }
        listeSalles.setBounds(123, 33, 124, 27);
        this.panelPrincipal.add(listeSalles);
    }

    public void afficherListePersonnes() {
        JLabel labelPersonne = DefaultComponentFactory.getInstance().createLabel("Personne :");
        labelPersonne.setFont(new Font("Arial", Font.PLAIN, 13));
        labelPersonne.setBounds(21, 83, 74, 16);
        this.panelPrincipal.add(labelPersonne);

        ArrayList<Entites> personnes = Controleur.getPersonneRepo().stream().map(personne -> new Entites(personne.getNom() + " " + personne.getPrenom(), personne.getIdentifiant())).collect(Collectors.toCollection(ArrayList::new));
        listePersonnes = new JComboBox<>();
        for(Entites personne: personnes) {
            listePersonnes.addItem(personne);
        }
        listePersonnes.setBounds(123, 83, 124, 27);
        this.panelPrincipal.add(listePersonnes);
    }

    private void afficherCreneaux() {
        JLabel labelCreneaux = new JLabel("Créneaux : ");
        labelCreneaux.setFont(new Font("Arial", Font.PLAIN, 13));
        labelCreneaux.setBounds(270, 38, 74, 16);
        this.panelPrincipal.add(labelCreneaux);

        DefaultListModel<Entites> model = new DefaultListModel<>();
        ArrayList<Entites> creneaux = Controleur.getCreneauRepo().stream().map(creneau -> new Entites(creneau.getDebut() + " - " + creneau.getFin(), creneau.getIdentifiant())).collect(Collectors.toCollection(ArrayList::new));
        model.addAll(creneaux);
        listeCreneaux = new JList<>(model);
        this.panelPrincipal.add(listeCreneaux);
        listeCreneaux.setBounds(350, 38, 200, 200);
    }

    @Override
    public void ajouterActionBoutonValider() {
        boutonValider.addActionListener(e -> {
            if (!listeSalles.isValid() || !listePersonnes.isValid() || !listeCreneaux.isValid()) {
                return;
            }
            Controleur.ajouterReservation(Identifiant.genererIdentifiant(), ((Entites) Objects.requireNonNull(listeSalles.getSelectedItem())).valeur(), listeCreneaux.getSelectedValuesList().stream().map(Entites::valeur).collect(Collectors.toCollection(ArrayList::new)), ((Entites) Objects.requireNonNull(listePersonnes.getSelectedItem())).valeur());
            dispose();
        });
    }
}