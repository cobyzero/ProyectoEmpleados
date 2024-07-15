
package AccesoDatos;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Procesos.Mensajes;
import Configuracion.*;
import Modelo.DTOActividades;
import java.sql.*;

public class DAOActividades {
    public void CargarCategoriasCombo(JComboBox combo){
        try{
            Connection con =  Conexion.HacerConexion();
            Statement st =  con.createStatement();
            ResultSet rs = st.executeQuery
  ("select nombre from empleados where estado='L' order by nombre;");
            combo.removeAllItems();
            while(rs.next()){
                combo.addItem(rs.getString("nombre"));
            }//fin while             
        }catch(Exception ex){
            Mensajes.Texto("ERROR al cargar combo.."+ex);
        }
    }//fin de cargar combo
    
    //Mostrando los productos en JTable
    public void MostrarProductos(JTable tabla){
        String titulos[]={"Num","ID","Nombre","Apellido","Puesto","Salario","Fecha de contrato",
                          "Departamento"};
        DefaultTableModel mt =  new DefaultTableModel(null,titulos);
        tabla.setModel(mt);
        try{
            Connection con =  Conexion.HacerConexion();
            Statement st =  con.createStatement();
            ResultSet rs =  st.executeQuery
                    ( " select a.idact,a.nombreact,a.descripcion,a.fecha_ini,fecha_fin,e.nombre" +
                      " from empleados e,actividades a "+
                      " where e.idemp=a.idemp and a.estado='L'" +
                      " order by e.nombre");
            int num=0;
            while(rs.next()){
                num++;
                Object[] fila={num,rs.getInt(1),rs.getString(2),
                          rs.getDouble(3),rs.getInt(4),rs.getString(5)};
                mt.addRow(fila);
            }//fin while
        }catch(Exception ex){
            Mensajes.Texto("ERROR no puede mostrar productos"+ex);
        }
    }//fin mostrar
    
    //metodo que reciba un nombre de categoria y muestra su ID
    public String RecuperarIdemp(String nombre){
        String ic = "";
        try{
            Connection con =  Conexion.HacerConexion();
            PreparedStatement ps =  con.prepareStatement(
      "select idemp from empleados where nombre=?");
            ps.setString(1, nombre);
            ResultSet rs =  ps.executeQuery();
            if(rs.next()) ic = rs.getString(1); 

        }catch(Exception ex){
            Mensajes.Texto("ERROR al recuperar idemp"+ex);
        }
       
        return ic;
    }//fin recuperar
    
    //metodo que reciba un idcat y muestra el nomcat
    public String RecuperarNombre(String idemp){
        String nc = "";
        try{
            Connection con =  Conexion.HacerConexion();
            PreparedStatement ps =  con.prepareStatement(
      "select nombre from empleados where idemp=?");
            ps.setString(1, idemp);
            ResultSet rs =  ps.executeQuery();
            if(rs.next()) nc = rs.getString(1);            
        }catch(Exception ex){
            Mensajes.Texto("ERROR al recuperar idemp"+ex);
        }
        return nc;
    }//fin recuperar
    
    // metodo que inserta un producto en la tabla (DB)
    public void InsertarProd(DTOActividades act){
        try{           
            Connection con =  Conexion.HacerConexion();
            PreparedStatement ps =  con.prepareStatement(
              " insert into actividades(idact,nombreact,descripcion,fecha_ini,fecha_fin,idemp,estado)" +
              " values" +
              " (?,?,?,?,?,'L');");
            ps.setString(1,act.getNombreact());
            ps.setString(2, act.getDescripcion());
            ps.setString(3,act.getFecha_ini());
            ps.setString(3,act.getFecha_fin());
            ps.setString(4, act.getIdemp());
            ps.executeUpdate();
        }catch(Exception ex){
            Mensajes.Texto("ERROR al insertar productos.."+ex);
        }
    }//fin insertar
}
