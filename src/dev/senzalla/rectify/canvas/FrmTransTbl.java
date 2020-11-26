package dev.senzalla.rectify.canvas;

import dev.senzalla.rectify.entitys.MakeTrans;
import dev.senzalla.rectify.request.RequestMakeTrans;
import dev.senzalla.rectify.treatments.Access;

import javax.swing.table.DefaultTableModel;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class FrmTransTbl extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmTransTbl
     */
    public FrmTransTbl() {
        initComponents();
        showTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTrans = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnFilter = new javax.swing.JButton();
        roll = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(598, 460));
        setMinimumSize(new java.awt.Dimension(598, 460));
        setPreferredSize(new java.awt.Dimension(598, 460));

        pnlTrans.setMaximumSize(new java.awt.Dimension(596, 438));
        pnlTrans.setMinimumSize(new java.awt.Dimension(596, 438));

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblTitle.setText("Transesterificação");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/static/img/add_36dp.png"))); // NOI18N
        btnAdd.setPreferredSize(new java.awt.Dimension(46, 40));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/static/img/filter_24dp.png"))); // NOI18N
        btnFilter.setPreferredSize(new java.awt.Dimension(46, 40));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        roll.setBorder(null);
        roll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        roll.setMaximumSize(new java.awt.Dimension(596, 385));
        roll.setMinimumSize(new java.awt.Dimension(596, 385));
        roll.setPreferredSize(new java.awt.Dimension(596, 385));

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.", "Data", "Reações", "Tanque", "Produzido", "Residuos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl.setMaximumSize(new java.awt.Dimension(592, 363));
        tbl.setMinimumSize(new java.awt.Dimension(592, 363));
        tbl.setPreferredSize(new java.awt.Dimension(592, 363));
        roll.setViewportView(tbl);
        if (tbl.getColumnModel().getColumnCount() > 0) {
            tbl.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbl.getColumnModel().getColumn(2).setPreferredWidth(30);
            tbl.getColumnModel().getColumn(3).setPreferredWidth(150);
            tbl.getColumnModel().getColumn(4).setPreferredWidth(30);
            tbl.getColumnModel().getColumn(5).setPreferredWidth(30);
        }

        javax.swing.GroupLayout pnlTransLayout = new javax.swing.GroupLayout(pnlTrans);
        pnlTrans.setLayout(pnlTransLayout);
        pnlTransLayout.setHorizontalGroup(
            pnlTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTransLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(105, 105, 105)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTransLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(roll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTransLayout.setVerticalGroup(
            pnlTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTransLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTrans, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Access.goToCanvas(this, new FrmTrans());
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
//        Access.goToFilter(new FrmFilterTrans());
    }//GEN-LAST:event_btnFilterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnFilter;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlTrans;
    private javax.swing.JScrollPane roll;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables

    private void showTable() {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);

        for (MakeTrans makeTrans : new RequestMakeTrans().select()) {
            model.addRow(new Object[]{
                makeTrans.getIdTrans(),
                makeTrans.getReactTranss().getDtRctTrans(),
                makeTrans.getReactTrans(),
                makeTrans.getTank().getNameTank(),
                makeTrans.getProducedTrans(),
                makeTrans.getTrashTrans()
            });
        }
    }

}
