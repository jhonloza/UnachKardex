
package unachkardex.negocio.entidades;

import java.util.*;

public class FacturaVenta {
    
    private int codFacturaVenta;
    private Date fecha;
    private Cliente cliente;

    public FacturaVenta() {
    }

    public FacturaVenta(int codFacturaVenta, Date fecha, Cliente cliente) {
        this.codFacturaVenta = codFacturaVenta;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public int getCodFacturaVenta() {
        return codFacturaVenta;
    }

    public void setCodFacturaVenta(int codFacturaVenta) {
        this.codFacturaVenta = codFacturaVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   
    
    
    
    
}
