package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.treatments.DateTreatment;

import java.sql.Date;
import java.util.Set;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MakeEster extends DateTreatment {
    private Long idMakeEster;
    private int amountMatterMakeEster;
    private int producedMakeEster;
    private int trashMakeEster;
    private Date dateMakeEster;
    private Tank tank;
    private Set<MatterMake> matterMake;
    private Set<ReactionMakeEster> reactionMakeEster;

    public Long getIdMakeEster() {
        return idMakeEster;
    }

    public void setIdMakeEster(Long idMakeEster) {
        this.idMakeEster = idMakeEster;
    }

    public int getAmountMatterMakeEster() {
        return amountMatterMakeEster;
    }

    public void setAmountMatterMakeEster(int amountMatterMakeEster) {
        this.amountMatterMakeEster = amountMatterMakeEster;
    }

    public int getProducedMakeEster() {
        return producedMakeEster;
    }

    public void setProducedMakeEster(int producedMakeEster) {
        this.producedMakeEster = producedMakeEster;
    }

    public int getTrashMakeEster() {
        return trashMakeEster;
    }

    public void setTrashMakeEster(int trashMakeEster) {
        this.trashMakeEster = trashMakeEster;
    }

    public Date getDateMakeEster() {
        return dateMakeEster;
    }

    public void setDateMakeEster(java.util.Date dateMakeEster) {
        this.dateMakeEster = convertDateSql(dateMakeEster);
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public Set<MatterMake> getMatterEster() {
        return matterMake;
    }

    public void setMatterEster(Set<MatterMake> matterMake) {
        this.matterMake = matterMake;
    }

    public Set<ReactionMakeEster> getReactEster() {
        return reactionMakeEster;
    }

    public void setReactEster(Set<ReactionMakeEster> reactionMakeEster) {
        this.reactionMakeEster = reactionMakeEster;
    }

    @Override
    public String toString() {
        return String.valueOf(getIdMakeEster());
    }
}
