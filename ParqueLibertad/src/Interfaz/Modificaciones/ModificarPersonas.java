/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Modificaciones;

import Interfaz.Registro.*;
import Interfaz.Inicio;
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
import parquelibertad.dbConnection;
/**
 *
 * @author Luis Diego
 */
public class ModificarPersonas extends javax.swing.JFrame {
        Connection con= null;
        int tipo=1;
    /**
     * Creates new form RegistroPersonas
     */
        
    public final  void llenaridentificacion() 
    
    {
        CB_Identificacion.removeAllItems();
        CB_Identificacion.addItem("Seleccione Identificacion");
            try {
                 
                CallableStatement cstmt = con.prepareCall("{call get_idPersona(?)}");
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
    public ModificarPersonas() {
        initComponents();
        con= parquelibertad.dbConnection.conectDB();
        llenarpais();
        llenarNacionalidad();
        llenaridentificacion();
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModificarPersonas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ModificarPersonas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ModificarPersonas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ModificarPersonas.class.getName()).log(Level.SEVERE, null, ex);
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
    public final void ActualizarPersona(){
        CallableStatement cstmt;
        int ID_Nacionalidad;
        int ID_Distrito;
        int identificacion=Integer.parseInt(CB_Identificacion.getSelectedItem().toString());
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
                CallableStatement proc= con.prepareCall("{call modificarPersona(?,?,?,?,?,?,?)}");
                proc.setInt(1, identificacion);
                proc.setString(2, Nombre);
                proc.setString(3, Apellido1);
                proc.setString(4, Apellido2);
                proc.setString(5, Direccion);
                proc.setInt(6, tipo);
                proc.setInt(7,idDistrito);
                proc.execute();
                JOptionPane.showMessageDialog(this, "Persona Modificada Exitosamente",null,JOptionPane.INFORMATION_MESSAGE);
                TF_Nombre.setText("");
                TF_Apellido1.setText("");
                TF_Apellido2.setText("");
                jTextArea1.setText("");
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModificarPersonas.class.getName()).log(Level.SEVERE, null, ex);
            }
  
    }
    public final void NacionalidadPersona(){
            try {
                CallableStatement cstmt;
                con= parquelibertad.dbConnection.conectDB();
                int identificacion=Integer.parseInt(CB_Identificacion.getSelectedItem().toString());
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
        jButton1 = new javax.swing.JButton();
        TF_Nombre = new javax.swing.JTextField();
        TF_Apellido1 = new javax.swing.JTextField();
        TF_Apellido2 = new javax.swing.JTextField();
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
        L_Nacionalidad = new javax.swing.JLabel();
        L_Direccion = new javax.swing.JLabel();
        L_Pais = new javax.swing.JLabel();
        L_Provincia = new javax.swing.JLabel();
        L_Canton = new javax.swing.JLabel();
        Titulo_Registro_de_Persona = new javax.swing.JLabel();
        CB_Distrito = new javax.swing.JComboBox<>();
        L_Canton1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CB_Identificacion = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        L_Identificacion = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parque La Libertad");
        setLocation(new java.awt.Point(450, 125));
        setMinimumSize(new java.awt.Dimension(600, 511));
        setResizable(false);
        getContentPane().setLayout(null);

        TF_Nombre.setBackground(new java.awt.Color(153, 255, 153));
        getContentPane().add(TF_Nombre);
        TF_Nombre.setBounds(20, 140, 139, 20);

        TF_Apellido1.setBackground(new java.awt.Color(153, 255, 153));
        getContentPane().add(TF_Apellido1);
        TF_Apellido1.setBounds(170, 140, 139, 20);

        TF_Apellido2.setBackground(new java.awt.Color(153, 255, 153));
        getContentPane().add(TF_Apellido2);
        TF_Apellido2.setBounds(340, 140, 139, 20);

        CB_Pais.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CB_Pais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Costa Rica" }));
        CB_Pais.setToolTipText("");
        CB_Pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_PaisActionPerformed(evt);
            }
        });
        getContentPane().add(CB_Pais);
        CB_Pais.setBounds(30, 260, 93, 21);

        CB_Provincia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CB_Provincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "San José" }));
        CB_Provincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_ProvinciaActionPerformed(evt);
            }
        });
        getContentPane().add(CB_Provincia);
        CB_Provincia.setBounds(140, 260, 103, 21);

        CB_Canton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CB_Canton.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Central" }));
        CB_Canton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_CantonActionPerformed(evt);
            }
        });
        getContentPane().add(CB_Canton);
        CB_Canton.setBounds(280, 260, 116, 21);

        jTextArea1.setBackground(new java.awt.Color(153, 255, 153));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        SP_Direccion.setViewportView(jTextArea1);

        getContentPane().add(SP_Direccion);
        SP_Direccion.setBounds(30, 310, 380, 96);

        CB_Nacionalidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CB_Nacionalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Costarricense" }));
        getContentPane().add(CB_Nacionalidad);
        CB_Nacionalidad.setBounds(390, 200, 150, 21);

        B_Registrar.setBackground(new java.awt.Color(255, 255, 255));
        B_Registrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        B_Registrar.setText("Modificar");
        B_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(B_Registrar);
        B_Registrar.setBounds(450, 340, 110, 40);

        L_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Nombre.setText("Nombre: ");
        getContentPane().add(L_Nombre);
        L_Nombre.setBounds(20, 120, 90, 15);

        L_Apellido1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Apellido1.setText("Apellido 1:");
        getContentPane().add(L_Apellido1);
        L_Apellido1.setBounds(170, 120, 80, 15);

        L_Apellido2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Apellido2.setText("Apellido 2: ");
        getContentPane().add(L_Apellido2);
        L_Apellido2.setBounds(340, 120, 90, 15);

        L_Nacionalidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Nacionalidad.setText("Nacionalidad: ");
        getContentPane().add(L_Nacionalidad);
        L_Nacionalidad.setBounds(390, 180, 110, 15);

        L_Direccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Direccion.setText("Dirección: ");
        getContentPane().add(L_Direccion);
        L_Direccion.setBounds(30, 290, 110, 15);

        L_Pais.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Pais.setText("País: ");
        getContentPane().add(L_Pais);
        L_Pais.setBounds(40, 230, 38, 15);

        L_Provincia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Provincia.setText("Provincia: ");
        getContentPane().add(L_Provincia);
        L_Provincia.setBounds(150, 240, 90, 15);

        L_Canton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Canton.setText("Distrito:");
        getContentPane().add(L_Canton);
        L_Canton.setBounds(420, 240, 61, 15);

        Titulo_Registro_de_Persona.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Titulo_Registro_de_Persona.setText("Modificar Persona");
        getContentPane().add(Titulo_Registro_de_Persona);
        Titulo_Registro_de_Persona.setBounds(190, 10, 230, 30);

        CB_Distrito.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CB_Distrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Central" }));
        getContentPane().add(CB_Distrito);
        CB_Distrito.setBounds(420, 260, 116, 21);

        L_Canton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        L_Canton1.setText("Cantón: ");
        getContentPane().add(L_Canton1);
        L_Canton1.setBounds(280, 240, 61, 15);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 390, 0, 0);

        CB_Identificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "123456789" }));
        getContentPane().add(CB_Identificacion);
        CB_Identificacion.setBounds(160, 60, 180, 28);

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(360, 60, 80, 23);

        L_Identificacion.setText("Identificación:");
        getContentPane().add(L_Identificacion);
        L_Identificacion.setBounds(60, 60, 80, 28);

        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(450, 390, 110, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Registro/Fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 90, 590, 390);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 590, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RegistrarActionPerformed
        // TODO add your handling code here:
        if (TF_Nombre.getText().length()==0 || TF_Apellido1.getText().length()==0 || TF_Apellido2.getText().length()==0 ){
            JOptionPane.showMessageDialog(this, "Debe de llenar todos los campos obligatorios.",null,JOptionPane.ERROR_MESSAGE);
        }
        else{
            ActualizarPersona();
            
            
        }
    }//GEN-LAST:event_B_RegistrarActionPerformed
    
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
                con=dbConnection.conectDB();
                CallableStatement cstmt4 = con.prepareCall("{call get_DatosUbicacionPersona(?,?)}");
                int identificacion=Integer.parseInt(CB_Identificacion.getSelectedItem().toString());
                cstmt4.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                cstmt4.setInt(2, identificacion);
                cstmt4.execute();
                ResultSet rs = (ResultSet)cstmt4.getObject(1);
                while(rs.next()){
                    CB_Pais.setSelectedItem(rs.getString(1));
                    CB_Provincia.setSelectedItem(rs.getString(2));
                    CB_Canton.setSelectedItem(rs.getString(3));
                    CB_Distrito.setSelectedItem(rs.getString(4));
                }
                con=dbConnection.conectDB();
                CallableStatement cstmt5 = con.prepareCall("{call get_DatosPersona(?,?)}");
                cstmt5.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                cstmt5.setInt(2, identificacion);
                cstmt5.execute();
                rs = (ResultSet)cstmt5.getObject(1);
                while(rs.next()){
                    jTextArea1.setText(rs.getString(1));
                    tipo=rs.getInt(2);
                    CB_Nacionalidad.setSelectedItem(rs.getString(3));
                }
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (TF_Nombre.getText().length()>0 || TF_Apellido1.getText().length()>0 || TF_Apellido2.getText().length()>0 ){
            int response = JOptionPane.showConfirmDialog(null, "Se perderán todo los datos desea continuar?", "Confirmación",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            switch (response) {
                case JOptionPane.NO_OPTION:
                break;
                case JOptionPane.YES_OPTION:
                new Interfaz.Modificaciones.ModificarPersonas().setVisible(true);
                dispose();
                break;
                case JOptionPane.CLOSED_OPTION:
                break;
                default:
                break;
            }

        }else{
            new Interfaz.Modificaciones.ModificarPersonas().setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (TF_Nombre.getText().length()>0 || TF_Apellido1.getText().length()>0 || TF_Apellido2.getText().length()>0 ){
            int response = JOptionPane.showConfirmDialog(null, "Se perderán todo los datos desea continuar?", "Confirmación",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            switch (response) {
                case JOptionPane.NO_OPTION:
                break;
                case JOptionPane.YES_OPTION:
                new Interfaz.Registro.RegistroPersonas().setVisible(true);
                dispose();
                break;
                case JOptionPane.CLOSED_OPTION:
                break;
                default:
                break;
            }

        }else{
            new Interfaz.Registro.RegistroPersonas().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed
        
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
            java.util.logging.Logger.getLogger(ModificarPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarPersonas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Registrar;
    private javax.swing.JComboBox<String> CB_Canton;
    private javax.swing.JComboBox<String> CB_Distrito;
    private javax.swing.JComboBox<String> CB_Identificacion;
    private javax.swing.JComboBox<String> CB_Nacionalidad;
    private javax.swing.JComboBox<String> CB_Pais;
    private javax.swing.JComboBox<String> CB_Provincia;
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
    private javax.swing.JScrollPane SP_Direccion;
    private javax.swing.JTextField TF_Apellido1;
    private javax.swing.JTextField TF_Apellido2;
    private javax.swing.JTextField TF_Nombre;
    private javax.swing.JLabel Titulo_Registro_de_Persona;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
