/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.treatments;


import dev.senzalla.rectify.entitys.Hcl;
import dev.senzalla.rectify.exception.FieldException;
import dev.senzalla.rectify.request.HclRequest;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class HclTreatment {

    public void showSolutionHcl(JList<String> lstSolHcl) {
        Set<String> hcls = new HashSet<>();
        DefaultListModel model = new DefaultListModel();
        lstSolHcl.setModel(model);

        new HclRequest().select().forEach(naoh -> hcls.add(naoh.toString()));
        hcls.forEach(model::addElement);
    }

    public String panelInsert() {
        return PopUp.panelInsert("HCl");
    }

    public void addSolutionHcl() {
        new HclRequest().insert(getHcl());
    }

    private Hcl getHcl() {
        try {
            String solution = new HclTreatment().panelInsert();
            Hcl naoh = new Hcl();
            naoh.setValueHcl(Double.parseDouble(solution));
            return naoh;
        } catch (NumberFormatException ex) {
            throw new FieldException();
        }
    }

    public void updateSolutionHcl(JList<String> lstSolHcl) {
        Hcl naoh = getHcl();
        naoh.setIdHcl(getIdHcl(lstSolHcl));
        new HclRequest().update(naoh);
    }

    public Long getIdHcl(JList<String> lstSolHcl) {
        return new HclRequest().select().stream().filter(naoh ->
                naoh.getValueHcl() == Double.parseDouble(lstSolHcl.getSelectedValue()))
                .findFirst().map(Hcl::getIdHcl)
                .orElse(null);
    }

    public void deleteSolutionHcl(JList<String> lstSolHcl) {
        String del = PopUp.panelDelete("");
        if (del.toUpperCase().equals("S")) {
            Hcl naoh = new Hcl();
            naoh.setIdHcl(getIdHcl(lstSolHcl));
            new HclRequest().delete(naoh);
        } else {
            PopUp.cancelOperation();
        }
    }

    public void deleteAllSolutionHcl() {
        String del = PopUp.panelDelete("todos ");
        if (del.toUpperCase().equals("S")) {
            new HclRequest().deleteAll();
        } else {
            PopUp.cancelOperation();
        }
    }
}
