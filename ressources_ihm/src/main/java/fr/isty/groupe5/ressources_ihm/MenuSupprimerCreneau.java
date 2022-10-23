package fr.isty.groupe5.ressources_ihm;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.swing.JComboBox;

import fr.isty.groupe5.ressources_si.controleur.Controleur;

public class MenuSupprimerCreneau extends MiniMenuSupprimer {

	private static final long serialVersionUID = 1L;
	private final JComboBox<Entite> creneaux;
	private final ArrayList<Entite> listeCreneaux;

	public MenuSupprimerCreneau(String titre) {
		super(titre);

		listeCreneaux = Controleur.getCreneauRepo().stream()
				.map(creneau -> new Entite(creneau.getDebut() + " - " + creneau.getFin(), creneau.getIdentifiant()))
				.collect(Collectors.toCollection(ArrayList::new));
		creneaux = new JComboBox<>();
		for (final Entite creneau : listeCreneaux) {
			creneaux.addItem(creneau);
		}
		creneaux.setBounds(100, 50, 200, 27);
		panelPrincipal.add(creneaux);
	}

	@Override
	public void ajouterActionBoutonSupprimer() {
		boutonSupprimer.addActionListener(e -> {
			if (listeCreneaux.isEmpty()) {
				return;
			}
			Controleur.supprimerCreneau(((Entite) Objects.requireNonNull(creneaux.getSelectedItem())).valeur());
			dispose();
		});
	}
}
