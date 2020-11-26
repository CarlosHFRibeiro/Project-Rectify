/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.treatments;


import dev.senzalla.rectify.entitys.Naoh;
import dev.senzalla.rectify.exception.FieldException;
import dev.senzalla.rectify.request.RequestNaoh;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatmentNaoh {

    public void showSolutionNaoh(JList<Naoh> lstSolNaoh) {
        DefaultListModel<Naoh> model = new DefaultListModel<>();
        lstSolNaoh.setModel(model);

        Set<Naoh> naohs = new HashSet<>(new RequestNaoh().select());
        naohs.forEach(model::addElement);
    }

    public void addSolutionNaoh() {
        try {
            String solution = PopUp.panelInsert("NaoH");
            if (solution != null) {
                Naoh naoh = new Naoh();
                naoh.setValueNaoh(Double.parseDouble(solution));
                new RequestNaoh().insert(naoh);
            }
        } catch (NumberFormatException ex) {
            new FieldException();
        }
    }


    public void updateSolutionNaoh(JList<Naoh> lstSolNaoh) {
        try {
            String solution = PopUp.panelInsert("NaoH");
            if (solution != null) {
                Naoh naoh = new Naoh();
                naoh.setValueNaoh(Double.parseDouble(solution));
                naoh.setIdNaoh(getIdNaoh(lstSolNaoh));
                new RequestNaoh().update(naoh);
            }
        } catch (NumberFormatException ex) {
            new FieldException();
        }
    }

    public Long getIdNaoh(JList<Naoh> lstSolNaoh) {
        return new RequestNaoh().select().stream().filter(naoh ->
                naoh.getValueNaoh() == Double.parseDouble(String.valueOf(lstSolNaoh.getSelectedValue())))
                .findFirst().map(Naoh::getIdNaoh)
                .orElse(null);
    }

    public void deleteSolutionNaoh(JList<Naoh> lstSolNaoh) {
        String del = PopUp.panelDelete("");
        if (del.toUpperCase().equals("S")) {
            Naoh naoh = new Naoh();
            naoh.setIdNaoh(getIdNaoh(lstSolNaoh));
            new RequestNaoh().delete(naoh);
        } else {
            PopUp.cancelOperation();
        }
    }

    public void deleteAllSolutionNaoh() {
        String del = PopUp.panelDelete("todos ");
        if (del.toUpperCase().equals("S")) {
            new RequestNaoh().deleteAll();
        } else {
            PopUp.cancelOperation();
        }
    }

    public void showComboBox(JComboBox<Object> cbxConcentration) {
        new RequestNaoh().select().forEach(cbxConcentration::addItem);
    }
}
