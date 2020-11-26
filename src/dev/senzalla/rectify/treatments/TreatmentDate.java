package dev.senzalla.rectify.treatments;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatmentDate {

    private Date dateBetween;
    
    public Date getDateBetween() {
        return dateBetween;
    }
    
    public void setDateBetween(java.util.Date dateBetween) {
        this.dateBetween = convertDateSql(dateBetween);
    }
    
    protected Date convertDateSql(java.util.Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return Date.valueOf(sdf.format(date));
        }
        return null;
    }
    
    public static String convertDateUtil(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    public static String newDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(new java.util.Date());
    }
}
