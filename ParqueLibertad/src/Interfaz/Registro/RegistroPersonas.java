/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Registro;

import Interfaz.Inicio;
import Interfaz.MenuRegistro;
import java.awt.event.ItemListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Luis Diego
 */
public class RegistroPersonas extends javax.swing.JFrame {
        Connection con= null;
        int tipo=1;
    /**
     * Creates new form RegistroPersonas
     */
    public RegistroPersonas() {
        initComponents();
        con= parquelibertad.dbConnection.conectDB();
        llenarpais();
        llenarNacionalidad();
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RegistroPersonas.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public final  void llenarpais() {
        CB_Pais.removeAllItems();
            try {
               CallableStatement cstmt = con.prepareCall("{call get_pais(?)}");
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                cstmt.execute();
                ResultSet rs = (ResultSet)cstmt.getObject(1);
                while(rs.next()){
                   CB_Pais.addItem(rs.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
   public final void LlenarProvincia(){
       CB_Provincia.removeAllItems();
       CallableStatement cstmt;
            try {
                con= parquelibertad.dbConnection.conectDB();
                cstmt = con.prepareCall("{?=call consulta_idPais (?)}");
                String descripcion=CB_Pais.getSelectedItem().toString();
                cstmt.setString(2,descripcion);
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);
                cstmt.execute();
                int id_pais= cstmt.getInt(1);
                CallableStatement cstmt1 = con.prepareCall("{call get_provincia(?,?)}");
                cstmt1.setInt(1,id_pais);
                cstmt1.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
                cstmt1.execute();
                ResultSet rs = (ResultSet)cstmt1.getObject(2);
                while(rs.next()){
                   CB_Provincia.addItem(rs.getString(1));
                } 
              con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RegistroPersonas.class.getName()).log(Level.SEVERE, null, ex);
            }
   
   }
   public final void LlenarCanton(){
       CallableStatement cstmt;
            try {
                CB_Canton.removeAllItems();
                con= parquelibertad.dbConnection.conectDB();
                cstmt = con.prepareCall("{?=call consulta_idProvincia (?)}");
                String descripcion=CB_Provincia.getSelectedItem().toString();
                cstmt.setString(2,descripcion);
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);
                cstmt.execute();
                int id_provincia= cstmt.getInt(1);
                CallableStatement cstmt1 = con.prepareCall("{call get_Canton(?,?)}");
                cstmt1.setInt(1,id_provincia);
                cstmt1.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
                cstmt1.execute();
                ResultSet rs = (ResultSet)cstmt1.getObject(2);
                while(rs.next()){
                   CB_Canton.addItem(rs.getString(1));
                } 
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RegistroPersonas.class.getName()).log(Level.SEVERE, null, ex);
            }
   
   }
   public final void LlenarDistrito(){
       CallableStatement cstmt;
            try {
                CB_Distrito.removeAllItems();
                con= parquelibertad.dbConnection.conectDB();
                cstmt = con.prepareCall("{?=call consulta_idCanton (?)}");
                String descripcion=CB_Canton.getSelectedItem().toString();
                cstmt.setString(2,descripcion);
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);
                cstmt.execute();
                int id_provincia= cstmt.getInt(1);
                System.out.println(id_provincia);
                CallableStatement cstmt1 = con.prepareCall("{call get_Distrito(?,?)}");
                cstmt1.setInt(1,id_provincia);
                cstmt1.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
                cstmt1.execute();
                ResultSet rs = (ResultSet)cstmt1.getObject(2);
                while(rs.next()){
                   CB_Distrito.addItem(rs.getString(1));
                } 
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RegistroPersonas.class.getName()).log(Level.SEVERE, null, ex);
            }
   
   }
   
    public final  void llenarNacionalidad() {
        CB_Nacionalidad.removeAllItems();
            try {
               con= parquelibertad.dbConnection.conectDB();
               CallableStatement cstmt = con.prepareCall("{call get_Nacionalidad(?)}");
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                cstmt.execute();
                ResultSet rs = (ResultSet)cstmt.getObject(1);
                while(rs.next()){
                   CB_Nacionalidad.addItem(rs.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public final void RegistrarPersona(){
        CallableStatement cstmt;
        int ID_Nacionalidad;
        int ID_Distrito;
        int identificacion=Integer.parseInt(TF_Identificacion.getText());
        String Nombre=TF_Nombre.getText();
        String Apellido1=TF_Apellido1.getText();
        String Apellido2=TF_Apellido2.getText();
        String Direccion=jTextArea1.getText();
        con= parquelibertad.dbConnection.conectDB();
            try {
                cstmt = con.prepareCall("{?=call consulta_idDistrito (?)}");
                String descripcion=CB_Distrito.getSelectedItem().toString();
                cstmt.setString(2,descripcion);
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);
                cstmt.execute();
                int idDistrito=cstmt.getInt(1);
                CallableStatement proc= con.prepareCall("{call insertPersona(?,?,?,?,?,?,?)}");
                proc.setInt(1, identificacion);
                proc.setString(2, Nombre);
                proc.setString(3, Apellido1);
                proc.setString(4, Apellido2);
                proc.setString(5, Direccion);
                proc.setInt(6, tipo);
                proc.setInt(7,idDistrito);
                proc.execute();
                System.out.println("Persona ingresada");
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RegistroPersonas.class.getName()).log(Level.SEVERE, null, ex);
            }
  
    }
    public final void IngresoPersona(){
            con= parquelibertad.dbConnection.conectDB();
            java.util.Date fecha=new java.util.Date();
            java.sql.Date fechaIngreso=new java.sql.Date(fecha.getTime());
            System.out.println(fechaIngreso);
            int identificacion=Integer.parseInt(TF_Identificacion.getText());
            CallableStatement proc;
            try {
                proc = con.prepareCall("{call insertIngresos(?,?,?)}");
                proc.setInt(1, identificacion);
                proc.setDate(2, fechaIngreso);
                proc.setInt(3,1);
                proc.execute();
                System.out.println("Registro visita Exitoso");
            } catch (SQLException ex) {
                Logger.getLogger(RegistroPersonas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    
    }
    public final void NacionalidadPersona(){
            try {
                CallableStatement cstmt;
                con= parquelibertad.dbConnection.conectDB();
                int identificacion=Integer.parseInt(TF_Identificacion.getText());
                String nacionalidad=CB_Nacionalidad.getSelectedItem().toString();
                cstmt = con.prepareCall("{?=call consulta_idNacionalidad (?)}");
                cstmt.setString(2,nacionalidad);
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);
                cstmt.execute();
                int idNacionalidad=cstmt.getInt(1);
                CallableStatement proc;
                proc = con.prepareCall("{call insertNacionalidad(?,?)}");
                proc.setInt(1, identificacion);
                proc.setInt(2, idNacionalidad);
                proc.execute();
                System.out.println("Registro Nacionalidad Exitoso");
                
            } catch (SQLException ex) {
                Logger.getLogger(RegistroPersonas.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuItem1 = new javax.swing.JMenuItem();
        TF_Nombre = new javax.swing.JTextField();
        TF_Apellido1 = new javax.swing.JTextField();
        TF_Apellido2 = new javax.swing.JTextField();
        TF_Identificacion = new javax.swing.JFormattedTextField();
        RB_Cedula = new javax.swing.JRadioButton();
        RB_Pasaporte = new javax.swing.JRadioButton();
        RB_TIM = new javax.swing.JRadioButton();
        CB_Pais = new javax.swing.JComboBox<>();
        CB_Provincia = new javax.swing.JComboBox<>();
        CB_Canton = new javax.swing.JComboBox<>();
        SP_Direccion = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        CB_Nacionalidad = new javax.swing.JComboBox<>();
        B_Registrar = new javax.swing.JButton();
        L_Nombre = new javax.swing.JLabel();
        L_Apellido1 = new javax.swing.JLabel();
        L_Apellido2 = new javax.swing.JLabel();
        L_Identificacion = new javax.swing.JLabel();
        L_Nacionalidad = new javax.swing.JLabel();
        L_Direccion = new javax.swing.JLabel();
        L_Pais = new javax.swing.JLabel();
        L_Provincia = new javax.swing.JLabel();
        L_Canton = new javax.swing.JLabel();
        Titulo_Registro_de_Persona = new javax.swing.JLabel();
        CB_Distrito = new javax.swing.JComboBox<>();
        L_Canton1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Re_Actividad = new javax.swing.JMenuItem();
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

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parque La Libertad");
        setLocation(new java.awt.Point(450, 125));
        setMinimumSize(new java.awt.Dimension(580, 480));
        setResizable(false);
        getContentPane().setLayout(null);

        TF_Nombre.setBackground(new java.awt.Color(217, 217, 253));
        TF_Nombre.setForeground(new java.awt.Color(204, 204, 255));
        getContentPane().add(TF_Nombre);
        TF_Nombre.setBounds(25, 81, 139, 20);

        TF_Apellido1.setBackground(new java.awt.Color(217, 217, 253));
        TF_Apellido1.setForeground(new java.awt.Color(204, 204, 255));
        getContentPane().add(TF_Apellido1);
        TF_Apellido1.setBounds(184, 81, 139, 20);

        TF_Apellido2.setBackground(new java.awt.Color(217, 217, 253));
        TF_Apellido2.setForeground(new java.awt.Color(204, 204, 255));
        getContentPane().add(TF_Apellido2);
        TF_Apellido2.setBounds(341, 81, 139, 20);

        TF_Identificacion.setBackground(new java.awt.Color(217, 217, 253));
        TF_Identificacion.setForeground(new java.awt.Color(204, 204, 255));
        try {
            TF_Identificacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(TF_Identificacion);
        TF_Identificacion.setBounds(25, 165, 131, 20);

        RB_Cedula.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(RB_Cedula);
        RB_Cedula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        RB_Cedula.setText("Cédula");
        RB_Cedula.setOpaque(false);
        RB_Cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_CedulaActionPerformed(evt);
            }
        });
        getContentPane().add(RB_Cedula);
        RB_Cedula.setBounds(25, 135, 75, 23);

        RB_Pasaporte.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(RB_Pasaporte);
        RB_Pasaporte.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        RB_Pasaporte.setText("Pasaporte");
        RB_Pasaporte.setOpaque(false);
        RB_Pasaporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_PasaporteActionPerformed(evt);
            }
        });
        getContentPane().add(RB_Pasaporte);
        RB_Pasaporte.setBounds(118, 135, 90, 23);

        RB_TIM.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(RB_TIM);
        RB_TIM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        RB_TIM.setText("TIM");
        RB_TIM.setOpaque(false);
        RB_TIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_TIMActionPerformed(evt);
            }
        });
        getContentPane().add(RB_TIM);
        RB_TIM.setBounds(211, 135, 70, 23);

        CB_Pais.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CB_Pais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Costa Rica" }));
        CB_Pais.setToolTipText("");
        CB_Pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_PaisActionPerformed(evt);
            }
        });
        getContentPane().add(CB_Pais);
        CB_Pais.setBounds(25, 221, 93, 21);

        CB_Provincia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CB_Provincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "San José" }));
        CB_Provincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_ProvinciaActionPerformed(evt);
            }
        });
        getContentPane().add(CB_Provincia);
        CB_Provincia.setBounds(136, 221, 103, 21);

        CB_Canton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CB_Canton.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Central" }));
        CB_Canton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_CantonActionPerformed(evt);
            }
        });
        getContentPane().add(CB_Canton);
        CB_Canton.setBounds(270, 220, 116, 21);

        jTextArea1.setBackground(new java.awt.Color(217, 217, 253));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        SP_Direccion.setViewportView(jTextArea1);

        getContentPane().add(SP_Direccion);
        SP_Direccion.setBounds(25, 276, 367, 70);

        CB_Nacionalidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CB_Nacionalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Costarricense" }));
        getContentPane().add(CB_Nacionalidad);
        CB_Nacionalidad.setBounds(341, 165, 106, 21);

        B_Registrar.setBackground(new java.awt.Color(255, 255, 255));
        B_Registrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        B_Registrar.setText("Registrar");
        B_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(B_Registrar);
        B_Registrar.setBounds(400, 350, 110, 40);

        L_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Nombre.setText("Nombre: ");
        getContentPane().add(L_Nombre);
        L_Nombre.setBounds(25, 62, 90, 15);

        L_Apellido1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Apellido1.setText("Apellido 1:");
        getContentPane().add(L_Apellido1);
        L_Apellido1.setBounds(184, 62, 80, 15);

        L_Apellido2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Apellido2.setText("Apellido 2: ");
        getContentPane().add(L_Apellido2);
        L_Apellido2.setBounds(341, 62, 90, 15);

        L_Identificacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Identificacion.setText("Identificación: ");
        getContentPane().add(L_Identificacion);
        L_Identificacion.setBounds(25, 119, 100, 15);

        L_Nacionalidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Nacionalidad.setText("Nacionalidad: ");
        getContentPane().add(L_Nacionalidad);
        L_Nacionalidad.setBounds(341, 139, 110, 15);

        L_Direccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Direccion.setText("Dirección: ");
        getContentPane().add(L_Direccion);
        L_Direccion.setBounds(25, 256, 110, 15);

        L_Pais.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Pais.setText("País: ");
        getContentPane().add(L_Pais);
        L_Pais.setBounds(30, 200, 38, 15);

        L_Provincia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Provincia.setText("Provincia: ");
        getContentPane().add(L_Provincia);
        L_Provincia.setBounds(140, 200, 61, 15);

        L_Canton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Canton.setText("Distrito:");
        getContentPane().add(L_Canton);
        L_Canton.setBounds(410, 200, 61, 15);

        Titulo_Registro_de_Persona.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Titulo_Registro_de_Persona.setText("Registro de Persona");
        getContentPane().add(Titulo_Registro_de_Persona);
        Titulo_Registro_de_Persona.setBounds(170, 10, 230, 30);

        CB_Distrito.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CB_Distrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Central" }));
        getContentPane().add(CB_Distrito);
        CB_Distrito.setBounds(410, 220, 116, 21);

        L_Canton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Canton1.setText("Cantón: ");
        getContentPane().add(L_Canton1);
        L_Canton1.setBounds(276, 201, 61, 15);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(106, 50));

        jMenu1.setBackground(new java.awt.Color(204, 255, 204));
        jMenu1.setText("   Registro");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu1.setFocusPainted(true);
        jMenu1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 13)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(180, 19));

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

        Re_Persona.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        Re_Persona.setText("Persona");
        Re_Persona.setPreferredSize(new java.awt.Dimension(137, 40));
        Re_Persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Re_PersonaActionPerformed(evt);
            }
        });
        jMenu1.add(Re_Persona);

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

        jMenu1.add(jMenu11);

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

        jMenu1.add(jMenu10);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("  Consulta");
        jMenu4.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 13)); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(180, 19));

        jMenu8.setText("Persona");
        jMenu8.setPreferredSize(new java.awt.Dimension(100, 35));

        Con_persona_ID.setText("Identificación");
        Con_persona_ID.setFocusCycleRoot(true);
        Con_persona_ID.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_persona_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_persona_IDActionPerformed(evt);
            }
        });
        jMenu8.add(Con_persona_ID);

        Con_Persona_Name.setText("Nombre");
        Con_Persona_Name.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_Persona_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_Persona_NameActionPerformed(evt);
            }
        });
        jMenu8.add(Con_Persona_Name);

        Con_persona_Lugar.setText("Lugar");
        Con_persona_Lugar.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_persona_Lugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_persona_LugarActionPerformed(evt);
            }
        });
        jMenu8.add(Con_persona_Lugar);

        con_persona_Fecha.setText("Fecha");
        con_persona_Fecha.setPreferredSize(new java.awt.Dimension(140, 30));
        con_persona_Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                con_persona_FechaActionPerformed(evt);
            }
        });
        jMenu8.add(con_persona_Fecha);

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

        Con_Empleado_ID.setText("Identificación");
        Con_Empleado_ID.setFocusCycleRoot(true);
        Con_Empleado_ID.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_Empleado_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_Empleado_IDActionPerformed(evt);
            }
        });
        jMenu9.add(Con_Empleado_ID);

        Con_Empleado_Name.setText("Nombre");
        Con_Empleado_Name.setPreferredSize(new java.awt.Dimension(140, 30));
        Con_Empleado_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_Empleado_NameActionPerformed(evt);
            }
        });
        jMenu9.add(Con_Empleado_Name);

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
        jMenu3.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 13)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(180, 19));

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

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RB_CedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_CedulaActionPerformed
        // TODO add your handling code here:
        tipo=1;
        
    }//GEN-LAST:event_RB_CedulaActionPerformed

    private void B_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RegistrarActionPerformed
        // TODO add your handling code here:
        if (TF_Nombre.getText().length()==0 || TF_Apellido1.getText().length()==0 || TF_Apellido2.getText().length()==0 ){
            JOptionPane.showMessageDialog(this, "Debe de llenar todos los campos obligatorios.",null,JOptionPane.ERROR_MESSAGE);
        }
        else{
            RegistrarPersona();
            IngresoPersona();
            NacionalidadPersona();
            
        }
    }//GEN-LAST:event_B_RegistrarActionPerformed

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
    
    private void CB_PaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_PaisActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==CB_Pais){
            if(CB_Pais.getSelectedItem()!=null){
            LlenarProvincia();
            }
        }
    }//GEN-LAST:event_CB_PaisActionPerformed

    private void CB_ProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_ProvinciaActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==CB_Provincia){
            if(CB_Provincia.getSelectedItem()!=null){
            LlenarCanton();
            }
        }
    }//GEN-LAST:event_CB_ProvinciaActionPerformed

    private void CB_CantonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_CantonActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==CB_Canton){
            if(CB_Canton.getSelectedItem()!=null){
            LlenarDistrito();
            }
        }
        
    }//GEN-LAST:event_CB_CantonActionPerformed

    private void RB_PasaporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_PasaporteActionPerformed
        // TODO add your handling code here:
        tipo=3;
    }//GEN-LAST:event_RB_PasaporteActionPerformed

    private void RB_TIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_TIMActionPerformed
        // TODO add your handling code here:
        tipo=2;
    }//GEN-LAST:event_RB_TIMActionPerformed
        
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
            java.util.logging.Logger.getLogger(RegistroPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroPersonas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Admi_Curso;
    private javax.swing.JMenuItem Admi_Puesto;
    private javax.swing.JMenuItem Admi_tipoEvento;
    private javax.swing.JButton B_Registrar;
    private javax.swing.JComboBox<String> CB_Canton;
    private javax.swing.JComboBox<String> CB_Distrito;
    private javax.swing.JComboBox<String> CB_Nacionalidad;
    private javax.swing.JComboBox<String> CB_Pais;
    private javax.swing.JComboBox<String> CB_Provincia;
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
    private javax.swing.JLabel L_Canton;
    private javax.swing.JLabel L_Canton1;
    private javax.swing.JLabel L_Direccion;
    private javax.swing.JLabel L_Identificacion;
    private javax.swing.JLabel L_Nacionalidad;
    private javax.swing.JLabel L_Nombre;
    private javax.swing.JLabel L_Pais;
    private javax.swing.JLabel L_Provincia;
    private javax.swing.JRadioButton RB_Cedula;
    private javax.swing.JRadioButton RB_Pasaporte;
    private javax.swing.JRadioButton RB_TIM;
    private javax.swing.JMenuItem Re_Actividad;
    private javax.swing.JMenuItem Re_Curso;
    private javax.swing.JMenuItem Re_Empleado;
    private javax.swing.JMenuItem Re_Evento;
    private javax.swing.JMenuItem Re_Persona;
    private javax.swing.JMenuItem Re_desercion;
    private javax.swing.JScrollPane SP_Direccion;
    private javax.swing.JTextField TF_Apellido1;
    private javax.swing.JTextField TF_Apellido2;
    private javax.swing.JFormattedTextField TF_Identificacion;
    private javax.swing.JTextField TF_Nombre;
    private javax.swing.JLabel Titulo_Registro_de_Persona;
    private javax.swing.JMenuItem TopActividades;
    private javax.swing.JMenuItem TopCurso;
    private javax.swing.JMenuItem TopDeserciones;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenuItem con_Empleado_Fecha;
    private javax.swing.JMenuItem con_persona_Fecha;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
