package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.treatments.DateTreatment;

import java.sql.Date;
import java.sql.Time;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class AnalyzeBiodiesel extends DateTreatment {
    private Long idAnalyzeBiodiesel;
    private double acidityBiodiesel;
    private double densityBiodiesel;
    private double densityBiodiesel20Degress;
    private double correctionFactorBiodiesel;
    private double temperatureBiodiesel;
    private Date dateAnalyzeBiodiesel;
    private Time timeAnalyzeBiodiesel;

    public Long getIdAnalyzeBiodiesel() {
        return idAnalyzeBiodiesel;
    }

    public void setIdAnalyzeBiodiesel(Long idAnalyzeBiodiesel) {
        this.idAnalyzeBiodiesel = idAnalyzeBiodiesel;
    }

    public double getAcidityBiodiesel() {
        return acidityBiodiesel;
    }

    public void setAcidityBiodiesel(double acidityBiodiesel) {
        this.acidityBiodiesel = acidityBiodiesel;
    }

    public double getDensityBiodiesel() {
        return densityBiodiesel;
    }

    public void setDensityBiodiesel(double densityBiodiesel) {
        this.densityBiodiesel = densityBiodiesel;
    }

    public double getDensityBiodiesel20Degress() {
        return densityBiodiesel20Degress;
    }

    public void setDensityBiodiesel20Degress(double densityBiodiesel20Degress) {
        this.densityBiodiesel20Degress = densityBiodiesel20Degress;
    }

    public double getTemperatureBiodiesel() {
        return temperatureBiodiesel;
    }

    public void setTemperatureBiodiesel(double temperatureBiodiesel) {
        this.temperatureBiodiesel = temperatureBiodiesel;
    }

    public double getCorrectionFactorBiodiesel() {
        return correctionFactorBiodiesel;
    }

    public void setCorrectionFactorBiodiesel(double correctionFactorBiodiesel) {
        this.correctionFactorBiodiesel = correctionFactorBiodiesel;
    }

    public Date getDateAnalyzeBiodiesel() {
        return dateAnalyzeBiodiesel;
    }

    public void setDateAnalyzeBiodiesel(java.util.Date dateAnalyzeBiodiesel) {
        this.dateAnalyzeBiodiesel = convertDateSql(dateAnalyzeBiodiesel);
    }

    public Time getTimeAnalyzeBiodiesel() {
        return timeAnalyzeBiodiesel;
    }

    public void setTimeAnalyzeBiodiesel(Time timeAnalyzeBiodiesel) {
        this.timeAnalyzeBiodiesel = timeAnalyzeBiodiesel;
    }
}
