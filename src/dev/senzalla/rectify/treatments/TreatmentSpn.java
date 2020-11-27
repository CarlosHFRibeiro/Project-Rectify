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
public class TreatmentSpn {

    private List<Object> spnField;

    public void cleanSpn(JPanel pnl) {
        for (Component c : pnl.getComponents()) {
            if (c instanceof JSpinner) {
                JSpinner spn = (JSpinner) c;
                spn.setValue(0);
            }
        }
    }

    public boolean isSpnVoid(JPanel pnl) {
        setSpn(pnl);
        return spnField.stream().noneMatch(txt -> txt.equals(0));
    }

    private void setSpn(JPanel pnl) {
        spnField = new ArrayList<>();
        for (Component c : pnl.getComponents()) {
            if (c instanceof JSpinner) {
                JSpinner spn = (JSpinner) c;
                spnField.add(spn.getValue());
            }
        }
    }
}
