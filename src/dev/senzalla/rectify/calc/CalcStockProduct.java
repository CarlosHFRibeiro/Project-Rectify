package dev.senzalla.rectify.calc;

import dev.senzalla.rectify.entitys.Product;
import dev.senzalla.rectify.request.RequestStockTank;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class   CalcStockProduct {
    private int litters;
    private int percent;

    public void setLitters(Product product) {
        litters = new RequestStockTank().selectSum(product);
        setPercent();
    }

    private void setPercent() {
        int total = new RequestStockTank().selectSum(null);
        percent = (100 * litters / total);
    }

    public int getLitters() {
        return litters;
    }

    public int getPercent() {
        return percent;
    }
}
