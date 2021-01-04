package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.Driver;
import dev.senzalla.rectify.request.DriverRequest;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class DriverTreatment {

    public void saveDriver(String name, String cnh) {
        Driver driver = new Driver();
        driver.setCnhDriver(cnh);
        driver.setNameDriver(name);
        new DriverRequest().insert(driver);
    }
}
