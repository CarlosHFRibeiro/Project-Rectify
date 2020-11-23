package dev.senzalla.rectify.entitys;


import dev.senzalla.rectify.treatments.DateTretment;

import java.sql.Date;
import java.sql.Time;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class LabSplit extends DateTretment {
    private Long idSplit;
    private int oilSplit;
    private int sludgeSplit;
    private int glycerinSplit;
    private int trashSplit;
    private Date dtSplit;
    private Time hrSplit;

    public Long getIdSplit() {
        return idSplit;
    }

    public void setIdSplit(Long idSplit) {
        this.idSplit = idSplit;
    }

    public int getOilSplit() {
        return oilSplit;
    }

    public void setOilSplit(int oilSplit) {
        this.oilSplit = oilSplit;
    }

    public int getSludgeSplit() {
        return sludgeSplit;
    }

    public void setSludgeSplit(int sludgeSplit) {
        this.sludgeSplit = sludgeSplit;
    }

    public int getGlycerinSplit() {
        return glycerinSplit;
    }

    public void setGlycerinSplit(int glycerinSplit) {
        this.glycerinSplit = glycerinSplit;
    }

    public int getTrashSplit() {
        return trashSplit;
    }

    public void setTrashSplit(int trashSplit) {
        this.trashSplit = trashSplit;
    }

    public Date getDtSplit() {
        return dtSplit;
    }

    public void setDtSplit(Date dtSplit) {
        this.dtSplit = dtSplit;
    }

    public void setDtSplit(java.util.Date dtSplit) {
        this.dtSplit = convertDateSql(dtSplit);
    }

    public Time getHrSplit() {
        return hrSplit;
    }

    public void setHrSplit(Time hrSplit) {
        this.hrSplit = hrSplit;
    }

    @Override
    public String toString() {
        return String.valueOf(getIdSplit());
    }
}
