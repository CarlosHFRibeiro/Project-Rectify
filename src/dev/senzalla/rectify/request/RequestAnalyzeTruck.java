package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.AnalyzeTruck;
import dev.senzalla.rectify.exception.DataBaseException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class RequestAnalyzeTruck extends Request<AnalyzeTruck> {

    private List<AnalyzeTruck> analyzeTrucks;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.tbl_analyzeTruck";
    private String where = "";

    @Override
    public void insert(AnalyzeTruck analyzeTruck) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_analyzeTruck` (`trashCar`, `collectCar`, `acidCar`, `soapCar`, `densityCar`) VALUES (?, ?, ?, ?, ?);";
            prepareStatement(sql);
            stmt.setInt(1, analyzeTruck.getTrashCar());
            stmt.setInt(2, analyzeTruck.getCollect().getValor());
            stmt.setDouble(3, analyzeTruck.getAcidCar());
            stmt.setDouble(4, analyzeTruck.getSoapCar());
            stmt.setDouble(5, analyzeTruck.getDensityCar());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<AnalyzeTruck> select() {
        String ORDER = " ORDER BY idCar DESC";
        selectAll(SELECT_QUERY + ORDER, null);
        return analyzeTrucks;
    }

    public AnalyzeTruck select(AnalyzeTruck analyzeTruck) {
        SELECT_QUERY += "WHERE idCar = ?";
        selectAll(SELECT_QUERY, analyzeTruck);
        return analyzeTrucks.get(0);
    }


    @Override
    public List<AnalyzeTruck> select(List<String> query, AnalyzeTruck analyzeTruck) {
        query.forEach(s -> where += String.format(" %s ? AND", s));
        SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 3);
        selectAll(SELECT_QUERY, analyzeTruck);
        return analyzeTrucks;
    }

    private void selectAll(String query, AnalyzeTruck parameter) {
        connection();
        analyzeTrucks = new ArrayList<>();
        try {
            prepareStatement(query);
            if (parameter != null) {
                prepareStatement(parameter);
            }
            resultSet();
            while (rs.next()) {
                AnalyzeTruck analyzeTruck = new AnalyzeTruck();
                analyzeTruck.setIdCar(rs.getLong("idCar"));
                analyzeTruck.setTrashCar(rs.getInt("trashCar"));
                analyzeTruck.setCollect(rs.getInt("collectCar"));
                analyzeTruck.setAcidCar(rs.getDouble("acidCar"));
                analyzeTruck.setSoapCar(rs.getDouble("soapCar"));
                analyzeTruck.setDensityCar(rs.getDouble("densityCar"));
                analyzeTruck.setDtCar(rs.getDate("dtCar"));
                analyzeTruck.setHrCar(rs.getTime("hrCar"));

                analyzeTrucks.add(analyzeTruck);
            }
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnectionRs();
        }
    }

    private void prepareStatement(AnalyzeTruck parameter) {
        try {
            int i = 1;
            if (parameter.getIdCar() != null) {
                stmt.setLong(i++, parameter.getIdCar());
            }
            if (parameter.getDtCar() != null) {
                stmt.setDate(i++, parameter.getDtCar());
            }
            if (parameter.getDateBetween() != null) {
                stmt.setDate(i, parameter.getDateBetween());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
