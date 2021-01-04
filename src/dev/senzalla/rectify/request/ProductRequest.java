package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Product;
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
public class ProductRequest extends ConectionMySql {

    public void insert(Product product) {
        try {
            super.connection();
            final String sql = "INSERT INTO `tbl_product` (`densityProduct`, `nameProduct`) VALUES (?, ?);";
            super.prepareStatement(sql);
            stmt.setDouble(1, product.getDensityProduct());
            stmt.setString(2, product.getNameProduct());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Product: " + ex.getMessage(), product.getNameProduct());
        } finally {
            super.closeConnection();
        }
    }

    public List<Product> select() {
        List<Product> products = new ArrayList<>();
        try {
            super.connection();
            final String SELECT_QUERY = "SELECT * FROM tbl_product";
            super.prepareStatement(SELECT_QUERY);
            super.resultSet();
            while (rs.next()) {
                Product product = new Product();
                product.setIdProduct(rs.getLong("idProduct"));
                product.setNameProduct(rs.getString("nameProduct"));
                product.setDensityProduct(rs.getDouble("densityProduct"));
                products.add(product);
            }
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Product: " + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return products;
    }
}
