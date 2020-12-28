package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.treatments.TreatmentDate;

import java.sql.Date;
import java.util.Set;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MakeTrans extends TreatmentDate {
    private Long idTrans;
    private int amountTrans;
    private int foreseenTrans;
    private int trashTrans;
    private int producedTrans;
    private Date makeDateTrans;
    private Tank tank;
    private Set<MatterTrans> matterTrans;
    private Set<ReactTrans> reactTrans;

    public Long getIdTrans() {
        return idTrans;
    }

    public void setIdTrans(Long idTrans) {
        this.idTrans = idTrans;
    }

    public int getAmountTrans() {
        return amountTrans;
    }

    public void setAmountTrans(int amountTrans) {
        this.amountTrans = amountTrans;
    }

    public int getForeseenTrans() {
        return foreseenTrans;
    }

    public void setForeseenTrans(int foreseenTrans) {
        this.foreseenTrans = foreseenTrans;
    }

    public int getTrashTrans() {
        return trashTrans;
    }

    public void setTrashTrans(int trashTrans) {
        this.trashTrans = trashTrans;
    }

    public int getProducedTrans() {
        return producedTrans;
    }

    public void setProducedTrans(int producedTrans) {
        this.producedTrans = producedTrans;
    }

    public Date getMakeDateTrans() {
        return makeDateTrans;
    }

    public void setMakeDateTrans(java.util.Date makeDateTrans) {
        this.makeDateTrans = convertDateSql(makeDateTrans);
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public Set<MatterTrans> getMatterTrans() {
        return matterTrans;
    }

    public void setMatterTrans(Set<MatterTrans> matterTrans) {
        this.matterTrans = matterTrans;
    }

    public Set<ReactTrans> getReactTrans() {
        return reactTrans;
    }

    public void setReactTrans(Set<ReactTrans> reactTrans) {
        this.reactTrans = reactTrans;
    }
}
