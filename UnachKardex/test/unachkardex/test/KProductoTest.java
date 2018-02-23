package unachkardex.test;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;

public class KProductoTest {

    public KProductoTest() {
    }

    @Test
    public void testGeneral() {
        IConsultaKProducto kProducDao = new ImplConsultaKProducto();
        ArrayList<Kardex> listaKardexProd = new ArrayList<>();
        try {
            listaKardexProd = kProducDao.listadoKardexProducto(1);
            System.out.println("Tamaño de Listado kardex: "+listaKardexProd.size());
            for (Kardex nKardex : listaKardexProd) {
                System.out.println("Kardex: "+nKardex.getCodKardex()+"  "+nKardex.getProducto().getNombre()+"  "+nKardex.getFechaEmision()+"  "+nKardex.getTipoTransaccion()+"  "+nKardex.getExistencias()+"  "+nKardex.getValorTotal());
            }
        } catch (Exception e) {
        }
    }

}
