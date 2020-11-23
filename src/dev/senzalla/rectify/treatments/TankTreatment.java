package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.request.TankRequest;

import javax.swing.*;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class TankTreatment {
    public void addComboBox(JComboBox<Object> cbx) {
        cbx.removeAllItems();
        cbx.addItem("Tanque");
        new TankRequest().select().forEach(cbx::addItem);
    }

    public void saveTanque(JPanel pnlTank, JTextField txtName, JTextField txtCapacity) {
        if (new TxtTreatment().isTxtVoid(pnlTank)) {
            Tank tank = new Tank();
            tank.setNameTank(txtName.getText());
            tank.setCapacityTank(Integer.parseInt(txtCapacity.getText()));
            new TankRequest().insert(tank);
            new TxtTreatment().cleanTxt(pnlTank);
        } else {
            new EmptyField().showMsg();
        }
    }
}
