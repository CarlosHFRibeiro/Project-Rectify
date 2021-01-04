package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.treatments.DateTreatment;

import java.sql.Date;
import java.sql.Time;


/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ReactionMakeEster extends DateTreatment {
    private Long idReactionMakeEster;
    private int methanolPureMakeEster;
    private int methanolRecoverMakeEster;
    private int sulfuricAcidMakeEster;
    private Date dateReactionMakeEster;
    private Time timeStartReactionMakeEster;
    private Time timeFinalReactionMakeEster;
    private AnalyzeTank initialAnalysysReactionMakeEster;
    private AnalyzeTank finalAnalysisReactionMakeEster;
    private MakeEster makeEster;

    public Long getIdReactionMakeEster() {
        return idReactionMakeEster;
    }

    public void setIdReactionMakeEster(Long idReactionMakeEster) {
        this.idReactionMakeEster = idReactionMakeEster;
    }

    public int getMethanolPureMakeEster() {
        return methanolPureMakeEster;
    }

    public void setMethanolPureMakeEster(int methanolPureMakeEster) {
        this.methanolPureMakeEster = methanolPureMakeEster;
    }

    public int getMethanolRecoverMakeEster() {
        return methanolRecoverMakeEster;
    }

    public void setMethanolRecoverMakeEster(int methanolRecoverMakeEster) {
        this.methanolRecoverMakeEster = methanolRecoverMakeEster;
    }

    public int getSulfuricAcidMakeEster() {
        return sulfuricAcidMakeEster;
    }

    public void setSulfuricAcidMakeEster(int sulfuricAcidMakeEster) {
        this.sulfuricAcidMakeEster = sulfuricAcidMakeEster;
    }

    public Date getDateReactionMakeEster() {
        return dateReactionMakeEster;
    }

    public void setDateReactionMakeEster(java.util.Date dateReactionMakeEster) {
        this.dateReactionMakeEster = convertDateSql(dateReactionMakeEster);
    }

    public Time getTimeStartReactionMakeEster() {
        return timeStartReactionMakeEster;
    }

    public void setTimeStartReactionMakeEster(Time timeStartReactionMakeEster) {
        this.timeStartReactionMakeEster = timeStartReactionMakeEster;
    }

    public Time getTimeFinalReactionMakeEster() {
        return timeFinalReactionMakeEster;
    }

    public void setTimeFinalReactionMakeEster(Time timeFinalReactionMakeEster) {
        this.timeFinalReactionMakeEster = timeFinalReactionMakeEster;
    }

    public AnalyzeTank getInitialAnalysysReactionMakeEster() {
        return initialAnalysysReactionMakeEster;
    }

    public void setInitialAnalysysReactionMakeEster(AnalyzeTank initialAnalysysReactionMakeEster) {
        this.initialAnalysysReactionMakeEster = initialAnalysysReactionMakeEster;
    }

    public AnalyzeTank getFinalAnalysisReactionMakeEster() {
        return finalAnalysisReactionMakeEster;
    }

    public void setFinalAnalysisReactionMakeEster(AnalyzeTank finalAnalysisReactionMakeEster) {
        this.finalAnalysisReactionMakeEster = finalAnalysisReactionMakeEster;
    }

    public MakeEster getMakeEster() {
        return makeEster;
    }

    public void setMakeEster(MakeEster makeEster) {
        this.makeEster = makeEster;
    }
}
