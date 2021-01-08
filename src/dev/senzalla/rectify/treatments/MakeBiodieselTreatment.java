package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.MakeBiodiesel;
import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.frame.MakeBiodieselTableFrame;
import dev.senzalla.rectify.request.MakeBiodieselRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MakeBiodieselTreatment {

    public static void initTable(JTable tableMakeBiodiesel) {
        fillTable(tableMakeBiodiesel, new MakeBiodieselRequest().select(null, null));
    }

    public static void setTableFilters(JTable tableMakeBiodiesel, Long idMakeBiodiesel, Date dateOf, Date dateUntil, Object tank) {
        List<String> clause = new ArrayList<>();
        MakeBiodiesel makeBiodiesel = new MakeBiodiesel();
        if (idMakeBiodiesel > 0) {
            clause.add("idMakeBiodiesel =");
            makeBiodiesel.setIdMakeBiodiesel(idMakeBiodiesel);
        }
        if (dateOf != null && dateUntil != null) {
            clause.add("dateMakeBiodiesel between");
            makeBiodiesel.setDateMakeBiodiesel(dateOf);
            clause.add("");
            makeBiodiesel.setDateBetween(dateUntil);

        } else {
            if (dateOf != null) {
                clause.add("dateMakeBiodiesel =");
                makeBiodiesel.setDateMakeBiodiesel(dateOf);
            }
            if (dateUntil != null) {
                clause.add("dateMakeBiodiesel =");
                makeBiodiesel.setDateMakeBiodiesel(dateUntil);
            }
        }
        if (tank.equals("Tanque")) {
            clause.add("nameTank =");
            makeBiodiesel.setTank((Tank) tank);
        }
        List<MakeBiodiesel> makeBiodiesels = new MakeBiodieselRequest().select(clause, makeBiodiesel);
        if (!makeBiodiesels.isEmpty()) {
            fillTable(tableMakeBiodiesel, makeBiodiesels);
        } else {
            PopUp.searchNoResults("Transesterificação");
        }
    }

    private static void fillTable(JTable tableMakeBiodiesel, List<MakeBiodiesel> makeBiodiesels) {
        DefaultTableModel tableModel = (DefaultTableModel) tableMakeBiodiesel.getModel();
        tableModel.setNumRows(0);
        MakeBiodieselTableFrame.query(makeBiodiesels);
        makeBiodiesels.forEach(make ->
                tableModel.addRow(new Object[]{
                        make,
                        DateTreatment.convertDateUtil(make.getDateMakeBiodiesel()),
                        make.getTank(),
                        make.getProducedMakeBiodiesel(),
                        make.getTrashMakeBiodiesel()
                }));
    }

//    private void saveReact(List<ReactionBiodieselPanel> pnlReact) {
//        pnlReact.forEach(ReactionBiodieselPanel::saveReact);
//    }

    public void saveMakeBiodiesel(Tank tank, String amount, String produced, String trash, Date dateMakeBiodiesel) {
        MakeBiodiesel makeBiodiesel = new MakeBiodiesel();
        makeBiodiesel.setAmountMatterMakeBiodiesel(Integer.parseInt(amount));
        makeBiodiesel.setTank((Tank) tank);
        makeBiodiesel.setProducedMakeBiodiesel(Integer.parseInt(produced));
        makeBiodiesel.setTrashMakeBiodiesel(Integer.parseInt(trash));
        makeBiodiesel.setDateMakeBiodiesel(dateMakeBiodiesel);
        new MakeBiodieselRequest().insert(makeBiodiesel);
    }
}
