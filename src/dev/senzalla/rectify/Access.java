/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 * @author Black Burn Cybernetic
 * @e-mail blackburncyber@gmail.com
 * @github github.com/BlackBurnCybernetic
 */
public class Access {

    private static JDesktopPane dktMain;

    static void setDktMain(JDesktopPane dktMain) {
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
