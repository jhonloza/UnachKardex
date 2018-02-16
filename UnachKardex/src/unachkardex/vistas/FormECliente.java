/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


    public class FormECliente  extends Application {
        
    private TextField txtCedula;
    private Label txtNombres;
    private Label txtApellidos;
    private Label txtFechaNacimiento;
    private Label txtDireccion;
    private Label txtTelefono;
    private Label txtEmail;
    
    private Image pFondo;
    private BackgroundImage fondo;
    private Image logo;
    private ImageView visorlogo;
    
    private Label cedula;
    private Label nombres;
    private Label apellidos;
    private Label fechaNacimiento;
    private Label direccion;
    private Label telefono;
    private Label email;
    
    private Button btnEliminar;
    private Button btnLimpiar;
    
    private HBox pnlced;
    private GridPane pnlNombApe;
    private GridPane pnlFechDir;
    private GridPane pnlcontacto;
    private HBox pnlBotones;
    private VBox pntPrincipal;
    private VBox pnlTItClient;
    private VBox pnlIItClient;
    
    @Override
    public void  start (Stage primaryStage) throws Exception {
        pFondo=new Image("file:src\\unachkardex\\multimedia\\FondoSubVentanas.jpg");
        fondo=new BackgroundImage(pFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        //LABELS DE LOS CAMPOS A USAR
        
        txtCedula = new TextField("Cedula: ");
        txtCedula.setFont(Font.font("Berlin Sans FB Demi", 20));
        //txtCedula.setFill(Color.DARKBLUE);
        txtNombres = new Label("Nombres: ");
        txtNombres.setFont(Font.font("Berlin Sans FB Demi", 20));
        //txtNombres.setFill(Color.DARKBLUE);
        txtApellidos = new Label("Apellidos: ");
        txtApellidos.setFont(Font.font("Berlin Sans FB Demi", 20));
        //txtApellidos.setFill(Color.DARKBLUE);
        txtFechaNacimiento = new Label("Fecha de Nacimiento: ");
        txtFechaNacimiento.setFont(Font.font("Berlin Sans FB Demi", 20));
        //txtFechaNacimiento.setFill(Color.DARKBLUE);
        txtDireccion = new Label("Direccion: ");
        txtDireccion.setFont(Font.font("Berlin Sans FB Demi", 20));
        //txtDireccion.setFill(Color.DARKBLUE);
        txtTelefono = new Label("Telefono: ");
        txtTelefono.setFont(Font.font("Berlin Sans FB Demi", 20));
        //txtTelefono.setFill(Color.DARKBLUE);
        txtEmail = new Label("E-mail: ");
        txtEmail.setFont(Font.font("Berlin Sans FB Demi", 20));
        //txtEmail.setFill(Color.DARKBLUE);
       pnlTItClient = new VBox(10);
       pnlTItClient.getChildren().addAll(txtCedula,txtNombres,txtApellidos,txtFechaNacimiento,txtDireccion, txtTelefono, txtEmail);
       pnlTItClient.setAlignment(Pos.CENTER_RIGHT);
        
        //CAJAS DE TEXTO PARA CAMPOS
        cedula = new Label("");
        nombres.setMaxSize(150, 25);
        nombres.setMinSize(150, 25);
        nombres.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        apellidos = new Label("");
        apellidos.setMaxSize(150, 25);
        apellidos.setMinSize(150, 25);
        fechaNacimiento = new Label("");
        direccion = new Label("");
        direccion.setMaxSize(150, 25);
        direccion.setMinSize(150, 25);
        direccion.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        telefono = new Label("");
        telefono= new Label ("");
        telefono.setMaxSize(150, 25);
        telefono.setMinSize(150, 25);
        telefono.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        email = new Label("");
        email = new Label("");
        email.setMaxSize(150, 25);
        email.setMinSize(150, 25);
        email.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        pnlIItClient = new VBox(10);
        pnlIItClient.getChildren().addAll(direccion, telefono, email);
        pnlIItClient.setAlignment(Pos.CENTER);
//BOTONES A USAR
        btnEliminar = new Button("Eliminar");
        btnEliminar.setFont(Font.font("Berlin Sans FB Demi", 20));
        btnEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
           public void handle(ActionEvent event) {
                btnEliminarEventHandler(event);
            }
        });
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("Berlin Sans FB Demi", 20));
        btnLimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnLimpiarEventHandler(event);
            }
        });
//INGRESO EN PANELES
        //SUPERIOR
        pnlced = new HBox(20);
        pnlced.getChildren().addAll(txtCedula, cedula);
        //nombre
        pnlNombApe = new GridPane();
        pnlNombApe.setHgap(20);
        pnlNombApe.setVgap(20);
        pnlNombApe.add(txtNombres, 0, 0);
        pnlNombApe.add(nombres, 1, 0);
        pnlNombApe.add(txtApellidos, 2, 0);
        pnlNombApe.add(apellidos, 3, 0);
        //fecha y direccion
        pnlFechDir = new GridPane();
        pnlFechDir.setHgap(20);
        pnlFechDir.setVgap(10);
        pnlFechDir.add(txtFechaNacimiento, 0, 0);
        pnlFechDir.add(fechaNacimiento, 1, 0);
        pnlFechDir.add(txtDireccion, 0, 1);
        pnlFechDir.add(direccion, 1, 1);
        //Contacto        
        pnlcontacto = new GridPane();
        pnlcontacto.setHgap(20);
        pnlcontacto.setVgap(20);
        pnlcontacto.add(txtTelefono, 0, 0);
        pnlcontacto.add(telefono, 1, 0);
        pnlcontacto.add(txtEmail, 2, 0);
        pnlcontacto.add(email, 3, 0);
        //botones
        pnlBotones = new HBox(20);
        pnlBotones.getChildren().addAll(btnEliminar, btnLimpiar);
        pnlBotones.setAlignment(Pos.CENTER);
        //final
        pntPrincipal = new VBox(10);
        logo = new Image("file:src\\unachkardex\\multimedia\\logo.jpg");
        visorlogo = new ImageView();
        visorlogo.setImage(logo);
        visorlogo.setFitHeight(200);
        visorlogo.setPreserveRatio(true);
        pntPrincipal.getChildren().addAll(visorlogo, pnlced, pnlNombApe, pnlFechDir, pnlcontacto, pnlBotones);
        pntPrincipal.setAlignment(Pos.CENTER);
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
        cedula.setText("");
    }

    public void btnEliminarEventHandler(ActionEvent event) {
    }

public static void main(String[] args) {
        launch(args);
    }
    }

