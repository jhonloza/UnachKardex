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

public class FormNDetalleVenta extends Application {

    private Label codigo;
    private Label nombre;
    private Label cantidad;
    private Label precioU;
    private Label precioT;
    private ObservableList<TextField> lstCodigo=FXCollections.observableArrayList();
    private ArrayList<TextField> listaCodigo;
    private ObservableList<TextField> lstNombre=FXCollections.observableArrayList();
    private ObservableList<TextField> lstCantidad=FXCollections.observableArrayList();
    private ObservableList<TextField> lstPrecioU=FXCollections.observableArrayList();
    private ObservableList<TextField> lstPrecioT=FXCollections.observableArrayList();
    private Image pFondo;
    private BackgroundImage fondo;
    private HBox pnlItems;
    private HBox items;
    private VBox pntPrincipal;

    @Override

    public void start(Stage primaryStage) {
        //barra Items
        codigo = new Label("Codigo");
        codigo.setMaxSize(100, 25);
        codigo.setMinSize(100, 25);
        codigo.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        codigo.setAlignment(Pos.CENTER);
        nombre = new Label("Nombre");
        nombre.setMaxSize(350, 25);
        nombre.setMinSize(350, 25);
        nombre.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        nombre.setAlignment(Pos.CENTER);
        cantidad = new Label("Cantidad");
        cantidad.setMaxSize(100, 25);
        cantidad.setMinSize(100, 25);
        cantidad.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        cantidad.setAlignment(Pos.CENTER);
        precioU = new Label("Precio U");
        precioU.setMaxSize(100, 25);
        precioU.setMinSize(100, 25);
        precioU.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        precioU.setAlignment(Pos.CENTER);
        precioT = new Label("Precio T");
        precioT.setMaxSize(100, 25);
        precioT.setMinSize(100, 25);
        precioT.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        precioT.setAlignment(Pos.CENTER);
        pnlItems = new HBox(1);
        pnlItems.getChildren().addAll(codigo, nombre, cantidad, precioU, precioT);
        pnlItems.setAlignment(Pos.CENTER);
        //listado de items
        listaCodigo=new ArrayList<>();
        listaCodigo.add(new TextField());
        lstCodigo.setAll(listaCodigo);
        items=new HBox();
        items.getChildren().addAll(lstCodigo);
        items.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        pntPrincipal = new VBox(0);
        pntPrincipal.getChildren().addAll(pnlItems,items);
        pntPrincipal.setBackground(new Background(fondo));
        pntPrincipal.setStyle("-fx-padding: 2; -fx-border-color: mediumblue; -fx-border-width: 2px");
        Scene scnPrincipal = new Scene(pntPrincipal, 770, 300);
        primaryStage.setTitle("Sistema de facturacion");
        primaryStage.setMaximized(false);

        primaryStage.setScene(scnPrincipal);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Node getPantallaP() {
        return pntPrincipal;
    }

}
