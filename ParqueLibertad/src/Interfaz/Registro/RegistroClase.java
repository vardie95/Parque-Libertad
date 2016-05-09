/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Registro;


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
                RegistrarHorario(idMercado, idCurso, Integer.parseInt(costo));
                JOptionPane.showMessageDialog(this, "Registro de Clase exitoso",null,JOptionPane.INFORMATION_MESSAGE);
                TF_Costo.setText("");
                
            } catch (ParseException ex) {
                Logger.getLogger(RegistroClase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error:"+ex,null,JOptionPane.ERROR_MESSAGE);
            }
            
    
    
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void RegistrarHorario(int pidMercado, int pidCurso, int pCosto){
            try {
                CallableStatement cstmt;
                con= parquelibertad.dbConnection.conectDB();
                cstmt = con.prepareCall("{?=call consulta_idClase (?,?,?)}");
                cstmt.setInt(2,pidMercado);
                cstmt.setInt(3,pidCurso);
                cstmt.setInt(4,pCosto);
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);
                cstmt.execute();
                int idCurso=cstmt.getInt(1);
                int idHorario=getidHorario();
                con= parquelibertad.dbConnection.conectDB();
                cstmt = con.prepareCall("{call insertClasexHorario (?,?)}");
                cstmt.setInt(2,idCurso);
                cstmt.setInt(1,idHorario);
                cstmt.execute();
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(RegistroClase.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    
   
    }
    
    
    
    private int getIdHorario(){
            int idHora = 0;
            try {
                CallableStatement cstmt;
                con= parquelibertad.dbConnection.conectDB();
                String dia= CB_Curso2.getSelectedItem().toString();
                String hora=CB_Curso1.getSelectedItem().toString();
                cstmt = con.prepareCall("{?=call consulta_idHorario (?,?)}");
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);
                cstmt.setString(2,dia);
                cstmt.setString(3,hora);
                cstmt.execute();
                idHora=cstmt.getInt(1);
                System.out.println(idHora);
            } catch (SQLException ex) {
                Logger.getLogger(RegistroClase.class.getName()).log(Level.SEVERE, null, ex);
            }
        return idHora;    
    
    
    }
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
        jLabel2 = new javax.swing.JLabel();
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

        CB_Curso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre" }));
        getContentPane().add(CB_Curso);
        CB_Curso.setBounds(130, 60, 150, 28);

        L_Curso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Curso.setText("Curso: ");
        getContentPane().add(L_Curso);
        L_Curso.setBounds(40, 60, 60, 28);

        CB_Mercado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adultos" }));
        getContentPane().add(CB_Mercado);
        CB_Mercado.setBounds(130, 110, 146, 31);

        TF_Costo.setBackground(new java.awt.Color(153, 255, 153));
        getContentPane().add(TF_Costo);
        TF_Costo.setBounds(110, 290, 135, 30);

        L_Costo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Costo.setText("Costo: ");
        getContentPane().add(L_Costo);
        L_Costo.setBounds(30, 290, 70, 28);

        L_Mercado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Mercado.setText("Mercado: ");
        getContentPane().add(L_Mercado);
        L_Mercado.setBounds(40, 110, 70, 28);

        L_Horario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Horario.setText("Hora:");
        getContentPane().add(L_Horario);
        L_Horario.setBounds(220, 180, 70, 28);

        B_Registrar.setBackground(new java.awt.Color(255, 255, 255));
        B_Registrar.setText("Registrar");
        B_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(B_Registrar);
        B_Registrar.setBounds(320, 280, 100, 40);

        Titulo_Registro_de_Curso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Titulo_Registro_de_Curso.setText("Registro de Clase");
        getContentPane().add(Titulo_Registro_de_Curso);
        Titulo_Registro_de_Curso.setBounds(190, 10, 136, 22);

        CB_Curso1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horario" }));
        getContentPane().add(CB_Curso1);
        CB_Curso1.setBounds(270, 180, 120, 28);

        L_Horario1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Horario1.setText("Horario: ");
        getContentPane().add(L_Horario1);
        L_Horario1.setBounds(40, 150, 70, 28);

        CB_Curso2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado", "Domingo" }));
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

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 510, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Registro/Fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 40, 510, 350);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(106, 55));

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

    private void B_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RegistrarActionPerformed
        // TODO add your handling code here:
        if(TF_Costo.equals("")){
               System.out.println("error");
        
        }else{
            RegistrarClase();
            
            
        }
    }//GEN-LAST:event_B_RegistrarActionPerformed

    private void CB_Curso2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Curso2ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==CB_Curso2){
            if(CB_Curso2.getSelectedItem()!=null){
            llenarHorario();
            }
        }
        
     
    }//GEN-LAST:event_CB_Curso2ActionPerformed

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
    private javax.swing.JMenuItem Admi_Curso1;
    private javax.swing.JMenuItem Admi_Puesto;
    private javax.swing.JMenuItem Admi_Puesto1;
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
    private javax.swing.JLabel L_Costo;
    private javax.swing.JLabel L_Curso;
    private javax.swing.JLabel L_Horario;
    private javax.swing.JLabel L_Horario1;
    private javax.swing.JLabel L_Horario3;
    private javax.swing.JLabel L_Horario4;
    private javax.swing.JLabel L_Horario5;
    private javax.swing.JLabel L_Mercado;
    private javax.swing.JMenuItem Re_Actividad;
    private javax.swing.JMenuItem Re_Curso;
    private javax.swing.JMenuItem Re_Empleado;
    private javax.swing.JMenuItem Re_Evento;
    private javax.swing.JMenuItem Re_Persona;
    private javax.swing.JMenuItem Re_Persona1;
    private javax.swing.JMenuItem Re_Persona2;
    private javax.swing.JMenuItem Re_Persona3;
    private javax.swing.JMenuItem Re_desercion;
    private javax.swing.JFormattedTextField TF_Costo;
    private javax.swing.JLabel Titulo_Registro_de_Curso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
