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

public class FrmEcategoria extends Application {

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
    private Label nombre;
    private Label descripcion;
    private ArrayList<Categoria> listaCategorias;
    private HBox pnlC1;
    private HBox pnlC2;
    private HBox pnlC3;
    private VBox pnlCampos;
    //Prensetacion y Parametros
    private HBox catParaImg;
    //Botones
    private Button btnAccion;
    private Button btnLimpiar;
    private Button btnBuscar;
    private HBox pnlbotones;
    //Pantalla Principal
    private VBox pntPrincipal;

    @Override
    public void start(Stage primaryStage) throws Exception {
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
        nombre = new Label();
        nombre.setMaxSize(150, 25);
        nombre.setMinSize(150, 25);
        nombre.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        btnBuscar = new Button("Buscar");
        btnBuscar.setMaxSize(100, 35);
        btnBuscar.setMinSize(100, 35);
        btnBuscar.setFont(Font.font("Berlin Sans FB Demi", 20));
        descripcion = new Label();
        descripcion.setMaxSize(150, 25);
        descripcion.setMinSize(150, 25);
        descripcion.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        pnlC1 = new HBox(5);
        pnlC1.getChildren().addAll(txtCodigo, codigo, btnBuscar);
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

        //Acciones Botones
        btnAccion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bIngresarEventHandler(event);
            }
        });
        btnLimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnLimpiarEventHandler(event);
            }
        });
        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(Font.font("Berlin Sans FB Demi", 15));
        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnBuscarEventHandler(event);
            }
        });

        Scene scene = new Scene(pntPrincipal, 640, 480);
        primaryStage.setTitle("Eliminar Categoria");
        primaryStage.setScene(scene);
        primaryStage.setMaxHeight(480);
        primaryStage.setMinHeight(480);
        primaryStage.setMaxWidth(640);
        primaryStage.setMaxWidth(640);
        primaryStage.show();
    }

    public Node getPantallaP() {
        return pntPrincipal;
    }

    private int cargarCateg() {
        int numCateg = 0;
        listaCategorias = new ArrayList<>();
        ICategoria categoriaDao = new ImplCategoria();
        try {
            listaCategorias = categoriaDao.obtener();
            numCateg = listaCategorias.size();
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("Error: " + e.getMessage());
            alerta.showAndWait();
        }
        return numCateg;
    }

    public void bIngresarEventHandler(ActionEvent event) {
        ICategoria categDao = new ImplCategoria();
        Categoria nCategoria = new Categoria();
        try {
            nCategoria.setCodCategoria(Integer.parseInt(codigo.getText()));
            nCategoria.setNombre(nombre.getText());
            nCategoria.setDescripcion(descripcion.getText());
            if (categDao.insertar(nCategoria) > 0) {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("INFORMACION DEL SISTEMA");
                alerta.setHeaderText(null);
                alerta.setContentText("Ingtreso Correcto!!");
                alerta.showAndWait();
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("INFORMACION DEL SISTEMA");
                alerta.setHeaderText(null);
                alerta.setContentText("Ingreso Incorrecto!!");
                alerta.showAndWait();
            }
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("Error: " + e.getMessage());
            alerta.showAndWait();
        }
    }

    public void btnLimpiarEventHandler(ActionEvent event) {
        codigo.setText("");
        nombre.setText("");
        descripcion.setText("");
    }

    public void btnBuscarEventHandler(ActionEvent event) {
        ICategoria categoriaDao = new ImplCategoria();
        Categoria categori = new Categoria();
        try {
            categori = categoriaDao.obtener(Integer.parseInt(codigo.getText()));
            nombre.setText(categori.getNombre());
            descripcion.setText(categori.getDescripcion());

        } catch (Exception e) {
            System.out.println("error: "+e.getMessage());
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}