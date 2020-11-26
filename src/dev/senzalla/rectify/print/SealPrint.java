package dev.senzalla.rectify.print;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dev.senzalla.rectify.entitys.Seal;
import dev.senzalla.rectify.enuns.FontEnum;
import dev.senzalla.rectify.request.RequestSeal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static dev.senzalla.rectify.treatments.TreatmentDate.newDate;
import static dev.senzalla.rectify.treatments.TreatmentFont.getFonts;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class SealPrint {
    private PdfPTable pdfPTable;

    public void print(List<Integer> list) {
        try {

            final File DIR = new File(System.getProperty("user.home") + "/Relatorio Bio Refitica");
            DIR.mkdir();
            Document document = new Document();
            document.setMargins(5, 10, 30, 5);
            document.setPageSize(PageSize.A4);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(String.format("%s\\Amostra_%s.pdf", DIR, newDate())));
            document.open();

            pdfPTable = new PdfPTable(1);
            setTable("Coletas de Biodiesel", FontEnum.TITLE, BaseColor.WHITE, Element.ALIGN_RIGHT);
            document.add(pdfPTable);

            pdfPTable = new PdfPTable(6);
            List<String> header = Arrays.asList("Leilão", "Empresa", "Fabrica", "Petrobras", "Cliente", "Data");
            header.forEach(s -> setTable(s, FontEnum.SUBTITLE, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER));
            document.add(pdfPTable);

            pdfPTable = new PdfPTable(6);
            List<Seal> select = new RequestSeal().select(list);
            for (int j = 0, selectSize = select.size(); j < selectSize; j++) {
                Seal seal = select.get(j);
                if (j % 2 == 0) {
                    setTable(String.valueOf(seal.getSaleSeal()), FontEnum.FIELD, BaseColor.GRAY, Element.ALIGN_RIGHT);
                    setTable(String.valueOf(seal.getClientSeal()), FontEnum.FIELD, BaseColor.GRAY, Element.ALIGN_RIGHT);
                    setTable(String.valueOf(seal.getFactorySeal()), FontEnum.FIELD, BaseColor.GRAY, Element.ALIGN_RIGHT);
                    setTable(String.valueOf(seal.getBrSeal()), FontEnum.FIELD, BaseColor.GRAY, Element.ALIGN_RIGHT);
                    setTable(String.valueOf(seal.getProvider()), FontEnum.FIELD, BaseColor.GRAY, Element.ALIGN_RIGHT);
                    setTable(String.valueOf(seal.getDtSeal()), FontEnum.FIELD, BaseColor.GRAY, Element.ALIGN_RIGHT);
                } else {
                    setTable(String.valueOf(seal.getSaleSeal()), FontEnum.FIELD, BaseColor.LIGHT_GRAY, Element.ALIGN_RIGHT);
                    setTable(String.valueOf(seal.getClientSeal()), FontEnum.FIELD, BaseColor.LIGHT_GRAY, Element.ALIGN_RIGHT);
                    setTable(String.valueOf(seal.getFactorySeal()), FontEnum.FIELD, BaseColor.LIGHT_GRAY, Element.ALIGN_RIGHT);
                    setTable(String.valueOf(seal.getBrSeal()), FontEnum.FIELD, BaseColor.LIGHT_GRAY, Element.ALIGN_RIGHT);
                    setTable(String.valueOf(seal.getProvider()), FontEnum.FIELD, BaseColor.LIGHT_GRAY, Element.ALIGN_RIGHT);
                    setTable(String.valueOf(seal.getDtSeal()), FontEnum.FIELD, BaseColor.LIGHT_GRAY, Element.ALIGN_RIGHT);
                }
            }
            document.add(pdfPTable);

            String MODELO_CERTIFICADO = "/static/img/baseline_eco_black_24x.png";
            URL certificado = getClass().getResource(MODELO_CERTIFICADO);
            Image image = Image.getInstance(certificado);
            image.setAbsolutePosition(90, 767);
            pdfWriter.getDirectContent().addImage(image, false);
            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    private void setTable(String text, FontEnum fontEnum, BaseColor color, int align) {
        Chunk chunk = new Chunk(text, getFonts(fontEnum));
        Paragraph preface = new Paragraph(chunk);
        PdfPCell cell = new PdfPCell(preface);
        cell.setBackgroundColor(color);
        cell.setHorizontalAlignment(align);
        pdfPTable.addCell(cell);
    }
}
