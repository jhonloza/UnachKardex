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
//@Override
//    public ArrayList<Kardex> listadoKardexProducto(int codProducto,Date fechaini,Date fechafin) throws Exception {
//        ArrayList<Kardex> lista = new ArrayList<>();
//        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        String url = "jdbc:sqlserver://localhost:1433;databaseName=Proyecto";
//        String usuario = "kardex2018";
//        String conraseña = "kardex2018";
//        Connection conexion = null;
//        ResultSet res = null;
//        Kardex nKardex=null;
//       String comandoSQL = "Select * From Kardex Where codProducto>" +String.valueOf(codProducto)+ "and codProducto<"+String.valueOf(codProducto)+"and fechaEmision between"+String.valueOf(fechaini)+"and"+String.valueOf(fechafin);
//        ArrayList<Parametro> listaParametro = new ArrayList<>();
//         Producto prod=null;
//        IProducto prodDao=new ImplProducto();
//        listaParametro.add(new Parametro(1, codProducto));
//           listaParametro.add(new Parametro(2, fechaini));
//             listaParametro.add(new Parametro(3, fechafin));
//        try {
//            Class.forName(driver);
//            conexion = DriverManager.getConnection(url, usuario, conraseña);
//            System.out.println("Conexion Establecida");
//            Statement prstd=conexion.createStatement();
//            res=prstd.executeQuery(comandoSQL);
//            while(res.next()){
//                nKardex= new Kardex();
//                prod=new Producto();
//                nKardex.setCodKardex(res.getInt(1));
//                prod=prodDao.obtener(res.getInt(2));
//                nKardex.setProducto(prod);
//                nKardex.setfechaini(res.getDate(3));
//                   nKardex.setfechafin(res.getDate(4));
//                
//                lista.add(nKardex);
//            }
//        } catch (Exception e) {
//            System.out.println("Error: "+e.getMessage());
//        }
//        return lista;
//    }

//}
//   }

