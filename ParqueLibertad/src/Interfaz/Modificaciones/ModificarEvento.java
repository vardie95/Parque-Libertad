/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Modificaciones;

import Interfaz.Registro.*;
import Interfaz.Registro.RegistroTipoEvento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static org.eclipse.persistence.expressions.ExpressionOperator.currentDate;
import parquelibertad.dbConnection;

/**
 *
 * @author Luis Diego
 */
public class ModificarEvento extends javax.swing.JFrame {
            Connection con= null;
            ArrayList llaves=new ArrayList();
            
    /**
     * Creates new form RegistroCurso
     */
    public ModificarEvento() {
        initComponents();
        con= parquelibertad.dbConnection.conectDB();
        llenarTipo_evento();
        llenarTipo_evento2();
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ModificarEvento.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }
    
    public final  void llenarTipo_evento() {
        CB_Tipo.removeAllItems();
            try {
               CallableStatement cstmt =con.prepareCall("{call get_Eventos(?)}");
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                cstmt.execute();
                ResultSet rs = (ResultSet)cstmt.getObject(1);
                while(rs.next()){
                   CB_Tipo.addItem(rs.getString(2)+"   Fecha:    "+rs.getDate(3));
                   llaves.add(rs.getInt(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public final  void llenarTipo_evento2() {
        CB_Tipo1.removeAllItems();
            try {
               CallableStatement cstmt =con.prepareCall("{call get_TipoEvento(?)}");
                cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                cstmt.execute();
                ResultSet rs = (ResultSet)cstmt.getObject(1);
                while(rs.next()){
                   CB_Tipo1.addItem(rs.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public  String fecha(){
        String fecha=null;
        String dia=CB_Dia.getSelectedItem().toString();
        String mes=CB_Mes.getSelectedItem().toString();
        String año=CB_Año.getSelectedItem().toString();        
        fecha=dia+mes+año;   
        return fecha;
    }
    public final void registrarEvento(){
        CallableStatement cstmt;
                try {
                    con= parquelibertad.dbConnection.conectDB();
                    cstmt = con.prepareCall("{?=call consulta_idTipoEvento (?)}");
                    String descripcion = CB_Tipo1.getSelectedItem().toString();
                    cstmt.setString(2,descripcion);
                    cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);
                    cstmt.execute();
                    int indice = CB_Tipo.getSelectedIndex();
                    int Identificacion=(int)llaves.get(indice);
                    int idTipo = cstmt.getInt(1);
                    String fecha=fecha();
                    SimpleDateFormat formato=new SimpleDateFormat("ddMMyy"); 
                    try {
                        con= parquelibertad.dbConnection.conectDB();
                        java.util.Date parsed = formato.parse(fecha);
                        java.sql.Date sql= new java.sql.Date(parsed.getTime());
                        CallableStatement proc= con.prepareCall("{call modificarEvento(?,?,?)}");
                    proc.setInt(1, Identificacion);
                    proc.setInt(2, idTipo);
                    proc.setDate(3, sql);
                    proc.execute();
                    JOptionPane.showMessageDialog(this, "Evento Agregado Exitosamente",null,JOptionPane.INFORMATION_MESSAGE);
                    con.close();
                } catch (ParseException ex) {     
                Logger.getLogger(ModificarEvento.class.getName()).log(Level.SEVERE, null, ex);
            }     
                } catch (SQLException ex) {
                    Logger.getLogger(ModificarEvento.class.getName()).log(Level.SEVERE, null, ex);
                }
         
    
    }
    
    
    public void llenarCampos(){
        try {
            con=dbConnection.conectDB();
            CallableStatement cstmt4 = con.prepareCall("{call get_DatoEvento(?,?)}");
            int indice=CB_Tipo.getSelectedIndex();
            Date fecha;
            String Fecha;
            cstmt4.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            cstmt4.setInt(2, (int)llaves.get(indice));
            cstmt4.execute();
            ResultSet rs = (ResultSet)cstmt4.getObject(1);
            while(rs.next()){
                fecha=rs.getDate(2);
                Fecha=Convertirfecha(fecha);
                CB_Tipo1.setSelectedItem(rs.getString(1));
                CB_Dia.setSelectedItem(Fecha.substring(0,2));
                CB_Mes.setSelectedItem(Fecha.substring(2,4));
                CB_Año.setSelectedItem(Fecha.substring(4,6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModificarActividad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String Convertirfecha(Date pfecha){
        String Fecha;
        DateFormat df = new SimpleDateFormat("ddMMyy");
        Fecha= df.format(pfecha);
        return Fecha;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        L_Tipo = new javax.swing.JLabel();
        L_Fecha = new javax.swing.JLabel();
        B_Registrar = new javax.swing.JButton();
        Titulo_Registro_de_Evento = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CB_Dia = new javax.swing.JComboBox<>();
        CB_Mes = new javax.swing.JComboBox<>();
        CB_Año = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        CB_Tipo = new javax.swing.JComboBox<>();
        CB_Tipo1 = new javax.swing.JComboBox<>();
        L_Tipo1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parque la Libertad");
        setLocation(new java.awt.Point(500, 125));
        setMinimumSize(new java.awt.Dimension(550, 423));
        setResizable(false);
        getContentPane().setLayout(null);

        L_Tipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        L_Tipo.setText("Evento:");
        getContentPane().add(L_Tipo);
        L_Tipo.setBounds(27, 60, 60, 30);

        L_Fecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        L_Fecha.setText("Fecha:");
        getContentPane().add(L_Fecha);
        L_Fecha.setBounds(40, 190, 58, 30);

        B_Registrar.setText("Modificar");
        B_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(B_Registrar);
        B_Registrar.setBounds(90, 290, 110, 50);

        Titulo_Registro_de_Evento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Titulo_Registro_de_Evento.setText("Modificar Evento");
        getContentPane().add(Titulo_Registro_de_Evento);
        Titulo_Registro_de_Evento.setBounds(180, 20, 160, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("dd     /   mm       /  aa");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(120, 200, 130, 20);

        CB_Dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(CB_Dia);
        CB_Dia.setBounds(90, 230, 70, 20);

        CB_Mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", " " }));
        getContentPane().add(CB_Mes);
        CB_Mes.setBounds(170, 230, 60, 20);

        CB_Año.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", " ", " " }));
        getContentPane().add(CB_Año);
        CB_Año.setBounds(230, 230, 70, 20);

        jButton6.setText("Volver");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(270, 290, 110, 50);

        CB_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre" }));
        CB_Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_TipoActionPerformed(evt);
            }
        });
        getContentPane().add(CB_Tipo);
        CB_Tipo.setBounds(90, 60, 310, 30);

        CB_Tipo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre" }));
        CB_Tipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Tipo1ActionPerformed(evt);
            }
        });
        getContentPane().add(CB_Tipo1);
        CB_Tipo1.setBounds(100, 120, 220, 30);

        L_Tipo1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        L_Tipo1.setText("Tipo:");
        getContentPane().add(L_Tipo1);
        L_Tipo1.setBounds(40, 120, 47, 30);

        jButton2.setText("Ok");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(410, 70, 60, 23);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RegistrarActionPerformed
        // TODO add your handling code here:
        registrarEvento();
        
    }//GEN-LAST:event_B_RegistrarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
            int response = JOptionPane.showConfirmDialog(null, "Se perderán todo los datos desea continuar?", "Confirmación",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            switch (response) {
                case JOptionPane.NO_OPTION:
                break;
                case JOptionPane.YES_OPTION:
                new Interfaz.Registro.RegistroEvento().setVisible(true);
                dispose();
                break;
                case JOptionPane.CLOSED_OPTION:
                break;
                default:
                break;
            }

        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void CB_TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_TipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_TipoActionPerformed

    private void CB_Tipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Tipo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_Tipo1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        con=dbConnection.conectDB();
        if ((String)CB_Tipo.getSelectedItem()!="Seleccione una Actividad")
        {
            llenarCampos();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Registrar;
    private javax.swing.JComboBox<String> CB_Año;
    private javax.swing.JComboBox<String> CB_Dia;
    private javax.swing.JComboBox<String> CB_Mes;
    private javax.swing.JComboBox<String> CB_Tipo;
    private javax.swing.JComboBox<String> CB_Tipo1;
    private javax.swing.JLabel L_Fecha;
    private javax.swing.JLabel L_Tipo;
    private javax.swing.JLabel L_Tipo1;
    private javax.swing.JLabel Titulo_Registro_de_Evento;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
