package dev.senzalla.rectify.entitys;

import java.util.Date;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class StockTank {
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

    public void setDtStkTq(Date dtStkTq) {
        this.dtStkTq = dtStkTq;
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
