package unachkardex.negocio.entidades;

public class Proveedor {

    private String ruc;
    private String nombre;
    private String direccion;
    private String telefono;
    private String eMail;
    public Proveedor() {
        
    }

    public Proveedor(String ruc, String nombre, String direccion, String telefono, String eMail) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.eMail = eMail;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
}
