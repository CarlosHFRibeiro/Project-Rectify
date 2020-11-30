package dev.senzalla.rectify.print;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import dev.senzalla.rectify.entitys.Discharge;
import dev.senzalla.rectify.enuns.FontEnum;

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
public class DchargePrint extends ModelPrint {
    public void print(List<Discharge> dcharges) {
        try {
            final File DIR = new File(System.getProperty("user.home") + "/Descarregamento");
            final String archive = String.format("%s\\Detalhado.pdf", DIR);
            DIR.mkdir();
            Document document = new Document();
            document.setMargins(-35, -40, 30, 5);
            document.setPageSize(PageSize.A4);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(archive));
            document.open();

            configuration(1, FontEnum.TITLE, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable("Descarregamento");
            setTable(convertDateUtil(dcharges.get(0).getDtOfDcharge()));
            document.add(pdfPTable);

            configuration(6, FontEnum.SUBTITLE, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
            List<String> header = Arrays.asList("Cod", "Data Entrada", "Ticket", "Fornecedor", "Produto", "Litros");
            header.forEach(this::setTable);
            document.add(pdfPTable);

            configuration(6, FontEnum.SUBTITLE, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
            for (int i = 0; i < dcharges.size(); i++) {
                Discharge dcharge = dcharges.get(i);
                configuration(i % 2 == 0 ? BaseColor.GRAY : BaseColor.LIGHT_GRAY);
                setTable(String.valueOf(dcharge.getIdDcharge()));
                setTable(convertDateUtil(dcharge.getDtOfDcharge()));
                setTable(String.valueOf(dcharge.getTicketDcharge()));
                setTable(dcharge.getProvider().getNameProvider());
                setTable(dcharge.getProduct().getNameProduct());
                setTable(String.valueOf(dcharge.getLiterDcharge()));
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
