package dev.senzalla.rectify.print;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import dev.senzalla.rectify.entitys.MakeTrans;
import dev.senzalla.rectify.enuns.FontEnum;
import dev.senzalla.rectify.treatments.TreatmentDate;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static dev.senzalla.rectify.treatments.TreatmentDate.convertDateUtil;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MakeTransDetailPrint extends ModelPrint {
    public void print(MakeTrans makeTrans) {
        try {

            final String archive = String.format("%s\\Transesterificacao Detalhada_%d.pdf", DIR, makeTrans.getIdTrans());
            setPdfPTable(archive);

            configuration(1, FontEnum.TITLE, BaseColor.WHITE, Element.ALIGN_CENTER);
            setTable("Transificação");
            document.add(pdfPTable);


            configuration(1, FontEnum.FIELD, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable(convertDateUtil(makeTrans.getDtTrans()));
            document.add(pdfPTable);

            setPdf();
            setPhrase("Tanque: ", makeTrans.getTank().getNameTank());
            setEspace();

            makeTrans.getMatterTrans().forEach(matterTrans -> {
                setPhrase("Produto: ", matterTrans.getProduct().getNameProduct());
                setPhrase("Litros: ", String.valueOf(matterTrans.getLiterMtTrans()));
                setEspace();
            });

            setPhrase("Quantidade de Produto: ", String.valueOf(makeTrans.getAmountTrans()));
            setEspace();
            makeTrans.getReactTranss().forEach(reactTrans -> {
                setPhrase("Data: ", TreatmentDate.convertDateUtil(reactTrans.getDtRctTrans()));
                setPhrase("Hora Inicial: ", String.valueOf(reactTrans.getHrStartRctTrans()));
                setPhrase("Metanol Puro: ", String.valueOf(reactTrans.getPureRctTrans()));
                setEspace();
                setPhrase("Acidez: ", String.valueOf(reactTrans.getLabTank().getAcidTq()));
                setPhrase("Saponidade: ", String.valueOf(reactTrans.getLabTank().getSoapTq()));
                setPhrase("Impureza: ", String.valueOf(reactTrans.getLabTank().getTrashTq()));
                setEspace();
            });

            setPhrase("Produzido: ", String.valueOf(makeTrans.getProducedTrans()));
            setPhrase("Residuo: ", String.valueOf(makeTrans.getTrashTrans()));


            setLogo();
            document.close();
            Desktop.getDesktop().open(new File(archive));
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

}
