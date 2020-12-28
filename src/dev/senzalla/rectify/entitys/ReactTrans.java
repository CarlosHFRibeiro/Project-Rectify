package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.treatments.TreatmentDate;

import java.sql.Date;
import java.sql.Time;


/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ReactTrans extends TreatmentDate {
    private Long idReactTrans;
    private int methylateReactTrans;
    private int pureReactTrans;
    private Date dateReactTrans;
    private Time hourStartReactTrans;
    private Time hourFinalReactTrans;
    private LabTank labTank;
    private MakeTrans makeTrans;

    public Long getIdReactTrans() {
        return idReactTrans;
    }

    public void setIdReactTrans(Long idReactTrans) {
        this.idReactTrans = idReactTrans;
    }

    public int getMethylateReactTrans() {
        return methylateReactTrans;
    }

    public void setMethylateReactTrans(int methylateReactTrans) {
        this.methylateReactTrans = methylateReactTrans;
    }

    public int getPureReactTrans() {
        return pureReactTrans;
    }

    public void setPureReactTrans(int pureReactTrans) {
        this.pureReactTrans = pureReactTrans;
    }

    public Date getDateReactTrans() {
        return dateReactTrans;
    }

    public void setDateReactTrans(java.util.Date dateReactTrans) {
        this.dateReactTrans = convertDateSql(dateReactTrans);
    }

    public Time getHourStartReactTrans() {
        return hourStartReactTrans;
    }

    public void setHourStartReactTrans(Time hourStartReactTrans) {
        this.hourStartReactTrans = hourStartReactTrans;
    }

    public Time getHourFinalReactTrans() {
        return hourFinalReactTrans;
    }

    public void setHourFinalReactTrans(Time hourFinalReactTrans) {
        this.hourFinalReactTrans = hourFinalReactTrans;
    }

    public LabTank getLabTank() {
        return labTank;
    }

    public void setLabTank(LabTank labTank) {
        this.labTank = labTank;
    }

    public MakeTrans getMakeTrans() {
        return makeTrans;
    }

    public void setMakeTrans(MakeTrans makeTrans) {
        this.makeTrans = makeTrans;
    }
}
