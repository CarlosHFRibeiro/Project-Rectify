package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.calc.CalcSoap;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.frame.panel.PnlCalcSoap;

import javax.swing.*;
import java.awt.*;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class CalcSoapTreatment {

    /**
     *
     * @param pnlCalc
     * @param pnlCalcSoap
     * @param cbxConcentration
     * @param txtBulk
     * @param txtMass
     * @param txtLabSoap
     */
    public void calcSoap(JPanel pnlCalc, JPanel pnlCalcSoap, JComboBox<Object> cbxConcentration, JTextField txtBulk, JTextField txtMass, JTextField txtLabSoap) {
        if (TreatmentTxt.isTxtEmpty(pnlCalcSoap)) {
            String soap = new CalcSoap().getSoap(
                    Double.parseDouble(String.valueOf(cbxConcentration.getSelectedItem())),
                    Double.parseDouble(txtBulk.getText()),
                    Double.parseDouble(txtMass.getText())
            );

            if (pnlCalc.getComponents().length > 0) {
                pnlCalc.removeAll();
            }

            pnlCalc.setLayout(new GridLayout());
            pnlCalc.add(new PnlCalcSoap(soap)).setVisible(true);

            if (txtLabSoap != null) {
                txtLabSoap.setText(soap);
            }

        } else {
            EmptyField.showMsg();
        }
    }
}
