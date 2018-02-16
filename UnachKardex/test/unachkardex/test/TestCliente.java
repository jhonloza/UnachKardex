package unachkardex.test;

import org.junit.Test;
import static org.junit.Assert.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;
import java.util.*;

import java.sql.*;

public class TestCliente {

    public TestCliente() {

    }

    @Test
    public void testGeneral() {
        ICliente clDao = new ImplCliente();

        ///////TEST INSERTAR
//        
//        int filas = 0;
//
//        Cliente cln = new Cliente("06034377", "Daniel", "Bastian", "10 de agosto", "0973140672", "ao@gmail.com", new java.util.Date());
//        try {
//            filas = clDao.insertar(cln);
//            System.out.println("filas Inseertadas: " + filas + "\n");
//        } catch (Exception e) {
//        }
//        assertTrue(filas > 0);
        //ELIMINAR 
        
        int filas=0;
        Cliente ncliente = new Cliente("1700000000001", "Andres", "Orozco","Quito","099292921063","",new java.util.Date());
          ICliente clienteDao=new ImplCliente();
         try {
             filas=clienteDao.eliminar(ncliente);
             System.out.println("se elimino: "+filas+" Cliente");
         } catch (Exception e) {
             System.out.println("Error de eliminacion: "+e.getMessage());
         }
         assertTrue(filas>0);
        
        ////TEST OBTENER CODIGO
//        Cliente cli = new Cliente();
//
//        try {
//            cli = clDao.obtener("0604227215");
//            System.out.println(cli.getCedula() + " " + cli.getNombre() + " " + cli.getApellido() + " " + cli.getDireccion() + " " + cli.getTelefono() + " " + cli.geteMail() + " " + cli.getFechaNac());
//        } catch (Exception e) {
//            System.out.println("Error: "+e.getMessage());
//        }
//        assertEquals(cli!=null, true);
//        
        //////// TEST LISTADO 
//        
//        ArrayList<Cliente> clientess = new ArrayList<>();
//        try {
//            clientess = clDao.obtener();
//            for (Cliente clientes : clientess) {
//                System.out.println("CEDULA      " + "  NOMBRE "+ "   APELLIDO"+"DIRECCION"+"TELEFONO"+"EMAIL"+"FECHA NACIEMIENTO");
//                System.out.println(clientes.getCedula() + "" + clientes.getNombre() + "" + clientes.getApellido() + "" + clientes.getDireccion() + "" + clientes.getTelefono() + "" + clientes.geteMail() + " "+ clientes.getFechaNac());
//            }
//        } catch (Exception e) {
//        }
//       assertTrue(clientess.size() > 0);
//    }

}
}
