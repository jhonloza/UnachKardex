package unachkardex.negocio.impl;

import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;

import java.sql.*;
import java.util.*;


public class ImplFacturaVenta implements IFacturaVenta {

    @Override
    public int insertar(FacturaVenta facturaventa) throws Exception {
        int numFilas = 0;
        
        String sqlC = "INSERT INTO FacturaVenta (codFacturaVenta, fecha, cliente) VALUES (?,?,?) ";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, facturaventa.getCodFacturaVenta()));
        if (facturaventa.getFecha() instanceof java.util.Date) {
            
            lisParametros.add(new Parametro(2, new java.sql.Date(((java.util.Date) facturaventa.getFecha()).getTime())));
        } else {
            lisParametros.add(new Parametro(2, facturaventa.getFecha()));
        }
        lisParametros.add(new Parametro(3, facturaventa.getCliente().getCedula()));
        

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
    public int modificar(FacturaVenta facturaventa) throws Exception {
        int numFilas = 0;
        String sqlC = "update FacturaVenta set codFacturaVenta=?, fecha=?, cliente where codFacturaVenta =?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, facturaventa.getCodFacturaVenta()));
        if (facturaventa.getFecha() instanceof java.util.Date) {
            lisParametros.add(new Parametro(2, new java.sql.Date(((java.util.Date) facturaventa.getFecha()).getTime())));
        } else {
            lisParametros.add(new Parametro(2, facturaventa.getFecha()));
        }
        lisParametros.add(new Parametro(3, facturaventa.getCliente()));

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
    public int eliminar(FacturaVenta facturaventa) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM FacturaVenta VALUES WHERE codFacturaVenta=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, facturaventa.getCodFacturaVenta()));
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
    public FacturaVenta obtener(int codFacturaVenta) throws Exception {
        FacturaVenta fv = null;
        String sqlC = "SELECT codFacturaVenta, fecha, cliente from FacturaVenta WHERE codFacturaVenta=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codFacturaVenta));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ICliente clDao = new ImplCliente();
            Cliente cl = null;
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            while (rst.next()) {
                fv = new FacturaVenta();
                cl = new Cliente();
                fv.setCodFacturaVenta(rst.getInt(1));
                fv.setFecha(rst.getDate(2));
                cl = clDao.obtener(rst.getString(3));
                fv.setCliente(cl);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return fv;

    }

    @Override

    public ArrayList<FacturaVenta> obtener() throws Exception {
        FacturaVenta fv = null;
        String sqlC = "select codFacturaVenta, fecha, cliente from FacturaVenta";
        ArrayList<FacturaVenta> lstfv = new ArrayList<>();
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
            while(rst.next()){
                ICliente clDao = new ImplCliente();
                Cliente cl = null;
                fv = new FacturaVenta();
                fv.setCodFacturaVenta(rst.getInt(1));
                fv.setFecha(rst.getDate(2));
                cl = clDao.obtener(rst.getString(3));
                fv.setCliente(cl);
                lstfv.add(fv);
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        } finally {
            
            if (con != null) {
                con.desconectar();
            }
        }
        return  lstfv;
    }
}