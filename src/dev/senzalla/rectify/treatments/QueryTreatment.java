package dev.senzalla.rectify.treatments;

import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class QueryTreatment {

    public static String createQuery(String tableOrView, List<String> query) {
        final String[] where = {""};
        if (query != null) {
            query.forEach(s -> where[0] += String.format(" %s ? AND", s));
            return String.format("SELECT * FROM %s WHERE %s", tableOrView, where[0].substring(0, where[0].length() - 3));
        }
        return String.format("SELECT * FROM %s", tableOrView);
    }

    public static String curdate(String tableOrView, String nameColummDate) {
        return String.format("SELECT * FROM %s WHERE %s = CURDATE()", tableOrView, nameColummDate);
    }

}
