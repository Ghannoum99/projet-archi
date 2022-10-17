package swing;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings({ "serial" })
public class MiniMenu extends JFrame {
	private String titre;
	

	public MiniMenu(String titre) {
		this.titre = titre;
		
		this.setTitle("Groupe 5 - IATIC 5");
		this.setBounds(100, 100, 578, 357);
		this.setTitle(this.titre);
		this.setResizable(false);

	}

}
