package fr.isty.groupe5.ressources_ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import fr.isty.groupe5.ressources_si.controleur.Controleur;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JPanel panelPrincipal;
	private final JPanel panelMenu;
	private final JPanel panelGauche;
	private JList<Entite> tableauReservations;

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

		afficherBoutonAjouterReservation();
		afficherBoutonAjouterPersonne();
		afficherBoutonAjouterSalle();
		afficherBoutonAjouterCreneau();
		afficherBoutonCharger();
		afficherBoutonSauvegarder();
		afficherBoutonSupprimerSalle();
		afficherBoutonSupprimerPersonne();
		afficherBoutonSupprimerCreneau();
		afficherTableauReservation();
		afficherBoutonSupprimerReservation();
		afficherBoutonModifierReservation();
	}

	/* FONCTION PERMETTANT D'AFFICHER LE BOUTON : NOUVELLE RESERVATION **/
	/* CE BOUTON NOUS PERMETTRA D'AJOUTER UNE RESERVATION **/
	public void afficherBoutonAjouterReservation() {
		final JButton boutonAjouterReservation = new JButton();
		boutonAjouterReservation.setBounds(20, 12, 200, 47);
		boutonAjouterReservation.setText("Ajouter une réservation");
		boutonAjouterReservation.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		boutonAjouterReservation.setBackground(new Color(46, 204, 113));
		boutonAjouterReservation.addActionListener(e -> {
			final MenuReservation menuReservation = new MenuReservation("Nouvelle réservation", null);
			menuReservation.setVisible(true);
			menuReservation.addWindowListener(new WindowListener() {
				@Override
				public void windowOpened(WindowEvent e) {
					MenuPrincipal.super.processWindowEvent(e);
				}

				@Override
				public void windowClosing(WindowEvent e) {
					MenuPrincipal.super.processWindowEvent(e);
				}

				@Override
				public void windowClosed(WindowEvent e) {
					actualiserTableau();
				}

				@Override
				public void windowIconified(WindowEvent e) {
					MenuPrincipal.super.processWindowEvent(e);
				}

				@Override
				public void windowDeiconified(WindowEvent e) {
					MenuPrincipal.super.processWindowEvent(e);
				}

				@Override
				public void windowActivated(WindowEvent e) {
					MenuPrincipal.super.processWindowEvent(e);
				}

				@Override
				public void windowDeactivated(WindowEvent e) {
					MenuPrincipal.super.processWindowEvent(e);
				}
			});
		});
		boutonAjouterReservation.setHorizontalTextPosition(JButton.CENTER);
		panelMenu.add(boutonAjouterReservation);

	}

	public void afficherBoutonAjouterPersonne() {
		final JButton boutonAjouterPersonne = new JButton();
		boutonAjouterPersonne.setBounds(417, 18, 163, 38);
		boutonAjouterPersonne.setText("Ajouter une personne");
		boutonAjouterPersonne.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonAjouterPersonne.addActionListener(e -> {
			final MenuAjouterPersonne menuAjouterPersonne = new MenuAjouterPersonne("Nouvelle personne");
			menuAjouterPersonne.setVisible(true);
		});
		boutonAjouterPersonne.setBackground(new Color(166, 166, 166));
		boutonAjouterPersonne.setHorizontalTextPosition(JButton.CENTER);
		boutonAjouterPersonne.setOpaque(true);
		panelMenu.add(boutonAjouterPersonne);

	}

	public void afficherBoutonAjouterSalle() {
		final JButton boutonAjouterSalle = new JButton();
		boutonAjouterSalle.setBounds(261, 18, 143, 38);
		boutonAjouterSalle.setText("Ajouter une salle");
		boutonAjouterSalle.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonAjouterSalle.setBackground(new Color(166, 166, 166));
		boutonAjouterSalle.addActionListener(e -> {
			final MenuAjouterSalle menuAjouterSalle = new MenuAjouterSalle("Nouvelle salle");
			menuAjouterSalle.setVisible(true);
		});
		boutonAjouterSalle.setHorizontalTextPosition(JButton.CENTER);
		boutonAjouterSalle.setOpaque(true);
		panelMenu.add(boutonAjouterSalle);
	}

	public void afficherBoutonAjouterCreneau() {
		final JButton boutonAjouterCreneau = new JButton();
		boutonAjouterCreneau.setBounds(593, 18, 143, 38);
		boutonAjouterCreneau.setText("Ajouter un créneau");
		boutonAjouterCreneau.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonAjouterCreneau.setBackground(new Color(166, 166, 166));
		boutonAjouterCreneau.addActionListener(e -> {
			final MenuAjouterCreneau menuAjouterCreneau = new MenuAjouterCreneau("Nouveau créneau");
			menuAjouterCreneau.setVisible(true);
		});
		boutonAjouterCreneau.setHorizontalTextPosition(JButton.CENTER);
		boutonAjouterCreneau.setOpaque(true);
		panelMenu.add(boutonAjouterCreneau);
	}

	public void afficherBoutonCharger() {
		final JButton boutonCharger = new JButton();
		boutonCharger.setBounds(809, 18, 100, 38);
		boutonCharger.setText("Charger");
		boutonCharger.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonCharger.addActionListener(e -> {
			Controleur.chargerFichierCreneaux();
			Controleur.chargerFichierPersonnes();
			Controleur.chargerFichierSalles();
			Controleur.chargerFichierReservations();
			actualiserTableau();
		});
		boutonCharger.setBackground(new Color(166, 166, 166));
		boutonCharger.setHorizontalTextPosition(JButton.CENTER);
		boutonCharger.setOpaque(true);
		panelMenu.add(boutonCharger);
	}

	public void afficherBoutonSauvegarder() {
		final JButton boutonSauvegarder = new JButton();
		boutonSauvegarder.setBounds(922, 18, 130, 38);
		boutonSauvegarder.setText("Sauvegarder");
		boutonSauvegarder.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonSauvegarder.addActionListener(e -> {
			Controleur.sauvegarderFichierCreneaux();
			Controleur.sauvegarderFichierPersonnes();
			Controleur.sauvegarderFichierSalles();
			Controleur.sauvegarderFichierReservations();
			actualiserTableau();
		});
		boutonSauvegarder.setBackground(new Color(166, 166, 166));
		boutonSauvegarder.setHorizontalTextPosition(JButton.CENTER);
		boutonSauvegarder.setOpaque(true);
		panelMenu.add(boutonSauvegarder);
	}

	public void afficherBoutonSupprimerSalle() {
		final JButton boutonSupprimerSalle = new JButton();
		boutonSupprimerSalle.setBounds(25, 18, 150, 38);
		boutonSupprimerSalle.setText("Salles");
		boutonSupprimerSalle.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonSupprimerSalle.addActionListener(e -> {
			final MenuSupprimerSalle menuSupprimerSalle = new MenuSupprimerSalle("Suppression d'une salle");
			menuSupprimerSalle.setVisible(true);
		});
		boutonSupprimerSalle.setBackground(new Color(166, 166, 166));
		boutonSupprimerSalle.setHorizontalTextPosition(JButton.CENTER);
		boutonSupprimerSalle.setOpaque(true);
		panelGauche.add(boutonSupprimerSalle);
	}

	public void afficherBoutonSupprimerPersonne() {
		final JButton boutonSupprimerPersonne = new JButton();
		boutonSupprimerPersonne.setBounds(25, 76, 150, 38);
		boutonSupprimerPersonne.setText("Personnes");
		boutonSupprimerPersonne.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonSupprimerPersonne.addActionListener(e -> {
			final MenuSupprimerPersonne menuSupprimerPersonne = new MenuSupprimerPersonne("Suppression d'une personne");
			menuSupprimerPersonne.setVisible(true);
		});
		boutonSupprimerPersonne.setBackground(new Color(166, 166, 166));
		boutonSupprimerPersonne.setHorizontalTextPosition(JButton.CENTER);
		boutonSupprimerPersonne.setOpaque(true);
		panelGauche.add(boutonSupprimerPersonne);
	}

	public void afficherBoutonSupprimerCreneau() {
		final JButton boutonSupprimerCreneau = new JButton();
		boutonSupprimerCreneau.setBounds(25, 134, 150, 38);
		boutonSupprimerCreneau.setText("Creneaux");
		boutonSupprimerCreneau.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonSupprimerCreneau.addActionListener(e -> {
			final MenuSupprimerCreneau menuSupprimerCreneau = new MenuSupprimerCreneau("Suppression d'un creneau");
			menuSupprimerCreneau.setVisible(true);
		});
		boutonSupprimerCreneau.setBackground(new Color(166, 166, 166));
		boutonSupprimerCreneau.setHorizontalTextPosition(JButton.CENTER);
		boutonSupprimerCreneau.setOpaque(true);
		panelGauche.add(boutonSupprimerCreneau);
	}

	private void afficherTableauReservation() {
		tableauReservations = new JList<>();
		tableauReservations.setBounds(220, 100, 700, 800);
		tableauReservations.setAutoscrolls(true);
		tableauReservations.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		actualiserTableau();
		panelPrincipal.add(tableauReservations);
	}

	private void actualiserTableau() {
		final ArrayList<Entite> listeReservations = Controleur.getReservationRepo().stream()
				.map(reservation -> new Entite(
						reservation.getSalle().getNom() + " - " + reservation.getPersonne().getNom() + " "
								+ reservation.getPersonne().getPrenom() + " "
								+ reservation.getCreneaux().stream()
										.map(creneau -> creneau.getDebut() + " - " + creneau.getFin())
										.collect(Collectors.toCollection(ArrayList::new)),
						reservation.getIdentifiant()))
				.collect(Collectors.toCollection(ArrayList::new));

		final DefaultListModel<Entite> model = new DefaultListModel<>();
		model.addAll(listeReservations);
		tableauReservations.setModel(model);
	}

	private void afficherBoutonSupprimerReservation() {
		final JButton boutonSupprimerReservation = new JButton();
		boutonSupprimerReservation.setBounds(940, 130, 100, 30);
		boutonSupprimerReservation.setText("Supprimer");
		boutonSupprimerReservation.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonSupprimerReservation.addActionListener(e -> {
			Controleur.supprimerReservation(tableauReservations.getSelectedValue().valeur());
			actualiserTableau();
		});
		boutonSupprimerReservation.setBackground(new Color(255, 77, 77));
		boutonSupprimerReservation.setHorizontalTextPosition(JButton.CENTER);
		boutonSupprimerReservation.setOpaque(true);
		panelPrincipal.add(boutonSupprimerReservation);
	}

	private void afficherBoutonModifierReservation() {
		final JButton boutonModifierReservation = new JButton();
		boutonModifierReservation.setBounds(940, 190, 100, 30);
		boutonModifierReservation.setText("Modifier");
		boutonModifierReservation.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonModifierReservation.addActionListener(e -> {
			final MenuReservation menuReservation = new MenuReservation("Modifier la réservation",
					tableauReservations.getSelectedValue().valeur());
			menuReservation.setVisible(true);
			menuReservation.addWindowListener(new WindowListener() {
				@Override
				public void windowOpened(WindowEvent e) {
					MenuPrincipal.super.processWindowEvent(e);
				}

				@Override
				public void windowClosing(WindowEvent e) {
					MenuPrincipal.super.processWindowEvent(e);
				}

				@Override
				public void windowClosed(WindowEvent e) {
					actualiserTableau();
				}

				@Override
				public void windowIconified(WindowEvent e) {
					MenuPrincipal.super.processWindowEvent(e);
				}

				@Override
				public void windowDeiconified(WindowEvent e) {
					MenuPrincipal.super.processWindowEvent(e);
				}

				@Override
				public void windowActivated(WindowEvent e) {
					MenuPrincipal.super.processWindowEvent(e);
				}

				@Override
				public void windowDeactivated(WindowEvent e) {
					MenuPrincipal.super.processWindowEvent(e);
				}
			});
		});
		boutonModifierReservation.setBackground(new Color(255, 213, 77));
		boutonModifierReservation.setHorizontalTextPosition(JButton.CENTER);
		boutonModifierReservation.setOpaque(true);
		panelPrincipal.add(boutonModifierReservation);
	}
}
