
package Modelo;


public class DTOActividades {
    private int idact;
    private String nombreact;
    private String descripcion;
    private String fecha_ini;
    private String fecha_fin;
    private String idemp;
    private String estado;
    public DTOActividades(){}
    
    public int getIdact() {        return idact;    }
    public void setIdact(int idact) {        this.idact = idact;    }
    public String getNombreact() {        return nombreact;    }
    public void setNombreact(String nombreact) {        this.nombreact = nombreact;    }
    public String getDescripcion() {        return descripcion;   }
    public void setDescripcion(String descripcion) {        this.descripcion = descripcion;    }
    public String getFecha_ini() {        return fecha_ini;    }
    public void setFecha_ini(String fecha_ini) {        this.fecha_ini = fecha_ini;    }
    public String getFecha_fin() {        return fecha_fin;    }
    public void setFecha_fin(String fecha_fin) {        this.fecha_fin = fecha_fin;    }
    public String getIdemp() {        return idemp;    }
    public void setIdemp(String idemp) {        this.idemp = idemp;    }
    public String getEstado() {        return estado;    }
    public void setEstado(String estado) {        this.estado = estado;    }    
}
