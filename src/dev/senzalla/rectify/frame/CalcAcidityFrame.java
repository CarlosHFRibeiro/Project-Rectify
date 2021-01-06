package dev.senzalla.rectify.frame;

import dev.senzalla.rectify.calc.CalcAcidity;
import dev.senzalla.rectify.frame.panel.KohPanel;
import dev.senzalla.rectify.frame.panel.OleicPanel;
import dev.senzalla.rectify.treatments.*;
import dev.senzalla.theme.TreatmentTheme;

import javax.swing.*;
import java.awt.*;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class CalcAcidityFrame extends javax.swing.JInternalFrame {

    private static JTextField txtLabAcidity;

    /**
     * Creates new form FrmCalcAcid
     *
     * @param txtLabAcidity {@link JTextField}
     */
    public CalcAcidityFrame(JTextField txtLabAcidity) {
        initComponents();
        initPanel(txtLabAcidity);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgCalcAcidity = new javax.swing.ButtonGroup();
        pnlCalcAcidity = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblConcentration = new javax.swing.JLabel();
        cbxConcentration = new javax.swing.JComboBox<>();
        lblSampleWeight = new javax.swing.JLabel();
        txtSampleWeight = new javax.swing.JTextField();
        lblVolumeSolution = new javax.swing.JLabel();
        txtVolumeSolution = new javax.swing.JTextField();
        rbtnBio = new javax.swing.JRadioButton();
        rbtnOther = new javax.swing.JRadioButton();
        btnCalc = new javax.swing.JButton();
        pnlCalc = new javax.swing.JPanel();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(1000, 680));
        setMinimumSize(new java.awt.Dimension(1000, 680));
        setPreferredSize(new java.awt.Dimension(1000, 680));

        pnlCalcAcidity.setMaximumSize(new java.awt.Dimension(998, 658));
        pnlCalcAcidity.setMinimumSize(new java.awt.Dimension(998, 658));
        pnlCalcAcidity.setPreferredSize(new java.awt.Dimension(998, 658));

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        lblTitle.setText("Calculadora Acidez");

        lblConcentration.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblConcentration.setText("Concentração");

        cbxConcentration.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        lblSampleWeight.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblSampleWeight.setText("Peso Amostra");

        txtSampleWeight.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtSampleWeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSampleWeightKeyTyped(evt);
            }
        });

        lblVolumeSolution.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblVolumeSolution.setText("Volume");

        txtVolumeSolution.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtVolumeSolution.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVolumeSolutionKeyTyped(evt);
            }
        });

        btgCalcAcidity.add(rbtnBio);
        rbtnBio.setText("Biodiesel");

        btgCalcAcidity.add(rbtnOther);
        rbtnOther.setText("Demais Produtos");

        btnCalc.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btnCalc.setText("Calcular");
        btnCalc.setPreferredSize(new java.awt.Dimension(500, 90));
        btnCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcActionPerformed(evt);
            }
        });

        pnlCalc.setMaximumSize(new java.awt.Dimension(594, 152));
        pnlCalc.setMinimumSize(new java.awt.Dimension(594, 152));

        javax.swing.GroupLayout pnlCalcLayout = new javax.swing.GroupLayout(pnlCalc);
        pnlCalc.setLayout(pnlCalcLayout);
        pnlCalcLayout.setHorizontalGroup(
            pnlCalcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 594, Short.MAX_VALUE)
        );
        pnlCalcLayout.setVerticalGroup(
            pnlCalcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlCalcAcidityLayout = new javax.swing.GroupLayout(pnlCalcAcidity);
        pnlCalcAcidity.setLayout(pnlCalcAcidityLayout);
        pnlCalcAcidityLayout.setHorizontalGroup(
            pnlCalcAcidityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCalcAcidityLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(360, 360, 360))
            .addGroup(pnlCalcAcidityLayout.createSequentialGroup()
                .addGroup(pnlCalcAcidityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCalcAcidityLayout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addGroup(pnlCalcAcidityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCalcAcidityLayout.createSequentialGroup()
                                .addGap(182, 182, 182)
                                .addComponent(rbtnOther))
                            .addComponent(rbtnBio)))
                    .addGroup(pnlCalcAcidityLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addGroup(pnlCalcAcidityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCalc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlCalc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCalcAcidityLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(lblConcentration)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxConcentration, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(lblSampleWeight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSampleWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(lblVolumeSolution)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVolumeSolution, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 129, Short.MAX_VALUE))
        );
        pnlCalcAcidityLayout.setVerticalGroup(
            pnlCalcAcidityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCalcAcidityLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(pnlCalcAcidityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConcentration)
                    .addComponent(cbxConcentration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSampleWeight)
                    .addComponent(lblVolumeSolution)
                    .addComponent(txtSampleWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolumeSolution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlCalcAcidityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnBio)
                    .addComponent(rbtnOther))
                .addGap(57, 57, 57)
                .addComponent(btnCalc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(pnlCalc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCalcAcidity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCalcAcidity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed
        if (TxtTreatment.isTextFieldEmpty(pnlCalcAcidity) && btgCalcAcidity.getSelection() != null && cbxConcentration.getSelectedIndex() >= 0) {
            if (pnlCalc.getComponents().length > 0) {
                pnlCalc.removeAll();
            }
            pnlCalc.setLayout(new GridLayout());
            CalcAcidity calcAcidity = new CalcAcidity(cbxConcentration.getSelectedItem().toString(), txtVolumeSolution.getText(), txtSampleWeight.getText());
            if (rbtnBio.isSelected()) {
                pnlCalc.add(new OleicPanel(calcAcidity.getAcidity())).setVisible(true);
            } else {
                pnlCalc.add(new KohPanel(calcAcidity.getIndice())).setVisible(true);
            }
            if (txtLabAcidity != null) {
                txtLabAcidity.setText(calcAcidity.getAcidity() != null ? calcAcidity.getAcidity() : calcAcidity.getIndice());
            }
        } else {
            PopUp.fieldIsEmpty();
        }
    }//GEN-LAST:event_btnCalcActionPerformed

    private void txtSampleWeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSampleWeightKeyTyped
        NumberField.addNumber(txtSampleWeight.getText(), evt);
    }//GEN-LAST:event_txtSampleWeightKeyTyped

    private void txtVolumeSolutionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVolumeSolutionKeyTyped
        NumberField.addNumber(txtVolumeSolution.getText(), evt);
    }//GEN-LAST:event_txtVolumeSolutionKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgCalcAcidity;
    private javax.swing.JButton btnCalc;
    private javax.swing.JComboBox<Object> cbxConcentration;
    private javax.swing.JLabel lblConcentration;
    private javax.swing.JLabel lblSampleWeight;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVolumeSolution;
    private javax.swing.JPanel pnlCalc;
    private javax.swing.JPanel pnlCalcAcidity;
    private javax.swing.JRadioButton rbtnBio;
    private javax.swing.JRadioButton rbtnOther;
    private javax.swing.JTextField txtSampleWeight;
    private javax.swing.JTextField txtVolumeSolution;
    // End of variables declaration//GEN-END:variables

    void setRbt() {
        rbtnBio.setSelected(true);
        rbtnOther.setVisible(false);
    }

    private void initPanel(JTextField txtLabAcidity) {
        TreatmentTheme.initTheme(pnlCalcAcidity);
        NaohTreatment.initComboBox(cbxConcentration);
        CalcAcidityFrame.txtLabAcidity = txtLabAcidity;
    }

}
