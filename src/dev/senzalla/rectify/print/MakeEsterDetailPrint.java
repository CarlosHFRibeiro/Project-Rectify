package dev.senzalla.rectify.print;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import dev.senzalla.rectify.entitys.MakeEster;
import dev.senzalla.rectify.enuns.FontEnum;
import dev.senzalla.rectify.treatments.TreatmentDate;

import static dev.senzalla.rectify.treatments.TreatmentDate.convertDateUtil;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MakeEsterDetailPrint extends ModelPrint {
    public void print(MakeEster esters) {
        try {

            final String archive = String.format("%s\\Esterificacao Detalhada_%d.pdf", DIR, esters.getIdEster());
            setPdfPTable(archive);

            configuration(1, FontEnum.TITLE, BaseColor.WHITE, Element.ALIGN_CENTER);
            setTable("Esterificação");
            document.add(pdfPTable);


            configuration(1, FontEnum.FIELD, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable(convertDateUtil(esters.getDtEster()));
            document.add(pdfPTable);

            setPdf();
            setPhrase("Tanque: ", esters.getTank().getNameTank());
            setEspace();

            esters.getMatterEster().forEach(matterEster -> {
                setPhrase("Produto: ", matterEster.getProduct().getNameProduct());
                setPhrase("Litros: ", String.valueOf(matterEster.getLiterMtEster()));
                setEspace();
            });

            setPhrase("Quantidade de Produto: ", String.valueOf(esters.getAmountEster()));
            setEspace();
            esters.getReactEsters().forEach(reactEster -> {
                setPhrase("Data: ", TreatmentDate.convertDateUtil(reactEster.getDtRctEster()));
                setPhrase("Hora Inicial: ", String.valueOf(reactEster.getHrStartRctEster()));
                setPhrase("Metanol Puro: ", String.valueOf(reactEster.getPureRctEster()));
                setPhrase("Metanol Recuperado: ", String.valueOf(reactEster.getRecoverRctEster()));
                setEspace();
                setPhrase("Acidez: ", String.valueOf(reactEster.getFkLabStartRctEster().getAcidTq()));
                setPhrase("Saponidade: ", String.valueOf(reactEster.getFkLabStartRctEster().getSoapTq()));
                setPhrase("Impureza: ", String.valueOf(reactEster.getFkLabStartRctEster().getTrashTq()));
                setEspace();
                setPhrase("Acidez: ", String.valueOf(reactEster.getFkLabFinalRctEster().getAcidTq()));
                setPhrase("Saponidade: ", String.valueOf(reactEster.getFkLabFinalRctEster().getSoapTq()));
                setPhrase("Impureza: ", String.valueOf(reactEster.getFkLabFinalRctEster().getTrashTq()));
                setEspace();
            });

            setPhrase("Produzido: ", String.valueOf(esters.getProducedEster()));
            setPhrase("Residuo: ", String.valueOf(esters.getTrashEster()));


            setLogo();
            document.close();
//            Desktop.getDesktop().open(new File(archive));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


}
