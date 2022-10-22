package fr.isty.groupe5.ressources_ihm;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

@SuppressWarnings({ "serial" })
public class MenuReservation extends MiniMenu {

	private JLabel labelSalle;
	private JLabel labelPersonne;
	private JLabel labelDebut;
	private JLabel labelFin;
	private JComboBox<String> listeSalles;
	private JComboBox<String> listePersonnes;

	public MenuReservation(String titre) {
		super(titre);
		
		afficherListeSalles();
		afficherListePersonnes();
		afficherDebut();
		afficherFin();
	}
	
	public void afficherListeSalles() {
		labelSalle = DefaultComponentFactory.getInstance().createLabel("Salle :");
		labelSalle.setFont(new Font("Arial", Font.PLAIN, 13));
		labelSalle.setBounds(21, 33, 52, 27);
		this.panelPrincipal.add(labelSalle);
		listeSalles = new JComboBox<String>();
		listeSalles.setBounds(123, 78, 124, 27);
		this.panelPrincipal.add(listeSalles);
	}
	
	public void afficherListePersonnes() {
		labelPersonne = DefaultComponentFactory.getInstance().createLabel("Personne :");
		labelPersonne.setFont(new Font("Arial", Font.PLAIN, 13));
		labelPersonne.setBounds(21, 83, 74, 16);
		this.panelPrincipal.add(labelPersonne);
		
		listePersonnes = new JComboBox<String>();
		listePersonnes.setBounds(123, 33, 124, 27);
		this.panelPrincipal.add(listePersonnes);
	}
	
	public void afficherDebut() {
		labelDebut = DefaultComponentFactory.getInstance().createLabel("Début : ");
		labelDebut.setFont(new Font("Arial", Font.PLAIN, 13));
		labelDebut.setBounds(326, 38, 52, 16);
		this.panelPrincipal.add(labelDebut);
		
	}
	
	public void afficherFin() {
		labelFin = DefaultComponentFactory.getInstance().createLabel("Fin :");
		labelFin.setFont(new Font("Arial", Font.PLAIN, 13));
		labelFin.setBounds(326, 83, 36, 16);
		this.panelPrincipal.add(labelFin);
	}
}
