
package Model.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


public class BrandDao {
    
    Conection con;
    
    
    
    public HashMap DropMarca(){
        
        HashMap<String,String> drop = new HashMap();
        
        try {
            
            String query = "select idmarca as id, marca from marcas;";
            
            con = new Conection();
            
            con.OpenConnection();
            
            ResultSet consulta = con.conexionBD.createStatement().executeQuery(query);
            
            while (consulta.next()) {
                
                drop.put(consulta.getString("id"),consulta.getString("marca"));
                
            }
            
            //Debugging
            
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());       
        }finally{
            
            con.Closeconnection();
        }
        
     
        
        return drop;
    }
    
    

    
}
