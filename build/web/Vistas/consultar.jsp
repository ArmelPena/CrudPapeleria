<%-- 
    Document   : consultar
    Created on : 18/03/2022, 10:43:48 AM
    Author     : arpena
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.ClienteDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
    </head>
    <body>
        <h1>Clientes</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>TIPO DOCU</th>
                    <th>DOCUMENTO</th>
                    <th>NOMBRE</th>
                    <th>APELLIDOS</th>
                    <th>EDAD</th>
                    <th>TELEFONO</th>
                    <th>DIRECCION</th>
                    <th>OPCIONES</th>
                </tr>
            </thead>
            <%
                ClienteDAO dao = new ClienteDAO();
                List<Cliente> list = dao.consultar();
                Iterator<Cliente> iter = list.iterator();
                Cliente cli=null;
                while(iter.hasNext()){
                    cli=iter.next();
            %>
            <tbody>
                <tr>
                    <td><%= cli.getId()%></td>
                    <td><%= cli.getTipo()%></td>
                    <td><%= cli.getIdentificacion()%></td>
                    <td><%= cli.getNombre()%></td>
                    <td><%= cli.getApellidos()%></td>
                    <td><%= cli.getEdad()%></td>
                    <td><%= cli.getTelefono()%></td>
                    <td><%= cli.getDireccion()%></td>
                    <td>
                        <a>Editar</a>
                        <a>Borrar</a>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>

    </body>
</html>
