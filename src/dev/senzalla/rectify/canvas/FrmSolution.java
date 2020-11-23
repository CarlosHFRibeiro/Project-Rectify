/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.canvas;

//import dev.senzalla.rectify.request.NaohRequest;

import dev.senzalla.rectify.treatments.HclTreatment;
import dev.senzalla.rectify.treatments.NaohTreatment;
import dev.senzalla.rectify.treatments.PopUp;

/**
 * @author Black Burn Cybernetic
 * @e-mail blackburncyber@gmail.com
 * @github github.com/BlackBurnCybernetic
 */
public class FrmSolution extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmSolution
     */
    public FrmSolution() {
        initComponents();
        new NaohTreatment().showSolutionNaoh(lstSolNaoh);
        new HclTreatment().showSolutionHcl(lstSolHcl);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSolution = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlSolutionNaoh = new javax.swing.JPanel();
        rollSolNaoh = new javax.swing.JScrollPane();
        lstSolNaoh = new javax.swing.JList<>();
        btnSolNaohAdd = new javax.swing.JButton();
        btnSolNaohChange = new javax.swing.JButton();
        btnSolNaohDelete = new javax.swing.JButton();
        btnSolNaohDeleteAll = new javax.swing.JButton();
        pnlSolutionHcl = new javax.swing.JPanel();
        rollSolHcl = new javax.swing.JScrollPane();
        lstSolHcl = new javax.swing.JList<>();
        btnSolHclAdd = new javax.swing.JButton();
        btnSolHclChange = new javax.swing.JButton();
        btnSolHclDelete = new javax.swing.JButton();
        btnSolHclDeleteAll = new javax.swing.JButton();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(598, 460));
        setMinimumSize(new java.awt.Dimension(598, 460));
        setPreferredSize(new java.awt.Dimension(598, 460));

        pnlSolution.setMaximumSize(new java.awt.Dimension(596, 438));
        pnlSolution.setMinimumSize(new java.awt.Dimension(596, 438));
        pnlSolution.setPreferredSize(new java.awt.Dimension(596, 438));

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblTitle.setText("Soluções");

        pnlSolutionNaoh.setBorder(javax.swing.BorderFactory.createTitledBorder("NaoH"));
        pnlSolutionNaoh.setPreferredSize(new java.awt.Dimension(365, 440));

        rollSolNaoh.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        lstSolNaoh.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rollSolNaoh.setViewportView(lstSolNaoh);

        btnSolNaohAdd.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnSolNaohAdd.setText("Novo");
        btnSolNaohAdd.setPreferredSize(new java.awt.Dimension(160, 60));
        btnSolNaohAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolNaohAddActionPerformed(evt);
            }
        });

        btnSolNaohChange.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnSolNaohChange.setText("Alterar");
        btnSolNaohChange.setPreferredSize(new java.awt.Dimension(160, 60));
        btnSolNaohChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolNaohChangeActionPerformed(evt);
            }
        });

        btnSolNaohDelete.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnSolNaohDelete.setText("Excluir");
        btnSolNaohDelete.setPreferredSize(new java.awt.Dimension(160, 60));
        btnSolNaohDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolNaohDeleteActionPerformed(evt);
            }
        });

        btnSolNaohDeleteAll.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnSolNaohDeleteAll.setText("<html>Excluir <br>Todos</html>");
        btnSolNaohDeleteAll.setPreferredSize(new java.awt.Dimension(160, 60));
        btnSolNaohDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolNaohDeleteAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSolutionNaohLayout = new javax.swing.GroupLayout(pnlSolutionNaoh);
        pnlSolutionNaoh.setLayout(pnlSolutionNaohLayout);
        pnlSolutionNaohLayout.setHorizontalGroup(
                pnlSolutionNaohLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlSolutionNaohLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rollSolNaoh, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlSolutionNaohLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnSolNaohChange, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                        .addComponent(btnSolNaohDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(btnSolNaohAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(btnSolNaohDeleteAll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(16, 16, 16))
        );
        pnlSolutionNaohLayout.setVerticalGroup(
                pnlSolutionNaohLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlSolutionNaohLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlSolutionNaohLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlSolutionNaohLayout.createSequentialGroup()
                                                .addComponent(btnSolNaohAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(btnSolNaohChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addComponent(btnSolNaohDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                                .addComponent(btnSolNaohDeleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(rollSolNaoh))
                                .addContainerGap())
        );

        pnlSolutionHcl.setBorder(javax.swing.BorderFactory.createTitledBorder("HCl"));
        pnlSolutionHcl.setPreferredSize(new java.awt.Dimension(365, 440));

        rollSolHcl.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        lstSolHcl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rollSolHcl.setViewportView(lstSolHcl);

        btnSolHclAdd.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnSolHclAdd.setText("Novo");
        btnSolHclAdd.setPreferredSize(new java.awt.Dimension(160, 60));
        btnSolHclAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolHclAddActionPerformed(evt);
            }
        });

        btnSolHclChange.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnSolHclChange.setText("Alterar");
        btnSolHclChange.setPreferredSize(new java.awt.Dimension(160, 60));
        btnSolHclChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolHclChangeActionPerformed(evt);
            }
        });

        btnSolHclDelete.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnSolHclDelete.setText("Excluir");
        btnSolHclDelete.setPreferredSize(new java.awt.Dimension(160, 60));
        btnSolHclDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolHclDeleteActionPerformed(evt);
            }
        });

        btnSolHclDeleteAll.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnSolHclDeleteAll.setText("<html>Excluir <br>Todos</html>");
        btnSolHclDeleteAll.setPreferredSize(new java.awt.Dimension(160, 60));
        btnSolHclDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolHclDeleteAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSolutionHclLayout = new javax.swing.GroupLayout(pnlSolutionHcl);
        pnlSolutionHcl.setLayout(pnlSolutionHclLayout);
        pnlSolutionHclLayout.setHorizontalGroup(
                pnlSolutionHclLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlSolutionHclLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rollSolHcl, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlSolutionHclLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnSolHclChange, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                        .addComponent(btnSolHclAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(btnSolHclDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(btnSolHclDeleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlSolutionHclLayout.setVerticalGroup(
                pnlSolutionHclLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlSolutionHclLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlSolutionHclLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlSolutionHclLayout.createSequentialGroup()
                                                .addComponent(btnSolHclAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(btnSolHclChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(btnSolHclDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnSolHclDeleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(rollSolHcl))
                                .addContainerGap())
        );

        javax.swing.GroupLayout pnlSolutionLayout = new javax.swing.GroupLayout(pnlSolution);
        pnlSolution.setLayout(pnlSolutionLayout);
        pnlSolutionLayout.setHorizontalGroup(
                pnlSolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlSolutionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlSolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlSolutionLayout.createSequentialGroup()
                                                .addGap(249, 249, 249)
                                                .addComponent(lblTitle)
                                                .addGap(251, 254, Short.MAX_VALUE))
                                        .addGroup(pnlSolutionLayout.createSequentialGroup()
                                                .addComponent(pnlSolutionNaoh, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(pnlSolutionHcl, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12))))
        );
        pnlSolutionLayout.setVerticalGroup(
                pnlSolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlSolutionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlSolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pnlSolutionHcl, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                                        .addComponent(pnlSolutionNaoh, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlSolution, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlSolution, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSolNaohAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolNaohAddActionPerformed
        new NaohTreatment().addSolutionNaoh();
        new NaohTreatment().showSolutionNaoh(lstSolNaoh);
    }//GEN-LAST:event_btnSolNaohAddActionPerformed

    private void btnSolNaohChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolNaohChangeActionPerformed
        if (lstSolNaoh.getSelectedIndex() >= 0) {
            new NaohTreatment().updateSolutionNaoh(lstSolNaoh);
        } else {
            PopUp.selectField();
        }
        new NaohTreatment().showSolutionNaoh(lstSolNaoh);
    }//GEN-LAST:event_btnSolNaohChangeActionPerformed

    private void btnSolNaohDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolNaohDeleteActionPerformed
        if (lstSolNaoh.getSelectedIndex() >= 0) {
            new NaohTreatment().deleteSolutionNaoh(lstSolNaoh);
        } else {
            PopUp.selectField();
        }
        new NaohTreatment().showSolutionNaoh(lstSolNaoh);
    }//GEN-LAST:event_btnSolNaohDeleteActionPerformed

    private void btnSolNaohDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolNaohDeleteAllActionPerformed
        new NaohTreatment().deleteAllSolutionNaoh();
        new NaohTreatment().showSolutionNaoh(lstSolNaoh);
    }//GEN-LAST:event_btnSolNaohDeleteAllActionPerformed

    private void btnSolHclAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolHclAddActionPerformed
        new HclTreatment().addSolutionHcl();
        new HclTreatment().showSolutionHcl(lstSolHcl);
    }//GEN-LAST:event_btnSolHclAddActionPerformed

    private void btnSolHclChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolHclChangeActionPerformed
        if (lstSolHcl.getSelectedIndex() >= 0) {
            new HclTreatment().updateSolutionHcl(lstSolHcl);
        } else {
            PopUp.selectField();
        }
        new HclTreatment().showSolutionHcl(lstSolHcl);
    }//GEN-LAST:event_btnSolHclChangeActionPerformed

    private void btnSolHclDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolHclDeleteActionPerformed
        if (lstSolHcl.getSelectedIndex() >= 0) {
            new HclTreatment().deleteSolutionHcl(lstSolHcl);
        } else {
            PopUp.selectField();
        }
        new HclTreatment().showSolutionHcl(lstSolHcl);
    }//GEN-LAST:event_btnSolHclDeleteActionPerformed

    private void btnSolHclDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolHclDeleteAllActionPerformed
        new HclTreatment().deleteAllSolutionHcl();
        new HclTreatment().showSolutionHcl(lstSolHcl);
    }//GEN-LAST:event_btnSolHclDeleteAllActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSolHclAdd;
    private javax.swing.JButton btnSolHclChange;
    private javax.swing.JButton btnSolHclDelete;
    private javax.swing.JButton btnSolHclDeleteAll;
    private javax.swing.JButton btnSolNaohAdd;
    private javax.swing.JButton btnSolNaohChange;
    private javax.swing.JButton btnSolNaohDelete;
    private javax.swing.JButton btnSolNaohDeleteAll;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JList<String> lstSolHcl;
    private javax.swing.JList<String> lstSolNaoh;
    private javax.swing.JPanel pnlSolution;
    private javax.swing.JPanel pnlSolutionHcl;
    private javax.swing.JPanel pnlSolutionNaoh;
    private javax.swing.JScrollPane rollSolHcl;
    private javax.swing.JScrollPane rollSolNaoh;
    // End of variables declaration//GEN-END:variables
}
