/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.canvas;

import dev.senzalla.rectify.Access;
import dev.senzalla.rectify.canvas.panel.PnlStkTk;
import java.awt.GridLayout;

/**
 * @author Black Burn Cybernetic
 * @e-mail blackburncyber@gmail.com
 * @github github.com/BlackBurnCybernetic
 */
public class FrmStkTk extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmStkTk
     */
    public FrmStkTk() {
        initComponents();
        addPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rollStk = new javax.swing.JScrollPane();
        pnlStk = new javax.swing.JPanel();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(600, 460));
        setMinimumSize(new java.awt.Dimension(600, 460));

        rollStk.setBorder(null);
        rollStk.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlStk.setMaximumSize(new java.awt.Dimension(598, 438));
        pnlStk.setMinimumSize(new java.awt.Dimension(598, 438));

        javax.swing.GroupLayout pnlStkLayout = new javax.swing.GroupLayout(pnlStk);
        pnlStk.setLayout(pnlStkLayout);
        pnlStkLayout.setHorizontalGroup(
            pnlStkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );
        pnlStkLayout.setVerticalGroup(
            pnlStkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        rollStk.setViewportView(pnlStk);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rollStk, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rollStk, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlStk;
    private javax.swing.JScrollPane rollStk;
    // End of variables declaration//GEN-END:variables

    private void addPanel() {
//        if(dao.isEmpty){
        Access.goToCanvas(this, new FrmStkTkAdd());
//        }
//        pnlStk.setLayout(new GridLayout(StkFull.getStks().size() / 3, 3));
//        StkFull.getStks().forEach(stk -> pnlStk.add(new pnlStkTk(stk)).setVisible(true));
    }
}
