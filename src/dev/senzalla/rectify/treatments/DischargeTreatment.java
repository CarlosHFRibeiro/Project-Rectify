package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.*;
import dev.senzalla.rectify.frame.DeschargeTableFrame;
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


    public static void setTableFilters(JTable tblDischarge, Long id, Date dateOf, Date dateUntil, Integer ticket, Integer note, Object product, Object provider) {
        List<String> clause = new ArrayList<>();
        Discharge dcharge = new Discharge();
        if (id > 0) {
            clause.add("id =");
            dcharge.setId(id);
        }
        if (dateOf != null && dateUntil != null) {
            clause.add("dtOf between");
            dcharge.setDateEntry(dateOf);
            clause.add("");
            dcharge.setDateBetween(dateUntil);

        } else {
            if (dateOf != null) {
                clause.add("dtOf =");
                dcharge.setDateEntry(dateOf);
            }
            if (dateUntil != null) {
                clause.add("dtOf =");
                dcharge.setDateEntry(dateUntil);
            }
        }
        if (ticket > 0) {
            clause.add("ticket =");
            dcharge.setTicket(ticket);
        }
        if (note > 0) {
            clause.add("note =");
            dcharge.setNote(note);
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
            fillTable(tblDischarge, dcharges);
        } else {
            PopUp.searchNoResults("Carregamento");
        }
    }

    private static void fillTable(JTable tblDischarge, List<Discharge> discharges) {
        DeschargeTableFrame.query(discharges);
        DefaultTableModel tableModel = (DefaultTableModel) tblDischarge.getModel();
        tableModel.setNumRows(0);
        discharges.forEach(discharge -> tableModel.addRow(new Object[]{
                discharge.getId(),
                DateTreatment.convertDateUtil(discharge.getDateEntry()),
                discharge.getTicket(),
                discharge.getProvider(),
                discharge.getProduct(),
                discharge.getLiter()
        }));
    }

    public void saveDchage(Provider provider, Date dateEntry, String timeEntry, Integer note, Integer ticket, String CarPlatec, Driver driver, Date dateExit, String timeExit, Product product, AnalyzeTruck analyzeTruck, String burden, String liter, Tank tank) {
        Discharge dcharge = new Discharge();
        dcharge.setProvider(provider);
        dcharge.setDateEntry(dateEntry);
        dcharge.setTimeEntry(Time.valueOf(timeEntry));
        dcharge.setNote(note);
        dcharge.setTicket(ticket);
        dcharge.setCarPlate(CarPlatec);
        dcharge.setDriver(driver);
        dcharge.setDateExit(dateExit);
        dcharge.setTimeExit(Time.valueOf(timeExit));
        dcharge.setProduct(product);
        dcharge.setAnalyzeTruck(analyzeTruck);
        dcharge.setBurden(Integer.parseInt(burden));
        dcharge.setLiter(Integer.parseInt(liter));
        dcharge.setTank(tank);
        new DischargeRequest().insert(dcharge);
    }
}
