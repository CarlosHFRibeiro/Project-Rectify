package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Product;
import dev.senzalla.rectify.entitys.StockTank;
import dev.senzalla.rectify.entitys.Tank;
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
public class StockTankRequest extends ConectionMySql {

    public void insert(StockTank stockTank) {
        try {
            super.connection();
            final String sql = "INSERT INTO `tbl_stock_tank` (`fkTank`, `fkProduct`, `literProduct`) VALUES (?, ?, ?);";
            super.prepareStatement(sql);
            stmt.setLong(1, stockTank.getTank().getIdTank());
            stmt.setLong(2, stockTank.getProduct().getIdProduct());
            stmt.setInt(3, stockTank.getLiterProduct());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Stock Tank: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }

    public List<StockTank> select(List<String> query, StockTank parameter) {
        String selectQuery = "view_stock_tank";

        if (parameter == null) {
            selectQuery = QueryTreatment.curdate(selectQuery, "dateStockTank");
            return selectAll(selectQuery, parameter);
        } else {
            selectQuery = QueryTreatment.createQuery(selectQuery, query);
            return selectAll(selectQuery, parameter);
        }
    }

    private List<StockTank> selectAll(String selectQuery, StockTank parameter) {
        super.connection();
        List<StockTank> stockTanks = new ArrayList<>();
        try {
            super.prepareStatement(selectQuery);
            this.prepareStatement(parameter);
            super.resultSet();
            while (rs.next()) {
                StockTank stockTank = new StockTank();
                stockTank.setDateStockTank(rs.getDate("dateStockTank"));
                stockTank.setLiterProduct(rs.getInt("literProduct"));
                stockTank.setTank(new Tank(rs.getString("nameTank")));
                stockTank.setProduct(new Product(rs.getString("nameProduct")));
                stockTanks.add(stockTank);
            }
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Stock Tank: " + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return stockTanks;
    }

    private void prepareStatement(StockTank parameter) throws SQLException {
        if (parameter != null) {
            int i = 1;
            if (parameter.getTank() != null) {
                stmt.setString(i++, parameter.getTank().getNameTank());
            }
            if (parameter.getProduct() != null) {
                stmt.setString(i++, parameter.getProduct().getNameProduct());
            }
            if (parameter.getDateStockTank() != null) {
                stmt.setDate(i++, parameter.getDateStockTank());
            }
            if (parameter.getDateBetween() != null) {
                stmt.setDate(i, parameter.getDateBetween());
            }
        }
    }

    public int selectSum(Product product) {
        int sumProduct = 0;
        try {
            String query = "SELECT SUM(literProduct) AS sumLiter FROM tbl_stock_tank " + (product != null ? "WHERE fkProduct = ?" : "");
            super.connection();
            super.prepareStatement(query);
            this.prepareStatement(product);
            super.resultSet();
            if (rs.next()) {
                sumProduct = rs.getInt("sumLiter");
            }
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Stock Tank: " + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return sumProduct;
    }

    private void prepareStatement(Product product) throws SQLException {
        if (product != null) {
            stmt.setLong(1, product.getIdProduct());
        }
    }

}
