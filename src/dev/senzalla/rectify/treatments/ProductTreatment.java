package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.Product;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.request.ProductRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class ProductTreatment {
    public void showTable(JTable tbl) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);

        new ProductRequest().select().forEach(product
                -> model.addRow(new Object[]{
                product.getNameProduct(),
                product.getDensityProduct()
        }));
    }

    public void saveProduct(JPanel pnlProduct, String nameProduct, String density) {
        if (TreatmentTxt.isTxtEmpty(pnlProduct)) {
            Product product = new Product();
            product.setNameProduct(nameProduct);
            product.setDensityProduct(Double.parseDouble(density.replace(",", ".")));
            new ProductRequest().insert(product);
            TreatmentTxt.cleanTxt(pnlProduct);
        } else {
            EmptyField.showMsg();
        }
    }

    public void addComboBox(JComboBox<Object> cbx) {
        cbx.removeAllItems();
        cbx.addItem("Produto");
        new ProductRequest().select().forEach(cbx::addItem);
    }
}
