package fr.isty.groupe5.ressources_ihm;

import javax.swing.*;
import java.awt.*;

public class MiniMenu extends JFrame {

    protected JButton boutonValider;
    protected JPanel panelPrincipal;

    public MiniMenu(String titre) {

        this.setTitle("Groupe 5 - IATIC 5");
        this.setBounds(100, 100, 578, 357);
        this.setTitle(titre);
        this.setResizable(false);

        panelPrincipal = new JPanel();
        panelPrincipal.setBackground(new Color(238, 238, 238));
        panelPrincipal.setForeground(Color.WHITE);
        panelPrincipal.setBounds(0, 0, 578, 357);
        getContentPane().add(panelPrincipal);
        panelPrincipal.setLayout(null);

        afficherBoutonAnnuler();
        afficherBoutonValider();
        ajouterActionBoutonValider();
    }

    public void afficherBoutonAnnuler() {
        JButton boutonAnnuler = new JButton();
        panelPrincipal.add(boutonAnnuler);
        boutonAnnuler.setBounds(359, 283, 118, 29);
        boutonAnnuler.setText("Annuler");
        boutonAnnuler.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        boutonAnnuler.setBackground(new Color(46, 204, 113));
        boutonAnnuler.addActionListener(e -> dispose());
        boutonAnnuler.setHorizontalTextPosition(JButton.CENTER);
        boutonAnnuler.setOpaque(true);
    }

    public void afficherBoutonValider() {
        boutonValider = new JButton();
        boutonValider.setBounds(119, 283, 118, 29);
        boutonValider.setText("Valider");
        boutonValider.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        boutonValider.setBackground(new Color(46, 204, 113));
        boutonValider.setHorizontalTextPosition(JButton.CENTER);
        boutonValider.setOpaque(true);
        panelPrincipal.add(boutonValider);

    }

    public void ajouterActionBoutonValider() {
    }
}
