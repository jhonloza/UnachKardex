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
    private VBox cod;
    private ObservableList<TextField> lstCodigo=FXCollections.observableArrayList();
    private ArrayList<TextField> listaCodigo;
    private TextField tfcodigo;
    private VBox nom;
    private ObservableList<TextField> lstNombre=FXCollections.observableArrayList();
    private ArrayList<TextField> listaNombre;
    private TextField tfNombre;
    private VBox cant;
    private ObservableList<TextField> lstCantidad=FXCollections.observableArrayList();
    private ArrayList<TextField> listaCantidad;
    private TextField tfCantidad;
    private VBox pUnit;
    private ObservableList<TextField> lstPrecioU=FXCollections.observableArrayList();
    private ArrayList<TextField> listaPrecioU;
    private TextField tfPrecioU;
    private VBox pTot;
    private ObservableList<TextField> lstPrecioT=FXCollections.observableArrayList();
    private ArrayList<TextField> listaPrecioT;
    private TextField tfprecioT;
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
        pnlItems.setMaxSize(755, 30);
        pnlItems.setMinSize(755, 30);
        pnlItems.getChildren().addAll(codigo, nombre, cantidad, precioU, precioT);
        pnlItems.setAlignment(Pos.CENTER);
        //listado de items
        //codigo
        listaCodigo=new ArrayList<>();
        tfcodigo=new TextField();
        tfcodigo.setMaxSize(100, 25);
        tfcodigo.setMinSize(100, 25);
        listaCodigo.add(tfcodigo);
        lstCodigo.setAll(listaCodigo);
        cod=new VBox();
        cod.getChildren().addAll(lstCodigo);
        //nombre
        listaNombre=new ArrayList<>();
        tfNombre=new TextField();
        tfNombre.setMaxSize(348, 25);
        tfNombre.setMinSize(348, 25);
        listaNombre.add(tfNombre);
        lstNombre.setAll(listaNombre);
        nom=new VBox();
        nom.getChildren().addAll(lstNombre);
        //cantidad
        listaCantidad=new ArrayList<>();
        tfCantidad=new TextField();
        tfCantidad.setMaxSize(100, 25);
        tfCantidad.setMinSize(100, 25);
        listaCantidad.add(tfCantidad);
        lstCantidad.setAll(listaCantidad);
        cant=new VBox();
        cant.getChildren().addAll(lstCantidad);
        //pu
        listaPrecioU=new ArrayList<>();
        tfPrecioU=new TextField();
        tfPrecioU.setMaxSize(100, 25);
        tfPrecioU.setMinSize(100, 25);
        listaPrecioU.add(tfPrecioU);
        lstPrecioU.setAll(listaPrecioU);
        pUnit=new VBox();
        pUnit.getChildren().addAll(lstPrecioU);
        //pt
        listaPrecioT=new ArrayList<>();
        tfprecioT=new TextField();
        tfprecioT.setMaxSize(100, 25);
        tfprecioT.setMinSize(100, 25);
        listaPrecioT.add(tfprecioT);
        lstPrecioT.setAll(listaPrecioT);
        pTot=new VBox();
        pTot.getChildren().addAll(lstPrecioT);
        //ingreso final
        items=new HBox(1);
        items.getChildren().addAll(cod,nom,cant,pUnit,pTot);
        items.setMaxSize(755, 350);
        items.setMinSize(755, 350);
        items.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        pntPrincipal = new VBox(1);
        pntPrincipal.getChildren().addAll(pnlItems,items);
        pntPrincipal.setBackground(new Background(fondo));
        pntPrincipal.setStyle("-fx-padding: 2; -fx-border-color: mediumblue; -fx-border-width: 2px");
        Scene scnPrincipal = new Scene(pntPrincipal, 840, 600);
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
