package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.Naoh;
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

    public static void initComboBox(JComboBox<Object> cbxConcentration) {
        new NaohRequest().select().forEach(cbxConcentration::addItem);
    }

    public static void initList(JList<Naoh> listSolNaoh) {
        DefaultListModel<Naoh> model = new DefaultListModel<>();
        listSolNaoh.setModel(model);

        Set<Naoh> naohs = new HashSet<>(new NaohRequest().select());
        naohs.forEach(model::addElement);
    }

    public void addSolutionNaoh() {
        try {
            String solution = PopUp.panelInsert("NaoH");
            if (solution != null) {
                Naoh naoh = new Naoh();
                naoh.setConcentrationNaoh(Double.parseDouble(solution));
                new NaohRequest().insert(naoh);
            }
        } catch (NumberFormatException ex) {
            PopUp.notValidNumber();
        }
    }

    public void updateSolutionNaoh(JList<Naoh> listSolNaoh) {
        try {
            String solution = PopUp.panelInsert("NaoH");
            if (solution != null) {
                Naoh naoh = new Naoh();
                naoh.setConcentrationNaoh(Double.parseDouble(solution));
                naoh.setIdNaoh(getIdNaoh(listSolNaoh));
                new NaohRequest().update(naoh);
            }
        } catch (NumberFormatException ex) {
            PopUp.notValidNumber();
        }
    }

    public void deleteSolutionNaoh(JList<Naoh> listSolNaoh) {
        String del = PopUp.panelDelete("");
        if (del.toUpperCase().equals("S")) {
            Naoh naoh = new Naoh();
            naoh.setIdNaoh(getIdNaoh(listSolNaoh));
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

    private Long getIdNaoh(JList<Naoh> lstSolNaoh) {
        return new NaohRequest().select().stream().filter(naoh
                -> naoh.getConcentrationNaoh() == Double.parseDouble(String.valueOf(lstSolNaoh.getSelectedValue())))
                .findFirst().map(Naoh::getIdNaoh)
                .orElse(null);
    }
}
