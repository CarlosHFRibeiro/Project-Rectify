package dev.senzalla.rectify.entitys;

import java.time.LocalDateTime;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class LabTank {
    private Long idTq;
    private int trashTq;
    private double acidTq;
    private double soapTq;
    private LocalDateTime dtTq;
    private Tank tank;

    public Long getIdTq() {
        return idTq;
    }

    public void setIdTq(Long idTq) {
        this.idTq = idTq;
    }

    public int getTrashTq() {
        return trashTq;
    }

    public void setTrashTq(int trashTq) {
        this.trashTq = trashTq;
    }

    public double getAcidTq() {
        return acidTq;
    }

    public void setAcidTq(double acidTq) {
        this.acidTq = acidTq;
    }

    public double getSoapTq() {
        return soapTq;
    }

    public void setSoapTq(double soapTq) {
        this.soapTq = soapTq;
    }

    public LocalDateTime getDtTq() {
        return dtTq;
    }

    public void setDtTq(LocalDateTime dtTq) {
        this.dtTq = dtTq;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }
}
