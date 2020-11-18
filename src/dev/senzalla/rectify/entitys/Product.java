package dev.senzalla.rectify.entitys;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class Product {
    private Long idProduct;
    private double densityProduct;
    private String nameProduct;

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public double getDensityProduct() {
        return densityProduct;
    }

    public void setDensityProduct(double densityProduct) {
        this.densityProduct = densityProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
}
