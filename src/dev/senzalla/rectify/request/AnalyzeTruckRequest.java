package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.AnalyzeTruck;
import dev.senzalla.rectify.entitys.Product;
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
public class AnalyzeTruckRequest extends ConectionMySql {

    public void insert(AnalyzeTruck analyzeTruck) {
        try {
            super.connection();
            final String sql = "INSERT INTO `tbl_analyze_truck` (`trashTruck`, `collect`, `acidityTruck`, `saponityTruck`, `densityTruck`, `fkProduct`) VALUES (?, ?, ?, ?, ?, ?);";
            super.prepareStatement(sql);
            stmt.setInt(1, analyzeTruck.getTrashTruck());
            stmt.setInt(2, analyzeTruck.getCollect().getValor());
            stmt.setDouble(3, analyzeTruck.getAcidityTruck());
            stmt.setDouble(4, analyzeTruck.getSaponityTruck());
            stmt.setDouble(5, analyzeTruck.getDensityTruck());
            stmt.setLong(6, analyzeTruck.getProduct().getIdProduct());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase(ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }


    public List<AnalyzeTruck> select() {
        String ORDER = "SELECT * FROM tbl_analyze_truck ORDER BY idCar DESC";
        return selectAll(ORDER, null);
    }

//    public AnalyzeTruck select(AnalyzeTruck analyzeTruck) {
//
//        SELECT_QUERY += "WHERE idCar = ?";
//        selectAll(SELECT_QUERY, analyzeTruck);
//        return analyzeTrucks.get(0);
//    }


    public List<AnalyzeTruck> select(List<String> query, AnalyzeTruck analyzeTruck) {
        String SELECT_QUERY = QueryTreatment.createQuery("view_analyze_truck", query);
        return selectAll(SELECT_QUERY, analyzeTruck);
    }

    private List<AnalyzeTruck> selectAll(String query, AnalyzeTruck parameter) {
        List<AnalyzeTruck> analyzeTrucks = new ArrayList<>();
        try {
            super.connection();
            super.prepareStatement(query);
            this.prepareStatement(parameter);
            super.resultSet();
            System.out.println(stmt);
            while (rs.next()) {
                AnalyzeTruck analyzeTruck = new AnalyzeTruck();
                analyzeTruck.setIdAnalyzeTruck(rs.getLong("idAnalyzeTruck"));
                analyzeTruck.setTrashTruck(rs.getInt("trashTruck"));
                analyzeTruck.setCollect(rs.getInt("collect"));
                analyzeTruck.setAcidityTruck(rs.getDouble("acidityTruck"));
                analyzeTruck.setSaponityTruck(rs.getDouble("saponityTruck"));
                analyzeTruck.setDensityTruck(rs.getDouble("densityTruck"));
                analyzeTruck.setDateAnalyzeTruck(rs.getDate("dateAnalyzeTruck"));
                analyzeTruck.setTimeAnalyzeTruck(rs.getTime("timeAnalyzeTruck"));
                analyzeTruck.setProduct(new Product(rs.getString("nameProduct")));
                analyzeTrucks.add(analyzeTruck);
            }
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase(ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return analyzeTrucks;
    }

    private void prepareStatement(AnalyzeTruck parameter) throws SQLException {
        if (parameter != null) {
            int i = 1;
            if (parameter.getIdAnalyzeTruck() != null) {
                stmt.setLong(i++, parameter.getIdAnalyzeTruck());
            }
            if (parameter.getDateAnalyzeTruck() != null) {
                stmt.setDate(i++, parameter.getDateAnalyzeTruck());
            }
            if (parameter.getDateBetween() != null) {
                stmt.setDate(i++, parameter.getDateBetween());
            }
            if (parameter.getProduct() != null) {
                stmt.setLong(i, parameter.getProduct().getIdProduct());
            }
        }
    }
}
