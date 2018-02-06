package unachkardex.test;

import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.*;

public class TestDetalledeventa {

    @Test
    public void testGeneral() {
        IDetalleVenta deveDao = new ImplDetalleVenta();
        
        /////////INSERTAR TEST
//        int filas = 0;
//
//        Categoria ca = new Categoria(3, "GHI", "Papel Bon");
//        Producto producto = new Producto(3, ca, "A4", 4.00);
//        Cliente cli = new Cliente("0623547932", "Carlos", "Arevalo", "La Maldonado", "0991575474", "jc@gmail.com", new java.util.Date());
//        FacturaVenta facturaventa = new FacturaVenta(3, new java.util.Date(), cli);
//        DetalleVenta detalleventa = new DetalleVenta(4, producto, facturaventa, 1, 2);
//
//        try {                                                                  
//            filas = deveDao.ingresar(detalleventa);
//            System.out.println("Filas insertadas: " + filas);
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        assertTrue(filas > 0);
//
//        //////////////////////////////// obtener por codigo 
        DetalleVenta dt = new DetalleVenta();

        try {
            dt = deveDao.obtener(1);
            System.out.println(dt.getCodDetalleVenta() + " " + dt.getProducto().getCodProducto() + " " + dt.getFacturaVenta().getCodFacturaVenta() + " " + dt.getCantidad() + " " + dt.getPrecioTotal());
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        assertEquals(dt != null, true);
// OBTENES LISTADO
        ArrayList<DetalleVenta> det = new ArrayList<>();
        try {
            det = deveDao.obtener();
            for (DetalleVenta deta : det) {
                System.out.println(deta.getCodDetalleVenta() + " " + deta.getProducto().getCodProducto() + " " + deta.getFacturaVenta().getCodFacturaVenta() + " " + deta.getCantidad() + " " + deta.getPrecioTotal());
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        
         assertTrue(det.size()>0);
    }
}
