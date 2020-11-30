package dev.senzalla.rectify.canvas;

import dev.senzalla.rectify.entitys.Driver;
import dev.senzalla.rectify.exception.EmptyField;
import dev.senzalla.rectify.request.RequestDriver;
import dev.senzalla.rectify.treatments.*;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class FrmCharge extends javax.swing.JInternalFrame {
    private boolean driverEmpty = true;
    private Driver driver;

    /**
     * Creates new form FrmLabTqTbl
     */
    public FrmCharge() {
        initComponents();
        new TreatmentProduct().addComboBox(cbxProduct);
        new TreatementProvider().showComboBox(cbxProvider);
        new TreatmentTank().showComboBox(cbxTank);
        new TreatmentLabCar().showComboBox(cbxLabCar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rollCharge = new javax.swing.JScrollPane();
        pnlCharge = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblProvider = new javax.swing.JLabel();
        cbxProvider = new javax.swing.JComboBox<>();
        lblDtOf = new javax.swing.JLabel();
        dtcDtOf = new com.toedter.calendar.JDateChooser();
        lblHrOf = new javax.swing.JLabel();
        txtHrOf = new javax.swing.JFormattedTextField();
        lblNote = new javax.swing.JLabel();
        spnNote = new javax.swing.JSpinner();
        lblTicket = new javax.swing.JLabel();
        spnTicket = new javax.swing.JSpinner();
        lblBoard = new javax.swing.JLabel();
        txtBoard = new javax.swing.JTextField();
        lblCnh = new javax.swing.JLabel();
        txtCnh = new javax.swing.JFormattedTextField();
        lblDriver = new javax.swing.JLabel();
        txtDriver = new javax.swing.JTextField();
        lblDtUp = new javax.swing.JLabel();
        dtcDtUp = new com.toedter.calendar.JDateChooser();
        lblHrUp = new javax.swing.JLabel();
        txtHrUp = new javax.swing.JFormattedTextField();
        lblProduct = new javax.swing.JLabel();
        cbxProduct = new javax.swing.JComboBox<>();
        lblLabCar = new javax.swing.JLabel();
        cbxLabCar = new javax.swing.JComboBox<>();
        lblBurden = new javax.swing.JLabel();
        txtBurden = new javax.swing.JFormattedTextField();
        lblLitter = new javax.swing.JLabel();
        txtLitter = new javax.swing.JTextField();
        lblTank = new javax.swing.JLabel();
        cbxTank = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(598, 460));
        setMinimumSize(new java.awt.Dimension(598, 460));
        setPreferredSize(new java.awt.Dimension(598, 460));

        rollCharge.setBorder(null);
        rollCharge.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        rollCharge.setMaximumSize(new java.awt.Dimension(596, 438));
        rollCharge.setMinimumSize(new java.awt.Dimension(596, 438));
        rollCharge.setPreferredSize(new java.awt.Dimension(596, 438));

        pnlCharge.setMaximumSize(new java.awt.Dimension(750, 765));
        pnlCharge.setMinimumSize(new java.awt.Dimension(750, 765));

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblTitle.setText("Carregamento");

        lblProvider.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblProvider.setText("Fornecedor");

        cbxProvider.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        lblDtOf.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDtOf.setText("Data Entrada");

        dtcDtOf.setDateFormatString("dd/MM/yyyy");

        lblHrOf.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblHrOf.setText("Hora Entrada");

        try {
            txtHrOf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHrOf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHrOf.setPreferredSize(new java.awt.Dimension(120, 27));

        lblNote.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNote.setText("Nota N°");

        spnNote.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        spnNote.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnNote.setPreferredSize(new java.awt.Dimension(70, 27));

        lblTicket.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTicket.setText("Ticket");

        spnTicket.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        spnTicket.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnTicket.setPreferredSize(new java.awt.Dimension(70, 27));

        lblBoard.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBoard.setText("Placa");

        txtBoard.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtBoard.setPreferredSize(new java.awt.Dimension(120, 27));
        txtBoard.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBoardFocusLost(evt);
            }
        });

        lblCnh.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCnh.setText("CNH");

        txtCnh.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtCnh.setPreferredSize(new java.awt.Dimension(120, 27));
        txtCnh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCnhFocusLost(evt);
            }
        });
        txtCnh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCnhKeyTyped(evt);
            }
        });

        lblDriver.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDriver.setText("Motorista");

        txtDriver.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDriver.setPreferredSize(new java.awt.Dimension(120, 27));

        lblDtUp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDtUp.setText("Data Saida");

        dtcDtUp.setDateFormatString("dd/MM/yyyy");

        lblHrUp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblHrUp.setText("Hora Saida");

        try {
            txtHrUp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHrUp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHrUp.setPreferredSize(new java.awt.Dimension(120, 27));

        lblProduct.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblProduct.setText("Produto");

        cbxProduct.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        lblLabCar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblLabCar.setText("Analise");

        cbxLabCar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        lblBurden.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBurden.setText("Peso");

        txtBurden.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtBurden.setPreferredSize(new java.awt.Dimension(120, 27));
        txtBurden.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBurdenFocusLost(evt);
            }
        });
        txtBurden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBurdenKeyTyped(evt);
            }
        });

        lblLitter.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblLitter.setText("Litros");

        txtLitter.setEditable(false);

        lblTank.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTank.setText("Tanque");

        cbxTank.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        btnSave.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnSave.setText("Salvar");
        btnSave.setPreferredSize(new java.awt.Dimension(120, 60));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnClear.setText("Limpar");
        btnClear.setPreferredSize(new java.awt.Dimension(120, 60));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.setPreferredSize(new java.awt.Dimension(120, 60));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlChargeLayout = new javax.swing.GroupLayout(pnlCharge);
        pnlCharge.setLayout(pnlChargeLayout);
        pnlChargeLayout.setHorizontalGroup(
                pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlChargeLayout.createSequentialGroup()
                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlChargeLayout.createSequentialGroup()
                                                .addGap(229, 229, 229)
                                                .addComponent(lblTitle))
                                        .addGroup(pnlChargeLayout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblDtOf)
                                                        .addComponent(lblProvider)
                                                        .addComponent(lblNote)
                                                        .addComponent(lblBoard)
                                                        .addComponent(lblDriver)
                                                        .addComponent(lblDtUp)
                                                        .addComponent(lblProduct)
                                                        .addComponent(lblLabCar)
                                                        .addComponent(lblBurden)
                                                        .addComponent(lblTank))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(pnlChargeLayout.createSequentialGroup()
                                                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(pnlChargeLayout.createSequentialGroup()
                                                                                .addComponent(txtBurden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(lblLitter))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlChargeLayout.createSequentialGroup()
                                                                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addComponent(spnNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(txtBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addGap(107, 107, Short.MAX_VALUE)
                                                                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(lblCnh, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(lblTicket, javax.swing.GroupLayout.Alignment.TRAILING)))
                                                                        .addGroup(pnlChargeLayout.createSequentialGroup()
                                                                                .addComponent(dtcDtUp, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(lblHrUp))
                                                                        .addGroup(pnlChargeLayout.createSequentialGroup()
                                                                                .addComponent(dtcDtOf, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(lblHrOf)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtCnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(txtHrUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(txtHrOf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(spnTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(txtLitter)))
                                                        .addComponent(txtDriver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cbxProduct, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cbxProvider, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cbxTank, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cbxLabCar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(pnlChargeLayout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(54, 54, 54)
                                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(58, 58, 58)
                                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(50, 50, 50))
        );
        pnlChargeLayout.setVerticalGroup(
                pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlChargeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblHrOf)
                                                .addComponent(txtHrOf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pnlChargeLayout.createSequentialGroup()
                                                .addComponent(lblTitle)
                                                .addGap(30, 30, 30)
                                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblProvider)
                                                        .addComponent(cbxProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblDtOf)
                                                        .addComponent(dtcDtOf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNote)
                                        .addComponent(lblTicket)
                                        .addComponent(spnNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(spnTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblBoard)
                                        .addComponent(txtBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblCnh)
                                        .addComponent(txtCnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(pnlChargeLayout.createSequentialGroup()
                                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblDriver)
                                                        .addComponent(txtDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblDtUp)
                                                        .addComponent(dtcDtUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblHrUp)
                                                .addComponent(txtHrUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblProduct)
                                        .addComponent(cbxProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblLabCar)
                                        .addComponent(cbxLabCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblBurden)
                                        .addComponent(txtBurden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblLitter)
                                        .addComponent(txtLitter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblTank)
                                        .addComponent(cbxTank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlChargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47))
        );

        rollCharge.setViewportView(pnlCharge);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rollCharge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rollCharge, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBoardFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBoardFocusLost
        txtBoard.setText(txtBoard.getText().toUpperCase());
    }//GEN-LAST:event_txtBoardFocusLost

    private void txtCnhKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCnhKeyTyped
        NumberField.txtNumberInt(evt);
    }//GEN-LAST:event_txtCnhKeyTyped

    private void txtCnhFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCnhFocusLost
        driver = new RequestDriver().selectCnh(txtCnh.getText());
        if (driver != null) {
            driverEmpty = false;
            txtDriver.setText(driver.getNameDriver());
        }
    }//GEN-LAST:event_txtCnhFocusLost

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (new TreatmentTxt().isTxtVoid(pnlCharge) && new TreatmentCbx().isCbxVoid(pnlCharge) && new TreatmentSpn().isSpnVoid(pnlCharge) && new TreatmentDtc().isDtcVoid(pnlCharge)) {
            if (driverEmpty) {
                new TreatmentDriver().saveDriver(txtDriver, txtCnh);
                driver = new RequestDriver().selectCnh(txtCnh.getText());
            }
            new TreatmentCharge().saveChage(pnlCharge, cbxProvider, dtcDtOf, txtHrOf, spnNote, spnTicket, txtBoard, driver, dtcDtUp, txtHrUp, cbxProduct, cbxLabCar, txtBurden, txtLitter, cbxTank);
        } else {
            new EmptyField().showMsg();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        new TreatmentCharge().clear(pnlCharge);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtBurdenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBurdenKeyTyped
        NumberField.txtNumberInt(evt);
    }//GEN-LAST:event_txtBurdenKeyTyped

    private void txtBurdenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBurdenFocusLost
        System.out.println(!txtBurden.getText().equals(""));
        System.out.println(txtBurden.getText());
        if (cbxLabCar.getSelectedIndex() > 0 && !txtBurden.getText().equals("")) {
            int litter = new TreatmentCharge().calcLitter(cbxLabCar.getSelectedItem(), Integer.parseInt((txtBurden.getText())));
            txtLitter.setText(String.valueOf(litter));
        }
    }//GEN-LAST:event_txtBurdenFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Object> cbxLabCar;
    private javax.swing.JComboBox<Object> cbxProduct;
    private javax.swing.JComboBox<Object> cbxProvider;
    private javax.swing.JComboBox<Object> cbxTank;
    private com.toedter.calendar.JDateChooser dtcDtOf;
    private com.toedter.calendar.JDateChooser dtcDtUp;
    private javax.swing.JLabel lblBoard;
    private javax.swing.JLabel lblBurden;
    private javax.swing.JLabel lblCnh;
    private javax.swing.JLabel lblDriver;
    private javax.swing.JLabel lblDtOf;
    private javax.swing.JLabel lblDtUp;
    private javax.swing.JLabel lblHrOf;
    private javax.swing.JLabel lblHrUp;
    private javax.swing.JLabel lblLabCar;
    private javax.swing.JLabel lblLitter;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lblProduct;
    private javax.swing.JLabel lblProvider;
    private javax.swing.JLabel lblTank;
    private javax.swing.JLabel lblTicket;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlCharge;
    private javax.swing.JScrollPane rollCharge;
    private javax.swing.JSpinner spnNote;
    private javax.swing.JSpinner spnTicket;
    private javax.swing.JTextField txtBoard;
    private javax.swing.JFormattedTextField txtBurden;
    private javax.swing.JFormattedTextField txtCnh;
    private javax.swing.JTextField txtDriver;
    private javax.swing.JFormattedTextField txtHrOf;
    private javax.swing.JFormattedTextField txtHrUp;
    private javax.swing.JTextField txtLitter;
    // End of variables declaration//GEN-END:variables

}
