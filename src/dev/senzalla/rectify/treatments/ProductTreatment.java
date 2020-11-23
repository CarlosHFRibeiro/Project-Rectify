package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.request.ProductRequest;
import dev.senzalla.rectify.request.TankRequest;

import javax.swing.*;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class ProductTreatment {

    public void addComboBox(JComboBox<Object> cbx) {
        cbx.removeAllItems();
        cbx.addItem("Produto");
        new ProductRequest().select().forEach(cbx::addItem);
    }
}
