package dev.senzalla.rectify.calc;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class CalcAcid {
    double acid;

    public CalcAcid(double cbxAcid, double txtBulk, double txtMass) {
        acid = ((txtBulk) * 28.2 * cbxAcid) / txtMass;
    }

    public String getAcid() {
        return String.format("%.3f", acid);
    }

    public String getIndice() {
        return String.format("%.3f", acid * 1.9);
    }
}
