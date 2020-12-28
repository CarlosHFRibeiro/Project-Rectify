package dev.senzalla.rectify.treatments;

import com.toedter.calendar.JDateChooser;
import dev.senzalla.rectify.entitys.MakeTrans;
import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.frame.FrmTrans;
import dev.senzalla.rectify.frame.FrmTransTbl;
import dev.senzalla.rectify.frame.panel.PnlMatter;
import dev.senzalla.rectify.frame.panel.PnlReactTrans;
import dev.senzalla.rectify.request.MakeTransRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TransTreatment {

    public void checkTransToSave(JPanel pnlTrans, List<PnlMatter> pnlMatter, List<PnlReactTrans> pnlReact, Object tank, String amount, String produced, String trash, FrmTrans frmTrans) {
        boolean matter = checkMatter(pnlMatter);
        boolean react = checkReact(pnlReact);
        if (matter && react && TreatmentTxt.isTxtEmpty(pnlTrans)) {
            saveTrans(tank, amount, produced, trash, pnlReact);
            saveMatter(pnlMatter);
            saveReact(pnlReact);
            Access.goToInternalFrame(frmTrans, new FrmTrans());
        } else {
            EmptyField.showMsg();
        }
    }

    private void saveTrans(Object tank, String amount, String produced, String trash, List<PnlReactTrans> pnlReact) {
        MakeTrans makeTrans = new MakeTrans();
        makeTrans.setAmountTrans(Integer.parseInt(amount));
        makeTrans.setTank((Tank) tank);
        makeTrans.setProducedTrans(Integer.parseInt(produced));
        makeTrans.setTrashTrans(Integer.parseInt(trash));
        makeTrans.setMakeDateTrans(pnlReact.get(0).getDate());
        new MakeTransRequest().insert(makeTrans);
    }

    private void saveReact(List<PnlReactTrans> pnlReact) {
        pnlReact.forEach(PnlReactTrans::saveReact);
    }

    private void saveMatter(List<PnlMatter> pnlMatter) {
        pnlMatter.forEach(PnlMatter::saveMatter);
    }

    private boolean checkMatter(List<PnlMatter> pnlMatter) {
        return pnlMatter.stream().anyMatch(matter
                -> TreatmentTxt.isTxtEmpty(
                matter.getPanel())
                || CbxTreatment.isCbxEmpty(matter.getPanel()
        ));
    }

    private boolean checkReact(List<PnlReactTrans> pnlReact) {
        return pnlReact.stream().anyMatch(pnl -> TreatmentTxt.isTxtEmpty(pnl.getPanel()) && CbxTreatment.isCbxEmpty(pnl.getPanel()) && new TreatmentDtc().isDtcVoid(pnl.getPanel()));
    }

    public static void initTable(JTable tbl) {
        List<MakeTrans> makeTranss = new MakeTransRequest().select(null, null);
        table(tbl, makeTranss);
    }

    public static void initTable(JTable tbl, JSpinner spnCod, JDateChooser dtcDtOf, JDateChooser dtcDtUp, JComboBox<Object> cbxTank) {
        List<String> clause = new ArrayList<>();
        MakeTrans makeTrans = new MakeTrans();
        if (!spnCod.getValue().equals(0)) {
            clause.add("idTrans =");
            makeTrans.setIdTrans(Long.valueOf(spnCod.getValue().toString()));
        }
        if (dtcDtOf.getDate() != null && dtcDtUp.getDate() != null) {
            clause.add("dtTrans between");
            makeTrans.setMakeDateTrans(dtcDtOf.getDate());
            clause.add("");
            makeTrans.setDateBetween(dtcDtUp.getDate());

        } else {
            if (dtcDtOf.getDate() != null) {
                clause.add("dtTrans =");
                makeTrans.setMakeDateTrans(dtcDtOf.getDate());
            }
            if (dtcDtUp.getDate() != null) {
                clause.add("dtTrans =");
                makeTrans.setMakeDateTrans(dtcDtUp.getDate());
            }
        }
        if (cbxTank.getSelectedIndex() > 0) {
            clause.add("nameTank =");
            makeTrans.setTank((Tank) cbxTank.getSelectedItem());
        }
        List<MakeTrans> makeTranss = new MakeTransRequest().select(clause, makeTrans);
        if (!makeTranss.isEmpty()) {
            table(tbl, makeTranss);
        } else {
            PopUp.isEmpty("Transesterificação");
        }
    }

    private static void table(JTable tbl, List<MakeTrans> makeTransList) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        FrmTransTbl.query(makeTransList);
        makeTransList.forEach(make ->
                model.addRow(new Object[]{
                        make.getIdTrans(),
                        TreatmentDate.convertDateUtil(make.getMakeDateTrans()),
                        make.getTank(),
                        make.getProducedTrans(),
                        make.getTrashTrans()
                }));
    }

}
