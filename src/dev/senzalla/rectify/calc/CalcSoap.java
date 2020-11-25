package dev.senzalla.rectify.calc;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class CalcSoap {

    public String getSoap(double cbxHcl, double txtBulk, double txtMass) {
        return String.format("%.3f", ((304447 * txtBulk * cbxHcl) / txtMass));
    }
}
