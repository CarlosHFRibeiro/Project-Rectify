package dev.senzalla.rectify.entitys;


/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ObservationDischarge {
    private Long idObsDcharge;
    private String obsDcharge;
    private Discharge discharge;

    public Long getIdObsDcharge() {
        return idObsDcharge;
    }

    public void setIdObsDcharge(Long idObsDcharge) {
        this.idObsDcharge = idObsDcharge;
    }

    public String getObsDcharge() {
        return obsDcharge;
    }

    public void setObsDcharge(String obsDcharge) {
        this.obsDcharge = obsDcharge;
    }

    public Discharge getDischarge() {
        return discharge;
    }

    public void setDischarge(Discharge discharge) {
        this.discharge = discharge;
    }
}
