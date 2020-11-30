package dev.senzalla.rectify.print;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import dev.senzalla.rectify.entitys.Seal;
import dev.senzalla.rectify.enuns.FontEnum;
import dev.senzalla.rectify.request.RequestSeal;
import dev.senzalla.rectify.treatments.TreatmentSeal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
            final File DIR = new File(System.getProperty("user.home") + "/Relatorio Bio Refitica");
            DIR.mkdir();
            Document document = new Document();
            document.setMargins(-35, -40, 30, 5);
            document.setPageSize(PageSize.A4);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(String.format("%s\\Amostra_%s.pdf", DIR, newDate())));
            document.open();

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

            setLogo(pdfWriter);
            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
