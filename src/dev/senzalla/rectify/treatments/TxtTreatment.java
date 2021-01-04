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
public class TxtTreatment {

    public static void cleanTextField(JPanel panelCleaned) {
        for (Component c : panelCleaned.getComponents()) {
            if (c instanceof JTextField) {
                JTextField txt = (JTextField) c;
                txt.setText("");
            }
        }
    }

    public static boolean isTextFieldEmpty(JPanel panel) {
        List<String> txtField = new ArrayList<>();
        for (Component c : panel.getComponents()) {
            if (c instanceof JTextField) {
                JTextField txt = (JTextField) c;
                txtField.add(txt.getText());
            }
        }
        return txtField.stream().noneMatch(txt -> txt.equals(""));
    }
}
