package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.MakeEster;
import dev.senzalla.rectify.entitys.MatterMake;
import dev.senzalla.rectify.entitys.Product;
import dev.senzalla.rectify.exception.DataBaseException;
import dev.senzalla.rectify.setting.ConectionMySql;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MatterEsterRequest extends ConectionMySql {

    public void insert(MatterMake matterester) {
        try {
            super.connection();
            final String sql = "INSERT INTO `tbl_matter_ester` (`literMatterEster`, `fkProduct`) VALUES (?, ?);";
            super.prepareStatement(sql);
            stmt.setInt(1, matterester.getLiterMatterMake());
            stmt.setLong(2, matterester.getProduct().getIdProduct());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Matter Make Ester: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }

    public MakeEster select(MakeEster makeester) {
        try {
            final String SELECT_QUERY = "SELECT * FROM view_matter_ester WHERE fkMakeEster = ?";
            super.connection();
            Set<MatterMake> matterMakes = new HashSet<>();
            super.prepareStatement(SELECT_QUERY);
            stmt.setLong(1, makeester.getIdMakeEster());
            super.resultSet();
            while (rs.next()) {
                MatterMake matterester = new MatterMake();
                matterester.setIdMatterMake(rs.getLong("idMatterEster"));
                matterester.setLiterMatterMake(rs.getInt("literMatterEster"));
                matterester.setProduct(new Product(rs.getString("nameProduct")));
                matterMakes.add(matterester);
            }
            makeester.setMatterEster(matterMakes);
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Matter Make Ester: " + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return makeester;
    }
}
