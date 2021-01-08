/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.frame.detail;

import dev.senzalla.rectify.entitys.MakeBiodiesel;
import dev.senzalla.rectify.entitys.MakeEster;
import dev.senzalla.rectify.frame.panel.MatterPanelDetail;
import dev.senzalla.rectify.frame.panel.ReactionBiodieselPanelDetail;
import dev.senzalla.rectify.frame.panel.ReactionEsterPanelDetail;
import dev.senzalla.rectify.print.MakeEsterDetailPrint;
import dev.senzalla.rectify.print.MakeTransDetailPrint;
import dev.senzalla.rectify.request.MakeBiodieselRequest;
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

    public MakeEsterDetailFrame() {
        initComponents();
    }

    /**
     * Creates new form FrmTranspDetail
     *
     * @param makeEster
     */
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
        lblTank = new javax.swing.JLabel();
        lblNameTank = new javax.swing.JLabel();
        pnlMatter = new javax.swing.JPanel();
        lblAmount = new javax.swing.JLabel();
        lblAmountProduct = new javax.swing.JLabel();
        pnlReact = new javax.swing.JPanel();
        lblProduced = new javax.swing.JLabel();
        lblAmountProduced = new javax.swing.JLabel();
        lblTrash = new javax.swing.JLabel();
        lblAmountTrash = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 640));
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

        lblTank.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTank.setText("Tanque");

        lblNameTank.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNameTank.setText("Tanque");

        javax.swing.GroupLayout pnlMatterLayout = new javax.swing.GroupLayout(pnlMatter);
        pnlMatter.setLayout(pnlMatterLayout);
        pnlMatterLayout.setHorizontalGroup(
            pnlMatterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlMatterLayout.setVerticalGroup(
            pnlMatterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblAmount.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblAmount.setText("Quantidade Produto");

        lblAmountProduct.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAmountProduct.setText("Quantidade");

        javax.swing.GroupLayout pnlReactLayout = new javax.swing.GroupLayout(pnlReact);
        pnlReact.setLayout(pnlReactLayout);
        pnlReactLayout.setHorizontalGroup(
            pnlReactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlReactLayout.setVerticalGroup(
            pnlReactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblProduced.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblProduced.setText("Produzido");

        lblAmountProduced.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAmountProduced.setText("Produzido");

        lblTrash.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTrash.setText("Residuo");

        lblAmountTrash.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAmountTrash.setText("Trash");

        javax.swing.GroupLayout pnlDetailLayout = new javax.swing.GroupLayout(pnlDetail);
        pnlDetail.setLayout(pnlDetailLayout);
        pnlDetailLayout.setHorizontalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlReact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDetailLayout.createSequentialGroup()
                        .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDetailLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(lblTank)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNameTank))
                            .addGroup(pnlDetailLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(lblAmount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAmountProduct))
                            .addGroup(pnlDetailLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(lblProduced)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAmountProduced)
                                .addGap(54, 54, 54)
                                .addComponent(lblTrash)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAmountTrash)))
                        .addGap(0, 284, Short.MAX_VALUE))
                    .addComponent(pnlMatter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPrint)))
                .addContainerGap())
        );
        pnlDetailLayout.setVerticalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPrint)
                .addGap(12, 12, 12)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTank)
                    .addComponent(lblNameTank))
                .addGap(18, 18, 18)
                .addComponent(pnlMatter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAmount)
                    .addComponent(lblAmountProduct))
                .addGap(18, 18, 18)
                .addComponent(pnlReact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProduced)
                    .addComponent(lblAmountProduced)
                    .addComponent(lblTrash)
                    .addComponent(lblAmountTrash))
                .addGap(35, 35, 35))
        );

        roll.setViewportView(pnlDetail);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roll)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        new MakeEsterDetailPrint().print(makeEster);
    }//GEN-LAST:event_btnPrintActionPerformed

    private void rollMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_rollMouseWheelMoved
        ItemTreatment.speedRoll(roll);
    }//GEN-LAST:event_rollMouseWheelMoved

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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
            new MakeEsterDetailFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblAmountProduced;
    private javax.swing.JLabel lblAmountProduct;
    private javax.swing.JLabel lblAmountTrash;
    private javax.swing.JLabel lblNameTank;
    private javax.swing.JLabel lblProduced;
    private javax.swing.JLabel lblTank;
    private javax.swing.JLabel lblTrash;
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
        lblNameTank.setText(makeEster.getTank().getNameTank());
        lblAmountProduct.setText(String.valueOf(makeEster.getAmountMatterMakeEster()));
        lblAmountProduced.setText(String.valueOf(makeEster.getProducedMakeEster()));
        lblAmountTrash.setText(String.valueOf(makeEster.getTrashMakeEster()));
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
