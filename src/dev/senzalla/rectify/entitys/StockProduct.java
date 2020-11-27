package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.treatments.TreatmentDate;

import java.sql.Date;


/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class StockProduct extends TreatmentDate {
    private Long idStkPd;
    private int literStkPd;
    private int percentStkPd;
    private Date dtStkPd;
    private Product product;

    public Long getIdStkPd() {
        return idStkPd;
    }

    public void setIdStkPd(Long idStkPd) {
        this.idStkPd = idStkPd;
    }

    public int getLiterStkPd() {
        return literStkPd;
    }

    public void setLiterStkPd(int literStkPd) {
        this.literStkPd = literStkPd;
    }

    public int getPercentStkPd() {
        return percentStkPd;
    }

    public void setPercentStkPd(int percentStkPd) {
        this.percentStkPd = percentStkPd;
    }

    public Date getDtStkPd() {
        return dtStkPd;
    }

    public void setDtStkPd(java.util.Date dtStkPd) {
        this.dtStkPd = convertDateSql(dtStkPd);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
