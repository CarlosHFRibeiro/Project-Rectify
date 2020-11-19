/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.exception;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Bomsalvez
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ElementDuplicate {

    public void processMsg(String ex, String element) {
        if (ex.contains("Duplicate")) {
            String titulo = "Elemento Duplicado";
            String msg = String.format(" %s já existe no registro", element);
            showMsg(msg, titulo, JOptionPane.ERROR_MESSAGE);
        } else {
            String titulo = "Erro no banco";
            String msg = "Se percistir o sintoma o suporte devera ser consultado";
            showMsg(msg, titulo, JOptionPane.WARNING_MESSAGE);
        }
    }

    private void showMsg(String msg, String titulo, int MESSAGE) {
        JOptionPane.showMessageDialog(new JFrame(), msg, titulo, MESSAGE);
    }
}
