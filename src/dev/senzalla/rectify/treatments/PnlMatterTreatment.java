package dev.senzalla.rectify.treatments;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class PnlMatterTreatment {

    private static List<Integer> litters;

    public static void initEster() {
        litters = new ArrayList<>();
    }

    public static int getLitters() {
        return litters.stream().reduce(0, Integer::sum);
    }

    public void sumLitters(int litters) {
        PnlMatterTreatment.litters.add(litters);
    }

    public void editLitters(int litters, int count) {
        PnlMatterTreatment.litters.set(count, litters);
    }

    public void minusLitters(int count) {
        if (count < litters.size()) {
            PnlMatterTreatment.litters.remove(count);
        }
    }
}
