package dev.senzalla.rectify.print;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import dev.senzalla.rectify.entitys.Charge;
import dev.senzalla.rectify.entitys.StockProduct;
import dev.senzalla.rectify.enuns.FontEnum;
import dev.senzalla.rectify.treatments.TreatmentDate;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static dev.senzalla.rectify.treatments.TreatmentDate.convertDateUtil;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ChargePrint extends ModelPrint {
    public void print(List<Charge> charges) {
        try {
            final File DIR = new File(System.getProperty("user.home") + "/Carregamento");
            final String archive = String.format("%s\\Detalhado.pdf", DIR);
            DIR.mkdir();
            Document document = new Document();
            document.setMargins(-35, -40, 30, 5);
            document.setPageSize(PageSize.A4);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(archive));
            document.open();

            configuration(1, FontEnum.TITLE, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable("Carregameto");
            document.add(pdfPTable);

            configuration(1, FontEnum.FIELD, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable(convertDateUtil(charges.get(0).getDtOfCharge()));
            document.add(pdfPTable);

            configuration(6, FontEnum.SUBTITLE, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
            List<String> header = Arrays.asList("Cod", "Data Entrada", "Ticket", "Fornecedor", "Produto", "Litros");
            header.forEach(this::setTable);
            document.add(pdfPTable);

            configuration(6, FontEnum.SUBTITLE, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
            for (int i = 0; i < charges.size(); i++) {
                Charge charge = charges.get(i);
                configuration(i % 2 == 0 ? BaseColor.GRAY : BaseColor.LIGHT_GRAY);
                setTable(String.valueOf(charge.getIdCharge()));
                setTable(convertDateUtil(charge.getDtOfCharge()));
                setTable(String.valueOf(charge.getTicketCharge()));
                setTable(charge.getProvider().getNameProvider());
                setTable(charge.getProduct().getNameProduct());
                setTable(String.valueOf(charge.getLiterCharge()));
            }
            document.add(pdfPTable);

            setLogo(pdfWriter);
            document.close();
            Desktop.getDesktop().open(new File(archive));
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }


}
