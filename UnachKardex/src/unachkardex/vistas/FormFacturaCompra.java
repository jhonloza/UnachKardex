
package unachkardex.vistas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.*;

import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.reflect.Field;

import java.text.DateFormat;
import java.text.MessageFormat;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import unachkardex.negocio.dao.ICategoria;
import unachkardex.negocio.entidades.Categoria;
import unachkardex.negocio.entidades.FacturaCompra;
import unachkardex.negocio.entidades.Proveedor;
import unachkardex.negocio.impl.ImplCategoria;

public class FormFacturaCompra extends Application {

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
    private  TextField ruc;
    private  TextField nombre;
    private  TextField direccion;
    private  TextField telefono;
    private  TextField email;

       private VBox   pntDetafacomp;
      
          private Label txtFecha;
          private Label txtcodproveedor;
          private TextField fecha;
          private TextField codproveedor;
          
          
          private Button btnlogo;
    @Override
    public void start(Stage primaryStage) {
        //panel proveedor
        pnlruc=new HBox(5);
        txtruc=new Label("Ruc");
        ruc=new TextField("");
        btnbuscrproveedor=new Button();
         pnlruc.getChildren().addAll(txtruc,ruc,btnbuscrproveedor);
        //info proveedor
        pnldetalleprveedor= new GridPane();
        txtnombre=new Label("Nombre");
        txtdireccion= new Label("Direccion");
        txtTelefono= new Label("Telefono");
        nombre=new TextField("");
        direccion=new TextField("");
        telefono=new TextField("");
        pnldetalleprveedor.add(txtnombre, 0, 0);
        pnldetalleprveedor.add(txtdireccion, 0, 1);
        pnldetalleprveedor.add(txtTelefono, 0, 2);
        pnldetalleprveedor.add(nombre, 1, 0);
        pnldetalleprveedor.add(direccion, 1, 1);
        pnldetalleprveedor.add(telefono, 1, 2);
        pnldetalleprveedor.setHgap(10);
        pnldetalleprveedor.setVgap(10);
        //panel proveedor
        email=new TextField("");
        pntproveeedor=new VBox(15);
        pntproveeedor.getChildren().addAll(pnlruc,pnldetalleprveedor,email);
        pntproveeedor.setPadding(new Insets(20));
        
        //FACTURA
        // DETALLE  FACTURA
        txtFecha=new Label("Fecha");
        fecha=new TextField("");
        txtcodproveedor=new Label("Proveedor");
        codproveedor=new TextField("");
        //logo
        btnlogo=new Button();
        
                
        pntDetafacomp= new VBox(10);
         pntDetafacomp.getChildren().addAll(txtruc,ruc,txtFecha,fecha,txtcodproveedor,codproveedor);
       
        
       
        
        Scene scene=new Scene(pntDetafacomp, 480, 240);
        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
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
