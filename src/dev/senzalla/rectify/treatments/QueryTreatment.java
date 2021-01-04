package dev.senzalla.rectify.treatments;

import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class QueryTreatment {
    private static String where;

    public static String createQuery(String tableOrView, List<String> query) {
        if (query != null) {
            query.forEach(s -> where += String.format(" %s ? AND", s));
            return String.format("SELECT * FROM %s WHERE %s", tableOrView, where.substring(0, where.length() - 3));
        }
        return String.format("SELECT * FROM %s", tableOrView);
    }

    public static String curdate(String tableOrView, String nameColummDate) {
        return String.format("SELECT * FROM %s WHERE %s = CURDATE()", tableOrView, nameColummDate);
    }

}
