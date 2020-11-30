package dev.senzalla.rectify.print;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import dev.senzalla.rectify.entitys.StockProduct;
import dev.senzalla.rectify.enuns.FontEnum;
import dev.senzalla.rectify.treatments.TreatmentDate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class StockProductPrint extends ModelPrint {

    public void print(List<StockProduct> stockProducts) {
        try {
            final File DIR = new File(System.getProperty("user.home") + "/Relatorio Estoque Produto");
            DIR.mkdir();
            Document document = new Document();
            document.setMargins(-35, -40, 30, 5);
            document.setPageSize(PageSize.A4);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(String.format("%s\\StockProduct.pdf", DIR)));
            document.open();

            configuration(1, FontEnum.TITLE, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable("Estoque do Produto");
            document.add(pdfPTable);

            configuration(1, FontEnum.FIELD, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable(TreatmentDate.convertDateUtil(stockProducts.get(0).getDtStkPd()));
            document.add(pdfPTable);

            configuration(3, FontEnum.SUBTITLE, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
            List<String> header = Arrays.asList("Produto", "Litros", "Porcento");
            header.forEach(this::setTable);
            document.add(pdfPTable);

            configuration(3, FontEnum.FIELD, Element.ALIGN_RIGHT);
            for (int i = 0; i < stockProducts.size(); i++) {
                StockProduct stock = stockProducts.get(i);
                configuration(i % 2 == 0 ? BaseColor.GRAY : BaseColor.LIGHT_GRAY);
                setTable(String.valueOf(stock.getProduct()));
                setTable(String.valueOf(stock.getLiterStkPd()));
                setTable(String.valueOf(stock.getPercentStkPd()));
            }
            document.add(pdfPTable);

            setLogo(pdfWriter);
            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
