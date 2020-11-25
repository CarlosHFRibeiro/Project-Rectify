package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.calc.CalcAcid;
import dev.senzalla.rectify.canvas.panel.PnlCalcKoh;
import dev.senzalla.rectify.canvas.panel.PnlCalcOleic;
import dev.senzalla.rectify.exception.EmptyField;

import javax.swing.*;
import java.awt.*;

public class CalcAcidTreatment {
    public void calcAcid(JPanel pnlCalc, JPanel pnlCalcAcid, ButtonGroup btgCalcAcid, JComboBox<Object> cbxConcentration, JTextField txtBulk, JTextField txtMass, JTextField txtLabCarAcid, JRadioButton rbtnBio) {
        if (new TxtTreatment().isTxtVoid(pnlCalcAcid) && btgCalcAcid.getSelection() != null) {

            CalcAcid calcAcid = new CalcAcid(
                    Double.parseDouble(String.valueOf(cbxConcentration.getSelectedItem())),
                    Double.parseDouble(txtBulk.getText().replace(",", ".")),
                    Double.parseDouble(txtMass.getText().replace(",", "."))
            );

            if (pnlCalc.getComponents().length > 0) {
                pnlCalc.removeAll();
            }

            GridLayout layout = new GridLayout();
            pnlCalc.setLayout(layout);
            pnlCalc.add(
                    rbtnBio.isSelected() ? new PnlCalcOleic(calcAcid.getAcid()) : new PnlCalcKoh(calcAcid.getIndice())
            ).setVisible(true);
            if (txtLabCarAcid != null) {
                txtLabCarAcid.setText(rbtnBio.isSelected() ? calcAcid.getAcid() : calcAcid.getIndice());
            }
        } else {
            new EmptyField().showMsg();
        }
    }
}
