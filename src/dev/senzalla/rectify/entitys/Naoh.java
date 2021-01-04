package dev.senzalla.rectify.entitys;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class Naoh {

    private Long idNaoh;
    private double concentrationNaoh;

    public Long getIdNaoh() {
        return idNaoh;
    }

    public void setIdNaoh(Long idNaoh) {
        this.idNaoh = idNaoh;
    }

    public double getConcentrationNaoh() {
        return concentrationNaoh;
    }

    public void setConcentrationNaoh(double concentrationNaoh) {
        this.concentrationNaoh = concentrationNaoh;
    }

    @Override
    public String toString() {
        return String.valueOf(getConcentrationNaoh());
    }

}
