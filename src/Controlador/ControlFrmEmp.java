package Controlador;

import Vista.*;
import AccesoDatos.*;
import Modelo.DTOEmpleados; //<== agregar
import Procesos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlFrmEmp implements ActionListener {

    FrmEmp vista;
    DTOEmpleados emp;
    String idemp;

    public ControlFrmEmp(FrmEmp fe) {
        vista = fe;
        vista.btnRegistrar.addActionListener((ActionListener) this);
        vista.btnConsultar.addActionListener((ActionListener) this);
        vista.btnEliminar.addActionListener((ActionListener) this);
        vista.btnActualizar.addActionListener((ActionListener) this);
        ProFrmEmp.MostrarDatos(vista,
                DAOEmpleados.ListaEmp());
        vista.setTitle("Registro de Empleados...");
        vista.setVisible(true);
    }//fin constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRegistrar) {
            DAOEmpleados.AgregarEmp(ProFrmEmp.LeerEmp(vista));
            ProFrmEmp.MostrarDatos(vista,
                    DAOEmpleados.ListaEmp());
            ProFrmEmp.LimpiarEntradas(vista);
        }//fin agregar
        if (e.getSource() == vista.btnConsultar) {
            idemp = Mensajes.Leer("Ingrese ID a buscar..");
            emp = DAOEmpleados.BuscarEmp(idemp);
            if (emp == null) { // no existe el ID
                Mensajes.Texto("El ID " + idemp + " no existe en la tabla");
            } else {
                ProFrmEmp.MostrarEmp(emp, vista);
            }
        }//fin consultar
        if (e.getSource() == vista.btnActualizar) {
            emp = ProFrmEmp.LeerEmp(vista);
            DAOEmpleados.ActualizarEmp(emp);
            Mensajes.Texto("Registro actualizado!!");
            ProFrmEmp.MostrarDatos(vista, DAOEmpleados.ListaEmp());
            ProFrmEmp.LimpiarEntradas(vista);
        }//fin actualizar

        if (e.getSource() == vista.btnEliminar) {
            int resp = Mensajes.Preguntar("Confirmar!!!",
                    "Desea eliminar el registro con ID " + idemp + "?");
            if (resp == 0) {
                DAOEmpleados.EliminarEmp(idemp);
                Mensajes.Texto("Registro eliminado!!");
                ProFrmEmp.MostrarDatos(vista, DAOEmpleados.ListaEmp());
                ProFrmEmp.LimpiarEntradas(vista);
            }
        }//fin eliminar

    }//fin action
}
