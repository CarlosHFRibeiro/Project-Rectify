package dev.senzalla.rectify.calc;

import dev.senzalla.rectify.entitys.Product;
import dev.senzalla.rectify.request.StockTankRequest;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class CalcStockProduct {
    private int litters;
    private double percent;
    private final Product product;

    public CalcStockProduct(Product product) {
        this.product = product;
        setLitters();
        setPercent();
    }

    private void setLitters() {
        litters = new StockTankRequest().selectSum(product);
    }

    private void setPercent() {
        double total = new StockTankRequest().selectSum(null);
        percent = (100 * litters / total);
        System.out.println(percent);
    }

    public int getLitters() {
        return litters;
    }

    public double getPercent() {
        return percent;
    }
}
