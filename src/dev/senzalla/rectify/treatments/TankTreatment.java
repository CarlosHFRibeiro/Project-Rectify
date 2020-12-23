package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.request.TankRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TankTreatment {

    /**
     * @param tblTank {@link JTable}
     */
    public static void initTable(JTable tblTank) {
        DefaultTableModel model = (DefaultTableModel) tblTank.getModel();
        model.setNumRows(0);

        new TankRequest().select().forEach(tank
                -> model.addRow(new Object[]{
                tank.getNameTank(),
                tank.getCapacityTank()
        }));
    }

    /**
     * @param cbxTank {@link JComboBox}
     */
    public static void initComboBox(JComboBox<Object> cbxTank) {
        cbxTank.removeAllItems();
        cbxTank.addItem("Tanque");
        new TankRequest().select().forEach(cbxTank::addItem);
    }

    /**
     * @param pnlTank  {@link JPanel}
     * @param nameTank {@link String}
     * @param capacity {@link String}
     */
    public void saveTanque(JPanel pnlTank, String nameTank, String capacity) {
        if (TreatmentTxt.isTxtEmpty(pnlTank)) {
            Tank tank = new Tank();
            tank.setNameTank(nameTank);
            tank.setCapacityTank(Integer.parseInt(capacity));
            new TankRequest().insert(tank);
            TreatmentTxt.cleanTxt(pnlTank);
        } else {
            EmptyField.showMsg();
        }
    }
}