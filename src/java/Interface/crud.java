package Interface;

import Modelo.Cliente;
import java.util.List;

/**
 *
 * @author arpena
 */
public interface crud {
    public List consultar();
    public Cliente consultarId(int id);
    public boolean agregar(Cliente objCliente);
    public boolean modificar(Cliente objCliente);
    public boolean eliminar(int id);
}
