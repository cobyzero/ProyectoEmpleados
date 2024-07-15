
package Procesos;
import Vista.*;
import Modelo.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class ProFrmEmp {
    public static void MostrarDatos(FrmEmp fe,
                                ArrayList<DTOEmpleados> Lista){
        String titulos[]={"Num","Nombre","Apellido","Puesto","Salario","Fecha Contrato"
                ,"Departamento","Libre"};
        DefaultTableModel mt = new DefaultTableModel(
                                  null,titulos);
        fe.tblDatos.setModel(mt);
        for(int i=0;i<Lista.size();i++){
           mt.addRow(Lista.get(i).Registro(i+1));
        }        
    }//fin Mostrar
    public static DTOEmpleados LeerEmp(FrmEmp fe){
        DTOEmpleados emp=new DTOEmpleados();
        emp.setIdemp(fe.txtId.getText());
        emp.setNombre(fe.txtNombre.getText());
        emp.setApellido(fe.txtApellido.getText());
        emp.setPuesto(fe.txtPuesto.getText());
        emp.setSalario(Integer.parseInt(fe.txtSalario.getText()));
        emp.setFecha_contrato(fe.txtFechaC.getText());
        emp.setDepartamento(fe.txtDepartamento.getText());
        emp.setEstado("L");
        return emp;
    }
    public static void LimpiarEntradas(FrmEmp fe){
        fe.txtId.setText("");
        fe.txtNombre.setText("");
        fe.txtApellido.setText("");
        fe.txtPuesto.setText("");
        fe.txtSalario.setText("");
        fe.txtFechaC.setText("");
        fe.txtDepartamento.setText("");        
        fe.txtId.requestFocus();
    }
    
    public static void MostrarEmp(DTOEmpleados emp,FrmEmp fe){
        fe.txtId.setText(emp.getIdemp());
        fe.txtNombre.setText(emp.getNombre());
        fe.txtApellido.setText(emp.getApellido());
        fe.txtPuesto.setText(emp.getPuesto());
        fe.txtSalario.setText(Integer.toString(emp.getSalario()));
        fe.txtFechaC.setText(emp.getFecha_contrato());
        fe.txtDepartamento.setText(emp.getDepartamento());
        fe.txtId.requestFocus();
    }
}
