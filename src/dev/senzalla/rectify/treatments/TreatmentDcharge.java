package dev.senzalla.rectify.treatments;

import com.toedter.calendar.JDateChooser;
import dev.senzalla.rectify.canvas.FrmDchargeTbl;
import dev.senzalla.rectify.entitys.*;
import dev.senzalla.rectify.request.RequestDcharge;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatmentDcharge {

    private DefaultTableModel model;

    public void showTable(JTable tbl) {
        List<Discharge> dcharges = new RequestDcharge().select();
        FrmDchargeTbl.query(dcharges);
        model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        dcharges.forEach(this::table);
    }

    public void showTable(JTable tbl, JSpinner spnCod, JDateChooser dtcDtOf, JDateChooser dtcDtUp, JSpinner spnTicket, JSpinner spnNote, JComboBox<Object> cbxProduct, JComboBox<Object> cbxProvider) {
        List<String> clause = new ArrayList<>();
        Discharge dcharge = new Discharge();
        if (!spnCod.getValue().equals(0)) {
            clause.add("idDcharge =");
            dcharge.setIdDcharge(Long.valueOf(spnCod.getValue().toString()));
        }
        if (dtcDtOf.getDate() != null && dtcDtUp.getDate() != null) {
            clause.add("dtOfDcharge between");
            dcharge.setDtOfDcharge(dtcDtOf.getDate());
            clause.add("");
            dcharge.setDateBetween(dtcDtUp.getDate());

        } else {
            if (dtcDtOf.getDate() != null) {
                clause.add("dtOfDcharge =");
                dcharge.setDtOfDcharge(dtcDtOf.getDate());
            }
            if (dtcDtUp.getDate() != null) {
                clause.add("dtOfDcharge =");
                dcharge.setDtOfDcharge(dtcDtUp.getDate());
            }
        }
        if (!spnTicket.getValue().equals(0)) {
            clause.add("ticketDcharge =");
            dcharge.setTicketDcharge(Integer.parseInt(spnTicket.getValue().toString()));
        }
        if (!spnNote.getValue().equals(0)) {
            clause.add("noteDcharge =");
            dcharge.setNoteDcharge(Integer.parseInt(spnNote.getValue().toString()));
        }
        if (cbxProvider.getSelectedIndex() > 0) {
            clause.add("nameProvider =");
            dcharge.setProvider((Provider) cbxProvider.getSelectedItem());
        }
        if (cbxProduct.getSelectedIndex() > 0) {
            clause.add("nameProduct =");
            dcharge.setProduct((Product) cbxProduct.getSelectedItem());
        }
        List<Discharge> dcharges = new RequestDcharge().select(clause, dcharge);
        if (!dcharges.isEmpty()) {
            FrmDchargeTbl.query(dcharges);
            model = (DefaultTableModel) tbl.getModel();
            model.setNumRows(0);
            dcharges.forEach(this::table);
        } else {
            PopUp.isEmpty("Carregamento");
        }
    }

    private void table(Discharge dcharge) {
        model.addRow(new Object[]{
                dcharge.getIdDcharge(),
                TreatmentDate.convertDateUtil(dcharge.getDtOfDcharge()),
                dcharge.getTicketDcharge(),
                dcharge.getProvider(),
                dcharge.getProduct(),
                dcharge.getLiterDcharge()
        });
    }

    public void clear(JPanel pnlDcharge) {
        new TreatmentTxt().cleanTxt(pnlDcharge);
        new TreatmentCbx().cleanCbx(pnlDcharge);
        new TreatmentDtc().cleanDtc(pnlDcharge);
        new TreatmentSpn().cleanSpn(pnlDcharge);
    }

    public void saveDchage(JPanel pnlDcharge, JComboBox<Object> cbxProvider, JDateChooser dtcDtOf, JFormattedTextField txtHrOf, JSpinner spnNote, JSpinner spnTicket, JTextField txtBoard, Driver driver, JDateChooser dtcDtUp, JFormattedTextField txtHrUp, JComboBox<Object> cbxProduct, JComboBox<Object> cbxLabCar, JFormattedTextField txtBurden, JTextField txtLitter, JComboBox<Object> cbxTank) {
        Discharge dcharge = new Discharge();
        dcharge.setProvider((Provider) cbxProvider.getSelectedItem());
        dcharge.setDtOfDcharge(dtcDtOf.getDate());
        dcharge.setHrOfDcharge(Time.valueOf(txtHrOf.getText()));
        dcharge.setNoteDcharge(Integer.parseInt(spnNote.getValue().toString()));
        dcharge.setTicketDcharge(Integer.parseInt(spnTicket.getValue().toString()));
        dcharge.setBoardDcharge(txtBoard.getText());
        dcharge.setDriver(driver);
        dcharge.setDtUpDcharge(dtcDtUp.getDate());
        dcharge.setHrUpDcharge(Time.valueOf(txtHrUp.getText()));
        dcharge.setProduct((Product) cbxProduct.getSelectedItem());
        dcharge.setLabCar((LabCar) cbxLabCar.getSelectedItem());
        dcharge.setBurdenDcharge(Integer.parseInt(txtBurden.getText()));
        dcharge.setLiterDcharge(Integer.parseInt(txtLitter.getText()));
        dcharge.setTank((Tank) cbxTank.getSelectedItem());
        new RequestDcharge().insert(dcharge);
        clear(pnlDcharge);

    }

    public int calcLitter(Object selectedItem, int keyChar) {
        LabCar labCar = (LabCar) selectedItem;
        return (int) (keyChar / labCar.getDensityCar());
    }

}
