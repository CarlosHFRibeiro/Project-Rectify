package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Product;
import dev.senzalla.rectify.entitys.StockProduct;
import dev.senzalla.rectify.exception.DataBaseException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class RequestStockProduct extends Request<StockProduct> {

    private List<StockProduct> stockProducts;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.view_stkproduct";
    private String where = "";

    @Override
    public void insert(StockProduct stockProduct) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_stockproduct` (`literStkPd`, `percentStkPd`, `fkProductStkPd`) VALUES (?, ?, ?);";
            prepareStatement(sql);
            stmt.setInt(1, stockProduct.getLiterStkPd());
            stmt.setInt(2, stockProduct.getPercentStkPd());
            stmt.setLong(3, stockProduct.getProduct().getIdProduct());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnection();
        }
    }


    @Override
    public List<StockProduct> select() {
        final String DATE = "dtStkPd = CURDATE()";
        selectAll(SELECT_QUERY + " WHERE " + DATE, null);
        return stockProducts;
    }

    @Override
    public List<StockProduct> select(List<String> query, StockProduct parameter) {
        query.forEach(s -> where += String.format(" %s ? AND", s));
        SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 3);
        selectAll(SELECT_QUERY, parameter);
        return stockProducts;
    }

    private void selectAll(String query, StockProduct parameter) {
        connection();
        stockProducts = new ArrayList<>();
        try {
            prepareStatement(query);
            if (parameter != null) {
                int i = 1;
                if (parameter.getProduct() != null) {
                    stmt.setString(i++, parameter.getProduct().getNameProduct());
                }
                if (parameter.getDtStkPd() != null) {
                    stmt.setDate(i++, parameter.getDtStkPd());
                }
                if (parameter.getDateBetween() != null) {
                    stmt.setDate(i, parameter.getDateBetween());
                }
            }
            resultSet();
            while (rs.next()) {
                StockProduct stockProduct = new StockProduct();
                stockProduct.setLiterStkPd(rs.getInt("literStkPd"));
                stockProduct.setPercentStkPd(rs.getInt("percentStkPd"));
                stockProduct.setDtStkPd(rs.getDate("dtStkPd"));

                Product tank = new Product();
                tank.setNameProduct(rs.getString("nameProduct"));
                stockProduct.setProduct(tank);

                stockProducts.add(stockProduct);
            }
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnectionRs();
        }
    }
}
