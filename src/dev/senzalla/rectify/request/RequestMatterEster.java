package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.MakeEster;
import dev.senzalla.rectify.entitys.MatterEster;
import dev.senzalla.rectify.entitys.Product;
import dev.senzalla.rectify.exception.DataBaseException;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class RequestMatterEster extends Request<MatterEster> {

    @Override
    public void insert(MatterEster matterester) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_matterester` (`literMtEster`, `fkProductMtEster`, `fkMtEster`) VALUES (?, ?, ?);";
            prepareStatement(sql);
            stmt.setInt(1, matterester.getLiterMtEster());
            stmt.setLong(2, matterester.getProduct().getIdProduct());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnection();
        }
    }

    public MakeEster select(MakeEster makeester) {
        try {
            final String SELECT_QUERY = "SELECT * FROM db_retifica.view_matterester WHERE fkMtEster = ?";
            connection();
            Set<MatterEster> matterEsters = new HashSet<>();
            prepareStatement(SELECT_QUERY);
            stmt.setLong(1, makeester.getIdEster());
            resultSet();
            while (rs.next()) {
                MatterEster matterester = new MatterEster();
                matterester.setIdMtEster(rs.getLong("idMtEster"));
                matterester.setLiterMtEster(rs.getInt("literMtEster"));
                matterester.setProduct(new Product(rs.getString("nameProduct")));
                matterEsters.add(matterester);
            }
            makeester.setMatterEster(matterEsters);
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnectionRs();
        }
        return makeester;
    }

    @Override
    public List<MatterEster> select() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MatterEster> select(List<String> clause, MatterEster matterEster) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
