/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.treatments;


import dev.senzalla.rectify.entitys.Naoh;
import dev.senzalla.rectify.exception.FieldException;
import dev.senzalla.rectify.request.NaohRequest;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class NaohTreatment {

    public void showSolutionNaoh(JList<String> lstSolNaoh) {
        Set<String> naohs = new HashSet<>();
        DefaultListModel model = new DefaultListModel();
        lstSolNaoh.setModel(model);

        new NaohRequest().select().forEach(naoh -> naohs.add(naoh.toString()));
        naohs.forEach(model::addElement);
    }

    public String panelInsert() {
        return PopUp.panelInsert("NaoH");
    }

    public void addSolutionNaoh() {
        new NaohRequest().insert(getNaoh());
    }

    private Naoh getNaoh() {
        try {
            String solution = new NaohTreatment().panelInsert();
            Naoh naoh = new Naoh();
            naoh.setValueNaoh(Double.parseDouble(solution));
            return naoh;
        } catch (NumberFormatException ex) {
            throw new FieldException();
        }
    }

    public void updateSolutionNaoh(JList<String> lstSolNaoh) {
        Naoh naoh = getNaoh();
        naoh.setIdNaoh(getIdNaoh(lstSolNaoh));
        new NaohRequest().update(naoh);
    }

    public Long getIdNaoh(JList<String> lstSolNaoh) {
        return new NaohRequest().select().stream().filter(naoh ->
                naoh.getValueNaoh() == Double.parseDouble(lstSolNaoh.getSelectedValue()))
                .findFirst().map(Naoh::getIdNaoh)
                .orElse(null);
    }

    public void deleteSolutionNaoh(JList<String> lstSolNaoh) {
        String del = PopUp.panelDelete("");
        if (del.toUpperCase().equals("S")) {
            Naoh naoh = new Naoh();
            naoh.setIdNaoh(getIdNaoh(lstSolNaoh));
            new NaohRequest().delete(naoh);
        } else {
            PopUp.cancelOperation();
        }
    }

    public void deleteAllSolutionNaoh() {
        String del = PopUp.panelDelete("todos ");
        if (del.toUpperCase().equals("S")) {
            new NaohRequest().deleteAll();
        } else {
            PopUp.cancelOperation();
        }
    }
}
