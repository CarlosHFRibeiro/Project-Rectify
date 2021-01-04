package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.Hcl;
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

    public static void initComboBox(JComboBox<Object> cbxConcentration) {
        new HclRequest().select().forEach(cbxConcentration::addItem);
    }

    public static void initList(JList<Hcl> lstSolHcl) {
        DefaultListModel<Hcl> model = new DefaultListModel<>();
        lstSolHcl.setModel(model);

        Set<Hcl> hcls = new HashSet<>(new HclRequest().select());
        hcls.forEach(model::addElement);
    }

    public void addSolutionHcl() {
        try {
            String solution = PopUp.panelInsert("HCl");
            if (solution != null) {
                Hcl hcl = new Hcl();
                hcl.setConcentrationHcl(Double.parseDouble(solution));
                new HclRequest().insert(hcl);
            }
        } catch (NumberFormatException ex) {
            PopUp.notValidNumber();
        }
    }


    public void updateSolutionHcl(JList<Hcl> lstSolHcl) {
        try {
            String solution = PopUp.panelInsert("HCl");
            if (solution != null) {
                Hcl hcl = new Hcl();
                hcl.setConcentrationHcl(Double.parseDouble(solution));
                hcl.setIdHcl(getIdHcl(lstSolHcl));
                new HclRequest().update(hcl);
            }
        } catch (NumberFormatException ex) {
            PopUp.notValidNumber();
        }
    }



    public void deleteSolutionHcl(JList<Hcl> lstSolHcl) {
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

    private Long getIdHcl(JList<Hcl> lstSolHcl) {
        return new HclRequest().select().stream().filter(naoh ->
                naoh.getConcentrationHcl() == Double.parseDouble(String.valueOf(lstSolHcl.getSelectedValue())))
                .findFirst().map(Hcl::getIdHcl)
                .orElse(null);
    }
}
