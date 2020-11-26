package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.LabBio;
import dev.senzalla.rectify.exception.DataBaseException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class RequestLabBio extends Request<LabBio> {

    private List<LabBio> labBios;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.tbl_labBio";
    private String where = "";
    private final String ORDER = " ORDER BY idBio DESC";

    @Override
    public void insert(LabBio labBio) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_labbio` (`acidBio`, `densityBio`, `density20Bio`, `tempBio`, `factorBio`) VALUES (?, ?, ?, ?, ?);";
            prepareStatement(sql);
            stmt.setDouble(1, labBio.getAcidBio());
            stmt.setDouble(2, labBio.getDensityBio());
            stmt.setDouble(3, labBio.getDensity20Bio());
            stmt.setDouble(4, labBio.getTempBio());
            stmt.setDouble(5, labBio.getFactorBio());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnection();
        }
    }


    @Override
    public List<LabBio> select() {
        selectAll(SELECT_QUERY + ORDER, null);
        return labBios;
    }

    @Override
    public List<LabBio> select(LabBio labBio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public List<LabBio> select(List<String> query, LabBio parameter) {
        query.forEach(s -> where += String.format(" %s ? AND", s));
        SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 3);
        selectAll(SELECT_QUERY + ORDER, parameter);
        return labBios;
    }

    private void selectAll(String query, LabBio parameter) {
        connection();
        labBios = new ArrayList<>();
        try {
            prepareStatement(query);
            if (parameter != null) {
                int i = 1;
                if (parameter.getIdBio() != null) {
                    stmt.setLong(i++, parameter.getIdBio());
                }
                if (parameter.getDtBio() != null) {
                    stmt.setDate(i++, parameter.getDtBio());
                }
                if (parameter.getDateBetween() != null) {
                    stmt.setDate(i, parameter.getDateBetween());
                }
            }
            resultSet();
            while (rs.next()) {
                LabBio labBio = new LabBio();
                labBio.setIdBio(rs.getLong("idBio"));
                labBio.setAcidBio(rs.getDouble("acidBio"));
                labBio.setDensityBio(rs.getDouble("densityBio"));
                labBio.setDensity20Bio(rs.getDouble("density20Bio"));
                labBio.setTempBio(rs.getDouble("tempBio"));
                labBio.setFactorBio(rs.getDouble("factorBio"));
                labBio.setDtBio(rs.getDate("dtBio"));
                labBio.setHrBio(rs.getTime("hrBio"));

                labBios.add(labBio);
            }
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnectionRs();
        }
    }
}
