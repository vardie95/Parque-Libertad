/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Consultas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Luis Diego
 */
public class ConsultaEvento extends javax.swing.JFrame {
            Connection con= null;
    /**
     * Creates new form ConsultaFecha
     */
    public ConsultaEvento() {
        initComponents();
    }
    
    public  String fechaInicio(){
        String fecha=null;
        String dia=CB_Dia1.getSelectedItem().toString();
        String mes=CB_Mes1.getSelectedItem().toString();
        String año=CB_Año1.getSelectedItem().toString();        
        fecha=dia+mes+año;   
        return fecha;
    }
    
    public  String fechaFinalizacion(){
        String fecha=null;
        String dia=CB_Dia2.getSelectedItem().toString();
        String mes=CB_Mes2.getSelectedItem().toString();
        String año=CB_Año2.getSelectedItem().toString();        
        fecha=dia+mes+año;   
        return fecha;
    }
    
    private void UpdateTable(){
        CallableStatement cstmt =null;
        con = parquelibertad.dbConnection.conectDB();
        try {
            
            String fechaInicio=fechaInicio();
            String fechaFinal=fechaFinalizacion();
            SimpleDateFormat formato=new SimpleDateFormat("ddMMyy");
            java.util.Date parsed1 = formato.parse(fechaInicio);
            java.util.Date parsed2 = formato.parse(fechaFinal);
            java.sql.Date Initialdate= new java.sql.Date(parsed1.getTime());
            java.sql.Date Finaldate= new java.sql.Date(parsed2.getTime());
            cstmt =con.prepareCall("{call consultaEvento(?,?,?)}");
            cstmt.setDate(1,Initialdate);
            cstmt.setDate(2, Finaldate);
            cstmt.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet)cstmt.getObject(3);
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaNombre.class.getName()).log(Level.SEVERE, null, ex);
        }    catch (ParseException ex) {
                 Logger.getLogger(ConsultaCurso.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BT_Buscar = new javax.swing.JButton();
        Titulo_Menu = new javax.swing.JLabel();
        CB_Dia1 = new javax.swing.JComboBox<>();
        CB_Mes1 = new javax.swing.JComboBox<>();
        CB_Año1 = new javax.swing.JComboBox<>();
        CB_Dia2 = new javax.swing.JComboBox<>();
        CB_Mes2 = new javax.swing.JComboBox<>();
        CB_Año2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
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
        setLocation(new java.awt.Point(500, 125));
        setMinimumSize(new java.awt.Dimension(580, 480));
        getContentPane().setLayout(null);

        jTable1.setBackground(new java.awt.Color(204, 255, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Evento", "Descripción", "Horario"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 130, 540, 240);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Fecha Inicio: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 50, 90, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Fecha Final: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 80, 80, 20);

        BT_Buscar.setText("Buscar");
        BT_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(BT_Buscar);
        BT_Buscar.setBounds(430, 50, 90, 40);

        Titulo_Menu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Titulo_Menu.setText("Consulta Evento");
        getContentPane().add(Titulo_Menu);
        Titulo_Menu.setBounds(230, 20, 200, 22);

        CB_Dia1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(CB_Dia1);
        CB_Dia1.setBounds(130, 50, 50, 20);

        CB_Mes1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", " " }));
        getContentPane().add(CB_Mes1);
        CB_Mes1.setBounds(190, 50, 50, 20);

        CB_Año1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", " ", " " }));
        getContentPane().add(CB_Año1);
        CB_Año1.setBounds(250, 50, 50, 20);

        CB_Dia2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(CB_Dia2);
        CB_Dia2.setBounds(130, 80, 50, 20);

        CB_Mes2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", " " }));
        getContentPane().add(CB_Mes2);
        CB_Mes2.setBounds(190, 80, 50, 20);

        CB_Año2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", " ", " " }));
        getContentPane().add(CB_Año2);
        CB_Año2.setBounds(250, 80, 50, 20);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Registro/Fondo.png"))); // NOI18N
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 590, 430);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(106, 50));

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

    private void BT_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_BuscarActionPerformed
        // TODO add your handling code here:
        UpdateTable();
    }//GEN-LAST:event_BT_BuscarActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Admi_Curso1;
    private javax.swing.JMenuItem Admi_Puesto1;
    private javax.swing.JButton BT_Buscar;
    private javax.swing.JComboBox<String> CB_Año1;
    private javax.swing.JComboBox<String> CB_Año2;
    private javax.swing.JComboBox<String> CB_Dia1;
    private javax.swing.JComboBox<String> CB_Dia2;
    private javax.swing.JComboBox<String> CB_Mes1;
    private javax.swing.JComboBox<String> CB_Mes2;
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
    private javax.swing.JLabel Titulo_Menu;
    private javax.swing.JMenuItem TopActividades;
    private javax.swing.JMenuItem TopCurso;
    private javax.swing.JMenuItem TopDeserciones;
    private javax.swing.JMenuItem con_Empleado_Fecha;
    private javax.swing.JMenuItem con_persona_Fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
