/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Registro;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import parquelibertad.dbConnection;



/**
 *
 * @author Luis Diego
 */
public class InscripcionClase extends javax.swing.JFrame {
    Connection con=null;
    ArrayList llaves=new ArrayList();

    /**
     * Creates new form RegistroCurso
     */
    public InscripcionClase() {
        initComponents();
        llenaridentificacion();
        llenarClase();
    }
    public final  void llenaridentificacion() {
        con= parquelibertad.dbConnection.conectDB();
        CB_Identificacion.removeAllItems();
        CB_Identificacion.addItem("Seleccione Identificacion");
            try {
                 
                CallableStatement cstmt = con.prepareCall("{call get_idEstudiante(?)}");
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                cstmt.execute();
                ResultSet rs = (ResultSet)cstmt.getObject(1);
                while(rs.next()){
                   CB_Identificacion.addItem(rs.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            
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
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private void InscribirCurso(){
         Connection con= null;
            int identificacion=Integer.parseInt(CB_Identificacion.getSelectedItem().toString());
            int indice=CB_Curso.getSelectedIndex()-1;
            con= parquelibertad.dbConnection.conectDB();
            try {
                CallableStatement proc= con.prepareCall("{call insertClasexPersona(?,?)}");
                proc.setInt(1, identificacion);
                proc.setInt(2, indice);
                proc.execute();
                JOptionPane.showMessageDialog(this, "Persona Matriculada Exitosamente",null,JOptionPane.INFORMATION_MESSAGE);
                con.close();
                
            } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, "Error: "+ex,null,JOptionPane.ERROR_MESSAGE);

            }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CB_Identificacion = new javax.swing.JComboBox<>();
        L_Identificacion = new javax.swing.JLabel();
        CB_Curso = new javax.swing.JComboBox<>();
        L_Curso = new javax.swing.JLabel();
        B_Registrar = new javax.swing.JButton();
        Titulo_Registro_de_Desercion = new javax.swing.JLabel();
        TF_Nombre = new javax.swing.JTextField();
        TF_Apellido1 = new javax.swing.JTextField();
        TF_Apellido2 = new javax.swing.JTextField();
        L_Nombre = new javax.swing.JLabel();
        L_Apellido1 = new javax.swing.JLabel();
        L_Apellido2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        Ins_Actividad = new javax.swing.JMenuItem();
        Ins_Clase = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        Con_persona_ID = new javax.swing.JMenuItem();
        Con_Persona_Name = new javax.swing.JMenuItem();
        Con_persona_Lugar = new javax.swing.JMenuItem();
        con_persona_Fecha = new javax.swing.JMenuItem();
        Con_persona_deser = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        Con_Empleado_ID = new javax.swing.JMenuItem();
        Con_Empleado_Name = new javax.swing.JMenuItem();
        con_Empleado_Fecha = new javax.swing.JMenuItem();
        Con_actividad = new javax.swing.JMenuItem();
        Con_Curso = new javax.swing.JMenuItem();
        Con_Evento = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        Es_persona_Fecha = new javax.swing.JMenuItem();
        Es_persona_lugar = new javax.swing.JMenuItem();
        Es_top_persona = new javax.swing.JMenuItem();
        TopCurso = new javax.swing.JMenuItem();
        TopActividades = new javax.swing.JMenuItem();
        TopDeserciones = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        Admi_Curso1 = new javax.swing.JMenuItem();
        Admi_Puesto1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parque la Libertad");
        setLocation(new java.awt.Point(450, 125));
        setMinimumSize(new java.awt.Dimension(521, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        CB_Identificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "123456789" }));
        CB_Identificacion.setBorder(null);
        getContentPane().add(CB_Identificacion);
        CB_Identificacion.setBounds(190, 60, 164, 28);

        L_Identificacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Identificacion.setText("Identificación:");
        getContentPane().add(L_Identificacion);
        L_Identificacion.setBounds(70, 60, 110, 28);

        CB_Curso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre" }));
        CB_Curso.setBorder(null);
        getContentPane().add(CB_Curso);
        CB_Curso.setBounds(20, 200, 470, 31);

        L_Curso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Curso.setText("Curso:");
        getContentPane().add(L_Curso);
        L_Curso.setBounds(30, 170, 40, 28);

        B_Registrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        B_Registrar.setText("Registrar");
        B_Registrar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        B_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(B_Registrar);
        B_Registrar.setBounds(370, 250, 100, 40);

        Titulo_Registro_de_Desercion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Titulo_Registro_de_Desercion.setText("Inscripción Curso");
        getContentPane().add(Titulo_Registro_de_Desercion);
        Titulo_Registro_de_Desercion.setBounds(190, 20, 180, 22);

        TF_Nombre.setEditable(false);
        TF_Nombre.setBackground(new java.awt.Color(153, 255, 153));
        TF_Nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(TF_Nombre);
        TF_Nombre.setBounds(30, 130, 139, 30);

        TF_Apellido1.setEditable(false);
        TF_Apellido1.setBackground(new java.awt.Color(153, 255, 153));
        TF_Apellido1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(TF_Apellido1);
        TF_Apellido1.setBounds(180, 130, 139, 30);

        TF_Apellido2.setEditable(false);
        TF_Apellido2.setBackground(new java.awt.Color(153, 255, 153));
        TF_Apellido2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(TF_Apellido2);
        TF_Apellido2.setBounds(340, 130, 139, 30);

        L_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Nombre.setText("Nombre: ");
        getContentPane().add(L_Nombre);
        L_Nombre.setBounds(30, 110, 90, 15);

        L_Apellido1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Apellido1.setText("Apellido 1:");
        getContentPane().add(L_Apellido1);
        L_Apellido1.setBounds(180, 110, 80, 15);

        L_Apellido2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Apellido2.setText("Apellido 2: ");
        getContentPane().add(L_Apellido2);
        L_Apellido2.setBounds(340, 110, 90, 15);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(370, 60, 80, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Registro/Fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 570, 340);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(106, 50));

        jMenu11.setBackground(new java.awt.Color(255, 255, 255));
        jMenu11.setText("       Inscripción");
        jMenu11.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 13)); // NOI18N
        jMenu11.setMinimumSize(new java.awt.Dimension(100, 100));
        jMenu11.setPreferredSize(new java.awt.Dimension(180, 100));

        Ins_Actividad.setText("Actividad");
        Ins_Actividad.setFocusCycleRoot(true);
        Ins_Actividad.setPreferredSize(new java.awt.Dimension(140, 30));
        Ins_Actividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ins_ActividadActionPerformed(evt);
            }
        });
        jMenu11.add(Ins_Actividad);

        Ins_Clase.setText("Clase");
        Ins_Clase.setPreferredSize(new java.awt.Dimension(140, 30));
        Ins_Clase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ins_ClaseActionPerformed(evt);
            }
        });
        jMenu11.add(Ins_Clase);

        jMenuBar1.add(jMenu11);

        jMenu4.setBackground(new java.awt.Color(255, 255, 255));
        jMenu4.setText("  Consulta");
        jMenu4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 13)); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(180, 19));

        jMenu8.setBackground(new java.awt.Color(253, 253, 253));
        jMenu8.setText("Persona");
        jMenu8.setPreferredSize(new java.awt.Dimension(100, 35));

        Con_persona_ID.setBackground(new java.awt.Color(253, 253, 253));
        Con_persona_ID.setText("Identificación");
        Con_persona_ID.setFocusCycleRoot(true);
        Con_persona_ID.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_persona_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_persona_IDActionPerformed(evt);
            }
        });
        jMenu8.add(Con_persona_ID);

        Con_Persona_Name.setBackground(new java.awt.Color(253, 253, 253));
        Con_Persona_Name.setText("Nombre");
        Con_Persona_Name.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_Persona_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_Persona_NameActionPerformed(evt);
            }
        });
        jMenu8.add(Con_Persona_Name);

        Con_persona_Lugar.setBackground(new java.awt.Color(253, 253, 253));
        Con_persona_Lugar.setText("Lugar");
        Con_persona_Lugar.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_persona_Lugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_persona_LugarActionPerformed(evt);
            }
        });
        jMenu8.add(Con_persona_Lugar);

        con_persona_Fecha.setBackground(new java.awt.Color(253, 253, 253));
        con_persona_Fecha.setText("Fecha");
        con_persona_Fecha.setPreferredSize(new java.awt.Dimension(140, 30));
        con_persona_Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                con_persona_FechaActionPerformed(evt);
            }
        });
        jMenu8.add(con_persona_Fecha);

        Con_persona_deser.setBackground(new java.awt.Color(253, 253, 253));
        Con_persona_deser.setText("Deserciones");
        Con_persona_deser.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_persona_deser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_persona_deserActionPerformed(evt);
            }
        });
        jMenu8.add(Con_persona_deser);

        jMenu4.add(jMenu8);

        jMenu9.setText("Empleado");
        jMenu9.setPreferredSize(new java.awt.Dimension(100, 35));

        Con_Empleado_ID.setBackground(new java.awt.Color(252, 252, 252));
        Con_Empleado_ID.setText("Identificación");
        Con_Empleado_ID.setFocusCycleRoot(true);
        Con_Empleado_ID.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_Empleado_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_Empleado_IDActionPerformed(evt);
            }
        });
        jMenu9.add(Con_Empleado_ID);

        Con_Empleado_Name.setBackground(new java.awt.Color(252, 252, 252));
        Con_Empleado_Name.setText("Nombre");
        Con_Empleado_Name.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_Empleado_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_Empleado_NameActionPerformed(evt);
            }
        });
        jMenu9.add(Con_Empleado_Name);

        con_Empleado_Fecha.setBackground(new java.awt.Color(252, 252, 252));
        con_Empleado_Fecha.setText("Fecha");
        con_Empleado_Fecha.setPreferredSize(new java.awt.Dimension(140, 30));
        con_Empleado_Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                con_Empleado_FechaActionPerformed(evt);
            }
        });
        jMenu9.add(con_Empleado_Fecha);

        jMenu4.add(jMenu9);

        Con_actividad.setText("Actividad");
        Con_actividad.setPreferredSize(new java.awt.Dimension(137, 30));
        Con_actividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_actividadActionPerformed(evt);
            }
        });
        jMenu4.add(Con_actividad);

        Con_Curso.setText("Curso");
        Con_Curso.setPreferredSize(new java.awt.Dimension(137, 30));
        Con_Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_CursoActionPerformed(evt);
            }
        });
        jMenu4.add(Con_Curso);

        Con_Evento.setText("Evento");
        Con_Evento.setPreferredSize(new java.awt.Dimension(137, 30));
        Con_Evento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_EventoActionPerformed(evt);
            }
        });
        jMenu4.add(Con_Evento);

        jMenuBar1.add(jMenu4);

        jMenu3.setBackground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("   Estadística");
        jMenu3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 13)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(180, 19));

        jMenu7.setBackground(new java.awt.Color(253, 253, 253));
        jMenu7.setText("Persona");
        jMenu7.setPreferredSize(new java.awt.Dimension(100, 35));

        Es_persona_Fecha.setText("Fecha");
        Es_persona_Fecha.setPreferredSize(new java.awt.Dimension(140, 30));
        Es_persona_Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Es_persona_FechaActionPerformed(evt);
            }
        });
        jMenu7.add(Es_persona_Fecha);

        Es_persona_lugar.setText("Lugar");
        Es_persona_lugar.setPreferredSize(new java.awt.Dimension(140, 30));
        Es_persona_lugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Es_persona_lugarActionPerformed(evt);
            }
        });
        jMenu7.add(Es_persona_lugar);

        Es_top_persona.setText("Top 10");
        Es_top_persona.setPreferredSize(new java.awt.Dimension(140, 30));
        Es_top_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Es_top_personaActionPerformed(evt);
            }
        });
        jMenu7.add(Es_top_persona);

        jMenu3.add(jMenu7);

        TopCurso.setText("Top Cursos");
        TopCurso.setPreferredSize(new java.awt.Dimension(137, 40));
        TopCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopCursoActionPerformed(evt);
            }
        });
        jMenu3.add(TopCurso);

        TopActividades.setText("Top Actividades");
        TopActividades.setPreferredSize(new java.awt.Dimension(137, 40));
        TopActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopActividadesActionPerformed(evt);
            }
        });
        jMenu3.add(TopActividades);

        TopDeserciones.setText("Top Deserciones");
        TopDeserciones.setPreferredSize(new java.awt.Dimension(137, 40));
        TopDeserciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopDesercionesActionPerformed(evt);
            }
        });
        jMenu3.add(TopDeserciones);

        jMenuBar1.add(jMenu3);

        jMenu12.setBackground(new java.awt.Color(255, 255, 255));
        jMenu12.setText("      Sesión");
        jMenu12.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 13)); // NOI18N
        jMenu12.setPreferredSize(new java.awt.Dimension(180, 35));

        Admi_Curso1.setText("Modo Administrador");
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

    private void B_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RegistrarActionPerformed
        // TODO add your handling code here:
        if(TF_Nombre.getText().equals("")|| CB_Curso.getSelectedIndex()==0 ||CB_Identificacion.getSelectedIndex()==0  ){
            JOptionPane.showMessageDialog(this, "Por favor seleccionar una persona y una actividad para inscribir",null,JOptionPane.ERROR_MESSAGE);
        }else{
        InscribirCurso();}
    }//GEN-LAST:event_B_RegistrarActionPerformed

    private void Ins_ActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ins_ActividadActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.InscripcionActividad().setVisible(true);
        dispose();
    }//GEN-LAST:event_Ins_ActividadActionPerformed

    private void Ins_ClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ins_ClaseActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.InscripcionClase().setVisible(true);
        dispose();
    }//GEN-LAST:event_Ins_ClaseActionPerformed

    private void Con_persona_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_persona_IDActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaIndentificacionPersona().setVisible(true);
        dispose();
    }//GEN-LAST:event_Con_persona_IDActionPerformed

    private void Con_Persona_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_Persona_NameActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaNombre().setVisible(true);
        dispose();
    }//GEN-LAST:event_Con_Persona_NameActionPerformed

    private void Con_persona_LugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_persona_LugarActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaLugarPersona().setVisible(true);
        dispose();
    }//GEN-LAST:event_Con_persona_LugarActionPerformed

    private void con_persona_FechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_con_persona_FechaActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaFecha().setVisible(true);
        dispose();
    }//GEN-LAST:event_con_persona_FechaActionPerformed

    private void Con_persona_deserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_persona_deserActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaDesertaPersona().setVisible(true);
        dispose();
    }//GEN-LAST:event_Con_persona_deserActionPerformed

    private void Con_Empleado_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_Empleado_IDActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaEmpleadoIdentificacion().setVisible(true);
        dispose();
    }//GEN-LAST:event_Con_Empleado_IDActionPerformed

    private void Con_Empleado_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_Empleado_NameActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaEmpleadoNombre().setVisible(true);
        dispose();
    }//GEN-LAST:event_Con_Empleado_NameActionPerformed

    private void con_Empleado_FechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_con_Empleado_FechaActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaEmpleadoFecha().setVisible(true);
        dispose();
    }//GEN-LAST:event_con_Empleado_FechaActionPerformed

    private void Con_actividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_actividadActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaActividad().setVisible(true);
        dispose();
    }//GEN-LAST:event_Con_actividadActionPerformed

    private void Con_CursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_CursoActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaCurso().setVisible(true);
        dispose();
    }//GEN-LAST:event_Con_CursoActionPerformed

    private void Con_EventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_EventoActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaEvento().setVisible(true);
        dispose();
    }//GEN-LAST:event_Con_EventoActionPerformed

    private void Es_persona_FechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Es_persona_FechaActionPerformed
        // TODO add your handling code here:
        new Interfaz.Estadisticas.EstadisticaFecha().setVisible(true);
        dispose();
    }//GEN-LAST:event_Es_persona_FechaActionPerformed

    private void Es_persona_lugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Es_persona_lugarActionPerformed
        // TODO add your handling code here:
        new Interfaz.Estadisticas.EstadisticaLugar().setVisible(true);
        dispose();
    }//GEN-LAST:event_Es_persona_lugarActionPerformed

    private void Es_top_personaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Es_top_personaActionPerformed
        // TODO add your handling code here:
        new Interfaz.Estadisticas.Top10Personas().setVisible(true);
        dispose();
    }//GEN-LAST:event_Es_top_personaActionPerformed

    private void TopCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopCursoActionPerformed
        // TODO add your handling code here:
        new Interfaz.Estadisticas.Top5Cursos().setVisible(true);
        dispose();
    }//GEN-LAST:event_TopCursoActionPerformed

    private void TopActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopActividadesActionPerformed
        // TODO add your handling code here:
        new Interfaz.Estadisticas.Top5Actividades().setVisible(true);
        dispose();
    }//GEN-LAST:event_TopActividadesActionPerformed

    private void TopDesercionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopDesercionesActionPerformed
        // TODO add your handling code here:
        new Interfaz.Estadisticas.Top5Deserciones().setVisible(true);
        dispose();
    }//GEN-LAST:event_TopDesercionesActionPerformed

    private void Admi_Curso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Admi_Curso1ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Inicio().setVisible(true);
        dispose();
    }//GEN-LAST:event_Admi_Curso1ActionPerformed

    private void Admi_Puesto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Admi_Puesto1ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Inicio().setVisible(true);
        dispose();
    }//GEN-LAST:event_Admi_Puesto1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        con=dbConnection.conectDB();
        if ((String)CB_Identificacion.getSelectedItem()!="Seleccione Identificacion")
        {

            try {
                CallableStatement cstmt = con.prepareCall("{?=call consulta_nombre (?)}");
                TF_Nombre.setText((String)CB_Identificacion.getSelectedItem());
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
                int aux=Integer.parseInt(TF_Nombre.getText());
                cstmt.setInt(2,aux);
                cstmt.execute();
                TF_Nombre.setText(cstmt.getString(1));

                CallableStatement cstmt2 = con.prepareCall("{?=call consulta_apellido1 (?)}");
                cstmt2.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
                cstmt2.setInt(2,aux);
                cstmt2.execute();
                TF_Apellido1.setText(cstmt2.getString(1));

                CallableStatement cstmt3 = con.prepareCall("{?=call consulta_apellido2 (?)}");
                cstmt3.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
                cstmt3.setInt(2,aux);
                cstmt3.execute();
                TF_Apellido2.setText(cstmt3.getString(1));
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(InscripcionClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InscripcionClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InscripcionClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InscripcionClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new InscripcionClase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Admi_Curso1;
    private javax.swing.JMenuItem Admi_Puesto1;
    private javax.swing.JButton B_Registrar;
    private javax.swing.JComboBox<String> CB_Curso;
    private javax.swing.JComboBox<String> CB_Identificacion;
    private javax.swing.JMenuItem Con_Curso;
    private javax.swing.JMenuItem Con_Empleado_ID;
    private javax.swing.JMenuItem Con_Empleado_Name;
    private javax.swing.JMenuItem Con_Evento;
    private javax.swing.JMenuItem Con_Persona_Name;
    private javax.swing.JMenuItem Con_actividad;
    private javax.swing.JMenuItem Con_persona_ID;
    private javax.swing.JMenuItem Con_persona_Lugar;
    private javax.swing.JMenuItem Con_persona_deser;
    private javax.swing.JMenuItem Es_persona_Fecha;
    private javax.swing.JMenuItem Es_persona_lugar;
    private javax.swing.JMenuItem Es_top_persona;
    private javax.swing.JMenuItem Ins_Actividad;
    private javax.swing.JMenuItem Ins_Clase;
    private javax.swing.JLabel L_Apellido1;
    private javax.swing.JLabel L_Apellido2;
    private javax.swing.JLabel L_Curso;
    private javax.swing.JLabel L_Identificacion;
    private javax.swing.JLabel L_Nombre;
    private javax.swing.JTextField TF_Apellido1;
    private javax.swing.JTextField TF_Apellido2;
    private javax.swing.JTextField TF_Nombre;
    private javax.swing.JLabel Titulo_Registro_de_Desercion;
    private javax.swing.JMenuItem TopActividades;
    private javax.swing.JMenuItem TopCurso;
    private javax.swing.JMenuItem TopDeserciones;
    private javax.swing.JMenuItem con_Empleado_Fecha;
    private javax.swing.JMenuItem con_persona_Fecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
