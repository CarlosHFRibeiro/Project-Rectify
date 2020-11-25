package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.Provider;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.request.ProviderRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProviderTreatement {
    public void showTable(JTable tbl) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);

        new ProviderRequest().select().forEach(provider
                -> model.addRow(new Object[]{
                provider.getNameProvider(),
                provider.getCnpjProvider(),
                provider.getPhoneProvider()
        }));
    }

    public void saveProvider(JPanel pnlProvider, JTextField txtName, JTextField txtCnpj, JTextField txtPhone) {
        if (new TxtTreatment().isTxtVoid(pnlProvider)) {
            Provider provider = new Provider();
            provider.setPhoneProvider(txtPhone.getText());
            provider.setCnpjProvider(txtCnpj.getText());
            provider.setNameProvider(txtName.getText());
            new ProviderRequest().insert(provider);
            new TxtTreatment().cleanTxt(pnlProvider);
        } else {
            new EmptyField().showMsg();
        }
    }

    public void showTable(JTable tbl, Provider provider) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        if (!new ProviderRequest().select(provider).isEmpty()) {
            new ProviderRequest().select(provider).forEach(p
                    -> model.addRow(new Object[]{
                    p.getNameProvider(),
                    p.getCnpjProvider(),
                    p.getPhoneProvider()
            }));
        } else {
            PopUp.isEmpty("Fornecedor");
        }
    }
}
