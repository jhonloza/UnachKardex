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
    private ArrayList<FacturaVenta> listaFacturas;
    private Cliente client;
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
    private ComboBox<Producto> cbxProd;
    private ArrayList<Producto> listaProdF;
    private ObservableList<ComboBox<Producto>> cbxProducto = FXCollections.observableArrayList();
    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    private ArrayList<Producto> listProducto;
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
    private HBox pnlbotones;
    private Button btnComprar;
    private Button btnlimpiar;
    private VBox pnlFinal;
    private double totalA;
    private double totalF;
    private double ivaUsado;
    private ArrayList<DetalleVenta> listaVentas;
    private String tipoTransaccion;
    private BorderPane pntPrincipal;
    private ArrayList<Kardex> listadoKardex;

    public FormNFacturaVenta() {
        totalA = 0;
        totalF = 0;
        tipoTransaccion = "V";
        //PANEL SUPERIOR CLIENTE
        pFondo = new Image("file:src\\unachkardex\\multimedia\\FondoSubVentanas.jpg");
        fondo = new BackgroundImage(pFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        txtcedula = new Label("Cedula/Ruc Cliente:   ");
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
        cargarProducto();
        listaProdF = new ArrayList<Producto>();
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
        tfCodFactura = new TextField(String.valueOf(cargarFactura() + 1));
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
        vItems = new VBox();
        vItems.getChildren().add(items);
        barrita = new ScrollPane(vItems);
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
        iva = new TextField("12");
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
        btnlimpiar = new Button("Limpiar");
        btnlimpiar.setFont(Font.font("Berlin Sans FB Demi", 15));
        btnComprar = new Button("Vender");
        btnComprar.setFont(Font.font("Berlin Sans FB Demi", 15));
        pnlbotones = new HBox(10);
        pnlbotones.getChildren().addAll(btnlimpiar, btnComprar);
        pnlbotones.setAlignment(Pos.CENTER_RIGHT);
        pnlFinal = new VBox(15);
        pnlFinal.getChildren().addAll(pnlFin1, pnlFin2, pnlFin3, pnlbotones);
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
                insertarCompraPEventHandler(event);
            }
        });
        btnComprar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnComprarEventHandler(event);
            }
        });
        btnlimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnLimpiarEventHandler(event);
            }
        });
        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnBuscarEventHandler(event);
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
        listaProdF.add(cbxProd.getValue());
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
        tfCodigo.setEditable(false);
        lstCodigo.add(tfCodigo);
        cod = new VBox();
        cod.getChildren().addAll(lstCodigo);
        //nombre
        listaProductos.addAll(listProducto);
        cbxProd = new ComboBox<Producto>(listaProductos);
        cbxProducto.add(cbxProd);
        nom = new VBox();
        nom.getChildren().addAll(cbxProducto);
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
        tfCantidad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calcular(event);
            }
        });
        cbxProd.setOnHiding(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                llenarProducto(event);
            }
        });
    }

    public void llenarProducto(Event event) {
        try {
            tfCodigo.setText(String.valueOf(cbxProd.getValue().getCodProducto()));
            tfPrecioU.setText(String.valueOf(cbxProd.getValue().getPrecio()));
        } catch (Exception e) {
        }
    }

    public void insertarCompraPEventHandler(ActionEvent event) {
        IProducto prodDao = new ImplProducto();
        Producto produc = null;
        try {
            produc = new Producto();

            listaCodigo.add(Integer.parseInt(tfCodigo.getText()));
            System.out.println("Codigo Seleccionado: " + tfCodigo.getText());
            produc = prodDao.obtener(Integer.parseInt(tfCodigo.getText()));
            System.out.println("Producto Seleccionado: " + produc.getNombre());
            listaProdF.add(produc);
            System.out.println("Cantidad Seleccionado: " + tfCantidad.getText());
            listaCantidad.add(Integer.parseInt(tfCantidad.getText()));
            System.out.println("Cantidad Seleccionado: " + tfCantidad.getText());
            listaPrecioU.add(Double.parseDouble(tfPrecioU.getText()));
            System.out.println("Precio unitario Seleccionado: " + tfPrecioU.getText());
            listaPrecioT.add(Double.parseDouble(tfprecioT.getText()));
            System.out.println("Precio Total Seleccionado: " + tfprecioT.getText());
            ivaUsado = Double.parseDouble(iva.getText()) / 100;
            totalA = totalA + Double.parseDouble(tfprecioT.getText());
            TotalAntes.setText(String.valueOf(totalA));
            totalF = totalA + (ivaUsado * totalA);
            totalFinal.setText(String.valueOf(totalF));
            for (int e : listaCodigo) {
                System.out.println("codigo:  " + e);
            }
            generarFilaVenta();
            vItems.getChildren().add(items);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private int cargarFactura() {
        int numCateg = 0;
        listaFacturas = new ArrayList<>();
        IFacturaVenta factDao = new ImplFacturaVenta();
        try {
            listaFacturas = factDao.obtener();
            numCateg = listaFacturas.size();
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("Error: " + e.getMessage());
            alerta.showAndWait();
        }
        return numCateg;
    }

    private int cargarDetFact() {
        int numCateg = 0;
        listaVentas = new ArrayList<>();
        IDetalleVenta ventaDao = new ImplDetalleVenta();
        try {
            listaVentas = ventaDao.obtener();
            numCateg = listaFacturas.size();
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("Error: " + e.getMessage());
            alerta.showAndWait();
        }
        return numCateg;
    }

    public void btnComprarEventHandler(ActionEvent event) {
        IKardex kardexDao = new ImplKardex();
        Kardex nKardex = null;
        ICliente clientedorDao = new ImplCliente();
        Cliente nCliente = new Cliente();
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
            nCliente = clientedorDao.obtener(cedula.getText());
        } catch (Exception e) {
        }
        IFacturaVenta factDao = new ImplFacturaVenta();
        FacturaVenta nFactura = new FacturaVenta();
        IProducto producDao = new ImplProducto();
        Producto productoTemp = new Producto();
        IDetalleVenta ventaDao = new ImplDetalleVenta();
        IConsultaKProducto consultaKDao=new ImplConsultaKProducto();
        DetalleVenta nVenta = null;
        try {
            nFactura.setCodFacturaVenta(Integer.parseInt(tfCodFactura.getText()));
            try {
                nFactura.setFecha(formatoFecha.parse(tfFechaFact.getText()));
            } catch (Exception e) {
            }
            nFactura.setCliente(nCliente);
            if (factDao.insertar(nFactura) > 0) {
                System.out.println("Factura Nueva Creada");
            } else {
                System.out.println("Error de creacion de factura");
            }
            for (int i = 0; i < listaCodigo.size(); i++) {
                productoTemp = producDao.obtener(listaCodigo.get(i));
                nVenta = new DetalleVenta(cargarDetFact() + 1 + i, productoTemp, nFactura, listaCantidad.get(i), listaPrecioT.get(i));
                if (ventaDao.ingresar(nVenta) > 0) {
                    System.out.println("Ingreso de Detalle V Correcto!");
                } else {
                    System.out.println("Ingreso de Detalle V Fallido!");
                }
                ArrayList<Kardex> kardexBuscado = new ArrayList<>();
                kardexBuscado = consultaKDao.listadoKardexProducto(productoTemp.getCodProducto());
                Kardex kardexTemp = null;
                if (kardexBuscado.size() > 0) {
                    Kardex ktemp=new Kardex();
                    ktemp=kardexBuscado.get(kardexBuscado.size()-1);
                    System.out.println("Kardex final: "+ktemp.getCodKardex()+ ktemp.getProducto().getNombre());
                    kardexTemp=new Kardex();
                    kardexTemp=ktemp;
                } else {
                    kardexTemp = new Kardex(1, productoTemp, nFactura.getFecha(), tipoTransaccion, 0, 0, totalA);
                }
                nKardex = new Kardex(cargarKardex() + 1 + i, productoTemp, nFactura.getFecha(), tipoTransaccion, kardexTemp.getExistencias() + (listaCantidad.get(i) * (-1)), listaCantidad.get(i), listaPrecioT.get(i));
                if (kardexDao.insertar(nKardex) > 0) {
                    System.out.println("Ingreso de Kardex Correcto!");
                } else {
                    System.out.println("Ingreso de Kardex Fallido!");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void btnLimpiarEventHandler(ActionEvent event) {
        detaVenta = new VBox();
        generarFilaVenta();
        tfCodFactura.setText(String.valueOf(cargarFactura() + 1));
        tfFechaFact.setText("");
        vItems.getChildren().removeAll(items);
        vItems.getChildren().add(items);
        barrita = new ScrollPane();
        barrita.setMaxSize(718, 200);
        barrita.setMinSize(718, 200);
        barrita.setVmax(5000);
        barrita.setVmin(0);
        barrita.setContent(vItems);
        detaVenta.getChildren().addAll(pnlItems, barrita);
        detaVenta.setAlignment(Pos.CENTER);
        detaVenta.setPadding(new Insets(10));
        pntPrincipal.setCenter(detaVenta);
    }

    private int cargarKardex() {
        int numCateg = 0;
        listadoKardex = new ArrayList<>();
        IKardex kardexDao = new ImplKardex();
        try {
            listadoKardex = kardexDao.obtener();
            numCateg = listaFacturas.size();
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("Error: " + e.getMessage());
            alerta.showAndWait();
        }
        return numCateg;
    }

    public void cargarProducto() {
        listProducto = new ArrayList<>();
        IProducto proDao = new ImplProducto();
        try {
            listProducto = proDao.obtener();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }

    public void btnBuscarEventHandler(ActionEvent event) {
        ICliente clienteDao = new ImplCliente();
        client = new Cliente();
        try {
            client = clienteDao.obtener(cedula.getText());
            nombres.setText(client.getNombre() + " " + client.getApellido());
            direccion.setText(client.getDireccion());
            telefono.setText(client.getTelefono());
            email.setText(client.geteMail());
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("No se encontro Registros: " + e.getMessage());
            alerta.showAndWait();
        }
    }
}
