package dev.senzalla.rectify.canvas.detail;

import dev.senzalla.rectify.entitys.Discharge;
import dev.senzalla.rectify.print.DchargeDetailPrint;
import dev.senzalla.rectify.request.RequestDcharge;

import static dev.senzalla.rectify.treatments.TreatmentDate.convertDateUtil;
import dev.senzalla.theme.TreatmentTheme;

/**
 * @author Bomsalvez
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class FrmTranspDetailDcharge extends javax.swing.JFrame {
    private Discharge discharge;

    /**
     * Creates new form FrmTranspDetail
     */
    public FrmTranspDetailDcharge() {
        initComponents();
        TreatmentTheme.initTheme(pnlDetail);
    }

    public FrmTranspDetailDcharge(Object cod) {
        initComponents();
        TreatmentTheme.initTheme(pnlDetail);
        Discharge d = new Discharge();
        d.setIdDcharge(Long.valueOf(cod.toString()));
        discharge = new RequestDcharge().select(d);
        showDetail();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDetail = new javax.swing.JPanel();
        lblProvider = new javax.swing.JLabel();
        txtProvider = new javax.swing.JLabel();
        lblDtOf = new javax.swing.JLabel();
        txtDtOf = new javax.swing.JLabel();
        lblHrOf = new javax.swing.JLabel();
        txtHrOf = new javax.swing.JLabel();
        lblNote = new javax.swing.JLabel();
        txtNote = new javax.swing.JLabel();
        lblTicket = new javax.swing.JLabel();
        txtTicket = new javax.swing.JLabel();
        lblBoard = new javax.swing.JLabel();
        txtBoard = new javax.swing.JLabel();
        lblCnh = new javax.swing.JLabel();
        txtCnh = new javax.swing.JLabel();
        lblDriver = new javax.swing.JLabel();
        txtDriver = new javax.swing.JLabel();
        lblDtUp = new javax.swing.JLabel();
        txtDtUp = new javax.swing.JLabel();
        lblHrUp = new javax.swing.JLabel();
        txtHrUp = new javax.swing.JLabel();
        lblProduct = new javax.swing.JLabel();
        txtProduct = new javax.swing.JLabel();
        lblAnalyse = new javax.swing.JLabel();
        lblAcid = new javax.swing.JLabel();
        txtAcid = new javax.swing.JLabel();
        lblSoap = new javax.swing.JLabel();
        txtSoap = new javax.swing.JLabel();
        lblDens = new javax.swing.JLabel();
        txtDens = new javax.swing.JLabel();
        lblTrash = new javax.swing.JLabel();
        txtTrash = new javax.swing.JLabel();
        lblBurden = new javax.swing.JLabel();
        txtBurden = new javax.swing.JLabel();
        lblLiters = new javax.swing.JLabel();
        txtLiters = new javax.swing.JLabel();
        lblTank = new javax.swing.JLabel();
        txtTank = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlDetail.setMaximumSize(new java.awt.Dimension(400, 765));
        pnlDetail.setMinimumSize(new java.awt.Dimension(400, 765));
        pnlDetail.setPreferredSize(new java.awt.Dimension(400, 730));

        lblProvider.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblProvider.setText("Fornecedor");

        txtProvider.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtProvider.setText("Fornecedor");

        lblDtOf.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDtOf.setText("Data Entrada");

        txtDtOf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDtOf.setText("Data Entrada");

        lblHrOf.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblHrOf.setText("Hora Entrada");

        txtHrOf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHrOf.setText("Hora Entrada");

        lblNote.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNote.setText("Nota N°");

        txtNote.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNote.setText("Nota");

        lblTicket.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTicket.setText("Ticket");

        txtTicket.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTicket.setText("Ticket");

        lblBoard.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBoard.setText("Placa");

        txtBoard.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBoard.setText("Placa");

        lblCnh.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCnh.setText("CNH");

        txtCnh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCnh.setText("Cnh");

        lblDriver.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDriver.setText("Motorista");

        txtDriver.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDriver.setText("Motorista");

        lblDtUp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDtUp.setText("Data Saida");

        txtDtUp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDtUp.setText("Data Saida");

        lblHrUp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblHrUp.setText("Hora Saida");

        txtHrUp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHrUp.setText("Hora Saida");

        lblProduct.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblProduct.setText("Produto");

        txtProduct.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtProduct.setText("Produto");

        lblAnalyse.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAnalyse.setText("Analise");

        lblAcid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAcid.setText("Acidez");

        txtAcid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAcid.setText("Acidez");

        lblSoap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSoap.setText("Saponidade");

        txtSoap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSoap.setText("Saponidade");

        lblDens.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDens.setText("Densidade");

        txtDens.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDens.setText("Densidade");

        lblTrash.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTrash.setText("Impureza");

        txtTrash.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTrash.setText("Impureza");

        lblBurden.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBurden.setText("Peso");

        txtBurden.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBurden.setText("Peso");

        lblLiters.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblLiters.setText("Litros");

        txtLiters.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtLiters.setText("Litros");

        lblTank.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTank.setText("Tanque");

        txtTank.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTank.setText("Tanque");

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/static/img/pdf_24dp.png"))); // NOI18N
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDetailLayout = new javax.swing.GroupLayout(pnlDetail);
        pnlDetail.setLayout(pnlDetailLayout);
        pnlDetailLayout.setHorizontalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDens)
                    .addComponent(lblAcid)
                    .addComponent(lblDtOf)
                    .addComponent(lblProvider)
                    .addComponent(lblNote)
                    .addComponent(lblBoard)
                    .addComponent(lblDriver)
                    .addComponent(lblDtUp)
                    .addComponent(lblProduct)
                    .addComponent(lblAnalyse)
                    .addComponent(lblBurden)
                    .addComponent(lblTank))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetailLayout.createSequentialGroup()
                        .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProvider)
                            .addComponent(txtDriver)
                            .addComponent(txtProduct)
                            .addGroup(pnlDetailLayout.createSequentialGroup()
                                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(pnlDetailLayout.createSequentialGroup()
                                        .addComponent(txtDens)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTrash))
                                    .addGroup(pnlDetailLayout.createSequentialGroup()
                                        .addComponent(txtAcid)
                                        .addGap(45, 45, 45)
                                        .addComponent(lblSoap)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoap)
                                    .addComponent(txtTrash)))
                            .addComponent(txtTank)
                            .addGroup(pnlDetailLayout.createSequentialGroup()
                                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDetailLayout.createSequentialGroup()
                                        .addComponent(txtBoard)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblCnh))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDetailLayout.createSequentialGroup()
                                        .addComponent(txtNote)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTicket))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDetailLayout.createSequentialGroup()
                                        .addComponent(txtDtUp)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblHrUp))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDetailLayout.createSequentialGroup()
                                        .addComponent(txtDtOf)
                                        .addGap(52, 52, 52)
                                        .addComponent(lblHrOf)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHrUp)
                                    .addComponent(txtTicket)
                                    .addComponent(txtHrOf)
                                    .addComponent(txtCnh))))
                        .addContainerGap(56, Short.MAX_VALUE))
                    .addGroup(pnlDetailLayout.createSequentialGroup()
                        .addComponent(txtBurden)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLiters)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLiters)
                        .addGap(122, 122, 122))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrint)
                .addContainerGap())
        );
        pnlDetailLayout.setVerticalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPrint)
                .addGap(27, 27, 27)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProvider)
                    .addComponent(txtProvider))
                .addGap(18, 18, 18)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDtOf)
                    .addComponent(txtDtOf)
                    .addComponent(lblHrOf)
                    .addComponent(txtHrOf))
                .addGap(18, 18, 18)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNote)
                    .addComponent(txtNote)
                    .addComponent(txtTicket)
                    .addComponent(lblTicket))
                .addGap(18, 18, 18)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCnh)
                        .addComponent(txtCnh))
                    .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBoard)
                        .addComponent(txtBoard)))
                .addGap(18, 18, 18)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDriver)
                    .addComponent(txtDriver))
                .addGap(18, 18, 18)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDtUp)
                    .addComponent(txtDtUp)
                    .addComponent(lblHrUp)
                    .addComponent(txtHrUp))
                .addGap(18, 18, 18)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProduct)
                    .addComponent(txtProduct))
                .addGap(27, 27, 27)
                .addComponent(lblAnalyse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAcid)
                    .addComponent(txtAcid)
                    .addComponent(lblSoap)
                    .addComponent(txtSoap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDens)
                    .addComponent(txtDens)
                    .addComponent(lblTrash)
                    .addComponent(txtTrash))
                .addGap(30, 30, 30)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBurden)
                    .addComponent(txtBurden)
                    .addComponent(lblLiters)
                    .addComponent(txtLiters))
                .addGap(18, 18, 18)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTank)
                    .addComponent(txtTank))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDetail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 511, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        new DchargeDetailPrint().print(discharge);
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
            java.util.logging.Logger.getLogger(FrmTranspDetailDcharge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTranspDetailDcharge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTranspDetailDcharge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTranspDetailDcharge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTranspDetailDcharge().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel lblAcid;
    private javax.swing.JLabel lblAnalyse;
    private javax.swing.JLabel lblBoard;
    private javax.swing.JLabel lblBurden;
    private javax.swing.JLabel lblCnh;
    private javax.swing.JLabel lblDens;
    private javax.swing.JLabel lblDriver;
    private javax.swing.JLabel lblDtOf;
    private javax.swing.JLabel lblDtUp;
    private javax.swing.JLabel lblHrOf;
    private javax.swing.JLabel lblHrUp;
    private javax.swing.JLabel lblLiters;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lblProduct;
    private javax.swing.JLabel lblProvider;
    private javax.swing.JLabel lblSoap;
    private javax.swing.JLabel lblTank;
    private javax.swing.JLabel lblTicket;
    private javax.swing.JLabel lblTrash;
    private javax.swing.JPanel pnlDetail;
    private javax.swing.JLabel txtAcid;
    private javax.swing.JLabel txtBoard;
    private javax.swing.JLabel txtBurden;
    private javax.swing.JLabel txtCnh;
    private javax.swing.JLabel txtDens;
    private javax.swing.JLabel txtDriver;
    private javax.swing.JLabel txtDtOf;
    private javax.swing.JLabel txtDtUp;
    private javax.swing.JLabel txtHrOf;
    private javax.swing.JLabel txtHrUp;
    private javax.swing.JLabel txtLiters;
    private javax.swing.JLabel txtNote;
    private javax.swing.JLabel txtProduct;
    private javax.swing.JLabel txtProvider;
    private javax.swing.JLabel txtSoap;
    private javax.swing.JLabel txtTank;
    private javax.swing.JLabel txtTicket;
    private javax.swing.JLabel txtTrash;
    // End of variables declaration//GEN-END:variables


    private void showDetail() {
        txtProvider.setText(discharge.getProvider().getNameProvider());
        txtDtOf.setText(convertDateUtil(discharge.getDtOfDcharge()));
        txtHrOf.setText(String.valueOf(discharge.getHrOfDcharge()));
        txtNote.setText(String.valueOf(discharge.getNoteDcharge()));
        txtTicket.setText(String.valueOf(discharge.getTicketDcharge()));
        txtBoard.setText(discharge.getBoardDcharge());
        txtCnh.setText(discharge.getDriver().getCnhDriver());
        txtDriver.setText(discharge.getDriver().getNameDriver());
        txtDtUp.setText(convertDateUtil(discharge.getDtUpDcharge()));
        txtHrUp.setText(String.valueOf(discharge.getHrUpDcharge()));
        txtProduct.setText(discharge.getProduct().getNameProduct());
        txtAcid.setText(String.valueOf(discharge.getLabCar().getAcidCar()));
        txtSoap.setText(String.valueOf(discharge.getLabCar().getSoapCar()));
        txtDens.setText(String.valueOf(discharge.getLabCar().getDensityCar()));
        txtTrash.setText(String.valueOf(discharge.getLabCar().getTrashCar()));
        txtBurden.setText(String.valueOf(discharge.getBurdenDcharge()));
        txtBurden.setText(String.valueOf(discharge.getLiterDcharge()));
        txtTank.setText(discharge.getTank().getNameTank());
    }
}
