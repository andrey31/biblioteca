package com.biblioteca.biblioteca.vistas;

public class JFDevoluciones extends javax.swing.JFrame {

    public JFDevoluciones() {
        initComponents();

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
        btnEditar = new javax.swing.JButton();
        pnActualizar = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Monto de multa");
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        tbTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "FechaPropuesta", "Fecha", "Multa", "Prestamo"
            }
        ));
        jScrollPane1.setViewportView(tbTabla);
        tbTabla.getAccessibleContext().setAccessibleName("");

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 550, 460));

        jLabel2.setText("Fecha de devolución");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        txtFechaProp.setEditable(false);
        jPanel1.add(txtFechaProp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 230, -1));

        txtMulta.setText("0");
        txtMulta.setBorder(null);
        jPanel1.add(txtMulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 230, 30));

        jLabel3.setText("Fecha propuesta");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 230, 10));

        btnIngresar.setText("Ingresar devolución");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 150, 50));
        jPanel1.add(dtpFechaDev, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 230, -1));

        lbIdPrestamo.setBackground(new java.awt.Color(255, 255, 255));
        lbIdPrestamo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbIdPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 30, 30));

        lbError.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbError.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(lbError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 320, 30));

        pnEditar.setBackground(new java.awt.Color(255, 255, 255));
        pnEditar.setForeground(new java.awt.Color(255, 255, 255));
        pnEditar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEditar.setText("Editar devolución");
        pnEditar.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 50));

        jPanel1.add(pnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 170, 70));

        pnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        pnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        pnActualizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnActualizar.setText("Actualizar devolución");
        pnActualizar.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 50));

        jPanel1.add(pnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 180, 70));

        btnEliminar.setText("Eliminar");
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 150, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed

    }//GEN-LAST:event_btnIngresarActionPerformed

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
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnIngresar;
    public com.github.lgooddatepicker.components.DatePicker dtpFechaDev;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel lbError;
    public javax.swing.JLabel lbIdPrestamo;
    public javax.swing.JPanel pnActualizar;
    public javax.swing.JPanel pnEditar;
    public javax.swing.JTable tbTabla;
    public javax.swing.JTextField txtFechaProp;
    public javax.swing.JTextField txtMulta;
    // End of variables declaration//GEN-END:variables

}
