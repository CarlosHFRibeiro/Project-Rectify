package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.Collect;
import dev.senzalla.rectify.entitys.LabCar;
import dev.senzalla.rectify.entitys.LabCarSplit;
import dev.senzalla.rectify.entitys.LabSplit;

import javax.swing.*;
import java.util.Arrays;

public class LabCarTreatment {
    public void CollectComboBox(JComboBox<Object> cbx) {
        cbx.removeAllItems();
        cbx.addItem("Coleta");
        Arrays.stream(Collect.values()).map(Collect::getDescricao).forEach(cbx::addItem);
    }

    public void saveLabCar(JPanel pnlLabCar, JTextField txtLabCarAcid, JTextField txtLabCarSoap, JTextField txtLabCarDens, JFormattedTextField txtLabCarTrash, JComboBox<Object> cbxLabCarCollect, JComboBox<Object> cbxLabCarSplit) {
        if(new TxtTreatment().isTxtVoid(pnlLabCar)&&cbxLabCarCollect.getSelectedIndex()>0){
            LabCar labCar=new LabCar();
            labCar.setAcidCar(Double.parseDouble(txtLabCarAcid.getText()));
            labCar.setSoapCar(Double.parseDouble(txtLabCarSoap.getText()));
            labCar.setDensityCar(Double.parseDouble(txtLabCarDens.getText()));
            labCar.setTrashCar(Integer.parseInt(txtLabCarTrash.getText()));
            labCar.setCollect(cbxLabCarCollect.getSelectedIndex());
            if(cbxLabCarSplit.getSelectedIndex()>0){
                LabSplit labSplit=new LabSplit();
                labSplit.setIdSplit(Long.valueOf(cbxLabCarSplit.getSelectedIndex()));
                LabCarSplit  labCarSplit=new LabCarSplit();
                labCarSplit.setLabSplit();
            }
        }
    }
}
