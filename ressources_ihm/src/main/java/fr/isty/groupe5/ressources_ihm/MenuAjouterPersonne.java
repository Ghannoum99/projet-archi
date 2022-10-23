package fr.isty.groupe5.ressources_ihm;

import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.isty.groupe5.ressources_si.controleur.Controleur;

public class MenuAjouterPersonne extends MiniMenu {

	private static final long serialVersionUID = 1L;
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
		final JLabel labelNom = new JLabel("Nom :");
		labelNom.setBounds(34, 39, 61, 16);
		panelPrincipal.add(labelNom);

		nom = new JTextField();
		nom.setBounds(107, 34, 130, 26);
		panelPrincipal.add(nom);
		nom.setColumns(10);
	}

	public void afficherPrenom() {
		final JLabel labelPrenom = new JLabel("Prenom :");
		labelPrenom.setBounds(318, 39, 61, 16);
		panelPrincipal.add(labelPrenom);

		prenom = new JTextField();
		prenom.setBounds(391, 34, 130, 26);
		panelPrincipal.add(prenom);
		prenom.setColumns(10);
	}

	public void afficherAge() {
		final JLabel labelAge = new JLabel("Age :");
		labelAge.setBounds(34, 134, 61, 16);
		panelPrincipal.add(labelAge);

		final JLabel labelGenre = new JLabel("Genre :");
		labelGenre.setBounds(318, 134, 61, 16);
		panelPrincipal.add(labelGenre);
	}

	public void afficherGenre() {
		age = new JTextField();
		age.setBounds(107, 129, 130, 26);
		panelPrincipal.add(age);
		age.setColumns(10);

		final ArrayList<String> listeGenre = Controleur.getGenres();
		genre = new JComboBox<>();
		for (final String valeur : listeGenre) {
			genre.addItem(valeur);
		}
		genre.setBounds(391, 130, 130, 27);
		panelPrincipal.add(genre);
	}

	@Override
	public void ajouterActionBoutonValider() {
		boutonValider.addActionListener(e -> {
			final int valeurAge = Integer.parseInt(age.getText());
			if (nom.getText().isBlank() || prenom.getText().isBlank() || valeurAge <= 0 || !genre.isValid()) {
				return;
			}
			Controleur.ajouterPersonne(Identifiant.genererIdentifiant(), nom.getText(), prenom.getText(), valeurAge,
					Objects.requireNonNull(genre.getSelectedItem()).toString());
			dispose();
		});
	}
}