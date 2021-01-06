package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.AnalyzeTank;
import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.request.AnalyzeTankRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static dev.senzalla.rectify.treatments.DateTreatment.convertDateUtil;

/**
 * @author Bomsalvez
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class AnalyzeTankTreatment {

    public static void initComboBox(JComboBox<Object> comboBoxAnalyze ,AnalyzeTank analyzeTank) {
        comboBoxAnalyze.removeAllItems();
        comboBoxAnalyze.addItem("Cod Analise");
        new AnalyzeTankRequest().select(null, analyzeTank).forEach(comboBoxAnalyze::addItem);
    }

    public static void initTable(JTable tableAnalyzeTank) {
        fillTable(tableAnalyzeTank, new AnalyzeTankRequest().select(null, null));
    }

    public static void setTableFilters(JTable tableAnalyzeTank, Long idAnalyzeTank, Date dateOf, Date dateUntil) {
        List<String> clause = new ArrayList<>();
        AnalyzeTank analyzeTank = new AnalyzeTank();
        if (idAnalyzeTank > 0) {
            clause.add("idAnalyzeTank =");
            analyzeTank.setIdAnalyzeTank(idAnalyzeTank);
        }

        if (dateUntil != null && dateOf != null) {
            clause.add("dateAnalyzeTank between");
            analyzeTank.setDateAnalyzeTank(dateOf);
            clause.add("");
            analyzeTank.setDateBetween(dateUntil);

        } else {
            if (dateOf != null) {
                clause.add("dateAnalyzeTank =");
                analyzeTank.setDateAnalyzeTank(dateOf);
            }
            if (dateUntil != null) {
                clause.add("dateAnalyzeTank =");
                analyzeTank.setDateAnalyzeTank(dateUntil);
            }
        }

        if (!new AnalyzeTankRequest().select(clause, analyzeTank).isEmpty()) {
            fillTable(tableAnalyzeTank, new AnalyzeTankRequest().select(clause, analyzeTank));
        } else {
            PopUp.searchNoResults("Analise");
        }
    }

    private static void fillTable(JTable tableAnalyzeTank, List<AnalyzeTank> analyzeTanks) {
        DefaultTableModel tableModel = (DefaultTableModel) tableAnalyzeTank.getModel();
        tableModel.setNumRows(0);
        analyzeTanks.forEach(analyzeTank
                -> tableModel.addRow(new Object[]{
            analyzeTank.getIdAnalyzeTank(),
            analyzeTank.getAcidityAnalyzeTank(),
            analyzeTank.getSaponityTank(),
            analyzeTank.getTrashTank(),
            analyzeTank.getTank(),
            convertDateUtil(analyzeTank.getDateAnalyzeTank()),
            analyzeTank.getTimeAnalyzeTank()
        }));
    }

    public void saveLabTank(Tank tank, String acidity, String saponity, String trash) {
        AnalyzeTank analyzeTank = new AnalyzeTank();
        analyzeTank.setTank(tank);
        analyzeTank.setAcidityAnalyzeTank(Double.parseDouble(acidity));
        analyzeTank.setSaponityTank(Double.parseDouble(saponity));
        analyzeTank.setTrashTank(Integer.parseInt(trash));
        new AnalyzeTankRequest().insert(analyzeTank);
    }
}
