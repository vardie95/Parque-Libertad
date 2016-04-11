/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Diego
 */
public class Inicio extends javax.swing.JFrame {
    Connection con= null;
    
    /**
     * Creates new form Inicio
     */
    public Inicio() {
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

        B_Ingresar = new javax.swing.JButton();
        TF_Usuario = new javax.swing.JTextField();
        PF_Contraseña = new javax.swing.JPasswordField();
        L_Usuario = new javax.swing.JLabel();
        L_Contraseña = new javax.swing.JLabel();
        BT_Cancelar = new javax.swing.JButton();
        Titulo_Menu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parque Libertad");
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(490, 160));
        setMinimumSize(new java.awt.Dimension(500, 390));
        setName("Login"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        B_Ingresar.setText("Ingresar");
        B_Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_IngresarActionPerformed(evt);
            }
        });
        getContentPane().add(B_Ingresar);
        B_Ingresar.setBounds(240, 290, 90, 30);
        getContentPane().add(TF_Usuario);
        TF_Usuario.setBounds(280, 200, 170, 29);
        getContentPane().add(PF_Contraseña);
        PF_Contraseña.setBounds(280, 250, 170, 28);

        L_Usuario.setText("Usuario: ");
        getContentPane().add(L_Usuario);
        L_Usuario.setBounds(200, 210, 60, 14);

        L_Contraseña.setText("Contraseña:");
        getContentPane().add(L_Contraseña);
        L_Contraseña.setBounds(200, 260, 70, 14);

        BT_Cancelar.setText("Cancelar");
        BT_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_CancelarActionPerformed(evt);
            }
        });
        getContentPane().add(BT_Cancelar);
        BT_Cancelar.setBounds(360, 290, 90, 30);

        Titulo_Menu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Titulo_Menu.setText("Bienvenido ");
        getContentPane().add(Titulo_Menu);
        Titulo_Menu.setBounds(290, 150, 150, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/login.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 510, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_IngresarActionPerformed
        // TODO add your handling code here:
        String usuario= TF_Usuario.getText();
        String password= PF_Contraseña.getText();
        if (usuario.equals("libertad") && password.equals("parque")) {
            new Interfaz.Registro.RegistroPersonas().setVisible(true);
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();   
        }else{
            JOptionPane.showMessageDialog(this, "Contraseña Incorrecta","El usuario o la contraseña son invalidos",JOptionPane.ERROR_MESSAGE);
            
        }
        
    }//GEN-LAST:event_B_IngresarActionPerformed

    private void BT_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_CancelarActionPerformed
        // TODO add your handling code here:
        TF_Usuario.setText("");
        PF_Contraseña.setText("");
    }//GEN-LAST:event_BT_CancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Cancelar;
    private javax.swing.JButton B_Ingresar;
    private javax.swing.JLabel L_Contraseña;
    private javax.swing.JLabel L_Usuario;
    private javax.swing.JPasswordField PF_Contraseña;
    private javax.swing.JTextField TF_Usuario;
    private javax.swing.JLabel Titulo_Menu;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
   
}
