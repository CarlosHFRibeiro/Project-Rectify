package dev.senzalla.rectify.entitys;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class MatterEster {
    private Long idMtEster;
    private int literMtEster;
    private Product product;
    private MakeEster makeEster;

    public Long getIdMtEster() {
        return idMtEster;
    }

    public void setIdMtEster(Long idMtEster) {
        this.idMtEster = idMtEster;
    }

    public int getLiterMtEster() {
        return literMtEster;
    }

    public void setLiterMtEster(int literMtEster) {
        this.literMtEster = literMtEster;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public MakeEster getMakeEster() {
        return makeEster;
    }

    public void setMakeEster(MakeEster makeEster) {
        this.makeEster = makeEster;
    }
}
