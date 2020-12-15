package dev.senzalla.rectify.canvas;

import dev.senzalla.theme.TreatmentTheme;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class FrmAbout extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmLabTqTbl
     */
    public FrmAbout() {
        initComponents();
        TreatmentTheme.initTheme(pnlAbout);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAbout = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblProgramming = new javax.swing.JLabel();
        txtProgramming = new javax.swing.JLabel();
        lblVersion = new javax.swing.JLabel();
        txtVersion = new javax.swing.JLabel();
        lblFactory = new javax.swing.JLabel();
        txtFactory = new javax.swing.JLabel();
        lblDeveloper = new javax.swing.JLabel();
        txtDeveloper = new javax.swing.JLabel();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(598, 460));
        setMinimumSize(new java.awt.Dimension(598, 460));
        setPreferredSize(new java.awt.Dimension(598, 460));

        pnlAbout.setMaximumSize(new java.awt.Dimension(596, 438));
        pnlAbout.setMinimumSize(new java.awt.Dimension(596, 438));
        pnlAbout.setPreferredSize(new java.awt.Dimension(596, 438));

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblTitle.setText("Sobre");

        lblProgramming.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblProgramming.setText("Programa:");

        txtProgramming.setFont(new java.awt.Font("Bauhaus 93", 0, 18)); // NOI18N
        txtProgramming.setText("Bio Retifica");

        lblVersion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblVersion.setText("Versão:");

        txtVersion.setFont(new java.awt.Font("Bauhaus 93", 0, 18)); // NOI18N
        txtVersion.setText("2.0");

        lblFactory.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblFactory.setText("Empresa:");

        txtFactory.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        txtFactory.setText("Senzalla Technology");

        lblDeveloper.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblDeveloper.setText("Desenvolvedor:");

        txtDeveloper.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        txtDeveloper.setText("Bomsalvez Freitas");

        javax.swing.GroupLayout pnlAboutLayout = new javax.swing.GroupLayout(pnlAbout);
        pnlAbout.setLayout(pnlAboutLayout);
        pnlAboutLayout.setHorizontalGroup(
            pnlAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAboutLayout.createSequentialGroup()
                .addGroup(pnlAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAboutLayout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(lblTitle))
                    .addGroup(pnlAboutLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(pnlAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAboutLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(lblProgramming)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProgramming))
                            .addGroup(pnlAboutLayout.createSequentialGroup()
                                .addGroup(pnlAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblVersion)
                                    .addComponent(lblFactory)
                                    .addComponent(lblDeveloper))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFactory)
                                    .addComponent(txtDeveloper)
                                    .addComponent(txtVersion))))))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        pnlAboutLayout.setVerticalGroup(
            pnlAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAboutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(78, 78, 78)
                .addGroup(pnlAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProgramming)
                    .addComponent(txtProgramming, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnlAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVersion)
                    .addComponent(txtVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnlAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFactory)
                    .addComponent(txtFactory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeveloper)
                    .addComponent(txtDeveloper))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAbout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAbout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDeveloper;
    private javax.swing.JLabel lblFactory;
    private javax.swing.JLabel lblProgramming;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JPanel pnlAbout;
    private javax.swing.JLabel txtDeveloper;
    private javax.swing.JLabel txtFactory;
    private javax.swing.JLabel txtProgramming;
    private javax.swing.JLabel txtVersion;
    // End of variables declaration//GEN-END:variables

}
