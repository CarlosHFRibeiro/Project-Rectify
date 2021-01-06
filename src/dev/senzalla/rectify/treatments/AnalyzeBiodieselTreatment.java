package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.AnalyzeBiodiesel;
import dev.senzalla.rectify.request.AnalyzeBiodieselRequest;

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
public class AnalyzeBiodieselTreatment {

    public static void initTable(JTable tableAnalyzeBiodiesel) {
        fillTable(tableAnalyzeBiodiesel, new AnalyzeBiodieselRequest().select(null, null));
    }

    public static void setTableFilters(JTable tableAnalyzeBiodiesel, Long idAnalyzeBiodiesel, Date dateOf, Date dateUntil) {
        System.out.println("teste");
        List<String> clause = new ArrayList<>();
        AnalyzeBiodiesel analyzeBiodiesel = new AnalyzeBiodiesel();
        if (idAnalyzeBiodiesel > 0) {
            clause.add("idAnalyzeBiodiesel =");
            analyzeBiodiesel.setIdAnalyzeBiodiesel(idAnalyzeBiodiesel);
        }

        if (dateOf != null && dateUntil != null) {
            clause.add("dateAnalyzeBiodiesel between");
            analyzeBiodiesel.setDateAnalyzeBiodiesel(dateOf);
            clause.add("");
            analyzeBiodiesel.setDateBetween(dateUntil);

        } else {
            if (dateOf != null) {
                clause.add("dateAnalyzeBiodiesel =");
                analyzeBiodiesel.setDateAnalyzeBiodiesel(dateOf);
            }
            if (dateUntil != null) {
                clause.add("dateAnalyzeBiodiesel =");
                analyzeBiodiesel.setDateAnalyzeBiodiesel(dateUntil);
            }
        }

        List<AnalyzeBiodiesel> analyzeBiodiesels = new AnalyzeBiodieselRequest().select(clause, analyzeBiodiesel);

        if (!analyzeBiodiesels.isEmpty()) {
            fillTable(tableAnalyzeBiodiesel, analyzeBiodiesels);
        } else {
            PopUp.searchNoResults("Analise");
        }
    }

    private static void fillTable(JTable tableAnalyzeBiodiesel, List<AnalyzeBiodiesel> analyzeBiodiesels) {
        DefaultTableModel tableModel = (DefaultTableModel) tableAnalyzeBiodiesel.getModel();
        tableModel.setNumRows(0);
        analyzeBiodiesels.forEach(analyzeBiodiesel ->
                tableModel.addRow(new Object[]{
                        analyzeBiodiesel.getIdAnalyzeBiodiesel(),
                        analyzeBiodiesel.getAcidityBiodiesel(),
                        analyzeBiodiesel.getDensityBiodiesel(),
                        convertDateUtil(analyzeBiodiesel.getDateAnalyzeBiodiesel()),
                        analyzeBiodiesel.getTimeAnalyzeBiodiesel()
                }));
    }

    public void saveAnalyzeBiodiesel(String acidity, String density, String density20Degress, String correctionFactor, String temperature) {
        AnalyzeBiodiesel analyzeBiodiesel = new AnalyzeBiodiesel();
        analyzeBiodiesel.setAcidityBiodiesel(Double.parseDouble(acidity));
        analyzeBiodiesel.setDensityBiodiesel(Double.parseDouble(density));
        analyzeBiodiesel.setDensityBiodiesel(Double.parseDouble(density20Degress));
        analyzeBiodiesel.setTemperatureBiodiesel(Double.parseDouble(temperature));
        analyzeBiodiesel.setCorrectionFactorBiodiesel(Double.parseDouble(correctionFactor));
        new AnalyzeBiodieselRequest().insert(analyzeBiodiesel);
    }
}
