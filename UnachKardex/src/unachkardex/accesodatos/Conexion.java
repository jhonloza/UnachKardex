package unachkardex.accesodatos;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Conexion {

    Scanner entrada = new Scanner(System.in);
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://192.168.100.15:1433;databaseName=Proyecto";
    String usuario = "kardex2018";
    String conraseña = "kardex2018";
    Connection conexion = null;

    public void conectar() {

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, conraseña);
            System.out.println("Conexion Establecida!!!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar Driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en conexion: " + e.getMessage());
        }
    }

    public ResultSet ejecutarQuery(String comandoSQL, List<Parametro> listaParametros) {
        ResultSet resultado = null;
        try {
            PreparedStatement estado = conexion.prepareStatement(comandoSQL);
            if (listaParametros != null) {
                for (Parametro valorP : listaParametros) {
                    
                    if (valorP.getValor() instanceof java.util.Date) {
                        estado.setObject(valorP.getPosicion(), new java.sql.Date(((java.util.Date) valorP.getValor()).getTime()));
                    } else {
                        estado.setObject(valorP.getPosicion(), valorP.getValor());
                    }

                }
            }
            resultado = estado.executeQuery();
        }catch (Exception e) {
            System.out.println("Error en Ejecucion SQL: " + e.getMessage());
        }
        return resultado;
    }

    public int ejecutarComando(String sql, ArrayList<Parametro> ValoresParametro) {
        int nFilasAfectadas=0;
        ResultSet resultado = null;
        try {
            PreparedStatement estado = conexion.prepareStatement(sql);
            if (ValoresParametro != null) {
                for (Parametro valorP : ValoresParametro) {
                    if (valorP.getValor() instanceof java.util.Date) {
                        estado.setObject(valorP.getPosicion(), new java.sql.Date(((java.util.Date) valorP.getValor()).getTime()));
                    } else {
                        estado.setObject(valorP.getPosicion(), valorP.getValor());
                    }
                }
            }
            nFilasAfectadas=estado.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en Ejecucion SQL: " + e.getMessage());
        }
        return nFilasAfectadas;
    }

    public void desconectar() {

        try {
            if (conexion != null) {
                if (!conexion.isClosed()) {
                    conexion.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Error de desconexion: " + e.getMessage());
        }

    }
}
