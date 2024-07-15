
package Procesos;
import AccesoDatos.*;
import Modelo.*;
import Vista.*;

public class ProFrmAct {
    public static void LimpiarEntradas(FrmAct act){
        act.txtNombre.setText("");
        act.txaDescripcion.setText("");
        act.txtFechaI.setText("");
        act.txtFechaF.setText("");
        act.cbxEmpleado.setSelectedIndex(0);
        act.txtNombre.requestFocus();
    }//fin limpiar    
    public static DTOActividades LeerAct(FrmAct act){
        DTOActividades activ =  new DTOActividades();
        activ.setNombreact(act.txtNombre.getText());
        activ.setDescripcion(act.txaDescripcion.getText());
        activ.setFecha_ini(act.txtFechaI.getText());
        activ.setFecha_fin(act.txtFechaF.getText());
        String nombre = act.cbxEmpleado.getSelectedItem().toString();
        DAOActividades dao =  new DAOActividades();
        activ.setIdemp(dao.RecuperarIdemp(nombre));
        return activ;
    }//fin leer
}
