package dev.senzalla.rectify.treatments;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class DateTretment {
    private Date dateBetween;

    public Date getDateBetween() {
        return dateBetween;
    }

    public void setDateBetween(Date dateBetween) {
        this.dateBetween = dateBetween;
    }

    protected Date convertDateSql(java.util.Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return Date.valueOf(sdf.format(date));
    }

    public static java.util.Date convertDateUtil(Date date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat();
            return sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
