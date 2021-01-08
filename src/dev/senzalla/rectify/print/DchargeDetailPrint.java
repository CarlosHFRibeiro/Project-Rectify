package dev.senzalla.rectify.print;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import dev.senzalla.rectify.entitys.Discharge;
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
public class DchargeDetailPrint extends ModelPrint {
    public void print(Discharge charge) {
        try {
            final String archive = String.format("%s\\Descarregamento Detalhado_%d.pdf", DIR, charge.getId());
            setPdfPTable(archive);

            configuration(1, FontEnum.TITLE, BaseColor.WHITE, Element.ALIGN_CENTER);
            setTable("Descarregamento Detalhado");
            document.add(pdfPTable);
            setLogo();

            configuration(1, FontEnum.FIELD, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable(convertDateUtil(charge.getDateEntry()));
            document.add(pdfPTable);

            setPdf();
            configuration(4, FontEnum.FIELD, BaseColor.WHITE, Element.ALIGN_BOTTOM);
            setPhrase("Fornecedor: ", charge.getProvider().getNameProvider());
            setPhrase("Data Entrada: ", convertDateUtil(charge.getDateEntry()));
            setPhrase("Hora Entrada: ", String.valueOf(charge.getTimeEntry()));
            setPhrase("Nota: ", String.valueOf(charge.getNote()));
            setPhrase("Ticket: ", String.valueOf(charge.getTicket()));
            setPhrase("Placa: ", charge.getCarPlate());
            setPhrase("CNH: ", charge.getDriver().getCnhDriver());
            setPhrase("Motorista: ", charge.getDriver().getNameDriver());
            setPhrase("Data Saida: ", convertDateUtil(charge.getDateExit()));
            setPhrase("Hora Saida: ", String.valueOf(charge.getTimeExit()));
            setPhrase("Produto: ", charge.getProduct().getNameProduct());
            setEspace();
            setPhrase("Analise ", "");
            setPhrase("Acidez: ", String.valueOf(charge.getAnalyzeTruck().getAcidityTruck()));
            setPhrase("Saponidade: ", String.valueOf(charge.getAnalyzeTruck().getSaponityTruck()));
            setPhrase("Densidade: ", String.valueOf(charge.getAnalyzeTruck().getDensityTruck()));
            setPhrase("Impureza: ", String.valueOf(charge.getAnalyzeTruck().getTrashTruck()));
            setPhrase("Peso: ", String.valueOf(charge.getBurden()));
            setPhrase("Litros: ", String.valueOf(charge.getLiter()));
            setPhrase("Tanque: ", charge.getTank().getNameTank());
            document.add(pdfPTable);
            document.close();
            Desktop.getDesktop().open(new File(archive));
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }


}
