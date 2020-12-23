package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.calc.CalcAcidity;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.frame.panel.PnlCalcKoh;
import dev.senzalla.rectify.frame.panel.PnlCalcOleic;

import javax.swing.*;
import java.awt.*;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class CalcAcidityTreatment {

    /**
     * @param pnlCalc {@link JPanel}
     * @param pnlCalcAcidity {@link JPanel}
     * @param btgCalcAcid {@link ButtonGroup}
     * @param cbxConcentration {@link JComboBox}
     * @param txtBulk {@link JTextField}
     * @param sampleWeight {@link JTextField}
     * @param txtLabAcidity {@link JTextField}
     * @param rbtnBio {@link JRadioButton}
     */
    public void calcAcidity(JPanel pnlCalc, JPanel pnlCalcAcidity, ButtonModel btgCalcAcid, Object concentration, String volumeSolution, String sampleWeight, JTextField txtLabAcidity, JRadioButton rbtnBio) {
        if (TreatmentTxt.isTxtEmpty(pnlCalcAcidity) && btgCalcAcid != null) {

            CalcAcidity calcAcid = new CalcAcidity(
                    Double.parseDouble(String.valueOf(concentration)),
                    Double.parseDouble(volumeSolution.replace(",", ".")),
                    Double.parseDouble(sampleWeight.replace(",", "."))
            );

            if (pnlCalc.getComponents().length > 0) {
                pnlCalc.removeAll();
            }

            pnlCalc.setLayout(new GridLayout());

            if (rbtnBio.isSelected()) {
                pnlCalc.add(new PnlCalcOleic(calcAcid.getAcidity())).setVisible(true);

            } else {
                pnlCalc.add(new PnlCalcKoh(calcAcid.getIndice())).setVisible(true);
            }

            if (txtLabAcidity != null) {
                txtLabAcidity.setText(calcAcid.getAcidity() != null ? calcAcid.getAcidity() : calcAcid.getIndice());
            }

        } else {
            EmptyField.showMsg();
        }
    }
}
