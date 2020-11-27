package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.Provider;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.request.RequestProvider;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Bomsalvez
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatementProvider {
    public void showTable(JTable tbl) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);

        new RequestProvider().select().forEach(provider
                -> model.addRow(new Object[]{
                provider.getNameProvider(),
                provider.getCnpjProvider(),
                provider.getPhoneProvider()
        }));
    }

    public void saveProvider(JPanel pnlProvider, JTextField txtName, JTextField txtCnpj, JTextField txtPhone) {
        if (new TreatmentTxt().isTxtVoid(pnlProvider)) {
            Provider provider = new Provider();
            provider.setPhoneProvider(txtPhone.getText());
            provider.setCnpjProvider(txtCnpj.getText());
            provider.setNameProvider(txtName.getText());
            new RequestProvider().insert(provider);
            new TreatmentTxt().cleanTxt(pnlProvider);
        } else {
            new EmptyField().showMsg();
        }
    }

    public void showTable(JTable tbl, Provider provider) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        if (!new RequestProvider().select(provider).isEmpty()) {
            new RequestProvider().select(provider).forEach(p
                    -> model.addRow(new Object[]{
                    p.getNameProvider(),
                    p.getCnpjProvider(),
                    p.getPhoneProvider()
            }));
        } else {
            PopUp.isEmpty("Fornecedor");
        }
    }

    public void showComboBox(JComboBox<Object> cbx) {
        cbx.removeAllItems();
        cbx.addItem("Fornecedor");
        new RequestProvider().select().forEach(cbx::addItem);
    }

    public  Provider provider(JComboBox<Object> cbxProvider) {
        Provider provider = new Provider();
        provider.setNameProvider(String.valueOf(cbxProvider.getSelectedItem()));
        return provider;
    }
}
