package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.calc.CalcStockProduct;
import dev.senzalla.rectify.entitys.Product;
import dev.senzalla.rectify.entitys.StockProduct;
import dev.senzalla.rectify.frame.StockProductTableFrame;
import dev.senzalla.rectify.frame.StockTankAddFrame;
import dev.senzalla.rectify.request.ProductRequest;
import dev.senzalla.rectify.request.StockProductRequest;
import dev.senzalla.rectify.request.StockTankRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class StockProductTreatment {

    public static void initTable(JTable tableStockProduct) {
        fillTable(tableStockProduct, new StockProductRequest().select(null, null));
    }

    public static void initTableWithFilter(JTable tableStockProduct, Object product, Date dateOf, Date dateUntil) {
        List<String> clause = new ArrayList<>();
        StockProduct stockProduct = new StockProduct();
        if (!product.equals("Produto")) {
            clause.add("nameProduct =");
            stockProduct.setProduct((Product) product);
        }
        if (dateOf != null && dateUntil != null) {
            clause.add("dtStkPd between");
            stockProduct.setDateStockProduct(dateOf);
            clause.add("");
            stockProduct.setDateBetween(dateUntil);

        } else {
            if (dateOf != null) {
                clause.add("dtStkPd =");
                stockProduct.setDateStockProduct(dateOf);
            }
            if (dateUntil != null) {
                clause.add("dtStkPd =");
                stockProduct.setDateStockProduct(dateUntil);
            }
        }
        if (!new StockProductRequest().select(clause, stockProduct).isEmpty()) {
            List<StockProduct> stockProducts = new StockProductRequest().select(clause, stockProduct);
            fillTable(tableStockProduct, stockProducts);
        } else {
            PopUp.searchNoResults("Estoque");
        }
    }

    private static void fillTable(JTable tbl, List<StockProduct> stockProduct) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        StockProductTableFrame.query(stockProduct);
        stockProduct.forEach(stock ->
                model.addRow(new Object[]{
                        stock.getProduct(),
                        stock.getLiterProduct(),
                        stock.getPercentProduct()
                }));
    }

    public void checkStockProduct(StockProductTableFrame frmStkProduct, JTable tableStockProduct) {
        List<StockProduct> stockProducts = new StockProductRequest().select(null, null);
        if (stockProducts.isEmpty()) {
            if (!new StockTankRequest().select(null, null).isEmpty()) {
                saveStockProduct(tableStockProduct);
            } else {
                PopUp.searchNoResults();
                Access.goToInternalFrame(frmStkProduct, new StockTankAddFrame());
            }
        } else {
            fillTable(tableStockProduct, stockProducts);
        }
    }

    private void saveStockProduct(JTable tbl) {
        StockProduct stockProduct = new StockProduct();

        new ProductRequest().select().forEach(product -> {
            CalcStockProduct calc = new CalcStockProduct(product);

            stockProduct.setProduct(product);
            stockProduct.setLiterProduct(calc.getLitters());
            stockProduct.setPercentProduct(calc.getPercent());
            new StockProductRequest().insert(stockProduct);
        });
        initTable(tbl);
    }


}
