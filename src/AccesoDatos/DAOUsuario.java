package AccesoDatos;

import Modelo.DTOUsuario;
import javax.swing.JOptionPane;
import java.sql.*;
import Configuracion.Conexion;

public class DAOUsuario {

    public DTOUsuario Login(String usuario, String contrasena) {

        try {
            var connection = Conexion.HacerConexion();
            var sql = "SELECT * FROM login WHERE username=? AND passwordd=?";

            var sf = connection.prepareStatement(sql);

            sf.setString(1, usuario);
            sf.setString(2, contrasena);

            var query = sf.executeQuery();

            while (query.next()) {
                var us = new DTOUsuario(
                        query.getString("username"),
                        query.getString("passwordd")
                );
                JOptionPane.showMessageDialog(null, "Autenticado correctamente");
                return us;
            }
            JOptionPane.showMessageDialog(null, "Usuario incorrecto");

            return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");

            return null;
        }

    }
}
