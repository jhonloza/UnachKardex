

package unachkardex.negocio.impl;
import unachkardex.accesodatos.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import java.sql.*;
import java.util.*;
public class ImplDetalleCompra implements IDetalleCompra{
    @Override
    public int ingresar(DetalleCompra detalleCompra) throws Exception {
        int numFilas = 0;
        String sqlC = "INSERT INTO DetalleCompra (codDetalleCompra, codProducto, codFacturaCompra, cantidad, precioTotal) VALUES (?,?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, detalleCompra.getCodDetalleCompra()));
        
        lisParametros.add(new Parametro(2, detalleCompra.getProducto().getCodProducto()));
        lisParametros.add(new Parametro(3, detalleCompra.getFacturaCompra().getCodFacturaCompra()));
        
        lisParametros.add(new Parametro(4, detalleCompra.getCantidad()));
        lisParametros.add(new Parametro(5, detalleCompra.getPrecioTotal()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;

    }
    @Override
    public int modificar(DetalleCompra detalleCompra) throws Exception {
        
        int numFilas = 0;
        String sqlC = "UPDATE DetalleCompra SET codDetalleCompra=?, codProducto=?, codFacturaCompra=?, cantidad=?, precioTotal=? WHERE codDetalleCompra=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, detalleCompra.getCodDetalleCompra()));
        lisParametros.add(new Parametro(2, detalleCompra.getProducto().getCodProducto()));
        lisParametros.add(new Parametro(3, detalleCompra.getFacturaCompra().getCodFacturaCompra()));
        lisParametros.add(new Parametro(4, detalleCompra.getCantidad()));
        lisParametros.add(new Parametro(5, detalleCompra.getPrecioTotal()));
        lisParametros.add(new Parametro(6, detalleCompra.getCodDetalleCompra()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;
    }
    @Override
    public int eliminar(DetalleCompra detalleCompra) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM DetalleCompra WHERE codDetalleCompra=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, detalleCompra.getCodDetalleCompra()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;
    }
        @Override
    public DetalleCompra obtener(int codDetalleCompra) throws Exception {
        DetalleCompra detalle = null;
        String sqlC = "SELECT codDetalleCompra, codProducto, codFacturaCompra, cantidad, precioTotal FROM DetalleCompra Where codDetalleCompra=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codDetalleCompra));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
           IProducto productoDao = new ImplProducto();
            Producto produc = null;
            IFacturaCompra factCompraDao = new ImplFacturaCompra();
            FacturaCompra factCompra = new FacturaCompra();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            
            while (rst.next()) {
                detalle = new DetalleCompra();
                produc = new Producto();
                factCompra = new FacturaCompra();
                detalle.setCodDetalleCompra(rst.getInt(1));
              produc = productoDao.obtener(rst.getInt(2));
                detalle.getProducto();
                factCompra = factCompraDao.obtener(rst.getInt(3));
                detalle.setCantidad(rst.getInt(4));
                detalle.setPrecioTotal(rst.getDouble(5));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return detalle;
    }
     @Override
    public ArrayList<DetalleCompra> obtener() throws Exception {
        ArrayList<DetalleCompra> lstDetalle=new ArrayList<>();
        DetalleCompra detalle = null;
        String sqlC = "SELECT codDetalleCompra, codProducto, codFacturaCompra, cantidad, precioTotal FROM DetalleCompra";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            IProducto productoDao = new ImplProducto();
            Producto produc = null;
            IFacturaCompra factCompraDao = new ImplFacturaCompra();
            FacturaCompra factCompra = new FacturaCompra();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
            while (rst.next()) {
                detalle = new DetalleCompra();
                produc = new Producto();
                factCompra = new FacturaCompra();
                detalle.setCodDetalleCompra(rst.getInt(1));
                produc = productoDao.obtener(rst.getInt(2));
                detalle.setProducto(produc);
                factCompra = factCompraDao.obtener(rst.getInt(3));
                detalle.setFacturaCompra(factCompra);
                detalle.setCantidad(rst.getInt(4));
                detalle.setPrecioTotal(rst.getDouble(5));
                lstDetalle.add(detalle);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return lstDetalle;
    }
}
