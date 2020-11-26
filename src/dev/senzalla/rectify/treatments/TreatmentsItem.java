package dev.senzalla.rectify.treatments;

import javax.swing.*;
import java.awt.*;

/**
 * @author Bomsalvez
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatmentsItem {

    public static void visiblePanel(JPanel pnl) {
        for (Component c : pnl.getComponents()) {
            if (c instanceof JPanel) {
                JPanel panel = (JPanel) c;
                panel.setVisible(false);
            }
        }
    }
}
