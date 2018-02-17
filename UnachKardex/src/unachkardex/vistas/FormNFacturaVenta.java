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
import javafx.scene.input.ScrollEvent;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;

public class FormNFacturaVenta {

    private Image pFondo;
    private BackgroundImage fondo;
    private Label txtcedula;
    private Label txtnombres;
    private Label txtdireccion;
    private Label txttelefono;
    private Label txtemail;
    private TextField cedula;
    private Label nombres;
    private Label direccion;
    private Label telefono;
    private Label email;
    private VBox pnlCliente;
    private Button btnBuscar;
    private HBox pnlC1;
    private HBox pnlC2;
    private HBox pnlC3;
    private HBox pnlC4;

    //DETALLE VENTA
    private Group pnlMedio;
    private VBox detaVenta;
    private Label codigo;
    private Label nombre;
    private Label cantidad;
    private Label precioU;
    private Label precioT;
    private Label accion;
    private VBox cod;
    private ObservableList<TextField> lstCodigo = FXCollections.observableArrayList();
    private ArrayList<Integer> listaCodigo = new ArrayList<Integer>();
    private TextField tfCodigo;
    private VBox nom;
    private ObservableList<TextField> lstNombre = FXCollections.observableArrayList();
    private ArrayList<String> listaNombre = new ArrayList<String>();
    private TextField tfNombre;
    private VBox cant;
    private ObservableList<TextField> lstCantidad = FXCollections.observableArrayList();
    private ArrayList<Integer> listaCantidad = new ArrayList<Integer>();
    private TextField tfCantidad;
    private VBox pUnit;
    private ObservableList<TextField> lstPrecioU = FXCollections.observableArrayList();
    private ArrayList<Double> listaPrecioU = new ArrayList<Double>();
    private TextField tfPrecioU;
    private VBox pTot;
    private ObservableList<TextField> lstPrecioT = FXCollections.observableArrayList();
    private ArrayList<Double> listaPrecioT = new ArrayList<Double>();
    private TextField tfprecioT;
    private Button btnAccion;
    private HBox pnlItems;
    private HBox items;
    private ScrollPane barrita;
    private VBox vItems;
    /////////////////
    //////////Factura////////////
    private Label tituloFac;
    private Label txtCodFactura;
    private TextField tfCodFactura;
    private Label txtFechaFact;
    private TextField tfFechaFact;
    private HBox pnlF1;
    private HBox pnlF2;
    private HBox pnlF3;
    private VBox pnlFact;

    /// logo ////
    private Image logo;
    private ImageView mostrarLogo;
    //////// Cabecera /////////
    private HBox pnlCabecera;
    /////////Pie/////////
    private Label txtTotalAntes;
    private Label TotalAntes;
    private Label txtIva;
    private TextField iva;
    private Label txtTotalFinal;
    private Label totalFinal;
    private HBox pnlFin1;
    private HBox pnlFin2;
    private HBox pnlFin3;
    private VBox pnlFinal;

    private BorderPane pntPrincipal;

