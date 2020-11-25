package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.treatments.DateTretment;

import java.sql.Date;
import java.sql.Time;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class LabBio extends DateTretment {
    private Long idBio;
    private double acidBio;
    private double densityBio;
    private double density20Bio;
    private double tempBio;
    private double factorBio;
    private Date dtBio;
    private Time hrBio;

    public Long getIdBio() {
        return idBio;
    }

    public void setIdBio(Long idBio) {
        this.idBio = idBio;
    }

    public double getAcidBio() {
        return acidBio;
    }

    public void setAcidBio(double acidBio) {
        this.acidBio = acidBio;
    }

    public double getDensityBio() {
        return densityBio;
    }

    public void setDensityBio(double densityBio) {
        this.densityBio = densityBio;
    }

    public double getDensity20Bio() {
        return density20Bio;
    }

    public void setDensity20Bio(double density20Bio) {
        this.density20Bio = density20Bio;
    }

    public double getTempBio() {
        return tempBio;
    }

    public void setTempBio(double tempBio) {
        this.tempBio = tempBio;
    }

    public double getFactorBio() {
        return factorBio;
    }

    public void setFactorBio(double factorBio) {
        this.factorBio = factorBio;
    }

    public Date getDtBio() {
        return dtBio;
    }

    public void setDtBio(java.util.Date dtBio) {
        this.dtBio = convertDateSql(dtBio);
    }

    public Time getHrBio() {
        return hrBio;
    }

    public void setHrBio(Time hrBio) {
        this.hrBio = hrBio;
    }
}
