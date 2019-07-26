/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.biblioteca.vistas;

/**
 *
 * @author Adriel
 */
public class JFRegister extends javax.swing.JFrame {

    /**
     * Creates new form JFRegistro
     */
    public JFRegister() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        cmbTipo = new javax.swing.JComboBox<>();
        txtContraseña = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        txtDia = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersona = new javax.swing.JTable();
        lblNombre1 = new javax.swing.JLabel();
        lblNombre2 = new javax.swing.JLabel();
        lblNombre3 = new javax.swing.JLabel();
        lblNombre4 = new javax.swing.JLabel();
        lblNombre5 = new javax.swing.JLabel();
        lblNombre6 = new javax.swing.JLabel();
        lblNombre7 = new javax.swing.JLabel();
        lblNombre8 = new javax.swing.JLabel();
        lblNombre9 = new javax.swing.JLabel();
        lblNombre10 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        app_Tittle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Delete_45px.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setOpaque(false);
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 560, -1, -1));

        btnModificar.setBackground(new java.awt.Color(204, 204, 204));
        btnModificar.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Edit_45px.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setOpaque(false);
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 560, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardar.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Checkmark_45px.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setOpaque(false);
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 560, -1, -1));

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "bibliotecario", "estudiante" }));
        jPanel1.add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 200, 30));

        txtContraseña.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        txtContraseña.setBorder(null);
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 200, 30));

        txtUsuario.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        txtUsuario.setBorder(null);
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 200, 30));

        txtDireccion.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        txtDireccion.setBorder(null);
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 200, 30));

        txtTelefono.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        txtTelefono.setBorder(null);
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 200, 30));

        txtAno.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        txtAno.setBorder(null);
        jPanel1.add(txtAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 50, 30));

        txtMes.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        txtMes.setBorder(null);
        jPanel1.add(txtMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 50, 30));

        txtDia.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        txtDia.setBorder(null);
        jPanel1.add(txtDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 50, 30));

        txtApellido2.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        txtApellido2.setBorder(null);
        jPanel1.add(txtApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 200, 30));

        txtApellido1.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        txtApellido1.setBorder(null);
        jPanel1.add(txtApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 200, 30));

        txtNombre.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        txtNombre.setBorder(null);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 200, 30));

        txtId.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        txtId.setBorder(null);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 200, 30));

        tblPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido 1", "Apellido 2", "Fecha_Nac", "Telefono", "Direccion", "Usuario", "Contraseña", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPersona);
        if (tblPersona.getColumnModel().getColumnCount() > 0) {
            tblPersona.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 1030, 390));

        lblNombre1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        lblNombre1.setText("Tipo de usuario:");
        lblNombre1.setToolTipText("");
        jPanel1.add(lblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, -1, 30));

        lblNombre2.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        lblNombre2.setText("Id:");
        lblNombre2.setToolTipText("");
        jPanel1.add(lblNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, 30));

        lblNombre3.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        lblNombre3.setText("Nombre:");
        lblNombre3.setToolTipText("");
        jPanel1.add(lblNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 30));

        lblNombre4.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        lblNombre4.setText("Apellido Paterno:");
        lblNombre4.setToolTipText("");
        jPanel1.add(lblNombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, 30));

        lblNombre5.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        lblNombre5.setText("Apellido Materno:");
        lblNombre5.setToolTipText("");
        jPanel1.add(lblNombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, 30));

        lblNombre6.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        lblNombre6.setText("Fecha:");
        lblNombre6.setToolTipText("");
        jPanel1.add(lblNombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, 30));

        lblNombre7.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        lblNombre7.setText("Teléfono:");
        lblNombre7.setToolTipText("");
        jPanel1.add(lblNombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, 30));

        lblNombre8.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        lblNombre8.setText("Dirección:");
        lblNombre8.setToolTipText("");
        jPanel1.add(lblNombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 80, 30));

        lblNombre9.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        lblNombre9.setText("Usuario:");
        lblNombre9.setToolTipText("");
        jPanel1.add(lblNombre9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, 30));

        lblNombre10.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        lblNombre10.setText("Contraseña:");
        lblNombre10.setToolTipText("");
        jPanel1.add(lblNombre10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Name_Tag_35px.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 40, 50));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_ID_Verified_35px.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 40, 50));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Hitbox_35px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 40, 50));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Insulin_Pen_35px.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 40, 50));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Ball_Point_Pen_35px.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 40, 50));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Pay_Date_35px.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 40, 50));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Telephone_35px.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 40, 50));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Address_35px.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 40, 50));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_User_Male_35px.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 40, 50));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Lock_35px.png"))); // NOI18N
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 40, 50));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 50, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 200, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 200, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 200, 10));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 200, 10));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 200, 10));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 200, 10));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 200, 10));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 200, 10));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 50, 10));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 50, 10));

        jPanel2.setBackground(new java.awt.Color(130, 204, 171));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        app_Tittle.setBackground(new java.awt.Color(255, 255, 255));
        app_Tittle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 30)); // NOI18N
        app_Tittle.setText("Registro de usuarios:");
        jPanel2.add(app_Tittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 320, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_User_Male_Skin_Type_4_65px.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 82, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel app_Tittle;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    public javax.swing.JLabel lblNombre1;
    public javax.swing.JLabel lblNombre10;
    public javax.swing.JLabel lblNombre2;
    public javax.swing.JLabel lblNombre3;
    public javax.swing.JLabel lblNombre4;
    public javax.swing.JLabel lblNombre5;
    public javax.swing.JLabel lblNombre6;
    public javax.swing.JLabel lblNombre7;
    public javax.swing.JLabel lblNombre8;
    public javax.swing.JLabel lblNombre9;
    public javax.swing.JTable tblPersona;
    public javax.swing.JTextField txtAno;
    public javax.swing.JTextField txtApellido1;
    public javax.swing.JTextField txtApellido2;
    public javax.swing.JTextField txtContraseña;
    public javax.swing.JTextField txtDia;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtMes;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelefono;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
