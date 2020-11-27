package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.Driver;
import dev.senzalla.rectify.request.RequestDriver;

import javax.swing.*;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatmentDriver {


    public void saveDriver(JTextField txtChargeDriver, JFormattedTextField txtChargeCnh) {
        Driver driver=new Driver();
        driver.setCnhDriver(txtChargeCnh.getText());
        driver.setNameDriver(txtChargeDriver.getText());
        new RequestDriver().insert(driver);
    }
}
