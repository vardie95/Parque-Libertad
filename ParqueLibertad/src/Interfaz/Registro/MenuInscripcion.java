/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Registro;

import Interfaz.*;
import Interfaz.Registro.RegistroClase;
import Interfaz.Registro.RegistroDesercion;
import Interfaz.Registro.RegistroEmpleado;
import Interfaz.Registro.RegistroEvento;
import Interfaz.Menu;
import Interfaz.Registro.RegistroActividad;
import Interfaz.Registro.RegistroClase;

/**
 *
 * @author Luis Diego
 */
public class MenuInscripcion extends javax.swing.JFrame {

    /**
     * Creates new form MenuRegistro
     */
    public MenuInscripcion() {
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

        jButton1 = new javax.swing.JButton();
        Titulo_Registro = new javax.swing.JLabel();
        B_Persona = new javax.swing.JButton();
        B_Clase = new javax.swing.JButton();
        B_Atras = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 125));
        setMinimumSize(new java.awt.Dimension(340, 320));
        getContentPane().setLayout(null);

        Titulo_Registro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Titulo_Registro.setText("Inscripción");
        getContentPane().add(Titulo_Registro);
        Titulo_Registro.setBounds(130, 20, 100, 22);

        B_Persona.setText("Actividad");
        B_Persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_PersonaActionPerformed(evt);
            }
        });
        getContentPane().add(B_Persona);
        B_Persona.setBounds(110, 80, 110, 50);

        B_Clase.setText("Clase");
        B_Clase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ClaseActionPerformed(evt);
            }
        });
        getContentPane().add(B_Clase);
        B_Clase.setBounds(110, 170, 110, 50);

        B_Atras.setText("Atrás");
        B_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_AtrasActionPerformed(evt);
            }
        });
        getContentPane().add(B_Atras);
        B_Atras.setBounds(10, 10, 70, 23);

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Imagen1.png"))); // NOI18N
        getContentPane().add(Fondo);
        Fondo.setBounds(-40, 0, 370, 290);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_PersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_PersonaActionPerformed
        // TODO add your handling code here:
        dispose();
        new InscripcionActividad().setVisible(true);
    }//GEN-LAST:event_B_PersonaActionPerformed

    private void B_ClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ClaseActionPerformed
        // TODO add your handling code here:
        new InscripcionClase().setVisible(true);
        dispose();
    }//GEN-LAST:event_B_ClaseActionPerformed

    private void B_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_AtrasActionPerformed
        // TODO add your handling code here:
        dispose();
        new MenuRegistro().setVisible(true);
    }//GEN-LAST:event_B_AtrasActionPerformed

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
            java.util.logging.Logger.getLogger(MenuInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuInscripcion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Atras;
    private javax.swing.JButton B_Clase;
    private javax.swing.JButton B_Persona;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Titulo_Registro;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}