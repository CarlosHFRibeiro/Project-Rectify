package dev.senzalla.rectify.exception;

import javax.swing.*;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class DataBaseException {

    public static void MsgErrorDataBase(String ex, String element) {
        if (ex.contains("Duplicate")) {
            String titulo = "Elemento Duplicado";
            String msg = String.format(" %s já existe no registro", element);
            showMsg(msg, titulo, JOptionPane.ERROR_MESSAGE);
        } else {
            MsgErrorDataBase(ex);
        }
    }

    public static void MsgErrorDataBase(String ex) {
        String titulo = "Erro no banco";
        String msg = String.format("%s \nSe percistir o sintoma o suporte devera ser consultado", ex);
        showMsg(msg, titulo, JOptionPane.WARNING_MESSAGE);
    }

    private static void showMsg(String msg, String titulo, int MESSAGE) {
        JOptionPane.showMessageDialog(new JFrame(), msg, titulo, MESSAGE);
    }
}
