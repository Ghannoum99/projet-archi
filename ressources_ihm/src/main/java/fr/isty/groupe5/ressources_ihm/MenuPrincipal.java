package fr.isty.groupe5.ressources_ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings({ "serial" })
public class MenuPrincipal extends JFrame {

	private final JPanel panelPrincipal;
	private final JPanel panelMenu;
	private final JPanel panelGauche;
	private JButton newBooking;
	private JButton boutonAjouterPersonne;
	private JButton boutonAjouterSalle;

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

		/** PANEL PRINCIPAL DE LA FENETRE **/
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(238, 238, 238));
		panelPrincipal.setForeground(Color.WHITE);
		panelPrincipal.setBounds(0, 0, 1100, 767);
		getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);

		/** PANEL QUI CONTIENT TOUS LE TITRE ET LES BOUTONS **/
		panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 1100, 71);
		panelMenu.setBackground(new Color(232, 232, 232));
		panelPrincipal.add(panelMenu);
		panelMenu.setLayout(null);

		/** PANEL CONTENANT LES SALLES RESERVEES **/
		panelGauche = new JPanel();
		panelGauche.setBounds(0, 74, 200, 679);
		panelGauche.setBackground(new Color(220, 220, 220));
		panelPrincipal.add(panelGauche);
		panelGauche.setLayout(null);

		afficherTitre();
		afficherBoutonNewBooking();
		afficherBoutonAjouterPersonne();
		afficherBoutonAjouterSalle();
		afficherCalendrier();

	}

	/*****************************************************************************/
	/** FONCTION PERMETTANT D4AFFICHER LE BOUTON : NEW BOOKING **/
	/** CE BOUTON NOUS PERMETTRA D4AJOUTER UNE RESERVATION **/
	/*****************************************************************************/
	public void afficherBoutonNewBooking() {
		newBooking = new JButton();
		newBooking.setBounds(196, 12, 118, 47);
		newBooking.setText("New Booking");
		newBooking.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		newBooking.setBackground(new Color(46, 204, 113));
		newBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuReservation menuReservation = new MenuReservation("Nouvelle réservation");
                menuReservation.setVisible(true);
            }
        });
		newBooking.setHorizontalTextPosition(JButton.CENTER);
		panelMenu.add(newBooking);

	}

	public void afficherBoutonAjouterPersonne() {
		boutonAjouterPersonne = new JButton();
		boutonAjouterPersonne.setBounds(497, 18, 143, 38);
		boutonAjouterPersonne.setText("Ajouter une Personne");
		boutonAjouterPersonne.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonAjouterPersonne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuAjouterPersonne menuAjouterPersonne = new MenuAjouterPersonne("Nouvelle Personne");
                menuAjouterPersonne.setVisible(true);
            }
        });
		boutonAjouterPersonne.setBackground(new Color(166, 166, 166));
		boutonAjouterPersonne.setHorizontalTextPosition(JButton.CENTER);
		boutonAjouterPersonne.setOpaque(true);
		panelMenu.add(boutonAjouterPersonne);

	}

	public void afficherBoutonAjouterSalle() {
		boutonAjouterSalle = new JButton();
		boutonAjouterSalle.setBounds(341, 18, 143, 38);
		boutonAjouterSalle.setText("Ajouter une Salle");
		boutonAjouterSalle.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonAjouterSalle.setBackground(new Color(166, 166, 166));
		boutonAjouterSalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAjouterSalle menuAjouterSalle = new MenuAjouterSalle("Nouvelle Salle");
				menuAjouterSalle.setVisible(true);
			}
		});
		boutonAjouterSalle.setHorizontalTextPosition(JButton.CENTER);
		boutonAjouterSalle.setOpaque(true);
		panelMenu.add(boutonAjouterSalle);
	}

	public void afficherTitre() {
		final JLabel titre = new JLabel("Titre");
		titre.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		titre.setBounds(17, 21, 79, 26);
		panelMenu.add(titre);
	}

	public void afficherCalendrier() {
		final com.mindfusion.scheduling.Calendar calendrier = new com.mindfusion.scheduling.Calendar();
		//calendrier.setTheme(ThemeType.Light);
		calendrier.setBounds(205, 74, 895, 679);
		panelPrincipal.add(calendrier);
	}
}
