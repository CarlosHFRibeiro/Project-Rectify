/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.treatments;


import dev.senzalla.rectify.entitys.Hcl;
import dev.senzalla.rectify.exception.FieldException;
import dev.senzalla.rectify.request.RequestHcl;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatmentHcl {

    public void showSolutionHcl(JList<Hcl> lstSolHcl) {
        DefaultListModel<Hcl> model = new DefaultListModel<>();
        lstSolHcl.setModel(model);

        Set<Hcl> hcls = new HashSet<>(new RequestHcl().select());
        hcls.forEach(model::addElement);
    }

    public String panelInsert() {
        return PopUp.panelInsert("HCl");
    }

    public void addSolutionHcl() {
        try {
            String solution = new TreatmentHcl().panelInsert();
            if (solution != null) {
                Hcl hcl = new Hcl();
                hcl.setValueHcl(Double.parseDouble(solution));
                new RequestHcl().insert(hcl);
            }
        } catch (NumberFormatException ex) {
            new FieldException();
        }
    }


    public void updateSolutionHcl(JList<Hcl> lstSolHcl) {
        try {
            String solution = new TreatmentHcl().panelInsert();
            if (solution != null) {
                Hcl hcl = new Hcl();
                hcl.setValueHcl(Double.parseDouble(solution));
                hcl.setIdHcl(getIdHcl(lstSolHcl));
                new RequestHcl().update(hcl);
            }
        } catch (NumberFormatException ex) {
            new FieldException();
        }
    }

    public Long getIdHcl(JList<Hcl> lstSolHcl) {
        return new RequestHcl().select().stream().filter(naoh ->
                naoh.getValueHcl() == Double.parseDouble(String.valueOf(lstSolHcl.getSelectedValue())))
                .findFirst().map(Hcl::getIdHcl)
                .orElse(null);
    }

    public void deleteSolutionHcl(JList<Hcl> lstSolHcl) {
        String del = PopUp.panelDelete("");
        if (del.toUpperCase().equals("S")) {
            Hcl naoh = new Hcl();
            naoh.setIdHcl(getIdHcl(lstSolHcl));
            new RequestHcl().delete(naoh);
        } else {
            PopUp.cancelOperation();
        }
    }

    public void deleteAllSolutionHcl() {
        String del = PopUp.panelDelete("todos ");
        if (del.toUpperCase().equals("S")) {
            new RequestHcl().deleteAll();
        } else {
            PopUp.cancelOperation();
        }
    }

    public void showComboBox(JComboBox<Object> cbxConcentration) {
        new RequestHcl().select().forEach(cbxConcentration::addItem);
    }
}