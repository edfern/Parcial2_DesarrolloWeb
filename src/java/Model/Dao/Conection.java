package Model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Conection {
    
    public Connection conexionBD;
    private final String puerto= "3306";
    private final String bd= "parcial2Desarrollo";
    private final String urlConexion = String.format("jdbc:mysql://localhost:%s/%s?serverTimezone=UTC&autoReconnect=true&useSSL=false",puerto, bd);
    private final String usuario = "user_desarrollo";
    private final String contra = "fernando";
    private final String jdbc ="com.mysql.cj.jdbc.Driver";
    
    
    
    public void OpenConnection(){
        
        try{
                Class.forName(jdbc);
                conexionBD = DriverManager.getConnection(urlConexion,usuario,contra);               
               System.out.println("Conexion Exitosa");
            }catch(ClassNotFoundException | SQLException ex){
                    System.out.println("Error: " + ex.getMessage());
            }   
    }
    
    
    public void Closeconnection(){
        
        try{
            conexionBD.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }      
    
    }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
