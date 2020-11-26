package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.StockTank;
import dev.senzalla.rectify.request.RequestStockTank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatmentStockTank {

    private DefaultTableModel model;

    public void showTable(JTable tbl) {
        model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        new RequestStockTank().select().forEach(this::table);
    }

//    public void showTable(JTable tbl, JComboBox<Object> cbxSale, JComboBox<Object> cbxProvider, JDateChooser dtcDe, JDateChooser dtcAte) {
//        List<String> clause = new ArrayList<>();
//        Seal seal = new Seal();
//        if (cbxSale.getSelectedIndex() > 0) {
//            clause.add("saleSeal =");
//            seal.setSaleSeal(Integer.parseInt(cbxSale.getSelectedItem().toString()));
//        }
//        if (cbxProvider.getSelectedIndex() > 0) {
//            Provider provider = new Provider();
//            provider.setNameProvider(String.valueOf(cbxProvider.getSelectedItem()));
//            clause.add("nameProvider =");
//            seal.setProvider(provider);
//        }
//
//        if (dtcAte.getDate() != null && dtcDe.getDate() != null) {
//            clause.add("dtSeal between");
//            seal.setDtSeal(dtcDe.getDate());
//            clause.add("");
//            seal.setDateBetween(dtcAte.getDate());
//        } else {
//            if (dtcDe.getDate() != null) {
//                clause.add("dtSeal =");
//                seal.setDtSeal(dtcDe.getDate());
//            }
//            if (dtcAte.getDate() != null) {
//                clause.add("dtSeal =");
//                seal.setDtSeal(dtcAte.getDate());
//            }
//
//        }
//
//        model = (DefaultTableModel) tbl.getModel();
//        model.setNumRows(0);
//        new RequestStockTank().select(clause, seal).forEach(this::table);
//    }

    private void table(StockTank stockTank) {
        model.addRow(new Object[]{
                stockTank.getTank(),
                stockTank.getProduct(),
                stockTank.getLiterStkTq()
        });
    }

//    public void saveSeal(JPanel pnlSeal, JFormattedTextField txtSale, JFormattedTextField
//            txtFactory, JFormattedTextField txtClient, JFormattedTextField txtBr, JComboBox<Object> cbxProvider) {
//        if (new TreatmentTxt().isTxtVoid(pnlSeal) && cbxProvider.getSelectedIndex() > 0) {
//            Provider provider = new Provider();
//            provider.setIdProvider((long) cbxProvider.getSelectedIndex());
//            Seal seal = new Seal();
//            seal.setProvider(provider);
//            seal.setBrSeal(Integer.parseInt(txtBr.getText()));
//            seal.setFactorySeal(Integer.parseInt(txtFactory.getText()));
//            seal.setClientSeal(Integer.parseInt(txtClient.getText()));
//            seal.setSaleSeal(Integer.parseInt(txtSale.getText()));
//            new SealRequest().insert(seal);
//            new TreatmentTxt().cleanTxt(pnlSeal);
//            new TreatmentCbx().cleanCbx(pnlSeal);
//        } else {
//            new EmptyField().showMsg();
//        }
//    }


    public void saveStockTank(JPanel pnlStk, JTable tbl) {
        
    }


}
