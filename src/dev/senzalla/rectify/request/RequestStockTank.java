package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Product;
import dev.senzalla.rectify.entitys.StockTank;
import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.exception.DataBaseException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class RequestStockTank extends Request<StockTank> {

    private List<StockTank> stockTanks;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.view_stocktank";
    private String where = "";

    @Override
    public void insert(StockTank stockTank) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_stocktank` (`literStkTq`, `fkTankStkTq`, `fkProductStkTq`) VALUES (?, ?, ?);";
            prepareStatement(sql);
            stmt.setInt(1, stockTank.getLiterStkTq());
            stmt.setLong(2, stockTank.getTank().getIdTank());
            stmt.setLong(3, stockTank.getProduct().getIdProduct());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnection();
        }
    }


    @Override
    public List<StockTank> select() {
        final String DATE = "dtStkTq = CURDATE()";
        selectAll(SELECT_QUERY + " WHERE " + DATE, null);
        return stockTanks;
    }

    @Override
    public List<StockTank> select(StockTank stockTank) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public List<StockTank> select(List<String> query, StockTank parameter) {
        query.forEach(s -> where += String.format(" %s ? AND", s));
        SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 3);
        selectAll(SELECT_QUERY, parameter);
        return stockTanks;
    }

    private void selectAll(String query, StockTank parameter) {
        connection();
        stockTanks = new ArrayList<>();
        try {
            prepareStatement(query);
            if (parameter != null) {
                int i = 1;
                if (parameter.getTank() != null) {
                    stmt.setString(i++, parameter.getTank().getNameTank());
                }
                if (parameter.getProduct() != null) {
                    stmt.setString(i++, parameter.getProduct().getNameProduct());
                }
                if (parameter.getDtStkTq() != null) {
                    stmt.setDate(i++, parameter.getDtStkTq());
                }
                if (parameter.getDateBetween() != null) {
                    stmt.setDate(i, parameter.getDateBetween());
                }
            }
            resultSet();
            while (rs.next()) {
                StockTank stockTank = new StockTank();
                stockTank.setLiterStkTq(rs.getInt("literStkTq"));
                stockTank.setDtStkTq(rs.getDate("dtStkTq"));

                Tank tank = new Tank();
                tank.setNameTank(rs.getString("nameTank"));
                stockTank.setTank(tank);

                Product product = new Product();
                product.setNameProduct(rs.getString("nameProduct"));
                stockTank.setProduct(product);

                stockTanks.add(stockTank);
            }
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnectionRs();
        }
    }

    public int selectSum(Product product) {
        String query = "SELECT sum(literStkTq) FROM db_retifica.tbl_stocktank";
        if (product != null) {
            query += " where fkProductStkTq = ?";
        }
        connection();
        try {
            prepareStatement(query);
            if (product != null) {
                stmt.setLong(1, product.getIdProduct());
            }
            resultSet();
            if (rs.next()) {
                return rs.getInt("sum(literStkTq)");
            }
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnectionRs();
        }
        return 0;
    }

}
