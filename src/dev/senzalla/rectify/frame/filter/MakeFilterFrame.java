package dev.senzalla.rectify.frame.filter;

import dev.senzalla.rectify.treatments.MakeEsterTreatment;
import dev.senzalla.rectify.treatments.MakeBiodieselTreatment;
import dev.senzalla.rectify.treatments.TankTreatment;
import dev.senzalla.theme.TreatmentTheme;

import javax.swing.*;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MakeFilterFrame extends javax.swing.JFrame {

    private JTable tbl;
    private boolean isMakeEster;

    /**
     * Creates new form FrmFilterCharging
     */
    public MakeFilterFrame() {
        initComponents();
        TreatmentTheme.initTheme(pnlTransp);
    }

    public MakeFilterFrame(JTable tbl, boolean isMakeEster) {
        initVariable(tbl, isMakeEster);
        initComponents();
        TreatmentTheme.initTheme(pnlTransp);
        TankTreatment.initComboBox(cbxTank);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTransp = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblCod = new javax.swing.JLabel();
        spnCod = new javax.swing.JSpinner();
        lblDtOf = new javax.swing.JLabel();
        dtcDtOf = new com.toedter.calendar.JDateChooser();
        lblDtUp = new javax.swing.JLabel();
        dtcDtUp = new com.toedter.calendar.JDateChooser();
        lblProvider = new javax.swing.JLabel();
        cbxTank = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("FrmFilterCharging"); // NOI18N
        setResizable(false);

        pnlTransp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblTitle.setText("Filtro Carregamento");

        lblCod.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblCod.setText("Cod");

        spnCod.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        spnCod.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnCod.setMinimumSize(new java.awt.Dimension(70, 26));
        spnCod.setPreferredSize(new java.awt.Dimension(70, 30));

        lblDtOf.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblDtOf.setText("De");

        dtcDtOf.setDateFormatString("dd/MM/yyyy");
        dtcDtOf.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        lblDtUp.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblDtUp.setText("Ate");

        dtcDtUp.setDateFormatString("dd/MM/yyyy");
        dtcDtUp.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        lblProvider.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblProvider.setText("Tanque");

        cbxTank.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSearch.setText("Buscar");
        btnSearch.setPreferredSize(new java.awt.Dimension(97, 35));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnClear.setText("Limpar");
        btnClear.setPreferredSize(new java.awt.Dimension(97, 35));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTranspLayout = new javax.swing.GroupLayout(pnlTransp);
        pnlTransp.setLayout(pnlTranspLayout);
        pnlTranspLayout.setHorizontalGroup(
            pnlTranspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTranspLayout.createSequentialGroup()
                .addGroup(pnlTranspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTranspLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTranspLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(pnlTranspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCod)
                            .addComponent(lblDtOf)
                            .addComponent(lblDtUp)
                            .addComponent(lblProvider))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlTranspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTank, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtcDtOf, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtcDtUp, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTranspLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(75, 75, 75))
        );
        pnlTranspLayout.setVerticalGroup(
            pnlTranspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTranspLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(30, 30, 30)
                .addGroup(pnlTranspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlTranspLayout.createSequentialGroup()
                        .addGroup(pnlTranspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCod)
                            .addComponent(spnCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(lblDtOf))
                    .addComponent(dtcDtOf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTranspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDtUp)
                    .addComponent(dtcDtUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTranspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProvider)
                    .addComponent(cbxTank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTranspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTransp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTransp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (!spnCod.getValue().equals(0) || dtcDtOf.getDate() != null || dtcDtUp.getDate() != null || cbxTank.getSelectedIndex() > 0) {
            if (isMakeEster) {
                MakeEsterTreatment.setTableFilters(tbl, Long.valueOf(spnCod.getValue().toString()), dtcDtOf.getDate(), dtcDtUp.getDate(), cbxTank.getSelectedItem());
            } else {
                MakeBiodieselTreatment.setTableFilters(tbl, Long.valueOf(spnCod.getValue().toString()), dtcDtOf.getDate(), dtcDtUp.getDate(), cbxTank.getSelectedItem());
            }
        }
        this.dispose();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        if (isMakeEster) {
            MakeEsterTreatment.initTable(tbl);
        } else {
            MakeBiodieselTreatment.initTable(tbl);
        }
        this.dispose();
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MakeFilterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MakeFilterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MakeFilterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MakeFilterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MakeFilterFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<Object> cbxTank;
    private com.toedter.calendar.JDateChooser dtcDtOf;
    private com.toedter.calendar.JDateChooser dtcDtUp;
    private javax.swing.JLabel lblCod;
    private javax.swing.JLabel lblDtOf;
    private javax.swing.JLabel lblDtUp;
    private javax.swing.JLabel lblProvider;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlTransp;
    private javax.swing.JSpinner spnCod;
    // End of variables declaration//GEN-END:variables

    private void initVariable(JTable tbl, boolean isMakeEster) {
        this.tbl = tbl;
        this.isMakeEster = isMakeEster;
    }

}
