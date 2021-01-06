package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.AnalyzeBiodiesel;
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
public class AnalyzeBiodieselRequest extends ConectionMySql {

    public void insert(AnalyzeBiodiesel analyzeBiodiesel) {
        super.connection();
        try {
            final String sql = "INSERT INTO `tbl_analyze_biodiesel` (`acidityBiodiesel`, `densityBiodiesel`, `densityBiodiesel20Degress`, `temperatureBiodiesel`, `correctionFactorBiodiesel`) VALUES (?, ?, ?, ?, ?);";
            super.prepareStatement(sql);
            stmt.setDouble(1, analyzeBiodiesel.getAcidityBiodiesel());
            stmt.setDouble(2, analyzeBiodiesel.getDensityBiodiesel());
            stmt.setDouble(3, analyzeBiodiesel.getDensityBiodiesel20Degress());
            stmt.setDouble(4, analyzeBiodiesel.getTemperatureBiodiesel());
            stmt.setDouble(5, analyzeBiodiesel.getCorrectionFactorBiodiesel());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase(ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }

    public List<AnalyzeBiodiesel> select(List<String> query, AnalyzeBiodiesel parameter) {
        List<AnalyzeBiodiesel> analyzeBiodiesels = new ArrayList<>();
        try {
            String SELECT_QUERY = QueryTreatment.createQuery("tbl_analyze_biodiesel", query);
            super.connection();
            super.prepareStatement(SELECT_QUERY);
            this.prepareStatement(parameter);
            super.resultSet();
            System.out.println(stmt);
            while (rs.next()) {
                AnalyzeBiodiesel analyzeBiodiesel = new AnalyzeBiodiesel();
                analyzeBiodiesel.setIdAnalyzeBiodiesel(rs.getLong("idAnalyzeBiodiesel"));
                analyzeBiodiesel.setAcidityBiodiesel(rs.getDouble("acidityBiodiesel"));
                analyzeBiodiesel.setDensityBiodiesel(rs.getDouble("densityBiodiesel"));
                analyzeBiodiesel.setDensityBiodiesel20Degress(rs.getDouble("densityBiodiesel20Degress"));
                analyzeBiodiesel.setTemperatureBiodiesel(rs.getDouble("temperatureBiodiesel"));
                analyzeBiodiesel.setCorrectionFactorBiodiesel(rs.getDouble("correctionFactorBiodiesel"));
                analyzeBiodiesel.setDateAnalyzeBiodiesel(rs.getDate("dateAnalyzeBiodiesel"));
                analyzeBiodiesel.setTimeAnalyzeBiodiesel(rs.getTime("timeAnalyzeBiodiesel"));

                analyzeBiodiesels.add(analyzeBiodiesel);
            }
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase(ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return analyzeBiodiesels;
    }

    private void prepareStatement(AnalyzeBiodiesel parameter) throws SQLException {
        if (parameter != null) {
            int i = 1;
            if (parameter.getIdAnalyzeBiodiesel() != null) {
                stmt.setLong(i++, parameter.getIdAnalyzeBiodiesel());
            }
            if (parameter.getDateAnalyzeBiodiesel() != null) {
                stmt.setDate(i++, parameter.getDateAnalyzeBiodiesel());
            }
            if (parameter.getDateBetween() != null) {
                stmt.setDate(i, parameter.getDateBetween());
            }
        }
    }
}
