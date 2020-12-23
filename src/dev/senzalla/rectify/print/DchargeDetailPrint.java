package dev.senzalla.rectify.print;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import dev.senzalla.rectify.entitys.Discharge;
import dev.senzalla.rectify.enuns.FontEnum;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static dev.senzalla.rectify.treatments.TreatmentDate.convertDateUtil;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class DchargeDetailPrint extends ModelPrint {
    public void print(Discharge charge) {
        try {
            final String archive = String.format("%s\\Descarregamento Detalhado_%d.pdf", DIR, charge.getIdDcharge());
            setPdfPTable(archive);

            configuration(1, FontEnum.TITLE, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable("Descarregamento Detalhado");
            document.add(pdfPTable);

            configuration(1, FontEnum.FIELD, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable(convertDateUtil(charge.getDtOfDcharge()));
            setParagraph(" ", FontEnum.FIELD);
            document.add(pdfPTable);

            configuration(4, FontEnum.FIELD, BaseColor.WHITE, Element.ALIGN_BOTTOM);
            setParagraph("Fornecedor: ", FontEnum.BOLDFIELD);
            setParagraph(charge.getProvider().getNameProvider(), FontEnum.FIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("Data Entrada: ", FontEnum.BOLDFIELD);
            setParagraph(convertDateUtil(charge.getDtOfDcharge()), FontEnum.FIELD);
            setParagraph("Hora Entrada: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getHrOfDcharge()), FontEnum.FIELD);
            setParagraph("Nota: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getNoteDcharge()), FontEnum.FIELD);
            setParagraph("Ticket: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getTicketDcharge()), FontEnum.FIELD);
            setParagraph("Placa: ", FontEnum.BOLDFIELD);
            setParagraph(charge.getBoardDcharge(), FontEnum.FIELD);
            setParagraph("CNH: ", FontEnum.BOLDFIELD);
            setParagraph(charge.getDriver().getCnhDriver(), FontEnum.FIELD);
            setParagraph("Motorista: ", FontEnum.BOLDFIELD);
            setParagraph(charge.getDriver().getNameDriver(), FontEnum.FIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("Data Saida: ", FontEnum.BOLDFIELD);
            setParagraph(convertDateUtil(charge.getDtUpDcharge()), FontEnum.FIELD);
            setParagraph("Hora Saida: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getHrUpDcharge()), FontEnum.FIELD);
            setParagraph("Produto: ", FontEnum.BOLDFIELD);
            setParagraph(charge.getProduct().getNameProduct(), FontEnum.FIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("Analise ", FontEnum.BOLDFIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("Acidez: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getanalyzeTruck().getAcidCar()), FontEnum.FIELD);
            setParagraph("Saponidade: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getanalyzeTruck().getSoapCar()), FontEnum.FIELD);
            setParagraph("Densidade: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getanalyzeTruck().getDensityCar()), FontEnum.FIELD);
            setParagraph("Impureza: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getanalyzeTruck().getTrashCar()), FontEnum.FIELD);
            setParagraph("Peso: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getBurdenDcharge()), FontEnum.FIELD);
            setParagraph("Litros: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getLiterDcharge()), FontEnum.FIELD);
            setParagraph("Tanque: ", FontEnum.BOLDFIELD);
            setParagraph(charge.getTank().getNameTank(), FontEnum.FIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("", FontEnum.FIELD);
            document.add(pdfPTable);


            setLogo();
            document.close();
            Desktop.getDesktop().open(new File(archive));
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }


}
