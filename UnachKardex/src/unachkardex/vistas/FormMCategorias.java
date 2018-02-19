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

public class FormMCategorias extends Application {

    //Presentacion
    private Image pFondo;
    private BackgroundImage fondo;
    private Label titulo;
    private Image icono;
    private ImageView visor;
    private VBox pnlPresentacion;
    //Parametros
    private Label txtCodigo;
    private Label txtNombre;
    private Label txtDescripcion;
    private TextField codigo;
    private TextField nombre;
    private TextField descripcion;
    private ArrayList<Categoria> listaCategorias;
    private HBox pnlC1;
    private HBox pnlC2;
    private HBox pnlC3;
    private VBox pnlCampos;
    //Prensetacion y Parametros
    private HBox catParaImg;
    //Botones
    private Button btnModificar;
    private Button btnLimpiar;
    private Button btnBuscar;
    private HBox pnlbotones;
    //Pantalla Principal
    private VBox pntPrincipal;

    private Categoria cate;

    @Override
    public void start(Stage primaryStage) {
        //public FormECategorias() {

        pFondo = new Image("file:src\\unachkardex\\multimedia\\FondoSubVentanas.jpg");
        fondo = new BackgroundImage(pFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        //Presentacion
        icono = new Image("file:src\\unachkardex\\multimedia\\iconoProveedor.png");
        visor = new ImageView(icono);
        visor.setFitHeight(100);
        visor.setFitWidth(100);
        titulo = new Label("CATEGORIA");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        pnlPresentacion = new VBox(10);
        pnlPresentacion.getChildren().addAll(titulo, visor);
        pnlPresentacion.setAlignment(Pos.CENTER);
        pnlPresentacion.setPadding(new Insets(10));
        //parametros
        txtCodigo = new Label("Codigo:        ");
        txtCodigo.setFont(Font.font("Berlin Sans FB Demi", 20));
        txtNombre = new Label("Nombre:      ");
        txtNombre.setFont(Font.font("Berlin Sans FB Demi", 20));
        txtDescripcion = new Label("Descripcion: ");
        txtDescripcion.setFont(Font.font("Berlin Sans FB Demi", 20));
        codigo = new TextField();
        //codigo.setText(String.valueOf(cargarCateg()1));
        nombre = new TextField();
        descripcion = new TextField();
        pnlC1 = new HBox(5);
        pnlC1.getChildren().addAll(txtCodigo, codigo);
        pnlC1.setAlignment(Pos.CENTER);
        pnlC2 = new HBox(5);
        pnlC2.getChildren().addAll(txtNombre, nombre);
        pnlC2.setAlignment(Pos.CENTER);
        pnlC3 = new HBox(5);
        pnlC3.getChildren().addAll(txtDescripcion, descripcion);
        pnlC3.setAlignment(Pos.CENTER);
        pnlCampos = new VBox(15);
        pnlCampos.getChildren().addAll(pnlC1, pnlC2, pnlC3);
        pnlCampos.setAlignment(Pos.CENTER);
        //Categoria Parametros e Imagen
        catParaImg = new HBox(10);
        catParaImg.getChildren().addAll(pnlPresentacion, pnlCampos);
        catParaImg.setAlignment(Pos.CENTER);
        //Barra de botones
        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(Font.font("Berlin Sans FB Demi", 20));
        btnModificar = new Button("Modificar");
        btnModificar.setFont(Font.font("Berlin Sans FB Demi", 20));
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("Berlin Sans FB Demi", 20));
        pnlbotones = new HBox(25);
        pnlbotones.getChildren().addAll(btnBuscar, btnModificar, btnLimpiar);
        pnlbotones.setAlignment(Pos.CENTER);
        //Ventana principal
        pntPrincipal = new VBox(10);
        pntPrincipal.getChildren().addAll(catParaImg, pnlbotones);
        pntPrincipal.setPadding(new Insets(10));
        pntPrincipal.setBackground(new Background(fondo));
        pntPrincipal.setStyle("-fx-padding: 10; -fx-border-color: mediumblue; -fx-border-width: 2px");

        Scene scene = new Scene(pntPrincipal, 640, 480);
        primaryStage.setTitle("Eliminar Proveedor");
        primaryStage.setScene(scene);
        primaryStage.setMaxHeight(480);
        primaryStage.setMinHeight(480);
        primaryStage.setMaxWidth(640);
        primaryStage.setMaxWidth(640);
        primaryStage.show();
        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnBuscarEventHandler(event);
            }
        });

        btnLimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnLimpiarEventHandler(event);
            }
        });

        btnModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnModificarEventHandler(event);
            }
        });

    }

    public void btnLimpiarEventHandler(ActionEvent event) {
        codigo.setText("");
        nombre.setText("");
        descripcion.setText("");
    }

    public void btnModificarEventHandler(ActionEvent event) {
        ICategoria catDao = new ImplCategoria();
        try {
            cate.setNombre(nombre.getText());
            cate.setDescripcion(descripcion.getText());

            if (catDao.modificar(cate) > 0) {
                Alert alerta=new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("INFORMACION DEL SISTEMA");
                alerta.setHeaderText(null);
                alerta.setContentText("Modificacion Correcto!!");
                alerta.showAndWait();
            } else {
                Alert alerta=new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("INFORMACION DEL SISTEMA");
                alerta.setHeaderText(null);
                alerta.setContentText("Modificacion Fallido!! ");
                alerta.showAndWait();
            }

        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("No se pudo Modificar: " + e.getMessage());
            alerta.showAndWait();
        }
    }

    public void btnBuscarEventHandler(ActionEvent event) {
        ICategoria catDao = new ImplCategoria();
        cate = new Categoria();
        try {
            cate = catDao.obtener(Integer.parseInt(codigo.getText()));
            nombre.setText(cate.getNombre());
            descripcion.setText(cate.getDescripcion());

        } catch (Exception e) {

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("No se encontro Registros: " + e.getMessage());
            alerta.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

//    public Node getPntPrincipal() {
//        return pntPrincipal;
//    }
}
