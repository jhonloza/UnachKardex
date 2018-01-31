package unachkardex.negocio.impl;

import unachkardex.accesodatos.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import java.util.*;
import java.sql.*;


public class ImplDetalleVenta implements IDetalleVenta {

    @Override
    public int ingresar(DetalleVenta detalleVenta) throws Exception {
        int numFilas = 0;
        String sqlC = "INSERT INTO DetalleVenta (codDetalleVenta, codProducto, codFacturaVenta, cantidad, precioTotal) VALUES (?,?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, detalleVenta.getCodDetalleVenta()));
        lisParametros.add(new Parametro(2, detalleVenta.getProducto().getCodProducto()));
        lisParametros.add(new Parametro(3, detalleVenta.getFacturaVenta().getCodFacturaVenta()));
        lisParametros.add(new Parametro(4, detalleVenta.getCantidad()));
        lisParametros.add(new Parametro(5, detalleVenta.getPrecioTotal()));
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
    public int modificar(DetalleVenta detalleVenta) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE DetalleVenta SET codDetalleVenta=?, codProducto=?, codFacturaVenta=?, cantidad=?, precioTotal=? WHERE codDetalleVenta=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, detalleVenta.getCodDetalleVenta()));
        lisParametros.add(new Parametro(2, detalleVenta.getProducto().getCodProducto()));
        lisParametros.add(new Parametro(3, detalleVenta.getFacturaVenta().getCodFacturaVenta()));
        lisParametros.add(new Parametro(4, detalleVenta.getCantidad()));
        lisParametros.add(new Parametro(5, detalleVenta.getPrecioTotal()));
        lisParametros.add(new Parametro(6, detalleVenta.getCodDetalleVenta()));
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
    public int eliminar(DetalleVenta detalleVenta) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM DetalleVenta WHERE codDetalleVenta=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, detalleVenta.getCodDetalleVenta()));
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
    public DetalleVenta obtener(int codDetalleVenta) throws Exception {
        DetalleVenta detalle = null;
        String sqlC = "SELECT codDetalleVenta, codProducto, codFacturaVenta, cantidad, precioTotal FROM DetalleVenta Where codDetalleVenta=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codDetalleVenta));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            IProducto productoDao = new ImplProducto();
            Producto produc = null;
            IFacturaVenta factVentaDao = new ImplFacturaVenta();
            FacturaVenta factVenta = new FacturaVenta();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            while (rst.next()) {
                detalle = new DetalleVenta();
                produc = new Producto();
                factVenta = new FacturaVenta();
                detalle.setCodDetalleVenta(rst.getInt(1));
                produc = productoDao.obtener(rst.getInt(2));
                detalle.setProducto(produc);
                factVenta = factVentaDao.obtener(rst.getInt(3));
                detalle.setFacturaVenta(factVenta);
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
    public ArrayList<DetalleVenta> obtener() throws Exception {
        DetalleVenta dec = null;
        ArrayList<DetalleVenta> lstDetalle = new ArrayList<>();
        DetalleVenta detalle = null;
        String sqlC = "SELECT codDetalleVenta, codProducto, codFacturaVenta, cantidad, precioTotal FROM DetalleVenta";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();

            ResultSet rst = con.ejecutarQuery(sqlC, null);
            while (rst.next()) {
                IProducto productoDao = new ImplProducto();
                Producto produc = null;
                IFacturaVenta factVentaDao = new ImplFacturaVenta();
                FacturaVenta fc = null;
                dec = new DetalleVenta();               
                produc = new Producto();
                fc = new FacturaVenta();
                dec.setCodDetalleVenta(rst.getInt(1));
                produc = productoDao.obtener(rst.getInt(2));
                dec.setProducto(produc);
                fc = factVentaDao.obtener(rst.getInt(3));
                dec.setFacturaVenta(fc);
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
