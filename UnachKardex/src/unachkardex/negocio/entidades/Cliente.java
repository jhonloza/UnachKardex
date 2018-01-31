package unachkardex.negocio.entidades;

import java.util.Date;

public class Cliente {
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    
    private String eMail;
    private Date fechaNac;

    public Cliente() {
    }

    public Cliente(String cedula, String nombre, String apellido, String direccion, String telefono, String eMail, Date fechaNac) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        
        this.direccion = direccion;
        this.telefono = telefono;
        this.eMail = eMail;
        this.fechaNac = fechaNac;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }   
    
    @Override
    public String toString() {
        return nombre; 
    }
    
}
