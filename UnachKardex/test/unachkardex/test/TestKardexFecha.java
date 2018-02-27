
package unachkardex.test;

import org.junit.Test;
import static org.junit.Assert.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;
import java.util.*;
import java.sql.*;
import java.text.*;
public class TestKardexFecha {
    
    public TestKardexFecha() {
    }
    @Test
    public void testGeneral(){
        IKardexM kardexDao=new ImplKardexM();
        ArrayList<Kardex> lista=new ArrayList<>();
        try {
            lista=kardexDao.listadoKardexFecha(1, "2016-08-01", "2016-08-30");
            for (Kardex k: lista){
                System.out.println(k.getCodKardex()+"  "+k.getProducto().getNombre()+"  "+k.getFechaEmision()+"  "+k.getTipoTransaccion()+"  "+k.getExistencias()+"  "+k.getValorTotal()+"  "+k.getCantEditable()+"  ");
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        } 
        assertTrue(lista.size()>0);
    }
}
