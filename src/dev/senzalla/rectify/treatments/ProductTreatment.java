package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.Product;
import dev.senzalla.rectify.request.ProductRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ProductTreatment {

    public static void initComboBox(JComboBox<Object> comboBoxProduct) {
        comboBoxProduct.removeAllItems();
        comboBoxProduct.addItem("Produto");
        new ProductRequest().select().forEach(comboBoxProduct::addItem);
    }

    public static void initTable(JTable tableProduct) {
        DefaultTableModel tableModel = (DefaultTableModel) tableProduct.getModel();
        tableModel.setNumRows(0);

        new ProductRequest().select().forEach(product
                -> tableModel.addRow(new Object[]{
            product.getNameProduct(),
            product.getDensityProduct()
        }));
    }

    public void saveProduct(String nameProduct, String density) {
        Product product = new Product();
        product.setNameProduct(nameProduct);
        product.setDensityProduct(Double.parseDouble(density.replace(",", ".")));
        new ProductRequest().insert(product);
    }
}
