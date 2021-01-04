package dev.senzalla.rectify.entitys;


import dev.senzalla.rectify.treatments.DateTreatment;

import java.sql.Date;
import java.sql.Time;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class AnalyzeSplit extends DateTreatment {
    private Long idAnalyzeSplit;
    private double fattyAcidPercentSplit;
    private double glycerinPercentSplit;
    private double sludgePercentSplit;
    private double trashPercentSplit;
    private Date dateAnalyzeSplit;
    private Time timeAnalyzeSplit;

    public AnalyzeSplit() {
    }

    public AnalyzeSplit(Long idAnalyzeSplit) {
        this.idAnalyzeSplit = idAnalyzeSplit;
    }

    public Long getIdAnalyzeSplit() {
        return idAnalyzeSplit;
    }

    public void setIdAnalyzeSplit(Long idAnalyzeSplit) {
        this.idAnalyzeSplit = idAnalyzeSplit;
    }

    public double getFattyAcidPercentSplit() {
        return fattyAcidPercentSplit;
    }

    public void setFattyAcidPercentSplit(double fattyAcidPercentSplit) {
        this.fattyAcidPercentSplit = fattyAcidPercentSplit;
    }

    public double getGlycerinPercentSplit() {
        return glycerinPercentSplit;
    }

    public void setGlycerinPercentSplit(double glycerinPercentSplit) {
        this.glycerinPercentSplit = glycerinPercentSplit;
    }

    public double getSludgePercentSplit() {
        return sludgePercentSplit;
    }

    public void setSludgePercentSplit(double sludgePercentSplit) {
        this.sludgePercentSplit = sludgePercentSplit;
    }

    public double getTrashPercentSplit() {
        return trashPercentSplit;
    }

    public void setTrashPercentSplit(double trashPercentSplit) {
        this.trashPercentSplit = trashPercentSplit;
    }

    public Date getDateAnalyzeSplit() {
        return dateAnalyzeSplit;
    }

    public void setDateAnalyzeSplit(java.util.Date dateAnalyzeSplit) {
        this.dateAnalyzeSplit = convertDateSql(dateAnalyzeSplit);
    }

    public Time getTimeAnalyzeSplit() {
        return timeAnalyzeSplit;
    }

    public void setTimeAnalyzeSplit(Time timeAnalyzeSplit) {
        this.timeAnalyzeSplit = timeAnalyzeSplit;
    }

    @Override
    public String toString() {
        return String.valueOf(getIdAnalyzeSplit());
    }
}
