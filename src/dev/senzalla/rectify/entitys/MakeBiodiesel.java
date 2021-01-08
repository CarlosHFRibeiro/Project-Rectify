package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.treatments.DateTreatment;

import java.sql.Date;
import java.util.Set;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MakeBiodiesel extends DateTreatment {

    private Long idMakeBiodiesel;
    private int amountMatterMakeBiodiesel;
    private int trashMakeBiodiesel;
    private int producedMakeBiodiesel;
    private Date dateMakeBiodiesel;
    private Tank tank;
    private Set<MatterMake> matterMakes;
    private Set<ReactionMakeBiodiesel> reactTrans;

    public MakeBiodiesel() {
    }

    public MakeBiodiesel(Long idMakeBiodiesel) {
        this.idMakeBiodiesel = idMakeBiodiesel;
    }

    public Long getIdMakeBiodiesel() {
        return idMakeBiodiesel;
    }

    public void setIdMakeBiodiesel(Long idMakeBiodiesel) {
        this.idMakeBiodiesel = idMakeBiodiesel;
    }

    public int getAmountMatterMakeBiodiesel() {
        return amountMatterMakeBiodiesel;
    }

    public void setAmountMatterMakeBiodiesel(int amountMatterMakeBiodiesel) {
        this.amountMatterMakeBiodiesel = amountMatterMakeBiodiesel;
    }

    public int getTrashMakeBiodiesel() {
        return trashMakeBiodiesel;
    }

    public void setTrashMakeBiodiesel(int trashMakeBiodiesel) {
        this.trashMakeBiodiesel = trashMakeBiodiesel;
    }

    public int getProducedMakeBiodiesel() {
        return producedMakeBiodiesel;
    }

    public void setProducedMakeBiodiesel(int producedMakeBiodiesel) {
        this.producedMakeBiodiesel = producedMakeBiodiesel;
    }

    public Date getDateMakeBiodiesel() {
        return dateMakeBiodiesel;
    }

    public void setDateMakeBiodiesel(java.util.Date dateMakeBiodiesel) {
        this.dateMakeBiodiesel = convertDateSql(dateMakeBiodiesel);
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public Set<MatterMake> getMatterMakes() {
        return matterMakes;
    }

    public void setMatterMakes(Set<MatterMake> matterMakes) {
        this.matterMakes = matterMakes;
    }

    public Set<ReactionMakeBiodiesel> getReactTrans() {
        return reactTrans;
    }

    public void setReactTrans(Set<ReactionMakeBiodiesel> reactTrans) {
        this.reactTrans = reactTrans;
    }

    @Override
    public String toString() {
        return String.valueOf(getIdMakeBiodiesel());
    }
}
