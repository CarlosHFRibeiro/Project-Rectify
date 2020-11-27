package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.Product;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.request.RequestProduct;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class TreatmentProduct {
    public void showTable(JTable tbl) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);

        new RequestProduct().select().forEach(product
                -> model.addRow(new Object[]{
                product.getNameProduct(),
                product.getDensityProduct()
        }));
    }

    public void saveProduct(JPanel pnlProduct, JTextField txtName, JTextField txtDensity) {
        if (new TreatmentTxt().isTxtVoid(pnlProduct)) {
            Product product = new Product();
            product.setNameProduct(txtName.getText());
            product.setDensityProduct(Double.parseDouble(txtDensity.getText().replace(",", ".")));
            new RequestProduct().insert(product);
            new TreatmentTxt().cleanTxt(pnlProduct);
        } else {
            new EmptyField().showMsg();
        }
    }

    public void addComboBox(JComboBox<Object> cbx) {
        cbx.removeAllItems();
        cbx.addItem("Produto");
        new RequestProduct().select().forEach(cbx::addItem);
    }

    public Product getProduct(Object product) {
        return new RequestProduct().selectName((Product) product);
    }
}
