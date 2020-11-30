package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.enuns.Collect;
import dev.senzalla.rectify.treatments.TreatmentDate;

import java.sql.Date;
import java.sql.Time;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class LabCar extends TreatmentDate {
    private Long idCar;
    private int trashCar;
    private double acidCar;
    private double soapCar;
    private double densityCar;
    private Date dtCar;
    private Time hrCar;
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

    public Date getDtCar() {
        return dtCar;
    }

    public void setDtCar(java.util.Date dtCar) {
        this.dtCar = convertDateSql(dtCar);
    }

    public Time getHrCar() {
        return hrCar;
    }

    public void setHrCar(Time hrCar) {
        this.hrCar = hrCar;
    }

    public Collect getCollect() {
        return collect;
    }

    public void setCollect(Collect collect) {
        this.collect = collect;
    }

    public void setCollect(int collect) {
        switch (collect) {
            case 1:
                this.collect = Collect.BOCA;
                break;
            case 2:
                this.collect = Collect.SONDA;
                break;
            case 3:
                this.collect = Collect.DRENO;
                break;
            case 4:
                this.collect = Collect.BOMBA;
                break;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(getIdCar());
    }
}
