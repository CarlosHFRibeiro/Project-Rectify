package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.treatments.DateTreatment;

import java.sql.Date;


/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class StockTank extends DateTreatment {
    private Long idStockTank;
    private int literProduct;
    private Date dateStockTank;
    private Product product;
    private Tank tank;

    public Long getIdStockTank() {
        return idStockTank;
    }

    public void setIdStockTank(Long idStockTank) {
        this.idStockTank = idStockTank;
    }

    public int getLiterProduct() {
        return literProduct;
    }

    public void setLiterProduct(int literProduct) {
        this.literProduct = literProduct;
    }

    public Date getDateStockTank() {
        return dateStockTank;
    }

    public void setDateStockTank(java.util.Date dateStockTank) {
        this.dateStockTank = convertDateSql(dateStockTank);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }
}
