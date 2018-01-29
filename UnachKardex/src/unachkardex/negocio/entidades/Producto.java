
package unachkardex.negocio.entidades;

public class Producto {

    
    private int codProducto;
    private Categoria categoria;
    private String nombre;
    private Double precio;

    public Producto() {
    }

    public Producto(int codProducto, Categoria categoria, String nombre, Double precio) {
        this.codProducto = codProducto;
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    
}

