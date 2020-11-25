package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.calc.CalcSoap;
import dev.senzalla.rectify.canvas.panel.PnlCalcOleic;
import dev.senzalla.rectify.exception.EmptyField;

import javax.swing.*;
import java.awt.*;

public class CalcSoapTreatment {
    public void calcSoap(JPanel pnlCalc, JPanel pnlCalcSoap, JComboBox<Object> cbxConcentration, JTextField txtBulk, JTextField txtMass, JTextField txtLabCarSoap) {
        if (new TxtTreatment().isTxtVoid(pnlCalcSoap)) {
           String soap = new CalcSoap().getSoap(
                    Double.parseDouble(cbxConcentration.getSelectedItem().toString()),
                    Double.parseDouble(txtBulk.getText()),
                    Double.parseDouble(txtMass.getText())
            );
            if (pnlCalc.getComponents().length > 0) {
                pnlCalc.removeAll();
            }
            GridLayout layout = new GridLayout();
            pnlCalc.setLayout(layout);
            pnlCalc.add(new PnlCalcOleic(soap)).setVisible(true);
            txtLabCarSoap.setText(soap);
        } else {
            new EmptyField().showMsg();
        }
    }
}
