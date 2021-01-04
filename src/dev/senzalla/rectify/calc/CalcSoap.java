package dev.senzalla.rectify.calc;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class CalcSoap {

    public static String calcSoap(String concentration, String volumeSolution, String sampleWeight) {
        return getSoap(Double.parseDouble(concentration), Double.parseDouble(volumeSolution), Double.parseDouble(sampleWeight));
    }

    public static String getSoap(double concentration, double volumeSolution, double sampleWeight) {
        final double conversionFactor = 304447;
        return String.format("%.3f", ((conversionFactor * volumeSolution * concentration) / sampleWeight));
    }
}
