package fr.isty.groupe5.ressources_ihm;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;

@SuppressWarnings({ "serial" })
public class MenuReservation extends MiniMenu {

	private final JPanel panelPrincipal;
	private JButton boutonReserver;
	private JButton boutonAnnuler;
	private JLabel labelSalle;
	private JLabel labelPersonne;
	private JLabel labelDebut;
	private JLabel labelFin;
	private JComboBox<String> listeSalles;
	private JComboBox<String> listePersonnes;

	public MenuReservation(String titre) {
		super(titre);

		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(238, 238, 238));
		panelPrincipal.setForeground(Color.WHITE);
		panelPrincipal.setBounds(0, 0, 578, 357);
		getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);

		afficherBoutonReserver();
		afficherBoutonAnnuler();
		afficherListeSalles();
		afficherListePersonnes();
		afficherDebut();
		afficherFin();

	}

	public void afficherBoutonAnnuler() {
		boutonAnnuler = new JButton();
		boutonAnnuler.setBounds(338, 283, 118, 29);
		boutonAnnuler.setText("Annuler");
		boutonAnnuler.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonAnnuler.setBackground(new Color(46, 204, 113));
		boutonAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		boutonAnnuler.addActionListener(e -> dispose());
		boutonAnnuler.setHorizontalTextPosition(JButton.CENTER);
		boutonAnnuler.setOpaque(true);
		panelPrincipal.add(boutonAnnuler);

	}

	public void afficherBoutonReserver() {
		panelPrincipal.setLayout(null);
		boutonReserver = new JButton();
		boutonReserver.setBounds(119, 283, 118, 29);
		boutonReserver.setText("Réserver");
		boutonReserver.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		boutonReserver.setBackground(new Color(46, 204, 113));
		boutonReserver.setHorizontalTextPosition(JButton.CENTER);
		boutonReserver.setOpaque(true);
		panelPrincipal.add(boutonReserver);
	}

	public void afficherListeSalles() {
		labelSalle = DefaultComponentFactory.getInstance().createLabel("Salle :");
		labelSalle.setFont(new Font("Arial", Font.PLAIN, 13));
		labelSalle.setBounds(21, 33, 52, 27);
		panelPrincipal.add(labelSalle);
		listeSalles = new JComboBox<>();
		listeSalles.setBounds(123, 78, 124, 27);
		panelPrincipal.add(listeSalles);
	}

	public void afficherListePersonnes() {
		labelPersonne = DefaultComponentFactory.getInstance().createLabel("Personne :");
		labelPersonne.setFont(new Font("Arial", Font.PLAIN, 13));
		labelPersonne.setBounds(21, 83, 74, 16);
		panelPrincipal.add(labelPersonne);

		listePersonnes = new JComboBox<>();
		listePersonnes.setBounds(123, 33, 124, 27);
		panelPrincipal.add(listePersonnes);
	}

	public void afficherDebut() {
		labelDebut = DefaultComponentFactory.getInstance().createLabel("Début : ");
		labelDebut.setFont(new Font("Arial", Font.PLAIN, 13));
		labelDebut.setBounds(326, 38, 52, 16);
		panelPrincipal.add(labelDebut);

	}

	public void afficherFin() {
		labelFin = DefaultComponentFactory.getInstance().createLabel("Fin :");
		labelFin.setFont(new Font("Arial", Font.PLAIN, 13));
		labelFin.setBounds(326, 83, 36, 16);
		panelPrincipal.add(labelFin);
	}
}
