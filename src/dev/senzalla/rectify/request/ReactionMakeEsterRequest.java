package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.AnalyzeTank;
import dev.senzalla.rectify.entitys.MakeEster;
import dev.senzalla.rectify.entitys.ReactionMakeEster;
import dev.senzalla.rectify.exception.DataBaseException;
import dev.senzalla.rectify.setting.ConectionMySql;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ReactionMakeEsterRequest extends ConectionMySql {

    public void insert(ReactionMakeEster reactionMakeEster) {
        try {
        super.connection();
            final String sql = "INSERT INTO `tbl_reaction_make_ester` (`fkInitialAnalysys`, `fkMakeEster`, `sulfuricAcid`, `methanolPure`, `methanolRecover`, `fkFinalAnalysis`, `dateReaction`, `timeStart`, `timeFinal`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            super.prepareStatement(sql);
            stmt.setLong(1, reactionMakeEster.getInitialAnalysysReactionMakeEster().getIdAnalyzeTank());
            stmt.setInt(2, reactionMakeEster.getSulfuricAcidMakeEster());
            stmt.setInt(3, reactionMakeEster.getMethanolPureMakeEster());
            stmt.setInt(4, reactionMakeEster.getMethanolRecoverMakeEster());
            stmt.setLong(5, reactionMakeEster.getFinalAnalysisReactionMakeEster().getIdAnalyzeTank());
            stmt.setDate(6, reactionMakeEster.getDateReactionMakeEster());
            stmt.setTime(7, reactionMakeEster.getTimeStartReactionMakeEster());
            stmt.setTime(8, reactionMakeEster.getTimeFinalReactionMakeEster());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Rection Make Ester: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }

    public MakeEster select(MakeEster makeester) {
        try {
            super.connection();
            Set<ReactionMakeEster> reactionMakeEsters = new HashSet<>();
            final String SELECT_QUERY = "SELECT * FROM view_reaction_ester WHERE fkMakeEster = ?";
            prepareStatement(SELECT_QUERY);
            stmt.setLong(1, makeester.getIdMakeEster());
            super.resultSet();
            while (rs.next()) {
                ReactionMakeEster reactionMakeEster = new ReactionMakeEster();
                reactionMakeEster.setDateReactionMakeEster(rs.getDate("dateReaction"));
                reactionMakeEster.setSulfuricAcidMakeEster(rs.getInt("sulfuricAcid"));
                reactionMakeEster.setMethanolRecoverMakeEster(rs.getInt("methanolRecover"));
                reactionMakeEster.setMethanolPureMakeEster(rs.getInt("methanolPure"));
                reactionMakeEster.setTimeFinalReactionMakeEster(rs.getTime("timeFinal"));
                reactionMakeEster.setTimeStartReactionMakeEster(rs.getTime("timeStart"));

                AnalyzeTank analyzeTank = new AnalyzeTank();
                analyzeTank.setAcidityAnalyzeTank(rs.getDouble("acidInitial"));
                analyzeTank.setSaponityTank(rs.getDouble("soapInitial"));
                analyzeTank.setTrashTank(rs.getInt("trashInitial"));
                reactionMakeEster.setInitialAnalysysReactionMakeEster(analyzeTank);

                analyzeTank = new AnalyzeTank();
                analyzeTank.setAcidityAnalyzeTank(rs.getDouble("acidFinal"));
                analyzeTank.setSaponityTank(rs.getDouble("soapFinal"));
                analyzeTank.setTrashTank(rs.getInt("trashFinal"));
                reactionMakeEster.setFinalAnalysisReactionMakeEster(analyzeTank);

                reactionMakeEsters.add(reactionMakeEster);
            }
            makeester.setReactEster(reactionMakeEsters);
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Rection Make Ester: " + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return makeester;
    }
}
