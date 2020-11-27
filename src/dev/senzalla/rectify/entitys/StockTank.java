package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.treatments.TreatmentDate;

import java.sql.Date;


/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class StockTank extends TreatmentDate {
    private Long idStkTq;
    private int literStkTq;
    private Date dtStkTq;
    private Tank tank;
    private Product product;

    public Long getIdStkTq() {
        return idStkTq;
    }

    public void setIdStkTq(Long idStkTq) {
        this.idStkTq = idStkTq;
    }

    public int getLiterStkTq() {
        return literStkTq;
    }

    public void setLiterStkTq(int literStkTq) {
        this.literStkTq = literStkTq;
    }

    public Date getDtStkTq() {
        return dtStkTq;
    }

    public void setDtStkTq(java.util.Date dtStkTq) {
        this.dtStkTq = convertDateSql(dtStkTq);
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
