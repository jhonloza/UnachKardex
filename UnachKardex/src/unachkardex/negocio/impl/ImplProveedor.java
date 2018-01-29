package unachkardex.negocio.impl;
import unachkardex.accesodatos.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import java.util.*;
import java.sql.*;

public class ImplProveedor implements IProveedor{

    @Override
    public int ingresar(Proveedor proveedor) throws Exception {
        int numFilas = 0;
        String sqlC = "INSERT INTO Proveedor (ruc, nombre, direccion, telefono, eMail) VALUES (?,?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, proveedor.getRuc()));
        lisParametros.add(new Parametro(2, proveedor.getNombre()));
        lisParametros.add(new Parametro(3, proveedor.getDireccion()));
        lisParametros.add(new Parametro(4, proveedor.getTelefono()));
        lisParametros.add(new Parametro(5, proveedor.geteMail()));
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
    public int modificar(Proveedor proveedor) throws Exception {
         int numFilas = 0;
        String sqlC = "UPDATE Proveedor SET ruc=?, nombre=?, direccion=?, telefono=?, eMail=? WHERE ruc=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, proveedor.getRuc()));
        lisParametros.add(new Parametro(2, proveedor.getNombre()));
        lisParametros.add(new Parametro(3, proveedor.getDireccion()));
        lisParametros.add(new Parametro(4, proveedor.getTelefono()));
        lisParametros.add(new Parametro(5, proveedor.geteMail()));
        lisParametros.add(new Parametro(6, proveedor.getRuc()));
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
    public int eliminar(Proveedor proveedor) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM Proveedor WHERE ruc=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, proveedor.getRuc()));
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
    public Proveedor obtener(String ruc) throws Exception {
        Proveedor elProveedor = null;
        String sqlC = "SELECT ruc, nombre, direccion, telefono, eMail FROM Proveedor Where ruc=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, ruc));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            while (rst.next()) {
                elProveedor = new Proveedor();
                elProveedor.setRuc(rst.getString(1));
                elProveedor.setNombre(rst.getString(2));
                elProveedor.setDireccion(rst.getString(3));
                elProveedor.setTelefono(rst.getString(4));
                elProveedor.seteMail(rst.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return elProveedor;
    }

    @Override
    public ArrayList<Proveedor> obtener() throws Exception {
        ArrayList<Proveedor> listProveedor = new ArrayList<>();
        Proveedor nProveedor = null;
        String sqlC = "Select ruc, nombre, direccion, telefono, eMail from Proveedor";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
            while (rst.next()) {
                nProveedor = new Proveedor();
                nProveedor.setRuc(rst.getString(1));
                nProveedor.setNombre(rst.getString(2));
                nProveedor.setDireccion(rst.getString(3));
                nProveedor.setTelefono(rst.getString(4));
                nProveedor.seteMail(rst.getString(5));
                listProveedor.add(nProveedor);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return listProveedor;
    }

}
