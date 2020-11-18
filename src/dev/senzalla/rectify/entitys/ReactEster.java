package dev.senzalla.rectify.entitys;

import java.sql.Time;
import java.util.Date;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class ReactEster {
    private Long idRctEster;
    private int sulfuricRctEster;
    private int pureRctEster;
    private int recoverRctEster;
    private Date dtRctEster;
    private Time hrStartRctEster;
    private Time hrFinalRctEster;
    private LabTank fkLabStartRctEster;
    private LabTank fkLabFinalRctEster;
    private MakeEster makeEster;

    public Long getIdRctEster() {
        return idRctEster;
    }

    public void setIdRctEster(Long idRctEster) {
        this.idRctEster = idRctEster;
    }

    public int getSulfuricRctEster() {
        return sulfuricRctEster;
    }

    public void setSulfuricRctEster(int sulfuricRctEster) {
        this.sulfuricRctEster = sulfuricRctEster;
    }

    public int getPureRctEster() {
        return pureRctEster;
    }

    public void setPureRctEster(int pureRctEster) {
        this.pureRctEster = pureRctEster;
    }

    public int getRecoverRctEster() {
        return recoverRctEster;
    }

    public void setRecoverRctEster(int recoverRctEster) {
        this.recoverRctEster = recoverRctEster;
    }

    public Date getDtRctEster() {
        return dtRctEster;
    }

    public void setDtRctEster(Date dtRctEster) {
        this.dtRctEster = dtRctEster;
    }

    public Time getHrStartRctEster() {
        return hrStartRctEster;
    }

    public void setHrStartRctEster(Time hrStartRctEster) {
        this.hrStartRctEster = hrStartRctEster;
    }

    public Time getHrFinalRctEster() {
        return hrFinalRctEster;
    }

    public void setHrFinalRctEster(Time hrFinalRctEster) {
        this.hrFinalRctEster = hrFinalRctEster;
    }

    public LabTank getFkLabStartRctEster() {
        return fkLabStartRctEster;
    }

    public void setFkLabStartRctEster(LabTank fkLabStartRctEster) {
        this.fkLabStartRctEster = fkLabStartRctEster;
    }

    public LabTank getFkLabFinalRctEster() {
        return fkLabFinalRctEster;
    }

    public void setFkLabFinalRctEster(LabTank fkLabFinalRctEster) {
        this.fkLabFinalRctEster = fkLabFinalRctEster;
    }

    public MakeEster getMakeEster() {
        return makeEster;
    }

    public void setMakeEster(MakeEster makeEster) {
        this.makeEster = makeEster;
    }
}
