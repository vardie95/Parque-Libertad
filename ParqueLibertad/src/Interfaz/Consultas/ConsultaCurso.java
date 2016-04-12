/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Consultas;

/**
 *
 * @author Luis Diego
 */
public class ConsultaCurso extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaFecha
     */
    public ConsultaCurso() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PT_FechaInicio = new javax.swing.JFormattedTextField();
        PT_FechaFinal = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BT_Buscar = new javax.swing.JButton();
        Titulo_Menu = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu15 = new javax.swing.JMenu();
        Re_Actividad = new javax.swing.JMenuItem();
        Re_Curso4 = new javax.swing.JMenuItem();
        Re_desercion = new javax.swing.JMenuItem();
        Re_Empleado4 = new javax.swing.JMenuItem();
        Re_Evento4 = new javax.swing.JMenuItem();
        Re_Persona4 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        Ins_Actividad = new javax.swing.JMenuItem();
        Ins_Clase = new javax.swing.JMenuItem();
        jMenu16 = new javax.swing.JMenu();
        Admi_Curso = new javax.swing.JMenuItem();
        Admi_Puesto = new javax.swing.JMenuItem();
        Admi_tipoEvento = new javax.swing.JMenuItem();
        jMenu17 = new javax.swing.JMenu();
        jMenu18 = new javax.swing.JMenu();
        Con_persona_ID2 = new javax.swing.JMenuItem();
        Con_Persona_Name2 = new javax.swing.JMenuItem();
        Con_persona_Lugar2 = new javax.swing.JMenuItem();
        con_persona_Fecha2 = new javax.swing.JMenuItem();
        Con_persona_deser2 = new javax.swing.JMenuItem();
        jMenu19 = new javax.swing.JMenu();
        Con_Empleado_ID = new javax.swing.JMenuItem();
        Con_Empleado_Name = new javax.swing.JMenuItem();
        con_Empleado_Fecha = new javax.swing.JMenuItem();
        Con_actividad2 = new javax.swing.JMenuItem();
        Con_Curso2 = new javax.swing.JMenuItem();
        Con_Evento2 = new javax.swing.JMenuItem();
        jMenu20 = new javax.swing.JMenu();
        jMenu21 = new javax.swing.JMenu();
        Es_persona_Fecha2 = new javax.swing.JMenuItem();
        Es_persona_lugar2 = new javax.swing.JMenuItem();
        Es_top_persona2 = new javax.swing.JMenuItem();
        TopCurso2 = new javax.swing.JMenuItem();
        TopActividades2 = new javax.swing.JMenuItem();
        TopDeserciones2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 125));
        setMinimumSize(new java.awt.Dimension(580, 480));
        getContentPane().setLayout(null);

        jTable1.setBackground(new java.awt.Color(204, 255, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Curso", "Descripción", "Mercado", "Costo"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 140, 540, 230);
        getContentPane().add(PT_FechaInicio);
        PT_FechaInicio.setBounds(150, 50, 150, 20);

        PT_FechaFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PT_FechaFinalActionPerformed(evt);
            }
        });
        getContentPane().add(PT_FechaFinal);
        PT_FechaFinal.setBounds(150, 80, 150, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Fecha Inicio: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 50, 90, 20);

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
        BT_Buscar.setBounds(430, 60, 80, 34);

        Titulo_Menu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Titulo_Menu.setText("Consulta Curso");
        getContentPane().add(Titulo_Menu);
        Titulo_Menu.setBounds(240, 20, 200, 22);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/13010187_1077907862232310_2035377480_o.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 580, 420);

        jMenuBar3.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar3.setPreferredSize(new java.awt.Dimension(106, 50));

        jMenu15.setBackground(new java.awt.Color(251, 251, 251));
        jMenu15.setText("   Registro");
        jMenu15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu15.setFocusPainted(true);
        jMenu15.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 13)); // NOI18N
        jMenu15.setPreferredSize(new java.awt.Dimension(180, 19));

        Re_Actividad.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        Re_Actividad.setBackground(new java.awt.Color(251, 251, 251));
        Re_Actividad.setText("Actividad");
        Re_Actividad.setName("Regis_curso"); // NOI18N
        Re_Actividad.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Actividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_ActividadActionPerformed(evt);
            }
        });
        jMenu15.add(Re_Actividad);

        Re_Curso4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Re_Curso4.setBackground(new java.awt.Color(251, 251, 251));
        Re_Curso4.setText("Clase");
        Re_Curso4.setName("Regis_curso"); // NOI18N
        Re_Curso4.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Curso4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_Curso4ActionPerformed(evt);
            }
        });
        jMenu15.add(Re_Curso4);

        Re_desercion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        Re_desercion.setBackground(new java.awt.Color(251, 251, 251));
        Re_desercion.setText("Deserción");
        Re_desercion.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_desercion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_desercionActionPerformed(evt);
            }
        });
        jMenu15.add(Re_desercion);

        Re_Empleado4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        Re_Empleado4.setBackground(new java.awt.Color(251, 251, 251));
        Re_Empleado4.setText("Empleado");
        Re_Empleado4.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Empleado4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_Empleado4ActionPerformed(evt);
            }
        });
        jMenu15.add(Re_Empleado4);

        Re_Evento4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        Re_Evento4.setBackground(new java.awt.Color(251, 251, 251));
        Re_Evento4.setText("Evento");
        Re_Evento4.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Evento4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_Evento4ActionPerformed(evt);
            }
        });
        jMenu15.add(Re_Evento4);

        Re_Persona4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        Re_Persona4.setBackground(new java.awt.Color(251, 251, 251));
        Re_Persona4.setText("Persona");
        Re_Persona4.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Persona4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_Persona4ActionPerformed(evt);
            }
        });
        jMenu15.add(Re_Persona4);

        jMenu11.setBackground(new java.awt.Color(255, 255, 255));
        jMenu11.setText("Inscripción");
        jMenu11.setOpaque(true);
        jMenu11.setPreferredSize(new java.awt.Dimension(100, 35));

        Ins_Actividad.setBackground(new java.awt.Color(255, 255, 255));
        Ins_Actividad.setText("Actividad");
        Ins_Actividad.setFocusCycleRoot(true);
        Ins_Actividad.setPreferredSize(new java.awt.Dimension(140, 30));
        Ins_Actividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ins_ActividadActionPerformed(evt);
            }
        });
        jMenu11.add(Ins_Actividad);

        Ins_Clase.setBackground(new java.awt.Color(255, 255, 255));
        Ins_Clase.setText("Clase");
        Ins_Clase.setPreferredSize(new java.awt.Dimension(140, 30));
        Ins_Clase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ins_ClaseActionPerformed(evt);
            }
        });
        jMenu11.add(Ins_Clase);

        jMenu15.add(jMenu11);

        jMenu16.setBackground(new java.awt.Color(255, 255, 255));
        jMenu16.setText("Administrar");
        jMenu16.setOpaque(true);
        jMenu16.setPreferredSize(new java.awt.Dimension(100, 35));

        Admi_Curso.setBackground(new java.awt.Color(255, 255, 255));
        Admi_Curso.setText("Curso");
        Admi_Curso.setFocusCycleRoot(true);
        Admi_Curso.setPreferredSize(new java.awt.Dimension(140, 30));
        Admi_Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Admi_CursoActionPerformed(evt);
            }
        });
        jMenu16.add(Admi_Curso);

        Admi_Puesto.setBackground(new java.awt.Color(255, 255, 255));
        Admi_Puesto.setText("Puesto");
        Admi_Puesto.setPreferredSize(new java.awt.Dimension(140, 30));
        Admi_Puesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Admi_PuestoActionPerformed(evt);
            }
        });
        jMenu16.add(Admi_Puesto);

        Admi_tipoEvento.setBackground(new java.awt.Color(255, 255, 255));
        Admi_tipoEvento.setText("Tipo Evento");
        Admi_tipoEvento.setPreferredSize(new java.awt.Dimension(140, 30));
        Admi_tipoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Admi_tipoEventoActionPerformed(evt);
            }
        });
        jMenu16.add(Admi_tipoEvento);

        jMenu15.add(jMenu16);

        jMenuBar3.add(jMenu15);

        jMenu17.setBackground(new java.awt.Color(255, 255, 255));
        jMenu17.setText("  Consulta");
        jMenu17.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 13)); // NOI18N
        jMenu17.setPreferredSize(new java.awt.Dimension(180, 19));

        jMenu18.setBackground(new java.awt.Color(253, 253, 253));
        jMenu18.setText("Persona");
        jMenu18.setOpaque(true);
        jMenu18.setPreferredSize(new java.awt.Dimension(100, 35));

        Con_persona_ID2.setBackground(new java.awt.Color(253, 253, 253));
        Con_persona_ID2.setText("Identificación");
        Con_persona_ID2.setFocusCycleRoot(true);
        Con_persona_ID2.setOpaque(true);
        Con_persona_ID2.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_persona_ID2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_persona_ID2ActionPerformed(evt);
            }
        });
        jMenu18.add(Con_persona_ID2);

        Con_Persona_Name2.setBackground(new java.awt.Color(253, 253, 253));
        Con_Persona_Name2.setText("Nombre");
        Con_Persona_Name2.setOpaque(true);
        Con_Persona_Name2.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_Persona_Name2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_Persona_Name2ActionPerformed(evt);
            }
        });
        jMenu18.add(Con_Persona_Name2);

        Con_persona_Lugar2.setBackground(new java.awt.Color(253, 253, 253));
        Con_persona_Lugar2.setText("Lugar");
        Con_persona_Lugar2.setOpaque(true);
        Con_persona_Lugar2.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_persona_Lugar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_persona_Lugar2ActionPerformed(evt);
            }
        });
        jMenu18.add(Con_persona_Lugar2);

        con_persona_Fecha2.setBackground(new java.awt.Color(253, 253, 253));
        con_persona_Fecha2.setText("Fecha");
        con_persona_Fecha2.setOpaque(true);
        con_persona_Fecha2.setPreferredSize(new java.awt.Dimension(140, 30));
        con_persona_Fecha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                con_persona_Fecha2ActionPerformed(evt);
            }
        });
        jMenu18.add(con_persona_Fecha2);

        Con_persona_deser2.setBackground(new java.awt.Color(253, 253, 253));
        Con_persona_deser2.setText("Deserciones");
        Con_persona_deser2.setOpaque(true);
        Con_persona_deser2.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_persona_deser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_persona_deser2ActionPerformed(evt);
            }
        });
        jMenu18.add(Con_persona_deser2);

        jMenu17.add(jMenu18);

        jMenu19.setBackground(new java.awt.Color(255, 255, 255));
        jMenu19.setText("Empleado");
        jMenu19.setOpaque(true);
        jMenu19.setPreferredSize(new java.awt.Dimension(100, 35));

        Con_Empleado_ID.setBackground(new java.awt.Color(252, 252, 252));
        Con_Empleado_ID.setText("Identificación");
        Con_Empleado_ID.setFocusCycleRoot(true);
        Con_Empleado_ID.setOpaque(true);
        Con_Empleado_ID.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_Empleado_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_Empleado_IDActionPerformed(evt);
            }
        });
        jMenu19.add(Con_Empleado_ID);

        Con_Empleado_Name.setBackground(new java.awt.Color(252, 252, 252));
        Con_Empleado_Name.setText("Nombre");
        Con_Empleado_Name.setOpaque(true);
        Con_Empleado_Name.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_Empleado_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_Empleado_NameActionPerformed(evt);
            }
        });
        jMenu19.add(Con_Empleado_Name);

        con_Empleado_Fecha.setBackground(new java.awt.Color(252, 252, 252));
        con_Empleado_Fecha.setText("Fecha");
        con_Empleado_Fecha.setOpaque(true);
        con_Empleado_Fecha.setPreferredSize(new java.awt.Dimension(140, 30));
        con_Empleado_Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                con_Empleado_FechaActionPerformed(evt);
            }
        });
        jMenu19.add(con_Empleado_Fecha);

        jMenu17.add(jMenu19);

        Con_actividad2.setBackground(new java.awt.Color(255, 255, 255));
        Con_actividad2.setText("Actividad");
        Con_actividad2.setPreferredSize(new java.awt.Dimension(137, 30));
        Con_actividad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_actividad2ActionPerformed(evt);
            }
        });
        jMenu17.add(Con_actividad2);

        Con_Curso2.setBackground(new java.awt.Color(255, 255, 255));
        Con_Curso2.setText("Curso");
        Con_Curso2.setPreferredSize(new java.awt.Dimension(137, 30));
        Con_Curso2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_Curso2ActionPerformed(evt);
            }
        });
        jMenu17.add(Con_Curso2);

        Con_Evento2.setBackground(new java.awt.Color(255, 255, 255));
        Con_Evento2.setText("Evento");
        Con_Evento2.setPreferredSize(new java.awt.Dimension(137, 30));
        Con_Evento2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_Evento2ActionPerformed(evt);
            }
        });
        jMenu17.add(Con_Evento2);

        jMenuBar3.add(jMenu17);

        jMenu20.setBackground(new java.awt.Color(255, 255, 255));
        jMenu20.setText("   Estadística");
        jMenu20.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 13)); // NOI18N
        jMenu20.setPreferredSize(new java.awt.Dimension(180, 19));

        jMenu21.setBackground(new java.awt.Color(253, 253, 253));
        jMenu21.setText("Persona");
        jMenu21.setOpaque(true);
        jMenu21.setPreferredSize(new java.awt.Dimension(100, 35));

        Es_persona_Fecha2.setBackground(new java.awt.Color(255, 255, 255));
        Es_persona_Fecha2.setText("Fecha");
        Es_persona_Fecha2.setOpaque(true);
        Es_persona_Fecha2.setPreferredSize(new java.awt.Dimension(140, 30));
        Es_persona_Fecha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Es_persona_Fecha2ActionPerformed(evt);
            }
        });
        jMenu21.add(Es_persona_Fecha2);

        Es_persona_lugar2.setBackground(new java.awt.Color(255, 255, 255));
        Es_persona_lugar2.setText("Lugar");
        Es_persona_lugar2.setOpaque(true);
        Es_persona_lugar2.setPreferredSize(new java.awt.Dimension(140, 30));
        Es_persona_lugar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Es_persona_lugar2ActionPerformed(evt);
            }
        });
        jMenu21.add(Es_persona_lugar2);

        Es_top_persona2.setBackground(new java.awt.Color(255, 255, 255));
        Es_top_persona2.setText("Top 10");
        Es_top_persona2.setOpaque(true);
        Es_top_persona2.setPreferredSize(new java.awt.Dimension(140, 30));
        Es_top_persona2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Es_top_persona2ActionPerformed(evt);
            }
        });
        jMenu21.add(Es_top_persona2);

        jMenu20.add(jMenu21);

        TopCurso2.setBackground(new java.awt.Color(255, 255, 255));
        TopCurso2.setText("Top Cursos");
        TopCurso2.setPreferredSize(new java.awt.Dimension(137, 40));
        TopCurso2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopCurso2ActionPerformed(evt);
            }
        });
        jMenu20.add(TopCurso2);

        TopActividades2.setBackground(new java.awt.Color(255, 255, 255));
        TopActividades2.setText("Top Actividades");
        TopActividades2.setPreferredSize(new java.awt.Dimension(137, 40));
        TopActividades2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopActividades2ActionPerformed(evt);
            }
        });
        jMenu20.add(TopActividades2);

        TopDeserciones2.setBackground(new java.awt.Color(255, 255, 255));
        TopDeserciones2.setText("Top Deserciones");
        TopDeserciones2.setPreferredSize(new java.awt.Dimension(137, 40));
        TopDeserciones2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopDeserciones2ActionPerformed(evt);
            }
        });
        jMenu20.add(TopDeserciones2);

        jMenuBar3.add(jMenu20);

        setJMenuBar(jMenuBar3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PT_FechaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PT_FechaFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PT_FechaFinalActionPerformed

    private void BT_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_BuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BT_BuscarActionPerformed

    private void Re_ActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_ActividadActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroActividad().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_ActividadActionPerformed

    private void Re_Curso4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_Curso4ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroClase().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_Curso4ActionPerformed

    private void Re_desercionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_desercionActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroDesercion().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_desercionActionPerformed

    private void Re_Empleado4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_Empleado4ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroEmpleado().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_Empleado4ActionPerformed

    private void Re_Evento4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_Evento4ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroEvento().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_Evento4ActionPerformed

    private void Re_Persona4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_Persona4ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroPersonas().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_Persona4ActionPerformed

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

    private void Con_persona_ID2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_persona_ID2ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaIndentificacionPersona().setVisible(true);
        dispose();
    }//GEN-LAST:event_Con_persona_ID2ActionPerformed

    private void Con_Persona_Name2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_Persona_Name2ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaNombre().setVisible(true);
        dispose();
    }//GEN-LAST:event_Con_Persona_Name2ActionPerformed

    private void Con_persona_Lugar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_persona_Lugar2ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaLugarPersona().setVisible(true);
        dispose();
    }//GEN-LAST:event_Con_persona_Lugar2ActionPerformed

    private void con_persona_Fecha2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_con_persona_Fecha2ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaFecha().setVisible(true);
        dispose();
    }//GEN-LAST:event_con_persona_Fecha2ActionPerformed

    private void Con_persona_deser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_persona_deser2ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaDesertaPersona().setVisible(true);
        dispose();
    }//GEN-LAST:event_Con_persona_deser2ActionPerformed

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
        new Interfaz.Consultas.ConsultaEmpleadoIdentificacion().setVisible(true);
        dispose();
    }//GEN-LAST:event_con_Empleado_FechaActionPerformed

    private void Con_actividad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_actividad2ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaActividad().setVisible(true);
        dispose();
    }//GEN-LAST:event_Con_actividad2ActionPerformed

    private void Con_Curso2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_Curso2ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaCurso().setVisible(true);
        dispose();
    }//GEN-LAST:event_Con_Curso2ActionPerformed

    private void Con_Evento2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_Evento2ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Consultas.ConsultaEvento().setVisible(true);
        dispose();
    }//GEN-LAST:event_Con_Evento2ActionPerformed

    private void Es_persona_Fecha2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Es_persona_Fecha2ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Estadisticas.EstadisticaFecha().setVisible(true);
        dispose();
    }//GEN-LAST:event_Es_persona_Fecha2ActionPerformed

    private void Es_persona_lugar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Es_persona_lugar2ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Estadisticas.EstadisticaLugar().setVisible(true);
        dispose();
    }//GEN-LAST:event_Es_persona_lugar2ActionPerformed

    private void Es_top_persona2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Es_top_persona2ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Estadisticas.Top10Personas().setVisible(true);
        dispose();
    }//GEN-LAST:event_Es_top_persona2ActionPerformed

    private void TopCurso2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopCurso2ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Estadisticas.Top5Cursos().setVisible(true);
        dispose();
    }//GEN-LAST:event_TopCurso2ActionPerformed

    private void TopActividades2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopActividades2ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Estadisticas.Top5Actividades().setVisible(true);
        dispose();
    }//GEN-LAST:event_TopActividades2ActionPerformed

    private void TopDeserciones2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopDeserciones2ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Estadisticas.Top5Deserciones().setVisible(true);
        dispose();
    }//GEN-LAST:event_TopDeserciones2ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Admi_Curso;
    private javax.swing.JMenuItem Admi_Puesto;
    private javax.swing.JMenuItem Admi_tipoEvento;
    private javax.swing.JButton BT_Buscar;
    private javax.swing.JMenuItem Con_Curso2;
    private javax.swing.JMenuItem Con_Empleado_ID;
    private javax.swing.JMenuItem Con_Empleado_Name;
    private javax.swing.JMenuItem Con_Evento2;
    private javax.swing.JMenuItem Con_Persona_Name2;
    private javax.swing.JMenuItem Con_actividad2;
    private javax.swing.JMenuItem Con_persona_ID2;
    private javax.swing.JMenuItem Con_persona_Lugar2;
    private javax.swing.JMenuItem Con_persona_deser2;
    private javax.swing.JMenuItem Es_persona_Fecha2;
    private javax.swing.JMenuItem Es_persona_lugar2;
    private javax.swing.JMenuItem Es_top_persona2;
    private javax.swing.JMenuItem Ins_Actividad;
    private javax.swing.JMenuItem Ins_Clase;
    private javax.swing.JFormattedTextField PT_FechaFinal;
    private javax.swing.JFormattedTextField PT_FechaInicio;
    private javax.swing.JMenuItem Re_Actividad;
    private javax.swing.JMenuItem Re_Curso4;
    private javax.swing.JMenuItem Re_Empleado4;
    private javax.swing.JMenuItem Re_Evento4;
    private javax.swing.JMenuItem Re_Persona4;
    private javax.swing.JMenuItem Re_desercion;
    private javax.swing.JLabel Titulo_Menu;
    private javax.swing.JMenuItem TopActividades2;
    private javax.swing.JMenuItem TopCurso2;
    private javax.swing.JMenuItem TopDeserciones2;
    private javax.swing.JMenuItem con_Empleado_Fecha;
    private javax.swing.JMenuItem con_persona_Fecha2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu20;
    private javax.swing.JMenu jMenu21;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
