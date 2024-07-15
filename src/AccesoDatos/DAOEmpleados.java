package AccesoDatos;

import Configuracion.*;
import Modelo.*;
import Procesos.*;
import java.util.*;
import java.sql.*;

public class DAOEmpleados {

    public static void AgregarEmp(DTOEmpleados emp) {
        try {
            Connection con = Conexion.HacerConexion();
            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(
                    "insert into empleados values(?,?,?,?,?,?,?,?)");
            ps.setString(1, null);
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getApellido());
            ps.setString(4, emp.getPuesto());
            ps.setInt(5, emp.getSalario());
            ps.setString(6, emp.getFecha_contrato());
            ps.setString(7, emp.getDepartamento());
            ps.setString(8, emp.getEstado());

            ps.executeUpdate();
        } catch (Exception ex) {
            Mensajes.Texto("No se puede insertar empleado" + ex);
        }
    }//fin de agregar

    public static ArrayList<DTOEmpleados> ListaEmp() {
        ArrayList<DTOEmpleados> Lista = new ArrayList();
        try {
            Connection con = Conexion.HacerConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "select * from empleados where estado='L' order by 2");
            while (rs.next()) {
                DTOEmpleados emp = new DTOEmpleados();
                emp.setIdemp(rs.getString(1));
                emp.setNombre(rs.getString(2));
                emp.setApellido(rs.getString(3));
                emp.setPuesto(rs.getString(4));
                emp.setSalario(rs.getInt(5));
                emp.setFecha_contrato(rs.getString(6));
                emp.setDepartamento(rs.getString(7));
                emp.setEstado(rs.getString(8));
                Lista.add(emp);
            }
        } catch (Exception ex) {
            Mensajes.Texto("No se puede recuperar las categorias" + ex);
        }
        return Lista;
    }//fin de ListaCat  

    //metodo que consulta una categoria por su ID
    public static DTOEmpleados BuscarEmp(String id) {
        DTOEmpleados emp = null;
        try {
            Connection con = Conexion.HacerConexion();
            PreparedStatement ps = con.prepareStatement(
                    "select * from empleados where id=?");
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                emp = new DTOEmpleados();
                emp.setIdemp(rs.getString(1));
                emp.setNombre(rs.getString(2));
                emp.setApellido(rs.getString(3));
                emp.setPuesto(rs.getString(4));
                emp.setSalario(rs.getInt(5));
                emp.setFecha_contrato(rs.getString(6));
                emp.setDepartamento(rs.getString(7));
                emp.setEstado(rs.getString(8));
            }
        } catch (Exception ex) {
            Mensajes.Texto("ERROR no se puede buscar cat.." + ex);
        }
        return emp;
    }//fin consulta por ID

    public static void ActualizarEmp(DTOEmpleados emp) {
        try {
            Connection con = Conexion.HacerConexion();
            PreparedStatement ps = con.prepareStatement(
                    "update empleados set nombre=?,apellido=?,puesto=?,salario=?,fecha_contratacion=?,departamento=?,estado=? where id=?;");
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getApellido());
            ps.setString(3, emp.getPuesto());
            ps.setInt(4, emp.getSalario());
            ps.setString(5, emp.getFecha_contrato());
            ps.setString(6, emp.getDepartamento());
            ps.setString(7, emp.getEstado());
            ps.setInt(8, Integer.parseInt(emp.getIdemp()));
            ps.executeUpdate();
        } catch (Exception ex) {
            Mensajes.Texto("ERROR no se puede actualizar emp.." + ex);
        }
    }//fin actualizar

    public static void EliminarEmp(String id) {
        try {
            Connection con = Conexion.HacerConexion();
            PreparedStatement ps = con.prepareStatement(
                    "update empleados set estado='L' where id=?");
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();
        } catch (Exception ex) {
            Mensajes.Texto("ERROR no se puede eliminar emp.." + ex);
        }
    }//fin eliminar
}
