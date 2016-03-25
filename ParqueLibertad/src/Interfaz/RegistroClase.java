/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javax.swing.JOptionPane;

/**
 *
 * @author Luis Diego
 */
public class RegistroClase extends javax.swing.JFrame {

    /**
     * Creates new form RegistroCurso
     */
    public RegistroClase() {
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

        CB_Curso = new javax.swing.JComboBox<String>();
        L_Curso = new javax.swing.JLabel();
        CB_Mercado = new javax.swing.JComboBox<String>();
        TF_Costo = new javax.swing.JFormattedTextField();
        L_Costo = new javax.swing.JLabel();
        L_Mercado = new javax.swing.JLabel();
        L_Horario = new javax.swing.JLabel();
        B_Registrar = new javax.swing.JButton();
        B_Atras = new javax.swing.JButton();
        Titulo_Registro_de_Curso = new javax.swing.JLabel();
        RB_Sabado = new javax.swing.JRadioButton();
        RB_Viernes = new javax.swing.JRadioButton();
        RB_Jueves = new javax.swing.JRadioButton();
        RB_Miercoles = new javax.swing.JRadioButton();
        RB_Domingo = new javax.swing.JRadioButton();
        RB_Lunes = new javax.swing.JRadioButton();
        RB_Martes = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 125));
        setMinimumSize(new java.awt.Dimension(380, 350));
        setResizable(false);
        getContentPane().setLayout(null);

        CB_Curso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre" }));
        getContentPane().add(CB_Curso);
        CB_Curso.setBounds(130, 60, 164, 28);

        L_Curso.setText("Curso: ");
        getContentPane().add(L_Curso);
        L_Curso.setBounds(70, 60, 47, 28);

        CB_Mercado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Adultos" }));
        getContentPane().add(CB_Mercado);
        CB_Mercado.setBounds(130, 110, 146, 31);
        getContentPane().add(TF_Costo);
        TF_Costo.setBounds(130, 230, 135, 30);

        L_Costo.setText("Costo: ");
        getContentPane().add(L_Costo);
        L_Costo.setBounds(70, 230, 58, 28);

        L_Mercado.setText("Mercado: ");
        getContentPane().add(L_Mercado);
        L_Mercado.setBounds(70, 110, 58, 28);

        L_Horario.setText("Horario: ");
        getContentPane().add(L_Horario);
        L_Horario.setBounds(70, 180, 58, 28);

        B_Registrar.setText("Registrar");
        B_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(B_Registrar);
        B_Registrar.setBounds(250, 270, 100, 30);

        B_Atras.setText("Atrás");
        B_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_AtrasActionPerformed(evt);
            }
        });
        getContentPane().add(B_Atras);
        B_Atras.setBounds(10, 10, 70, 23);

        Titulo_Registro_de_Curso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Titulo_Registro_de_Curso.setText("Registro de Clase");
        getContentPane().add(Titulo_Registro_de_Curso);
        Titulo_Registro_de_Curso.setBounds(110, 20, 136, 22);

        RB_Sabado.setBackground(new java.awt.Color(255, 255, 255));
        RB_Sabado.setText("S");
        RB_Sabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_SabadoActionPerformed(evt);
            }
        });
        getContentPane().add(RB_Sabado);
        RB_Sabado.setBounds(290, 150, 40, 23);

        RB_Viernes.setBackground(new java.awt.Color(255, 255, 255));
        RB_Viernes.setText("V");
        getContentPane().add(RB_Viernes);
        RB_Viernes.setBounds(250, 150, 40, 23);

        RB_Jueves.setBackground(new java.awt.Color(255, 255, 255));
        RB_Jueves.setText("J");
        getContentPane().add(RB_Jueves);
        RB_Jueves.setBounds(210, 150, 40, 23);

        RB_Miercoles.setBackground(new java.awt.Color(255, 255, 255));
        RB_Miercoles.setText("M");
        getContentPane().add(RB_Miercoles);
        RB_Miercoles.setBounds(170, 150, 40, 23);

        RB_Domingo.setBackground(new java.awt.Color(255, 255, 255));
        RB_Domingo.setText("D");
        getContentPane().add(RB_Domingo);
        RB_Domingo.setBounds(50, 150, 40, 23);

        RB_Lunes.setBackground(new java.awt.Color(255, 255, 255));
        RB_Lunes.setText("L");
        getContentPane().add(RB_Lunes);
        RB_Lunes.setBounds(90, 150, 40, 23);

        RB_Martes.setBackground(new java.awt.Color(255, 255, 255));
        RB_Martes.setText("K");
        getContentPane().add(RB_Martes);
        RB_Martes.setBounds(130, 150, 40, 23);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(160, 180, 20, 20);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(200, 180, 20, 20);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(230, 180, 20, 20);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(130, 180, 20, 20);

        jLabel1.setText(" :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, 180, 20, 14);

        jLabel2.setText(" :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 180, 20, 14);

        jLabel3.setText("a");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(190, 180, 30, 20);

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Imagen1.png"))); // NOI18N
        getContentPane().add(Fondo);
        Fondo.setBounds(0, 0, 370, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RegistrarActionPerformed
        // TODO add your handling code here:
        if (RB_Lunes.isSelected()==false && RB_Martes.isSelected()==false && RB_Miercoles.isSelected()==false && RB_Jueves.isSelected()==false && RB_Viernes.isSelected()==false && RB_Sabado.isSelected()==false && RB_Domingo.isSelected()==false){
            JOptionPane.showMessageDialog(this, "Debe de llenar todos los campos obligatorios.",null,JOptionPane.ERROR_MESSAGE);
        }
        else{
            dispose();
            new MenuRegistro().setVisible(true);
        }
    }//GEN-LAST:event_B_RegistrarActionPerformed

    private void B_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_AtrasActionPerformed
        // TODO add your handling code here:
        dispose();
        new MenuRegistro().setVisible(true);
    }//GEN-LAST:event_B_AtrasActionPerformed

    private void RB_SabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_SabadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RB_SabadoActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroClase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Atras;
    private javax.swing.JButton B_Registrar;
    private javax.swing.JComboBox<String> CB_Curso;
    private javax.swing.JComboBox<String> CB_Mercado;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel L_Costo;
    private javax.swing.JLabel L_Curso;
    private javax.swing.JLabel L_Horario;
    private javax.swing.JLabel L_Mercado;
    private javax.swing.JRadioButton RB_Domingo;
    private javax.swing.JRadioButton RB_Jueves;
    private javax.swing.JRadioButton RB_Lunes;
    private javax.swing.JRadioButton RB_Martes;
    private javax.swing.JRadioButton RB_Miercoles;
    private javax.swing.JRadioButton RB_Sabado;
    private javax.swing.JRadioButton RB_Viernes;
    private javax.swing.JFormattedTextField TF_Costo;
    private javax.swing.JLabel Titulo_Registro_de_Curso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
