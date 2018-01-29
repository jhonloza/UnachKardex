package unachkardex.negocio.impl;

import unachkardex.accesodatos.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ImplProducto implements IProducto{
    
    @Override
    public int insertar(Producto producto) throws Exception {
         int numFilas = 0;
        String sqlC = "INSERT INTO Producto (codProducto, codCategoria, nombre , precio) VALUES (?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, producto.getCodProducto()));
        lisParametros.add(new Parametro(2, producto.getCategoria().getCodCategoria()));
        lisParametros.add(new Parametro(3, producto.getNombre()));
        lisParametros.add(new Parametro(4, producto.getPrecio()));
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
    public Producto obtener(int codProducto) throws Exception {
        
        Producto pro = null;
        String sqlC = "SELECT codProducto, codCategoria, nombre, precio FROM Producto Where codProducto=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codProducto));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ICategoria clDao = new ImplCategoria();
            Categoria ca = null;
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            while (rst.next()) {
                pro = new Producto();
                ca = new Categoria();
                pro.setCodProducto(rst.getInt(1));
                ca = clDao.obtener(rst.getInt(2));
                pro.setCategoria(ca);
                pro.setNombre(rst.getString(3));
                pro.setPrecio(rst.getDouble(4));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return pro;

    }


@Override
    public int modificar(Producto producto) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE Producto SET codProducto=?, codCategoria=?, nombre=?, precio=? WHERE codProducto=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, producto.getCodProducto()));
        lisParametros.add(new Parametro(2, producto.getCategoria().getCodCategoria()));
        lisParametros.add(new Parametro(3, producto.getNombre()));
        lisParametros.add(new Parametro(4, producto.getPrecio()));
    
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
    public int eliminar(Producto producto) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM DetalleCompra WHERE codDetalleCompra=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, producto.getCodProducto()));
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
    public ArrayList<Producto> obtener() throws Exception {
        Producto pro = null;
        String sqlC = "select codProducto, codCategoria, nombre, precio from Producto";
        ArrayList<Producto> lstpro = new ArrayList<>();
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
            while(rst.next()){
                ICategoria clDao = new ImplCategoria();
                Categoria cl = null;
                pro = new Producto();
                pro.setCodProducto(rst.getInt(1));
                cl = clDao.obtener(rst.getInt(2));
                pro.setCategoria(cl);
                pro.setNombre(rst.getString(3));
                pro.setPrecio(rst.getDouble(4));
                lstpro.add(pro);
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        } finally {
            
            if (con != null) {
                con.desconectar();
            }
        }
        return  lstpro;
    }
}