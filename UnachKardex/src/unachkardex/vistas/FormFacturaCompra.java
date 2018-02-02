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
import unachkardex.negocio.impl.ImplCategoria;
public class FormFacturaCompra extends Application{
     private Text txtCodigo;
    private Text txtFacturaCompra;
    
    private Text txtNombre;
    private Text txtPrecio;
    
    private TextArea codigo;
    private TextArea nombre;
    
    private TextArea precio;
    private TextArea descrFactutacompra;
    
    private ComboBox<FacturaCompra> listFacturacompra;
    
    ObservableList<FacturaCompra> lstFacturaCompra;
    
    
    private Button btnAceptar;
    private Button btnModificar;
    private Button btnEliminar;
    private Button btnLimpiar;
    private Button btnCancelar;
    
        private VBox pnlProducto;
    private VBox pnlFacturacompra;
    private GridPane pnlCentral;
    private GridPane pnlBotones;
    private GridPane pnlPrincipal;
     @Override
    public void start(Stage primaryStage) {
        txtCodigo=new Text("Codigo");
        txtCodigo.setFont(javafx.scene.text.Font.font("Arial Black",20));
        codigo=new TextArea("");
        txtNombre=new Text("Nombre");
        txtNombre.setFont(javafx.scene.text.Font.font("Arial Black",20));
        nombre=new TextArea("");
        txtPrecio=new Text("Precio");
        txtPrecio.setFont(javafx.scene.text.Font.font("Arial Black",20));
        precio=new TextArea("");
        
        txtFacturaCompra=new Text("factura_compra");
        txtFacturaCompra.setFont(javafx.scene.text.Font.font("Arial Black",20));
        cargarFacturacompra();
        listFacturacompra=new ComboBox<FacturaCompra>();
        listFacturacompra.setItems(lstFacturaCompra);
        descrFactutacompra=new TextArea("");
        
        btnAceptar=new Button("Aceptar");
        btnAceptar.setFont(Font.font("Arial Black",20));
        btnModificar=new Button("Modificar");
        btnModificar.setFont(Font.font("Arial Black",20));
        btnEliminar=new Button("Eliminar");
        btnEliminar.setFont(Font.font("Arial Black",20));
        btnLimpiar=new Button("Limpiar");
        btnLimpiar.setFont(Font.font("Arial Black",20));
        btnCancelar=new Button("Cancelar");
        btnCancelar.setFont(Font.font("Arial Black",20));
        
        pnlProducto=new VBox();
        pnlProducto.getChildren().add(txtCodigo);
        pnlProducto.getChildren().add(codigo);
        pnlProducto.getChildren().add(txtNombre);
        pnlProducto.getChildren().add(nombre);
        pnlProducto.getChildren().add(txtPrecio);
        pnlProducto.getChildren().add(precio);
        
        pnlFacturacompra=new VBox();
        pnlFacturacompra.getChildren().add(txtFacturaCompra);
        pnlFacturacompra.getChildren().add(listFacturacompra);
        pnlFacturacompra.getChildren().add(descrFactutacompra);
        
        pnlCentral=new GridPane();
        pnlCentral.setVgap(10);
        pnlCentral.setHgap(10);
        pnlCentral.add(pnlProducto, 0, 0);
        pnlCentral.add(pnlFacturacompra, 1, 0);
        

        pnlBotones= new GridPane();
        pnlBotones.setVgap(10);
        pnlBotones.setHgap(10);
        pnlBotones.add(btnAceptar, 0, 0);
        pnlBotones.add(btnLimpiar, 1, 0);
        pnlBotones.add(btnCancelar, 2, 0);
        pnlBotones.setAlignment(Pos.CENTER);
        
        pnlPrincipal=new GridPane();
        pnlPrincipal.setVgap(10);
        pnlPrincipal.setHgap(10);
        pnlPrincipal.add(pnlCentral, 0, 0);
        pnlPrincipal.add(pnlBotones, 0, 1);
        pnlPrincipal.setPadding(new Insets(25));
        
        Scene scene = new Scene(pnlPrincipal, 600, 400);
        primaryStage.setTitle("Producto");
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