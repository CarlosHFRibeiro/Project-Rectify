package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.LabCar;
import dev.senzalla.rectify.exception.DataBaseException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class RequestLabCar extends Request<LabCar> {

    private List<LabCar> labcars;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.tbl_labcar";
    private String where = "";

    @Override
    public void insert(LabCar labcar) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_labcar` (`trashCar`, `collectCar`, `acidCar`, `soapCar`, `densityCar`) VALUES (?, ?, ?, ?, ?);";
            prepareStatement(sql);
            stmt.setInt(1, labcar.getTrashCar());
            stmt.setInt(2, labcar.getCollect().getValor());
            stmt.setDouble(3, labcar.getAcidCar());
            stmt.setDouble(4, labcar.getSoapCar());
            stmt.setDouble(5, labcar.getDensityCar());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<LabCar> select() {
        String ORDER = " ORDER BY idCar DESC";
        selectAll(SELECT_QUERY + ORDER, null);
        return labcars;
    }

    public LabCar select(LabCar labcar) {
         SELECT_QUERY += "WHERE idCar = ?";
         selectAll(SELECT_QUERY,labcar);
         return labcars.get(0);
    }


    @Override
    public List<LabCar> select(List<String> query, LabCar labCar) {
        query.forEach(s -> where += String.format(" %s ? AND", s));
        SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 3);
        selectAll(SELECT_QUERY, labCar);
        return labcars;
    }

    private void selectAll(String query, LabCar labCar) {
        connection();
        labcars = new ArrayList<>();
        try {
            prepareStatement(query);
            if (labCar != null) {
                int i = 1;
                if (labCar.getIdCar() != null) {
                    stmt.setLong(i++, labCar.getIdCar());
                }
                if (labCar.getDtCar() != null) {
                    stmt.setDate(i++, labCar.getDtCar());
                }
                if (labCar.getDateBetween() != null) {
                    stmt.setDate(i, labCar.getDateBetween());
                }
            }
            resultSet();
            while (rs.next()) {
                LabCar labcar = new LabCar();
                labcar.setIdCar(rs.getLong("idCar"));
                labcar.setTrashCar(rs.getInt("trashCar"));
                labcar.setCollect(rs.getInt("collectCar"));
                labcar.setAcidCar(rs.getDouble("acidCar"));
                labcar.setSoapCar(rs.getDouble("soapCar"));
                labcar.setDensityCar(rs.getDouble("densityCar"));
                labcar.setDtCar(rs.getDate("dtCar"));
                labcar.setHrCar(rs.getTime("hrCar"));

                labcars.add(labcar);
            }
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnectionRs();
        }
    }
}
