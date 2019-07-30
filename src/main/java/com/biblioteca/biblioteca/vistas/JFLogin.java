/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.biblioteca.vistas;

import java.awt.Color;

/**
 *
 * @author Adriel
 */
public class JFLogin extends javax.swing.JFrame {

    /**
     * Creates new form JFLogin
     */
    public JFLogin() {
        initComponents();
        btnIniciar.setOpaque(true);
        btnIniciar.setBackground(new Color(130, 204, 171));
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Login = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnMnimizar = new javax.swing.JButton();
        btnMaximizar = new javax.swing.JButton();
        Subtittle_3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtUsuario = new javax.swing.JTextField();
        lblErrorUsu = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        lblErrorContra = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnIniciar = new javax.swing.JButton();
        Panel_Info = new javax.swing.JPanel();
        app_Tittle = new javax.swing.JLabel();
        Icon = new javax.swing.JLabel();
        Subtitulo_1 = new javax.swing.JLabel();
        Subtittle_2 = new javax.swing.JLabel();
        Verso_1 = new javax.swing.JLabel();
        Verso_2 = new javax.swing.JLabel();
        Verso_3 = new javax.swing.JLabel();
        Verso_4 = new javax.swing.JLabel();
        Verso_5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Login.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setText("Salir");
        Panel_Login.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(743, 142, -1, -1));

        btnMnimizar.setText("Minimizar");
        Panel_Login.add(btnMnimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 142, -1, -1));

        btnMaximizar.setText("Restaurar");
        Panel_Login.add(btnMaximizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 142, -1, -1));

        Subtittle_3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 30)); // NOI18N
        Subtittle_3.setForeground(new java.awt.Color(130, 204, 171));
        Subtittle_3.setText("Inicio de Sesión");
        Panel_Login.add(Subtittle_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));
        Panel_Login.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 280, 20));
        Panel_Login.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 280, 20));

        txtUsuario.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        txtUsuario.setBorder(null);
        Panel_Login.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 270, 50));

        lblErrorUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblErrorUsu.setForeground(new java.awt.Color(255, 102, 102));
        lblErrorUsu.setText("Error");
        Panel_Login.add(lblErrorUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        txtContraseña.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtContraseña.setBorder(null);
        Panel_Login.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 270, 50));

        lblErrorContra.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblErrorContra.setForeground(new java.awt.Color(255, 102, 102));
        lblErrorContra.setText("Error");
        Panel_Login.add(lblErrorContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_User_Male_35px.png"))); // NOI18N
        Panel_Login.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Lock_35px.png"))); // NOI18N
        Panel_Login.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 30, 40));

        jSeparator3.setBackground(new java.awt.Color(130, 204, 171));
        Panel_Login.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 230, 20));

        btnIniciar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("Iniciar Sesión");
        Panel_Login.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 260, 50));

        getContentPane().add(Panel_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 400, 600));

        Panel_Info.setBackground(new java.awt.Color(130, 204, 171));
        Panel_Info.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        app_Tittle.setBackground(new java.awt.Color(255, 255, 255));
        app_Tittle.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 28)); // NOI18N
        app_Tittle.setForeground(new java.awt.Color(255, 255, 255));
        app_Tittle.setText("Biblioteca Virtual");
        Panel_Info.add(app_Tittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 230, 60));

        Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_E-Learning_65px.png"))); // NOI18N
        Panel_Info.add(Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 63));

        Subtitulo_1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 30)); // NOI18N
        Subtitulo_1.setForeground(new java.awt.Color(255, 255, 255));
        Subtitulo_1.setText("Biblioteca virtual!");
        Panel_Info.add(Subtitulo_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        Subtittle_2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 30)); // NOI18N
        Subtittle_2.setForeground(new java.awt.Color(255, 255, 255));
        Subtittle_2.setText("¡Bienvenido(a), a la");
        Panel_Info.add(Subtittle_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        Verso_1.setBackground(new java.awt.Color(255, 255, 255));
        Verso_1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 20)); // NOI18N
        Verso_1.setForeground(new java.awt.Color(255, 255, 255));
        Verso_1.setText("\"Como bibliotecario podrás");
        Panel_Info.add(Verso_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 280, 40));

        Verso_2.setBackground(new java.awt.Color(255, 255, 255));
        Verso_2.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 20)); // NOI18N
        Verso_2.setForeground(new java.awt.Color(255, 255, 255));
        Verso_2.setText("manejar préstamos y devoluciones");
        Panel_Info.add(Verso_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 320, 40));

        Verso_3.setBackground(new java.awt.Color(255, 255, 255));
        Verso_3.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 20)); // NOI18N
        Verso_3.setForeground(new java.awt.Color(255, 255, 255));
        Verso_3.setText("de libros, cobros por los mismos,");
        Panel_Info.add(Verso_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 300, 40));

        Verso_4.setBackground(new java.awt.Color(255, 255, 255));
        Verso_4.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 20)); // NOI18N
        Verso_4.setForeground(new java.awt.Color(255, 255, 255));
        Verso_4.setText("funcionalidades incluidas.\"");
        Panel_Info.add(Verso_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 300, 40));

        Verso_5.setBackground(new java.awt.Color(255, 255, 255));
        Verso_5.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 20)); // NOI18N
        Verso_5.setForeground(new java.awt.Color(255, 255, 255));
        Verso_5.setText("manejar el inventario entre otras");
        Panel_Info.add(Verso_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 300, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Topup_Payment_65px.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        Panel_Info.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 70, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Accounting_65px.png"))); // NOI18N
        jLabel2.setText("jLabel1");
        Panel_Info.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 70, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Move_Stock_65px.png"))); // NOI18N
        jLabel3.setText("jLabel1");
        Panel_Info.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 70, 80));

        getContentPane().add(Panel_Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 600));

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
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Icon;
    private javax.swing.JPanel Panel_Info;
    private javax.swing.JPanel Panel_Login;
    private javax.swing.JLabel Subtittle_2;
    private javax.swing.JLabel Subtittle_3;
    private javax.swing.JLabel Subtitulo_1;
    private javax.swing.JLabel Verso_1;
    private javax.swing.JLabel Verso_2;
    private javax.swing.JLabel Verso_3;
    private javax.swing.JLabel Verso_4;
    private javax.swing.JLabel Verso_5;
    private javax.swing.JLabel app_Tittle;
    public javax.swing.JButton btnIniciar;
    public javax.swing.JButton btnMaximizar;
    public javax.swing.JButton btnMnimizar;
    public javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public javax.swing.JLabel lblErrorContra;
    public javax.swing.JLabel lblErrorUsu;
    public javax.swing.JPasswordField txtContraseña;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
