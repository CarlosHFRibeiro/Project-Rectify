package dev.senzalla.rectify.print;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import dev.senzalla.rectify.entitys.Sample;
import dev.senzalla.rectify.enuns.FontEnum;

import java.util.Arrays;
import java.util.List;

import static dev.senzalla.rectify.treatments.DateTreatment.newDate;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class SealPrint extends ModelPrint {

    public void print(List<Sample> samples) {
        try {
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

            for (int j = 0; j < samples.size(); j++) {
                Sample sample = samples.get(j);
                configuration(j % 2 == 0 ? BaseColor.GRAY : BaseColor.LIGHT_GRAY);
                setTable(String.valueOf(sample.getAuctionNumber()));
                setTable(String.valueOf(sample.getClientSample()));
                setTable(String.valueOf(sample.getFactorySample()));
                setTable(String.valueOf(sample.getPetrobrasSample()));
                setTable(String.valueOf(sample.getProvider()));
                setTable(String.valueOf(sample.getDateSampleCollection()));
            }
            document.add(pdfPTable);

            setLogo();
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
