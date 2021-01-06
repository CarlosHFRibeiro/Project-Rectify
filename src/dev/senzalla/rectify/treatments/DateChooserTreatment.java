package dev.senzalla.rectify.treatments;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Bomsalvez
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class DateChooserTreatment {
    public static void cleanDateChooser(JPanel pnl) {
        for (Component c : pnl.getComponents()) {
            if (c instanceof JDateChooser) {
                JDateChooser dtc = (JDateChooser) c;
                dtc.setDate(null);
            }
        }
    }


    public static boolean isDateChooserNull(JPanel panel) {
        return dtcChooser(panel).stream().noneMatch(Objects::isNull);
    }

    public static boolean isDateChooserFilterNull(JPanel panel) {
        return dtcChooser(panel).stream().anyMatch(Objects::nonNull);
    }

    private static List<Date> dtcChooser(JPanel panel) {
        List<Date> dtcChooser = new ArrayList<>();
        for (Component c : panel.getComponents()) {
            if (c instanceof JDateChooser) {
                JDateChooser dtc = (JDateChooser) c;
                dtcChooser.add(dtc.getDate());
            }
        }
        return dtcChooser;
    }
}
