package dev.senzalla.rectify.print;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import dev.senzalla.rectify.entitys.MakeEster;
import dev.senzalla.rectify.enuns.FontEnum;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static dev.senzalla.rectify.treatments.DateTreatment.convertDateUtil;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MakeEsterPrint extends ModelPrint {
    public void print(List<MakeEster> esters) {
        try {

            final String archive = String.format("%s\\Esterificacao.pdf", DIR);
            setPdfPTable(archive);

            configuration(1, FontEnum.TITLE, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable("Esterificação");
            document.add(pdfPTable);

            configuration(1, FontEnum.FIELD, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable(convertDateUtil(esters.get(0).getDateMakeEster()));
            document.add(pdfPTable);

            configuration(5, FontEnum.SUBTITLE, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
            List<String> header = Arrays.asList("Cod", "Data", "Tanque", "Produzido", "Residuos");
            header.forEach(this::setTable);
            document.add(pdfPTable);

            configuration(5, FontEnum.SUBTITLE, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
            for (int i = 0; i < esters.size(); i++) {
                MakeEster charge = esters.get(i);
                configuration(i % 2 == 0 ? BaseColor.GRAY : BaseColor.LIGHT_GRAY);
                setTable(String.valueOf(charge.getIdMakeEster()));
                setTable(convertDateUtil(charge.getDateMakeEster()));
                setTable(String.valueOf(charge.getTank().getNameTank()));
                setTable(String.valueOf(charge.getProducedMakeEster()));
                setTable(String.valueOf(charge.getTrashMakeEster()));
            }
            document.add(pdfPTable);

            setLogo();
            document.close();
            Desktop.getDesktop().open(new File(archive));
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }


}
