package fr.isty.groupe5.ressources_ihm;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import fr.isty.groupe5.ressources_si.Controller;

@SuppressWarnings({ "serial" })
public class MenuAjouterSalle extends MiniMenu {
	
	private JLabel labelnomSalle;
	private JLabel labelCapacite;
	private JTextField nomSalle;
	private JTextField capacite;

	public MenuAjouterSalle(String titre) {
		super(titre);
		
		afficherNomSalle();
		afficherCapacite();
		ajouterActionBoutonValider();
	}
	
	public void afficherNomSalle() {
		labelnomSalle = DefaultComponentFactory.getInstance().createLabel("Nom :");
		labelnomSalle.setFont(new Font("Arial", Font.PLAIN, 13));
		labelnomSalle.setBounds(21, 33, 52, 27);
		this.panelPrincipal.add(labelnomSalle);
		
		nomSalle = new JTextField();
		nomSalle.setBounds(107, 34, 130, 26);
		panelPrincipal.add(nomSalle);
		nomSalle.setColumns(10);
		
	}
	
	public void afficherCapacite() {
		labelCapacite = new JLabel("Capacité :");
		labelCapacite.setBounds(318, 39, 61, 16);
		panelPrincipal.add(labelCapacite);
		
		capacite = new JTextField();
		capacite.setBounds(391, 34, 130, 26);
		panelPrincipal.add(capacite);
		capacite.setColumns(10);
	}

	private void ajouterActionBoutonValider() {
		boutonValider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String salle = nomSalle.getText();
				int cap = 0;

				try {
					cap = Integer.parseInt(capacite.getText());
				} catch (NumberFormatException ne) {
					texteErreur.setText("Veuillez rentrer une capacité");
					return;
				}

				if(salle.isBlank() || cap <= 0) {
					texteErreur.setText("Nom ou capacité non valide");
					return;
				}
				Controller.ajouterSalle(salle, cap);
				Controller.afficherSallesString();
				dispose();
			}
		});
	}


}
