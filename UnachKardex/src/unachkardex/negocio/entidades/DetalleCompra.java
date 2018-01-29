
package unachkardex.negocio.entidades;


public class DetalleCompra {
     private int codDetalleCompra;
    private Producto producto;
    private FacturaCompra facturaCompra;
    private int cantidad;
    private double precioTotal;

    public DetalleCompra() {
    }

    public DetalleCompra(int codDetalleCompra, Producto producto, FacturaCompra facturaCompra, int cantidad, double precioTotal) {
        this.codDetalleCompra = codDetalleCompra;
        this.producto = producto;
        this.facturaCompra = facturaCompra;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public int getCodDetalleCompra() {
        return codDetalleCompra;
    }

    public void setCodDetalleCompra(int codDetalleCompra) {
        this.codDetalleCompra = codDetalleCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public FacturaCompra getFacturaCompra() {
        return facturaCompra;
    }

    public void setFacturaCompra(FacturaCompra facturaCompra) {
        this.facturaCompra = facturaCompra;
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
