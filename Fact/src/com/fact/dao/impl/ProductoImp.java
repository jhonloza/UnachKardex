package com.fact.dao.impl;

import com.fact.accesoadatos.Conexion;
import com.fact.accesoadatos.Parametro;
import com.fact.dao.contrato.ICategoria;
import com.fact.dao.contrato.IProducto;
import com.fact.dao.rnegocio.entidades.Iva;
import com.fact.dao.rnegocio.entidades.Producto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductoImp implements IProducto {

    @Override
    public int insertar(Producto producto) {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO public.producto(\n"
                + "            codigo_producto, nombre, fecha_caducacion, \n"
                + "            categoria, precio_venta, precio_venta_cantidad, stock_cantidad, \n"
                + "            stock, precio_total_venta, detalle)\n"
                + "    VALUES (?, ?, ?, \n"
                + "            ?, ?, ?, ?, \n"
                + "            ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getCodigo()));
        lstPar.add(new Parametro(2, producto.getNombre()));
        lstPar.add(new Parametro(3, producto.getFechacaducacion()));
        lstPar.add(new Parametro(4, producto.getCategoria().getCodigo()));
        lstPar.add(new Parametro(5, producto.getPrecioventa()));
        lstPar.add(new Parametro(6, producto.getPrecioventacantidad()));
        lstPar.add(new Parametro(7, producto.getStockcantidad()));
        lstPar.add(new Parametro(8, producto.getStock()));
        lstPar.add(new Parametro(9, producto.getPreciototalventa()));
        lstPar.add(new Parametro(10, producto.getDetalle()));
        Conexion con = new Conexion();
        try {
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Producto producto) {
        int modificado = 0;
        String sql = "UPDATE public.producto\n"
                + "   SET nombre=?, fecha_caducacion=?, categoria=?, precio_venta=?, \n"
                + "       precio_venta_cantidad=?, stock_cantidad=?, stock=?, \n"
                + "       precio_total_venta=?, detalle=?\n"
                + " WHERE codigo_producto = ?";
        List<Parametro> prts = new ArrayList<>();
        prts.add(new Parametro(1, producto.getNombre()));
        prts.add(new Parametro(2, producto.getFechacaducacion()));
        prts.add(new Parametro(3, producto.getCategoria().getCodigo()));
        prts.add(new Parametro(4, producto.getPrecioventa()));
        prts.add(new Parametro(5, producto.getPrecioventacantidad()));
        prts.add(new Parametro(6, producto.getStockcantidad()));
        prts.add(new Parametro(7, producto.getStock()));
        prts.add(new Parametro(8, producto.getPreciototalventa()));
        prts.add(new Parametro(9, producto.getDetalle()));
        prts.add(new Parametro(10, producto.getCodigo()));
        Conexion con = new Conexion();
        try {
            modificado = con.ejecutaComando(sql, prts);
        } catch (Exception e) {
            //System.err.println(e.getMessage());
            throw e;
        }
        return modificado;
    }

    @Override
    public int eliminar(Producto producto) {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM producto WHERE codigo_producto=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getCodigo()));
        Conexion con = new Conexion();
        con.conectar();
        try {
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public Producto obtener(int id) throws Exception {
        Producto pro = null;
        ICategoria sqlCategoria = new CategoriaImp();
        String sql = "SELECT codigo_producto, nombre, fecha_caducacion, \n"
                + "       categoria, precio_venta, precio_venta_cantidad, stock_cantidad, \n"
                + "       stock, precio_total_venta, detalle\n"
                + "  FROM public.producto where codigo_producto=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                pro = new Producto();
                pro.setCodigo(rst.getInt(1));
                pro.setNombre(rst.getString(2));
                pro.setFechacaducacion(rst.getDate(3));
                pro.setCategoria(sqlCategoria.obtener(rst.getInt(4)));
                pro.setPrecioventa(rst.getDouble(5));
                pro.setPrecioventacantidad(rst.getDouble(6));
                pro.setStockcantidad(rst.getDouble(7));
                pro.setStock(rst.getDouble(8));
                pro.setPreciototalventa(rst.getDouble(9));
                pro.setDetalle(rst.getString(10));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return pro;
    }

    @Override
    public List<Producto> obtener() throws Exception {
        List<Producto> lista = new ArrayList<>();
        ICategoria sqlCategoria = new CategoriaImp();
        String sql = "SELECT codigo_producto, nombre, fecha_caducacion, \n"
                + "       categoria, precio_venta, precio_venta_cantidad, \n"
                + "       stock_cantidad, stock, precio_total_venta, \n"
                + "       detalle\n"
                + "  FROM public.producto";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Producto pro = new Producto();
                pro.setCodigo(rst.getInt(1));
                pro.setNombre(rst.getString(2));
                pro.setFechacaducacion(rst.getDate(3));
                pro.setCategoria(sqlCategoria.obtener(rst.getInt(4)));
                pro.setPrecioventa(rst.getDouble(5));
                pro.setPrecioventacantidad(rst.getDouble(6));
                pro.setStockcantidad(rst.getDouble(7));
                pro.setStock(rst.getDouble(8));
                pro.setPreciototalventa(rst.getDouble(9));
                pro.setDetalle(rst.getString(10));
                lista.add(pro);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        lista.sort(new Comparator<Producto>() {
            @Override
            public int compare(Producto producto1, Producto producto2) {
                return new Integer(producto1.getCodigo()).compareTo(producto2.getCodigo());
            }
        });
        return lista;
    }

}
