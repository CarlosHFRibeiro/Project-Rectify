package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Naoh;
import dev.senzalla.rectify.exception.ElementDuplicate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class NaohRequest extends Request<Naoh> {

    private List<Naoh> naohs;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.tbl_naoh;";

    @Override
    public void insert(Naoh naoh) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_naoh` (`valueNaoh`) VALUES (?);";
            prepareStatement(sql);
            stmt.setDouble(1, naoh.getValueNaoh());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new ElementDuplicate().processMsg(ex.getMessage(), String.valueOf(naoh.getValueNaoh()));
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Naoh> select() {
        selectAll(SELECT_QUERY);
        return naohs;
    }

    @Override
    public List<Naoh> select(Naoh naoh) {
        return null;
    }

    @Override
    public List<Naoh> select(Map<String, Naoh> clause) {
        return null;
    }

    private void selectAll(String select) {
        connection();
        if (naohs == null) {
            naohs = new ArrayList<>();
        }
        try {
            prepareStatement(select);
            resultSet();
            while (rs.next()) {
                Naoh naoh = new Naoh();
                naoh.setIdNaoh(rs.getLong("idNaoh"));
                naoh.setValueNaoh(rs.getDouble("valueNaoh"));
                naohs.add(naoh);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnectionRs();
        }
    }

    public void update(Naoh naoh) {
        connection();
        try {
            final String sql = "UPDATE `db_retifica`.`tbl_naoh` SET `valueNaoh` = ? WHERE (`idNaoh` = ?);";
            prepareStatement(sql);
            stmt.setDouble(1, naoh.getValueNaoh());
            stmt.setLong(2, naoh.getIdNaoh());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new ElementDuplicate().processMsg(ex.getMessage(), String.valueOf(naoh.getValueNaoh()));
        } finally {
            closeConnection();
        }
    }

    public void delete(Naoh naoh) {
        connection();
        final String sql = "DELETE FROM `db_retifica`.`tbl_naoh` WHERE idNaoh = ?;";
        try {
            prepareStatement(sql);
            stmt.setLong(1, naoh.getIdNaoh());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnection();
        }
    }
    public void deleteAll() {
        connection();
        final String sql = "TRUNCATE TABLE `db_retifica`.`tbl_naoh`;";
        try {
            prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnection();
        }
    }
}
