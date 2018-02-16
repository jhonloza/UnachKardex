
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
public class FrmEcategoria extends  Application{
    
    private Label titulo;
    private Label txtCodigo;
    private Label txtNombre;
    private Label txtDescripcion;
    private Image pFondo;
    private BackgroundImage fondo;
    private Image logo;
    private ImageView visorlogo;

    private TextField codigo ;
    private TextField nombre;
    private TextField descripcion;
    
    
     private Button btnEliminar;
    private Button btnLimpiar;

    private VBox pnlRucNom;
    private VBox pnlRN;
    private VBox pnlTitulo;
    private HBox pnlIcInfo;
    private VBox pnlTItProv;
    private VBox pnlIItProv;
    private HBox pnlSup;
    private HBox pnlInt;
    private HBox pnlBotones;
    private VBox pntPrincipal;
     @Override
    public void start(Stage primaryStage) {
        pFondo = new Image("file:src\\unachkardex\\multimedia\\FondoSubVentanas.jpg");
        fondo = new BackgroundImage(pFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
         //Sup izq
        titulo = new Label("\" Proveedor \"");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        txtCodigo = new Label("Codigo:");
        txtCodigo.setFont(Font.font("Berlin Sans FB Demi", 20));
        txtNombre = new Label("Nombres:");
        txtNombre.setFont(Font.font("Berlin Sans FB Demi", 20));
        pnlRucNom = new VBox(5);
        pnlRucNom.getChildren().addAll(txtCodigo, txtNombre);
        pnlRucNom.setAlignment(Pos.CENTER_RIGHT);
        txtDescripcion = new Label("Descripcion:");
        txtDescripcion.setFont(Font.font("Berlin Sans FB Demi", 20));
        
      logo = new Image("file:src\\unachkardex\\multimedia\\iconoProveedor.png");
        visorlogo = new ImageView(logo);
        visorlogo.setFitHeight(100);
        visorlogo.setFitWidth(100);
        //BOTONES A USAR
        btnEliminar = new Button("Ingresar");
        btnEliminar.setFont(Font.font("Berlin Sans FB Demi", 15));
//        btnIngresar.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                btnIngresarEventHandler(event);
//            }
//        });
      btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("Berlin Sans FB Demi", 15));
//        btnLimpiar.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                btnLimpiarEventHandler(event);
//            }
//        });
        pnlIcInfo = new HBox(10);
        pnlIcInfo.getChildren().addAll(pnlRucNom, pnlRN);
        pnlIcInfo.setAlignment(Pos.CENTER);
        pnlTitulo = new VBox(10);
        pnlTitulo.getChildren().addAll(titulo, pnlIcInfo);
        pnlTitulo.setAlignment(Pos.TOP_CENTER);
        pnlSup = new HBox(10);
        pnlSup.getChildren().addAll(pnlTitulo, visorlogo);
        pnlSup.setPadding(new Insets(10));
        pnlInt = new HBox(10);
        pnlInt.getChildren().addAll(pnlTItProv, pnlIItProv);
        pnlInt.setPadding(new Insets(10));
        pnlBotones = new HBox(10);
        pnlBotones.getChildren().addAll(btnEliminar, btnLimpiar);
        pnlBotones.setAlignment(Pos.CENTER);
        pnlBotones.setPadding(new Insets(10));
        pntPrincipal = new VBox(10);
        pntPrincipal.getChildren().addAll(pnlSup, pnlInt, pnlBotones);
        pntPrincipal.setPadding(new Insets(10));
        pntPrincipal.setBackground(new Background(fondo));
        pntPrincipal.setStyle("-fx-padding: 10; -fx-border-color: mediumblue; -fx-border-width: 2px");
  
      Scene scene=new Scene(pntPrincipal, 640, 480);
        primaryStage.setTitle("Eliminar Proveedor");
        primaryStage.setScene(scene);
        primaryStage.setMaxHeight(480);
        primaryStage.setMinHeight(480);
        primaryStage.setMaxWidth(640);
        primaryStage.setMaxWidth(640);
        primaryStage.show();  

    }
      public void btnLimpiarEventHandler(ActionEvent event) {
        codigo.setText("");
    }

    public void btnEliminarEventHandler(ActionEvent event) {
    }
    public static void main(String[] args) {
        launch(args);
    }
}