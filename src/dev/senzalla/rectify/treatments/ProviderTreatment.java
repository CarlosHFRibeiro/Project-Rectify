package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.Provider;
import dev.senzalla.rectify.request.ProviderRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ProviderTreatment {

    public static void initComboBox(JComboBox<Object> cbxProvider) {
        cbxProvider.removeAllItems();
        cbxProvider.addItem("Fornecedor");
        new ProviderRequest().select(null).forEach(cbxProvider::addItem);
    }

    public static void initTable(JTable tblProvider, Provider provider) {

        if (!new ProviderRequest().select(provider).isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) tblProvider.getModel();
            model.setNumRows(0);
            new ProviderRequest().select(provider).forEach(p
                    -> model.addRow(new Object[]{
                p.getNameProvider(),
                p.getCnpjProvider(),
                p.getPhoneProvider()
            }));
        } else {
            if (provider != null) {
                PopUp.searchNoResults("Fornecedor");
            }
        }
    }

    public void saveProvider(String name, String cnpj, String phone) {
            Provider provider = new Provider();
            provider.setNameProvider(name);
            provider.setCnpjProvider(cnpj);
            provider.setPhoneProvider(phone);
            new ProviderRequest().insert(provider);
    }
}
