package dev.senzalla.rectify.entitys;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class LabCarSplit {
    private Long idCarSplit;
    private LabSplit labSplit;
    private LabCar labCar;

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

    public LabCar getLabCar() {
        return labCar;
    }

    public void setLabCar(LabCar labCar) {
        this.labCar = labCar;
    }
}
