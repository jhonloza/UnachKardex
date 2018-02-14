package unachkardex.vistas;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import java.util.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.reflect.*;
import java.text.*;
import javafx.beans.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.image.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;

public class FormNFacturaCompra{
    
    private Image pFondo;
    private BackgroundImage fondo;
    private VBox pntPrincipal;
    private HBox pnlcab;
    private HBox pnlBotones;
    private HBox pnlproventa;
    private VBox pnlinfofactura;
    private VBox pntproveeedor;
    private HBox pnlruc;
    private GridPane pnldetalleprveedor;
    private Label txtruc;
    private Label txtnombre;
    private Label txtdireccion;
    private Label txtTelefono;
    private Button btnbuscrproveedor;
    private TextField ruc;
    private TextField nombre;
    private TextField direccion;
    private TextField telefono;
    private TextField email;
    private Label txtFecha;
    private Label txtcodproveedor;
    private TextField fecha;
    private TextField codproveedor;
    private Button btnlogo;

    public FormNFacturaCompra() {
        pFondo=new Image("file:src\\unachkardex\\multimedia\\FondoSubVentanas.jpg");
        fondo=new BackgroundImage(pFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        //panel proveedor
        pnlruc = new HBox(5);
        txtruc = new Label("Ruc");
        ruc = new TextField("");
        btnbuscrproveedor = new Button();
        pnlruc.getChildren().addAll(txtruc, ruc, btnbuscrproveedor);
        //info proveedor
        pnldetalleprveedor = new GridPane();
        txtnombre = new Label("Nombre");
        txtdireccion = new Label("Direccion");
        txtTelefono = new Label("Telefono");
        nombre = new TextField("");
        direccion = new TextField("");
        telefono = new TextField("");
        pnldetalleprveedor.add(txtnombre, 0, 0);
        pnldetalleprveedor.add(txtdireccion, 0, 1);
        pnldetalleprveedor.add(txtTelefono, 0, 2);
        pnldetalleprveedor.add(nombre, 1, 0);
        pnldetalleprveedor.add(direccion, 1, 1);
        pnldetalleprveedor.add(telefono, 1, 2);
        pnldetalleprveedor.setHgap(10);
        pnldetalleprveedor.setVgap(10);
        //panel proveedor
        email = new TextField("");
        pntproveeedor = new VBox(15);
        pntproveeedor.getChildren().addAll(pnlruc, pnldetalleprveedor, email);
        pntproveeedor.setPadding(new Insets(20));

        //FACTURA
        // DETALLE  FACTURA
        txtFecha = new Label("Fecha");
        fecha = new TextField("");
        txtcodproveedor = new Label("Proveedor");
        codproveedor = new TextField("");
        //logo
        btnlogo = new Button();

        pntPrincipal = new VBox(10);
        pntPrincipal.getChildren().addAll(txtruc, ruc, txtFecha, fecha, txtcodproveedor, codproveedor);
        pntPrincipal.setPadding(new Insets(10));
        pntPrincipal.setBackground(new Background(fondo));
        pntPrincipal.setStyle("-fx-padding: 10; -fx-border-color: mediumblue; -fx-border-width: 2px");
    }

    public Node getPantallaP() {
        return pntPrincipal;
    }

    public void cargarFacturacompra() {

//        IFacturaCompra facturacompraDao = new ImplFactura();
        try {
//            lstCateg = categDao.obtener();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CURSOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
