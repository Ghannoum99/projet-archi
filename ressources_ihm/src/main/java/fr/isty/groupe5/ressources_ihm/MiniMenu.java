package fr.isty.groupe5.ressources_ihm;

import javax.swing.JFrame;

@SuppressWarnings({ "serial" })
public class MiniMenu extends JFrame {
	private final String titre;

	public MiniMenu(String titre) {
		this.titre = titre;

		this.setTitle("Groupe 5 - IATIC 5");
		this.setBounds(100, 100, 578, 357);
		this.setTitle(this.titre);
		this.setResizable(false);

	}

}
