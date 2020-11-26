package dev.senzalla.rectify.enuns;

/**
 * @author Bomsalvez
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public enum Collect {
    BOCA(1, "Boca"),
    SONDA(2, "Sonda"),
    DRENO(3, "Dreno"),
    BOMBA(4, "Bomba");

    private final int valor;
    private final String descricao;

    Collect(int valor, String descricao) {
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
