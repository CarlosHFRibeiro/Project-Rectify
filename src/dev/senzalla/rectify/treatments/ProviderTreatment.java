package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.Provider;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.request.ProviderRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ProviderTreatment {

    /**
     * @param cbxProvider {@link JComboBox}
     */
    public static void initComboBox(JComboBox<Object> cbxProvider) {
        cbxProvider.removeAllItems();
        cbxProvider.addItem("Fornecedor");
        new ProviderRequest().select(null).forEach(cbxProvider::addItem);
    }

    /**
     * @param tblProvider {@link JTable}
     * @param provider    {@link Provider}
     */
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
            PopUp.isEmpty("Fornecedor");
        }
    }

    /**
     * @param pnlProvider   {@link JPanel}
     * @param nameProvider  {@link String}
     * @param cnpjProvider  {@link String}
     * @param phoneProvider {@link String}
     */
    public void saveProvider(JPanel pnlProvider, String nameProvider, String cnpjProvider, String phoneProvider) {
        if (TreatmentTxt.isTxtEmpty(pnlProvider)) {
            Provider provider = new Provider();
            provider.setNameProvider(nameProvider);
            provider.setCnpjProvider(cnpjProvider);
            provider.setPhoneProvider(phoneProvider);
            new ProviderRequest().insert(provider);
            TreatmentTxt.cleanTxt(pnlProvider);
        } else {
            EmptyField.showMsg();
        }
    }
}
