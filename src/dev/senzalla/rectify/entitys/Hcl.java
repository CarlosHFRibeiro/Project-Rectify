package dev.senzalla.rectify.entitys;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class Hcl {
    private Long idHcl;
    private double concentrationHcl;

    public Long getIdHcl() {
        return idHcl;
    }

    public void setIdHcl(Long idHcl) {
        this.idHcl = idHcl;
    }

    public double getConcentrationHcl() {
        return concentrationHcl;
    }

    public void setConcentrationHcl(double concentrationHcl) {
        this.concentrationHcl = concentrationHcl;
    }

    @Override
    public String toString() {
        return String.valueOf(getConcentrationHcl());
    }
    
}
