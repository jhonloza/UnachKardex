package unachkardex.test;

import unachkardex.negocio.dao.ICategoria;
import unachkardex.negocio.entidades.Categoria;
import unachkardex.negocio.impl.ImplCategoria;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import unachkardex.negocio.dao.ICliente;
import unachkardex.negocio.entidades.Cliente;
import unachkardex.negocio.impl.ImplCliente;

public class TestCategoria {

    public TestCategoria() {
    }

    @Test
    public void testGeneral() {
        ICategoria categoriaDao = new ImplCategoria();
        // TEST INSERTAR
//
        int filas = 0;
        Categoria categoria = new Categoria(5, "cualquier cosa", "ni idea");
        try {
            filas = categoriaDao.insertar(categoria);
            System.out.println("Ingreso de " + filas + " Filas Correctas");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(filas > 0);
        
        
        // ELIMINAR 
        
//        int filas=0;
//        Categoria ncategoria = new Categoria( 17001, "ABC", "LAPIZ");
//          ICategoria categoriaDao=new ImplCategoria();
//         try {
//             filas=categoriaDao.eliminar(ncategoria);
//             System.out.println("se elimino: "+filas+" Categoria");
//         } catch (Exception e) {
//            System.out.println("Error de eliminacion: "+e.getMessage());
//        }
//         assertTrue(filas>0);
//        

        //TEST OBTENER POR CODIGO
        
        Categoria categori = new Categoria();
        try {
            categori = categoriaDao.obtener(1);
            System.out.println(categori.getCodCategoria() + "    " + categori.getNombre() + "    " + categori.getDescripcion());
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(categori!=null, true);
        
        //TEST LISTADO
        
        ArrayList<Categoria> categ = new ArrayList<>();
        try {
            categ = categoriaDao.obtener();
            System.out.println("Codigo de Categoria \t" + "Nombre \t" + " \t Descripcion\t");
            for (Categoria cate : categ) {
                System.out.println(cate.getCodCategoria() + "\t\t" + cate.getNombre() + "\t\t" + cate.getDescripcion() + "\t\t");
            }
        } catch (Exception e) {
        }
        assertTrue(categ.size() > 0);
    }
}
