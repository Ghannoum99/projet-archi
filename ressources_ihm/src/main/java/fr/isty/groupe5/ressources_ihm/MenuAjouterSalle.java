package fr.isty.groupe5.ressources_ihm;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import fr.isty.groupe5.ressources_si.controleur.Controleur;

public class MenuAjouterSalle extends MiniMenu {

	private static final long serialVersionUID = 1L;
	private JTextField nomSalle;
	private JTextField capacite;

	public MenuAjouterSalle(String titre) {
		super(titre);

		afficherNomSalle();
		afficherCapacite();
	}

	public void afficherNomSalle() {
		final JLabel labelnomSalle = DefaultComponentFactory.getInstance().createLabel("Nom :");
		labelnomSalle.setFont(new Font("Arial", Font.PLAIN, 13));
		labelnomSalle.setBounds(21, 33, 52, 27);
		this.panelPrincipal.add(labelnomSalle);

		nomSalle = new JTextField();
		nomSalle.setBounds(107, 34, 130, 26);
		panelPrincipal.add(nomSalle);
		nomSalle.setColumns(10);

	}

	public void afficherCapacite() {
		final JLabel labelCapacite = new JLabel("Capacité :");
		labelCapacite.setBounds(318, 39, 61, 16);
		panelPrincipal.add(labelCapacite);

		capacite = new JTextField();
		capacite.setBounds(391, 34, 130, 26);
		panelPrincipal.add(capacite);
		capacite.setColumns(10);
	}

	@Override
	public void ajouterActionBoutonValider() {
		boutonValider.addActionListener(e -> {
			final int cap = Integer.parseInt(capacite.getText());

			if (nomSalle.getText().isBlank() || cap <= 0) {
				return;
			}
			Controleur.ajouterSalle(Identifiant.genererIdentifiant(), nomSalle.getText(), cap);
			dispose();
		});
	}

}
