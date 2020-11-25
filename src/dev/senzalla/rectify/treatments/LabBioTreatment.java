package dev.senzalla.rectify.treatments;

import com.toedter.calendar.JDateChooser;
import dev.senzalla.rectify.entitys.LabBio;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.request.LabBioRequest;

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
public class LabBioTreatment {
    private DefaultTableModel model;

    public void showTable(JTable tbl) {
        model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        new LabBioRequest().select().forEach(this::table);
    }

    public void showTable(JTable tbl, JSpinner spnCod, JDateChooser dtcDt, JDateChooser dtcDtAte) {
        List<String> clause = new ArrayList<>();
        LabBio labBio = new LabBio();
        if (!spnCod.getValue().equals(0)) {
            clause.add("idBio =");
            labBio.setIdBio(Long.valueOf(spnCod.getValue().toString()));
        }

        if (dtcDtAte.getDate() != null && dtcDt.getDate() != null) {
            clause.add("dtBio between");
            labBio.setDtBio(dtcDt.getDate());
            clause.add("");
            labBio.setDateBetween(dtcDtAte.getDate());

        } else {
            if (dtcDt.getDate() != null) {
                clause.add("dtBio =");
                labBio.setDtBio(dtcDt.getDate());
            }
        }

        if (!new LabBioRequest().select(clause, labBio).isEmpty()) {
            model = (DefaultTableModel) tbl.getModel();
            model.setNumRows(0);
            new LabBioRequest().select(clause, labBio).forEach(this::table);
        } else {
            PopUp.isEmpty("Analise");
        }
    }

    private void table(LabBio labBio) {
        model.addRow(new Object[]{
                labBio.getIdBio(),
                labBio.getAcidBio(),
                labBio.getDensityBio(),
                convertDateUtil(labBio.getDtBio()),
                labBio.getHrBio()
        });
    }

    public void saveLabBio(JPanel pnlLabBio, JTextField txtAcid, JTextField txtDens, JTextField txtDens20, JTextField txtTemp, JTextField txtFactor) {
        if (new TxtTreatment().isTxtVoid(pnlLabBio)) {
            LabBio labBio = new LabBio();
            labBio.setAcidBio(Double.parseDouble(txtAcid.getText()));
            labBio.setDensityBio(Double.parseDouble(txtDens.getText()));
            labBio.setDensityBio(Double.parseDouble(txtDens20.getText()));
            labBio.setTempBio(Double.parseDouble(txtTemp.getText()));
            labBio.setFactorBio(Double.parseDouble(txtFactor.getText()));
            new LabBioRequest().insert(labBio);
            new TxtTreatment().cleanTxt(pnlLabBio);
        } else {
            new EmptyField().showMsg();
        }
    }
}
