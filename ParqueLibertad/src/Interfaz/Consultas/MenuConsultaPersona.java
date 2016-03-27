/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Consultas;

import Interfaz.*;

/**
 *
 * @author Luis Diego
 */
public class MenuConsultaPersona extends javax.swing.JFrame {
    

    /**
     * Creates new form MenuRegistro
     */
    public MenuConsultaPersona() {
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
        BT_Fecha = new javax.swing.JButton();
        BT_Decerta = new javax.swing.JButton();
        BT_Lugar = new javax.swing.JButton();
        BT_Nombre = new javax.swing.JButton();
        BT_identificacion = new javax.swing.JButton();
        Titulo_Menu = new javax.swing.JLabel();
        BT_Atras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 125));
        setMinimumSize(new java.awt.Dimension(360, 360));
        getContentPane().setLayout(null);

        BT_Fecha.setText("Fecha");
        BT_Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_FechaActionPerformed(evt);
            }
        });
        getContentPane().add(BT_Fecha);
        BT_Fecha.setBounds(70, 160, 110, 40);

        BT_Decerta.setText("Desercción");
        BT_Decerta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_DecertaActionPerformed(evt);
            }
        });
        getContentPane().add(BT_Decerta);
        BT_Decerta.setBounds(130, 220, 120, 40);

        BT_Lugar.setText("Lugar");
        BT_Lugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_LugarActionPerformed(evt);
            }
        });
        getContentPane().add(BT_Lugar);
        BT_Lugar.setBounds(210, 160, 110, 40);

        BT_Nombre.setText("Nombre");
        BT_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_NombreActionPerformed(evt);
            }
        });
        getContentPane().add(BT_Nombre);
        BT_Nombre.setBounds(70, 100, 110, 40);

        BT_identificacion.setText("Identificación");
        BT_identificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_identificacionActionPerformed(evt);
            }
        });
        getContentPane().add(BT_identificacion);
        BT_identificacion.setBounds(210, 100, 110, 40);

        Titulo_Menu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Titulo_Menu.setText("Consulta Personas");
        getContentPane().add(Titulo_Menu);
        Titulo_Menu.setBounds(110, 50, 200, 22);

        BT_Atras.setText("Atras");
        BT_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_AtrasActionPerformed(evt);
            }
        });
        getContentPane().add(BT_Atras);
        BT_Atras.setBounds(10, 10, 70, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Imagen1.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 370, 320);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BT_FechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_FechaActionPerformed
        // TODO add your handling code here:
        new ConsultaFecha().setVisible(true);
        dispose();
    }//GEN-LAST:event_BT_FechaActionPerformed

    private void BT_DecertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_DecertaActionPerformed
        // TODO add your handling code here:
        new ConsultaDesertaPersona().setVisible(true);
        dispose();
    }//GEN-LAST:event_BT_DecertaActionPerformed

    private void BT_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_NombreActionPerformed
        // TODO add your handling code here:
        new ConsultaNombre().setVisible(true);
        dispose();
    }//GEN-LAST:event_BT_NombreActionPerformed

    private void BT_LugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_LugarActionPerformed
        // TODO add your handling code here:
        new ConsultaLugarPersona().setVisible(true);
        dispose();
    }//GEN-LAST:event_BT_LugarActionPerformed

    private void BT_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_AtrasActionPerformed
        // TODO add your handling code here:
        new MenuConsulta().setVisible(true);
        dispose();
    }//GEN-LAST:event_BT_AtrasActionPerformed

    private void BT_identificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_identificacionActionPerformed
        // TODO add your handling code here:
        new ConsultaIndentificacionPersona().setVisible(true);
        dispose();
    }//GEN-LAST:event_BT_identificacionActionPerformed

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
            java.util.logging.Logger.getLogger(MenuConsultaPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuConsultaPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuConsultaPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuConsultaPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuConsultaPersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Atras;
    private javax.swing.JButton BT_Decerta;
    private javax.swing.JButton BT_Fecha;
    private javax.swing.JButton BT_Lugar;
    private javax.swing.JButton BT_Nombre;
    private javax.swing.JButton BT_identificacion;
    private javax.swing.JLabel Titulo_Menu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
