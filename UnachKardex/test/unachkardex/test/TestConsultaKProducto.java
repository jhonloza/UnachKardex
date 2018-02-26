
 
package unachkardex.test;

import org.junit.Test;
import static org.junit.Assert.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;
import java.util.*;
import java.sql.*;

public class TestConsultaKProducto {
    
    public TestConsultaKProducto() {
        
          IConsultaKProducto  ConsultaKProdDao = new ImplConsultaKProducto();
          
          ////TEST LISTADO
        
        ArrayList<Kardex> conslpro = new ArrayList<>();
        try {
            conslpro = ConsultaKProdDao.obtener(1);
            for (Kardex kar : conslpro) {
                System.out.println(kar.getCodKardex()+"   "+kar.getProducto().getNombre()+"   "+kar.getFechaEmision()+"   "+kar.getTipoTransaccion()+"   "+kar.getExistencias()+"   "+kar.getValorTotal()+"   "+kar.getCantEditable());
            }
        } catch (Exception e) {
            System.out.println("error: "+e.getMessage());
        }
        assertTrue(conslpro.size() > 0);
        
    }
    
}
