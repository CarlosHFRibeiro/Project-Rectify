package dev.senzalla.rectify.entitys;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class Driver {
    private Long idDriver;
    private String cnhDriver;
    private String nameDriver;

    public Driver() {
    }

    public Long getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Long idDriver) {
        this.idDriver = idDriver;
    }

    public String getCnhDriver() {
        return cnhDriver;
    }

    public void setCnhDriver(String cnhDriver) {
        this.cnhDriver = cnhDriver;
    }

    public String getNameDriver() {
        return nameDriver;
    }

    public void setNameDriver(String nameDriver) {
        this.nameDriver = nameDriver;
    }
}
