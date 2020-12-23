package dev.senzalla.rectify.calc;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class CalcAcidity {
    private final double acidity;

    public CalcAcidity(double concentration, double volumeSolution , double sampleWeight) {
        final double conversionFactor = 28.2;
        acidity = (concentration * conversionFactor * volumeSolution) / sampleWeight;
    }

    public String getAcidity() {
        return String.format("%.3f", acidity);
    }

    public String getIndice() {
        return String.format("%.3f", acidity * 1.9);
    }
}
