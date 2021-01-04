package dev.senzalla.rectify.print;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import dev.senzalla.rectify.entitys.MakeBiodiesel;
import dev.senzalla.rectify.enuns.FontEnum;
import dev.senzalla.rectify.treatments.DateTreatment;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static dev.senzalla.rectify.treatments.DateTreatment.convertDateUtil;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MakeTransDetailPrint extends ModelPrint {
    public void print(MakeBiodiesel makeBiodiesel) {
        try {

            final String archive = String.format("%s\\Transesterificacao Detalhada_%d.pdf", DIR, makeBiodiesel.getIdMakeBiodiesel());
            setPdfPTable(archive);

            configuration(1, FontEnum.TITLE, BaseColor.WHITE, Element.ALIGN_CENTER);
            setTable("Transesterificação");
            document.add(pdfPTable);
            setLogo();


            configuration(1, FontEnum.FIELD, BaseColor.WHITE, Element.ALIGN_RIGHT);
            setTable(convertDateUtil(makeBiodiesel.getDateMakeBiodiesel()));
            document.add(pdfPTable);

            setPdf();
            setPhrase("Tanque: ", makeBiodiesel.getTank().getNameTank());
            setEspace();

            makeBiodiesel.getMatterMakes().forEach(matterTrans -> {
                setPhrase("Produto: ", matterTrans.getProduct().getNameProduct());
                setPhrase("Litros: ", String.valueOf(matterTrans.getLiterMatterMake()));
                setEspace();
            });

            setPhrase("Quantidade de Produto: ", String.valueOf(makeBiodiesel.getAmountMatterMakeBiodiesel()));
            setEspace();
            makeBiodiesel.getReactTrans().forEach(reactTrans -> {
                setPhrase("Data: ", DateTreatment.convertDateUtil(reactTrans.getDateReactionMakeBiodiesel()));
                setPhrase("Hora Inicial: ", String.valueOf(reactTrans.getTimeFinalReactionMakeBiodiesel()));
                setPhrase("Metanol Puro: ", String.valueOf(reactTrans.getMethanolMakeBiodiesel()));
                setPhrase("Metilato", String.valueOf(reactTrans.getMethylateMakeBiodiesel()));
                setPhrase("Hora Final", String.valueOf(reactTrans.getTimeFinalReactionMakeBiodiesel()));
                setEspace();
                setPhrase("Acidez: ", String.valueOf(reactTrans.getAnalyzeTank().getAcidityAnalyzeTank()));
                setPhrase("Saponidade: ", String.valueOf(reactTrans.getAnalyzeTank().getSaponityTank()));
                setPhrase("Impureza: ", String.valueOf(reactTrans.getAnalyzeTank().getTrashTank()));
                setEspace();
            });

            setPhrase("Produzido: ", String.valueOf(makeBiodiesel.getProducedMakeBiodiesel()));
            setPhrase("Residuo: ", String.valueOf(makeBiodiesel.getTrashMakeBiodiesel()));


            document.close();
            Desktop.getDesktop().open(new File(archive));
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

}