    public FormNFacturaVenta() {
        //PANEL SUPERIOR CLIENTE
        pFondo = new Image("file:src\\unachkardex\\multimedia\\FondoSubVentanas.jpg");
        fondo = new BackgroundImage(pFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        txtcedula = new Label("Cedula/Ruc CLiente:   ");
        txtcedula.setFont(Font.font("Berlin Sans FB Demi", 15));
        btnBuscar = new Button("Buscar");
        txtnombres = new Label("Nombre: ");
        txtnombres.setFont(Font.font("Berlin Sans FB Demi", 15));
        txtdireccion = new Label("Direccion: ");
        txtdireccion.setFont(Font.font("Berlin Sans FB Demi", 15));
        txttelefono = new Label("Telefono: ");
        txttelefono.setFont(Font.font("Berlin Sans FB Demi", 15));
        txtemail = new Label("Correo: ");
        txtemail.setFont(Font.font("Berlin Sans FB Demi", 15));
        //cajas de texto
        cedula = new TextField("0000000000001");
        cedula.setMaxSize(100, 25);
        cedula.setMinSize(100, 25);
        nombres = new Label("");
        nombres.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        nombres.setMaxSize(250, 25);
        nombres.setMinSize(250, 25);
        direccion = new Label("");
        direccion.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        direccion.setMaxSize(225, 25);
        direccion.setMinSize(225, 25);
        telefono = new Label("");
        telefono.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        telefono.setMaxSize(75, 25);
        telefono.setMinSize(75, 25);
        email = new Label("");
        email.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        email.setMaxSize(100, 25);
        email.setMinSize(100, 25);
        pnlC1 = new HBox(5);
        pnlC1.getChildren().addAll(txtcedula, cedula, btnBuscar);
        pnlC1.setAlignment(Pos.CENTER);
        pnlC2 = new HBox(5);
        pnlC2.getChildren().addAll(txtnombres, nombres);
        pnlC2.setAlignment(Pos.CENTER);
        pnlC3 = new HBox(5);
        pnlC3.getChildren().addAll(txtdireccion, direccion);
        pnlC3.setAlignment(Pos.CENTER);
        pnlC4 = new HBox(5);
        pnlC4.getChildren().addAll(txttelefono, telefono, txtemail, email);
        pnlC4.setAlignment(Pos.CENTER);
        pnlCliente = new VBox(5);
        pnlCliente.getChildren().addAll(pnlC1, pnlC2, pnlC3, pnlC4);
        consumidorFinal();

        ///////////Logo///////////
        logo = new Image("file:src\\unachkardex\\multimedia\\logo.jpg");
        mostrarLogo = new ImageView(logo);
        mostrarLogo.setFitHeight(75);
        mostrarLogo.setFitWidth(200);
        mostrarLogo.setOpacity(25);
        ///////////7////////////
        ///////////////Factura/////////////////
        tituloFac = new Label("Informacion de Facturacion");
        tituloFac.setMaxSize(200, 75);
        tituloFac.setMinSize(200, 75);
        tituloFac.setFont(Font.font("Berlin Sans FB Demi", 25));
        tituloFac.setAlignment(Pos.CENTER);
        tituloFac.setWrapText(true);
        txtCodFactura = new Label("Codigo Factura: ");
        tituloFac.setMaxSize(100, 25);
        tituloFac.setMaxSize(100, 25);
        txtCodFactura.setFont(Font.font("Berlin Sans FB Demi", 15));
        tfCodFactura = new TextField("");
        tfCodFactura.setMaxSize(100, 25);
        tfCodFactura.setMinSize(100, 25);
        txtFechaFact = new Label("Fecha de Emision: ");
        tituloFac.setMaxSize(100, 25);
        tituloFac.setMaxSize(100, 25);
        txtFechaFact.setFont(Font.font("Berlin Sans FB Demi", 15));
        tfFechaFact = new TextField("");
        tfFechaFact.setMaxSize(100, 25);
        tfFechaFact.setMinSize(100, 25);
        pnlF1 = new HBox(5);
        pnlF1.getChildren().add(tituloFac);
        pnlF1.setAlignment(Pos.CENTER);
        pnlF2 = new HBox(5);
        pnlF2.getChildren().addAll(txtCodFactura, tfCodFactura);
        pnlF2.setAlignment(Pos.CENTER);
        pnlF3 = new HBox(5);
        pnlF3.getChildren().addAll(txtFechaFact, tfFechaFact);
        pnlF3.setAlignment(Pos.CENTER);
        pnlFact = new VBox(10);
        pnlFact.getChildren().addAll(pnlF1, pnlF2, pnlF3);
        pnlFact.setAlignment(Pos.CENTER);
        //////////////////////
        ////////////CABECERA///////////
        pnlCabecera = new HBox(10);
        pnlCabecera.getChildren().addAll(pnlCliente, mostrarLogo, pnlFact);
        pnlCabecera.setAlignment(Pos.CENTER);
        //barra Items
        detaVenta = new VBox();
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
        precioU.setMaxSize(50, 25);
        precioU.setMinSize(50, 25);
        precioU.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        precioU.setAlignment(Pos.CENTER);
        precioT = new Label("Precio T");
        precioT.setMaxSize(50, 25);
        precioT.setMinSize(50, 25);
        precioT.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        precioT.setAlignment(Pos.CENTER);
        accion = new Label("A");
        accion.setMaxSize(55, 25);
        accion.setMinSize(55, 25);
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
        items.setStyle("-fx-border-color: white; -fx-border-width: 2px");
        items.setMaxWidth(714);
        items.setMinWidth(714);
        vItems=new VBox();
        vItems.getChildren().add(items);
        barrita=new ScrollPane(vItems);
        barrita.setMaxSize(718, 200);
        barrita.setMinSize(718, 200);
        barrita.setVmax(5000);
        barrita.setVmin(0);
        detaVenta.getChildren().addAll(pnlItems, barrita);
        detaVenta.setAlignment(Pos.CENTER);
        detaVenta.setPadding(new Insets(10));
        /////////////////////
        ////////////panel Fina////////////
        txtTotalAntes = new Label("Total Antes: ");
        txtTotalAntes.setFont(Font.font("Berlin Sans FB Demi", 15));
        TotalAntes = new Label("");
        TotalAntes.setMaxSize(100, 25);
        TotalAntes.setMinSize(100, 25);
        TotalAntes.setFont(Font.font("Berlin Sans FB Demi", 15));
        TotalAntes.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        txtIva = new Label("IVA: ");
        txtIva.setFont(Font.font("Berlin Sans FB Demi", 15));
        iva = new TextField();
        iva.setMaxSize(100, 25);
        iva.setMinSize(100, 25);
        txtTotalFinal = new Label("Total Final: ");
        txtTotalFinal.setFont(Font.font("Berlin Sans FB Demi", 15));
        totalFinal = new Label("");
        totalFinal.setMaxSize(100, 25);
        totalFinal.setMinSize(100, 25);
        totalFinal.setFont(Font.font("Berlin Sans FB Demi", 15));
        totalFinal.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        pnlFin1 = new HBox(5);
        pnlFin1.getChildren().addAll(txtTotalAntes, TotalAntes);
        pnlFin1.setAlignment(Pos.CENTER_RIGHT);
        pnlFin2 = new HBox(5);
        pnlFin2.getChildren().addAll(txtIva, iva);
        pnlFin2.setAlignment(Pos.CENTER_RIGHT);
        pnlFin3 = new HBox(5);
        pnlFin3.getChildren().addAll(txtTotalFinal, totalFinal);
        pnlFin3.setAlignment(Pos.CENTER_RIGHT);
        pnlFinal = new VBox(15);
        pnlFinal.getChildren().addAll(pnlFin1, pnlFin2, pnlFin3);
        pnlFinal.setMaxSize(730, 150);
        pnlFinal.setMinSize(730, 150);

        /////////////////////////////
        pntPrincipal = new BorderPane();
        pntPrincipal.setTop(pnlCabecera);
        pntPrincipal.setCenter(detaVenta);
        pntPrincipal.setBottom(pnlFinal);
        pntPrincipal.setPadding(new Insets(10));
        pntPrincipal.setBackground(new Background(fondo));
        pntPrincipal.setStyle("-fx-padding: 10; -fx-border-color: mediumblue; -fx-border-width: 2px");

        btnAccion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                insertarVentaPEventHandler(event);
            }
        });
    }

    public Node getPantallaP() {
        return pntPrincipal;
    }

    public void consumidorFinal() {
        ICliente clienteDao = new ImplCliente();
        Cliente nCliente = new Cliente();
        try {
            nCliente = clienteDao.obtener(cedula.getText());
            nombres.setText(nCliente.getNombre() + " " + nCliente.getApellido());
            direccion.setText(nCliente.getDireccion());
            telefono.setText(nCliente.getTelefono());
            email.setText(nCliente.geteMail());
        } catch (Exception e) {
        }
    }

    public void calcular(ActionEvent event) {
        double v1 = Double.parseDouble(tfCantidad.getText());
        double v2 = Double.parseDouble(tfPrecioU.getText());
        tfprecioT.setText(String.valueOf(v1 * v2));
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
        tfNombre.setEditable(false);
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
        tfPrecioU.setMaxSize(50, 25);
        tfPrecioU.setMinSize(50, 25);
        tfPrecioU.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        tfPrecioU.setEditable(false);
        lstPrecioU.add(tfPrecioU);
        pUnit = new VBox();
        pUnit.getChildren().addAll(lstPrecioU);
        //pt
        tfprecioT = new TextField();
        tfprecioT.setMaxSize(50, 25);
        tfprecioT.setMinSize(50, 25);
        tfprecioT.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        tfprecioT.setEditable(false);
        lstPrecioT.add(tfprecioT);
        pTot = new VBox();
        pTot.getChildren().addAll(lstPrecioT);
        items = new HBox(1);
        items.setPadding(new Insets(1));
        items.getChildren().addAll(cod, nom, cant, pUnit, pTot, btnAccion);
        items.setAlignment(Pos.BOTTOM_LEFT);
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

    public void llenarProducto(ActionEvent event) {
        IProducto prodDao = new ImplProducto();
        Producto nProd = new Producto();
        try {
            nProd = prodDao.obtener(Integer.parseInt(tfCodigo.getText()));
            tfNombre.setText(nProd.getNombre());
            tfPrecioU.setText(String.valueOf(nProd.getPrecio()));
        } catch (Exception e) {
        }
    }

    public void insertarVentaPEventHandler(ActionEvent event) {
        listaCodigo.add(Integer.parseInt(tfCodigo.getText()));
        listaNombre.add(tfCodigo.getText());
        listaCantidad.add(Integer.parseInt(tfCodigo.getText()));
        listaPrecioU.add(Double.parseDouble(tfCodigo.getText()));
        listaPrecioT.add(Double.parseDouble(tfCodigo.getText()));
        for (int i = 0; i < listaCodigo.size(); i++) {
            System.out.println(listaCodigo.get(i) + "\t" + listaNombre.get(i) + "\t" + listaCantidad.get(i) + "\t" + listaPrecioU.get(i) + "\t" + listaPrecioT.get(i));
        }
//        System.out.println(listaCodigo.size());
        generarFilaVenta();
        vItems.getChildren().add(items);
    }

}
