/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.canvas.panel.PnlMatter;
import dev.senzalla.rectify.canvas.panel.PnlReactEster;
import dev.senzalla.rectify.entitys.MakeEster;
import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.request.RequestMakeEster;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatmentEster {

    private DefaultTableModel model;

    public void save(JPanel pnlEster, List<PnlMatter> pnlMatter, List<PnlReactEster> pnlReact, JComboBox<Object> cbxTank, JFormattedTextField txtEsterAmount, JFormattedTextField txtEsterProduced, JFormattedTextField txtEsterTrash) {
        boolean matter = checkMatter(pnlMatter);
        boolean react = checkReact(pnlReact);
        if (matter && react && new TreatmentTxt().isTxtVoid(pnlEster)) {
            MakeEster makeEster=new MakeEster();
            makeEster.setAmountEster(Integer.parseInt(txtEsterAmount.getText()));
            makeEster.setTank((Tank) cbxTank.getSelectedItem());
            makeEster.setProducedEster(Integer.parseInt(txtEsterProduced.getText()));
            makeEster.setTrashEster(Integer.parseInt(txtEsterTrash.getText()));
            makeEster.setDtEster(pnlReact.get(0).getDate());
            new RequestMakeEster().insert(makeEster);
            saveMatter(pnlMatter);
            saveReact(pnlReact);
        } else {
            new EmptyField().showMsg();
        }
    }

    private void saveReact(List<PnlReactEster> pnlReact) {
        for (PnlReactEster react:pnlReact){
            react.save();
        }
    }

    private void saveMatter(List<PnlMatter> pnlMatter) {
        for (PnlMatter matter:pnlMatter) {
            matter.save();
        }
    }

    private boolean checkMatter(List<PnlMatter> pnlMatter) {
        return pnlMatter.stream().noneMatch(matter -> new TreatmentTxt().isTxtVoid(matter.getPanel()) || new TreatmentCbx().isCbxVoid(matter.getPanel()));
    }

    private boolean checkReact(List<PnlReactEster> pnlReact) {
        return pnlReact.stream().noneMatch(pnl -> new TreatmentTxt().isTxtVoid(pnl.getPanel()) || new TreatmentCbx().isCbxVoid(pnl.getPanel()) || new TreatmentDtc().isDtcVoid(pnl.getPanel()));
    }

    public void initTable(JTable tbl) {
        model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        new RequestMakeEster().select().forEach(this::table);
    }

    private void table(MakeEster makeEster) {
        model.addRow(new Object[]{
                makeEster.getIdEster(),
                TreatmentDate.convertDateUtil(makeEster.getDtEster()),
                makeEster.getTank(),
                makeEster.getProducedEster(),
                makeEster.getTrashEster()
        });
    }
}
