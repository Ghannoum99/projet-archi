package fr.isty.groupe5.ressources_ihm;

import java.awt.EventQueue;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                final MenuPrincipal frame = new MenuPrincipal();
                frame.setVisible(true);
            } catch (final Exception e) {
                e.printStackTrace();
            }
        });
    }
}
