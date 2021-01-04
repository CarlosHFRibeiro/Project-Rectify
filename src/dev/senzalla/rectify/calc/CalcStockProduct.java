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
    private int percent;
    private Product product;

    public CalcStockProduct(Product product) {
        this.product = product;
        setLitters();
        setPercent();
    }

    private void setLitters() {
        litters = new StockTankRequest().selectSum(product);
    }

    private void setPercent() {
        int total = new StockTankRequest().selectSum(null);
        percent = (100 * litters / total);
    }

    public int getLitters() {
        return litters;
    }

    public int getPercent() {
        return percent;
    }
}
