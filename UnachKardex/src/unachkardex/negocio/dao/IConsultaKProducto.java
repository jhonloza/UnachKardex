
package unachkardex.negocio.dao;
import unachkardex.negocio.impl.*;
import unachkardex.negocio.entidades.*;

import java.util.ArrayList;
public interface IConsultaKProducto {
     public ArrayList<Kardex> obtener(int codProducto) throws Exception;
    
}
