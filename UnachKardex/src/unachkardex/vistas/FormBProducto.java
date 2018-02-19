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
import static javafx.application.Application.launch;
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

public class FormBProducto {

    private Image pFondo;
    private BackgroundImage fondo;
    private Image icono;
    private ImageView visor;

    private Label txtCodigo;
    private Label txtCategoria;
    private Label txtNombre;
    private Label txtPrecio;

    private TextField codigo;
    private Label nombre;
    private Label precio;
    private Label descrCategoria;

    private Button btnBuscar;
    private Button btnLimpiar;
    private VBox pnlbuscar;
    private VBox pnlProducto;
    private VBox pnlCategoria;
    private GridPane pnlCentral;
    private GridPane pnlBotones;
    private GridPane pntPrincipal;

    public FormBProducto() {
        pFondo = new Image("file:src\\unachkardex\\multimedia\\FondoSubVentanas.jpg");
        fondo = new BackgroundImage(pFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        //lables de los campos
        txtCodigo = new Label("Codigo");
        txtCodigo.setFont(Font.font("Berlin Sans FB Demi", 20));

        txtCategoria = new Label("Categoria");
        txtCategoria.setFont(Font.font("Berlin Sans FB Demi", 20));

        txtNombre = new Label("Nombre");
        txtNombre.setFont(Font.font("Berlin Sans FB Demi", 20));

        txtPrecio = new Label("Precio");
        txtPrecio.setFont(Font.font("Berlin Sans FB Demi", 20));

        /////CAJAS DE TEXTO 
        codigo = new TextField("");
        codigo.setMaxSize(150, 25);
        codigo.setMinSize(150, 25);
        codigo.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");

        descrCategoria = new Label();
        descrCategoria.setMaxSize(150, 25);
        descrCategoria.setMinSize(150, 25);
        descrCategoria.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");

        nombre = new Label("");
        nombre.setMaxSize(150, 25);
        nombre.setMinSize(150, 25);
        nombre.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");

        precio = new Label("");
        precio.setMaxSize(150, 25);
        precio.setMinSize(150, 25);
        precio.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");

//        descrCategoria.setFont(Font.font("Berlin Sans FB Demi", 14));
//        descrCategoria.setTextFill(Color.AZURE);
        /////////////BOTONES A USAR 
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("Berlin Sans FB Demi", 20));
        btnLimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnLimpiarEventHandler(event);
            }
        });

        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(Font.font("Berlin Sans FB Demi", 20));
        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnBuscarEventHandler(event);
            }
        });
        pnlProducto = new VBox(20);
        pnlProducto.getChildren().add(txtCodigo);
        pnlProducto.getChildren().add(codigo);
        pnlProducto.getChildren().add(txtNombre);
        pnlProducto.getChildren().add(nombre);
        pnlProducto.getChildren().add(txtPrecio);
        pnlProducto.getChildren().add(precio);
        pnlCategoria = new VBox(20);
        pnlCategoria.getChildren().add(txtCategoria);
        pnlCategoria.getChildren().add(descrCategoria);
        pnlCentral = new GridPane();
        pnlCentral.setVgap(5);
        pnlCentral.setHgap(10);
        pnlCentral.add(pnlProducto, 1, 1);
        pnlCentral.add(pnlCategoria, 2, 1);
        pnlBotones = new GridPane();
        pnlBotones.setVgap(10);
        pnlBotones.setHgap(10);
        pnlBotones.add(btnBuscar, 0, 0);
        pnlBotones.add(btnLimpiar, 1, 0);
        pnlBotones.setAlignment(Pos.CENTER);
        pntPrincipal = new GridPane();
        pntPrincipal.setVgap(10);
        pntPrincipal.setHgap(10);
        pntPrincipal.add(pnlCentral, 0, 0);
        pntPrincipal.add(pnlBotones, 0, 1);
        pntPrincipal.setPadding(new Insets(25));
        pntPrincipal.setPadding(new Insets(10));
        pntPrincipal.setBackground(new Background(fondo));
        pntPrincipal.setStyle("-fx-padding: 10; -fx-border-color: mediumblue; -fx-border-width: 2px");

    }

    public void btnLimpiarEventHandler(ActionEvent event) {
        codigo.setText("");
    }

    public void btnBuscarEventHandler(ActionEvent event) {
        IProducto proDao = new ImplProducto();
        Producto prod = new Producto();
        try {
            prod = proDao.obtener(Integer.parseInt(codigo.getText()));
            descrCategoria.setText(String.valueOf(prod.getCategoria()));
            nombre.setText(prod.getNombre());
            precio.setText(String.valueOf(prod.getPrecio()));
            System.out.println(prod.getCodProducto() + "   " + prod.getNombre() + "   " + prod.getPrecio() + "   " + prod.getCategoria().getNombre());
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("No se encuentra el Producto " + codigo.getText());
            alerta.showAndWait();
        }
    }

    public Node getPntPrincipalP() {
        return pntPrincipal;
    }

}
