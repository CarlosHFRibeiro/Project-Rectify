package dev.senzalla.rectify.print;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dev.senzalla.rectify.enuns.FontEnum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import static dev.senzalla.rectify.treatments.FontTreatment.getFonts;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ModelPrint {
    private FontEnum fontEnum;
    private BaseColor color;
    private int align;
    private PdfWriter pdfWriter;

    protected PdfPTable pdfPTable;
    protected Document document;
    protected final File DIR;

    public ModelPrint() {
        DIR = new File(System.getProperty("user.home") + "/Documents/Retifica");
    }

    protected void setPdfPTable(String archive) {
        try {

            DIR.mkdir();
            document = new Document();
            document.setMargins(-35, -40, 30, 5);
            document.setPageSize(PageSize.A4);
            pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(archive));
            document.open();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void setPdf() {
        document.setMargins(35, 15, 90, 5);
        document.open();
    }

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
        Paragraph preface = new Paragraph(text, getFonts(fontEnum));
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

    protected void setPhrase(String key, String value) {
        try {
            Paragraph paragraph = new Paragraph();
            paragraph.add(new Phrase(key, getFonts(FontEnum.BOLDFIELD)));
            paragraph.add(new Phrase(value, getFonts(FontEnum.FIELD)));
            document.add(paragraph);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    protected void setEspace() {
        try {
            Paragraph paragraph = new Paragraph();
            paragraph.add(new Phrase("\n"));
            document.add(paragraph);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    protected void setLogo() {
        try {
            URL ICON_LOGO = getClass().getResource("/static/img/eco_24x.png");
            Image image = Image.getInstance(ICON_LOGO);
            image.setAbsolutePosition(90, 767);
            pdfWriter.getDirectContent().addImage(image, false);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

    }
}
