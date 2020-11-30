package dev.senzalla.rectify.print;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import dev.senzalla.rectify.entitys.StockTank;
import dev.senzalla.rectify.enuns.FontEnum;
import dev.senzalla.rectify.request.RequestStockTank;
import dev.senzalla.rectify.treatments.TreatmentDate;
import dev.senzalla.rectify.treatments.TreatmentStockTank;

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
public class StockTankPrint extends ModelPrint {

    public void print(List<String> clause, StockTank stockTank) {
        try {
            List<StockTank> stockTanks;
            if (stockTank != null) {
                stockTanks = new TreatmentStockTank().selectQuery(clause, stockTank);
            } else {
                stockTanks = new RequestStockTank().select();
            }

            final File DIR = new File(System.getProperty("user.home") + "/Relatorio Estoque Tanque");
            DIR.mkdir();
            Document document = new Document();
            document.setMargins(-35, -40, 30, 5);
            document.setPageSize(PageSize.A4);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(String.format("%s\\StockTank.pdf", DIR)));
            document.open();

            configuration(1, FontEnum.TITLE, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable("Estoque do Tanque");
            document.add(pdfPTable);

            configuration(1, FontEnum.FIELD, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable(TreatmentDate.convertDateUtil(stockTanks.get(0).getDtStkTq()));
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
                setTable(String.valueOf(stock.getLiterStkTq()));
            }
            document.add(pdfPTable);

            setLogo(pdfWriter);
            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
