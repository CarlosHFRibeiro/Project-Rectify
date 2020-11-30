package dev.senzalla.rectify.treatments;

import com.toedter.calendar.JDateChooser;
import dev.senzalla.rectify.entitys.*;
import dev.senzalla.rectify.request.RequestCharge;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.sql.Time;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatmentCharge {

    private DefaultTableModel model;

    public void showTable(JTable tbl) {
        model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        new RequestCharge().select().forEach(this::table);
    }

//    public void showTable(JTable tbl, JComboBox<Object> cbxProduct, JDateChooser dtcDe, JDateChooser dtcAte) {
//        List<String> clause = new ArrayList<>();
//        Charge charge = new Charge();
//        if (cbxProduct.getSelectedIndex() > 0) {
//            Product product = new Product();
//            product.setNameProduct(String.valueOf(cbxProduct.getSelectedItem()));
//            clause.add("nameProduct =");
//            stockProduct.setProduct(product);
//        }
//        if (dtcAte.getDate() != null && dtcDe.getDate() != null) {
//            clause.add("dtStkPd between");
//            stockProduct.setDtStkPd(dtcDe.getDate());
//            clause.add("");
//            stockProduct.setDateBetween(dtcAte.getDate());
//
//        } else {
//            if (dtcDe.getDate() != null) {
//                clause.add("dtStkPd =");
//                stockProduct.setDtStkPd(dtcDe.getDate());
//            }
//            if (dtcAte.getDate() != null) {
//                clause.add("dtStkPd =");
//                stockProduct.setDtStkPd(dtcAte.getDate());
//            }
//        }
//        if (!new RequestStockProduct().select(clause, charge).isEmpty()) {
//            model = (DefaultTableModel) tbl.getModel();
//            model.setNumRows(0);
////            .query(clause, charge);
//            selectQuery(clause, charge).forEach(this::table);
//        } else {
//            PopUp.isEmpty("Estoque");
//        }
//    }

    public List<Charge> selectQuery(List<String> clause, Charge charge) {
        return new RequestCharge().select(clause, charge);
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
