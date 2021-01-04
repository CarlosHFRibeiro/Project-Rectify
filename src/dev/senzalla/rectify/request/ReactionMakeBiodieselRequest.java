package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.AnalyzeTank;
import dev.senzalla.rectify.entitys.MakeBiodiesel;
import dev.senzalla.rectify.entitys.ReactionMakeBiodiesel;
import dev.senzalla.rectify.exception.DataBaseException;
import dev.senzalla.rectify.setting.ConectionMySql;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ReactionMakeBiodieselRequest extends ConectionMySql {

    public void insert(ReactionMakeBiodiesel reactionMakeBiodiesel) {
        try {
        super.connection();
            final String sql = "INSERT INTO `tbl_reaction_biodiesel` (`fkAnalyzeTank`, `methanolMakeBiodiesel`, `methylateMakeBiodiesel, `dateReactionMakeBiodiesel`, `timeStart`, `timeFinal`) VALUES (?, ?, ?, ?, ?, ?);";
            super.prepareStatement(sql);
            stmt.setLong(1, reactionMakeBiodiesel.getAnalyzeTank().getIdAnalyzeTank());
            stmt.setInt(2, reactionMakeBiodiesel.getMethanolMakeBiodiesel());
            stmt.setInt(3, reactionMakeBiodiesel.getMethylateMakeBiodiesel());
            stmt.setDate(4, reactionMakeBiodiesel.getDateReactionMakeBiodiesel());
            stmt.setTime(5, reactionMakeBiodiesel.getTimeInitialReactionMakeBiodiesel());
            stmt.setTime(6, reactionMakeBiodiesel.getTimeFinalReactionMakeBiodiesel());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Reaction Make Biodiesel: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }

    public MakeBiodiesel select(MakeBiodiesel makeBiodiesel) {
        try {
            super.connection();
            Set<ReactionMakeBiodiesel> reactionMakeBiodiesels = new HashSet<>();
            final String SELECT_QUERY = "SELECT * FROM view_reaction_biodiesel WHERE fkMakeBiodiesel = ?";
            super.prepareStatement(SELECT_QUERY);
            stmt.setLong(1, makeBiodiesel.getIdMakeBiodiesel());
            super.resultSet();
            while (rs.next()) {
                ReactionMakeBiodiesel reactionMakeBiodiesel = new ReactionMakeBiodiesel();
                reactionMakeBiodiesel.setDateReactionMakeBiodiesel(rs.getDate("dateReactionMakeBiodiesel"));
                reactionMakeBiodiesel.setMethylateMakeBiodiesel(rs.getInt("methylateMakeBiodiesel"));
                reactionMakeBiodiesel.setMethanolMakeBiodiesel(rs.getInt("methanolMakeBiodiesel"));
                reactionMakeBiodiesel.setTimeFinalReactionMakeBiodiesel(rs.getTime("timeFinal"));
                reactionMakeBiodiesel.setTimeInitialReactionMakeBiodiesel(rs.getTime("timeStart"));

                AnalyzeTank analyzeTank = new AnalyzeTank();
                analyzeTank.setAcidityAnalyzeTank(rs.getDouble("acidityTank"));
                analyzeTank.setSaponityTank(rs.getDouble("saponityTank"));
                analyzeTank.setTrashTank(rs.getInt("trashTank"));
                reactionMakeBiodiesel.setAnalyzeTank(analyzeTank);

                reactionMakeBiodiesels.add(reactionMakeBiodiesel);
            }
            makeBiodiesel.setReactTrans(reactionMakeBiodiesels);
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Reaction Make Biodiesel: " + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return makeBiodiesel;
    }

}
