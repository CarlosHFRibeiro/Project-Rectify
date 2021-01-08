package dev.senzalla.rectify.print;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import dev.senzalla.rectify.entitys.StockTank;
import dev.senzalla.rectify.enuns.FontEnum;
import dev.senzalla.rectify.treatments.DateTreatment;

import java.util.Arrays;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class StockTankPrint extends ModelPrint {

    public void print(List<StockTank> stockTanks) {
        try {

            final String archive = String.format("%s\\StockTank.pdf", DIR);
            setPdfPTable(archive);

            configuration(1, FontEnum.TITLE, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable("Estoque do Tanque");
            document.add(pdfPTable);
            setLogo();

            configuration(1, FontEnum.FIELD, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable(DateTreatment.convertDateUtil(stockTanks.get(0).getDateStockTank()));
            document.add(pdfPTable);

            configuration(3, FontEnum.SUBTITLE, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
            List<String> header = Arrays.asList("Tanque", "Produto", "Litros");
            header.forEach(this::setTable);
            document.add(pdfPTable);

            configuration(3, FontEnum.FIELD, Element.ALIGN_RIGHT);
            for (int i = 0; i < stockTanks.size(); i++) {
                StockTank stock = stockTanks.get(i);
                configuration(i % 2 == 0 ? BaseColor.GRAY : BaseColor.LIGHT_GRAY);
                setTable(String.valueOf(stock.getTank()));
                setTable(String.valueOf(stock.getProduct()));
                setTable(String.valueOf(stock.getLiterProduct()));
            }
            document.add(pdfPTable);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
