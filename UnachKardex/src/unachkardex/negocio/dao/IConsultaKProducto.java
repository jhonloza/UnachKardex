package unachkardex.negocio.dao;

import java.sql.*;
import unachkardex.negocio.impl.*;
import unachkardex.negocio.entidades.*;
import java.util.*;

public interface IConsultaKProducto {

    public ArrayList<Kardex> listadoKardexProducto(int codProducto) throws Exception;
    
}
