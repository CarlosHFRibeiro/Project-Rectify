package dev.senzalla.rectify.canvas;

import dev.senzalla.rectify.treatments.Access;
import dev.senzalla.rectify.treatments.TreatmentProduct;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class FrmProductTbl extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmProductTbl
     */
    public FrmProductTbl() {
        initComponents();
        new TreatmentProduct().showTable(tbl);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlProduct = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        roll = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(598, 460));
        setMinimumSize(new java.awt.Dimension(598, 460));
        setPreferredSize(new java.awt.Dimension(598, 460));

        pnlProduct.setMaximumSize(new java.awt.Dimension(596, 438));
        pnlProduct.setMinimumSize(new java.awt.Dimension(596, 438));

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblTitle.setText("Produto");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/static/img/add_36dp.png"))); // NOI18N
        btnAdd.setPreferredSize(new java.awt.Dimension(46, 40));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        roll.setBorder(null);
        roll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        roll.setMaximumSize(new java.awt.Dimension(596, 385));
        roll.setMinimumSize(new java.awt.Dimension(596, 385));
        roll.setPreferredSize(new java.awt.Dimension(596, 385));

        tbl.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Nome", "Densidade"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbl.setMaximumSize(new java.awt.Dimension(592, 363));
        tbl.setMinimumSize(new java.awt.Dimension(592, 363));
        tbl.setPreferredSize(new java.awt.Dimension(592, 363));
        roll.setViewportView(tbl);
        if (tbl.getColumnModel().getColumnCount() > 0) {
            tbl.getColumnModel().getColumn(0).setPreferredWidth(500);
        }

        javax.swing.GroupLayout pnlProductLayout = new javax.swing.GroupLayout(pnlProduct);
        pnlProduct.setLayout(pnlProductLayout);
        pnlProductLayout.setHorizontalGroup(
                pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlProductLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTitle)
                                .addGap(197, 197, 197)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(roll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlProductLayout.setVerticalGroup(
                pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlProductLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                                .addComponent(pnlProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Access.goToCanvas(this, new FrmProduct());
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlProduct;
    private javax.swing.JScrollPane roll;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables

}
