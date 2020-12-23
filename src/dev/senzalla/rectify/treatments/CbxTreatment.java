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
public class CbxTreatment {


    /**
     * @param panelCleaned {@link JPanel}
     */
    public static void cleanCbx(JPanel panelCleaned) {
        for (Component c : panelCleaned.getComponents()) {
            if (c instanceof JComboBox) {
                JComboBox cbx = (JComboBox) c;
                cbx.setSelectedIndex(0);
            }
        }
    }

    /**
     * @param panel {@link JPanel}
     * @return boolean
     */
    public static boolean isCbxEmpty(JPanel panel) {
        List<Integer> cbxComponent = new ArrayList<>();
        for (Component c : panel.getComponents()) {
            if (c instanceof JComboBox) {
                JComboBox cbx = (JComboBox) c;
                cbxComponent.add(cbx.getSelectedIndex());
            }
        }
        return cbxComponent.stream().noneMatch(cbx -> (cbx == 0));
    }
}
