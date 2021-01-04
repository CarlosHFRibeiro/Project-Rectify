/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.AnalyzeTank;
import dev.senzalla.rectify.entitys.ReactionMakeEster;
import dev.senzalla.rectify.frame.panel.ReactionEsterPanel;
import dev.senzalla.rectify.request.ReactionMakeEsterRequest;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * @author Bomsalvez
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ReactionEsterTreatment {

    public static boolean checkReact(List<ReactionEsterPanel> pnlReact) {
        return pnlReact.stream().anyMatch(pnl -> TxtTreatment.isTextFieldEmpty(pnl.getNamePanel()) && ComboBoxTreatment.isCbxEmpty(pnl.getNamePanel()) && DateChooserTreatment.isDateChooserNull(pnl.getNamePanel()));
    }

    public void saveReact(String sulfuric, String methanolRecover, String methanolPure, String timeStart, String timeFinal, AnalyzeTank initialAnalysys, AnalyzeTank finalAnalysis, Date dateReaction) {
        ReactionMakeEster reactionMakeEster = new ReactionMakeEster();
        reactionMakeEster.setSulfuricAcidMakeEster(Integer.parseInt(sulfuric));
        reactionMakeEster.setMethanolRecoverMakeEster(Integer.parseInt(methanolRecover));
        reactionMakeEster.setMethanolPureMakeEster(Integer.parseInt(methanolPure));
        reactionMakeEster.setTimeStartReactionMakeEster(Time.valueOf(timeStart));
        reactionMakeEster.setTimeFinalReactionMakeEster(Time.valueOf(timeFinal));
        reactionMakeEster.setInitialAnalysysReactionMakeEster(initialAnalysys);
        reactionMakeEster.setFinalAnalysisReactionMakeEster(finalAnalysis);
        reactionMakeEster.setDateReactionMakeEster(dateReaction);
        new ReactionMakeEsterRequest().insert(reactionMakeEster);
    }

}
