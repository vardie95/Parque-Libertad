/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Consultas;

import Interfaz.Estadisticas.*;
import Interfaz.Consultas.*;

/**
 *
 * @author Luis Diego
 */
public class ConsultaEmpleadoFecha extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaFecha
     */
    public ConsultaEmpleadoFecha() {
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
        jLabel1 = new javax.swing.JLabel();
        BT_Buscar = new javax.swing.JButton();
        BT_Atras = new javax.swing.JButton();
        Titulo_Menu = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 125));
        setMinimumSize(new java.awt.Dimension(530, 420));
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(PT_FechaInicio);
        PT_FechaInicio.setBounds(140, 50, 90, 20);

        jLabel1.setText("Fecha Ingreso: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 50, 100, 20);

        BT_Buscar.setText("Buscar");
        BT_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(BT_Buscar);
        BT_Buscar.setBounds(410, 40, 80, 34);

        BT_Atras.setText("Atrás");
        BT_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_AtrasActionPerformed(evt);
            }
        });
        getContentPane().add(BT_Atras);
        BT_Atras.setBounds(10, 350, 78, 23);

        Titulo_Menu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Titulo_Menu.setText("Consulta Empleado");
        getContentPane().add(Titulo_Menu);
        Titulo_Menu.setBounds(160, 10, 200, 22);

        jTable1.setBackground(new java.awt.Color(204, 255, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido 1", "Apellido 2 ", "Puesto", "Nacionalidad"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 470, 220);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/fondo2.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 520, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BT_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_BuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BT_BuscarActionPerformed

    private void BT_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_AtrasActionPerformed
        // TODO add your handling code here:
        new MenuConsultaEmpleado().setVisible(true);
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
            java.util.logging.Logger.getLogger(ConsultaEmpleadoFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaEmpleadoFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaEmpleadoFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaEmpleadoFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaEmpleadoFecha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Atras;
    private javax.swing.JButton BT_Buscar;
    private javax.swing.JFormattedTextField PT_FechaInicio;
    private javax.swing.JLabel Titulo_Menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
