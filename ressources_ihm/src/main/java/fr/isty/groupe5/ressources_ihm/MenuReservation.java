package fr.isty.groupe5.ressources_ihm;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class MenuReservation extends MiniMenu {

	public MenuReservation(String titre) {
		super(titre);
		
		afficherListeSalles();
		afficherListePersonnes();
		afficherDebut();
		afficherFin();
		afficherDate();
	}
	
	public void afficherListeSalles() {
		JLabel labelSalle = DefaultComponentFactory.getInstance().createLabel("Salle :");
		labelSalle.setFont(new Font("Arial", Font.PLAIN, 13));
		labelSalle.setBounds(21, 33, 52, 27);
		this.panelPrincipal.add(labelSalle);

		JComboBox<String> listeSalles = new JComboBox<>();
		listeSalles.setBounds(123, 78, 124, 27);
		this.panelPrincipal.add(listeSalles);
	}
	
	public void afficherListePersonnes() {
		JLabel labelPersonne = DefaultComponentFactory.getInstance().createLabel("Personne :");
		labelPersonne.setFont(new Font("Arial", Font.PLAIN, 13));
		labelPersonne.setBounds(21, 83, 74, 16);
		this.panelPrincipal.add(labelPersonne);

		JComboBox<String> listePersonnes = new JComboBox<>();
		listePersonnes.setBounds(123, 33, 124, 27);
		this.panelPrincipal.add(listePersonnes);
	}
	
	public void afficherDebut() {
		JLabel labelDebut = DefaultComponentFactory.getInstance().createLabel("Début : ");
		labelDebut.setFont(new Font("Arial", Font.PLAIN, 13));
		labelDebut.setBounds(326, 38, 52, 16);
		this.panelPrincipal.add(labelDebut);
		
	}
	
	public void afficherFin() {
		JLabel labelFin = DefaultComponentFactory.getInstance().createLabel("Fin :");
		labelFin.setFont(new Font("Arial", Font.PLAIN, 13));
		labelFin.setBounds(326, 83, 36, 16);
		this.panelPrincipal.add(labelFin);
	}
	
	public void afficherDate() {
		JLabel labelDate = DefaultComponentFactory.getInstance().createLabel("Date :");
		labelDate.setFont(new Font("Arial", Font.PLAIN, 13));
		labelDate.setBounds(21, 133, 61, 16);
		this.panelPrincipal.add(labelDate);
	}
	
}