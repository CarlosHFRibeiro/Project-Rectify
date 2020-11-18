package dev.senzalla.rectify.entitys;

import java.sql.Time;
import java.util.Date;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class ReactTrans {
    private Long idRctTrans;
    private int methylateRctTrans;
    private int pureRctTrans;
    private Date dtRctTrans;
    private Time hrStartRctTrans;
    private Time hrFinalRctTrans;
    private LabTank labTank;
    private MakeTrans makeTrans;

    public Long getIdRctTrans() {
        return idRctTrans;
    }

    public void setIdRctTrans(Long idRctTrans) {
        this.idRctTrans = idRctTrans;
    }

    public int getMethylateRctTrans() {
        return methylateRctTrans;
    }

    public void setMethylateRctTrans(int methylateRctTrans) {
        this.methylateRctTrans = methylateRctTrans;
    }

    public int getPureRctTrans() {
        return pureRctTrans;
    }

    public void setPureRctTrans(int pureRctTrans) {
        this.pureRctTrans = pureRctTrans;
    }

    public Date getDtRctTrans() {
        return dtRctTrans;
    }

    public void setDtRctTrans(Date dtRctTrans) {
        this.dtRctTrans = dtRctTrans;
    }

    public Time getHrStartRctTrans() {
        return hrStartRctTrans;
    }

    public void setHrStartRctTrans(Time hrStartRctTrans) {
        this.hrStartRctTrans = hrStartRctTrans;
    }

    public Time getHrFinalRctTrans() {
        return hrFinalRctTrans;
    }

    public void setHrFinalRctTrans(Time hrFinalRctTrans) {
        this.hrFinalRctTrans = hrFinalRctTrans;
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
