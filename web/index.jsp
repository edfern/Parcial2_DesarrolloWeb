

<%@page import="Model.Dao.ProductDao"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="java.util.HashMap"%>
<%@page import="Model.Dao.BrandDao"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>Products</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/litera/bootstrap.min.css" integrity="sha384-enpDwFISL6M3ZGZ50Tjo8m65q06uLVnyvkFO3rsoW0UC15ATBFz3QEhr3hmxpYsn" crossorigin="anonymous">
<link href="index.css" type="text/css" rel="stylesheet">
</head>
    <body>
    <main class="container-xl" style="margin-top: 200px">
        <div class="table-responsive">
          <div class="table-wrapper">
            <div class="table-title" style="background: #d8d8d8; color: #727272;">
              <div class="row">
                <div class="col-sm-6">
                  <h2>Products table</h2>
                </div>
                <div class="col-sm-6">
                
                  <a href="#addModal" class="btn btn-outline-info" data-toggle="modal"><i
                      class="material-icons"><span>Add<br></span><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-cart-plus-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                      <path fill-rule="evenodd" d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM4 14a1 1 0 1 1 2 0 1 1 0 0 1-2 0zm7 0a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM9 5.5a.5.5 0 0 0-1 0V7H6.5a.5.5 0 0 0 0 1H8v1.5a.5.5 0 0 0 1 0V8h1.5a.5.5 0 0 0 0-1H9V5.5z"/>
                  </svg></i> </a>
                 
                     
                </div>
              </div>
            </div>
    
    
            <table class="table table-hover">
              <thead>
                <tr>
                  <th>Producto</th>
                  <th>Descripcion</th>
                  <th>Precio Costo</th>
                  <th>Precio Venta</th>
                  <th>Existencias</th>
                  <th>Marca</th>
                  
                </tr>
              </thead>
              <tbody id="tbl_productos">
                  
                  <%
                      ProductDao producto = new ProductDao();
                      DefaultTableModel tabla = new DefaultTableModel();
                      
                      tabla = producto.Reed();
                      
                      for (int t=0;t<tabla.getRowCount();t++){
                          
                          out.println("<tr data-id=" + tabla.getValueAt(t,0) + " data-idmarca=" + tabla.getValueAt(t,7) + ">");
                          out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
                          out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
                          out.println("<td>" + tabla.getValueAt(t,3) + "</td>");
                          out.println("<td>" + tabla.getValueAt(t,4) + "</td>");
                          out.println("<td>" + tabla.getValueAt(t,5) + "</td>");
                          out.println("<td>" + tabla.getValueAt(t,6) + "</td>");
                          out.println("</tr>");
        
        }
                  
                  %>

              </tbody>
            </table>
          </div>
        </div>
      </main>
      <div id="addModal" class="modal fade">
        <div class="modal-dialog">
          <div class="modal-content">
    
            <form action="add" method="post" class="form-group">
              <div class="modal-header">
                <h4 class="modal-title">Add product</h4>
               
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="limpiar()">&times;</button>
              </div>
    
              <div class="modal-body">
    
                    <label for="lbl_id" ><b>ID</b></label>
                    <input type="text" name="txt_id" id="txt_id" class="form-control" value="0"  readonly> 
    
                    <label for="lbl_producto" ><b>Producto</b></label>
                    <input type="text" name="txt_producto" id="txt_producto" class="form-control"  required>
                    
                    <label for="lbl_descripcion" ><b>Descripcion</b></label>
                    <input type="text" name="txt_descripcion" id="txt_descripcion" class="form-control" required>
                   
                    <label for="lbl_costo" ><b>Precio Costo</b></label>
                    <input type="number" name="txt_costo" id="txt_costo" class="form-control" required>
                   
                    <label for="lbl_venta" ><b>Precio Venta</b></label>
                    <input type="number"  name="txt_venta" id="txt_venta" class="form-control" required>
                                  
                    <label for="lbl_marca" ><b>Marca</b></label>
                    <select name="drop_marca" id="drop_marca" class="form-control">
                        
                        <%
                            
                            BrandDao marca = new BrandDao();
                            
                            HashMap<String,String> drop = marca.DropMarca();
                            
                            for (String i:drop.keySet()){
                             out.println("<option value='" + i + "'>" + drop.get(i) + "</option>");
                         }
                        %>
                    </select>
                    <label for="lbl_existencias" ><b>Existencias</b></label>
                    <input type="number"  name="txt_existencias" id="txt_existencias" class="form-control" required>
              </div>
              <div class="modal-footer">
                <button name="btn_agregar" id="btn_agregar"  value="agregar" class="btn btn-outline-success">Agregar</button>
                <button name="btn_modificar" id="btn_modificar"  value="modificar" class="btn btn-outline-warning">Modificar</button>
                <button name="btn_eliminar" id="btn_eliminar"  value="eliminar" class="btn btn-outline-danger" onclick="javascript:if(!confirm('¿Desea Eliminar?'))return false" >Eliminar</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="index.js" type="text/javascript"></script>
    </body>
</html>
