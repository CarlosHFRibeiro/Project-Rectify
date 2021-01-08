package dev.senzalla.rectify.treatments;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ComboBoxTreatment {

    public static void cleanCbx(JPanel panelCleaned) {
        for (Component c : panelCleaned.getComponents()) {
            if (c instanceof JComboBox) {
                JComboBox cbx = (JComboBox) c;
                cbx.setSelectedIndex(0);
            }
        }
    }


    public static boolean isCbxEmpty(JPanel panel) {
        return comboBox(panel).stream().noneMatch(cbx -> (cbx == 0));
    }

    public static boolean isCbxFilterEmpty(JPanel panel) {
        return comboBox(panel).stream().noneMatch(cbx -> (cbx > 0));
    }

    private static List<Integer> comboBox(JPanel panel) {
        List<Integer> cbxComponent = new ArrayList<>();
        for (Component c : panel.getComponents()) {
            if (c instanceof JComboBox) {
                JComboBox cbx = (JComboBox) c;
                cbxComponent.add(cbx.getSelectedIndex());
            }
        }
        return cbxComponent;
    }
}
