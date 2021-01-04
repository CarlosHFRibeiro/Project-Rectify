package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.AnalyzeTank;
import dev.senzalla.rectify.entitys.ReactionMakeBiodiesel;
import dev.senzalla.rectify.request.ReactionMakeBiodieselRequest;

import java.sql.Time;
import java.util.Date;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class ReactionBiodieselTreatment {


    public void saveReact(String methylate, String methanolPure, Date dateMake, String timeInitial, String timeFinal, AnalyzeTank analyzeTank) {
        ReactionMakeBiodiesel reactionMakeBiodiesel = new ReactionMakeBiodiesel();
        reactionMakeBiodiesel.setMethylateMakeBiodiesel(Integer.parseInt(methylate));
        reactionMakeBiodiesel.setMethanolMakeBiodiesel(Integer.parseInt(methanolPure));
        reactionMakeBiodiesel.setDateReactionMakeBiodiesel(dateMake);
        reactionMakeBiodiesel.setTimeInitialReactionMakeBiodiesel(Time.valueOf(timeInitial));
        reactionMakeBiodiesel.setTimeFinalReactionMakeBiodiesel(Time.valueOf(timeFinal));
        reactionMakeBiodiesel.setAnalyzeTank(analyzeTank);
        new ReactionMakeBiodieselRequest().insert(reactionMakeBiodiesel);
    }
}
