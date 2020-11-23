package dev.senzalla.rectify.treatments;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class PnlMatterTreatment {
    private static final List<Integer> litters;

    static {
        litters = new ArrayList<>();
    }

    public static int getLitters() {
        return litters.stream().reduce(0, Integer::sum);
    }

    public  void sumLitters(int litters) {
        PnlMatterTreatment.litters.add( litters);
    }

    public void editLitters(int litters, int count) {
        PnlMatterTreatment.litters.set(count, litters);
    }

    public void minusLitters(int count, JFormattedTextField txtMatterLiter, JFormattedTextField txtTransAmount) {
        PnlMatterTreatment.litters.remove(count);
        txtTransAmount.setText(String.valueOf(PnlMatterTreatment.getLitters()));
    }

    public void addLitters(JFormattedTextField txtMatterLiter, JFormattedTextField txtTransAmount, boolean send, int count) {
        if (send) {
            new PnlMatterTreatment().editLitters(Integer.parseInt(txtMatterLiter.getText()), count);
        } else {
            new PnlMatterTreatment().sumLitters(Integer.parseInt(txtMatterLiter.getText()));
        }
        txtTransAmount.setText(String.valueOf(PnlMatterTreatment.getLitters()));
    }
}
