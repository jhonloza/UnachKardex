
package unachkardex.test;

import unachkardex.accesodatos.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.impl.*;
import unachkardex.negocio.entidades.*;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestProveedor {
    
    public TestProveedor() {
    }
    @Test
    public void testGeneral() {
        IProveedor proveedorDao=new ImplProveedor();
       
//TEST INSERTAR

//        int filas=0;
//       
//        Proveedor nuevoProveedor=new Proveedor("1234321234001","Ana","La esperanza","1234321234","gmailcom");
//        try {
//            filas=proveedorDao.ingresar(nuevoProveedor);
//            System.out.println("Filas Insertadas:"+filas);
//        } catch (Exception e) {
//        }
////        assertTrue(filas>0);
        
        //TEST ELIMINAR
        int filas=0;
        
        Proveedor prov = new Proveedor("1234321234001","Ana","La esperanza","1234321234","gmailcom");
         try {
             filas=proveedorDao.eliminar(prov);
             System.out.println("se elimino: "+filas+" proveedores");
         } catch (Exception e) {
             System.out.println("Error de eliminacion: "+e.getMessage());
         }
         assertTrue(filas>0);
        
//TEST OBTENER POR CODIGO

//        Proveedor prove=new Proveedor();
//        try {
//            prove=proveedorDao.obtener("10");
//            System.out.println(prove.getRuc()+"    "+prove.getNombre()+"    "+prove.getDireccion()+"    "+prove.getTelefono()+"     "+prove.geteMail());
//        } catch (Exception e) {
//            System.out.println("Error: "+e.getMessage());
//        }
//        assertEquals(prove!=null, true);
//            
////TEST LISTADO
//
//        ArrayList<Proveedor> proveedor=new ArrayList<>();
//        try {
//            proveedor=proveedorDao.obtener();
//           System.out.println("RUC \t" + " \tNOMBRE\t" + " \tDIRECCION\t" + "\tTELEFONO\t "+ "\t eMail" );
//            for(Proveedor pro:proveedor){
//                System.out.println(pro.getRuc()+"\t\t"+pro.getNombre()+"\t\t"+pro.getDireccion()+"\t"+pro.getTelefono()+"\t"+pro.geteMail());
//            }
//        } catch (Exception e) {
//            System.out.println("Error: "+e.getMessage());
//        }
//        assertTrue(proveedor.size()>0);
    }
} 