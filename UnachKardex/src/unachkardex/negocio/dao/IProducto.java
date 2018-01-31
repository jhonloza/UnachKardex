package unachkardex.negocio.dao;
import unachkardex.negocio.entidades.Producto;
import java.util.ArrayList;

public interface IProducto {
     public int insertar (Producto producto) throws Exception;
    public int modificar (Producto producto) throws Exception; 
    public int eliminar (Producto producto) throws Exception;
    public Producto obtener (int  codProducto) throws Exception;
    public ArrayList<Producto> obtener() throws Exception;
    
}

