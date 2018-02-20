 package unachkardex.test;
import unachkardex.accesodatos.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.impl.*;
import unachkardex.negocio.entidades.*;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestProducto {

    public TestProducto() {
    }
    
     @Test
    public void testGeneral() {
        IProducto productoDao = new ImplProducto();
        
//TEST INSERTAR

        int filas = 0;
        Categoria ncategoria = new Categoria(1, "ABC", "Cuadernoss");
        Producto produc = new Producto(74,ncategoria,  "Academico", 1.75);
        try {
            filas = productoDao.insertar(produc);
            System.out.println("filas Insertadas:" + filas);
        } catch (Exception e) {
        }
        assertTrue(filas > 0);
        //TEST ELIMINAR
//        int filas=0;
//        Categoria ncategoria = new Categoria(9, "Cuaderno", "Material de uso para toma de notas o apuntes");
//        Producto produc = new Producto(74,ncategoria,  "Cuadreno ", 1.00);
//         try {
//             filas=productoDao.eliminar(produc);
//             System.out.println("se elimino: "+filas+" productos");
//         } catch (Exception e) {
//             System.out.println("Error de eliminacion: "+e.getMessage());
//         }
//         assertTrue(filas>0);
        //TEST MODIFICAR
//        int filas=0;
//        Categoria ncategoria = new Categoria(1, "ABC", "Cuadernoss");
//        Producto produc = new Producto(1,ncategoria,  "tu Madre", 17.5);
//         try {
//             filas=productoDao.modificar(produc);
//             System.out.println("se elimino: "+filas+" productos");
//         } catch (Exception e) {
//             System.out.println("Error de eliminacion: "+e.getMessage());
//         }
//         assertTrue(filas>0);
         
         
////TEST OBTENER POR CODIGO

//        Producto producto = new Producto();
//        try {
//            producto = productoDao.obtener(1);
//            System.out.println(producto.getCodProducto() + "\t\t" + producto.getCategoria().getCodCategoria() + "\t\t" + producto.getNombre() + "\t\t" + producto.getPrecio() + "\t\t" + "\n\n");
//        } catch (Exception e) {
//        }
//        assertEquals(producto != null, true);
        
//TEST LISTADO

//        ArrayList<Producto> productos = new ArrayList<>();
//        try {
//            productos = productoDao.obtener();
//            for (Producto nProductos : productos) {
//                System.out.println(nProductos.getCodProducto()+"\t\t\t"+ nProductos.getCategoria().getCodCategoria()+"\t\t\t"+nProductos.getNombre()+"\t\t\t"+nProductos.getPrecio());
//            }
//        } catch (Exception e) {
//        }
//        assertTrue(productos.size() > 0);
    }

}
