/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import ModeloDAO.ClienteDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arpena
 */
public class Controlador extends HttpServlet {

    Cliente objCliente = new Cliente();
    ClienteDAO objClienteDAO = new ClienteDAO();
    int nIdCliente;
    String stTipo;
    String stIdentificacion;
    String stNombre;
    String stApellidos;
    int nEdad;
    String stEdad;
    String stTelefono;
    String stDireccion;
    boolean bReturn = false;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Accion = request.getParameter("accion");
        switch (Accion){
            case "Listar":
                List arrClientes = objClienteDAO.consultar();
                request.setAttribute("arrClientes", arrClientes);
                request.getRequestDispatcher("Vistas/consultar.jsp");
                break;
            case "Agregar":
                stTipo = request.getParameter("txtTipo");
                stIdentificacion = request.getParameter("txtIdentificacion");
                stNombre = request.getParameter("tstNombre");
                stApellidos = request.getParameter("txtApellidos");
                stEdad = request.getParameter("txtEdad");
                nEdad = Integer.parseInt(stEdad);
                stTelefono = request.getParameter("txtTelefono");
                stDireccion = request.getParameter("txtDireccion");
                objCliente = null;
                objCliente = new Cliente(0, stTipo, stIdentificacion, stNombre, stApellidos, nEdad, stTelefono, stDireccion);
                bReturn = objClienteDAO.agregar(objCliente);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
            case "Editar":
                nIdCliente = Integer.parseInt(request.getParameter("txtId"));
                objCliente = null;
                objCliente = objClienteDAO.consultarId(nIdCliente);
                request.setAttribute("objCliente", objCliente);
                request.getRequestDispatcher("Controlador=accion=Listar").forward(request, response);
                break;
            case "Actualizar":
                nIdCliente = Integer.parseInt(request.getParameter("txtId"));
                stTipo = request.getParameter("txtTipo");
                stIdentificacion = request.getParameter("txtIdentificacion");
                stNombre = request.getParameter("tstNombre");
                stApellidos = request.getParameter("txtApellidos");
                stEdad = request.getParameter("txtEdad");
                nEdad = Integer.parseInt(stEdad);
                stTelefono = request.getParameter("txtTelefono");
                stDireccion = request.getParameter("txtDireccion");
                objCliente = null;
                objCliente = new Cliente(0, stTipo, stIdentificacion, stNombre, stApellidos, nEdad, stTelefono, stDireccion);
                bReturn = objClienteDAO.modificar(objCliente);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
            case "Eliminar":
                nIdCliente = Integer.parseInt(request.getParameter("txtId"));
                bReturn = objClienteDAO.eliminar(nIdCliente);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
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
