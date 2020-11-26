package dev.senzalla.rectify.treatments;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatmentPnlMatter {
    private static final List<Integer> litters;

    static {
        litters = new ArrayList<>();
    }

    public static int getLitters() {
        return litters.stream().reduce(0, Integer::sum);
    }

    public void sumLitters(int litters) {
        TreatmentPnlMatter.litters.add(litters);
    }

    public void editLitters(int litters, int count) {
        TreatmentPnlMatter.litters.set(count, litters);
    }

    public void minusLitters(int count) {
        TreatmentPnlMatter.litters.remove(count);
    }
}
