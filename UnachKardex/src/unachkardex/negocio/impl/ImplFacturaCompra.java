package unachkardex.negocio.impl;

import unachkardex.accesodatos.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import java.util.*;
import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImplFacturaCompra implements IFacturaCompra {

    @Override
    public int insertar(FacturaCompra facturacompra) throws Exception {
        int numFilas = 0;
        String sqlC = "INSERT INTO FacturaCompra (codFacturaCompra,fecha, codProveedor) VALUES (?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();

        lisParametros.add(new Parametro(1, facturacompra.getCodFacturaCompra()));

        if (facturacompra.getFecha() instanceof java.util.Date) {
            lisParametros.add(new Parametro(2, new java.sql.Date(((java.util.Date) facturacompra.getFecha()).getTime())));
        } else {
            lisParametros.add(new Parametro(2, facturacompra.getFecha()));
        }
        lisParametros.add(new Parametro(3, facturacompra.getProveedor().getRuc()));

        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;
    }

    @Override
    public int modificar(FacturaCompra facturacompra) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE FacturaCompra SET codFacturaCompra=?, fecha=?, codProveedor=? WHERE codFacturaCompra=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, facturacompra.getCodFacturaCompra()));

        if (facturacompra.getFecha() instanceof java.util.Date) {
            lisParametros.add(new Parametro(2, new java.sql.Date(((java.util.Date) facturacompra.getFecha()).getTime())));
        } else {
            lisParametros.add(new Parametro(2, facturacompra.getFecha()));
        }
        lisParametros.add(new Parametro(3, facturacompra.getProveedor()));

        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;
    }

    @Override
    public int eliminar(FacturaCompra facturacompra) throws Exception {
        int filas = 0;
        String sqlC = "DELETE FROM FacturaCompra  WHERE codFacturaCompra=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, facturacompra.getCodFacturaCompra()));

        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            filas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return filas;
    }

    @Override

    public FacturaCompra obtener(int facturacompra) throws Exception {
        FacturaCompra nFC = null;
        String sqlC = "SELECT codFacturaCompra, fecha, codProveedor FROM FacturaCompra WHERE codFacturaCompra=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, facturacompra));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            Proveedor nProveedor = null;
            IProveedor obFC = new ImplProveedor();
            while (rst.next()) {
                nProveedor = new Proveedor();
                nFC = new FacturaCompra();
                nFC.setCodFacturaCompra(rst.getInt(1));
                nFC.setFecha(rst.getDate(2));
                nProveedor = obFC.obtener(rst.getString(3));
                nFC.setProveedor(nProveedor);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nFC;
    }

    @Override
    public ArrayList<FacturaCompra> obtener() throws Exception {
        FacturaCompra ef = null;
        ArrayList<FacturaCompra> listFacturaCompra = new ArrayList<>();
        String sqlC = "SELECT codFacturaCompra, fecha, codProveedor FROM FacturaCompra ";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
  
            ResultSet rst = con.ejecutarQuery(sqlC, null);
            while (rst.next()) {
                IProveedor obProveedor = new ImplProveedor();
                Proveedor nProveedor = null;
                ef = new FacturaCompra();
                nProveedor = new Proveedor();
                ef.setCodFacturaCompra(rst.getInt(1));
                ef.setFecha(rst.getDate(2));
                nProveedor = obProveedor.obtener(rst.getString(3));
                ef.setProveedor(nProveedor);
                listFacturaCompra.add(ef);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return listFacturaCompra;
    }
}
