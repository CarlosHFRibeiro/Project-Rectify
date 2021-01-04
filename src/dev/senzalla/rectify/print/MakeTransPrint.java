package dev.senzalla.rectify.print;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import dev.senzalla.rectify.entitys.MakeBiodiesel;
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
public class MakeTransPrint extends ModelPrint {
    public void print(List<MakeBiodiesel> esters) {
        try {

            final String archive = String.format("%s\\Transesterificacao.pdf", DIR);
            setPdfPTable(archive);

            configuration(1, FontEnum.TITLE, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable("Transesterificação");
            document.add(pdfPTable);
            setLogo();

            configuration(1, FontEnum.FIELD, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable(convertDateUtil(esters.get(0).getDateMakeBiodiesel()));
            document.add(pdfPTable);

            configuration(5, FontEnum.SUBTITLE, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
            List<String> header = Arrays.asList("Cod", "Data", "Tanque", "Produzido", "Residuos");
            header.forEach(this::setTable);
            document.add(pdfPTable);

            configuration(5, FontEnum.SUBTITLE, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
            for (int i = 0; i < esters.size(); i++) {
                MakeBiodiesel charge = esters.get(i);
                configuration(i % 2 == 0 ? BaseColor.GRAY : BaseColor.LIGHT_GRAY);
                setTable(String.valueOf(charge.getIdMakeBiodiesel()));
                setTable(convertDateUtil(charge.getDateMakeBiodiesel()));
                setTable(String.valueOf(charge.getTank().getNameTank()));
                setTable(String.valueOf(charge.getProducedMakeBiodiesel()));
                setTable(String.valueOf(charge.getTrashMakeBiodiesel()));
            }
            document.add(pdfPTable);


            document.close();
            Desktop.getDesktop().open(new File(archive));
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }


}
