package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Collect;
import dev.senzalla.rectify.entitys.LabCar;
import dev.senzalla.rectify.exception.ElementDuplicate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class LabCarRequest extends Request<LabCar> {

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
            stmt.setString(2, labcar.getCollect().getDescricao());
            stmt.setDouble(3, labcar.getAcidCar());
            stmt.setDouble(4, labcar.getSoapCar());
            stmt.setDouble(5, labcar.getDensityCar());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new ElementDuplicate().processMsg(ex.getMessage(), null);
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<LabCar> select() {
        selectAll(SELECT_QUERY, null);
        return labcars;
    }

    @Override
    public List<LabCar> select(LabCar labcar) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public List<LabCar> select(List<String> query, LabCar labCar) {
        query.forEach(s -> where += String.format(" %s ? AND", s));

        SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 3);
        selectAll(SELECT_QUERY, null);
        return labcars;
    }

    private void selectAll(String query, LabCar labCar) {
        connection();
        if (labcars == null) {
            labcars = new ArrayList<>();
        }
        try {
            prepareStatement(query);
            if (labCar != null) {
                stmt.setLong(1, labCar.getIdCar());
                stmt.setString(2, labCar.getCollect().getDescricao());
//                stmt.setTimestamp(3, labCar.getDtCar());
                stmt.setDate(4, labCar.getDateBetween());
            }
            resultSet();
            while (rs.next()) {
                LabCar labcar = new LabCar();
                labcar.setIdCar(rs.getLong("idCar"));
                labcar.setTrashCar(rs.getInt("trashCar"));
                labcar.setCollect(rs.getObject("collectCar", Collect.class));
                labcar.setAcidCar(rs.getDouble("acidCar"));
                labcar.setSoapCar(rs.getDouble("soapCar"));
                labCar.setDensityCar(rs.getDouble("densityCar"));
                labCar.setDtCar(rs.getTimestamp("dtCar"));

                labcars.add(labcar);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnectionRs();
        }
    }
}
