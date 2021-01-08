package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Product;
import dev.senzalla.rectify.entitys.StockProduct;
import dev.senzalla.rectify.exception.DataBaseException;
import dev.senzalla.rectify.setting.ConectionMySql;
import dev.senzalla.rectify.treatments.QueryTreatment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class StockProductRequest extends ConectionMySql {

    public void insert(StockProduct stockProduct) {
        super.connection();
        try {
            final String sql = "INSERT INTO `tbl_stock_product` (`fkProduct`, `literProduct`, `percentProduct`) VALUES (?, ?, ?);";
            super.prepareStatement(sql);
            stmt.setLong(1, stockProduct.getProduct().getIdProduct());
            stmt.setInt(2, stockProduct.getLiterProduct());
            stmt.setDouble(3, stockProduct.getPercentProduct());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Stock Product: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }

    public List<StockProduct> select(List<String> query, StockProduct parameter) {
        String selectQuery = "view_stock_product";

        if (parameter == null) {
            selectQuery = QueryTreatment.curdate(selectQuery, "dateStockProduct");
            return selectAll(selectQuery, parameter);
        } else {
            selectQuery = QueryTreatment.createQuery(selectQuery, query);
            return selectAll(selectQuery, parameter);
        }
    }

    private List<StockProduct> selectAll(String query, StockProduct parameter) {
        List<StockProduct> stockProducts = new ArrayList<>();
        try {
            super.connection();
            super.prepareStatement(query);
            this.prepareStatement(parameter);
            super.resultSet();
            while (rs.next()) {
                StockProduct stockProduct = new StockProduct();
                stockProduct.setDateStockProduct(rs.getDate("dateStockProduct"));
                stockProduct.setLiterProduct(rs.getInt("literProduct"));
                stockProduct.setProduct(new Product(rs.getString("nameProduct")));
                stockProduct.setPercentProduct(rs.getDouble("percentProduct"));
                stockProducts.add(stockProduct);
            }
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Stock Product: " + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return stockProducts;
    }

    private void prepareStatement(StockProduct parameter) throws SQLException {
        if (parameter != null) {
            int i = 1;
            if (parameter.getProduct() != null) {
                stmt.setString(i++, parameter.getProduct().getNameProduct());
            }
            if (parameter.getDateStockProduct() != null) {
                stmt.setDate(i++, parameter.getDateStockProduct());
            }
            if (parameter.getDateBetween() != null) {
                stmt.setDate(i, parameter.getDateBetween());
            }
        }
    }
}
