/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.exception;

import javax.swing.*;

/**
 * @author Bomsalvez
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class DataBaseException {

    public void processMsg(String ex, String element) {
        if (ex.contains("Duplicate")) {
            String titulo = "Elemento Duplicado";
            String msg = String.format(" %s já existe no registro", element);
            showMsg(msg, titulo, JOptionPane.ERROR_MESSAGE);
        } else {
            processMsg(ex);
        }
    }

    public void processMsg(String ex) {
        String titulo = "Erro no banco";
        String msg = String.format("%s \nSe percistir o sintoma o suporte devera ser consultado", ex);
        showMsg(msg, titulo, JOptionPane.WARNING_MESSAGE);
    }

    private void showMsg(String msg, String titulo, int MESSAGE) {
        JOptionPane.showMessageDialog(new JFrame(), msg, titulo, MESSAGE);
    }
}
