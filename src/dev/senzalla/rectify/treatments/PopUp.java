package dev.senzalla.rectify.treatments;

import javax.swing.*;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class PopUp {

    public static void selectField() {
        JOptionPane.showMessageDialog(
                new JFrame(),
                "Selecione uma Solução!",
                "Item não Selecionado",
                JOptionPane.WARNING_MESSAGE
        );
    }

    /**
     * @param solution {@link String}
     * @return String
     */
    public static String panelInsert(String solution) {
        try {
            return JOptionPane.showInputDialog(
                    new JFrame(),
                    String.format("Insira o valor da solução de %s!", solution),
                    String.format("Solução %s", solution),
                    JOptionPane.QUESTION_MESSAGE
            ).replace(",", ".");
        } catch (NullPointerException ex) {
            cancelOperation();
        }
        return null;
    }

    public static void cancelOperation() {
        JOptionPane.showMessageDialog(
                new JFrame(),
                "Operação Cancelada!",
                "Cancelamento",
                JOptionPane.CANCEL_OPTION
        );
    }

    /**
     * @param allSolution {@link String}
     * @return String
     */
    public static String panelDelete(String allSolution) {
        return JOptionPane.showInputDialog(
                new JFrame(),
                String.format("Deseja excluir %sos arquivos? (S/N)", allSolution),
                "Exclusão",
                JOptionPane.QUESTION_MESSAGE
        );
    }

    /**
     * @param item {@link String}
     */
    public static void isEmpty(String item) {
        JOptionPane.showMessageDialog(
                new JFrame(),
                item + " não foi encontrado!",
                "Sem Registro",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public static void isEmpty() {
        JOptionPane.showMessageDialog(
                new JFrame(),
                "Não foi registrado estoque do tanque ainda",
                "Sem Registro",
                JOptionPane.WARNING_MESSAGE
        );
    }
}
