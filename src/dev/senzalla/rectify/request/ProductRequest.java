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
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_product` (`densityProduct`, `nameProduct`) VALUES (?, ?);";
            prepareStatement(sql);
            stmt.setDouble(1, product.getDensityProduct());
            stmt.setString(2, product.getNameProduct());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.processMsg("Produto" + ex.getMessage(), product.getNameProduct());
        } finally {
            closeConnection();
        }
    }

    public List<Product> select() {
        connection();
        List<Product> products = new ArrayList<>();
        try {
            final String SELECT_QUERY = "SELECT * FROM db_retifica.tbl_product";
            prepareStatement(SELECT_QUERY);
            resultSet();
            while (rs.next()) {
                Product product = new Product();
                product.setIdProduct(rs.getLong("idProduct"));
                product.setNameProduct(rs.getString("nameProduct"));
                product.setDensityProduct(rs.getDouble("densityProduct"));
                products.add(product);
            }
        } catch (SQLException ex) {
            DataBaseException.processMsg("Produto" + ex.getMessage());
        } finally {
            closeConnectionRs();
        }
        return products;
    }
}
