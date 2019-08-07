package com.biblioteca.biblioteca.vistas;

public class JFDevoluciones extends javax.swing.JFrame {

    public JFDevoluciones() {
        initComponents();
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtFechaProp = new javax.swing.JTextField();
        txtMulta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnIngresar = new javax.swing.JButton();
        dtpFechaDev = new com.github.lgooddatepicker.components.DatePicker();
        lbIdPrestamo = new javax.swing.JLabel();
        lbError = new javax.swing.JLabel();
        pnEditar = new javax.swing.JPanel();
        pnActualizar = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnActualizar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Subtittle_2 = new javax.swing.JLabel();
        btnregreso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Paper_Money_35px.png"))); // NOI18N
        jLabel1.setText("Monto de multa:");
        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 160, -1));

        tbTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "FechaPropuesta", "Fecha", "Multa", "Prestamo"
            }
        ));
        jScrollPane1.setViewportView(tbTabla);
        tbTabla.getAccessibleContext().setAccessibleName("");

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 550, 460));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Pay_Date_35px.png"))); // NOI18N
        jLabel2.setText("Fecha de devolución:");
        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        txtFechaProp.setEditable(false);
        txtFechaProp.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaProp.setBorder(null);
        jPanel1.add(txtFechaProp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 230, 20));

        txtMulta.setText("0");
        txtMulta.setBorder(null);
        jPanel1.add(txtMulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 230, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Pay_Date_35px.png"))); // NOI18N
        jLabel3.setText("Fecha propuesta:");
        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 230, 10));

        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Add_Book_35px.png"))); // NOI18N
        btnIngresar.setText("Ingresar devolución");
        btnIngresar.setFont(new java.awt.Font("Calibri Light", 0, 13)); // NOI18N
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 180, 40));
        jPanel1.add(dtpFechaDev, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 230, -1));

        lbIdPrestamo.setBackground(new java.awt.Color(255, 255, 255));
        lbIdPrestamo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbIdPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 30, 30));

        lbError.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbError.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(lbError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 320, 30));

        pnEditar.setBackground(new java.awt.Color(255, 255, 255));
        pnEditar.setForeground(new java.awt.Color(255, 255, 255));
        pnEditar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(pnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 170, 70));

        pnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        pnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        pnActualizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(pnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 180, 70));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Delete_45px.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFont(new java.awt.Font("Calibri Light", 0, 13)); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 180, 40));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 230, 20));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Refresh_45px.png"))); // NOI18N
        btnActualizar.setText("Actualizar devolución");
        btnActualizar.setFont(new java.awt.Font("Calibri Light", 0, 13)); // NOI18N
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 180, 50));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Edit_45px.png"))); // NOI18N
        btnEditar.setText("Editar devolución");
        btnEditar.setFont(new java.awt.Font("Calibri Light", 0, 13)); // NOI18N
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, 180, 50));

        jPanel2.setBackground(new java.awt.Color(130, 204, 171));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Subtittle_2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 30)); // NOI18N
        Subtittle_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Refresh_45px.png"))); // NOI18N
        Subtittle_2.setText("Devoluciones:");
        jPanel2.add(Subtittle_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        btnregreso.setText("Regresar al menu principal");
        btnregreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresoActionPerformed(evt);
            }
        });
        jPanel1.add(btnregreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 570, 180, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed

    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnregresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresoActionPerformed
       JFMenuPrincipal m = new JFMenuPrincipal();
       m.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnregresoActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFDevoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFDevoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFDevoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFDevoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFDevoluciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Subtittle_2;
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnregreso;
    public com.github.lgooddatepicker.components.DatePicker dtpFechaDev;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JLabel lbError;
    public javax.swing.JLabel lbIdPrestamo;
    public javax.swing.JPanel pnActualizar;
    public javax.swing.JPanel pnEditar;
    public javax.swing.JTable tbTabla;
    public javax.swing.JTextField txtFechaProp;
    public javax.swing.JTextField txtMulta;
    // End of variables declaration//GEN-END:variables

}
