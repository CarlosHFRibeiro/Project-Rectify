package dev.senzalla.rectify.canvas;

import dev.senzalla.rectify.canvas.panel.PnlStkTk;
import dev.senzalla.rectify.entitys.StockTank;
import dev.senzalla.rectify.request.RequestStockTank;

import java.awt.*;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class FrmStkTk extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmStkTk
     */
    public FrmStkTk() {
        initComponents();
        lblEmpty.setVisible(false);
        showPanel();

    }

    private void showPanel() {
        List<StockTank> stockTank = new RequestStockTank().select();
        if (!stockTank.isEmpty()) {
            GridLayout layout = new GridLayout();
            layout.setRows(stockTank.size() / 2);
            stockTank.forEach(stock -> {
                pnlStk.setLayout(layout);
                pnlStk.add(new PnlStkTk(stock.getTank().getNameTank(), stock.getProduct().getNameProduct(), stock.getLiterStkTq())).setVisible(true);
            });
        } else {
            lblEmpty.setVisible(true);
        }

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
        pnlStk = new javax.swing.JPanel();
        lblEmpty = new javax.swing.JLabel();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(598, 460));
        setMinimumSize(new java.awt.Dimension(598, 460));
        setPreferredSize(new java.awt.Dimension(598, 460));

        roll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlStk.setMaximumSize(new java.awt.Dimension(593, 435));

        lblEmpty.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblEmpty.setText("Não foi cadastrado estoque Hoje!");

        javax.swing.GroupLayout pnlStkLayout = new javax.swing.GroupLayout(pnlStk);
        pnlStk.setLayout(pnlStkLayout);
        pnlStkLayout.setHorizontalGroup(
            pnlStkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStkLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(lblEmpty)
                .addContainerGap(453, Short.MAX_VALUE))
        );
        pnlStkLayout.setVerticalGroup(
            pnlStkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStkLayout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(lblEmpty)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        roll.setViewportView(pnlStk);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roll)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roll)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblEmpty;
    private javax.swing.JPanel pnlStk;
    private javax.swing.JScrollPane roll;
    // End of variables declaration//GEN-END:variables

}