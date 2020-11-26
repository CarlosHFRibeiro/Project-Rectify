package dev.senzalla.rectify.entitys;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MatterTrans {
    private Long idMtTrans;
    private int literMtTrans;
    private Product product;
    private MakeTrans makeTrans;

    public Long getIdMtTrans() {
        return idMtTrans;
    }

    public void setIdMtTrans(Long idMtTrans) {
        this.idMtTrans = idMtTrans;
    }

    public int getLiterMtTrans() {
        return literMtTrans;
    }

    public void setLiterMtTrans(int literMtTrans) {
        this.literMtTrans = literMtTrans;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public MakeTrans getMakeTrans() {
        return makeTrans;
    }

    public void setMakeTrans(MakeTrans makeTrans) {
        this.makeTrans = makeTrans;
    }
}
