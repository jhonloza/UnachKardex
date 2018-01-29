package unachkardex.negocio.entidades;

public class DetalleVenta {
    private int codDetalleVenta;
    private Producto producto;
    private FacturaVenta facturaVenta;
    private int cantidad;
    private double precioTotal;

    public DetalleVenta(int codDetalleVenta, Producto producto, FacturaVenta facturaVenta, int cantidad, double precioTotal) {
        this.codDetalleVenta = codDetalleVenta;
        this.producto = producto;
        this.facturaVenta = facturaVenta;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public DetalleVenta() {
    }

    public int getCodDetalleVenta() {
        return codDetalleVenta;
    }

    public void setCodDetalleVenta(int codDetalleVenta) {
        this.codDetalleVenta = codDetalleVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public FacturaVenta getFacturaVenta() {
        return facturaVenta;
    }

    public void setFacturaVenta(FacturaVenta facturaVenta) {
        this.facturaVenta = facturaVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    
}
