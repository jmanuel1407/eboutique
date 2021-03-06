/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Rol;
import Modelo.RolDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Toni
 */
public class ControladorRol extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //Para controlar peticiones del tipo GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    //Para controlar peticiones del tipo POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    //Un metodo que recibe todas las peticiones a si sea GET y POST
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //La accion se va a guardar en un caja de texto oculto que nos dira que accion
        //debemos hacer
        String accion = request.getParameter("accion");
        if (accion.equals("RegistrarRol")) {
            this.registrarRol(request, response);
        } else if (accion.equals("ModificarRol")){
            this.actualizarRol(request, response);
        } else if (accion.equals("EliminarRol")){
            this.eliminarRol(request, response);
        }

    } 
    //Metodo que sirve para registrar un producto 
    private void registrarRol(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Rol rol = new Rol();
        //request.getParameter --> Sirve para obtener los valores de las cajas de texto
        rol.setNombre(request.getParameter("txtNombre").toUpperCase());
        boolean rpta = RolDB.insertarRol(rol);
        if (rpta) {
            //Si inserto lo redireccionamos a otra pagina que se llama "mensaje.jsp"
            response.sendRedirect("mensaje.jsp?men=Se registro del producto de manera correcta");
        } else {
            //Si no se inserto lo redireccionamos a otra pagina que se llama "mensaje.jsp"
            response.sendRedirect("mensaje.jsp?men=No se registro el producto");
        }
    }
    
    private void actualizarRol(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Rol rol = new Rol();
        rol.setId(Integer.parseInt(request.getParameter("txtCodigo")));
        rol.setNombre(request.getParameter("txtNombre").toUpperCase());
        boolean rpta = RolDB.actualizarRol(rol);
        if (rpta) {
            response.sendRedirect("mensaje.jsp?men=Se actualizo el producto de manera correcta");
        } else {
            response.sendRedirect("mensaje.jsp?men=No se actualizo el producto");
        }
    }
    
    private void eliminarRol (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Rol rol = new Rol();
        rol.setId(Integer.parseInt(request.getParameter("txtCodigo")));
        boolean rpta = RolDB.eliminarRol(rol.getId());
        if (rpta) {
            response.sendRedirect("mensaje.jsp?men=Se elimino la categoria de manera correcta");
        } else {
            response.sendRedirect("mensaje.jsp?men=No se elimino correctamente la categoria");
        }
    }

}
