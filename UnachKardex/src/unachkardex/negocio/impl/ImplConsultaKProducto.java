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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ImplConsultaKProducto implements IConsultaKProducto {
   @Override
   public ArrayList<Integer > obtener(int codProducto) throws Exception{
       ArrayList<Integer > lista=new ArrayList<>();
        String sql= "select existencia from Kardex where codProducto=?";
        ArrayList<Parametro> lstparametros=new ArrayList<>();
        lstparametros.add(new Parametro(1, codProducto));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstparametros);            
            while (rst.next()) {
              int var=rst.getInt(1);
              lista.add(var);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }
       
   }

