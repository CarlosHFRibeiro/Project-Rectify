package dev.senzalla.rectify.entitys;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class Naoh {

    private Long idNaoh;
    private double valueNaoh;

    public Long getIdNaoh() {
        return idNaoh;
    }

    public void setIdNaoh(Long idNaoh) {
        this.idNaoh = idNaoh;
    }

    public double getValueNaoh() {
        return valueNaoh;
    }

    public void setValueNaoh(double valueNaoh) {
        this.valueNaoh = valueNaoh;
    }

    @Override
    public String toString() {
        return String.valueOf(getValueNaoh());
    }

}
