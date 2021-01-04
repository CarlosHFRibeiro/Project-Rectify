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

    public static void initTable(JTable tableCharge) {
        fillTable(tableCharge, new ChargeRequest().select(null, null));
    }

    public static void setTableFilters(JTable tableCharge, Long idCharge, Date dateEntry, Date dateExit, Integer ticket, Integer note, Object product, Object provider) {
        List<String> clause = new ArrayList<>();
        Charge charge = new Charge();
        if (idCharge > 0) {
            clause.add("idCharge =");
            charge.setIdCharge(idCharge);
        }
        if (dateEntry != null && dateExit != null) {
            clause.add("dtOfCharge between");
            charge.setDateEntryCharge(dateEntry);
            clause.add("");
            charge.setDateBetween(dateExit);

        } else {
            if (dateEntry != null) {
                clause.add("dtOfCharge =");
                charge.setDateEntryCharge(dateEntry);
            }
            if (dateExit != null) {
                clause.add("dtOfCharge =");
                charge.setDateEntryCharge(dateExit);
            }
        }
        if (ticket > 0) {
            clause.add("ticketCharge =");
            charge.setTicketCharge(Integer.parseInt(ticket.toString()));
        }
        if (note > 0) {
            clause.add("noteCharge =");
            charge.setNoteCharge(Integer.parseInt(note.toString()));
        }
        if (!provider.equals("Fornecedor")) {
            clause.add("nameProvider =");
            charge.setProvider((Provider) provider);
        }
        if (!product.equals("Produto")) {
            clause.add("nameProduct =");
            charge.setProduct((Product) product);
        }
        List<Charge> charges = new ChargeRequest().select(clause, charge);
        if (!charges.isEmpty()) {
            fillTable(tableCharge, charges);
        } else {
            PopUp.searchNoResults("Carregamento");
        }
    }

    private static void fillTable(JTable tableCharge, List<Charge> charges) {
        FrmChargeTbl.query(charges);
        DefaultTableModel tableModel = (DefaultTableModel) tableCharge.getModel();
        tableModel.setNumRows(0);
        charges.forEach(c
                -> tableModel.addRow(new Object[]{
            c.getIdCharge(),
            DateTreatment.convertDateUtil(c.getDateEntryCharge()),
            c.getTicketCharge(),
            c.getProvider(),
            c.getProduct(),
            c.getLiterCharge()
        })
        );
    }

    public void saveChage(Provider provider, Date dateEntry, String timeEntry, Integer note, Integer ticket, String carPlate, Driver driver, Date dateExit, String timeExit, Product product, AnalyzeTruck analyzeTruck, String burden, String litter, Tank tank) {
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
        charge.setProduct(product);
        charge.setAnalyzeTruck(analyzeTruck);
        charge.setProvider(provider);
        charge.setTank(tank);
        new ChargeRequest().insert(charge);
    }

}
