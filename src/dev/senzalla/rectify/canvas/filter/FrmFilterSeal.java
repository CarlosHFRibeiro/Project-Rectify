/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.canvas.filter;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 * @author Black Burn Cybernetic
 * @mail blackburncyber@gmail.com
 * @git github.com/BlackBurnCybernetic
 */
public class FrmFilterSeal extends javax.swing.JFrame {

    /**
     * Creates new form FrmFilterSeal
     */
    public FrmFilterSeal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFilterSeal = new javax.swing.JPanel();
        lblFilterSealTitle = new javax.swing.JLabel();
        lblFilterSealDt = new javax.swing.JLabel();
        lblFilterSealSale = new javax.swing.JLabel();
        cbxFilterSealSale = new javax.swing.JComboBox<>();
        lblFilterSealProvider = new javax.swing.JLabel();
        cbxFilterSealProvider = new javax.swing.JComboBox<>();
        btnFilterSealSave = new javax.swing.JButton();
        btnFilterSealCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("FrmFilterSeal"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        pnlFilterSeal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblFilterSealTitle.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblFilterSealTitle.setText("Filtro de Amostras");

        lblFilterSealDt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblFilterSealDt.setText("Data");

        lblFilterSealSale.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblFilterSealSale.setText("Leilão");

        cbxFilterSealSale.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbxFilterSealSale.setPreferredSize(new java.awt.Dimension(34, 27));

        lblFilterSealProvider.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblFilterSealProvider.setText("Parceira");

        cbxFilterSealProvider.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbxFilterSealProvider.setPreferredSize(new java.awt.Dimension(34, 27));

        btnFilterSealSave.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnFilterSealSave.setText("Buscar");
        btnFilterSealSave.setPreferredSize(new java.awt.Dimension(97, 35));
        btnFilterSealSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterSealSaveActionPerformed(evt);
            }
        });

        btnFilterSealCancel.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnFilterSealCancel.setText("Limpar");
        btnFilterSealCancel.setPreferredSize(new java.awt.Dimension(97, 35));
        btnFilterSealCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterSealCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFilterSealLayout = new javax.swing.GroupLayout(pnlFilterSeal);
        pnlFilterSeal.setLayout(pnlFilterSealLayout);
        pnlFilterSealLayout.setHorizontalGroup(
            pnlFilterSealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterSealLayout.createSequentialGroup()
                .addGroup(pnlFilterSealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFilterSealLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlFilterSealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFilterSealProvider)
                            .addComponent(lblFilterSealSale)
                            .addComponent(lblFilterSealDt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFilterSealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxFilterSealProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxFilterSealSale, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlFilterSealLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnFilterSealSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFilterSealCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFilterSealLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(lblFilterSealTitle)))
                .addGap(20, 20, 20))
        );
        pnlFilterSealLayout.setVerticalGroup(
            pnlFilterSealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterSealLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblFilterSealTitle)
                .addGap(32, 32, 32)
                .addComponent(lblFilterSealDt)
                .addGap(18, 18, 18)
                .addGroup(pnlFilterSealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFilterSealSale)
                    .addComponent(cbxFilterSealSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFilterSealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFilterSealProvider)
                    .addComponent(cbxFilterSealProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFilterSealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFilterSealSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFilterSealCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFilterSeal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFilterSeal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterSealSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterSealSaveActionPerformed
    }//GEN-LAST:event_btnFilterSealSaveActionPerformed

    private void btnFilterSealCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterSealCancelActionPerformed
    }//GEN-LAST:event_btnFilterSealCancelActionPerformed

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
            java.util.logging.Logger.getLogger(FrmFilterSeal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmFilterSeal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmFilterSeal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmFilterSeal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmFilterSeal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilterSealCancel;
    private javax.swing.JButton btnFilterSealSave;
    private javax.swing.JComboBox<Object> cbxFilterSealProvider;
    private javax.swing.JComboBox<Object> cbxFilterSealSale;
    private javax.swing.JLabel lblFilterSealDt;
    private javax.swing.JLabel lblFilterSealProvider;
    private javax.swing.JLabel lblFilterSealSale;
    private javax.swing.JLabel lblFilterSealTitle;
    private javax.swing.JPanel pnlFilterSeal;
    // End of variables declaration//GEN-END:variables

    private JTable tbl;

    public void setTbl(JTable tbl) {
        this.tbl = tbl;
    }

}
