package dev.senzalla.rectify.treatments;

import com.toedter.calendar.JDateChooser;
import dev.senzalla.rectify.entitys.*;
import dev.senzalla.rectify.frame.FrmChargeTbl;
import dev.senzalla.rectify.request.ChargeRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ChargeTreatment {


    public void initTableWithClause(JTable tbl, JSpinner spnCod, JDateChooser dtcDtOf, JDateChooser dtcDtUp, JSpinner spnTicket, JSpinner spnNote, JComboBox<Object> cbxProduct, JComboBox<Object> cbxProvider) {
        List<String> clause = new ArrayList<>();
        Charge charge = new Charge();
        if (!spnCod.getValue().equals(0)) {
            clause.add("idCharge =");
            charge.setIdCharge(Long.valueOf(spnCod.getValue().toString()));
        }
        if (dtcDtOf.getDate() != null && dtcDtUp.getDate() != null) {
            clause.add("dtOfCharge between");
            charge.setDateEntryCharge(dtcDtOf.getDate());
            clause.add("");
            charge.setDateBetween(dtcDtUp.getDate());

        } else {
            if (dtcDtOf.getDate() != null) {
                clause.add("dtOfCharge =");
                charge.setDateEntryCharge(dtcDtOf.getDate());
            }
            if (dtcDtUp.getDate() != null) {
                clause.add("dtOfCharge =");
                charge.setDateEntryCharge(dtcDtUp.getDate());
            }
        }
        if (!spnTicket.getValue().equals(0)) {
            clause.add("ticketCharge =");
            charge.setTicketCharge(Integer.parseInt(spnTicket.getValue().toString()));
        }
        if (!spnNote.getValue().equals(0)) {
            clause.add("noteCharge =");
            charge.setNoteCharge(Integer.parseInt(spnNote.getValue().toString()));
        }
        if (cbxProvider.getSelectedIndex() > 0) {
            clause.add("nameProvider =");
            charge.setProvider((Provider) cbxProvider.getSelectedItem());
        }
        if (cbxProduct.getSelectedIndex() > 0) {
            clause.add("nameProduct =");
            charge.setProduct((Product) cbxProduct.getSelectedItem());
        }
        List<Charge> charges = new ChargeRequest().select(clause, charge);
        if (!charges.isEmpty()) {
            initTable(tbl, clause, charge);
        } else {
            PopUp.isEmpty("Carregamento");
        }
    }

    public void initTable(JTable tbl, List<String> clause, Charge charge) {
        List<Charge> charges = new ChargeRequest().select(clause, charge);
        FrmChargeTbl.query(charges);
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        charges.forEach(c ->
                model.addRow(new Object[]{
                        c.getIdCharge(),
                        TreatmentDate.convertDateUtil(c.getDateEntryCharge()),
                        c.getTicketCharge(),
                        c.getProvider(),
                        c.getProduct(),
                        c.getLiterCharge()
                })
        );
    }

    public void clear(JPanel pnlCharge) {
        TreatmentTxt.cleanTxt(pnlCharge);
        CbxTreatment.cleanCbx(pnlCharge);
        new TreatmentDtc().cleanDtc(pnlCharge);
        new TreatmentSpn().cleanSpn(pnlCharge);
    }

    public void saveChage(JPanel pnlCharge, Object provider, Date dateEntry, String timeEntry, Object note, Object ticket, String carPlate, Driver driver, Date dateExit, String timeExit, Object product, Object analyzeTruck, String burden, String litter, Object tank) {
        Charge charge = new Charge();
        charge.setDateEntryCharge(dateEntry);
        charge.setTimeEntryCharge(Time.valueOf(timeEntry));
        charge.setNoteCharge(Integer.parseInt(note.toString()));
        charge.setTicketCharge(Integer.parseInt(ticket.toString()));
        charge.setCarPlateCharge(carPlate);
        charge.setDriver(driver);
        charge.setDateExitCharge(dateExit);
        charge.setTimeExitCharge(Time.valueOf(timeExit));
        charge.setBurdenCharge(Integer.parseInt(burden));
        charge.setLiterCharge(Integer.parseInt(litter));
        charge.setProduct((Product) product);
        charge.setanalyzeTruck((AnalyzeTruck) analyzeTruck);
        charge.setProvider((Provider) provider);
        charge.setTank((Tank) tank);
        new ChargeRequest().insert(charge);
        clear(pnlCharge);

    }

    public int calcLitter(Object selectedItem, int keyChar) {
        AnalyzeTruck analyzeTruck = (AnalyzeTruck) selectedItem;
        return (int) (keyChar / analyzeTruck.getDensityCar());
    }

}
