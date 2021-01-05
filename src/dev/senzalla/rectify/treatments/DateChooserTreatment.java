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

    public static boolean isDateChooserNull(JPanel pnl) {

        List<Date> dtcChooser = new ArrayList<>();
        for (Component c : pnl.getComponents()) {
            if (c instanceof JDateChooser) {
                JDateChooser dtc = (JDateChooser) c;
                dtcChooser.add(dtc.getDate());
            }
        }

        return dtcChooser.stream().noneMatch(Objects::isNull);
    }
}
