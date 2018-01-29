package unachkardex.test;

import org.junit.Test;
import static org.junit.Assert.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;
import java.util.*;
import java.sql.*;

public class TestFacturaVenta {

    public TestFacturaVenta() {
    }
    
     @Test
    public void testGeneral() {
        IFacturaVenta efacturaventaDao = new ImplFacturaVenta();
        
//TEST INSERTAR

        int filas = 0;
        Cliente cliente=new Cliente("1234567890", "David", "Campos", "La Conda", "0991575474","jc@gmail.com", new java.util.Date());
        FacturaVenta nFacVen=new FacturaVenta(2,new java.util.Date(), cliente);
        try {
            filas = efacturaventaDao.insertar(nFacVen);
            System.out.println("filas Insertadas:" + filas);
        } catch (Exception e) {
        }
        assertTrue(filas > 0);
        
       
//TEST OBTENER POR CODIGO

        FacturaVenta facvent = new FacturaVenta();
        try {
            facvent = efacturaventaDao.obtener(1);
            System.out.println(facvent.getCodFacturaVenta()+"     "+facvent.getFecha()+ "    " + facvent.getCliente().getCedula()+"\n\n");
        } catch (Exception e) {
        }
      //assertEquals(facvent != null, true);
        
////TEST LISTADO
        
        ArrayList<FacturaVenta> facven = new ArrayList<>();
        try {
            facven = efacturaventaDao.obtener();
            for (FacturaVenta facVent : facven) {
                System.out.println(facVent.getCodFacturaVenta()+"\t\t\t"+facVent.getFecha()+"\t\t\t"+facVent.getCliente().getCedula());
            }
        } catch (Exception e) {
            System.out.println("error: "+e.getMessage());
        }
        assertTrue(facven.size() > 0);
    }
    
}
