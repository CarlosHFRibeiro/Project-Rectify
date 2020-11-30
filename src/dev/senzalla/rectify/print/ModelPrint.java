package dev.senzalla.rectify.print;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dev.senzalla.rectify.enuns.FontEnum;

import java.io.IOException;
import java.net.URL;

import static dev.senzalla.rectify.treatments.TreatmentFont.getFonts;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ModelPrint {
    protected PdfPTable pdfPTable;
    protected Paragraph preface;
    private FontEnum fontEnum;
    private BaseColor color;
    private int align;

    protected void configuration(int collumn, FontEnum fontEnum, BaseColor color, int align) {
        pdfPTable = new PdfPTable(collumn);
        this.fontEnum = fontEnum;
        this.color = color;
        this.align = align;
    }

    protected void configuration(int collumn, FontEnum fontEnum, int align) {
        pdfPTable = new PdfPTable(collumn);
        this.fontEnum = fontEnum;
        this.align = align;
    }

    protected void configuration(BaseColor color) {
        this.color = color;
    }

    protected void setTable(String text) {
        Chunk chunk = new Chunk(text, getFonts(fontEnum));
        Paragraph preface = new Paragraph(chunk);
        PdfPCell cell = new PdfPCell(preface);
        cell.setBackgroundColor(color);
        cell.setHorizontalAlignment(align);
        pdfPTable.addCell(cell);
    }

    protected void setParagraph(String key, FontEnum fontKey) {
        PdfPCell cell = new PdfPCell();
        cell.addElement(new Phrase(key, getFonts(fontKey)));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(align);
        pdfPTable.addCell(cell);
    }

    protected void setvacuo() {
        preface.add("\n\n");
    }

    protected void setLogo(PdfWriter pdfWriter) {
        try {
            String MODELO_CERTIFICADO = "/static/img/baseline_eco_black_24x.png";
            URL certificado = getClass().getResource(MODELO_CERTIFICADO);
            Image image = Image.getInstance(certificado);
            image.setAbsolutePosition(90, 767);
            pdfWriter.getDirectContent().addImage(image, false);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

    }
}
