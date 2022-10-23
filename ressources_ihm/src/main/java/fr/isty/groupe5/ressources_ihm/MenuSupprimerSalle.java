package fr.isty.groupe5.ressources_ihm;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.swing.JComboBox;

import fr.isty.groupe5.ressources_si.controleur.Controleur;

public class MenuSupprimerSalle extends MiniMenuSupprimer {

	private static final long serialVersionUID = 1L;
	private final JComboBox<Entite> salles;
	private final ArrayList<Entite> listeSalles;

	public MenuSupprimerSalle(String titre) {
		super(titre);

		listeSalles = Controleur.getSalleRepo().stream()
				.map(salle -> new Entite(salle.getNom() + " (" + salle.getCapacite() + ")", salle.getIdentifiant()))
				.collect(Collectors.toCollection(ArrayList::new));
		salles = new JComboBox<>();
		for (final Entite salle : listeSalles) {
			salles.addItem(salle);
		}
		salles.setBounds(150, 50, 130, 27);
		panelPrincipal.add(salles);
	}

	@Override
	public void ajouterActionBoutonSupprimer() {
		boutonSupprimer.addActionListener(e -> {
			if (listeSalles.isEmpty()) {
				return;
			}
			Controleur.supprimerSalle(((Entite) Objects.requireNonNull(salles.getSelectedItem())).valeur());
			dispose();
		});
	}
}
