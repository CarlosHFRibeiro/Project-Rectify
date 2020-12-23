/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.treatments;

import com.toedter.calendar.JDateChooser;
import dev.senzalla.rectify.entitys.MakeTrans;
import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.frame.FrmTrans;
import dev.senzalla.rectify.frame.FrmTransTbl;
import dev.senzalla.rectify.frame.panel.PnlMatter;
import dev.senzalla.rectify.frame.panel.PnlReactTrans;
import dev.senzalla.rectify.request.RequestMakeTrans;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatmentTrans {

    private DefaultTableModel model;

    public void save(JPanel pnlTrans, List<PnlMatter> pnlMatter, List<PnlReactTrans> pnlReact, JComboBox<Object> cbxTank, JFormattedTextField txtTransAmount, JFormattedTextField txtTransProduced, JFormattedTextField txtTransTrash, FrmTrans frmTrans) {
        boolean matter = checkMatter(pnlMatter);
        boolean react = checkReact(pnlReact);
        if (matter && react &&  TreatmentTxt.isTxtEmpty(pnlTrans)) {
            MakeTrans makeTrans = new MakeTrans();
            makeTrans.setAmountTrans(Integer.parseInt(txtTransAmount.getText()));
            makeTrans.setTank((Tank) cbxTank.getSelectedItem());
            makeTrans.setProducedTrans(Integer.parseInt(txtTransProduced.getText()));
            makeTrans.setTrashTrans(Integer.parseInt(txtTransTrash.getText()));
            makeTrans.setDtTrans(pnlReact.get(0).getDate());
            new RequestMakeTrans().insert(makeTrans);
            saveMatter(pnlMatter);
            saveReact(pnlReact);
            Access.goToInternalFrame(frmTrans, new FrmTrans());
        } else {
            EmptyField.showMsg();
        }
    }

    private void saveReact(List<PnlReactTrans> pnlReact) {
        pnlReact.forEach(PnlReactTrans::save);
    }

    private void saveMatter(List<PnlMatter> pnlMatter) {
        pnlMatter.forEach(PnlMatter::saveTrans);
    }

    private boolean checkMatter(List<PnlMatter> pnlMatter) {
        return pnlMatter.stream().anyMatch(matter ->
                TreatmentTxt.isTxtEmpty(
                        matter.getPanel())
                        || CbxTreatment.isCbxEmpty(matter.getPanel()
                ));
    }

    private boolean checkReact(List<PnlReactTrans> pnlReact) {
        return pnlReact.stream().anyMatch(pnl -> TreatmentTxt.isTxtEmpty(pnl.getPanel()) && CbxTreatment.isCbxEmpty(pnl.getPanel()) && new TreatmentDtc().isDtcVoid(pnl.getPanel()));
    }

    public void initTable(JTable tbl) {
        model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        List<MakeTrans> makeTranss = new RequestMakeTrans().select();
        FrmTransTbl.query(makeTranss);
        makeTranss.forEach(this::table);
    }

    public void initTable(JTable tbl, JSpinner spnCod, JDateChooser dtcDtOf, JDateChooser dtcDtUp, JComboBox<Object> cbxTank) {
        List<String> clause = new ArrayList<>();
        MakeTrans makeTrans = new MakeTrans();
        if (!spnCod.getValue().equals(0)) {
            clause.add("idTrans =");
            makeTrans.setIdTrans(Long.valueOf(spnCod.getValue().toString()));
        }
        if (dtcDtOf.getDate() != null && dtcDtUp.getDate() != null) {
            clause.add("dtTrans between");
            makeTrans.setDtTrans(dtcDtOf.getDate());
            clause.add("");
            makeTrans.setDateBetween(dtcDtUp.getDate());

        } else {
            if (dtcDtOf.getDate() != null) {
                clause.add("dtTrans =");
                makeTrans.setDtTrans(dtcDtOf.getDate());
            }
            if (dtcDtUp.getDate() != null) {
                clause.add("dtTrans =");
                makeTrans.setDtTrans(dtcDtUp.getDate());
            }
        }
        if (cbxTank.getSelectedIndex() > 0) {
            clause.add("nameTank =");
            makeTrans.setTank((Tank) cbxTank.getSelectedItem());
        }
        List<MakeTrans> makeTranss = new RequestMakeTrans().select(clause, makeTrans);
        if (!makeTranss.isEmpty()) {
            model = (DefaultTableModel) tbl.getModel();
            model.setNumRows(0);
            FrmTransTbl.query(makeTranss);
            makeTranss.forEach(this::table);
        } else {
            PopUp.isEmpty("Transesterificação");
        }
    }

    private void table(MakeTrans makeTrans) {
        model.addRow(new Object[]{
                makeTrans.getIdTrans(),
                TreatmentDate.convertDateUtil(makeTrans.getDtTrans()),
                makeTrans.getTank(),
                makeTrans.getProducedTrans(),
                makeTrans.getTrashTrans()
        });
    }


}
