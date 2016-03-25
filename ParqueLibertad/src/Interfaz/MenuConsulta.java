/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Interfaz.Consultas.ConsultaCurso;
import Interfaz.Consultas.MenuConsultaPersona;

/**
 *
 * @author Luis Diego
 */
public class MenuConsulta extends javax.swing.JFrame {

    /**
     * Creates new form MenuRegistro
     */
    public MenuConsulta() {
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
        B_Atras = new javax.swing.JButton();
        BT_Persona = new javax.swing.JButton();
        BT_Curso = new javax.swing.JButton();
        BT_Evento = new javax.swing.JButton();
        BT_Empleado = new javax.swing.JButton();
        BT_Activdades = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 125));
        setMinimumSize(new java.awt.Dimension(380, 380));
        getContentPane().setLayout(null);

        Titulo_Registro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Titulo_Registro.setText("Consultas");
        getContentPane().add(Titulo_Registro);
        Titulo_Registro.setBounds(130, 40, 100, 20);

        B_Atras.setText("Atrás");
        B_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_AtrasActionPerformed(evt);
            }
        });
        getContentPane().add(B_Atras);
        B_Atras.setBounds(10, 290, 80, 30);

        BT_Persona.setText("Persona");
        BT_Persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_PersonaActionPerformed(evt);
            }
        });
        getContentPane().add(BT_Persona);
        BT_Persona.setBounds(60, 110, 100, 40);

        BT_Curso.setText("Curso");
        BT_Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_CursoActionPerformed(evt);
            }
        });
        getContentPane().add(BT_Curso);
        BT_Curso.setBounds(190, 110, 100, 40);

        BT_Evento.setText("Evento");
        BT_Evento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_EventoActionPerformed(evt);
            }
        });
        getContentPane().add(BT_Evento);
        BT_Evento.setBounds(60, 170, 100, 40);

        BT_Empleado.setText("Empleado");
        getContentPane().add(BT_Empleado);
        BT_Empleado.setBounds(190, 170, 100, 40);

        BT_Activdades.setText("Actividades");
        BT_Activdades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ActivdadesActionPerformed(evt);
            }
        });
        getContentPane().add(BT_Activdades);
        BT_Activdades.setBounds(130, 220, 100, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Imagen1.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 370, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_AtrasActionPerformed
        // TODO add your handling code here:
        dispose();
        new Menu().setVisible(true);
        
    }//GEN-LAST:event_B_AtrasActionPerformed

    private void BT_PersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_PersonaActionPerformed
        // TODO add your handling code here:
        new MenuConsultaPersona().setVisible(true);
        dispose();
    }//GEN-LAST:event_BT_PersonaActionPerformed

    private void BT_CursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_CursoActionPerformed
        // TODO add your handling code here:
        new ConsultaCurso().setVisible(true);
        dispose();
    }//GEN-LAST:event_BT_CursoActionPerformed

    private void BT_EventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_EventoActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaEvento().setVisible(true);
        dispose();
    }//GEN-LAST:event_BT_EventoActionPerformed

    private void BT_ActivdadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ActivdadesActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaActividad().setVisible(true);
        dispose();
    }//GEN-LAST:event_BT_ActivdadesActionPerformed

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
            java.util.logging.Logger.getLogger(MenuConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Activdades;
    private javax.swing.JButton BT_Curso;
    private javax.swing.JButton BT_Empleado;
    private javax.swing.JButton BT_Evento;
    private javax.swing.JButton BT_Persona;
    private javax.swing.JButton B_Atras;
    private javax.swing.JLabel Titulo_Registro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
