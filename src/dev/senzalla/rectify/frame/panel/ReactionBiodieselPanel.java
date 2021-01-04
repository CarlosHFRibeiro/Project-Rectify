package dev.senzalla.rectify.frame.panel;

import dev.senzalla.rectify.entitys.AnalyzeTank;
import dev.senzalla.rectify.frame.MakeBiodieselFrame;
import dev.senzalla.rectify.treatments.AnalyzeTankTreatment;
import dev.senzalla.rectify.treatments.ReactionBiodieselTreatment;
import dev.senzalla.theme.TreatmentTheme;

import javax.swing.*;
import java.util.Date;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ReactionBiodieselPanel extends javax.swing.JPanel {

    public ReactionBiodieselPanel(MakeBiodieselFrame trans) {
        initComponents();
        TreatmentTheme.initTheme(pnlReact);
        AnalyzeTankTreatment.initComboBox(cbxAnalyzeTank, null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlReact = new javax.swing.JPanel();
        lblDate = new javax.swing.JLabel();
        dtcDate = new com.toedter.calendar.JDateChooser();
        lblTimeInitial = new javax.swing.JLabel();
        txtTimeInitial = new javax.swing.JFormattedTextField();
        lblAnalyze = new javax.swing.JLabel();
        cbxAnalyzeTank = new javax.swing.JComboBox<>();
        lblMethylate = new javax.swing.JLabel();
        txtMethiylate = new javax.swing.JFormattedTextField();
        lblMethanol = new javax.swing.JLabel();
        txtMethanol = new javax.swing.JFormattedTextField();
        lblTimeFinal = new javax.swing.JLabel();
        txtTimeFinal = new javax.swing.JFormattedTextField();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMaximumSize(new java.awt.Dimension(614, 148));
        setMinimumSize(new java.awt.Dimension(614, 148));
        setPreferredSize(new java.awt.Dimension(614, 148));

        pnlReact.setMaximumSize(new java.awt.Dimension(610, 144));
        pnlReact.setMinimumSize(new java.awt.Dimension(610, 144));
        pnlReact.setPreferredSize(new java.awt.Dimension(610, 144));

        lblDate.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblDate.setText("Data");

        dtcDate.setDateFormatString("dd/MM/yyyy");

        lblTimeInitial.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTimeInitial.setText("Hora Inicial");

        try {
            txtTimeInitial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTimeInitial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTimeInitial.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTimeInitial.setPreferredSize(new java.awt.Dimension(120, 27));

        lblAnalyze.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblAnalyze.setText("Cod Analise");

        cbxAnalyzeTank.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbxAnalyzeTank.setPreferredSize(new java.awt.Dimension(120, 27));

        lblMethylate.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblMethylate.setText("Metilato");

        txtMethiylate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtMethiylate.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtMethiylate.setPreferredSize(new java.awt.Dimension(120, 27));

        lblMethanol.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblMethanol.setText("Metanol");

        txtMethanol.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtMethanol.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtMethanol.setPreferredSize(new java.awt.Dimension(120, 27));

        lblTimeFinal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTimeFinal.setText("Hora Final");

        try {
            txtTimeFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTimeFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTimeFinal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTimeFinal.setPreferredSize(new java.awt.Dimension(120, 27));

        javax.swing.GroupLayout pnlReactLayout = new javax.swing.GroupLayout(pnlReact);
        pnlReact.setLayout(pnlReactLayout);
        pnlReactLayout.setHorizontalGroup(
            pnlReactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReactLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlReactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAnalyze)
                    .addComponent(lblDate)
                    .addComponent(lblMethanol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlReactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMethanol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxAnalyzeTank, 0, 130, Short.MAX_VALUE)
                    .addComponent(dtcDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(pnlReactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlReactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReactLayout.createSequentialGroup()
                            .addComponent(lblTimeInitial)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTimeInitial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReactLayout.createSequentialGroup()
                            .addComponent(lblMethylate)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtMethiylate, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReactLayout.createSequentialGroup()
                        .addComponent(lblTimeFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimeFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        pnlReactLayout.setVerticalGroup(
            pnlReactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReactLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlReactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTimeInitial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTimeInitial)
                    .addComponent(lblDate)
                    .addComponent(dtcDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlReactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnalyze)
                    .addComponent(cbxAnalyzeTank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMethiylate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMethylate))
                .addGap(18, 18, 18)
                .addGroup(pnlReactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimeFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlReactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTimeFinal)
                        .addComponent(txtMethanol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMethanol)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlReact, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlReact, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> cbxAnalyzeTank;
    private com.toedter.calendar.JDateChooser dtcDate;
    private javax.swing.JLabel lblAnalyze;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblMethanol;
    private javax.swing.JLabel lblMethylate;
    private javax.swing.JLabel lblTimeFinal;
    private javax.swing.JLabel lblTimeInitial;
    private javax.swing.JPanel pnlReact;
    private javax.swing.JFormattedTextField txtMethanol;
    private javax.swing.JFormattedTextField txtMethiylate;
    private javax.swing.JFormattedTextField txtTimeFinal;
    private javax.swing.JFormattedTextField txtTimeInitial;
    // End of variables declaration//GEN-END:variables

    public JPanel getNamePanel() {
        return pnlReact;
    }

    public Date getDate() {
        return dtcDate.getDate();
    }

    public void saveReact() {
       new ReactionBiodieselTreatment(). saveReact(txtMethiylate.getText(),txtMethanol.getText(),dtcDate.getDate(),txtTimeInitial.getText(),txtTimeFinal.getText(),(AnalyzeTank) cbxAnalyzeTank.getSelectedItem());
       
    }
}
