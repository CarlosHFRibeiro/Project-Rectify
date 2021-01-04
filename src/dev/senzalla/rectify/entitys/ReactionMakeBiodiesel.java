package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.treatments.DateTreatment;

import java.sql.Date;
import java.sql.Time;


/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ReactionMakeBiodiesel extends DateTreatment {
    private Long idReactionMakeBiodiesel;
    private int methanolMakeBiodiesel;
    private int methylateMakeBiodiesel;
    private Date dateReactionMakeBiodiesel;
    private Time timeInitialReactionMakeBiodiesel;
    private Time timeFinalReactionMakeBiodiesel;
    private AnalyzeTank analyzeTank;
    private MakeBiodiesel makeBiodiesel;

    public Long getIdReactionMakeBiodiesel() {
        return idReactionMakeBiodiesel;
    }

    public void setIdReactionMakeBiodiesel(Long idReactionMakeBiodiesel) {
        this.idReactionMakeBiodiesel = idReactionMakeBiodiesel;
    }

    public int getMethanolMakeBiodiesel() {
        return methanolMakeBiodiesel;
    }

    public void setMethanolMakeBiodiesel(int methanolMakeBiodiesel) {
        this.methanolMakeBiodiesel = methanolMakeBiodiesel;
    }

    public int getMethylateMakeBiodiesel() {
        return methylateMakeBiodiesel;
    }

    public void setMethylateMakeBiodiesel(int methylateMakeBiodiesel) {
        this.methylateMakeBiodiesel = methylateMakeBiodiesel;
    }

    public Date getDateReactionMakeBiodiesel() {
        return dateReactionMakeBiodiesel;
    }

    public void setDateReactionMakeBiodiesel(java.util.Date dateReactionMakeBiodiesel) {
        this.dateReactionMakeBiodiesel = convertDateSql(dateReactionMakeBiodiesel);
    }

    public Time getTimeInitialReactionMakeBiodiesel() {
        return timeInitialReactionMakeBiodiesel;
    }

    public void setTimeInitialReactionMakeBiodiesel(Time timeInitialReactionMakeBiodiesel) {
        this.timeInitialReactionMakeBiodiesel = timeInitialReactionMakeBiodiesel;
    }

    public Time getTimeFinalReactionMakeBiodiesel() {
        return timeFinalReactionMakeBiodiesel;
    }

    public void setTimeFinalReactionMakeBiodiesel(Time timeFinalReactionMakeBiodiesel) {
        this.timeFinalReactionMakeBiodiesel = timeFinalReactionMakeBiodiesel;
    }

    public AnalyzeTank getAnalyzeTank() {
        return analyzeTank;
    }

    public void setAnalyzeTank(AnalyzeTank analyzeTank) {
        this.analyzeTank = analyzeTank;
    }

    public MakeBiodiesel getMakeBiodiesel() {
        return makeBiodiesel;
    }

    public void setMakeBiodiesel(MakeBiodiesel makeBiodiesel) {
        this.makeBiodiesel = makeBiodiesel;
    }
}
