package dev.senzalla.rectify.treatments;

import javax.swing.*;

public class PopUp {

    public static void selectField() {
        JOptionPane.showMessageDialog(
                new JFrame(),
                "Selecione uma Solução!",
                "Item não Selecionado",
                JOptionPane.WARNING_MESSAGE
        );
    }

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

    public static String panelDelete(String all) {
        return JOptionPane.showInputDialog(
                new JFrame(),
                String.format("Deseja excluir %sos arquivos? (S/N)", all),
                "Exclusão",
                JOptionPane.QUESTION_MESSAGE
        );
    }

    public static void isEmpty(String item) {
        JOptionPane.showMessageDialog(
                new JFrame(),
                item + " não foi encontrado!",
                "Sem Registro",
                JOptionPane.WARNING_MESSAGE
        );
    }

}
