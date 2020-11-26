/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.treatments;

import javax.swing.*;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class Access {

    private static JDesktopPane dktMain;

    public static void setDktMain(JDesktopPane dktMain) {
        Access.dktMain = dktMain;
    }

    public static void goToCanvas(JInternalFrame oldFrm, JInternalFrame newFrm) {
        oldFrm.dispose();
        goToCanvas(newFrm);
    }

    public static void goToCanvas(JInternalFrame newFrm) {
        dktMain.add(newFrm).setVisible(true);
    }

    public static void goToFilter(JFrame newFrm) {
        newFrm.setVisible(true);
    }

}
