package dev.senzalla.rectify.entitys;

import java.time.LocalDateTime;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class LabCar {
    private Long idCar;
    private int trashCar;
    private double acidCar;
    private double soapCar;
    private double densityCar;
    private LocalDateTime dtCar;
    private Collect collect;

    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long idCar) {
        this.idCar = idCar;
    }

    public int getTrashCar() {
        return trashCar;
    }

    public void setTrashCar(int trashCar) {
        this.trashCar = trashCar;
    }

    public double getAcidCar() {
        return acidCar;
    }

    public void setAcidCar(double acidCar) {
        this.acidCar = acidCar;
    }

    public double getSoapCar() {
        return soapCar;
    }

    public void setSoapCar(double soapCar) {
        this.soapCar = soapCar;
    }

    public double getDensityCar() {
        return densityCar;
    }

    public void setDensityCar(double densityCar) {
        this.densityCar = densityCar;
    }

    public LocalDateTime getDtCar() {
        return dtCar;
    }

    public void setDtCar(LocalDateTime dtCar) {
        this.dtCar = dtCar;
    }

    public Collect getCollect() {
        return collect;
    }

    public void setCollect(Collect collect) {
        this.collect = collect;
    }
}
