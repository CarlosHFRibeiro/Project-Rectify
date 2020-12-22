package dev.senzalla.rectify.print;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import dev.senzalla.rectify.entitys.Seal;
import dev.senzalla.rectify.enuns.FontEnum;
import dev.senzalla.rectify.request.RequestSeal;
import dev.senzalla.rectify.treatments.TreatmentSeal;

import java.util.Arrays;
import java.util.List;

import static dev.senzalla.rectify.treatments.TreatmentDate.newDate;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class SealPrint extends ModelPrint {

    public void print(List<String> clause, Seal sealSale) {
        try {
            List<Seal> seals;
            if (sealSale != null) {
                seals = new TreatmentSeal().selectQuery(clause, sealSale);
            } else {
                seals = new RequestSeal().select();
            }
            final String archive = String.format("%s\\Amostra_%s.pdf", DIR, newDate());
            setPdfPTable(archive);

            configuration(1, FontEnum.TITLE, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable("Coletas de Biodiesel");
            document.add(pdfPTable);

            configuration(6, FontEnum.SUBTITLE, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
            List<String> header = Arrays.asList("Leilão", "Empresa", "Fabrica", "Petrobras", "Cliente", "Data");
            header.forEach(this::setTable);
            document.add(pdfPTable);

            configuration(6, FontEnum.FIELD, Element.ALIGN_RIGHT);

            for (int j = 0; j < seals.size(); j++) {
                Seal seal = seals.get(j);
                configuration(j % 2 == 0 ? BaseColor.GRAY : BaseColor.LIGHT_GRAY);
                setTable(String.valueOf(seal.getSaleSeal()));
                setTable(String.valueOf(seal.getClientSeal()));
                setTable(String.valueOf(seal.getFactorySeal()));
                setTable(String.valueOf(seal.getBrSeal()));
                setTable(String.valueOf(seal.getProvider()));
                setTable(String.valueOf(seal.getDtSeal()));
            }
            document.add(pdfPTable);

            setLogo();
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
