
package Controller;

import Model.Dao.IProductDao;
import Model.Dao.ProductDao;
import Model.Entity.ProductoEntity;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "add", urlPatterns = "/add")
public class ProductController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet product</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet product at " + request.getContextPath() + "</h1>");
            
            IProductDao dao = new ProductDao();
            IProductDao dao1 = new ProductDao();
            
            ProductoEntity producto = new ProductoEntity();
            
            
            producto.setId(Integer.parseInt(request.getParameter("txt_id")));
            producto.setNombreObjeto(request.getParameter("txt_producto"));
            producto.setDescripcion(request.getParameter("txt_descripcion"));
            producto.setPrecioCosto(Integer.parseInt((request.getParameter("txt_costo"))));
            producto.setPrecioVenta(Integer.parseInt((request.getParameter("txt_venta"))));
            producto.setExistencia(Integer.parseInt((request.getParameter("txt_existencias"))));
            producto.setId_marca(Integer.parseInt(request.getParameter("drop_marca")));
            
            //agregar
            if ("agregar".equals(request.getParameter("btn_agregar"))) {
                
                int contador = dao.AddProduct(producto);
                
                if (contador > 0) {
                    response.sendRedirect("index.jsp");

                } else {
                    out.println("<h1>No insert </h1>");
                    out.println("<a href='index.jsp'>back...</a>");
                }
            }
            // Boton modificar
            if ("modificar".equals(request.getParameter("btn_modificar"))){
                int co = dao.Update(producto);
                if (co>0){
                    response.sendRedirect("index.jsp");

                }else{
                    out.println("<h1>No update</h1>");
                    out.println("<a href='index.jsp'>Back...</a>");
                }
            }


            // Boton eliminar 
            if ("eliminar".equals(request.getParameter("btn_eliminar"))){
                 int contadorE = dao1.Delete(Integer.parseInt(request.getParameter("txt_id")));
             if (contadorE>0){
             response.sendRedirect("index.jsp");
             
             }else{
             out.println("<h1>No delete </h1>");
             out.println("<a href='index.jsp'>Back..</a>");
             }
             }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
