package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Hcl;
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
public class HclRequest extends ConectionMySql {

    public void insert(Hcl hcl) {
        try {
            super.connection();
            final String sql = "INSERT INTO `tbl_hcl` (`concentrationHcl`) VALUES (?);";
            super.prepareStatement(sql);
            stmt.setDouble(1, hcl.getConcentrationHcl());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("HCl: " + ex.getMessage(), String.valueOf(hcl.getConcentrationHcl()));
        } finally {
            super.closeConnection();
        }
    }

    public List<Hcl> select() {
        List<Hcl> hcls = new ArrayList<>();
        try {
            String SELECT_QUERY = "SELECT * FROM tbl_hcl;";
            super.connection();
            super.prepareStatement(SELECT_QUERY);
            super.resultSet();
            while (rs.next()) {
                Hcl hcl = new Hcl();
                hcl.setIdHcl(rs.getLong("idHcl"));
                hcl.setConcentrationHcl(rs.getDouble("concentrationHcl"));
                hcls.add(hcl);
            }
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("HCl: " + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return hcls;
    }

    public void update(Hcl hcl) {
        try {
            super.connection();
            final String sql = "UPDATE `tbl_hcl` SET `concentrationHcl` = ? WHERE (`idHcl` = ?);";
            super.prepareStatement(sql);
            stmt.setDouble(1, hcl.getConcentrationHcl());
            stmt.setLong(2, hcl.getIdHcl());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("HCl: " + ex.getMessage(), String.valueOf(hcl.getConcentrationHcl()));
        } finally {
            super.closeConnection();
        }
    }

    public void delete(Hcl hcl) {
        try {
            super.connection();
            final String sql = "DELETE FROM `tbl_hcl` WHERE idHcl = ?;";
            super.prepareStatement(sql);
            stmt.setLong(1, hcl.getIdHcl());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("HCl: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }

    public void deleteAll() {
        try {
            final String sql = "TRUNCATE TABLE `tbl_hcl`;";
            super.connection();
            super.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("HCl: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }
}
