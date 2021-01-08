package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.enuns.Collect;
import dev.senzalla.rectify.treatments.DateTreatment;

import java.sql.Date;
import java.sql.Time;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class AnalyzeTruck extends DateTreatment {

    private Long idAnalyzeTruck;
    private int trashTruck;
    private double acidityTruck;
    private double densityTruck;
    private double saponityTruck;
    private Collect collect;
    private Date dateAnalyzeTruck;
    private Time timeAnalyzeTruck;
    private Product product;

    public AnalyzeTruck() {
    }

    public AnalyzeTruck(Product product) {
        this.product = product;
    }

    public Long getIdAnalyzeTruck() {
        return idAnalyzeTruck;
    }

    public void setIdAnalyzeTruck(Long idAnalyzeTruck) {
        this.idAnalyzeTruck = idAnalyzeTruck;
    }

    public int getTrashTruck() {
        return trashTruck;
    }

    public void setTrashTruck(int trashTruck) {
        this.trashTruck = trashTruck;
    }

    public double getAcidityTruck() {
        return acidityTruck;
    }

    public void setAcidityTruck(double acidityTruck) {
        this.acidityTruck = acidityTruck;
    }

    public double getDensityTruck() {
        return densityTruck;
    }

    public void setDensityTruck(double densityTruck) {
        this.densityTruck = densityTruck;
    }

    public double getSaponityTruck() {
        return saponityTruck;
    }

    public void setSaponityTruck(double saponityTruck) {
        this.saponityTruck = saponityTruck;
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

    public Date getDateAnalyzeTruck() {
        return dateAnalyzeTruck;
    }

    public void setDateAnalyzeTruck(java.util.Date dateAnalyzeTruck) {
        this.dateAnalyzeTruck = convertDateSql(dateAnalyzeTruck);
    }

    public Time getTimeAnalyzeTruck() {
        return timeAnalyzeTruck;
    }

    public void setTimeAnalyzeTruck(Time timeAnalyzeTruck) {
        this.timeAnalyzeTruck = timeAnalyzeTruck;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return String.valueOf(getIdAnalyzeTruck());
    }
}
