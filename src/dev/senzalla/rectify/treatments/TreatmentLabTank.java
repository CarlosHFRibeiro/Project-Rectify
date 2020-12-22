package dev.senzalla.rectify.treatments;

import com.toedter.calendar.JDateChooser;
import dev.senzalla.rectify.entitys.LabTank;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.request.RequestLabTank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

import static dev.senzalla.rectify.treatments.TreatmentDate.convertDateUtil;

/**
 * @author Bomsalvez
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatmentLabTank {
    private DefaultTableModel model;

    public void showTable(JTable tbl) {
        model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        new RequestLabTank().select().forEach(this::table);
    }

    public void saveLabTank(JPanel pnlLabTk, JComboBox<Object> cbxTank, JTextField txtAcid, JTextField txtSoap, JFormattedTextField txtTrash) {
        if (new TreatmentTxt().isTxtVoid(pnlLabTk) && new TreatmentCbx().isCbxVoid(pnlLabTk)) {
            LabTank labTank = new LabTank();
            labTank.setTank(new TreatmentTank().getTank(cbxTank.getSelectedItem()));
            labTank.setAcidTq(Double.parseDouble(txtAcid.getText()));
            labTank.setSoapTq(Double.parseDouble(txtSoap.getText()));
            labTank.setTrashTq(Integer.parseInt(txtTrash.getText()));
            new RequestLabTank().insert(labTank);
            new TreatmentTxt().cleanTxt(pnlLabTk);
            new TreatmentCbx().cleanCbx(pnlLabTk);
        } else {
            new EmptyField().showMsg();
        }
    }

    public void showTable(JTable tbl, JSpinner spnCod, JDateChooser dtcDt, JDateChooser dtcDtAte) {
        List<String> clause = new ArrayList<>();
        LabTank labTank = new LabTank();
        if (!spnCod.getValue().equals(0)) {
            clause.add("idTq =");
            labTank.setIdTq(Long.valueOf(spnCod.getValue().toString()));
        }

        if (dtcDtAte.getDate() != null && dtcDt.getDate() != null) {
            clause.add("dtTq between");
            labTank.setDtTq(dtcDt.getDate());
            clause.add("");
            labTank.setDateBetween(dtcDtAte.getDate());

        } else {
            if (dtcDt.getDate() != null) {
                clause.add("dtTq =");
                labTank.setDtTq(dtcDt.getDate());
            }
            if (dtcDtAte.getDate() != null) {
                clause.add("dtTq =");
                labTank.setDtTq(dtcDtAte.getDate());
            }
        }

        if (!new RequestLabTank().select(clause, labTank).isEmpty()) {
            model = (DefaultTableModel) tbl.getModel();
            model.setNumRows(0);
            new RequestLabTank().select(clause, labTank).forEach(this::table);
        } else {
            PopUp.isEmpty("Analise");
        }
    }

    private void table(LabTank lab) {
        model.addRow(new Object[]{
                lab.getIdTq(),
                lab.getAcidTq(),
                lab.getSoapTq(),
                lab.getTrashTq(),
                lab.getTank(),
                convertDateUtil(lab.getDtTq()),
                lab.getHrTq()
        });
    }

    public void showComboBox(JComboBox<Object> cbx) {
        cbx.removeAllItems();
        cbx.addItem("Cod Analise");
        new RequestLabTank().select().forEach(cbx::addItem);
    }

    public void showComboBox(JComboBox<Object> cbx, LabTank labTank) {
        cbx.removeAllItems();
        cbx.addItem("Cod Analise");
        new RequestLabTank().select(labTank).forEach(cbx::addItem);
    }
}
