package dev.senzalla.rectify.treatments;

import com.toedter.calendar.JDateChooser;
import dev.senzalla.rectify.entitys.LabCar;
import dev.senzalla.rectify.entitys.LabCarSplit;
import dev.senzalla.rectify.entitys.LabSplit;
import dev.senzalla.rectify.enuns.Collect;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.request.RequestLabCar;
import dev.senzalla.rectify.request.RequestLabCarSplit;

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
public class TreatmentLabCar {
    private DefaultTableModel model;

    public void CollectComboBox(JComboBox<Object> cbx) {
        cbx.removeAllItems();
        cbx.addItem("Coleta");
        Arrays.stream(Collect.values()).map(Collect::getDescricao).forEach(cbx::addItem);
    }

    public void saveLabCar(JPanel pnlLabCar, JTextField txtLabCarAcid, JTextField txtLabCarSoap, JTextField txtLabCarDens, JFormattedTextField txtLabCarTrash, JComboBox<Object> cbxLabCarCollect, JComboBox<Object> cbxLabCarSplit) {
        if (new TreatmentTxt().isTxtVoid(pnlLabCar) && cbxLabCarCollect.getSelectedIndex() > 0) {
            LabCar labCar = new LabCar();
            labCar.setAcidCar(Double.parseDouble(txtLabCarAcid.getText()));
            labCar.setSoapCar(Double.parseDouble(txtLabCarSoap.getText()));
            labCar.setDensityCar(Double.parseDouble(txtLabCarDens.getText()));
            labCar.setTrashCar(Integer.parseInt(txtLabCarTrash.getText()));
            labCar.setCollect(cbxLabCarCollect.getSelectedIndex());
            new RequestLabCar().insert(labCar);

            if (cbxLabCarSplit.getSelectedIndex() > 0) {
                LabSplit labSplit = new LabSplit();
                labSplit.setIdSplit((long) cbxLabCarSplit.getSelectedIndex());
                LabCarSplit labCarSplit = new LabCarSplit();
                labCarSplit.setLabSplit(labSplit);
                new RequestLabCarSplit().insert(labCarSplit);
            }
            new TreatmentTxt().cleanTxt(pnlLabCar);
            new TreatmentCbx().cleanCbx(pnlLabCar);
        } else {
            new EmptyField().showMsg();
        }
    }

    public void showTable(JTable tbl) {
        model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        new RequestLabCar().select().forEach(this::table);
    }

    public void showTable(JTable tbl, JSpinner spnCod, JDateChooser dtcDt, JDateChooser dtcDtAte) {
        List<String> clause = new ArrayList<>();
        LabCar labCar = new LabCar();
        if (!spnCod.getValue().equals(0)) {
            clause.add("idCar =");
            labCar.setIdCar(Long.valueOf(spnCod.getValue().toString()));
        }

        if (dtcDtAte.getDate() != null && dtcDt.getDate() != null) {
            clause.add("dtCar between");
            labCar.setDtCar(dtcDt.getDate());
            clause.add("");
            labCar.setDateBetween(dtcDtAte.getDate());

        } else {
            if (dtcDt.getDate() != null) {
                clause.add("dtCar =");
                labCar.setDtCar(dtcDt.getDate());
            }
            if (dtcDtAte.getDate() != null) {
                clause.add("dtCar =");
                labCar.setDtCar(dtcDtAte.getDate());
            }
        }

        if (!new RequestLabCar().select(clause, labCar).isEmpty()) {
            model = (DefaultTableModel) tbl.getModel();
            model.setNumRows(0);
            new RequestLabCar().select(clause, labCar).forEach(this::table);
        } else {
            PopUp.isEmpty("Analise");
        }
    }

    public void showComboBox(JComboBox<Object> cbxLabCarSplit, JComboBox<Object> cbxLabCarCollect) {
        new TreatmentLabSplit().addComboBox(cbxLabCarSplit);
        CollectComboBox(cbxLabCarCollect);
    }


    private void table(LabCar labCar) {
        model.addRow(new Object[]{
                labCar.getIdCar(),
                labCar.getAcidCar(),
                labCar.getSoapCar(),
                labCar.getTrashCar(),
                labCar.getDensityCar(),
                convertDateUtil(labCar.getDtCar()),
                labCar.getHrCar()
        });
    }

    public  LabCar labCar(JComboBox<Object> cbxLabCar) {
        LabCar labCar=new LabCar();
        labCar.setIdCar(Long.valueOf(cbxLabCar.getSelectedItem().toString()));
        return labCar;
    }

    public void showComboBox(JComboBox<Object> cbx) {
        cbx.removeAllItems();
        cbx.addItem("Cod. Analise");
        new RequestLabCar().select().forEach(cbx::addItem);
    }
}
