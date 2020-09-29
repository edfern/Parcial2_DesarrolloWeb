
package Model.Dao;

import Model.Entity.ProductoEntity;

import javax.swing.table.DefaultTableModel;


public interface IProductDao {
    
    public int AddProduct(ProductoEntity producto);

    public DefaultTableModel Reed();
    
    public int Update(ProductoEntity entity);
    
    public int Delete(int idproducto);

    
}
