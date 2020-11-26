package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.request.RequestTank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatmentTank {
    public void showTable(JTable tbl) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);

        new RequestTank().select().forEach(tank
                -> model.addRow(new Object[]{
                tank.getNameTank(),
                tank.getCapacityTank()
        }));
    }

    public void saveTanque(JPanel pnlTank, JTextField txtName, JTextField txtCapacity) {
        if (new TreatmentTxt().isTxtVoid(pnlTank)) {
            Tank tank = new Tank();
            tank.setNameTank(txtName.getText());
            tank.setCapacityTank(Integer.parseInt(txtCapacity.getText()));
            new RequestTank().insert(tank);
            new TreatmentTxt().cleanTxt(pnlTank);
        } else {
            new EmptyField().showMsg();
        }
    }


    public void showComboBox(JComboBox<Object> cbx) {
        cbx.removeAllItems();
        cbx.addItem("Tanque");
        new RequestTank().select().forEach(cbx::addItem);
    }
}
