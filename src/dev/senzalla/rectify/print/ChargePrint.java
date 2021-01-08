package dev.senzalla.rectify.print;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import dev.senzalla.rectify.entitys.Charge;
import dev.senzalla.rectify.enuns.FontEnum;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static dev.senzalla.rectify.treatments.DateTreatment.convertDateUtil;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ChargePrint extends ModelPrint {
    public void print(List<Charge> charges) {
        try {
            final String archive = String.format("%s\\Carregamento.pdf", DIR);
            setPdfPTable(archive);

            configuration(1, FontEnum.TITLE, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable("Carregameto");
            document.add(pdfPTable);
            setLogo();

            configuration(1, FontEnum.FIELD, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable(convertDateUtil(charges.get(0).getDateEntry()));
            document.add(pdfPTable);

            configuration(6, FontEnum.SUBTITLE, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
            List<String> header = Arrays.asList("Cod", "Data Entrada", "Ticket", "Fornecedor", "Produto", "Litros");
            header.forEach(this::setTable);
            document.add(pdfPTable);

            configuration(6, FontEnum.SUBTITLE, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
            for (int i = 0; i < charges.size(); i++) {
                Charge charge = charges.get(i);
                configuration(i % 2 == 0 ? BaseColor.GRAY : BaseColor.LIGHT_GRAY);
                setTable(String.valueOf(charge.getId()));
                setTable(convertDateUtil(charge.getDateEntry()));
                setTable(String.valueOf(charge.getTicket()));
                setTable(charge.getProvider().getNameProvider());
                setTable(charge.getProduct().getNameProduct());
                setTable(String.valueOf(charge.getLiter()));
            }
            document.add(pdfPTable);


            document.close();
            Desktop.getDesktop().open(new File(archive));
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }


}
