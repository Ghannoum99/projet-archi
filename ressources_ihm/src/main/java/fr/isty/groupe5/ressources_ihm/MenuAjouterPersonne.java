package fr.isty.groupe5.ressources_ihm;

import fr.isty.groupe5.ressources_si.Controleur;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings({ "serial" })
public class MenuAjouterPersonne extends MiniMenu {
	
	private JLabel labelNom;
	private JLabel labelPrenom;
	private JLabel labelAge;
	private JLabel labelGenre;
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
		labelNom = new JLabel("Nom :");
		labelNom.setBounds(34, 39, 61, 16);
		panelPrincipal.add(labelNom);
		
		nom = new JTextField();
		nom.setBounds(107, 34, 130, 26);
		panelPrincipal.add(nom);
		nom.setColumns(10);
	}
	
	public void afficherPrenom() {
		labelPrenom = new JLabel("Prenom :");
		labelPrenom.setBounds(318, 39, 61, 16);
		panelPrincipal.add(labelPrenom);
		
		prenom = new JTextField();
		prenom.setBounds(391, 34, 130, 26);
		panelPrincipal.add(prenom);
		prenom.setColumns(10);
	}
	
	public void afficherAge() {
		labelAge = new JLabel("Age :");
		labelAge.setBounds(34, 134, 61, 16);
		panelPrincipal.add(labelAge);
		
		labelGenre = new JLabel("Genre :");
		labelGenre.setBounds(318, 134, 61, 16);
		panelPrincipal.add(labelGenre);
	}
	
	public void afficherGenre() {
		age = new JTextField();
		age.setBounds(107, 129, 130, 26);
		panelPrincipal.add(age);
		age.setColumns(10);

		ArrayList<String> listeGenre = Controleur.getGenres();
		genre = new JComboBox<String>();
		for(String valeur: listeGenre) {
			genre.addItem(valeur);
		}
		genre.setBounds(391, 130, 130, 27);
		panelPrincipal.add(genre);
	}

	@Override
	public void ajouterActionBoutonValider() {
		boutonValider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer valeurAge = Integer.parseInt(age.getText());
				if(nom.getText().isBlank() || prenom.getText().isBlank() || valeurAge <= 0 || !genre.isValid()) {
					return;
				}
				Controleur.ajouterPersonne(Identifiant.genererIdentifiant(), nom.getText(), prenom.getText(), valeurAge, genre.getSelectedItem().toString());
				Controleur.afficherPersonnesString();
				dispose();
			}
		});
	}
}