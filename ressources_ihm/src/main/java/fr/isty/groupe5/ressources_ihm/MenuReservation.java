package fr.isty.groupe5.ressources_ihm;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import fr.isty.groupe5.ressources_si.controleur.Controleur;

public class MenuReservation extends MiniMenu {

	private static final long serialVersionUID = 1L;
	private JComboBox<Entite> listeSalles;
	private JComboBox<Entite> listePersonnes;
	private JList<Entite> listeCreneaux;
	private final Long identifiant;

	public MenuReservation(String titre, Long identifiant) {
		super(titre);
		this.identifiant = identifiant;
		afficherListeSalles();
		afficherListePersonnes();
		afficherCreneaux();
	}

	public void afficherListeSalles() {
		final JLabel labelSalle = DefaultComponentFactory.getInstance().createLabel("Salle :");
		labelSalle.setFont(new Font("Arial", Font.PLAIN, 13));
		labelSalle.setBounds(21, 33, 52, 27);
		this.panelPrincipal.add(labelSalle);

		listeSalles = new JComboBox<>();
		if (identifiant == null) {
			final ArrayList<Entite> salles = Controleur.getSalleRepo().stream()
					.map(salle -> new Entite(salle.getNom() + " (" + salle.getCapacite() + ")", salle.getIdentifiant()))
					.collect(Collectors.toCollection(ArrayList::new));
			for (final Entite salle : salles) {
				listeSalles.addItem(salle);
			}
		} else {
			final Entite salle = new Entite(
					Controleur.accederReservation(identifiant).getSalle().getNom() + " ("
							+ Controleur.accederReservation(identifiant).getSalle().getCapacite() + ")",
					Controleur.accederReservation(identifiant).getSalle().getIdentifiant());
			listeSalles.addItem(salle);
			listeSalles.setEnabled(false);
		}
		listeSalles.setBounds(123, 33, 124, 27);
		this.panelPrincipal.add(listeSalles);
	}

	public void afficherListePersonnes() {
		final JLabel labelPersonne = DefaultComponentFactory.getInstance().createLabel("Personne :");
		labelPersonne.setFont(new Font("Arial", Font.PLAIN, 13));
		labelPersonne.setBounds(21, 83, 74, 16);
		this.panelPrincipal.add(labelPersonne);

		listePersonnes = new JComboBox<>();
		if (identifiant == null) {
			final ArrayList<Entite> personnes = Controleur.getPersonneRepo().stream().map(
					personne -> new Entite(personne.getNom() + " " + personne.getPrenom(), personne.getIdentifiant()))
					.collect(Collectors.toCollection(ArrayList::new));
			for (final Entite personne : personnes) {
				listePersonnes.addItem(personne);
			}
		} else {
			final Entite personne = new Entite(
					Controleur.accederReservation(identifiant).getPersonne().getNom() + " "
							+ Controleur.accederReservation(identifiant).getPersonne().getPrenom(),
					Controleur.accederReservation(identifiant).getPersonne().getIdentifiant());
			listePersonnes.addItem(personne);
			listePersonnes.setEnabled(false);
		}
		listePersonnes.setBounds(123, 83, 124, 27);
		this.panelPrincipal.add(listePersonnes);
	}

	private void afficherCreneaux() {
		final JLabel labelCreneaux = new JLabel("Créneaux : ");
		labelCreneaux.setFont(new Font("Arial", Font.PLAIN, 13));
		labelCreneaux.setBounds(270, 38, 74, 16);
		this.panelPrincipal.add(labelCreneaux);

		final DefaultListModel<Entite> model = new DefaultListModel<>();
		final ArrayList<Entite> creneaux = Controleur.getCreneauRepo().stream()
				.map(creneau -> new Entite(creneau.getDebut() + " - " + creneau.getFin(), creneau.getIdentifiant()))
				.collect(Collectors.toCollection(ArrayList::new));
		model.addAll(creneaux);
		listeCreneaux = new JList<>(model);
		this.panelPrincipal.add(listeCreneaux);
		listeCreneaux.setBounds(350, 38, 200, 200);

		if (identifiant != null) {
			final int[] indices = Arrays.stream(Controleur.accederReservation(identifiant).getCreneaux().stream()
					.map(creneau -> IntStream.range(0, creneaux.size())
							.filter(i -> ("" + creneaux.get(i).valeur()).equals(("" + creneau.getIdentifiant())))
							.findFirst().orElse(-1))
					.toArray(Integer[]::new)).mapToInt(x -> x).toArray();
			listeCreneaux.setSelectedIndices(indices);
		}
	}

	@Override
	public void ajouterActionBoutonValider() {
		boutonValider.addActionListener(e -> {
			if (!listeSalles.isValid() || !listePersonnes.isValid() || !listeCreneaux.isValid()) {
				return;
			}

			if (identifiant != null) {
				Controleur.modifierReservation(identifiant, listeCreneaux.getSelectedValuesList().stream()
						.map(Entite::valeur).collect(Collectors.toCollection(ArrayList::new)));
			} else {
				Controleur.ajouterReservation(Identifiant.genererIdentifiant(),
						((Entite) Objects.requireNonNull(listeSalles.getSelectedItem())).valeur(),
						listeCreneaux.getSelectedValuesList().stream().map(Entite::valeur)
								.collect(Collectors.toCollection(ArrayList::new)),
						((Entite) Objects.requireNonNull(listePersonnes.getSelectedItem())).valeur());
			}
			dispose();
		});
	}
}