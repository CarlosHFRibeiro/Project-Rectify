package dev.senzalla.rectify.exception;

import javax.swing.*;

public class FieldException  {
    public FieldException() {
        JOptionPane.showMessageDialog(
                new JFrame(),
                "Não é um número valido!",
                "Campos com Erro",
                JOptionPane.WARNING_MESSAGE
        );
    }
}
