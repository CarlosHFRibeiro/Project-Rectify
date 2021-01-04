package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Naoh;
import dev.senzalla.rectify.exception.DataBaseException;
import dev.senzalla.rectify.setting.ConectionMySql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class NaohRequest extends ConectionMySql {


    public void insert(Naoh naoh) {
        try {
            super.connection();
            final String sql = "INSERT INTO `tbl_naoh` (`concentrationNaoh`) VALUES (?);";
            super.prepareStatement(sql);
            stmt.setDouble(1, naoh.getConcentrationNaoh());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("NaOH: " + ex.getMessage(), String.valueOf(naoh.getConcentrationNaoh()));
        } finally {
            super.closeConnection();
        }
    }

    public List<Naoh> select() {
        List<Naoh> naohs = new ArrayList<>();
        try {
            String SELECT_QUERY = "SELECT * FROM tbl_naoh;";
            super.connection();
            super.prepareStatement(SELECT_QUERY);
            super.resultSet();
            while (rs.next()) {
                Naoh naoh = new Naoh();
                naoh.setIdNaoh(rs.getLong("idNaoh"));
                naoh.setConcentrationNaoh(rs.getDouble("concentrationNaoh"));
                naohs.add(naoh);
            }
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("NaOH: " + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return naohs;
    }

    public void update(Naoh naoh) {
        try {
            super.connection();
            final String sql = "UPDATE `tbl_naoh` SET `concentrationNaoh` = ? WHERE (`idNaoh` = ?);";
            super.prepareStatement(sql);
            stmt.setDouble(1, naoh.getConcentrationNaoh());
            stmt.setLong(2, naoh.getIdNaoh());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("NaOH: " + ex.getMessage(), String.valueOf(naoh.getConcentrationNaoh()));
        } finally {
            super.closeConnection();
        }
    }

    public void delete(Naoh naoh) {
        try {
            final String sql = "DELETE FROM `tbl_naoh` WHERE idNaoh = ?;";
            super.connection();
            super.prepareStatement(sql);
            stmt.setLong(1, naoh.getIdNaoh());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("NaOH: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }

    public void deleteAll() {
        try {
            super.connection();
            final String sql = "TRUNCATE TABLE `tbl_naoh`;";
            super.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("NaOH: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }
}
