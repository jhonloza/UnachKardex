/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unachkardex.negocio.impl;
import unachkardex.accesodatos.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import java.util.*;
import java.sql.*;
/**
 *
 * @author Wen
 */
//public class ImplKardexM implements IKardexM{
//    @Override
//    public ArrayList<Kardex> listadoKardexFecha(int codFacturaCompra) throws Exception {
//        ArrayList<Kardex> lista = new ArrayList<>();
//        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        String url = "jdbc:sqlserver://localhost:1433;databaseName=Proyecto";
//        String usuario = "kardex2018";
//        String conraseña = "kardex2018";
//        Connection conexion = null;
//        ResultSet res = null;
//        Kardex nKardex=null;
//        String comandoSQL = "Select codigoFacturaCompra,fecha , proveedor From FacturaCoompra Where codigoFacturaCompra="+String.valueOf(codigoFacturaCompra);
//        ArrayList<Parametro> listaParametro = new ArrayList<>();
//        FacturaCompra facompra=null;
//        IFacturaCompra compraDao=new ImplFacturaCompra();
//        listaParametro.add(new Parametro(1, fecha));
//        try {
//            Class.forName(driver);
//            conexion = DriverManager.getConnection(url, usuario, conraseña);
//            System.out.println("Conexion Establecida");
//            Statement prstd=conexion.createStatement();
//            res=prstd.executeQuery(comandoSQL);
//            while(res.next()){
//                nKardex= new Kardex();
//                facompra=new FacturaCompra();
//                nKardex.setcodigoFacturaCompra(res.getInt(1));
//                facompra=compraDao.obtener(res.getInt(2));
//                nKardex.setProvedor(facompra);
//                nKardex.setFechaEmision(res.getDate(3));
//                lista.add(nKardex);
//            }
//        } catch (Exception e) {
//            System.out.println("Error: "+e.getMessage());
//        }
//        return lista;
//    }

//}
//    }
    

