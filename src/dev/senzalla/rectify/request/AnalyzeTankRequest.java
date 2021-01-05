package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.AnalyzeTank;
import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.exception.DataBaseException;
import dev.senzalla.rectify.setting.ConectionMySql;
import dev.senzalla.rectify.treatments.QueryTreatment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class AnalyzeTankRequest extends ConectionMySql {


    public void insert(AnalyzeTank analyzeTank) {
        try {
            super.connection();
            final String sql = "INSERT INTO `tbl_analyze_tank` (`trashTank`, `fkTank`, `acidityTank`, `saponityTank`) VALUES (?, ?, ?, ?);";
            super.prepareStatement(sql);
            stmt.setInt(1, analyzeTank.getTrashTank());
            stmt.setLong(2, analyzeTank.getTank().getIdTank());
            stmt.setDouble(3, analyzeTank.getAcidityAnalyzeTank());
            stmt.setDouble(4, analyzeTank.getSaponityTank());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Analyze Tank: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }

    public List<AnalyzeTank> select(List<String> query, AnalyzeTank analyzeTank) {
        String SELECT_QUERY = "view_analyze_tank";
        if (query != null) {
            SELECT_QUERY = QueryTreatment.createQuery(SELECT_QUERY, query);
        } else if (analyzeTank != null) {
            SELECT_QUERY = "SELECT * FROM view_analyze_tank WHERE nameTank = ?";
        }
        return selectAll(SELECT_QUERY, analyzeTank);
    }

    private List<AnalyzeTank> selectAll(String query, AnalyzeTank parameter) {
        super.connection();
        List<AnalyzeTank> labtanks = new ArrayList<>();
        try {
            super.prepareStatement(query);
            this.prepareStatement(parameter);
            super.resultSet();
            while (rs.next()) {
                AnalyzeTank labtank = new AnalyzeTank();
                labtank.setIdAnalyzeTank(rs.getLong("idAnalyzeTank"));
                labtank.setTrashTank(rs.getInt("trashTank"));
                labtank.setAcidityAnalyzeTank(rs.getDouble("acidityTank"));
                labtank.setSaponityTank(rs.getDouble("saponityTank"));
                labtank.setDateAnalyzeTank(rs.getDate("dateAnalyzeTank"));
                labtank.setTimeAnalyzeTank(rs.getTime("timeAnalyzeTank"));
                labtank.setTank(new Tank(rs.getString("nameTank")));

                labtanks.add(labtank);
            }
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Analyze Tank: " + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return labtanks;
    }

    private void prepareStatement(AnalyzeTank parameter) throws SQLException {
        if (parameter != null) {
            int i = 1;
            if (parameter.getIdAnalyzeTank() != null) {
                stmt.setLong(i++, parameter.getIdAnalyzeTank());
            }
            if (parameter.getDateAnalyzeTank() != null) {
                stmt.setDate(i++, parameter.getDateAnalyzeTank());
            }
            if (parameter.getDateBetween() != null) {
                stmt.setDate(i++, parameter.getDateBetween());
            }
            if (parameter.getTank() != null) {
                stmt.setString(i, parameter.getTank().getNameTank());
            }
        }
    }


}
