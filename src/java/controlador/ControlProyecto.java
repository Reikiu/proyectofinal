/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
@WebServlet(name = "ControlProyecto", urlPatterns = {"/ControlProyecto"})
public class ControlProyecto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
      Proyectos p;
        int r=0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             RequestDispatcher res;
            DaoProyecto ob1=new DaoProyecto();      
            if(request.getParameter("mostrar")!=null){
                try {
                    request.setAttribute("proyecto", ob1.mostrar());
                } catch (Exception e) {
                    request.setAttribute("error", e.getMessage());
                }
            }            
            if(request.getParameter("insertar")!=null){
                try {
                    
                    p = new Proyectos(request.getParameter("direccion"),request.getParameter("latitud"),request.getParameter("longitud"),request.getParameter("foto"));
                  
                    r=ob1.insertar(p);   

                    if(r>0){
                        request.setAttribute("r", "Felicidades, Su registro finalizo exitosamente.!!");
                    }else{
                        request.setAttribute("r", "No pudo ser registrado:( ");
                    }                    
                    
                } catch (Exception e) {
                      request.setAttribute("error", e.getMessage());
                }
            
            }
           
            /* if(request.getParameter("eliminar")!=null){
                try {
                   // Proyecto p = new Proyecto(Integer.valueOf(request.getParameter("idProyecto")));
                     r=ob1.eliminar(p);  
                    request.setAttribute("proyecto", ob1.mostrar());
                                     
                    if(r>0)
                        request.setAttribute("r", "Su registro se ha eliminado exitosamente");
                    else
                        request.setAttribute("r", "Su registro NO se ha eliminado");
                    
                } catch (Exception e) {
                    request.setAttribute("error", e.getMessage());
                }
            }*/
            res = request.getRequestDispatcher("vistaProyecto.jsp");
            res.forward(request, response);
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
