/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Interfaz.Registro.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Diego
 */
public class RegistroHorario extends javax.swing.JFrame {

    /**
     * Creates new form RegistroCurso
     */
    public RegistroHorario() {
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

        B_Registrar = new javax.swing.JButton();
        CB_Curso2 = new javax.swing.JComboBox<>();
        Titulo_Registro_de_Puesto1 = new javax.swing.JLabel();
        Titulo_Registro_de_Puesto2 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        Titulo_Registro_de_Puesto3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Re_Actividad = new javax.swing.JMenuItem();
        Re_Curso = new javax.swing.JMenuItem();
        Re_desercion = new javax.swing.JMenuItem();
        Re_Empleado = new javax.swing.JMenuItem();
        Re_Evento = new javax.swing.JMenuItem();
        Re_Persona3 = new javax.swing.JMenuItem();
        Re_Persona = new javax.swing.JMenuItem();
        Re_Persona1 = new javax.swing.JMenuItem();
        Re_Persona2 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        Admi_Curso = new javax.swing.JMenuItem();
        Admi_Puesto = new javax.swing.JMenuItem();
        Admi_tipoEvento = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        Admi_Curso1 = new javax.swing.JMenuItem();
        Admi_Puesto1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parque Libertad");
        setLocation(new java.awt.Point(500, 125));
        setMinimumSize(new java.awt.Dimension(400, 340));
        setResizable(false);
        getContentPane().setLayout(null);

        B_Registrar.setBackground(new java.awt.Color(255, 255, 255));
        B_Registrar.setText("Registrar");
        B_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(B_Registrar);
        B_Registrar.setBounds(250, 170, 90, 40);

        CB_Curso2.setBackground(new java.awt.Color(204, 255, 204));
        CB_Curso2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        CB_Curso2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Curso2ActionPerformed(evt);
            }
        });
        getContentPane().add(CB_Curso2);
        CB_Curso2.setBounds(130, 70, 100, 28);

        Titulo_Registro_de_Puesto1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Titulo_Registro_de_Puesto1.setText("Registro de Horario");
        getContentPane().add(Titulo_Registro_de_Puesto1);
        Titulo_Registro_de_Puesto1.setBounds(110, 30, 180, 22);

        Titulo_Registro_de_Puesto2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Titulo_Registro_de_Puesto2.setText("Día:");
        getContentPane().add(Titulo_Registro_de_Puesto2);
        Titulo_Registro_de_Puesto2.setBounds(80, 70, 40, 17);

        jFormattedTextField2.setBackground(new java.awt.Color(153, 255, 153));
        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:## a ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jFormattedTextField2);
        jFormattedTextField2.setBounds(160, 120, 80, 20);

        Titulo_Registro_de_Puesto3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Titulo_Registro_de_Puesto3.setText("Hora:");
        getContentPane().add(Titulo_Registro_de_Puesto3);
        Titulo_Registro_de_Puesto3.setBounds(100, 120, 40, 17);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 390, 280);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(106, 60));

        jMenu1.setText("    Registro");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu1.setFocusPainted(true);
        jMenu1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 13)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(200, 19));

        Re_Actividad.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        Re_Actividad.setText("Actividad");
        Re_Actividad.setName("Regis_curso"); // NOI18N
        Re_Actividad.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Actividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_ActividadActionPerformed(evt);
            }
        });
        jMenu1.add(Re_Actividad);

        Re_Curso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Re_Curso.setText("Clase");
        Re_Curso.setName("Regis_curso"); // NOI18N
        Re_Curso.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_CursoActionPerformed(evt);
            }
        });
        jMenu1.add(Re_Curso);

        Re_desercion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        Re_desercion.setText("Deserción");
        Re_desercion.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_desercion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_desercionActionPerformed(evt);
            }
        });
        jMenu1.add(Re_desercion);

        Re_Empleado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        Re_Empleado.setText("Empleado");
        Re_Empleado.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_EmpleadoActionPerformed(evt);
            }
        });
        jMenu1.add(Re_Empleado);

        Re_Evento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        Re_Evento.setText("Evento");
        Re_Evento.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Evento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_EventoActionPerformed(evt);
            }
        });
        jMenu1.add(Re_Evento);

        Re_Persona3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        Re_Persona3.setText("Horario");
        Re_Persona3.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Persona3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_Persona3ActionPerformed(evt);
            }
        });
        jMenu1.add(Re_Persona3);

        Re_Persona.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        Re_Persona.setText("Persona");
        Re_Persona.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_PersonaActionPerformed(evt);
            }
        });
        jMenu1.add(Re_Persona);

        Re_Persona1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        Re_Persona1.setText("Usuario");
        Re_Persona1.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Persona1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_Persona1ActionPerformed(evt);
            }
        });
        jMenu1.add(Re_Persona1);

        Re_Persona2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        Re_Persona2.setText("Estudiante");
        Re_Persona2.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Persona2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_Persona2ActionPerformed(evt);
            }
        });
        jMenu1.add(Re_Persona2);

        jMenuBar1.add(jMenu1);

        jMenu10.setText("     Administrar");
        jMenu10.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 13)); // NOI18N
        jMenu10.setPreferredSize(new java.awt.Dimension(200, 19));

        Admi_Curso.setText("Curso");
        Admi_Curso.setFocusCycleRoot(true);
        Admi_Curso.setPreferredSize(new java.awt.Dimension(140, 30));
        Admi_Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Admi_CursoActionPerformed(evt);
            }
        });
        jMenu10.add(Admi_Curso);

        Admi_Puesto.setText("Puesto");
        Admi_Puesto.setPreferredSize(new java.awt.Dimension(140, 30));
        Admi_Puesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Admi_PuestoActionPerformed(evt);
            }
        });
        jMenu10.add(Admi_Puesto);

        Admi_tipoEvento.setText("Tipo Evento");
        Admi_tipoEvento.setPreferredSize(new java.awt.Dimension(140, 30));
        Admi_tipoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Admi_tipoEventoActionPerformed(evt);
            }
        });
        jMenu10.add(Admi_tipoEvento);

        jMenu2.setText("Lugar");

        jMenuItem7.setText("País");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem2.setText("Provincia");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Cantón");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Distrito");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem8.setText("Nacionalidad");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenu10.add(jMenu2);

        jMenuItem5.setText("Horario");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem5);

        jMenuBar1.add(jMenu10);

        jMenu12.setText("       Sesión");
        jMenu12.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 13)); // NOI18N
        jMenu12.setPreferredSize(new java.awt.Dimension(200, 19));

        Admi_Curso1.setText("Modo Usuario");
        Admi_Curso1.setFocusCycleRoot(true);
        Admi_Curso1.setPreferredSize(new java.awt.Dimension(140, 30));
        Admi_Curso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Admi_Curso1ActionPerformed(evt);
            }
        });
        jMenu12.add(Admi_Curso1);

        Admi_Puesto1.setText("Cerrar Sesión");
        Admi_Puesto1.setPreferredSize(new java.awt.Dimension(140, 30));
        Admi_Puesto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Admi_Puesto1ActionPerformed(evt);
            }
        });
        jMenu12.add(Admi_Puesto1);

        jMenuBar1.add(jMenu12);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void InsertHorario(){
        Connection con= null;
            String Horario=jFormattedTextField2.getText();
            String dia=CB_Curso2.getSelectedItem().toString();
            con= parquelibertad.dbConnection.conectDB();
            try {
                CallableStatement proc= con.prepareCall("{call insertHorario(?,?)}");
                proc.setString(1, dia);
                proc.setString(2, Horario);
                proc.execute();
                JOptionPane.showMessageDialog(this, "Horario Agregado Exitosamente",null,JOptionPane.INFORMATION_MESSAGE);
                jFormattedTextField2.setText("");
                con.close();
                
            } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, "Error:"+ex,null,JOptionPane.ERROR_MESSAGE);

            }
    }
    private void B_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RegistrarActionPerformed
        // TODO add your handling code here:
        if (jFormattedTextField2.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Debe de llenar todos los campos obligatorios.",null,JOptionPane.ERROR_MESSAGE); 
        }
        else{
            InsertHorario();
        }
    }//GEN-LAST:event_B_RegistrarActionPerformed

    private void CB_Curso2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Curso2ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==CB_Curso2){
            if(CB_Curso2.getSelectedItem()!=null){
               
            }
        }

    }//GEN-LAST:event_CB_Curso2ActionPerformed

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField2ActionPerformed

    private void Re_ActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_ActividadActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroActividad().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_ActividadActionPerformed

    private void Re_CursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_CursoActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroClase().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_CursoActionPerformed

    private void Re_desercionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_desercionActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroDesercion().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_desercionActionPerformed

    private void Re_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_EmpleadoActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroEmpleado().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_EmpleadoActionPerformed

    private void Re_EventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_EventoActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroEvento().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_EventoActionPerformed

    private void Re_Persona3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_Persona3ActionPerformed
        // TODO add your handling code here:
        new Administrador.HorariosCurso().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_Persona3ActionPerformed

    private void Re_PersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_PersonaActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroPersonas().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_PersonaActionPerformed

    private void Re_Persona1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_Persona1ActionPerformed
        // TODO add your handling code here:
        new Administrador.RegistroUsuario().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_Persona1ActionPerformed

    private void Re_Persona2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_Persona2ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroEstudiante().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_Persona2ActionPerformed

    private void Admi_CursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Admi_CursoActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroCurso().setVisible(true);
        dispose();
    }//GEN-LAST:event_Admi_CursoActionPerformed

    private void Admi_PuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Admi_PuestoActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroPuesto().setVisible(true);
        dispose();
    }//GEN-LAST:event_Admi_PuestoActionPerformed

    private void Admi_tipoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Admi_tipoEventoActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroTipoEvento().setVisible(true);
        dispose();
    }//GEN-LAST:event_Admi_tipoEventoActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        new Administrador.RegistroPais().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        new Administrador.RegistroProvincia().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        new Administrador.RegistroCanton().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        new Administrador.RegistroDistrito().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        new Administrador.RegistroNacionalidad().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        new Administrador.RegistroHorario().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void Admi_Curso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Admi_Curso1ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.InscripcionClase().setVisible(true);
        dispose();
    }//GEN-LAST:event_Admi_Curso1ActionPerformed

    private void Admi_Puesto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Admi_Puesto1ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Inicio().setVisible(true);
        dispose();
    }//GEN-LAST:event_Admi_Puesto1ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroHorario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Admi_Curso;
    private javax.swing.JMenuItem Admi_Curso1;
    private javax.swing.JMenuItem Admi_Puesto;
    private javax.swing.JMenuItem Admi_Puesto1;
    private javax.swing.JMenuItem Admi_tipoEvento;
    private javax.swing.JButton B_Registrar;
    private javax.swing.JComboBox<String> CB_Curso2;
    private javax.swing.JMenuItem Re_Actividad;
    private javax.swing.JMenuItem Re_Curso;
    private javax.swing.JMenuItem Re_Empleado;
    private javax.swing.JMenuItem Re_Evento;
    private javax.swing.JMenuItem Re_Persona;
    private javax.swing.JMenuItem Re_Persona1;
    private javax.swing.JMenuItem Re_Persona2;
    private javax.swing.JMenuItem Re_Persona3;
    private javax.swing.JMenuItem Re_desercion;
    private javax.swing.JLabel Titulo_Registro_de_Puesto1;
    private javax.swing.JLabel Titulo_Registro_de_Puesto2;
    private javax.swing.JLabel Titulo_Registro_de_Puesto3;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    // End of variables declaration//GEN-END:variables
}
