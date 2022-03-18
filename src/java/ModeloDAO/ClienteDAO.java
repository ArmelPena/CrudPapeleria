package ModeloDAO;

import Config.Conexion;
import Interface.crud;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arpena
 */
public class ClienteDAO implements crud {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cliente objCliente = new Cliente();

    @Override
    public List consultar() {
        ArrayList list = new ArrayList<>();
        String sql = "select * from cliente";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente objCli = new Cliente();
                objCli.setId(rs.getInt("id"));
                objCli.setTipo(rs.getString("tipo"));
                objCli.setIdentificacion(rs.getString("identificacion"));
                objCli.setNombre(rs.getString("nombre"));
                objCli.setApellidos(rs.getString("apellidos"));
                objCli.setEdad(rs.getInt("edad"));
                objCli.setTelefono(rs.getString("telefono"));
                objCli.setDireccion(rs.getString("direccion"));
                list.add(objCli);
                objCli = null;
            }
            con = null;
            ps = null;
            rs = null;
        } catch (Exception e) {

        }
        return list;
    }

    @Override
    public Cliente consultarId(int nId) {
        Cliente objCli = new Cliente();
        try {
            String sqlQuery = "select * from cliente where id=" + nId;

            con = cn.getConexion();
            ps = con.prepareStatement(sqlQuery);
            rs = ps.executeQuery();
            if (rs.next()) {
                objCli.setId(rs.getInt("id"));
                objCli.setTipo(rs.getString("tipo"));
                objCli.setIdentificacion(rs.getString("identificacion"));
                objCli.setNombre(rs.getString("nombre"));
                objCli.setApellidos(rs.getString("apellidos"));
                objCli.setEdad(rs.getInt("edad"));
                objCli.setTelefono(rs.getString("telefono"));
                objCli.setDireccion(rs.getString("direccion"));
            }
            con = null;
            ps = null;
            rs = null;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objCli;
    }

    @Override
    public boolean agregar(Cliente objCliente) {
        boolean bReturn = false;
        try {

            String sqlQuery = "insert into cliente (tipo, identificacion, nombre, apellidos, edad, telefono, direccion) "
                    + "values (?,?,?,?,?,?,?,?)";
            con = cn.getConexion();
            ps = con.prepareStatement(sqlQuery);

            ps.setString(1, objCliente.getTipo());
            ps.setString(2, objCliente.getIdentificacion());
            ps.setString(3, objCliente.getNombre());
            ps.setString(4, objCliente.getApellidos());
            ps.setInt(5, objCliente.getEdad());
            ps.setString(6, objCliente.getTelefono());
            ps.setString(7, objCliente.getDireccion());

            con = null;
            ps = null;
            rs = null;
            bReturn = true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bReturn;
    }

    @Override
    public boolean modificar(Cliente objCliente) {
        boolean bReturn = false;
        try {
            String sqlQuery = "update cliente set "
                    + "tipo = ?,"
                    + "identificacion = ?, "
                    + "nombre = ?, "
                    + "apellidos = ?, "
                    + "edad = ?, "
                    + "telefono = ?, "
                    + "direccion = ? "
                    + "where (id= )" + objCliente.getId();

            con = cn.getConexion();
            ps = con.prepareStatement(sqlQuery);

            ps.setString(1, objCliente.getTipo());
            ps.setString(2, objCliente.getIdentificacion());
            ps.setString(3, objCliente.getNombre());
            ps.setString(4, objCliente.getApellidos());
            ps.setInt(5, objCliente.getEdad());
            ps.setString(6, objCliente.getTelefono());
            ps.setString(7, objCliente.getDireccion());

            con = null;
            ps = null;
            rs = null;
            bReturn = true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bReturn;
    }

    @Override
    public boolean eliminar(int nId) {
        boolean bReturn = false;
        try {
            String sqlQuery = "delete from cliente where cliente.id = " + nId;
            con = cn.getConexion();
            ps = con.prepareStatement(sqlQuery);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bReturn;
    }
}
