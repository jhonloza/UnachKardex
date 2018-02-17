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

public class FormNDetalleVenta /*extends Application*/ {

    private Label codigo;
    private Label nombre;
    private Label cantidad;
    private Label precioU;
    private Label precioT;
    private Label accion;
    private VBox cod;
    private ObservableList<TextField> lstCodigo = FXCollections.observableArrayList();
    private ArrayList<Integer> listaCodigo=new ArrayList<Integer>();
    private TextField tfCodigo;
    private VBox nom;
    private ObservableList<TextField> lstNombre = FXCollections.observableArrayList();
    private ArrayList<String> listaNombre=new ArrayList<String>();
    private TextField tfNombre;
    private VBox cant;
    private ObservableList<TextField> lstCantidad = FXCollections.observableArrayList();
    private ArrayList<Integer> listaCantidad=new ArrayList<Integer>();
    private TextField tfCantidad;
    private VBox pUnit;
    private ObservableList<TextField> lstPrecioU = FXCollections.observableArrayList();
    private ArrayList<Double> listaPrecioU=new ArrayList<Double>();
    private TextField tfPrecioU;
    private VBox pTot;
    private ObservableList<TextField> lstPrecioT = FXCollections.observableArrayList();
    private ArrayList<Double> listaPrecioT=new ArrayList<Double>();
    private TextField tfprecioT;
    private Button btnAccion;

    private Image pFondo;
    private BackgroundImage fondo;
    private HBox pnlItems;
    private HBox items;
    private VBox pntPrincipal;

//    @Override

    public FormNDetalleVenta() /*void start(Stage primaryStage)*/ {

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
        accion = new Label("A");
        accion.setMaxSize(25, 25);
        accion.setMinSize(25, 25);
        accion.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        accion.setAlignment(Pos.CENTER);
        pnlItems = new HBox(2);
        pnlItems.setMaxSize(780, 30);
        pnlItems.setMinSize(780, 30);
        pnlItems.getChildren().addAll(codigo, nombre, cantidad, precioU, precioT, accion);
        pnlItems.setAlignment(Pos.CENTER);
        //btnaccion
        btnAccion = new Button("...");
        btnAccion.setMaxSize(25, 25);
        btnAccion.setMinSize(25, 25);
        items = new HBox(1);
        generarFilaVenta();
        items.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        pntPrincipal = new VBox(1);
        pntPrincipal.getChildren().addAll(pnlItems, items);
        pntPrincipal.setBackground(new Background(fondo));
        pntPrincipal.setStyle("-fx-padding: 2; -fx-border-color: mediumblue; -fx-border-width: 2px");
        pntPrincipal.setMaxSize(800, 600);
        pntPrincipal.setMinSize(800, 600);
        /*Scene scnPrincipal = new Scene(pntPrincipal, 790, 600);
        primaryStage.setTitle("Sistema de facturacion");
        primaryStage.setMaximized(false);
        primaryStage.setScene(scnPrincipal);
        primaryStage.show();*/
        
        btnAccion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                insertarVentaPEventHandler(event);
            }
        });
    }
/*
    public static void main(String[] args) {
        launch(args);
    }*/

    public Node getPantallaP() {
        return pntPrincipal;
    }

    public void calcular(ActionEvent event){
        double v1=Double.parseDouble(tfCantidad.getText());
        double v2=Double.parseDouble(tfPrecioU.getText());
        tfprecioT.setText(String.valueOf(v1*v2));
    }
    
    public void btnAccionEventHandler(ActionEvent event) {
        double v1 = Double.parseDouble(tfCantidad.getText());
        double v2 = Double.parseDouble(tfPrecioU.getText());
        tfprecioT.setText(String.valueOf(v1 * v2));
        listaCodigo.add(Integer.parseInt(tfCodigo.getText()));
        listaNombre.add(tfNombre.getText());
        listaCantidad.add(Integer.parseInt(tfCantidad.getText()));
        listaPrecioU.add(Double.parseDouble(tfPrecioU.getText()));
        listaPrecioT.add(Double.parseDouble(tfprecioT.getText()));
    }

    
    
    public void generarFilaVenta() {
        //listado de items
        //codigo
        tfCodigo = new TextField();
        tfCodigo.setMaxSize(100, 25);
        tfCodigo.setMinSize(100, 25);
        tfCodigo.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        lstCodigo.add(tfCodigo);
        cod = new VBox();
        cod.getChildren().addAll(lstCodigo);
        //nombre
        tfNombre = new TextField();
        tfNombre.setMaxSize(350, 25);
        tfNombre.setMinSize(350, 25);
        tfNombre.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        lstNombre.add(tfNombre);
        nom = new VBox();
        nom.getChildren().addAll(lstNombre);
        //cantidad
        tfCantidad = new TextField();
        tfCantidad.setMaxSize(100, 25);
        tfCantidad.setMinSize(100, 25);
        tfCantidad.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        lstCantidad.add(tfCantidad);
        cant = new VBox();
        cant.getChildren().addAll(lstCantidad);
        //pu
        tfPrecioU = new TextField();
        tfPrecioU.setMaxSize(100, 25);
        tfPrecioU.setMinSize(100, 25);
        tfPrecioU.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        lstPrecioU.add(tfPrecioU);
        pUnit = new VBox();
        pUnit.getChildren().addAll(lstPrecioU);
        //pt
        tfprecioT = new TextField();
        tfprecioT.setMaxSize(100, 25);
        tfprecioT.setMinSize(100, 25);
        tfprecioT.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        lstPrecioT.add(tfprecioT);
        pTot = new VBox();
        pTot.getChildren().addAll(lstPrecioT);
        items=new HBox(1);
        items.getChildren().addAll(cod, nom, cant, pUnit, pTot, btnAccion);
        items.setAlignment(Pos.BOTTOM_CENTER);
        tfCodigo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                llenarProducto(event);
            }
        });
        tfCantidad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calcular(event);
            }
        });
    }
    
    public void llenarProducto(ActionEvent event){
        IProducto prodDao=new ImplProducto();
        Producto nProd=new Producto();
        try {
            nProd=prodDao.obtener(Integer.parseInt(tfCodigo.getText()));
            tfNombre.setText(nProd.getNombre());
            tfPrecioU.setText(String.valueOf(nProd.getPrecio()));
        } catch (Exception e) {
        }
    }
    
    public void insertarVentaPEventHandler(ActionEvent event){
        listaCodigo.add(Integer.parseInt(tfCodigo.getText()));
        listaNombre.add(tfCodigo.getText());
        listaCantidad.add(Integer.parseInt(tfCodigo.getText()));
        listaPrecioU.add(Double.parseDouble(tfCodigo.getText()));
        listaPrecioT.add(Double.parseDouble(tfCodigo.getText()));
        for(int i=0; i<listaCodigo.size();i++){
            System.out.println(listaCodigo.get(i)+"\t"+listaNombre.get(i)+"\t"+listaCantidad.get(i)+"\t"+listaPrecioU.get(i)+"\t"+listaPrecioT.get(i));
        }
//        System.out.println(listaCodigo.size());
        generarFilaVenta();
        pntPrincipal.getChildren().add(items);
    }

    public ArrayList<Integer> getListaCodigo() {
        return listaCodigo;
    }

    public ArrayList<String> getListaNombre() {
        return listaNombre;
    }

    public ArrayList<Integer> getListaCantidad() {
        return listaCantidad;
    }

    public ArrayList<Double> getListaPrecioU() {
        return listaPrecioU;
    }

    public ArrayList<Double> getListaPrecioT() {
        return listaPrecioT;
    }

}
