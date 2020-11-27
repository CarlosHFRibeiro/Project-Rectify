package dev.senzalla.rectify.treatments;

import com.toedter.calendar.JDateChooser;
import dev.senzalla.rectify.canvas.FrmStkTank;
import dev.senzalla.rectify.entitys.Product;
import dev.senzalla.rectify.entitys.StockTank;
import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.request.RequestStockTank;
import dev.senzalla.rectify.request.RequestTank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatmentStockTank {

    private DefaultTableModel model;

    public void showTable(JTable tbl) {
        model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        new RequestStockTank().select().forEach(this::table);
    }

    private void table(StockTank stockTank) {
        model.addRow(new Object[]{
                stockTank.getTank(),
                stockTank.getProduct(),
                stockTank.getLiterStkTq()
        });
    }

    public void saveStockTank(JTable tbl) {
        for (int i = 0; i < tbl.getRowCount(); i++) {
            if (!tbl.getValueAt(i, 1).equals("Produto")) {
                Tank tank = new TreatmentTank().getTank(tbl.getValueAt(i, 0));
                StockTank stockTank = new StockTank();
                stockTank.setTank(tank);
                stockTank.setProduct(new TreatmentProduct().getProduct(tbl.getValueAt(i, 1)));
                stockTank.setLiterStkTq(litter(tbl, i, tank));
                new RequestStockTank().insert(stockTank);
                new TreatmentStockTank().tableTank(tbl);
            }
        }
    }

    private int litter(JTable tbl, int i, Tank tank) {
        Object litters = tbl.getValueAt(i, 2);
        int litter = 0;
        if (litters != null) {
            litter = Integer.parseInt(litters.toString());
            return litter >= tank.getCapacityTank() ? tank.getCapacityTank() : litter;
        }
        return litter;
    }

    public void tableTank(JTable tbl) {
        model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        new RequestTank().select().forEach(tank
                -> model.addRow(new Object[]{
                tank.getNameTank(),
                "Produto"
        }));
    }

    public void showTable(JTable tbl, JComboBox<Object> cbxTank, JComboBox<Object> cbxProduct, JDateChooser dtcDe, JDateChooser dtcAte) {
        List<String> clause = new ArrayList<>();
        StockTank stockTank = new StockTank();
        if (cbxTank.getSelectedIndex() > 0) {
            Tank tank = new Tank();
            tank.setNameTank(String.valueOf(cbxTank.getSelectedItem()));
            clause.add("nameTank =");
            stockTank.setTank(tank);
        }
        if (cbxProduct.getSelectedIndex() > 0) {
            Product product = new Product();
            product.setNameProduct(String.valueOf(cbxProduct.getSelectedItem()));
            clause.add("nameProduct =");
            stockTank.setProduct(product);
        }
        if (dtcAte.getDate() != null && dtcDe.getDate() != null) {
            clause.add("dtStkTq between");
            stockTank.setDtStkTq(dtcDe.getDate());
            clause.add("");
            stockTank.setDateBetween(dtcAte.getDate());

        } else {
            if (dtcDe.getDate() != null) {
                clause.add("dtStkTq =");
                stockTank.setDtStkTq(dtcDe.getDate());
            }
            if (dtcAte.getDate() != null) {
                clause.add("dtStkTq =");
                stockTank.setDtStkTq(dtcAte.getDate());
            }
        }
        if (!new RequestStockTank().select(clause, stockTank).isEmpty()) {
            FrmStkTank.queryFilter(clause, stockTank);
            model = (DefaultTableModel) tbl.getModel();
            model.setNumRows(0);
            selectQuery(clause, stockTank).forEach(this::table);
        } else {
            PopUp.isEmpty("Estoque");
        }
    }

    public List<StockTank> selectQuery(List<String> clause, StockTank stockTank) {
        return new RequestStockTank().select(clause, stockTank);
    }

}
