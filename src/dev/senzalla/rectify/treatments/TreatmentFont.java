package dev.senzalla.rectify.treatments;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import dev.senzalla.rectify.enuns.FontEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class TreatmentFont {
    private static final List<Font> fonts;

    static {
        fonts = new ArrayList<>();
        fonts.add(new Font(Font.FontFamily.TIMES_ROMAN, 36, Font.NORMAL, BaseColor.BLACK));
        fonts.add(new Font(Font.FontFamily.HELVETICA, 16, Font.NORMAL, BaseColor.BLACK));
        fonts.add(new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK));
        fonts.add(new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK));
    }

    public static Font getFonts(FontEnum font) {
        return fonts.get(font.getValor());
    }

}
