package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.MakeBiodiesel;
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
public class MatterBiodieselRequest extends ConectionMySql {

    public void insert(MatterMake matterMake) {
        try {
            super.connection();
            final String sql = "INSERT INTO `tbl_matter_biodiesel` (`literMatterBiodiesel`, `fkProduct`) VALUES (?, ?);";
            super.prepareStatement(sql);
            stmt.setInt(1, matterMake.getLiterMatterMake());
            stmt.setLong(2, matterMake.getProduct().getIdProduct());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Matter Biodiesel: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }

    public MakeBiodiesel select(MakeBiodiesel makeBiodiesel) {
        try {
            final String SELECT_QUERY = "SELECT * FROM view_matter_biodiesel WHERE fkMakeBiodiesel = ?";
            super.connection();
            Set<MatterMake> matterMakes = new HashSet<>();
            super.prepareStatement(SELECT_QUERY);
            stmt.setLong(1, makeBiodiesel.getIdMakeBiodiesel());
            super.resultSet();
            while (rs.next()) {
                MatterMake matterester = new MatterMake();
                matterester.setIdMatterMake(rs.getLong("idMatterBiodiesel"));
                matterester.setLiterMatterMake(rs.getInt("literMatterBiodiesel"));
                matterester.setProduct(new Product(rs.getString("nameProduct")));
                matterMakes.add(matterester);
            }
            makeBiodiesel.setMatterMakes(matterMakes);
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Matter Biodiesel: " + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return makeBiodiesel;
    }
}
