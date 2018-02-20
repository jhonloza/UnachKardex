package unachkardex.negocio.dao;

import java.util.*;
import unachkardex.negocio.entidades.*;

public interface IKardex {

    public int insertar(Kardex kardex) throws Exception;

    public int modificar(Kardex kardex) throws Exception;

    public int eliminar(Kardex kardex) throws Exception;

    public Kardex obtener(int codKardex, int codProducto) throws Exception;

    public ArrayList<Kardex> obtener() throws Exception;
    
    public ArrayList<Kardex> obtenerkardexProducto(int producto) throws Exception;
}
