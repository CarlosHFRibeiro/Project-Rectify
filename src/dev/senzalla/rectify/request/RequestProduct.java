package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Product;
import dev.senzalla.rectify.exception.DataBaseException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class RequestProduct extends Request<Product> {

    private List<Product> products;
    private final String SELECT_QUERY = "SELECT * FROM db_retifica.tbl_product";

    @Override
    public void insert(Product product) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_product` (`densityProduct`, `nameProduct`) VALUES (?, ?);";
            prepareStatement(sql);
            stmt.setDouble(1, product.getDensityProduct());
            stmt.setString(2, product.getNameProduct());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage(), product.getNameProduct());
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Product> select() {
        selectAll(SELECT_QUERY, null);
        return products;
    }

    @Override
    public List<Product> select(Product product) {
        return null;
    }


    public Product selectName(Product product) {
        String clause = SELECT_QUERY + " WHERE UPPER(nameProduct) = UPPER(?);";
        selectAll(clause, product);
        return products.get(0);
    }

    @Override
    public List<Product> select(List<String> clause, Product product) {
        return null;
    }

    private void selectAll(String select, Product parameter) {
        connection();
        products = new ArrayList<>();
        try {
            prepareStatement(select);
            if (parameter != null) {
                stmt.setString(1, parameter.getNameProduct());
            }
            resultSet();
            while (rs.next()) {
                Product product = new Product();
                product.setIdProduct(rs.getLong("idProduct"));
                product.setNameProduct(rs.getString("nameProduct"));
                product.setDensityProduct(rs.getDouble("densityProduct"));
                products.add(product);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnectionRs();
        }
    }
}
