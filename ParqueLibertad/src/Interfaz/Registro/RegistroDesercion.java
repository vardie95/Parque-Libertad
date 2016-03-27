/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Registro;

import Interfaz.MenuRegistro;

/**
 *
 * @author Luis Diego
 */
public class RegistroDesercion extends javax.swing.JFrame {

    /**
     * Creates new form RegistroCurso
     */
    public RegistroDesercion() {
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

        CB_Identificacion = new javax.swing.JComboBox<String>();
        L_Identificacion = new javax.swing.JLabel();
        CB_Curso = new javax.swing.JComboBox<String>();
        L_Curso = new javax.swing.JLabel();
        L_Motivo = new javax.swing.JLabel();
        B_Registrar = new javax.swing.JButton();
        B_Atras = new javax.swing.JButton();
        Titulo_Registro_de_Desercion = new javax.swing.JLabel();
        SP_Descripcion = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        TF_Nombre = new javax.swing.JTextField();
        TF_Apellido1 = new javax.swing.JTextField();
        TF_Apellido2 = new javax.swing.JTextField();
        L_Nombre = new javax.swing.JLabel();
        L_Apellido1 = new javax.swing.JLabel();
        L_Apellido2 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();
        Relleno_Fondo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 125));
        setMinimumSize(new java.awt.Dimension(511, 340));
        setResizable(false);
        getContentPane().setLayout(null);

        CB_Identificacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "123456789" }));
        getContentPane().add(CB_Identificacion);
        CB_Identificacion.setBounds(200, 60, 164, 28);

        L_Identificacion.setText("Identificación:");
        getContentPane().add(L_Identificacion);
        L_Identificacion.setBounds(110, 60, 80, 28);

        CB_Curso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre" }));
        getContentPane().add(CB_Curso);
        CB_Curso.setBounds(130, 150, 146, 31);

        L_Curso.setText("Curso:");
        getContentPane().add(L_Curso);
        L_Curso.setBounds(70, 150, 40, 28);

        L_Motivo.setText("Motivo:");
        getContentPane().add(L_Motivo);
        L_Motivo.setBounds(70, 180, 58, 28);

        B_Registrar.setText("Registrar");
        B_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(B_Registrar);
        B_Registrar.setBounds(390, 260, 90, 30);

        B_Atras.setText("Atrás");
        B_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_AtrasActionPerformed(evt);
            }
        });
        getContentPane().add(B_Atras);
        B_Atras.setBounds(10, 10, 70, 23);

        Titulo_Registro_de_Desercion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Titulo_Registro_de_Desercion.setText("Registro de Deserción");
        getContentPane().add(Titulo_Registro_de_Desercion);
        Titulo_Registro_de_Desercion.setBounds(180, 20, 180, 22);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        SP_Descripcion.setViewportView(jTextArea1);

        getContentPane().add(SP_Descripcion);
        SP_Descripcion.setBounds(70, 210, 270, 60);

        TF_Nombre.setEditable(false);
        getContentPane().add(TF_Nombre);
        TF_Nombre.setBounds(30, 120, 139, 20);

        TF_Apellido1.setEditable(false);
        getContentPane().add(TF_Apellido1);
        TF_Apellido1.setBounds(180, 120, 139, 20);

        TF_Apellido2.setEditable(false);
        getContentPane().add(TF_Apellido2);
        TF_Apellido2.setBounds(340, 120, 139, 20);

        L_Nombre.setText("Nombre: ");
        getContentPane().add(L_Nombre);
        L_Nombre.setBounds(30, 100, 90, 14);

        L_Apellido1.setText("Apellido 1:");
        getContentPane().add(L_Apellido1);
        L_Apellido1.setBounds(180, 100, 80, 14);

        L_Apellido2.setText("Apellido 2: ");
        getContentPane().add(L_Apellido2);
        L_Apellido2.setBounds(340, 100, 90, 14);

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Imagen1.png"))); // NOI18N
        getContentPane().add(Fondo);
        Fondo.setBounds(130, 0, 380, 310);

        Relleno_Fondo.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Relleno_Fondo);
        Relleno_Fondo.setBounds(0, 0, 210, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RegistrarActionPerformed
        // TODO add your handling code here:
        dispose();
        new MenuRegistro().setVisible(true);
    }//GEN-LAST:event_B_RegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroDesercion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroDesercion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroDesercion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroDesercion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroDesercion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Atras;
    private javax.swing.JButton B_Registrar;
    private javax.swing.JComboBox<String> CB_Curso;
    private javax.swing.JComboBox<String> CB_Identificacion;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel L_Apellido1;
    private javax.swing.JLabel L_Apellido2;
    private javax.swing.JLabel L_Curso;
    private javax.swing.JLabel L_Identificacion;
    private javax.swing.JLabel L_Motivo;
    private javax.swing.JLabel L_Nombre;
    private javax.swing.JPanel Relleno_Fondo;
    private javax.swing.JScrollPane SP_Descripcion;
    private javax.swing.JTextField TF_Apellido1;
    private javax.swing.JTextField TF_Apellido2;
    private javax.swing.JTextField TF_Nombre;
    private javax.swing.JLabel Titulo_Registro_de_Desercion;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}