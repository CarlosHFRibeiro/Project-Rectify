/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class TxtTreatment {

    private List<String> txtField;

    public void cleanTxt(JPanel pnl) {
        for (Component c : pnl.getComponents()) {
            if (c instanceof JTextField) {
                JTextField txt = (JTextField) c;
                txt.setText("");
            }
        }
    }

    public boolean isTxtVoid(JPanel pnl) {
        setTxt(pnl);
        return txtField.stream().noneMatch(txt -> (txt.equals("")));
    }

    private void setTxt(JPanel pnl) {
        txtField = new ArrayList<>();
        for (Component c : pnl.getComponents()) {
            if (c instanceof JTextField) {
                JTextField txt = (JTextField) c;
                txtField.add(txt.getText());
            }
        }
    }
}
