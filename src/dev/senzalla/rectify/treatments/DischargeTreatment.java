package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.*;
import dev.senzalla.rectify.frame.FrmDchargeTbl;
import dev.senzalla.rectify.request.DischargeRequest;

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
public class DischargeTreatment {


    public static void initTable(JTable tblDischarge) {
        fillTable(tblDischarge, new DischargeRequest().select(null, null));
    }


    public static void setTableFilters(JTable tblDischarge, Long idDcharge, Date dateOf, Date dateUntil, Integer ticket, Integer note, Object product, Object provider) {
        List<String> clause = new ArrayList<>();
        Discharge dcharge = new Discharge();
        if (idDcharge > 0) {
            clause.add("idDcharge =");
            dcharge.setIdDcharge(idDcharge);
        }
        if (dateOf != null && dateUntil != null) {
            clause.add("dtOfDcharge between");
            dcharge.setDateEntryDcharge(dateOf);
            clause.add("");
            dcharge.setDateBetween(dateUntil);

        } else {
            if (dateOf != null) {
                clause.add("dtOfDcharge =");
                dcharge.setDateEntryDcharge(dateOf);
            }
            if (dateUntil != null) {
                clause.add("dtOfDcharge =");
                dcharge.setDateEntryDcharge(dateUntil);
            }
        }
        if (ticket > 0) {
            clause.add("ticketDcharge =");
            dcharge.setTicketDcharge(ticket);
        }
        if (note > 0) {
            clause.add("noteDcharge =");
            dcharge.setNoteDcharge(note);
        }
        if (!provider.equals("Fornecedor")) {
            clause.add("nameProvider =");
            dcharge.setProvider((Provider) provider);
        }
        if (!product.equals("Produto")) {
            clause.add("nameProduct =");
            dcharge.setProduct((Product) product);
        }
        List<Discharge> dcharges = new DischargeRequest().select(clause, dcharge);
        if (!dcharges.isEmpty()) {
            FrmDchargeTbl.query(dcharges);
            fillTable(tblDischarge, dcharges);
        } else {
            PopUp.searchNoResults("Carregamento");
        }
    }

    private static void fillTable(JTable tblDischarge, List<Discharge> discharges) {
        FrmDchargeTbl.query(discharges);
        DefaultTableModel tableModel = (DefaultTableModel) tblDischarge.getModel();
        tableModel.setNumRows(0);
        discharges.forEach(discharge -> tableModel.addRow(new Object[]{
                discharge.getIdDcharge(),
                DateTreatment.convertDateUtil(discharge.getDateEntryDcharge()),
                discharge.getTicketDcharge(),
                discharge.getProvider(),
                discharge.getProduct(),
                discharge.getLiterDcharge()
        }));
    }

    public void saveDchage(Provider provider, Date dateEntry, String timeEntry, Integer note, Integer ticket, String CarPlatec, Driver driver, Date dateExit, String timeExit, Product product, AnalyzeTruck analyzeTruck, String burden, String liter, Tank tank) {
        Discharge dcharge = new Discharge();
        dcharge.setProvider(provider);
        dcharge.setDateEntryDcharge(dateEntry);
        dcharge.setTimeEntryDcharge(Time.valueOf(timeEntry));
        dcharge.setNoteDcharge(note);
        dcharge.setTicketDcharge(ticket);
        dcharge.setCarPlateDcharge(CarPlatec);
        dcharge.setDriver(driver);
        dcharge.setDateExitDcharge(dateExit);
        dcharge.setTimeExitDcharge(Time.valueOf(timeExit));
        dcharge.setProduct(product);
        dcharge.setAnalyzeTruck(analyzeTruck);
        dcharge.setBurdenDcharge(Integer.parseInt(burden));
        dcharge.setLiterDcharge(Integer.parseInt(liter));
        dcharge.setTank(tank);
        new DischargeRequest().insert(dcharge);
    }
}
