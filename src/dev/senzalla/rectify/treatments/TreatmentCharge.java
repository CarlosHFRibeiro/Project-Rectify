package dev.senzalla.rectify.treatments;

import com.toedter.calendar.JDateChooser;
import dev.senzalla.rectify.canvas.FrmChargeTbl;
import dev.senzalla.rectify.entitys.*;
import dev.senzalla.rectify.request.RequestCharge;

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
public class TreatmentCharge {

    private DefaultTableModel model;

    public void showTable(JTable tbl) {
        List<Charge> charges = new RequestCharge().select();
        FrmChargeTbl.query(charges);
        model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        charges.forEach(this::table);
    }

    public void showTable(JTable tbl, JSpinner spnCod, JDateChooser dtcDtOf, JDateChooser dtcDtUp, JSpinner spnTicket, JSpinner spnNote, JComboBox<Object> cbxProduct, JComboBox<Object> cbxProvider) {
        List<String> clause = new ArrayList<>();
        Charge charge = new Charge();
        if (!spnCod.getValue().equals(0)) {
            clause.add("idCharge =");
            charge.setIdCharge(Long.valueOf(spnCod.getValue().toString()));
        }
        if (dtcDtOf.getDate() != null && dtcDtUp.getDate() != null) {
            clause.add("dtOfCharge between");
            charge.setDtOfCharge(dtcDtOf.getDate());
            clause.add("");
            charge.setDateBetween(dtcDtUp.getDate());

        } else {
            if (dtcDtOf.getDate() != null) {
                clause.add("dtOfCharge =");
                charge.setDtOfCharge(dtcDtOf.getDate());
            }
            if (dtcDtUp.getDate() != null) {
                clause.add("dtOfCharge =");
                charge.setDtOfCharge(dtcDtUp.getDate());
            }
        }
        if (!spnTicket.getValue().equals(0)) {
            clause.add("ticketCharge =");
            charge.setTicketCharge(Integer.parseInt(spnTicket.getValue().toString()));
        }
        if (!spnNote.getValue().equals(0)) {
            clause.add("noteCharge =");
            charge.setNoteCharge(Integer.parseInt(spnNote.getValue().toString()));
        }
        if (cbxProvider.getSelectedIndex() > 0) {
            clause.add("nameProvider =");
            charge.setProvider((Provider) cbxProvider.getSelectedItem());
        }
        if (cbxProduct.getSelectedIndex() > 0) {
            clause.add("nameProduct =");
            charge.setProduct((Product) cbxProduct.getSelectedItem());
        }
        List<Charge> charges = new RequestCharge().select(clause, charge);
        if (!charges.isEmpty()) {
            FrmChargeTbl.query(charges);
            model = (DefaultTableModel) tbl.getModel();
            model.setNumRows(0);
            charges.forEach(this::table);
        } else {
            PopUp.isEmpty("Carregamento");
        }
    }

    private void table(Charge charge) {
        model.addRow(new Object[]{
                charge.getIdCharge(),
                TreatmentDate.convertDateUtil(charge.getDtOfCharge()),
                charge.getTicketCharge(),
                charge.getProvider(),
                charge.getProduct(),
                charge.getLiterCharge()
        });
    }

    public void clear(JPanel pnlCharge) {
        new TreatmentTxt().cleanTxt(pnlCharge);
        new TreatmentCbx().cleanCbx(pnlCharge);
        new TreatmentDtc().cleanDtc(pnlCharge);
        new TreatmentSpn().cleanSpn(pnlCharge);
    }

    public void saveChage(JPanel pnlCharge, JComboBox<Object> cbxProvider, JDateChooser dtcDtOf, JFormattedTextField txtHrOf, JSpinner spnNote, JSpinner spnTicket, JTextField txtBoard, Driver driver, JDateChooser dtcDtUp, JFormattedTextField txtHrUp, JComboBox<Object> cbxProduct, JComboBox<Object> cbxLabCar, JFormattedTextField txtBurden, JTextField txtLitter, JComboBox<Object> cbxTank) {
        Charge charge = new Charge();
        charge.setProvider((Provider) cbxProvider.getSelectedItem());
        charge.setDtOfCharge(dtcDtOf.getDate());
        charge.setHrOfCharge(Time.valueOf(txtHrOf.getText()));
        charge.setNoteCharge(Integer.parseInt(spnNote.getValue().toString()));
        charge.setTicketCharge(Integer.parseInt(spnTicket.getValue().toString()));
        charge.setBoardCharge(txtBoard.getText());
        charge.setDriver(driver);
        charge.setDtUpCharge(dtcDtUp.getDate());
        charge.setHrUpCharge(Time.valueOf(txtHrUp.getText()));
        charge.setProduct((Product) cbxProduct.getSelectedItem());
        charge.setLabCar((LabCar) cbxLabCar.getSelectedItem());
        charge.setBurdenCharge(Integer.parseInt(txtBurden.getText()));
        charge.setLiterCharge(Integer.parseInt(txtLitter.getText()));
        charge.setTank((Tank) cbxTank.getSelectedItem());
        new RequestCharge().insert(charge);
        clear(pnlCharge);

    }

    public int calcLitter(Object selectedItem, int keyChar) {
        LabCar labCar = (LabCar) selectedItem;
        return (int) (keyChar / labCar.getDensityCar());
    }

}
