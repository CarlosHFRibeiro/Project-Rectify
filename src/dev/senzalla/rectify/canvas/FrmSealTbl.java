/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.senzalla.rectify.canvas;

import dev.senzalla.rectify.Access;
import dev.senzalla.rectify.canvas.filter.FrmFilterSeal;

/**
 * @author Black Burn Cybernetic
 * @e-mail blackburncyber@gmail.com
 * @github github.com/BlackBurnCybernetic
 */

public class FrmSealTbl extends javax.swing.JInternalFrame {

    /** Creates new form FrmLabTqTbl */
    public FrmSealTbl() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSeal = new javax.swing.JPanel();
        btnSealMain = new javax.swing.JButton();
        lblSealTitle = new javax.swing.JLabel();
        btnSealAdd = new javax.swing.JButton();
        btnSealFilter = new javax.swing.JButton();
        rollSeal = new javax.swing.JScrollPane();
        tblSeal = new javax.swing.JTable();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(598, 460));
        setMinimumSize(new java.awt.Dimension(598, 460));
        setPreferredSize(new java.awt.Dimension(598, 460));

        btnSealMain.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSealMain.setText("<<");
        btnSealMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSealMainActionPerformed(evt);
            }
        });

        lblSealTitle.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblSealTitle.setText("Etiqueta Biodiesel");

        btnSealAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/senzalla/rectify/canvas/resource/add_36dp.png"))); // NOI18N
        btnSealAdd.setPreferredSize(new java.awt.Dimension(46, 40));
        btnSealAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSealAddActionPerformed(evt);
            }
        });

        btnSealFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/senzalla/rectify/canvas/resource/filter_24dp.png"))); // NOI18N
        btnSealFilter.setPreferredSize(new java.awt.Dimension(46, 40));
        btnSealFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSealFilterActionPerformed(evt);
            }
        });

        rollSeal.setBorder(null);
        rollSeal.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        rollSeal.setMaximumSize(new java.awt.Dimension(596, 385));
        rollSeal.setMinimumSize(new java.awt.Dimension(596, 385));
        rollSeal.setPreferredSize(new java.awt.Dimension(596, 385));

        tblSeal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empresa", "Leilão", "Fabrica", "Petrobras", "Cliente", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSeal.setMaximumSize(new java.awt.Dimension(592, 363));
        tblSeal.setMinimumSize(new java.awt.Dimension(592, 363));
        tblSeal.setPreferredSize(new java.awt.Dimension(592, 363));
        rollSeal.setViewportView(tblSeal);

        javax.swing.GroupLayout pnlSealLayout = new javax.swing.GroupLayout(pnlSeal);
        pnlSeal.setLayout(pnlSealLayout);
        pnlSealLayout.setHorizontalGroup(
            pnlSealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSealLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSealMain)
                .addGap(141, 141, 141)
                .addComponent(lblSealTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSealAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSealFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addComponent(rollSeal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlSealLayout.setVerticalGroup(
            pnlSealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSealLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSealMain)
                        .addComponent(lblSealTitle)
                        .addComponent(btnSealFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSealAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rollSeal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlSeal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlSeal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSealMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSealMainActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSealMainActionPerformed

    private void btnSealAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSealAddActionPerformed
        Access.goToCanvas(this, new FrmSeal());
    }//GEN-LAST:event_btnSealAddActionPerformed

    private void btnSealFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSealFilterActionPerformed
        Access.goToFilter(new FrmFilterSeal());
    }//GEN-LAST:event_btnSealFilterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSealAdd;
    private javax.swing.JButton btnSealFilter;
    private javax.swing.JButton btnSealMain;
    private javax.swing.JLabel lblSealTitle;
    private javax.swing.JPanel pnlSeal;
    private javax.swing.JScrollPane rollSeal;
    private javax.swing.JTable tblSeal;
    // End of variables declaration//GEN-END:variables

}
