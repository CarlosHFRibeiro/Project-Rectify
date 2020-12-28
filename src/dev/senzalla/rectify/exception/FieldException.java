package dev.senzalla.rectify.exception;

import javax.swing.*;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class FieldException  {
    
    public static void fieldException() {
        JOptionPane.showMessageDialog(
                new JFrame(),
                "Não é um número valido!",
                "Campos com Erro",
                JOptionPane.WARNING_MESSAGE
        );
    }
}
