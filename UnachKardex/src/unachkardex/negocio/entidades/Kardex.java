package unachkardex.negocio.entidades;
import java.util.*;
public class Kardex {
    private int codKardex;
    private Producto producto;
    private Date fechaEmision;
    private String tipoTransaccion;
    private int existencias;
    private double valorTotal;

    public Kardex() {
    }

    public Kardex(int codKardex, Producto producto, Date fechaEmision, String tipoTransaccion, int existencias, double valorTotal) {
        this.codKardex = codKardex;
        this.producto = producto;
        this.fechaEmision = fechaEmision;
        this.tipoTransaccion = tipoTransaccion;
        this.existencias = existencias;
        this.valorTotal = valorTotal;
    }

    public int getCodKardex() {
        return codKardex;
    }

    public void setCodKardex(int codKardex) {
        this.codKardex = codKardex;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
