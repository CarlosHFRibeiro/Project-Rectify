package dev.senzalla.rectify.entitys;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class AnalyzeTruckSplit {
    private Long idAnalyzeTruckSplit;
    private AnalyzeSplit analyzeSplit;
    private AnalyzeTruck analyzeTruck;

    public Long getIdAnalyzeTruckSplit() {
        return idAnalyzeTruckSplit;
    }

    public void setIdAnalyzeTruckSplit(Long idAnalyzeTruckSplit) {
        this.idAnalyzeTruckSplit = idAnalyzeTruckSplit;
    }

    public AnalyzeSplit getAnalyzeSplit() {
        return analyzeSplit;
    }

    public void setAnalyzeSplit(AnalyzeSplit analyzeSplit) {
        this.analyzeSplit = analyzeSplit;
    }

    public AnalyzeTruck getAnalyzeTruck() {
        return analyzeTruck;
    }

    public void setAnalyzeTruck(AnalyzeTruck analyzeTruck) {
        this.analyzeTruck = analyzeTruck;
    }
}
