package dev.senzalla.rectify.exception;

import javax.swing.*;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class EmptyField {

    public void showMsg() {
        JOptionPane.showMessageDialog(
                new JFrame(),
                "Preencha todos os campos!",
                "Campos Em Branco",
                JOptionPane.WARNING_MESSAGE
        );
    }
}
