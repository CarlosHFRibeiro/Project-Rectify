package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.MakeTrans;
import dev.senzalla.rectify.entitys.MatterTrans;
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
public class RequestMatterTrans extends Request<MatterTrans> {

    @Override
    public void insert(MatterTrans matterester) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_mattertrans` (`literMtTrans`, `fkProductMtTrans`) VALUES (?, ?);";
            prepareStatement(sql);
            stmt.setInt(1, matterester.getLiterMtTrans());
            stmt.setLong(2, matterester.getProduct().getIdProduct());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnection();
        }
    }

    public MakeTrans select(MakeTrans makeester) {
        try {
            final String SELECT_QUERY = "SELECT * FROM db_retifica.view_matterester WHERE fkMtTrans = ?";
            connection();
            Set<MatterTrans> matterTranss = new HashSet<>();
            prepareStatement(SELECT_QUERY);
            stmt.setLong(1, makeester.getIdTrans());
            resultSet();
            while (rs.next()) {
                MatterTrans matterester = new MatterTrans();
                matterester.setIdMtTrans(rs.getLong("idMtTrans"));
                matterester.setLiterMtTrans(rs.getInt("literMtTrans"));
                matterester.setProduct(new Product(rs.getString("nameProduct")));
                matterTranss.add(matterester);
            }
            makeester.setMatterTrans(matterTranss);
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnectionRs();
        }
        return makeester;
    }

    @Override
    public List<MatterTrans> select() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MatterTrans> select(List<String> clause, MatterTrans matterTrans) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
