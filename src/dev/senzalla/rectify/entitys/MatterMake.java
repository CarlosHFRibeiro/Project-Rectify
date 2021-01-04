package dev.senzalla.rectify.entitys;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MatterMake {
    private Long idMatterMake;
    private int literMatterMake;
    private MakeEster makeEster;
    private MakeBiodiesel makeBiodiesel;
    private Product product;

    public Long getIdMatterMake() {
        return idMatterMake;
    }

    public void setIdMatterMake(Long idMatterMake) {
        this.idMatterMake = idMatterMake;
    }

    public int getLiterMatterMake() {
        return literMatterMake;
    }

    public void setLiterMatterMake(int literMatterMake) {
        this.literMatterMake = literMatterMake;
    }

    public MakeEster getMakeEster() {
        return makeEster;
    }

    public void setMakeEster(MakeEster makeEster) {
        this.makeEster = makeEster;
    }

    public MakeBiodiesel getMakeBiodiesel() {
        return makeBiodiesel;
    }

    public void setMakeBiodiesel(MakeBiodiesel makeBiodiesel) {
        this.makeBiodiesel = makeBiodiesel;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
