package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import javax.swing.*;

import com.mindfusion.scheduling.Calendar;
import com.mindfusion.scheduling.ThemeType;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

@SuppressWarnings({ "serial" })
public class MenuPrincipal extends JFrame {
	
	private JPanel panelPrincipal;
	private JPanel panelMenu;
	private JPanel panelGauche;
	private JButton newBooking;
	private JComboBox<String> listeRessources;
	private JComboBox<String> listeSalles;

	public MenuPrincipal() {
		this.setTitle("Groupe 5 - IATIC 5");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1100, 781);
		
		Dimension size = Toolkit. getDefaultToolkit().getScreenSize();
		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
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
	afficherListeRessources();
	afficherListeSalles();
	afficherCalendrier();

	
}
	
	
	/*****************************************************************************/
	/** 		FONCTION PERMETTANT D4AFFICHER LE BOUTON : NEW BOOKING          **/
	/** 		  CE BOUTON NOUS PERMETTRA D4AJOUTER UNE RESERVATION            **/
	/*****************************************************************************/
	public void afficherBoutonNewBooking() {
		newBooking = new JButton();
		newBooking.setBounds(196, 12, 118, 47);
		newBooking.setText("New Booking");
		newBooking.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		newBooking.setBackground(new Color(46, 204, 113));
		newBooking.setHorizontalTextPosition(JButton.CENTER);
		panelMenu.add(newBooking);
		
	}
	
	public void afficherListeRessources() {
		listeRessources = new JComboBox<String>();
		listeRessources.setBounds(340, 23, 85, 26);
		panelMenu.add(listeRessources);
		
	}
	
	public void afficherListeSalles() {
		listeSalles = new JComboBox<String>();
		listeSalles.setBounds(437, 23, 85, 26);
		panelMenu.add(listeSalles);
	}
	
	public void afficherTitre() {
		JLabel titre = new JLabel("Titre");
		titre.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		titre.setBounds(17, 21, 79, 26);
		panelMenu.add(titre);
	}
	
	public void afficherCalendrier() {
		Calendar calendrier = new Calendar();
		calendrier.setTheme(ThemeType.Light);
		calendrier.setBounds(205, 74, 895, 679);
		panelPrincipal.add(calendrier);
	}
}
