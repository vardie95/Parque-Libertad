/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Interfaz.Consultas.*;
import Interfaz.Registro.RegistroClase;
import Interfaz.Registro.RegistroEmpleado;
import Interfaz.Registro.RegistroEstudiante;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Luis Diego
 */
public class HorariosCurso extends javax.swing.JFrame {
         Connection con= null;
        ArrayList llaves=new ArrayList();
    /**
     * Creates new form ConsultaFecha
     */
    public HorariosCurso() {
        initComponents();
        llenarHorario();
        llenarClase();
    }
    private  void llenarHorario(){
        CB_Curso1.removeAllItems();
            try {
               con= parquelibertad.dbConnection.conectDB();
               String dia=CB_Curso2.getSelectedItem().toString();
               CallableStatement cstmt =con.prepareCall("{call get_Horario(?,?)}");
               cstmt.setString(1, dia);
               cstmt.registerOutParameter(2,oracle.jdbc.OracleTypes.CURSOR);
               cstmt.execute();
               ResultSet rs = (ResultSet)cstmt.getObject(2);
               while(rs.next()){
                   CB_Curso1.addItem(rs.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private int getidHorario(){
        int id_horario = 0;    
        try {
                CallableStatement cstmt;
                con= parquelibertad.dbConnection.conectDB();
                String dia=CB_Curso2.getSelectedItem().toString();
                String hora=CB_Curso1.getSelectedItem().toString();
                cstmt = con.prepareCall("{?=call consulta_idHorario (?,?)}");
                cstmt.setString(2,dia);
                cstmt.setString(3,hora);
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);
                cstmt.execute();
                id_horario=cstmt.getInt(1);
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RegistroClase.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    
    
            return id_horario;
    }
    
   
    private void UpdateTable(){
        CallableStatement cstmt =null;
        con = parquelibertad.dbConnection.conectDB();
        try {
            int indice=CB_Curso.getSelectedIndex()-1;
            int ID_Curso=(int) llaves.get(indice);
            cstmt =con.prepareCall("{call consultaHorarioCurso(?,?)}");
            cstmt.setInt(1,ID_Curso);
            cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet)cstmt.getObject(2);
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            con.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaNombre.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    public final  void llenarClase()
    {
        CB_Curso.removeAllItems();
        CB_Curso.addItem("Seleccione un Curso");
        llaves.clear();
            try {
                 
                CallableStatement cstmt = con.prepareCall("{call get_Clase(?)}");
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                cstmt.execute();
                ResultSet rs = (ResultSet)cstmt.getObject(1);
                while(rs.next()){
                   CB_Curso.addItem("Grupo: "+rs.getString(1)+"  "+rs.getString(2)+"\t  Costo:  "+rs.getString(3)+"       Mercado: "+rs.getString(4) );
                   llaves.add(rs.getInt(1));
                }
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private void RegistrarHorario(){
            try {
                CallableStatement cstmt = null;
                int indice=CB_Curso.getSelectedIndex()-1;
                int idCurso=(int) llaves.get(indice);
                int idHorario=getidHorario();
                con= parquelibertad.dbConnection.conectDB();
                System.out.println(idCurso+"   "+idHorario);
                cstmt = con.prepareCall("{call insertClasexHorario(?,?)}");
                cstmt.setInt(2,idCurso);
                cstmt.setInt(1,idHorario);
                cstmt.execute();
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(RegistroClase.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    
   
    }
    
    private void EliminarHorario(){
             try {
                 String dia=jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                 String hora=jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
                 int idHorario=getidHorarioEliminar(dia, hora);
                 int idClase=(int) llaves.get(CB_Curso.getSelectedIndex()-1);
                 CallableStatement cstmt;
                 con= parquelibertad.dbConnection.conectDB();
                 cstmt = con.prepareCall("{call EliminarUsuarioClase (?,?)}");
                 cstmt.setInt(1,idClase);
                 cstmt.setInt(2,idHorario);
                 cstmt.execute();
                 
             } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this, "Error:"+ex,null,JOptionPane.ERROR_MESSAGE);
             }

    
    }
    private int getidHorarioEliminar(String dia,String hora){
        int id_horario = 0;    
        try {
                CallableStatement cstmt;
                con= parquelibertad.dbConnection.conectDB();
                cstmt = con.prepareCall("{?=call consulta_idHorario (?,?)}");
                cstmt.setString(2,dia);
                cstmt.setString(3,hora);
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);
                cstmt.execute();
                id_horario=cstmt.getInt(1);
                cstmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RegistroClase.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    
    
            return id_horario;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Titulo_Menu = new javax.swing.JLabel();
        CB_Curso = new javax.swing.JComboBox<>();
        L_Horario4 = new javax.swing.JLabel();
        CB_Curso2 = new javax.swing.JComboBox<>();
        L_Horario = new javax.swing.JLabel();
        CB_Curso1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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
        setLocation(new java.awt.Point(500, 125));
        setMinimumSize(new java.awt.Dimension(580, 480));
        getContentPane().setLayout(null);

        jTable1.setBackground(new java.awt.Color(204, 255, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Día", "Hora"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 110, 350, 150);

        Titulo_Menu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Titulo_Menu.setText("Horarios");
        getContentPane().add(Titulo_Menu);
        Titulo_Menu.setBounds(240, 20, 80, 22);

        CB_Curso.setBackground(new java.awt.Color(204, 255, 204));
        CB_Curso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre" }));
        CB_Curso.setBorder(null);
        CB_Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_CursoActionPerformed(evt);
            }
        });
        getContentPane().add(CB_Curso);
        CB_Curso.setBounds(40, 60, 460, 31);

        L_Horario4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Horario4.setText("Dia: ");
        getContentPane().add(L_Horario4);
        L_Horario4.setBounds(90, 270, 70, 28);

        CB_Curso2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado", "Domingo" }));
        CB_Curso2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Curso2ActionPerformed(evt);
            }
        });
        getContentPane().add(CB_Curso2);
        CB_Curso2.setBounds(130, 270, 100, 28);

        L_Horario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Horario.setText("Hora:");
        getContentPane().add(L_Horario);
        L_Horario.setBounds(250, 270, 70, 28);

        CB_Curso1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horario" }));
        getContentPane().add(CB_Curso1);
        CB_Curso1.setBounds(300, 270, 120, 28);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Agregar Horario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(80, 320, 140, 30);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Eliminar Horario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(320, 320, 150, 30);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Registro/Fondo.png"))); // NOI18N
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 590, 400);

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

    private void CB_Curso2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Curso2ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==CB_Curso2){
            if(CB_Curso2.getSelectedItem()!=null){
                llenarHorario();
            }
        }

    }//GEN-LAST:event_CB_Curso2ActionPerformed

    private void CB_CursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_CursoActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==CB_Curso){
            if(CB_Curso.getSelectedItem()!=null){
                if((int)CB_Curso.getSelectedIndex()>0){
                    UpdateTable();
                }
            }
        }
    }//GEN-LAST:event_CB_CursoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(CB_Curso.getSelectedIndex()>0){
            RegistrarHorario();
            UpdateTable();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow()!=-1|| CB_Curso.getSelectedIndex()>0){
            EliminarHorario();
            UpdateTable();
        }
        else{
           JOptionPane.showMessageDialog(this, "Error: Seleccione un Horario a Borrar ",null,JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(HorariosCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HorariosCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HorariosCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HorariosCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HorariosCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Admi_Curso;
    private javax.swing.JMenuItem Admi_Curso1;
    private javax.swing.JMenuItem Admi_Puesto;
    private javax.swing.JMenuItem Admi_Puesto1;
    private javax.swing.JMenuItem Admi_tipoEvento;
    private javax.swing.JComboBox<String> CB_Curso;
    private javax.swing.JComboBox<String> CB_Curso1;
    private javax.swing.JComboBox<String> CB_Curso2;
    private javax.swing.JLabel L_Horario;
    private javax.swing.JLabel L_Horario4;
    private javax.swing.JMenuItem Re_Actividad;
    private javax.swing.JMenuItem Re_Curso;
    private javax.swing.JMenuItem Re_Empleado;
    private javax.swing.JMenuItem Re_Evento;
    private javax.swing.JMenuItem Re_Persona;
    private javax.swing.JMenuItem Re_Persona1;
    private javax.swing.JMenuItem Re_Persona2;
    private javax.swing.JMenuItem Re_Persona3;
    private javax.swing.JMenuItem Re_desercion;
    private javax.swing.JLabel Titulo_Menu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
