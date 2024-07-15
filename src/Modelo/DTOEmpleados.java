
package Modelo;
public class DTOEmpleados {
    private String idemp;
    private String nombre;
    private String apellido;
    private String puesto;
    private int salario;
    private String departamento;
    private String fecha_contrato;
    private String estado;
    public DTOEmpleados(){}
    public Object[] Registro(int num){
       Object[] fila={idemp,nombre,apellido,puesto,salario,departamento,fecha_contrato,estado};
       return fila;
    }
    //getter y setter
    public String getNombre() {        return nombre;    }
    public void setNombre(String nombre) {        this.nombre = nombre;    }
    public String getApellido() {        return apellido;    }
    public void setApellido(String apellido) {        this.apellido = apellido;    }
    public String getPuesto() {        return puesto;   }
    public void setPuesto(String puesto) {        this.puesto = puesto;    }
    public int getSalario() {       return salario;   }
    public void setSalario(int salario) {       this.salario = salario;   }
    public String getDepartamento() {       return departamento;   }
    public void setDepartamento(String departamento) {        this.departamento = departamento;   }
    public String getFecha_contrato() {       return fecha_contrato;   }
    public void setFecha_contrato(String fecha_contrato) {       this.fecha_contrato = fecha_contrato;    }    
    public String getEstado() {        return estado;    }
    public void setEstado(String estado) {        this.estado = estado;    }
    public String getIdemp() {        return idemp;    }
    public void setIdemp(String idemp) {        this.idemp = idemp;    }
    
}
