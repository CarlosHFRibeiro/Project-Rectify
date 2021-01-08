package dev.senzalla.rectify.entitys;


import dev.senzalla.rectify.treatments.DateTreatment;

import java.sql.Date;
import java.sql.Time;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class AnalyzeTank extends DateTreatment {
    private Long idAnalyzeTank;
    private int trashTank;
    private double acidityTank;
    private double saponityTank;
    private Date dateAnalyzeTank;
    private Time timeAnalyzeTank;
    private Tank tank;

    public AnalyzeTank() {
    }

    public AnalyzeTank(Tank tank) {
        this.tank = tank;
    }

    public Long getIdAnalyzeTank() {
        return idAnalyzeTank;
    }

    public void setIdAnalyzeTank(Long idAnalyzeTank) {
        this.idAnalyzeTank = idAnalyzeTank;
    }

    public int getTrashTank() {
        return trashTank;
    }

    public void setTrashTank(int trashTank) {
        this.trashTank = trashTank;
    }

    public double getAcidityAnalyzeTank() {
        return acidityTank;
    }

    public void setAcidityAnalyzeTank(double acidityAnalyzeTank) {
        this.acidityTank = acidityAnalyzeTank;
    }

    public double getSaponityTank() {
        return saponityTank;
    }

    public void setSaponityTank(double saponityTank) {
        this.saponityTank = saponityTank;
    }

    public Date getDateAnalyzeTank() {
        return dateAnalyzeTank;
    }

    public void setDateAnalyzeTank(java.util.Date dateAnalyzeTank) {
        this.dateAnalyzeTank = convertDateSql(dateAnalyzeTank);
    }

    public Time getTimeAnalyzeTank() {
        return timeAnalyzeTank;
    }

    public void setTimeAnalyzeTank(Time timeAnalyzeTank) {
        this.timeAnalyzeTank = timeAnalyzeTank;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    @Override
    public String toString() {
        return String.valueOf(getIdAnalyzeTank());
    }
}
