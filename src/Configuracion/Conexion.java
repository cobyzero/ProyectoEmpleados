
package Configuracion;
import java.sql.*;
import Procesos.*;

public class Conexion implements Parametros{
    public static Connection HacerConexion(){
        Connection con=null;
        try{
            Class.forName(DRIVER);
con = DriverManager.getConnection(URL, USER, CLAVE);
        }catch(Exception ex){
            Mensajes.Texto("No se puede conectar a la BD..");
        }        
        return con;
    }//fin hacer conexion
}
