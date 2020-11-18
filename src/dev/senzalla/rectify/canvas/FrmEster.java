/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.canvas;

import dev.senzalla.rectify.canvas.panel.PnlMatter;
import dev.senzalla.rectify.canvas.panel.PnlReactEster;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Black Burn Cybernetic
 * @e-mail blackburncyber@gmail.com
 * @github github.com/BlackBurnCybernetic
 */
public class FrmEster extends javax.swing.JInternalFrame {

    private int countMatter = 1;
    private int countReact = 1;
    private BoxLayout layoutMatter;
    private BoxLayout layoutReact;
    private List<PnlMatter> pnlMatter;
    private List<PnlReactEster> pnlReact;

    /**
     * Creates new form FrmLabTqTbl
     */
    public FrmEster() {
        initComponents();
        addPanelMatter();
        addPanelReact();
        defineButton(btnMatterEsterRmv, false);
        defineButton(btnReactEsterRmv, false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rollEster = new javax.swing.JScrollPane();
        pnlEster = new javax.swing.JPanel();
        pnlMakeEster = new javax.swing.JPanel();
        btnEsterMain = new javax.swing.JButton();
        lblEsterTitle = new javax.swing.JLabel();
        lblEsterTank = new javax.swing.JLabel();
        cbxEsterTank = new javax.swing.JComboBox<>();
        pnlMatterEster = new javax.swing.JPanel();
        btnMatterEsterAdd = new javax.swing.JButton();
        btnMatterEsterRmv = new javax.swing.JButton();
        lblEsterAmount = new javax.swing.JLabel();
        txtEsterAmount = new javax.swing.JFormattedTextField();
        pnlReactEster = new javax.swing.JPanel();
        btnReactEsterAdd = new javax.swing.JButton();
        btnReactEsterRmv = new javax.swing.JButton();
        lblEsterTrash = new javax.swing.JLabel();
        txtEsterTrash = new javax.swing.JFormattedTextField();
        lblEsterProduced = new javax.swing.JLabel();
        txtEsterProduced = new javax.swing.JFormattedTextField();
        lblEsterObs = new javax.swing.JLabel();
        rollEsterObs = new javax.swing.JScrollPane();
        txtEsterObs = new javax.swing.JTextArea();
        btnEsterSave = new javax.swing.JButton();
        btnEsterClear = new javax.swing.JButton();
        btnEsterCancel = new javax.swing.JButton();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(598, 460));
        setMinimumSize(new java.awt.Dimension(598, 460));
        setPreferredSize(new java.awt.Dimension(598, 460));

        rollEster.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlMakeEster.setMaximumSize(new java.awt.Dimension(563, 32767));
        pnlMakeEster.setMinimumSize(new java.awt.Dimension(563, 0));

        btnEsterMain.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnEsterMain.setText("<<");
        btnEsterMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsterMainActionPerformed(evt);
            }
        });

        lblEsterTitle.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblEsterTitle.setText("Esterificação");

        lblEsterTank.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEsterTank.setText("Tanque");

        cbxEsterTank.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        pnlMatterEster.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlMatterEster.setLayout(new javax.swing.BoxLayout(pnlMatterEster, javax.swing.BoxLayout.Y_AXIS));

        btnMatterEsterAdd.setText("Adicionar Produto");
        btnMatterEsterAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatterEsterAddActionPerformed(evt);
            }
        });

        btnMatterEsterRmv.setText("Eliminar Produto");
        btnMatterEsterRmv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatterEsterRmvActionPerformed(evt);
            }
        });

        lblEsterAmount.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEsterAmount.setText("Quantidade Total");

        txtEsterAmount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtEsterAmount.setPreferredSize(new java.awt.Dimension(120, 27));
        txtEsterAmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEsterAmountFocusGained(evt);
            }
        });

        pnlReactEster.setLayout(new javax.swing.BoxLayout(pnlReactEster, javax.swing.BoxLayout.LINE_AXIS));

        btnReactEsterAdd.setText("Adicionar Reação");
        btnReactEsterAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReactEsterAddActionPerformed(evt);
            }
        });

        btnReactEsterRmv.setText("Eliminar Reação");
        btnReactEsterRmv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReactEsterRmvActionPerformed(evt);
            }
        });

        lblEsterTrash.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEsterTrash.setText("Residuo");

        txtEsterTrash.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtEsterTrash.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtEsterTrash.setPreferredSize(new java.awt.Dimension(100, 23));

        lblEsterProduced.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEsterProduced.setText("Total Produzido");

        txtEsterProduced.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtEsterProduced.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtEsterProduced.setPreferredSize(new java.awt.Dimension(100, 23));

        lblEsterObs.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEsterObs.setText("Observação");

        txtEsterObs.setColumns(20);
        txtEsterObs.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtEsterObs.setRows(5);
        txtEsterObs.setPreferredSize(new java.awt.Dimension(220, 100));
        rollEsterObs.setViewportView(txtEsterObs);

        btnEsterSave.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnEsterSave.setText("Salvar");
        btnEsterSave.setPreferredSize(new java.awt.Dimension(120, 60));
        btnEsterSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsterSaveActionPerformed(evt);
            }
        });

        btnEsterClear.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnEsterClear.setText("Limpar");
        btnEsterClear.setPreferredSize(new java.awt.Dimension(120, 60));
        btnEsterClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsterClearActionPerformed(evt);
            }
        });

        btnEsterCancel.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnEsterCancel.setText("Cancelar");
        btnEsterCancel.setPreferredSize(new java.awt.Dimension(120, 60));
        btnEsterCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsterCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMakeEsterLayout = new javax.swing.GroupLayout(pnlMakeEster);
        pnlMakeEster.setLayout(pnlMakeEsterLayout);
        pnlMakeEsterLayout.setHorizontalGroup(
            pnlMakeEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMakeEsterLayout.createSequentialGroup()
                .addGroup(pnlMakeEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMatterEster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMakeEsterLayout.createSequentialGroup()
                        .addGroup(pnlMakeEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMakeEsterLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlMakeEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlMakeEsterLayout.createSequentialGroup()
                                        .addComponent(btnEsterMain)
                                        .addGap(171, 171, 171)
                                        .addComponent(lblEsterTitle))
                                    .addGroup(pnlMakeEsterLayout.createSequentialGroup()
                                        .addGap(177, 177, 177)
                                        .addComponent(lblEsterTank)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxEsterTank, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlMakeEsterLayout.createSequentialGroup()
                                .addComponent(btnMatterEsterAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMatterEsterRmv, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlMakeEsterLayout.createSequentialGroup()
                                .addComponent(btnReactEsterAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReactEsterRmv, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(pnlMakeEsterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlMakeEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlReactEster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlMakeEsterLayout.createSequentialGroup()
                                .addGroup(pnlMakeEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(pnlMakeEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblEsterObs)
                                        .addGroup(pnlMakeEsterLayout.createSequentialGroup()
                                            .addComponent(lblEsterAmount)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtEsterAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pnlMakeEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(rollEsterObs, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMakeEsterLayout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addComponent(lblEsterTrash)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEsterTrash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(113, 113, 113)
                                                .addComponent(lblEsterProduced)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEsterProduced, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(pnlMakeEsterLayout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(btnEsterSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEsterClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59)
                                        .addComponent(btnEsterCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnlMakeEsterLayout.setVerticalGroup(
            pnlMakeEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMakeEsterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMakeEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEsterMain)
                    .addComponent(lblEsterTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMakeEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEsterTank)
                    .addComponent(cbxEsterTank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlMatterEster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMakeEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMatterEsterAdd)
                    .addComponent(btnMatterEsterRmv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMakeEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEsterAmount)
                    .addComponent(txtEsterAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlReactEster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlMakeEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReactEsterAdd)
                    .addComponent(btnReactEsterRmv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMakeEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEsterTrash)
                    .addComponent(txtEsterTrash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEsterProduced)
                    .addComponent(txtEsterProduced, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlMakeEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEsterObs)
                    .addComponent(rollEsterObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnlMakeEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEsterClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEsterCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEsterSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout pnlEsterLayout = new javax.swing.GroupLayout(pnlEster);
        pnlEster.setLayout(pnlEsterLayout);
        pnlEsterLayout.setHorizontalGroup(
            pnlEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEsterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlMakeEster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        pnlEsterLayout.setVerticalGroup(
            pnlEsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEsterLayout.createSequentialGroup()
                .addComponent(pnlMakeEster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        rollEster.setViewportView(pnlEster);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rollEster, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rollEster, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEsterMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsterMainActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnEsterMainActionPerformed

    private void btnMatterEsterAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatterEsterAddActionPerformed
        PnlMatter panel = new PnlMatter();
        pnlMatterEster.setLayout(layoutMatter);
        if (countMatter <= 1) {
            pnlMatter = new ArrayList<>();
            defineButton(btnMatterEsterRmv, true);
        } else if (countMatter >= 6) {
            defineButton(btnMatterEsterAdd, false);
        }
        this.pnlMatter.add(panel);
        pnlMatterEster.add(panel).setVisible(true);
        countMatter++;
    }//GEN-LAST:event_btnMatterEsterAddActionPerformed

    private void btnMatterEsterRmvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatterEsterRmvActionPerformed
        countMatter--;
        if (countMatter <= 1) {
            defineButton(btnMatterEsterRmv, false);
        } else if (countMatter <= 6) {
            defineButton(btnMatterEsterAdd, true);
        }
        pnlMatter.get(countMatter - 1).setVisible(false);
        pnlMatter.remove(countMatter - 1);
    }//GEN-LAST:event_btnMatterEsterRmvActionPerformed

    private void txtEsterAmountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEsterAmountFocusGained
    }//GEN-LAST:event_txtEsterAmountFocusGained

    private void btnReactEsterAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReactEsterAddActionPerformed
        PnlReactEster panel = new PnlReactEster();
        pnlReactEster.setLayout(layoutReact);
        if (countReact <= 1) {
            pnlReact = new ArrayList<>();
            defineButton(btnReactEsterRmv, true);
        } else if (countReact>= 6) {
            defineButton(btnReactEsterAdd, false);
        }
        this.pnlReact.add(panel);
        pnlReactEster.add(panel).setVisible(true);
        countReact++;
    }//GEN-LAST:event_btnReactEsterAddActionPerformed

    private void btnReactEsterRmvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReactEsterRmvActionPerformed
        countReact--;
        if (countReact <= 1) {
            defineButton(btnReactEsterRmv, false);
        } else if (countReact <= 6) {
            defineButton(btnReactEsterAdd, true);
        }
        pnlReact.get(countReact - 1).setVisible(false);
        pnlReact.remove(countReact - 1);
    }//GEN-LAST:event_btnReactEsterRmvActionPerformed

    private void btnEsterSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsterSaveActionPerformed
    }//GEN-LAST:event_btnEsterSaveActionPerformed

    private void btnEsterClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsterClearActionPerformed
    }//GEN-LAST:event_btnEsterClearActionPerformed

    private void btnEsterCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsterCancelActionPerformed
        btnEsterClearActionPerformed(evt);
        btnEsterMainActionPerformed(evt);
    }//GEN-LAST:event_btnEsterCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEsterCancel;
    private javax.swing.JButton btnEsterClear;
    private javax.swing.JButton btnEsterMain;
    private javax.swing.JButton btnEsterSave;
    private javax.swing.JButton btnMatterEsterAdd;
    private javax.swing.JButton btnMatterEsterRmv;
    private javax.swing.JButton btnReactEsterAdd;
    private javax.swing.JButton btnReactEsterRmv;
    private javax.swing.JComboBox<String> cbxEsterTank;
    private javax.swing.JLabel lblEsterAmount;
    private javax.swing.JLabel lblEsterObs;
    private javax.swing.JLabel lblEsterProduced;
    private javax.swing.JLabel lblEsterTank;
    private javax.swing.JLabel lblEsterTitle;
    private javax.swing.JLabel lblEsterTrash;
    private javax.swing.JPanel pnlEster;
    private javax.swing.JPanel pnlMakeEster;
    private javax.swing.JPanel pnlMatterEster;
    private javax.swing.JPanel pnlReactEster;
    private javax.swing.JScrollPane rollEster;
    private javax.swing.JScrollPane rollEsterObs;
    private javax.swing.JFormattedTextField txtEsterAmount;
    private javax.swing.JTextArea txtEsterObs;
    private javax.swing.JFormattedTextField txtEsterProduced;
    private javax.swing.JFormattedTextField txtEsterTrash;
    // End of variables declaration//GEN-END:variables

    private void addPanelMatter() {
        layoutMatter = new BoxLayout(pnlMatterEster, countMatter);
        pnlMatterEster.setLayout(layoutMatter);
        pnlMatterEster.add(new PnlMatter()).setVisible(true);
    }

    private void addPanelReact() {
//        layoutReact = new BoxLayout(pnlReactEster, countReact);
//        pnlReactEster.setLayout(layoutReact);
//        pnlReactEster.add(new PnlReactEster()).setVisible(true);
        addPanel(layoutReact,pnlReactEster, countReact, new PnlReactEster());
    }
    private <T> void addPanel(BoxLayout layout, JPanel pnl, int count, T t){
        System.out.println(t.getClass());
        layout = new BoxLayout(pnl,count);
        pnl.setLayout(layout);
        pnl.add((Component) t).setVisible(true);
    }

    private void defineButton(JButton btn, boolean b) {
        btn.setEnabled(b);
        btn.setVisible(b);
    }
}
