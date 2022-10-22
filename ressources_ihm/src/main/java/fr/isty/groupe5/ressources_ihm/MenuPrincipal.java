package fr.isty.groupe5.ressources_ihm;

import fr.isty.groupe5.ressources_si.Controleur;

import javax.swing.*;
import java.awt.*;


public class MenuPrincipal extends JFrame {

	private final JPanel panelPrincipal;
	private final JPanel panelMenu;
	private final JPanel panelGauche;
	private JTable tableReservations;
	private String listeReservations;

	public MenuPrincipal() {
		this.setTitle("Groupe 5 - IATIC 5");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1100, 781);

		final Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		final GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		if (device.isFullScreenSupported() && size.getHeight() <= 720) {
			device.setFullScreenWindow(this);

		}

		/* PANEL PRINCIPAL DE LA FENETRE **/
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(238, 238, 238));
		panelPrincipal.setForeground(Color.WHITE);
		panelPrincipal.setBounds(0, 0, 1100, 767);
		getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);

		/* PANEL QUI CONTIENT TOUS LE TITRE ET LES BOUTONS **/
		panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 1100, 71);
		panelMenu.setBackground(new Color(232, 232, 232));
		panelPrincipal.add(panelMenu);
		panelMenu.setLayout(null);

		/* PANEL CONTENANT LES SALLES RESERVEES **/
		panelGauche = new JPanel();
		panelGauche.setBounds(0, 74, 200, 679);
		panelGauche.setBackground(new Color(220, 220, 220));
		panelPrincipal.add(panelGauche);
		panelGauche.setLayout(null);

		afficherTitre();
		afficherBoutonNewBooking();
		afficherBoutonAjouterPersonne();
		afficherBoutonAjouterSalle();
		afficherBoutonCharger();
		afficherBoutonSauvegarder();
		afficherBoutonSupprimerSalle();
		afficherBoutonSupprimerPersonne();
		afficherBoutonSupprimerCreneau();
		afficherTableauReservation();
	}

	/* FONCTION PERMETTANT D'AFFICHER LE BOUTON : NOUVELLE RESERVATION **/
	/* CE BOUTON NOUS PERMETTRA D'AJOUTER UNE RESERVATION **/
	public void afficherBoutonNewBooking() {
		JButton boutonAjouterReservation = new JButton();
		boutonAjouterReservation.setBounds(100, 12, 200, 47);
		boutonAjouterReservation.setText("Ajouter une réservation");
		boutonAjouterReservation.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		boutonAjouterReservation.setBackground(new Color(46, 204, 113));
		boutonAjouterReservation.addActionListener(e -> {
			MenuReservation menuReservation = new MenuReservation("Nouvelle réservation");
			menuReservation.setVisible(true);
		});
		boutonAjouterReservation.setHorizontalTextPosition(JButton.CENTER);
		panelMenu.add(boutonAjouterReservation);

	}

	public void afficherBoutonAjouterPersonne() {
		JButton boutonAjouterPersonne = new JButton();
		boutonAjouterPersonne.setBounds(497, 18, 143, 38);
		boutonAjouterPersonne.setText("Ajouter une Personne");
		boutonAjouterPersonne.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonAjouterPersonne.addActionListener(e -> {
			MenuAjouterPersonne menuAjouterPersonne = new MenuAjouterPersonne("Nouvelle Personne");
			menuAjouterPersonne.setVisible(true);
		});
		boutonAjouterPersonne.setBackground(new Color(166, 166, 166));
		boutonAjouterPersonne.setHorizontalTextPosition(JButton.CENTER);
		boutonAjouterPersonne.setOpaque(true);
		panelMenu.add(boutonAjouterPersonne);

	}

	public void afficherBoutonAjouterSalle() {
		JButton boutonAjouterSalle = new JButton();
		boutonAjouterSalle.setBounds(341, 18, 143, 38);
		boutonAjouterSalle.setText("Ajouter une Salle");
		boutonAjouterSalle.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonAjouterSalle.setBackground(new Color(166, 166, 166));
		boutonAjouterSalle.addActionListener(e -> {
			MenuAjouterSalle menuAjouterSalle = new MenuAjouterSalle("Nouvelle Salle");
			menuAjouterSalle.setVisible(true);
		});
		boutonAjouterSalle.setHorizontalTextPosition(JButton.CENTER);
		boutonAjouterSalle.setOpaque(true);
		panelMenu.add(boutonAjouterSalle);
	}

	public void afficherBoutonCharger() {
		JButton boutonCharger = new JButton();
		boutonCharger.setBounds(653, 18, 143, 38);
		boutonCharger.setText("Charger");
		boutonCharger.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonCharger.addActionListener(e -> {
			Controleur.chargerFichierCreneaux();
			Controleur.chargerFichierPersonnes();
			Controleur.chargerFichierReservations();
			Controleur.chargerFichierSalles();
		});
		boutonCharger.setBackground(new Color(166, 166, 166));
		boutonCharger.setHorizontalTextPosition(JButton.CENTER);
		boutonCharger.setOpaque(true);
		panelMenu.add(boutonCharger);
	}

	public void afficherBoutonSauvegarder() {
		JButton boutonSauvegarder = new JButton();
		boutonSauvegarder.setBounds(809, 18, 143, 38);
		boutonSauvegarder.setText("Sauvegarder");
		boutonSauvegarder.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonSauvegarder.addActionListener(e -> {
			Controleur.sauvegarderFichierCreneaux();
			Controleur.sauvegarderFichierPersonnes();
			Controleur.sauvegarderFichierReservations();
			Controleur.sauvegarderFichierSalles();
		});
		boutonSauvegarder.setBackground(new Color(166, 166, 166));
		boutonSauvegarder.setHorizontalTextPosition(JButton.CENTER);
		boutonSauvegarder.setOpaque(true);
		panelMenu.add(boutonSauvegarder);
	}

	public void afficherBoutonSupprimerSalle() {
		JButton boutonSupprimerSalle = new JButton();
		boutonSupprimerSalle.setBounds(25, 18, 150, 38);
		boutonSupprimerSalle.setText("Salles");
		boutonSupprimerSalle.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonSupprimerSalle.addActionListener(e -> {
			MenuSupprimerSalle menuSupprimerSalle = new MenuSupprimerSalle("Suppression d'une salle");
			menuSupprimerSalle.setVisible(true);
		});
		boutonSupprimerSalle.setBackground(new Color(166, 166, 166));
		boutonSupprimerSalle.setHorizontalTextPosition(JButton.CENTER);
		boutonSupprimerSalle.setOpaque(true);
		panelGauche.add(boutonSupprimerSalle);
	}

	public void afficherBoutonSupprimerPersonne() {
		JButton boutonSupprimerPersonne = new JButton();
		boutonSupprimerPersonne.setBounds(25, 76, 150, 38);
		boutonSupprimerPersonne.setText("Personnes");
		boutonSupprimerPersonne.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonSupprimerPersonne.addActionListener(e -> {
			MenuSupprimerPersonne menuSupprimerPersonne = new MenuSupprimerPersonne("Suppression d'une personne");
			menuSupprimerPersonne.setVisible(true);
		});
		boutonSupprimerPersonne.setBackground(new Color(166, 166, 166));
		boutonSupprimerPersonne.setHorizontalTextPosition(JButton.CENTER);
		boutonSupprimerPersonne.setOpaque(true);
		panelGauche.add(boutonSupprimerPersonne);
	}

	public void afficherBoutonSupprimerCreneau() {
		JButton boutonSupprimerCreneau = new JButton();
		boutonSupprimerCreneau.setBounds(25, 134, 150, 38);
		boutonSupprimerCreneau.setText("Creneaux");
		boutonSupprimerCreneau.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonSupprimerCreneau.addActionListener(e -> {
			MenuSupprimerCreneau menuSupprimerCreneau = new MenuSupprimerCreneau("Suppression d'un creneau");
			menuSupprimerCreneau.setVisible(true);
		});
		boutonSupprimerCreneau.setBackground(new Color(166, 166, 166));
		boutonSupprimerCreneau.setHorizontalTextPosition(JButton.CENTER);
		boutonSupprimerCreneau.setOpaque(true);
		panelGauche.add(boutonSupprimerCreneau);
	}

	public void afficherTitre() {
		final JLabel titre = new JLabel("Titre");
		titre.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		titre.setBounds(17, 21, 79, 26);
		panelMenu.add(titre);
	}

	public void afficherTableauReservation() {
		final String colonnes[] = {"Réservations","Salle","Personne", "Date", "Créneau"};
        String listeReservations[] []= {
                {"Jean","Herard","Masculin","Herard","Masculin"},
                {"Wiliams","Jean","Masculin","Herard","Masculin"},
                {"Chuck","Batosky","Masculin","Herard","Masculin"},
                {"Joel","Fouckan","Masculin","Herard","Masculin"}
        };
                
		tableReservations = new JTable(listeReservations, colonnes);
		tableReservations.setBounds(205, 100, 895, 679);
		
		JScrollPane scrollPane = new JScrollPane(tableReservations);
		scrollPane.setBounds(356, 72, 744, 681);
		panelGauche.add(scrollPane);
	}
}
