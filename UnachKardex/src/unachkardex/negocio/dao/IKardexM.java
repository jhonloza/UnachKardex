/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unachkardex.negocio.dao;

import java.util.ArrayList;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import java.util.*;

/**
 *
 * @author Wen
 */
public interface IKardexM {
    public ArrayList<Kardex> listadoKardexFecha(int codProducto,Date fechaini,Date fechafin) throws Exception;
              
}
