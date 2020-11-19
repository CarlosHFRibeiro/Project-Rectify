/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.treatments;

//import dev.senzalla.rectify.request.NaohRequest;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 * @author Bomsalvez
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class NaohTreatment {

    public void showSolutionNaoh(JList<String> lstSolNaoh) {
        Set<String> naohs = new HashSet<>();
        DefaultListModel model = new DefaultListModel();
        lstSolNaoh.setModel(model);

//        new NaohRequest().select().forEach(naoh -> naohs.add(naoh.toString()));
        naohs.forEach(naoh -> model.addElement(naoh));
    }

    public String panelInsert() {
        return JOptionPane.showInputDialog(
                new JFrame(),
                "Insira o valor da solução de Naoh!",
                "Solução Naoh",
                JOptionPane.QUESTION_MESSAGE
        ).replace(",", ".");
    }
}
