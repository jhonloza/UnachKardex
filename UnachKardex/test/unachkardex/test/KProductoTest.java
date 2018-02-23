package unachkardex.test;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import java.util.*;
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
            int cK=listaKardexProd.get(listaKardexProd.size()).getCodKardex();
            String cP=listaKardexProd.get(listaKardexProd.size()).getProducto().getNombre();
            String tC=listaKardexProd.get(listaKardexProd.size()).getTipoTransaccion();
            Date fE=listaKardexProd.get(listaKardexProd.size()).getFechaEmision();
            int e=listaKardexProd.get(listaKardexProd.size()).getExistencias();
            double vT=listaKardexProd.get(listaKardexProd.size()).getValorTotal();
            int cE=listaKardexProd.get(listaKardexProd.size()).getCantEditable();
            System.out.println("Kardex Final: "+cK+"  "+cP+"  "+tC+"  "+fE+"  "+e+"  "+vT+"  "+cE+"  ");
            for (Kardex nKardex : listaKardexProd) {
                System.out.println("Kardex: "+nKardex.getCodKardex()+"  "+nKardex.getProducto().getNombre()+"  "+nKardex.getFechaEmision()+"  "+nKardex.getTipoTransaccion()+"  "+nKardex.getExistencias()+"  "+nKardex.getValorTotal()+"  "+nKardex.getCantEditable());
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        assertTrue(listaKardexProd.size()>0);
    }

}
