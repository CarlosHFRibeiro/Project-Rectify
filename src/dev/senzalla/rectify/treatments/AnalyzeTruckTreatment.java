package dev.senzalla.rectify.treatments;

import com.toedter.calendar.JDateChooser;
import dev.senzalla.rectify.entitys.AnalyzeTruck;
import dev.senzalla.rectify.entitys.AnalyzeTruckSplit;
import dev.senzalla.rectify.entitys.LabSplit;
import dev.senzalla.rectify.enuns.Collect;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.request.RequestAnalyzeTruck;
import dev.senzalla.rectify.request.RequestAnalyzeTruckSplit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static dev.senzalla.rectify.treatments.TreatmentDate.convertDateUtil;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class AnalyzeTruckTreatment {
    private DefaultTableModel model;


    public static void initComboBoxCollect(JComboBox<Object> cbxCollect) {
        cbxCollect.removeAllItems();
        cbxCollect.addItem("Coleta");
        Arrays.stream(Collect.values()).map(Collect::getDescricao).forEach(cbxCollect::addItem);
    }

    public void initComboBoxAnalyze(JComboBox<Object> cbx) {
        cbx.removeAllItems();
        cbx.addItem("Cod. Analise");
        new RequestAnalyzeTruck().select().forEach(cbx::addItem);
    }

    public void checkAnalyzeTruck(JPanel pnlAnalyzeTruck, String analyzeTruckAcid, String analyzeTruckSoap, String analyzeTruckDens, String analyzeTruckTrash, JComboBox<Object> cbxanalyzeTruckCollect, JComboBox<Object> cbxAnalyzeTruckSplit) {
        if (TreatmentTxt.isTxtEmpty(pnlAnalyzeTruck) && cbxanalyzeTruckCollect.getSelectedIndex() > 0) {
            saveAnalyzeTruck(analyzeTruckAcid, analyzeTruckSoap, analyzeTruckTrash, analyzeTruckDens, cbxanalyzeTruckCollect);

            if (cbxAnalyzeTruckSplit.getSelectedIndex() > 0) {
                saveAnalyzeTruckSplit(cbxAnalyzeTruckSplit);
            }
            
            TreatmentTxt.cleanTxt(pnlAnalyzeTruck);
            CbxTreatment.cleanCbx(pnlAnalyzeTruck);
        } else {
            EmptyField.showMsg();
        }
    }

    private void saveAnalyzeTruck(String analyzeTruckAcid, String analyzeTruckSoap, String analyzeTruckTrash, String analyzeTruckDens, JComboBox<Object> cbxanalyzeTruckCollect) {
        AnalyzeTruck analyzeTruck = new AnalyzeTruck();
        analyzeTruck.setAcidCar(Double.parseDouble(analyzeTruckAcid));
        analyzeTruck.setSoapCar(Double.parseDouble(analyzeTruckSoap));
        analyzeTruck.setDensityCar(Double.parseDouble(analyzeTruckDens));
        analyzeTruck.setTrashCar(Integer.parseInt(analyzeTruckTrash));
        analyzeTruck.setCollect(cbxanalyzeTruckCollect.getSelectedIndex());
        new RequestAnalyzeTruck().insert(analyzeTruck);
    }

    private void saveAnalyzeTruckSplit(JComboBox<Object> cbxAnalyzeTruckSplit) {
        LabSplit labSplit = new LabSplit();
        labSplit.setIdSplit((long) cbxAnalyzeTruckSplit.getSelectedIndex());
        AnalyzeTruckSplit analyzeTruckSplit = new AnalyzeTruckSplit();
        analyzeTruckSplit.setLabSplit(labSplit);
        new RequestAnalyzeTruckSplit().insert(analyzeTruckSplit);
    }

    public void showTable(JTable tbl) {
        model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        new RequestAnalyzeTruck().select().forEach(this::table);
    }

    public void showTable(JTable tbl, JSpinner spnCod, JDateChooser dtcDt, JDateChooser dtcDtAte) {
        List<String> clause = new ArrayList<>();
        AnalyzeTruck analyzeTruck = new AnalyzeTruck();
        if (!spnCod.getValue().equals(0)) {
            clause.add("idCar =");
            analyzeTruck.setIdCar(Long.valueOf(spnCod.getValue().toString()));
        }

        if (dtcDtAte.getDate() != null && dtcDt.getDate() != null) {
            clause.add("dtCar between");
            analyzeTruck.setDtCar(dtcDt.getDate());
            clause.add("");
            analyzeTruck.setDateBetween(dtcDtAte.getDate());

        } else {
            if (dtcDt.getDate() != null) {
                clause.add("dtCar =");
                analyzeTruck.setDtCar(dtcDt.getDate());
            }
            if (dtcDtAte.getDate() != null) {
                clause.add("dtCar =");
                analyzeTruck.setDtCar(dtcDtAte.getDate());
            }
        }

        if (!new RequestAnalyzeTruck().select(clause, analyzeTruck).isEmpty()) {
            model = (DefaultTableModel) tbl.getModel();
            model.setNumRows(0);
            new RequestAnalyzeTruck().select(clause, analyzeTruck).forEach(this::table);
        } else {
            PopUp.isEmpty("Analise");
        }
    }

    private void table(AnalyzeTruck analyzeTruck) {
        model.addRow(new Object[]{
                analyzeTruck.getIdCar(),
                analyzeTruck.getAcidCar(),
                analyzeTruck.getSoapCar(),
                analyzeTruck.getTrashCar(),
                analyzeTruck.getDensityCar(),
                convertDateUtil(analyzeTruck.getDtCar()),
                analyzeTruck.getHrCar()
        });
    }



}
