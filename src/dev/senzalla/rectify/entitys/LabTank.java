package dev.senzalla.rectify.entitys;


import dev.senzalla.rectify.treatments.DateTretment;

import java.sql.Date;
import java.sql.Time;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class LabTank extends DateTretment {
    private Long idTq;
    private int trashTq;
    private double acidTq;
    private double soapTq;
    private Date dtTq;
    private Time hrTq;
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

    public Date getDtTq() {
        return dtTq;
    }

    public void setDtTq(java.util.Date dtTq) {
        this.dtTq = convertDateSql(dtTq);
    }

    public Time getHrTq() {
        return hrTq;
    }

    public void setHrTq(Time hrTq) {
        this.hrTq = hrTq;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }
}
