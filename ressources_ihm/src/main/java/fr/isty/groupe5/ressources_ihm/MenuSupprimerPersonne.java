package fr.isty.groupe5.ressources_ihm;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.swing.JComboBox;

import fr.isty.groupe5.ressources_si.controleur.Controleur;

public class MenuSupprimerPersonne extends MiniMenuSupprimer {

	private static final long serialVersionUID = 1L;
	private final JComboBox<Entite> personnes;
	private final ArrayList<Entite> listePersonnes;

	public MenuSupprimerPersonne(String titre) {
		super(titre);

		listePersonnes = Controleur.getPersonneRepo().stream()
				.map(personne -> new Entite(personne.getNom() + " " + personne.getPrenom(), personne.getIdentifiant()))
				.collect(Collectors.toCollection(ArrayList::new));
		personnes = new JComboBox<>();
		for (final Entite personne : listePersonnes) {
			personnes.addItem(personne);
		}
		personnes.setBounds(150, 50, 130, 27);
		panelPrincipal.add(personnes);
	}

	@Override
	public void ajouterActionBoutonSupprimer() {
		boutonSupprimer.addActionListener(e -> {
			if (listePersonnes.isEmpty()) {
				return;
			}
			Controleur.supprimerPersonne(((Entite) Objects.requireNonNull(personnes.getSelectedItem())).valeur());
			dispose();
		});
	}
}
