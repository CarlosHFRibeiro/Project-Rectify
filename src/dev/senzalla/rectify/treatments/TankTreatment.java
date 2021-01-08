package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.Product;
import dev.senzalla.rectify.entitys.StockTank;
import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.request.TankRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TankTreatment {

    public static void initTable(JTable tableTank) {
        DefaultTableModel tankModel = (DefaultTableModel) tableTank.getModel();
        tankModel.setNumRows(0);

        new TankRequest().select().forEach(tank
                -> tankModel.addRow(new Object[]{
                tank.getNameTank(),
                tank.getCapacityTank()
        }));
    }

    public static void initComboBox(JComboBox<Object> comboBoxTank) {
        comboBoxTank.removeAllItems();
        comboBoxTank.addItem("Tanque");
        new TankRequest().select().forEach(comboBoxTank::addItem);
    }

    public static void setFilterComboBox(JComboBox<Object> comboBoxTank, Product product, Date dateEntry, Date dateExit) {
        comboBoxTank.removeAllItems();
        comboBoxTank.addItem("Tanque");
        StockTankTreatment.setFilterComboBoxTank(product,dateEntry,dateExit).stream().map(StockTank::getTank).forEach(comboBoxTank::addItem);
    }

    public void saveTanque(String nameTank, String capacity) {
            Tank tank = new Tank();
            tank.setNameTank(nameTank);
            tank.setCapacityTank(Integer.parseInt(capacity));
            new TankRequest().insert(tank);
    }
}
