package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.treatments.DateTreatment;

import java.sql.Date;


/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class StockProduct extends DateTreatment {
    private Long idStockProduct;
    private int literProduct;
    private double percentProduct;
    private Date dateStockProduct;
    private Product product;

    public Long getIdStockProduct() {
        return idStockProduct;
    }

    public void setIdStockProduct(Long idStockProduct) {
        this.idStockProduct = idStockProduct;
    }

    public int getLiterProduct() {
        return literProduct;
    }

    public void setLiterProduct(int literProduct) {
        this.literProduct = literProduct;
    }

    public double getPercentProduct() {
        return percentProduct;
    }

    public void setPercentProduct(double percentProduct) {
        this.percentProduct = percentProduct;
    }

    public Date getDateStockProduct() {
        return dateStockProduct;
    }

    public void setDateStockProduct(java.util.Date dateStockProduct) {
        this.dateStockProduct = convertDateSql(dateStockProduct);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
