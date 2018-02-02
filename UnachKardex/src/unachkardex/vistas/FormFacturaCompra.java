/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    private Text txtruc;
    private Text txtnombre;
    private Text txtdireccion;
    private Text txtTelefono;
    private Button btnbuscrproveedor;
    private  TextArea ruc;
    private  TextArea nombre;
    private  TextArea direccion;
    private  TextArea telefono;
    private  TextArea email;

       private VBox   pntDetafacomp;
      
          private Text txtFecha;
          private Text txtcodproveedor;
          private TextArea fecha;
          private TextArea codproveedor;
          
          
          private Button btnlogo;
    @Override
    public void start(Stage primaryStage) {
        //panel proveedor
        pnlruc=new HBox(5);
        txtruc=new Text("Ruc");
        ruc=new TextArea("");
        btnbuscrproveedor=new Button();
         pnlruc.getChildren().addAll(txtruc,ruc,btnbuscrproveedor);
        //info proveedor
        pnldetalleprveedor= new GridPane();
        txtnombre=new Text("Nombre");
        txtdireccion= new Text("Direccion");
        txtTelefono= new Text("Telefono");
        nombre=new TextArea("");
        direccion=new TextArea("");
        telefono=new TextArea("");
        pnldetalleprveedor.add(txtnombre, 0, 0);
        pnldetalleprveedor.add(txtdireccion, 0, 1);
        pnldetalleprveedor.add(txtTelefono, 0, 2);
        pnldetalleprveedor.add(nombre, 1, 0);
        pnldetalleprveedor.add(direccion, 1, 1);
        pnldetalleprveedor.add(telefono, 1, 2);
        pnldetalleprveedor.setHgap(10);
        pnldetalleprveedor.setVgap(10);
        //panel proveedor
        email=new TextArea("");
        pntproveeedor=new VBox(15);
        pntproveeedor.getChildren().addAll(pnlruc,pnldetalleprveedor,email);
        pntproveeedor.setPadding(new Insets(20));
        
        //FACTURA
        // DETALLE  FACTURA
        txtFecha=new Text("Fecha");
        fecha=new TextArea("");
        txtcodproveedor=new Text("Proveedor");
        codproveedor=new TextArea("");
        //logo
        btnlogo=new Button();
        //
                
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
