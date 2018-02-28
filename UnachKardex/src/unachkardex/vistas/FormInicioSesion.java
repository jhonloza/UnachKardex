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
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;
import javafx.scene.image.*;

public class FormInicioSesion extends Application {

    //Presentacion
    private Image pFondo;
    private BackgroundImage fondo;
    private Label titulo;
    private Image icono;
    private ImageView visor;
    private VBox pnlPresentacion;
    //Parametros

    private Label txtNombre;
    private Label txtCodigo;

    private TextField nombre;
    private TextField codigo;

    private GridPane pnlC1;
    private GridPane pnlC2;
    private VBox pnlCampos;
    //Prensetacion y Parametros
    private HBox catParaImg;
    //Botones
    private Button btnAccion;
    private Button btnLimpiar;
    private HBox pnlbotones;
    //Pantalla Principal
    private VBox pntPrincipal;

    private String[] IniciosSesionU = {"administrador", "sebas", "wendy", "andres", "david"};
    private String[] IniciosSesionP = {"userpassword", "sebas1", "wendy1", "andres1", "david1"};

    public void start(Stage primaryStage) {
        pFondo = new Image("file:src\\unachkardex\\multimedia\\FondoSubVentanas.jpg");
        fondo = new BackgroundImage(pFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        //Presentacion
        icono = new Image("file:src\\unachkardex\\multimedia\\iconoProveedor.png");
        visor = new ImageView(icono);
        visor.setFitHeight(100);
        visor.setFitWidth(100);
        titulo = new Label("INICIO DE SESION");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 30));
      //  titulo.setAlignment(Pos.TOP_CENTER);
        
        pnlPresentacion = new VBox(10);
        pnlPresentacion.getChildren().addAll(visor);
        pnlPresentacion.setAlignment(Pos.CENTER);
        pnlPresentacion.setPadding(new Insets(10));
        //parametros
        txtCodigo = new Label("USUARIO:        ");
        txtCodigo.setFont(Font.font("Berlin Sans FB Demi", 20));
        txtNombre = new Label("CONTRASEÑA:      ");
        txtNombre.setFont(Font.font("Berlin Sans FB Demi", 20));
        codigo = new TextField();
        //  codigo.setText(String.valueOf(cargarCateg()+1));
        nombre = new TextField();
        pnlC1 = new GridPane();
        pnlC1.setHgap(20);
        pnlC1.setVgap(20);
        pnlC1.add(titulo, 0, 1);
        pnlC1.add(txtCodigo, 0, 2);
        pnlC1.add(codigo, 0, 3);
        pnlC1.add(txtNombre, 0, 4);
        pnlC1.add(nombre, 0, 5);
        pnlC1.setAlignment(Pos.CENTER);
       
        pnlCampos = new VBox(15);
        pnlCampos.getChildren().addAll(pnlC1);
        pnlCampos.setAlignment(Pos.CENTER);
        //Categoria Parametros e Imagen
        catParaImg = new HBox(10);
        catParaImg.getChildren().addAll(pnlPresentacion, pnlCampos);
        catParaImg.setAlignment(Pos.CENTER);
        //Barra de botones
        btnAccion = new Button("Ingresar");
        btnAccion.setFont(Font.font("Berlin Sans FB Demi", 20));
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("Berlin Sans FB Demi", 20));
        pnlbotones = new HBox(25);
        pnlbotones.getChildren().addAll(btnAccion, btnLimpiar);
        pnlbotones.setAlignment(Pos.CENTER);
        //Ventana principal
        pntPrincipal = new VBox(10);
        pntPrincipal.getChildren().addAll(catParaImg, pnlbotones);
        pntPrincipal.setPadding(new Insets(10));
        pntPrincipal.setBackground(new Background(fondo));
        pntPrincipal.setStyle("-fx-padding: 10; -fx-border-color: mediumblue; -fx-border-width: 2px");
        Scene scene = new Scene(pntPrincipal, 640, 480);
        primaryStage.setTitle("INICIO DE SESION");
        primaryStage.setScene(scene);
        primaryStage.setMaxHeight(480);
        primaryStage.setMinHeight(480);
        primaryStage.setMaxWidth(640);
        primaryStage.setMaxWidth(640);
        primaryStage.show();

        //Acciones Botones
//        btnAccion.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                bIngresarEventHandler(event);
//            }
//        });
//        btnLimpiar.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                btnLimpiarEventHandler(event);
//            }
//        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
