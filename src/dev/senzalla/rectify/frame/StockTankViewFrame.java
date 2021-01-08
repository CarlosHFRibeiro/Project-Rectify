package dev.senzalla.rectify.frame;

import dev.senzalla.rectify.entitys.StockTank;
import dev.senzalla.rectify.frame.panel.StockEmpty;
import dev.senzalla.rectify.frame.panel.StockTankPanel;
import dev.senzalla.rectify.request.StockTankRequest;
import dev.senzalla.rectify.treatments.ItemTreatment;
import dev.senzalla.theme.TreatmentTheme;

import java.awt.*;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class StockTankViewFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmStkTk
     */
    public StockTankViewFrame() {
        initComponents();
        TreatmentTheme.initTheme(pnlStock);
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
        pnlStock = new javax.swing.JPanel();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(1000, 680));
        setMinimumSize(new java.awt.Dimension(1000, 680));
        setPreferredSize(new java.awt.Dimension(1000, 680));

        roll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        roll.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                rollMouseWheelMoved(evt);
            }
        });

        javax.swing.GroupLayout pnlStockLayout = new javax.swing.GroupLayout(pnlStock);
        pnlStock.setLayout(pnlStockLayout);
        pnlStockLayout.setHorizontalGroup(
            pnlStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 995, Short.MAX_VALUE)
        );
        pnlStockLayout.setVerticalGroup(
            pnlStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
        );

        roll.setViewportView(pnlStock);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roll)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roll, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rollMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_rollMouseWheelMoved
        ItemTreatment.speedRoll(roll);        
    }//GEN-LAST:event_rollMouseWheelMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlStock;
    private javax.swing.JScrollPane roll;
    // End of variables declaration//GEN-END:variables
    private void fillPanel() {
        List<StockTank> stockTank = new StockTankRequest().select(null, null);
        if (!stockTank.isEmpty()) {
            GridLayout layout = new GridLayout();
            layout.setRows(stockTank.size() / 4);
            pnlStock.setLayout(layout);
            stockTank.forEach(stock -> {
                pnlStock.add(new StockTankPanel(stock.getTank().getNameTank(), stock.getProduct().getNameProduct(), stock.getLiterProduct())).setVisible(true);
            });
        } else {
            add(new StockEmpty()).setVisible(true);
        }
    }
    
}
