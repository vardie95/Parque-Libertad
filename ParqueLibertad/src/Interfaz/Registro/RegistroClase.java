/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Registro;

import Interfaz.MenuRegistro;
import Interfaz.Registro.RegistroCurso;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Diego
 */
public class RegistroClase extends javax.swing.JFrame {
        Connection con= null;
    /**
     * Creates new form RegistroCurso
     */
    public RegistroClase() {
        initComponents();
        con= parquelibertad.dbConnection.conectDB();
        llenarCurso();
        llenarMercado();
        llenarHorario();
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RegistroClase.class.getName()).log(Level.SEVERE, null, ex);
            }
        
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
    
    
    private int getidCurso(){
        int id_Curso = 0;    
        try {
                CallableStatement cstmt;
                con= parquelibertad.dbConnection.conectDB();
                String descripcion=CB_Curso.getSelectedItem().toString();
                cstmt = con.prepareCall("{?=call consulta_idCurso (?)}");
                cstmt.setString(2,descripcion);
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);
                cstmt.execute();
                id_Curso=cstmt.getInt(1);
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RegistroClase.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    
    
            return id_Curso;
    
    }
    private int getidMercado(){
        int id_Mercado = 0;    
        try {
                CallableStatement cstmt;
                con= parquelibertad.dbConnection.conectDB();
                String descripcion=CB_Mercado.getSelectedItem().toString();
                cstmt = con.prepareCall("{?=call consulta_idMercado (?)}");
                cstmt.setString(2,descripcion);
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);
                cstmt.execute();
                id_Mercado=cstmt.getInt(1);
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RegistroClase.class.getName()).log(Level.SEVERE, null, ex);
            }
            return id_Mercado;
    
    }
    
    private void RegistrarClase(){
            try {
                con = parquelibertad.dbConnection.conectDB();
                String fechaInicio=fechaInicio();
                String fechaFinal=fechaFinalizacion();
                SimpleDateFormat formato=new SimpleDateFormat("ddMMyy");
                java.util.Date parsed1 = formato.parse(fechaInicio);
                java.util.Date parsed2 = formato.parse(fechaFinal);
                java.sql.Date Initialdate= new java.sql.Date(parsed1.getTime());
                java.sql.Date Finaldate= new java.sql.Date(parsed2.getTime());
                int idCurso=getidCurso();
                int idMercado=getidMercado();
                con = parquelibertad.dbConnection.conectDB();
                String costo=TF_Costo.getText();
                CallableStatement proc= con.prepareCall("{call insertClase(?,?,?,?,?)}");
                proc.setString(1, costo);
                proc.setInt(2,idMercado);
                proc.setInt(3,idCurso);
                proc.setDate(4,Initialdate);
                proc.setDate(5,Finaldate);
                proc.execute();
                System.out.println("Registro Exitoso");
                
            } catch (ParseException ex) {
                Logger.getLogger(RegistroClase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(RegistroClase.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    
    
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    private  void llenarCurso(){
        CB_Curso.removeAllItems();
            try {
               CallableStatement cstmt =con.prepareCall("{call get_Curso(?)}");
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                cstmt.execute();
                ResultSet rs = (ResultSet)cstmt.getObject(1);
                while(rs.next()){
                   CB_Curso.addItem(rs.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private  void llenarMercado(){
        CB_Mercado.removeAllItems();
            try {
               CallableStatement cstmt =con.prepareCall("{call get_Mercado(?)}");
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                cstmt.execute();
                ResultSet rs = (ResultSet)cstmt.getObject(1);
                while(rs.next()){
                   CB_Mercado.addItem(rs.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CB_Dia = new javax.swing.JComboBox<>();
        CB_Mes = new javax.swing.JComboBox<>();
        CB_Año = new javax.swing.JComboBox<>();
        CB_Curso = new javax.swing.JComboBox<>();
        L_Curso = new javax.swing.JLabel();
        CB_Mercado = new javax.swing.JComboBox<>();
        TF_Costo = new javax.swing.JFormattedTextField();
        L_Costo = new javax.swing.JLabel();
        L_Mercado = new javax.swing.JLabel();
        L_Horario = new javax.swing.JLabel();
        B_Registrar = new javax.swing.JButton();
        Titulo_Registro_de_Curso = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        CB_Curso1 = new javax.swing.JComboBox<>();
        L_Horario1 = new javax.swing.JLabel();
        CB_Curso2 = new javax.swing.JComboBox<>();
        L_Horario3 = new javax.swing.JLabel();
        CB_Dia1 = new javax.swing.JComboBox<>();
        CB_Mes1 = new javax.swing.JComboBox<>();
        CB_Año1 = new javax.swing.JComboBox<>();
        L_Horario4 = new javax.swing.JLabel();
        L_Horario5 = new javax.swing.JLabel();
        CB_Dia2 = new javax.swing.JComboBox<>();
        CB_Mes2 = new javax.swing.JComboBox<>();
        CB_Año2 = new javax.swing.JComboBox<>();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        Re_Actividad2 = new javax.swing.JMenuItem();
        Re_Curso = new javax.swing.JMenuItem();
        Re_desercion = new javax.swing.JMenuItem();
        Re_Empleado = new javax.swing.JMenuItem();
        Re_Evento = new javax.swing.JMenuItem();
        Re_Persona = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        Ins_Actividad = new javax.swing.JMenuItem();
        Ins_Clase = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        Admi_Curso = new javax.swing.JMenuItem();
        Admi_Puesto = new javax.swing.JMenuItem();
        Admi_tipoEvento = new javax.swing.JMenuItem();
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

        CB_Dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        CB_Mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", " " }));

        CB_Año.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", " ", " " }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parque la Libertad");
        setBackground(new java.awt.Color(248, 244, 244));
        setLocation(new java.awt.Point(500, 125));
        setMinimumSize(new java.awt.Dimension(520, 450));
        setResizable(false);
        getContentPane().setLayout(null);

        CB_Curso.setBackground(new java.awt.Color(204, 255, 204));
        CB_Curso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre" }));
        getContentPane().add(CB_Curso);
        CB_Curso.setBounds(130, 60, 140, 28);

        L_Curso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Curso.setText("Curso: ");
        getContentPane().add(L_Curso);
        L_Curso.setBounds(57, 60, 60, 28);

        CB_Mercado.setBackground(new java.awt.Color(204, 255, 204));
        CB_Mercado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adultos" }));
        getContentPane().add(CB_Mercado);
        CB_Mercado.setBounds(130, 110, 146, 31);

        TF_Costo.setBackground(new java.awt.Color(204, 255, 204));
        getContentPane().add(TF_Costo);
        TF_Costo.setBounds(110, 290, 135, 30);

        L_Costo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Costo.setText("Costo: ");
        getContentPane().add(L_Costo);
        L_Costo.setBounds(30, 290, 70, 28);

        L_Mercado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Mercado.setText("Mercado: ");
        getContentPane().add(L_Mercado);
        L_Mercado.setBounds(58, 110, 70, 28);

        L_Horario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Horario.setText("Hora:");
        getContentPane().add(L_Horario);
        L_Horario.setBounds(220, 180, 70, 28);

        B_Registrar.setText("Registrar");
        B_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(B_Registrar);
        B_Registrar.setBounds(380, 310, 100, 40);

        Titulo_Registro_de_Curso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Titulo_Registro_de_Curso.setText("Registro de Clase");
        getContentPane().add(Titulo_Registro_de_Curso);
        Titulo_Registro_de_Curso.setBounds(200, 20, 136, 22);

        jButton1.setText("Otro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(320, 60, 73, 23);

        CB_Curso1.setBackground(new java.awt.Color(204, 255, 204));
        CB_Curso1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horario" }));
        getContentPane().add(CB_Curso1);
        CB_Curso1.setBounds(270, 180, 120, 28);

        L_Horario1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Horario1.setText("Horario: ");
        getContentPane().add(L_Horario1);
        L_Horario1.setBounds(40, 150, 70, 28);

        CB_Curso2.setBackground(new java.awt.Color(204, 255, 204));
        CB_Curso2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        CB_Curso2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Curso2ActionPerformed(evt);
            }
        });
        getContentPane().add(CB_Curso2);
        CB_Curso2.setBounds(100, 180, 100, 28);

        L_Horario3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Horario3.setText("Fecha Finalización:");
        getContentPane().add(L_Horario3);
        L_Horario3.setBounds(270, 210, 120, 28);

        CB_Dia1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(CB_Dia1);
        CB_Dia1.setBounds(50, 240, 50, 20);

        CB_Mes1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", " " }));
        getContentPane().add(CB_Mes1);
        CB_Mes1.setBounds(110, 240, 50, 20);

        CB_Año1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", " ", " " }));
        getContentPane().add(CB_Año1);
        CB_Año1.setBounds(170, 240, 50, 20);

        L_Horario4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Horario4.setText("Dia: ");
        getContentPane().add(L_Horario4);
        L_Horario4.setBounds(60, 180, 70, 28);

        L_Horario5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Horario5.setText("Fecha Inicio:");
        getContentPane().add(L_Horario5);
        L_Horario5.setBounds(40, 210, 120, 28);

        CB_Dia2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(CB_Dia2);
        CB_Dia2.setBounds(240, 240, 50, 20);

        CB_Mes2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", " " }));
        getContentPane().add(CB_Mes2);
        CB_Mes2.setBounds(300, 240, 50, 20);

        CB_Año2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", " ", " " }));
        getContentPane().add(CB_Año2);
        CB_Año2.setBounds(360, 240, 50, 20);

        jMenuBar3.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar3.setPreferredSize(new java.awt.Dimension(106, 50));

        jMenu5.setBackground(new java.awt.Color(251, 251, 251));
        jMenu5.setText("   Registro");
        jMenu5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu5.setFocusPainted(true);
        jMenu5.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 13)); // NOI18N
        jMenu5.setPreferredSize(new java.awt.Dimension(180, 19));

        Re_Actividad2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        Re_Actividad2.setBackground(new java.awt.Color(251, 251, 251));
        Re_Actividad2.setText("Actividad");
        Re_Actividad2.setName("Regis_curso"); // NOI18N
        Re_Actividad2.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Actividad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_Actividad2ActionPerformed(evt);
            }
        });
        jMenu5.add(Re_Actividad2);

        Re_Curso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Re_Curso.setBackground(new java.awt.Color(251, 251, 251));
        Re_Curso.setText("Clase");
        Re_Curso.setName("Regis_curso"); // NOI18N
        Re_Curso.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_CursoActionPerformed(evt);
            }
        });
        jMenu5.add(Re_Curso);

        Re_desercion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        Re_desercion.setBackground(new java.awt.Color(251, 251, 251));
        Re_desercion.setText("Deserción");
        Re_desercion.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_desercion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_desercionActionPerformed(evt);
            }
        });
        jMenu5.add(Re_desercion);

        Re_Empleado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        Re_Empleado.setBackground(new java.awt.Color(251, 251, 251));
        Re_Empleado.setText("Empleado");
        Re_Empleado.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_EmpleadoActionPerformed(evt);
            }
        });
        jMenu5.add(Re_Empleado);

        Re_Evento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        Re_Evento.setBackground(new java.awt.Color(251, 251, 251));
        Re_Evento.setText("Evento");
        Re_Evento.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Evento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_EventoActionPerformed(evt);
            }
        });
        jMenu5.add(Re_Evento);

        Re_Persona.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        Re_Persona.setBackground(new java.awt.Color(251, 251, 251));
        Re_Persona.setText("Persona");
        Re_Persona.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_PersonaActionPerformed(evt);
            }
        });
        jMenu5.add(Re_Persona);

        jMenu11.setText("Inscripción");
        jMenu11.setPreferredSize(new java.awt.Dimension(100, 35));

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

        jMenu5.add(jMenu11);

        jMenu10.setText("Administrar");
        jMenu10.setPreferredSize(new java.awt.Dimension(100, 35));

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

        jMenu5.add(jMenu10);

        jMenuBar3.add(jMenu5);

        jMenu4.setText("  Consulta");
        jMenu4.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 13)); // NOI18N
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

        jMenuBar3.add(jMenu4);

        jMenu3.setText("   Estadística");
        jMenu3.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 13)); // NOI18N
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

        jMenuBar3.add(jMenu3);

        setJMenuBar(jMenuBar3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RegistrarActionPerformed
        // TODO add your handling code here:
        if(TF_Costo.equals("")){
               System.out.println("error");
        
        }else{
            RegistrarClase();
        }
    }//GEN-LAST:event_B_RegistrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        new RegistroCurso().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Re_Actividad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_Actividad2ActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroActividad().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_Actividad2ActionPerformed

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

    private void Re_PersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Re_PersonaActionPerformed
        // TODO add your handling code here:
        new Interfaz.Registro.RegistroPersonas().setVisible(true);
        dispose();
    }//GEN-LAST:event_Re_PersonaActionPerformed

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
        new Interfaz.Consultas.ConsultaEmpleadoIdentificacion().setVisible(true);
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

    private void CB_Curso2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Curso2ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==CB_Curso2){
            if(CB_Curso2.getSelectedItem()!=null){
            llenarHorario();
            }
        }
        
     
    }//GEN-LAST:event_CB_Curso2ActionPerformed

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
    private javax.swing.JMenuItem Admi_Curso;
    private javax.swing.JMenuItem Admi_Puesto;
    private javax.swing.JMenuItem Admi_tipoEvento;
    private javax.swing.JButton B_Registrar;
    private javax.swing.JComboBox<String> CB_Año;
    private javax.swing.JComboBox<String> CB_Año1;
    private javax.swing.JComboBox<String> CB_Año2;
    private javax.swing.JComboBox<String> CB_Curso;
    private javax.swing.JComboBox<String> CB_Curso1;
    private javax.swing.JComboBox<String> CB_Curso2;
    private javax.swing.JComboBox<String> CB_Dia;
    private javax.swing.JComboBox<String> CB_Dia1;
    private javax.swing.JComboBox<String> CB_Dia2;
    private javax.swing.JComboBox<String> CB_Mercado;
    private javax.swing.JComboBox<String> CB_Mes;
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
    private javax.swing.JLabel L_Costo;
    private javax.swing.JLabel L_Curso;
    private javax.swing.JLabel L_Horario;
    private javax.swing.JLabel L_Horario1;
    private javax.swing.JLabel L_Horario3;
    private javax.swing.JLabel L_Horario4;
    private javax.swing.JLabel L_Horario5;
    private javax.swing.JLabel L_Mercado;
    private javax.swing.JMenuItem Re_Actividad2;
    private javax.swing.JMenuItem Re_Curso;
    private javax.swing.JMenuItem Re_Empleado;
    private javax.swing.JMenuItem Re_Evento;
    private javax.swing.JMenuItem Re_Persona;
    private javax.swing.JMenuItem Re_desercion;
    private javax.swing.JFormattedTextField TF_Costo;
    private javax.swing.JLabel Titulo_Registro_de_Curso;
    private javax.swing.JMenuItem TopActividades;
    private javax.swing.JMenuItem TopCurso;
    private javax.swing.JMenuItem TopDeserciones;
    private javax.swing.JMenuItem con_Empleado_Fecha;
    private javax.swing.JMenuItem con_persona_Fecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar3;
    // End of variables declaration//GEN-END:variables
}
