package dev.senzalla.rectify.print;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import dev.senzalla.rectify.entitys.StockProduct;
import dev.senzalla.rectify.enuns.FontEnum;
import dev.senzalla.rectify.treatments.DateTreatment;

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
            final String archive = String.format("%s\\StockProduct.pdf", DIR);
            setPdfPTable(archive);

            configuration(1, FontEnum.TITLE, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable("Estoque do Produto");
            document.add(pdfPTable);

            configuration(1, FontEnum.FIELD, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable(DateTreatment.convertDateUtil(stockProducts.get(0).getDateStockProduct()));
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
                setTable(String.valueOf(stock.getLiterProduct()));
                setTable(String.valueOf(stock.getPercentProduct()));
            }
            document.add(pdfPTable);

            setLogo();
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
