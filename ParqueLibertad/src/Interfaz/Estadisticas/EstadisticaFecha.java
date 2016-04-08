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
        Titulo_Menu = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Re_Curso = new javax.swing.JMenuItem();
        Re_Empleado = new javax.swing.JMenuItem();
        Re_Evento = new javax.swing.JMenuItem();
        Re_Persona = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        Con_persona_ID = new javax.swing.JMenuItem();
        Con_Persona_Name = new javax.swing.JMenuItem();
        Con_persona_Lugar = new javax.swing.JMenuItem();
        con_persona_Fecha = new javax.swing.JMenuItem();
        Con_persona_deser = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
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
        jMenu10 = new javax.swing.JMenu();
        Re_Curso1 = new javax.swing.JMenuItem();
        Re_Empleado1 = new javax.swing.JMenuItem();
        Re_Evento1 = new javax.swing.JMenuItem();
        Re_Persona1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 125));
        setMinimumSize(new java.awt.Dimension(380, 320));
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

        Titulo_Menu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Titulo_Menu.setText("Estadística por Fecha");
        getContentPane().add(Titulo_Menu);
        Titulo_Menu.setBounds(70, 10, 200, 22);

        jLabel3.setText("Cantidad de personas:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 170, 140, 14);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(150, 170, 40, 20);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Imagen1.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 390, 270);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(106, 50));

        jMenu1.setBackground(new java.awt.Color(204, 255, 204));
        jMenu1.setText("   Registro");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.setFocusPainted(true);
        jMenu1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 13)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(180, 19));

        Re_Curso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Re_Curso.setBackground(new java.awt.Color(255, 255, 255));
        Re_Curso.setText("Curso");
        Re_Curso.setName("Regis_curso"); // NOI18N
        Re_Curso.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_CursoActionPerformed(evt);
            }
        });
        jMenu1.add(Re_Curso);

        Re_Empleado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        Re_Empleado.setBackground(new java.awt.Color(255, 255, 255));
        Re_Empleado.setText("Empleado");
        Re_Empleado.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_EmpleadoActionPerformed(evt);
            }
        });
        jMenu1.add(Re_Empleado);

        Re_Evento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        Re_Evento.setBackground(new java.awt.Color(255, 255, 255));
        Re_Evento.setText("Evento");
        Re_Evento.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Evento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_EventoActionPerformed(evt);
            }
        });
        jMenu1.add(Re_Evento);

        Re_Persona.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        Re_Persona.setBackground(new java.awt.Color(255, 255, 255));
        Re_Persona.setText("Persona");
        Re_Persona.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_PersonaActionPerformed(evt);
            }
        });
        jMenu1.add(Re_Persona);

        jMenuBar1.add(jMenu1);

        jMenu4.setBackground(new java.awt.Color(255, 255, 255));
        jMenu4.setText(" Consulta");
        jMenu4.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 13)); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(180, 19));

        jMenu8.setBackground(new java.awt.Color(255, 255, 255));
        jMenu8.setText("Persona");
        jMenu8.setOpaque(true);
        jMenu8.setPreferredSize(new java.awt.Dimension(100, 35));

        Con_persona_ID.setBackground(new java.awt.Color(255, 255, 255));
        Con_persona_ID.setText("Identificación");
        Con_persona_ID.setFocusCycleRoot(true);
        Con_persona_ID.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_persona_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_persona_IDActionPerformed(evt);
            }
        });
        jMenu8.add(Con_persona_ID);

        Con_Persona_Name.setBackground(new java.awt.Color(255, 255, 255));
        Con_Persona_Name.setText("Nombre");
        Con_Persona_Name.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_Persona_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_Persona_NameActionPerformed(evt);
            }
        });
        jMenu8.add(Con_Persona_Name);

        Con_persona_Lugar.setBackground(new java.awt.Color(255, 255, 255));
        Con_persona_Lugar.setText("Lugar");
        Con_persona_Lugar.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_persona_Lugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_persona_LugarActionPerformed(evt);
            }
        });
        jMenu8.add(Con_persona_Lugar);

        con_persona_Fecha.setBackground(new java.awt.Color(255, 255, 255));
        con_persona_Fecha.setText("Fecha");
        con_persona_Fecha.setPreferredSize(new java.awt.Dimension(140, 30));
        con_persona_Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                con_persona_FechaActionPerformed(evt);
            }
        });
        jMenu8.add(con_persona_Fecha);

        Con_persona_deser.setBackground(new java.awt.Color(255, 255, 255));
        Con_persona_deser.setText("Deserciones");
        Con_persona_deser.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_persona_deser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_persona_deserActionPerformed(evt);
            }
        });
        jMenu8.add(Con_persona_deser);

        jMenu4.add(jMenu8);

        jMenu9.setBackground(new java.awt.Color(255, 255, 255));
        jMenu9.setText("Empleado");
        jMenu9.setOpaque(true);
        jMenu9.setPreferredSize(new java.awt.Dimension(100, 35));
        jMenu4.add(jMenu9);

        Con_actividad.setBackground(new java.awt.Color(255, 255, 255));
        Con_actividad.setText("Actividad");
        Con_actividad.setOpaque(true);
        Con_actividad.setPreferredSize(new java.awt.Dimension(137, 30));
        Con_actividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_actividadActionPerformed(evt);
            }
        });
        jMenu4.add(Con_actividad);

        Con_Curso.setBackground(new java.awt.Color(255, 255, 255));
        Con_Curso.setText("Curso");
        Con_Curso.setOpaque(true);
        Con_Curso.setPreferredSize(new java.awt.Dimension(137, 30));
        Con_Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_CursoActionPerformed(evt);
            }
        });
        jMenu4.add(Con_Curso);

        Con_Evento.setBackground(new java.awt.Color(255, 255, 255));
        Con_Evento.setText("Evento");
        Con_Evento.setOpaque(true);
        Con_Evento.setPreferredSize(new java.awt.Dimension(137, 30));
        Con_Evento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_EventoActionPerformed(evt);
            }
        });
        jMenu4.add(Con_Evento);

        jMenuBar1.add(jMenu4);

        jMenu3.setBackground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Estadística");
        jMenu3.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 13)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(180, 19));

        jMenu7.setBackground(new java.awt.Color(255, 255, 255));
        jMenu7.setText("Persona");
        jMenu7.setOpaque(true);
        jMenu7.setPreferredSize(new java.awt.Dimension(100, 35));

        Es_persona_Fecha.setBackground(new java.awt.Color(255, 255, 255));
        Es_persona_Fecha.setText("Fecha");
        Es_persona_Fecha.setPreferredSize(new java.awt.Dimension(140, 30));
        Es_persona_Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Es_persona_FechaActionPerformed(evt);
            }
        });
        jMenu7.add(Es_persona_Fecha);

        Es_persona_lugar.setBackground(new java.awt.Color(255, 255, 255));
        Es_persona_lugar.setText("Lugar");
        Es_persona_lugar.setPreferredSize(new java.awt.Dimension(140, 30));
        Es_persona_lugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Es_persona_lugarActionPerformed(evt);
            }
        });
        jMenu7.add(Es_persona_lugar);

        Es_top_persona.setBackground(new java.awt.Color(255, 255, 255));
        Es_top_persona.setText("Top 10");
        Es_top_persona.setPreferredSize(new java.awt.Dimension(140, 30));
        Es_top_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Es_top_personaActionPerformed(evt);
            }
        });
        jMenu7.add(Es_top_persona);

        jMenu3.add(jMenu7);

        TopCurso.setBackground(new java.awt.Color(255, 255, 255));
        TopCurso.setText("Top Cursos");
        TopCurso.setPreferredSize(new java.awt.Dimension(137, 40));
        TopCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopCursoActionPerformed(evt);
            }
        });
        jMenu3.add(TopCurso);

        TopActividades.setBackground(new java.awt.Color(255, 255, 255));
        TopActividades.setText("Top Actividades");
        TopActividades.setPreferredSize(new java.awt.Dimension(137, 40));
        TopActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopActividadesActionPerformed(evt);
            }
        });
        jMenu3.add(TopActividades);

        TopDeserciones.setBackground(new java.awt.Color(255, 255, 255));
        TopDeserciones.setText("Top Deserciones");
        TopDeserciones.setPreferredSize(new java.awt.Dimension(137, 40));
        TopDeserciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopDesercionesActionPerformed(evt);
            }
        });
        jMenu3.add(TopDeserciones);

        jMenuBar1.add(jMenu3);

        jMenu10.setBackground(new java.awt.Color(204, 255, 204));
        jMenu10.setText("     Admi");
        jMenu10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu10.setFocusPainted(true);
        jMenu10.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 13)); // NOI18N
        jMenu10.setPreferredSize(new java.awt.Dimension(180, 19));

        Re_Curso1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Re_Curso1.setBackground(new java.awt.Color(255, 255, 255));
        Re_Curso1.setText("Curso");
        Re_Curso1.setName("Regis_curso"); // NOI18N
        Re_Curso1.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Curso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_Curso1ActionPerformed(evt);
            }
        });
        jMenu10.add(Re_Curso1);

        Re_Empleado1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        Re_Empleado1.setBackground(new java.awt.Color(255, 255, 255));
        Re_Empleado1.setText("Empleado");
        Re_Empleado1.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Empleado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_Empleado1ActionPerformed(evt);
            }
        });
        jMenu10.add(Re_Empleado1);

        Re_Evento1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        Re_Evento1.setBackground(new java.awt.Color(255, 255, 255));
        Re_Evento1.setText("Evento");
        Re_Evento1.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Evento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_Evento1ActionPerformed(evt);
            }
        });
        jMenu10.add(Re_Evento1);

        Re_Persona1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        Re_Persona1.setBackground(new java.awt.Color(255, 255, 255));
        Re_Persona1.setText("Persona");
        Re_Persona1.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Persona1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_Persona1ActionPerformed(evt);
            }
        });
        jMenu10.add(Re_Persona1);

        jMenuBar1.add(jMenu10);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PT_FechaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PT_FechaFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PT_FechaFinalActionPerformed

    private void BT_AnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_AnalizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BT_AnalizarActionPerformed

    private void Re_CursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_CursoActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroClase().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_CursoActionPerformed

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

    private void Re_PersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_PersonaActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroPersonas().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_PersonaActionPerformed

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
    }//GEN-LAST:event_TopDesercionesActionPerformed

    private void Re_Curso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_Curso1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Re_Curso1ActionPerformed

    private void Re_Empleado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_Empleado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Re_Empleado1ActionPerformed

    private void Re_Evento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_Evento1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Re_Evento1ActionPerformed

    private void Re_Persona1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_Persona1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Re_Persona1ActionPerformed

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
    private javax.swing.JMenuItem Con_Curso;
    private javax.swing.JMenuItem Con_Evento;
    private javax.swing.JMenuItem Con_Persona_Name;
    private javax.swing.JMenuItem Con_actividad;
    private javax.swing.JMenuItem Con_persona_ID;
    private javax.swing.JMenuItem Con_persona_Lugar;
    private javax.swing.JMenuItem Con_persona_deser;
    private javax.swing.JMenuItem Es_persona_Fecha;
    private javax.swing.JMenuItem Es_persona_lugar;
    private javax.swing.JMenuItem Es_top_persona;
    private javax.swing.JFormattedTextField PT_FechaFinal;
    private javax.swing.JFormattedTextField PT_FechaInicio;
    private javax.swing.JMenuItem Re_Curso;
    private javax.swing.JMenuItem Re_Curso1;
    private javax.swing.JMenuItem Re_Empleado;
    private javax.swing.JMenuItem Re_Empleado1;
    private javax.swing.JMenuItem Re_Evento;
    private javax.swing.JMenuItem Re_Evento1;
    private javax.swing.JMenuItem Re_Persona;
    private javax.swing.JMenuItem Re_Persona1;
    private javax.swing.JLabel Titulo_Menu;
    private javax.swing.JMenuItem TopActividades;
    private javax.swing.JMenuItem TopCurso;
    private javax.swing.JMenuItem TopDeserciones;
    private javax.swing.JMenuItem con_persona_Fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
