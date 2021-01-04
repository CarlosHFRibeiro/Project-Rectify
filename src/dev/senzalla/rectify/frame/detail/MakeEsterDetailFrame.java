/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.frame.detail;

import dev.senzalla.rectify.entitys.MakeEster;
import dev.senzalla.rectify.frame.panel.MatterPanelDetail;
import dev.senzalla.rectify.frame.panel.ReactionEsterPanelDetail;
import dev.senzalla.rectify.print.MakeEsterDetailPrint;
import dev.senzalla.rectify.request.MakeEsterRequest;
import dev.senzalla.rectify.treatments.ItemTreatment;
import dev.senzalla.theme.TreatmentTheme;

import javax.swing.*;

/**
 * @author Bomsalvez
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MakeEsterDetailFrame extends javax.swing.JFrame {

    private MakeEster makeEster;

    /**
     * Creates new form FrmTranspDetail
     */
    public MakeEsterDetailFrame() {
        initComponents();
    }
    
    public MakeEsterDetailFrame(MakeEster makeEster) {
        initComponents();
        getEster(makeEster);
        initPanel();
        fillPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roll = new javax.swing.JScrollPane();
        pnlDetail = new javax.swing.JPanel();
        btnPrint = new javax.swing.JButton();
        jlabelTank = new javax.swing.JLabel();
        lblTank = new javax.swing.JLabel();
        pnlMatter = new javax.swing.JPanel();
        jlabelAmount = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        pnlReact = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        roll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        roll.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                rollMouseWheelMoved(evt);
            }
        });

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/static/img/pdf.png"))); // NOI18N
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        jlabelTank.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlabelTank.setText("Tanque");

        lblTank.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTank.setText("Tanque");

        javax.swing.GroupLayout pnlMatterLayout = new javax.swing.GroupLayout(pnlMatter);
        pnlMatter.setLayout(pnlMatterLayout);
        pnlMatterLayout.setHorizontalGroup(
            pnlMatterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );
        pnlMatterLayout.setVerticalGroup(
            pnlMatterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jlabelAmount.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlabelAmount.setText("Quantidade Produto");

        lblAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAmount.setText("Quantidade");

        javax.swing.GroupLayout pnlReactLayout = new javax.swing.GroupLayout(pnlReact);
        pnlReact.setLayout(pnlReactLayout);
        pnlReactLayout.setHorizontalGroup(
            pnlReactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );
        pnlReactLayout.setVerticalGroup(
            pnlReactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlDetailLayout = new javax.swing.GroupLayout(pnlDetail);
        pnlDetail.setLayout(pnlDetailLayout);
        pnlDetailLayout.setHorizontalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDetailLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jlabelTank)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTank))
                    .addGroup(pnlDetailLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jlabelAmount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAmount))
                    .addComponent(pnlReact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMatter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrint)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnlDetailLayout.setVerticalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPrint)
                .addGap(12, 12, 12)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelTank)
                    .addComponent(lblTank))
                .addGap(18, 18, 18)
                .addComponent(pnlMatter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelAmount)
                    .addComponent(lblAmount))
                .addGap(18, 18, 18)
                .addComponent(pnlReact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roll.setViewportView(pnlDetail);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roll, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roll, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rollMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_rollMouseWheelMoved
        ItemTreatment.speedRoll(roll);
    }//GEN-LAST:event_rollMouseWheelMoved

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        new MakeEsterDetailPrint().print(makeEster);
    }//GEN-LAST:event_btnPrintActionPerformed

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
            java.util.logging.Logger.getLogger(MakeEsterDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MakeEsterDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MakeEsterDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MakeEsterDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MakeEsterDetailFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jlabelAmount;
    private javax.swing.JLabel jlabelTank;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblTank;
    private javax.swing.JPanel pnlDetail;
    private javax.swing.JPanel pnlMatter;
    private javax.swing.JPanel pnlReact;
    private javax.swing.JScrollPane roll;
    // End of variables declaration//GEN-END:variables

    private void initPanel() {
        TreatmentTheme.initTheme(pnlDetail);
        TreatmentTheme.iconDefine(btnPrint, "/static/img/pdf_white.png");
    }
    
    private void fillPanel() {
        addPanelMatter();
        addPanelReact();
        lblTank.setText(makeEster.getTank().getNameTank());
        lblAmount.setText(String.valueOf(makeEster.getAmountMatterMakeEster()));
    }
    
    private void addPanelMatter() {
        BoxLayout layoutMatter = new BoxLayout(pnlMatter, 1);
        makeEster.getMatterEster().forEach(matterEster -> {
            pnlMatter.setLayout(layoutMatter);
            pnlMatter.add(new MatterPanelDetail(matterEster.getProduct(), matterEster.getLiterMatterMake())).setVisible(true);
        });
    }
    
    private void addPanelReact() {
        BoxLayout layoutReact = new BoxLayout(pnlReact, 1);
        makeEster.getReactEster().forEach(react -> {
            pnlReact.setLayout(layoutReact);
            pnlReact.add(new ReactionEsterPanelDetail(react)).setVisible(true);
        });
    }

    private void getEster(MakeEster makeEster) {
        this.makeEster = new MakeEsterRequest().select(makeEster);
    }
    
}