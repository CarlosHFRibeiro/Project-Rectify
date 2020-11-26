package dev.senzalla.rectify.enuns;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public enum Lab {
    LABCAR(1, "Carro"),
    LABBIO(2, "Biodiesel"),
    LABSPLIT(3, "Cisão"),
    LABTANK(4, "Tanque");

    private final int valor;
    private final String descricao;

    Lab(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}