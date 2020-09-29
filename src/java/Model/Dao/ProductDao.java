
package Model.Dao;

import Model.Entity.ProductoEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ProductDao implements IProductDao {
    
    PreparedStatement parametro;
    ResultSet consulta;
    Conection con;

    @Override
    public int AddProduct(ProductoEntity producto) {
    
        int retorno = 0;

        try {
            
            con = new Conection();
            
            String query = "insert into productos(producto, idmarca, descripcion, precio_costo, precio_venta, existencia) values (?, ?, ?, ?, ?, ?);";
            
            con.OpenConnection();
            
            
            parametro = (PreparedStatement) con.conexionBD.prepareStatement(query);
            
            parametro.setString(1, producto.getNombreObjeto());
            parametro.setInt(2, producto.getId_marca());
            parametro.setString(3, producto.getDescripcion());
            parametro.setInt(4, producto.getPrecioCosto());
            parametro.setInt(5, producto.getPrecioVenta());
            parametro.setInt(6, producto.getExistencia());
            
            retorno = parametro.executeUpdate();
            
           //------------------------------------------------------------------
            //debugging
            System.out.println(producto.getNombreObjeto());
            System.out.println(producto.getId_marca());
            System.out.println(producto.getDescripcion());
            System.out.println(producto.getPrecioCosto());
            System.out.println(producto.getPrecioVenta());
            System.out.println(producto.getExistencia());
          

            System.out.println(retorno);

            System.out.println("---------------------------------");
            
            //end debugging
            //------------------------------------------------------------------
         
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
            
        }finally{
         
            con.Closeconnection();
        }
        
        
        return retorno;
    }
    
    
    
    

    @Override
    public DefaultTableModel Reed() {
        DefaultTableModel table = new DefaultTableModel();
        
        try {
            
            con = new Conection();
            
            con.OpenConnection();
            
            String query = "select p.idproducto as id, p.producto, p.descripcion, p.precio_costo, p.precio_venta, p.existencia, m.marca, m.idmarca from productos as p inner join marcas as m on p.idmarca = m.idmarca;";
            
            
            consulta = con.conexionBD.createStatement().executeQuery(query);
            
            String header [] = {"id", "producto", "descripcion", "precio_costo", "precio_venta", "existencia", "marca", "idmarca"};
            
            table.setColumnIdentifiers(header);
            
            String datos[] = new String[8];
            
            while (consulta.next()) {
                
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("producto");
                datos[2] = consulta.getString("descripcion");
                datos[3] = consulta.getString("precio_costo");
                datos[4] = consulta.getString("precio_venta");
                datos[5] = consulta.getString("existencia");
                datos[6] = consulta.getString("marca");
                datos[7] = consulta.getString("idmarca");
                
                table.addRow(datos);
                                               
            }

            
            
            
        } catch (SQLException ex) {
        
            System.out.println(ex.getMessage());
        
        }finally{
        
            con.Closeconnection();
        }
        
        
        return table;
    }

    
    
    
    
    @Override
    public int Update(ProductoEntity entity) {
        int retorno =0;
        try{
            PreparedStatement parametro;
            con = new Conection();
            String query = "update productos set producto= ?,idmarca= ?,descripcion= ?,precio_costo= ?,precio_venta= ?,existencia= ? where idproducto = ?;";
            con.OpenConnection();
            parametro = (PreparedStatement)con.conexionBD.prepareStatement(query);
            parametro.setString(1,entity.getNombreObjeto());
            parametro.setInt(2,entity.getId_marca());
            parametro.setString(3,entity.getDescripcion());
            parametro.setFloat(4,entity.getPrecioCosto());
            parametro.setFloat(5,entity.getPrecioVenta());
            parametro.setInt(6,entity.getExistencia());
            parametro.setInt(7, entity.getId());
            retorno = parametro.executeUpdate();
            con.Closeconnection();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;

    }

    
    
    @Override
    public int Delete(int idproducto) {
        
        int retorno = 0;

        try {
            con = new Conection();
            
            String query = "delete from productos where idproducto = ? ;";
            
            con.OpenConnection();
            
            parametro = (PreparedStatement)con.conexionBD.prepareStatement(query);
            
            parametro.setInt(1, idproducto);
            retorno = parametro.executeUpdate();

            System.out.println(retorno);

        } catch (SQLException e) {
        
            
        }
        
        return retorno;
    }
    
    
    
}
