
package unachkardex.negocio.dao;


import unachkardex.negocio.entidades.*;

import java.util.ArrayList;

public interface IDetalleCompra {
    public int ingresar(DetalleCompra detalleCompra) throws Exception;
    public int modificar(DetalleCompra detalleCompra) throws Exception;
    public int eliminar(DetalleCompra detalleCompra) throws Exception;
    public DetalleCompra obtener(int codDetalleCompra) throws Exception;
    public ArrayList<DetalleCompra> obtener() throws Exception;
}
