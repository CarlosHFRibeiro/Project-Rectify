/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.treatments;

import com.toedter.calendar.JDateChooser;
import dev.senzalla.rectify.entitys.MakeEster;
import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.frame.FrmEster;
import dev.senzalla.rectify.frame.FrmEsterTbl;
import dev.senzalla.rectify.frame.panel.PnlMatter;
import dev.senzalla.rectify.frame.panel.PnlReactEster;
import dev.senzalla.rectify.request.RequestMakeEster;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatmentEster {

    private DefaultTableModel model;

    public void save(JPanel pnlEster, List<PnlMatter> pnlMatter, List<PnlReactEster> pnlReact, JComboBox<Object> cbxTank, JFormattedTextField txtEsterAmount, JFormattedTextField txtEsterProduced, JFormattedTextField txtEsterTrash, FrmEster frmEster) {
        boolean matter = checkMatter(pnlMatter);
        boolean react = checkReact(pnlReact);
        if (matter && react && TreatmentTxt.isTxtEmpty(pnlEster)) {
            MakeEster makeEster = new MakeEster();
            makeEster.setAmountEster(Integer.parseInt(txtEsterAmount.getText()));
            makeEster.setTank((Tank) cbxTank.getSelectedItem());
            makeEster.setProducedEster(Integer.parseInt(txtEsterProduced.getText()));
            makeEster.setTrashEster(Integer.parseInt(txtEsterTrash.getText()));
            makeEster.setDtEster(pnlReact.get(0).getDate());
            new RequestMakeEster().insert(makeEster);
            saveMatter(pnlMatter);
            saveReact(pnlReact);
            Access.goToInternalFrame(frmEster, new FrmEster());
        } else {
            EmptyField.showMsg();
        }
    }

    private void saveReact(List<PnlReactEster> pnlReact) {
        for (PnlReactEster react : pnlReact) {
            react.save();
        }
    }

    private void saveMatter(List<PnlMatter> pnlMatter) {
        for (PnlMatter matter : pnlMatter) {
            matter.saveEster();
        }
    }

    private boolean checkMatter(List<PnlMatter> pnlMatter) {
        return pnlMatter.stream().anyMatch(matter ->
                TreatmentTxt.isTxtEmpty(
                        matter.getPanel())
                        || CbxTreatment.isCbxEmpty(matter.getPanel()
                ));
    }

    private boolean checkReact(List<PnlReactEster> pnlReact) {
        return pnlReact.stream().anyMatch(pnl -> TreatmentTxt.isTxtEmpty(pnl.getPanel()) || CbxTreatment.isCbxEmpty(pnl.getPanel()) || new TreatmentDtc().isDtcVoid(pnl.getPanel()));
    }

    public void initTable(JTable tbl) {
        model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        List<MakeEster> makeEsters = new RequestMakeEster().select();
        FrmEsterTbl.query(makeEsters);
        makeEsters.forEach(makeEster -> model.addRow(new Object[]{
                makeEster.getIdEster(),
                TreatmentDate.convertDateUtil(makeEster.getDtEster()),
                makeEster.getTank(),
                makeEster.getProducedEster(),
                makeEster.getTrashEster()
        }));
    }

    public void initTable(JTable tbl, JSpinner spnCod, JDateChooser dtcDtOf, JDateChooser dtcDtUp, JComboBox<Object> cbxTank) {
        List<String> clause = new ArrayList<>();
        MakeEster makeEster = new MakeEster();
        if (!spnCod.getValue().equals(0)) {
            clause.add("idEster =");
            makeEster.setIdEster(Long.valueOf(spnCod.getValue().toString()));
        }
        if (dtcDtOf.getDate() != null && dtcDtUp.getDate() != null) {
            clause.add("dtEster between");
            makeEster.setDtEster(dtcDtOf.getDate());
            clause.add("");
            makeEster.setDateBetween(dtcDtUp.getDate());

        } else {
            if (dtcDtOf.getDate() != null) {
                clause.add("dtEster =");
                makeEster.setDtEster(dtcDtOf.getDate());
            }
            if (dtcDtUp.getDate() != null) {
                clause.add("dtEster =");
                makeEster.setDtEster(dtcDtUp.getDate());
            }
        }
        if (cbxTank.getSelectedIndex() > 0) {
            clause.add("nameTank =");
            makeEster.setTank((Tank) cbxTank.getSelectedItem());
        }
        List<MakeEster> makeEsters = new RequestMakeEster().select(clause, makeEster);
        if (!makeEsters.isEmpty()) {
            model = (DefaultTableModel) tbl.getModel();
            model.setNumRows(0);
            FrmEsterTbl.query(makeEsters);
            makeEsters.forEach(this::table);
        } else {
            PopUp.isEmpty("Carregamento");
        }
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
