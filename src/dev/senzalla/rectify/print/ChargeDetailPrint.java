package dev.senzalla.rectify.print;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import dev.senzalla.rectify.entitys.Charge;
import dev.senzalla.rectify.enuns.FontEnum;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static dev.senzalla.rectify.treatments.DateTreatment.convertDateUtil;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ChargeDetailPrint extends ModelPrint {
    public void print(Charge charge) {
        try {
            final String archive = String.format("%s\\Carregamento Detalhado_%d.pdf", DIR, charge.getId());
            setPdfPTable(archive);

            configuration(1, FontEnum.TITLE, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable("Carregameto Detalhado");
            document.add(pdfPTable);

            configuration(1, FontEnum.FIELD, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable(convertDateUtil(charge.getDateEntry()));
            setParagraph(" ", FontEnum.FIELD);
            document.add(pdfPTable);

            configuration(4, FontEnum.FIELD, BaseColor.WHITE, Element.ALIGN_BOTTOM);
            setParagraph("Fornecedor: ", FontEnum.BOLDFIELD);
            setParagraph(charge.getProvider().getNameProvider(), FontEnum.FIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("Data Entrada: ", FontEnum.BOLDFIELD);
            setParagraph(convertDateUtil(charge.getDateEntry()), FontEnum.FIELD);
            setParagraph("Hora Entrada: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getTimeEntry()), FontEnum.FIELD);
            setParagraph("Nota: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getNote()), FontEnum.FIELD);
            setParagraph("Ticket: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getTicket()), FontEnum.FIELD);
            setParagraph("Placa: ", FontEnum.BOLDFIELD);
            setParagraph(charge.getCarPlate(), FontEnum.FIELD);
            setParagraph("CNH: ", FontEnum.BOLDFIELD);
            setParagraph(charge.getDriver().getCnhDriver(), FontEnum.FIELD);
            setParagraph("Motorista: ", FontEnum.BOLDFIELD);
            setParagraph(charge.getDriver().getNameDriver(), FontEnum.FIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("Data Saida: ", FontEnum.BOLDFIELD);
            setParagraph(convertDateUtil(charge.getDateExit()), FontEnum.FIELD);
            setParagraph("Hora Saida: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getTimeExit()), FontEnum.FIELD);
            setParagraph("Produto: ", FontEnum.BOLDFIELD);
            setParagraph(charge.getProduct().getNameProduct(), FontEnum.FIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("Analise ", FontEnum.BOLDFIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("", FontEnum.FIELD);
            setParagraph("Acidez: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getAnalyzeTruck().getAcidityTruck()), FontEnum.FIELD);
            setParagraph("Saponidade: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getAnalyzeTruck().getSaponityTruck()), FontEnum.FIELD);
            setParagraph("Densidade: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getAnalyzeTruck().getDensityTruck()), FontEnum.FIELD);
            setParagraph("Impureza: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getAnalyzeTruck().getTrashTruck()), FontEnum.FIELD);
            setParagraph("Peso: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getBurden()), FontEnum.FIELD);
            setParagraph("Litros: ", FontEnum.BOLDFIELD);
            setParagraph(String.valueOf(charge.getLiter()), FontEnum.FIELD);
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
