package dev.senzalla.rectify.treatments;

import dev.senzalla.rectify.entitys.Provider;
import dev.senzalla.rectify.entitys.Sample;
import dev.senzalla.rectify.frame.SampleTableFrame;
import dev.senzalla.rectify.request.SampleRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static dev.senzalla.rectify.treatments.DateTreatment.convertDateUtil;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class SampleTreatment {

    public static void initComboBox(JComboBox<Object> comboBoxSample) {
        comboBoxSample.removeAllItems();
        comboBoxSample.addItem("Leilão");
        new SampleRequest().select(null,null).forEach(comboBoxSample::addItem);
    }

    public static void initTable(JTable tableSample) {
        fillTable(tableSample, new SampleRequest().select(null,null));

    }

    public static void setTableFilters(JTable tableSample, Integer sale, Object provider, Date dateOf, Date dateUntil) {
        List<String> clause = new ArrayList<>();
        Sample sample = new Sample();
        if (sale > 0) {
            clause.add("saleSeal =");
            sample.setAuctionNumber(sale);
        }
        if (!provider.equals("Fornecedor")) {
            clause.add("nameProvider =");
            sample.setProvider((Provider) provider);
        }
        if (dateOf != null && dateUntil != null) {
            clause.add("dtSeal between");
            sample.setDateSampleCollection(dateOf);
            clause.add("");
            sample.setDateBetween(dateUntil);
        } else {
            if (dateOf != null) {
                clause.add("dtSeal =");
                sample.setDateSampleCollection(dateOf);
            }
            if (dateUntil != null) {
                clause.add("dtSeal =");
                sample.setDateSampleCollection(dateUntil);
            }

        }
        fillTable(tableSample, new SampleRequest().select(clause, sample));
    }

    private static void fillTable(JTable tableSample, List<Sample> sampleList) {
        SampleTableFrame.query(sampleList);
        DefaultTableModel tableModel = (DefaultTableModel) tableSample.getModel();
        tableModel.setNumRows(0);
        sampleList.forEach(sample ->
                tableModel.addRow(new Object[]{
                        sample.getAuctionNumber(),
                        sample.getClientSample(),
                        sample.getFactorySample(),
                        sample.getPetrobrasSample(),
                        sample.getProvider(),
                        convertDateUtil(sample.getDateSampleCollection())
                }));
    }

    public void saveSample(String sale, String factory, String client, String petrobras, Provider provider) {
        Sample sample = new Sample();
        sample.setProvider(provider);
        sample.setPetrobrasSample(Integer.parseInt(petrobras));
        sample.setFactorySample(Integer.parseInt(factory));
        sample.setClientSample(Integer.parseInt(client));
        sample.setAuctionNumber(Integer.parseInt(sale));
        new SampleRequest().insert(sample);
    }
}
