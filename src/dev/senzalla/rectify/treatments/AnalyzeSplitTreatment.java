package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.AnalyzeSplit;
import dev.senzalla.rectify.request.AnalyzeSplitRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static dev.senzalla.rectify.treatments.DateTreatment.convertDateUtil;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class AnalyzeSplitTreatment {

    public static void initComboBoxSplit(JComboBox<Object> cbx) {
        cbx.removeAllItems();
        cbx.addItem("Cod. Cisão");
        new AnalyzeSplitRequest().select().forEach(cbx::addItem);
    }

    public static void initTable(JTable tableAnalyzeSplit) {
        fillTable(tableAnalyzeSplit, new AnalyzeSplitRequest().select());
    }

    public static void setTableFilters(JTable tableAnalyzeSplit, Long idAnalyzeSplit, Date dateOf, Date dateUntil) {
        List<String> clause = new ArrayList<>();
        AnalyzeSplit analyzeSplit = new AnalyzeSplit();
        if (idAnalyzeSplit > 0) {
            clause.add("idAnalyzeSplit =");
            analyzeSplit.setIdAnalyzeSplit(idAnalyzeSplit);
        }
        if (dateUntil != null && dateOf != null) {
            clause.add("dateAnalyzeSplit between");
            analyzeSplit.setDateAnalyzeSplit(dateOf);
            clause.add("");
            analyzeSplit.setDateBetween(dateUntil);

        } else {
            if (dateOf != null) {
                clause.add("dateAnalyzeSplit =");
                analyzeSplit.setDateAnalyzeSplit(dateOf);
            }
            if (dateUntil != null) {
                clause.add("dateAnalyzeSplit =");
                analyzeSplit.setDateAnalyzeSplit(dateUntil);
            }
        }
        List<AnalyzeSplit> analyzeSplits = new AnalyzeSplitRequest().select(clause, analyzeSplit);
        if (!analyzeSplits.isEmpty()) {
            fillTable(tableAnalyzeSplit, analyzeSplits);

        } else {
            PopUp.searchNoResults("Analise");
        }
    }

    private static void fillTable(JTable tableAnalyzeSplit, List<AnalyzeSplit> analyzeSplits) {
        DefaultTableModel tableModel = (DefaultTableModel) tableAnalyzeSplit.getModel();
        tableModel.setNumRows(0);
        analyzeSplits.forEach(analyzeSplit -> tableModel.addRow(new Object[]{
                analyzeSplit.getIdAnalyzeSplit(),
                analyzeSplit.getFattyAcidPercentSplit(),
                analyzeSplit.getSludgePercentSplit(),
                analyzeSplit.getGlycerinPercentSplit(),
                analyzeSplit.getTrashPercentSplit(),
                convertDateUtil(analyzeSplit.getDateAnalyzeSplit()),
                analyzeSplit.getTimeAnalyzeSplit()
        }));
    }

    public void checkAnalyzeSplit(String fattySplit, String sludgeSplit, String glycerinSplit, String trashSplit) {
        double fatty = Integer.parseInt(fattySplit);
        double sludge = Integer.parseInt(sludgeSplit);
        double glycerin = Integer.parseInt(glycerinSplit);
        double trash = Integer.parseInt(trashSplit);

        if ((fatty + sludge + glycerin + trash) == 99 || (fatty + sludge + glycerin + trash) == 100) {
            this.saveAnalyzeSplit(fatty, sludge, glycerin, trash);
        }
    }

    private void saveAnalyzeSplit(double fatty, double sludge, double glycerin, double trash) {
        AnalyzeSplit analyzeSplit = new AnalyzeSplit();
        analyzeSplit.setFattyAcidPercentSplit(fatty);
        analyzeSplit.setSludgePercentSplit(sludge);
        analyzeSplit.setGlycerinPercentSplit(glycerin);
        analyzeSplit.setTrashPercentSplit(trash);
        new AnalyzeSplitRequest().insert(analyzeSplit);
    }
}
