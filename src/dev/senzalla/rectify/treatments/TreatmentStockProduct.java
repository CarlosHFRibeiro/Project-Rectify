package dev.senzalla.rectify.treatments;

import com.toedter.calendar.JDateChooser;
import dev.senzalla.rectify.calc.CalcStockProduct;
import dev.senzalla.rectify.entitys.Product;
import dev.senzalla.rectify.entitys.StockProduct;
import dev.senzalla.rectify.frame.FrmStkProduct;
import dev.senzalla.rectify.frame.FrmStockTankAdd;
import dev.senzalla.rectify.request.ProductRequest;
import dev.senzalla.rectify.request.RequestStockProduct;
import dev.senzalla.rectify.request.RequestStockTank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatmentStockProduct {

    private DefaultTableModel model;

    public void showTable(FrmStkProduct frmStkProduct, JTable tbl) {
        if (new RequestStockProduct().select().isEmpty()) {
            if (!new RequestStockTank().select().isEmpty()) {
                saveStockProduct(tbl);
                showTable(tbl);
            } else {
                PopUp.isEmpty();
                Access.goToInternalFrame(frmStkProduct, new FrmStockTankAdd());
            }
        } else {
            showTable(tbl);
        }
    }

    public void showTable(JTable tbl) {
        model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        List<StockProduct> stockProducts = new RequestStockProduct().select();
        FrmStkProduct.query(stockProducts);
        stockProducts.forEach(this::table);
    }

    public void showTable(JTable tbl, JComboBox<Object> cbxProduct, JDateChooser dtcDe, JDateChooser dtcAte) {
        List<String> clause = new ArrayList<>();
        StockProduct stockProduct = new StockProduct();
        if (cbxProduct.getSelectedIndex() > 0) {
            Product product = new Product();
            product.setNameProduct(String.valueOf(cbxProduct.getSelectedItem()));
            clause.add("nameProduct =");
            stockProduct.setProduct(product);
        }
        if (dtcAte.getDate() != null && dtcDe.getDate() != null) {
            clause.add("dtStkPd between");
            stockProduct.setDtStkPd(dtcDe.getDate());
            clause.add("");
            stockProduct.setDateBetween(dtcAte.getDate());

        } else {
            if (dtcDe.getDate() != null) {
                clause.add("dtStkPd =");
                stockProduct.setDtStkPd(dtcDe.getDate());
            }
            if (dtcAte.getDate() != null) {
                clause.add("dtStkPd =");
                stockProduct.setDtStkPd(dtcAte.getDate());
            }
        }
        if (!new RequestStockProduct().select(clause, stockProduct).isEmpty()) {
            model = (DefaultTableModel) tbl.getModel();
            model.setNumRows(0);
            List<StockProduct> stockProducts = new RequestStockProduct().select(clause, stockProduct);
            FrmStkProduct.query(stockProducts);
            stockProducts.forEach(this::table);
        } else {
            PopUp.isEmpty("Estoque");
        }
    }

    private void table(StockProduct stockProduct) {
        model.addRow(new Object[]{
                stockProduct.getProduct(),
                stockProduct.getLiterStkPd(),
                stockProduct.getPercentStkPd()
        });
    }

    private void saveStockProduct(JTable tbl) {
        StockProduct stockProduct = new StockProduct();
        new ProductRequest().select().forEach(product -> {
            CalcStockProduct calc = new CalcStockProduct();
            calc.setLitters(product);

            stockProduct.setProduct(product);
            stockProduct.setLiterStkPd(calc.getLitters());
            stockProduct.setPercentStkPd(calc.getPercent());
            new RequestStockProduct().insert(stockProduct);
        });
        showTable(tbl);
    }


}
