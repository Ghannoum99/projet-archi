package fr.isty.groupe5.ressources_ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MiniMenuSupprimer extends JFrame {
    private String titre;
    private JButton boutonRetour;
    protected JButton boutonSupprimer;
    protected JPanel panelPrincipal;

    public MiniMenuSupprimer(String titre) {
        this.titre = titre;

        this.setTitle(this.titre);
        this.setBounds(100, 100, 578, 357);
        this.setResizable(false);

        panelPrincipal = new JPanel();
        panelPrincipal.setBackground(new Color(238, 238, 238));
        panelPrincipal.setForeground(Color.WHITE);
        panelPrincipal.setBounds(0, 0, 578, 357);
        getContentPane().add(panelPrincipal);
        panelPrincipal.setLayout(null);

        afficherBoutonRetour();
        afficherBoutonSupprimer();
    }

    private void afficherBoutonRetour() {
        boutonRetour = new JButton();
        panelPrincipal.add(boutonRetour);
        boutonRetour.setBounds(230, 283, 118, 29);
        boutonRetour.setText("Retour");
        boutonRetour.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        boutonRetour.setBackground(new Color(46, 204, 113));
        boutonRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        boutonRetour.setHorizontalTextPosition(JButton.CENTER);
        boutonRetour.setOpaque(true);
    }

    private void afficherBoutonSupprimer() {
        boutonSupprimer = new JButton();
        panelPrincipal.add(boutonSupprimer);
        boutonSupprimer.setBounds(320, 50, 118, 27);
        boutonSupprimer.setText("Supprimer");
        boutonSupprimer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        boutonSupprimer.setBackground(new Color(255, 77, 77));
        boutonSupprimer.setHorizontalTextPosition(JButton.CENTER);
        boutonSupprimer.setOpaque(true);
        ajouterActionBoutonSupprimer();
    }

    public void ajouterActionBoutonSupprimer() {}
}
