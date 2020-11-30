package dev.senzalla.rectify.enuns;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public enum FontEnum {
    TITLE(0, "Titulo"),
    SUBTITLE(1, "Subtitulo"),
    FIELD(2, "Corpo"),
    BOLDFIELD(3, "Corpo Negrito");

    private final int valor;
    private final String descricao;

    FontEnum(int valor, String descricao) {
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
