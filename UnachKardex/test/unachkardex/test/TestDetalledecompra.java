/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unachkardex.test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import unachkardex.negocio.dao.IDetalleCompra;
import unachkardex.negocio.dao.IDetalleVenta;
import unachkardex.negocio.entidades.Categoria;
import unachkardex.negocio.entidades.Cliente;
import unachkardex.negocio.entidades.DetalleCompra;
import unachkardex.negocio.entidades.DetalleVenta;
import unachkardex.negocio.entidades.FacturaCompra;
import unachkardex.negocio.entidades.FacturaVenta;
import unachkardex.negocio.entidades.Producto;
import unachkardex.negocio.entidades.Proveedor;
import unachkardex.negocio.impl.ImplDetalleCompra;
import unachkardex.negocio.impl.ImplDetalleVenta;

public class TestDetalledecompra {

    @Test
    public void testGeneral() {
        IDetalleCompra decoDao = new ImplDetalleCompra();
        
//        ///////INSERTAR TEST
//        int filas = 0;
//
//        Categoria ca = new Categoria(1,"ABC","Papel Ministro");
//        Producto producto = new Producto(2, ca, "A4", 4.00);
//        Proveedor pro = new Proveedor("0623547932", "Carlos", "Maldonado Norte", "09929291063",  "jc@gmail.com");
//        FacturaCompra facturacompra = new FacturaCompra(1, new java.util.Date(), pro);
//        DetalleCompra detallecompra = new DetalleCompra (1, producto, facturacompra, 20 , 60);
//
//        try {                                                                  
//            filas = decoDao.ingresar(detallecompra);
//            System.out.println("Filas insertadas: " + filas);
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        assertTrue(filas > 0);

        //////////////////////////////// obtener por codigo 
        DetalleCompra dc = new DetalleCompra();

        try {
            dc = decoDao.obtener(1);
            System.out.println(dc.getCodDetalleCompra() + " " + dc.getProducto().getCodProducto() + " " + dc.getFacturaCompra().getCodFacturaCompra() + " " + dc.getCantidad() + " " + dc.getPrecioTotal());
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        assertEquals(dc != null, true);

        ArrayList<DetalleCompra> dec = new ArrayList<>();
        try {
            dec = decoDao.obtener();
            for (DetalleCompra det : dec) {
                System.out.println(det.getCodDetalleCompra() + " " + det.getProducto().getCodProducto() + " " + det.getFacturaCompra().getCodFacturaCompra() + " " + det.getCantidad() + " " + det.getPrecioTotal());
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        
         assertTrue(dec.size()>0);
    }
}

