package unachkardex.negocio.entidades;

public class Categoria {

    private int codCategoria;
    private String nombre;
    private String descripcion;

    public Categoria(int codCategoria, String nombre, String descripcion) {
        this.codCategoria = codCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Categoria() {
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override

    public String toString() {
        return nombre;
    }

}
