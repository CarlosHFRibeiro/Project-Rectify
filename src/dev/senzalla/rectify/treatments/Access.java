package dev.senzalla.rectify.treatments;

import javax.swing.*;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class Access {

    private static JInternalFrame frame;
    private static JDesktopPane dktMain;

    public static void setDktMain(JDesktopPane dktMain) {
        Access.dktMain = dktMain;
    }

    public static void goToInternalFrame(JInternalFrame oldInternalFrame, JInternalFrame newInternalFrame) {
        frame = newInternalFrame;
        oldInternalFrame.dispose();
        goToInternalFrame(newInternalFrame);
    }

    public static void goToInternalFrame(JInternalFrame newInternalFrame) {
        dktMain.add(newInternalFrame).setVisible(true);
    }

    public static void goToFrame(JFrame newFrame) {
        newFrame.setVisible(true);
    }

    public static void checkFrame(JInternalFrame newFrame) {
        if (frame == null) {
            Access.goToInternalFrame(newFrame);
        } else {
            Access.goToInternalFrame(frame, newFrame);
        }
        frame = newFrame;
    }
}
