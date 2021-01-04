package dev.senzalla.rectify.treatments;

import javax.swing.*;
import java.awt.*;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ItemTreatment {

    public static void visiblePanel(JPanel panel) {
        for (Component c : panel.getComponents()) {
            if (c instanceof JPanel) {
                JPanel pnl = (JPanel) c;
                pnl.setVisible(false);
            }
        }
    }

    public static void speedRoll(JScrollPane scrollPane) {
        scrollPane.getVerticalScrollBar().setUnitIncrement(12);
    }
}
