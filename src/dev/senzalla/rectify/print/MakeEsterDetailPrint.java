package dev.senzalla.rectify.print;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import dev.senzalla.rectify.entitys.MakeEster;
import dev.senzalla.rectify.enuns.FontEnum;
import dev.senzalla.rectify.treatments.DateTreatment;

import static dev.senzalla.rectify.treatments.DateTreatment.convertDateUtil;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MakeEsterDetailPrint extends ModelPrint {
    public void print(MakeEster esters) {
        try {

            final String archive = String.format("%s\\Esterificacao Detalhada_%d.pdf", DIR, esters.getIdMakeEster());
            setPdfPTable(archive);

            configuration(1, FontEnum.TITLE, BaseColor.WHITE, Element.ALIGN_CENTER);
            setTable("Esterificação");
            document.add(pdfPTable);


            configuration(1, FontEnum.FIELD, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable(convertDateUtil(esters.getDateMakeEster()));
            document.add(pdfPTable);

            setPdf();
            setPhrase("Tanque: ", esters.getTank().getNameTank());
            setEspace();

            esters.getMatterEster().forEach(matterEster -> {
                setPhrase("Produto: ", matterEster.getProduct().getNameProduct());
                setPhrase("Litros: ", String.valueOf(matterEster.getLiterMatterMake()));
                setEspace();
            });

            setPhrase("Quantidade de Produto: ", String.valueOf(esters.getAmountMatterMakeEster()));
            setEspace();
            esters.getReactEster().forEach(reactEster -> {
                setPhrase("Data: ", DateTreatment.convertDateUtil(reactEster.getDateReactionMakeEster()));
                setPhrase("Hora Inicial: ", String.valueOf(reactEster.getTimeStartReactionMakeEster()));
                setPhrase("Metanol Puro: ", String.valueOf(reactEster.getMethanolPureMakeEster()));
                setPhrase("Metanol Recuperado: ", String.valueOf(reactEster.getMethanolRecoverMakeEster()));
                setEspace();
                setPhrase("Acidez: ", String.valueOf(reactEster.getInitialAnalysysReactionMakeEster().getAcidityAnalyzeTank()));
                setPhrase("Saponidade: ", String.valueOf(reactEster.getInitialAnalysysReactionMakeEster().getSaponityTank()));
                setPhrase("Impureza: ", String.valueOf(reactEster.getInitialAnalysysReactionMakeEster().getTrashTank()));
                setEspace();
                setPhrase("Acidez: ", String.valueOf(reactEster.getFinalAnalysisReactionMakeEster().getAcidityAnalyzeTank()));
                setPhrase("Saponidade: ", String.valueOf(reactEster.getFinalAnalysisReactionMakeEster().getSaponityTank()));
                setPhrase("Impureza: ", String.valueOf(reactEster.getFinalAnalysisReactionMakeEster().getTrashTank()));
                setEspace();
            });

            setPhrase("Produzido: ", String.valueOf(esters.getProducedMakeEster()));
            setPhrase("Residuo: ", String.valueOf(esters.getTrashMakeEster()));


            setLogo();
            document.close();
//            Desktop.getDesktop().open(new File(archive));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


}
