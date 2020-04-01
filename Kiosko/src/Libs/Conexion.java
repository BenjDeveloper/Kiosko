/*
 * Conexion.java
 *
 * Created on 6 de agosto de 2007, 03:57 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Libs;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author BYOSCA
 */
public class Conexion {
    //Conexion de Datos para los procesos del TPV
    public static Connection con;
    //Conexion de Datos para los reportes
    public static Connection conReportes;
    
    public static final String DRIVER="com.mysql.jdbc.Driver";
    
    //Drivers.ini es el archivo de inicio para la configuracion de la conexion
    public static final String RUTA = Lib_Archivo.Leer_Ini("Drivers.ini","DatabaseConnect", "");
    
    //Usuario Y Passaswd de la base de dotos MySql
    //Este Proceso se Relisa con un sistema de encriptacion
    //Pero como es solo un ejemplo coloca simplemente el Usuario y el Password
    public static final String USER="root";
    public static final String PASSWORD="Devonico05$";
    //public static final String PASSWORD="Clave1987$";
    
    public ResultSet setDatos = null;
    public String SqlVentas;
    public String SqlEmpresa;
    public static boolean Estado;
    
    /** Creates a new instance of Connection */
    public Conexion() {
        //Creando La Conexion
        try{
            System.out.println("Ruta: " + RUTA);
            Class.forName(DRIVER);
            con = DriverManager.getConnection(RUTA,USER,PASSWORD);
            conReportes = DriverManager.getConnection(RUTA,USER,PASSWORD);
           
        }
        catch (Exception e){
           e.printStackTrace();
           Conexion.Estado=false;
           //Lib_Msj.JMsgbox(null,"Error 001: No Hay Coneccion Con El Servidor, Verifique, Si el Problema Persiste Llame al Supervisor del Sistema","Coneccion",Lib_Msj.MENSAJE_ERROR);
        }
        Conexion.Estado=true;
    }

    public static boolean getEstado(){
        return Estado;
    }
    
    //Funcion q ejecuta cualquie sql en la base de datos y retorna un ResulSet Con la infomacion 
    //encontrada
    public static ResultSet Ejecutar_Sql(String InSql){
        ResultSet setDatos = null;
        PreparedStatement Prepare = null;
        try{
           Prepare = conReportes.prepareStatement(InSql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
           setDatos = Prepare.executeQuery();
           
        }
        catch (SQLException e){
            e.printStackTrace();
           return null;
        }
        return setDatos;
       
    }

    //Funcion q ejecuta cualquie sql en la base de datos y retorna un ResulSet Con la infomacion 
    //encontrada    
    public static ResultSet Ejecutar_Sql(PreparedStatement Prepare){
        ResultSet setDatos = null;
        try{
           setDatos = Prepare.executeQuery();
        }
        catch (SQLException e){
           e.printStackTrace();
           return null;
        }
        return setDatos;
    }
    /*
    //Pantalla de espera de conexion
    static ByosEsperandoConexion Espera = new ByosEsperandoConexion();
    
    //Nueva Coneccion en la DB
    public static Connection getNuevaConexion() {
        Connection  conexion = null;
        while (true) {
            try {
                Class.forName(DRIVER);
                System.out.println(RUTA + " " + USER + " " + PASSWORD);
                conexion = DriverManager.getConnection(RUTA, USER, PASSWORD);
                if (Espera.isVisible()) {
                    Espera.setVisible(false);
                    System.out.println("Conectado...");
                }
                return conexion;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (!Espera.isVisible()) {
                Espera.setVisible(true);
                System.out.println("Desconectado...");
            }
            Espera.repaint();
            System.out.println("Desconectado...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    */
}
