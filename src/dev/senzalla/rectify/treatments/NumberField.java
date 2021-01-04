package dev.senzalla.rectify.treatments;

import java.awt.event.KeyEvent;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class NumberField {

    public static void txtNumberInt(KeyEvent keyPressed) {
        String caracteres = "0987654321";
        if (!caracteres.contains(keyPressed.getKeyChar() + "")) {
            keyPressed.consume();
        }
    }

    public static void addNumber(String numberTextField, KeyEvent keyPressed) {
        boolean addLetter = true;
        if (numberTextField.contains(".") || numberTextField.contains(",")) {
            addLetter = false;
        }

        if (addLetter) {
            txtNumberDouble(keyPressed);
        } else {
            txtNumberInt(keyPressed);
        }
    }

    private static void txtNumberDouble(KeyEvent keyPressed) {
        String caracteres = "09876543210.,";
        if (!caracteres.contains(keyPressed.getKeyChar() + "")) {
            keyPressed.consume();
        }
    }
}
