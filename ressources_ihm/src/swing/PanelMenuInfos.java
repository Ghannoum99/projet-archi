package src;


import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/************************************************************************************************************************************/
/* 			           CLASSE CONSISTE A AFFICHER UN PANEL QUI VA ETRE UTILISER DANS PLUSIEURS MENU             	                */
/* 			          POUR ETRE CAPABLE D'UTILISER CE PANEL LIBREMENT, ON LUI A DONNEE (X, Y, LARGEUR, LONGEUR) COMME ATTRIBUT      */
/************************************************************************************************************************************/

@SuppressWarnings("serial")
public class PanelMenuInfos extends JPanel {

	
	private int x;
	private int y;
	private int width;
	private int height;
	
	public PanelMenuInfos(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.setBounds(x, y, 596, 480);
		this.setBackground(new Color(16, 22, 33));
		this.setLayout(null);
		
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}

