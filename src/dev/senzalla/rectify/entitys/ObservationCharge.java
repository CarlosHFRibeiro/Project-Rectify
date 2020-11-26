package dev.senzalla.rectify.entitys;



/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ObservationCharge {
    private Long idObsCharge;
    private String obsCharge;
    private Charge charge;

    public Long getIdObsCharge() {
        return idObsCharge;
    }

    public void setIdObsCharge(Long idObsCharge) {
        this.idObsCharge = idObsCharge;
    }

    public String getObsCharge() {
        return obsCharge;
    }

    public void setObsCharge(String obsCharge) {
        this.obsCharge = obsCharge;
    }

    public Charge getCharge() {
        return charge;
    }

    public void setCharge(Charge charge) {
        this.charge = charge;
    }
}
