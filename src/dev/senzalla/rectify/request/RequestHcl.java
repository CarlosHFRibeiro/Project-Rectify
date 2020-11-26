package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Hcl;
import dev.senzalla.rectify.exception.DataBaseException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class RequestHcl extends Request<Hcl> {

    private List<Hcl> hcls;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.tbl_hcl;";

    @Override
    public void insert(Hcl hcl) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_hcl` (`valueHcl`) VALUES (?);";
            prepareStatement(sql);
            stmt.setDouble(1, hcl.getValueHcl());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage(), String.valueOf(hcl.getValueHcl()));
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Hcl> select() {
        selectAll(SELECT_QUERY);
        return hcls;
    }

    @Override
    public List<Hcl> select(Hcl hcl) {
        return null;
    }

    @Override
    public List<Hcl> select(List<String> clause, Hcl hcl) {
        return null;
    }

    private void selectAll(String select) {
        connection();
        if (hcls == null) {
            hcls = new ArrayList<>();
        }
        try {
            prepareStatement(select);
            resultSet();
            while (rs.next()) {
                Hcl hcl = new Hcl();
                hcl.setIdHcl(rs.getLong("idHcl"));
                hcl.setValueHcl(rs.getDouble("valueHcl"));
                hcls.add(hcl);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnectionRs();
        }
    }

    public void update(Hcl hcl) {
        connection();
        try {
            final String sql = "UPDATE `db_retifica`.`tbl_hcl` SET `valueHcl` = ? WHERE (`idHcl` = ?);";
            prepareStatement(sql);
            stmt.setDouble(1, hcl.getValueHcl());
            stmt.setLong(2, hcl.getIdHcl());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage(), String.valueOf(hcl.getValueHcl()));
        } finally {
            closeConnection();
        }
    }

    public void delete(Hcl hcl) {
        connection();
        final String sql = "DELETE FROM `db_retifica`.`tbl_hcl` WHERE idHcl = ?;";
        try {
            prepareStatement(sql);
            stmt.setLong(1, hcl.getIdHcl());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnection();
        }
    }
    public void deleteAll() {
        connection();
        final String sql = "TRUNCATE TABLE `db_retifica`.`tbl_hcl`;";
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
