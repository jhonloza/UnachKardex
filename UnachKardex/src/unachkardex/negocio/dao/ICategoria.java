
package unachkardex.negocio.dao;


import unachkardex.negocio.entidades.Categoria;
import java.util.ArrayList;


public interface ICategoria {
    public int insertar (Categoria categoria) throws Exception;
    public int modificar (Categoria categoria) throws Exception; 
    public int eliminar (Categoria categoria) throws Exception;
    
    public Categoria obtener (int codCategoria) throws Exception;
    public ArrayList<Categoria> obtener() throws Exception;
}
