package unachkardex.negocio.dao;

import unachkardex.negocio.entidades.*;
import java.util.*;
public interface IFacturaCompra {
    public int insertar (FacturaCompra facturacompra) throws Exception;
    public int modificar (FacturaCompra facturacompra) throws Exception; 
    public int eliminar (FacturaCompra facturacompra) throws Exception;
    public FacturaCompra obtener (int codFacturaCompra) throws Exception;
    public ArrayList<FacturaCompra> obtener() throws Exception;
    
}
