package dev.senzalla.rectify.treatments;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class SpinnerTreatment {
    public void cleanSpinner(JPanel panel) {
        for (Component c : panel.getComponents()) {
            if (c instanceof JSpinner) {
                JSpinner spn = (JSpinner) c;
                spn.setValue(0);
            }
        }
    }

    public static boolean isSpinnerVoid(JPanel panel) {
        List<Object> spnField = new ArrayList<>();
        for (Component c : panel.getComponents()) {
            if (c instanceof JSpinner) {
                JSpinner spn = (JSpinner) c;
                spnField.add(spn.getValue());
            }
        }
        return spnField.stream().noneMatch(txt -> txt.equals(0));
    }
}
