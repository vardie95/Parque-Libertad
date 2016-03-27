/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Estadisticas;

import Interfaz.Consultas.*;

/**
 *
 * @author Luis Diego
 */
public class EstadisticaFecha extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaFecha
     */
    public EstadisticaFecha() {
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

        PT_FechaInicio = new javax.swing.JFormattedTextField();
        PT_FechaFinal = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BT_Analizar = new javax.swing.JButton();
        BT_Atras = new javax.swing.JButton();
        Titulo_Menu = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 125));
        setMinimumSize(new java.awt.Dimension(340, 260));
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(PT_FechaInicio);
        PT_FechaInicio.setBounds(150, 50, 70, 20);

        PT_FechaFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PT_FechaFinalActionPerformed(evt);
            }
        });
        getContentPane().add(PT_FechaFinal);
        PT_FechaFinal.setBounds(150, 80, 70, 20);

        jLabel1.setText("Fecha Inicio: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 50, 90, 20);

        jLabel2.setText("Fecha Final: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 80, 80, 20);

        BT_Analizar.setText("Analizar");
        BT_Analizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_AnalizarActionPerformed(evt);
            }
        });
        getContentPane().add(BT_Analizar);
        BT_Analizar.setBounds(240, 60, 80, 34);

        BT_Atras.setText("Atrás");
        BT_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_AtrasActionPerformed(evt);
            }
        });
        getContentPane().add(BT_Atras);
        BT_Atras.setBounds(10, 190, 78, 23);

        Titulo_Menu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Titulo_Menu.setText("Estadística por Fecha");
        getContentPane().add(Titulo_Menu);
        Titulo_Menu.setBounds(70, 10, 200, 22);

        jLabel3.setText("Cantidad de personas:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 140, 140, 14);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(160, 140, 40, 20);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Imagen1.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 340, 230);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PT_FechaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PT_FechaFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PT_FechaFinalActionPerformed

    private void BT_AnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_AnalizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BT_AnalizarActionPerformed

    private void BT_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_AtrasActionPerformed
        // TODO add your handling code here:
        new MenuEstadisticaPersona().setVisible(true);
        dispose();
    }//GEN-LAST:event_BT_AtrasActionPerformed

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
            java.util.logging.Logger.getLogger(EstadisticaFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstadisticaFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstadisticaFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstadisticaFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstadisticaFecha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Analizar;
    private javax.swing.JButton BT_Atras;
    private javax.swing.JFormattedTextField PT_FechaFinal;
    private javax.swing.JFormattedTextField PT_FechaInicio;
    private javax.swing.JLabel Titulo_Menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
