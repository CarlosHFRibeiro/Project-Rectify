package dev.senzalla.rectify.entitys;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class AnalyzeTruckSplit {
    private Long idCarSplit;
    private LabSplit labSplit;
    private AnalyzeTruck analyzeTruck;

    public Long getIdCarSplit() {
        return idCarSplit;
    }

    public void setIdCarSplit(Long idCarSplit) {
        this.idCarSplit = idCarSplit;
    }

    public LabSplit getLabSplit() {
        return labSplit;
    }

    public void setLabSplit(LabSplit labSplit) {
        this.labSplit = labSplit;
    }

    public AnalyzeTruck getanalyzeTruck() {
        return analyzeTruck;
    }

    public void setanalyzeTruck(AnalyzeTruck analyzeTruck) {
        this.analyzeTruck = analyzeTruck;
    }
}
