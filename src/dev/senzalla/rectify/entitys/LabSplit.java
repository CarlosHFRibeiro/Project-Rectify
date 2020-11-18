package dev.senzalla.rectify.entitys;

import java.time.LocalDateTime;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class LabSplit {
    private Long idSplit;
    private int oilSplit;
    private int sludgeSplit;
    private int glycerinSplit;
    private int trashSplit;
    private LocalDateTime dtSplit;

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

    public LocalDateTime getDtSplit() {
        return dtSplit;
    }

    public void setDtSplit(LocalDateTime dtSplit) {
        this.dtSplit = dtSplit;
    }
}
