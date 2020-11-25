package dev.senzalla.rectify.treatments;

import com.toedter.calendar.JDateChooser;
import dev.senzalla.rectify.entitys.LabSplit;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.request.LabSplitRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

import static dev.senzalla.rectify.treatments.DateTretment.convertDateUtil;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class LabSplitTreatment {

    private DefaultTableModel model;

    public void showTable(JTable tbl) {
        model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        new LabSplitRequest().select().forEach(this::table);
    }

    public void showTable(JTable tbl, JSpinner spnCod, JDateChooser dtcDt, JDateChooser dtcDtAte) {
        List<String> clause = new ArrayList<>();
        LabSplit labSplit = new LabSplit();
        if (!spnCod.getValue().equals(0)) {
            clause.add("idSplit =");
            labSplit.setIdSplit(Long.valueOf(spnCod.getValue().toString()));
        }

        if (dtcDtAte.getDate() != null && dtcDt.getDate() != null) {
            clause.add("dtSplit between");
            labSplit.setDtSplit(dtcDt.getDate());
            clause.add("");
            labSplit.setDateBetween(dtcDtAte.getDate());

        } else {
            if (dtcDt.getDate() != null) {
                clause.add("dtSplit =");
                labSplit.setDtSplit(dtcDt.getDate());
            }
        }

        if (!new LabSplitRequest().select(clause, labSplit).isEmpty()) {
            model = (DefaultTableModel) tbl.getModel();
            model.setNumRows(0);
            new LabSplitRequest().select(clause, labSplit).forEach(this::table);
        } else {
            PopUp.isEmpty("Analise");
        }
    }

    private void table(LabSplit labSplit) {
        model.addRow(new Object[]{
                labSplit.getIdSplit(),
                labSplit.getOilSplit(),
                labSplit.getSludgeSplit(),
                labSplit.getGlycerinSplit(),
                labSplit.getTrashSplit(),
                convertDateUtil(labSplit.getDtSplit()),
                labSplit.getHrSplit()
        });
    }

    public void addComboBox(JComboBox<Object> cbx) {
        cbx.removeAllItems();
        cbx.addItem("Cod. Cisão");
        new LabSplitRequest().select().forEach(cbx::addItem);
    }


    public void saveSplit(JPanel pnlLabSplit, JFormattedTextField txtOil, JFormattedTextField txtSludge, JFormattedTextField txtGlycerin, JFormattedTextField txtTrash) {
        if (new TxtTreatment().isTxtVoid(pnlLabSplit)) {
            int oil = Integer.parseInt(txtOil.getText());
            int sludge = Integer.parseInt(txtSludge.getText());
            int glycerin = Integer.parseInt(txtGlycerin.getText());
            int trash = Integer.parseInt(txtTrash.getText());
            if ((oil + sludge + glycerin + trash) == 99 || (oil + sludge + glycerin + trash) == 100) {
                LabSplit labSplit = new LabSplit();
                labSplit.setOilSplit(oil);
                labSplit.setSludgeSplit(sludge);
                labSplit.setGlycerinSplit(glycerin);
                labSplit.setTrashSplit(trash);
                new LabSplitRequest().insert(labSplit);
                new TxtTreatment().cleanTxt(pnlLabSplit);
            }
        } else {
            new EmptyField().showMsg();
        }
    }
}
