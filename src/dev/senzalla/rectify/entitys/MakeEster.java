package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.treatments.TreatmentDate;

import java.sql.Date;
import java.util.Set;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MakeEster extends TreatmentDate {
    private Long idEster;
    private int amountEster;
    private int foreseenEster;
    private int trashEster;
    private int producedEster;
    private Date dtEster;
    private Tank tank;
    private Set<MatterEster> matterEster;
    private Set<ReactEster> reactEsters;

    public Long getIdEster() {
        return idEster;
    }

    public void setIdEster(Long idEster) {
        this.idEster = idEster;
    }


    public int getAmountEster() {
        return amountEster;
    }

    public void setAmountEster(int amountEster) {
        this.amountEster = amountEster;
    }

    public int getForeseenEster() {
        return foreseenEster;
    }

    public void setForeseenEster(int foreseenEster) {
        this.foreseenEster = foreseenEster;
    }

    public int getTrashEster() {
        return trashEster;
    }

    public void setTrashEster(int trashEster) {
        this.trashEster = trashEster;
    }

    public int getProducedEster() {
        return producedEster;
    }

    public void setProducedEster(int producedEster) {
        this.producedEster = producedEster;
    }

    public Date getDtEster() {
        return dtEster;
    }

    public void setDtEster(java.util.Date dtEster) {
        this.dtEster = convertDateSql(dtEster);
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public Set<MatterEster> getMatterEster() {
        return matterEster;
    }

    public void setMatterEster(Set<MatterEster> matterEster) {
        this.matterEster = matterEster;
    }

    public Set<ReactEster> getReactEsters() {
        return reactEsters;
    }

    public void setReactEsters(Set<ReactEster> reactEsters) {
        this.reactEsters = reactEsters;
    }
}
