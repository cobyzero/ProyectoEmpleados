
package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import AccesoDatos.*;
import Procesos.*;

public class ControlFrmAct implements ActionListener{
    FrmAct vista;
    DAOActividades dao;
    public ControlFrmAct(FrmAct act){
      vista=act;
      vista.btnRegistrar.addActionListener((ActionListener) this);
      dao = new DAOActividades();
      dao.MostrarProductos(vista.tblDatos);
      dao.CargarCategoriasCombo(vista.cbxEmpleado);
    }//fin constructor
@Override    
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==vista.btnRegistrar){
           DTOActividades actv = ProFrmAct.LeerAct(vista);
           dao = new DAOActividades();
           dao.InsertarProd(actv);
           Mensajes.Texto("Actividad Registrada");
           ProFrmAct.LimpiarEntradas(vista);
           dao.MostrarProductos(vista.tblDatos);
       } //fin registrar 
    }//fin del action 
}
