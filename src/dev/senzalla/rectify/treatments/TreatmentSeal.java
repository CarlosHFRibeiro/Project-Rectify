package dev.senzalla.rectify.treatments;

import com.toedter.calendar.JDateChooser;
import dev.senzalla.rectify.frame.FrmSealTbl;
import dev.senzalla.rectify.entitys.Provider;
import dev.senzalla.rectify.entitys.Seal;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.request.RequestSeal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

import static dev.senzalla.rectify.treatments.TreatmentDate.convertDateUtil;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatmentSeal {

    private DefaultTableModel model;

    public void showTable(JTable tbl) {
        model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        new RequestSeal().select().forEach(this::table);
    }

    public void showTable(JTable tbl, JComboBox<Object> cbxSale, JComboBox<Object> cbxProvider, JDateChooser dtcDe, JDateChooser dtcAte) {
        List<String> clause = new ArrayList<>();
        Seal seal = new Seal();
        if (cbxSale.getSelectedIndex() > 0) {
            clause.add("saleSeal =");
            seal.setSaleSeal(Integer.parseInt(cbxSale.getSelectedItem().toString()));
        }
        if (cbxProvider.getSelectedIndex() > 0) {
            Provider provider = new Provider();
            provider.setNameProvider(String.valueOf(cbxProvider.getSelectedItem()));
            clause.add("nameProvider =");
            seal.setProvider(provider);
        }

        if (dtcAte.getDate() != null && dtcDe.getDate() != null) {
            clause.add("dtSeal between");
            seal.setDtSeal(dtcDe.getDate());
            clause.add("");
            seal.setDateBetween(dtcAte.getDate());
        } else {
            if (dtcDe.getDate() != null) {
                clause.add("dtSeal =");
                seal.setDtSeal(dtcDe.getDate());
            }
            if (dtcAte.getDate() != null) {
                clause.add("dtSeal =");
                seal.setDtSeal(dtcAte.getDate());
            }

        }

        model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        FrmSealTbl.query(clause, seal);
        selectQuery(clause, seal).forEach(this::table);
    }

    public List<Seal> selectQuery(List<String> clause, Seal seal) {
        return  new RequestSeal().select(clause, seal);
    }

    private void table(Seal seal) {
        model.addRow(new Object[]{
            seal.getSaleSeal(),
            seal.getClientSeal(),
            seal.getFactorySeal(),
            seal.getBrSeal(),
            seal.getProvider(),
            convertDateUtil(seal.getDtSeal())
        });
    }

    public void saveSeal(JPanel pnlSeal, JFormattedTextField txtSale, JFormattedTextField txtFactory, JFormattedTextField txtClient, JFormattedTextField txtBr, JComboBox<Object> cbxProvider) {
        if (TreatmentTxt.isTxtEmpty(pnlSeal) && cbxProvider.getSelectedIndex() > 0) {
            Provider provider = new Provider();
            provider.setIdProvider((long) cbxProvider.getSelectedIndex());
            Seal seal = new Seal();
            seal.setProvider(provider);
            seal.setBrSeal(Integer.parseInt(txtBr.getText()));
            seal.setFactorySeal(Integer.parseInt(txtFactory.getText()));
            seal.setClientSeal(Integer.parseInt(txtClient.getText()));
            seal.setSaleSeal(Integer.parseInt(txtSale.getText()));
            new RequestSeal().insert(seal);
            TreatmentTxt.cleanTxt(pnlSeal);
            CbxTreatment.cleanCbx(pnlSeal);
        } else {
            EmptyField.showMsg();
        }
    }

    public void showSale(JComboBox<Object> cbx) {
        cbx.removeAllItems();
        cbx.addItem("Leilão");
        new RequestSeal().sale().forEach(cbx::addItem);
    }

}
