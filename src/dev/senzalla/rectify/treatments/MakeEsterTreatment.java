package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.MakeEster;
import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.frame.MakeEsterTableFrame;
import dev.senzalla.rectify.request.MakeEsterRequest;

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
public class MakeEsterTreatment {

    public static void initTable(JTable tableMakeEster) {
        fillTable(tableMakeEster, new MakeEsterRequest().select(null, null));
    }

    public static void setTableFilters(JTable tableMakeEster, Long idMakeEster, Date dateOf, Date dateUntil, Object tank) {
        List<String> clause = new ArrayList<>();
        MakeEster makeEster = new MakeEster();
        if (idMakeEster > 0) {
            clause.add("idEster =");
            makeEster.setIdMakeEster(idMakeEster);
        }
        if (dateOf != null && dateUntil != null) {
            clause.add("dtEster between");
            makeEster.setDateMakeEster(dateOf);
            clause.add("");
            makeEster.setDateBetween(dateUntil);

        } else {
            if (dateOf != null) {
                clause.add("dtEster =");
                makeEster.setDateMakeEster(dateOf);
            }
            if (dateUntil != null) {
                clause.add("dtEster =");
                makeEster.setDateMakeEster(dateUntil);
            }
        }
        if (!tank.equals("Tanque")) {
            clause.add("nameTank =");
            makeEster.setTank((Tank) tank);
        }
        List<MakeEster> makeEsters = new MakeEsterRequest().select(clause, makeEster);
        if (!makeEsters.isEmpty()) {
            fillTable(tableMakeEster, makeEsters);
        } else {
            PopUp.searchNoResults("Carregamento");
        }
    }


    private static void fillTable(JTable tableMakeEster, List<MakeEster> makeEsters) {
        MakeEsterTableFrame.query(makeEsters);
        DefaultTableModel tableModel = (DefaultTableModel) tableMakeEster.getModel();
        tableModel.setNumRows(0);
        makeEsters.forEach(makeEster ->
                tableModel.addRow(new Object[]{
                        makeEster,
                        DateTreatment.convertDateUtil(makeEster.getDateMakeEster()),
                        makeEster.getTank(),
                        makeEster.getProducedMakeEster(),
                        makeEster.getTrashMakeEster()
                }));
    }

    public void saveMakeEster(Tank tank, String amount, String produced, String trash, Date dateMakeEster) {
        MakeEster makeEster = new MakeEster();
        makeEster.setAmountMatterMakeEster(Integer.parseInt(amount));
        makeEster.setTank(tank);
        makeEster.setProducedMakeEster(Integer.parseInt(produced));
        makeEster.setTrashMakeEster(Integer.parseInt(trash));
        makeEster.setDateMakeEster(dateMakeEster);
        new MakeEsterRequest().insert(makeEster);
    }
}
