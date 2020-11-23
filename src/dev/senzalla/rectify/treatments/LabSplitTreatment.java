package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.LabSplit;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.request.LabSplitRequest;

import javax.swing.*;

public class LabSplitTreatment {

    public void addComboBox(JComboBox<Object> cbx) {
        cbx.removeAllItems();
        cbx.addItem("Cod. Cisão");
        new LabSplitRequest().select().forEach(cbx::addItem);
    }


    public void saveSplit(JPanel pnlLabSplit, JFormattedTextField txtOil, JFormattedTextField txtSludge, JFormattedTextField txtGlycerin, JFormattedTextField txtTrash) {
        if (new TxtTreatment().isTxtVoid(pnlLabSplit)) {
            int oil = Integer.parseInt(txtOil.getText());
            int sludge = Integer.parseInt(txtSludge.getText());
            int glycerin = Integer.parseInt(txtGlycerin.getText());
            int trash = Integer.parseInt(txtTrash.getText());
            if ((oil + sludge + glycerin + trash) == 99 || (oil + sludge + glycerin + trash) == 100) {
                LabSplit labSplit = new LabSplit();
                labSplit.setOilSplit(oil);
                labSplit.setSludgeSplit(sludge);
                labSplit.setGlycerinSplit(glycerin);
                labSplit.setTrashSplit(trash);
                new LabSplitRequest().insert(labSplit);
            }
        } else {
            new EmptyField().showMsg();
        }
    }
}
