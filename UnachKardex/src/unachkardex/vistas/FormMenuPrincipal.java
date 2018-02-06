package unachkardex.vistas;

import com.sun.javafx.geom.Area;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import java.util.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import javafx.scene.Node;
import javafx.scene.text.Text;

public class FormMenuPrincipal extends Application {

    private Image fondo;
    private ImageView visorFondo;

    private VBox pntPrincipal;
    private MenuBar menuPrincipal;
    private Menu inicio;
    private Menu cliente;
    private Menu proveedor;
    private Menu FacturaVenta;
    private Menu facturaCompra;
    private Menu kardex;
    //inicio
    private MenuItem login;
    private MenuItem Salir;
    //cliente
    private MenuItem newCliente;
    private MenuItem modCliente;
    private MenuItem delCliente;
    private MenuItem infCliente;
    private MenuItem listCliente;
    //proveedor
    private MenuItem newProveedor;
    private MenuItem modProveedor;
    private MenuItem delProveedor;
    private MenuItem infProveedor;
    private MenuItem listProveedor;
    //FacturaVenta
    private MenuItem newFacVenta;
    private MenuItem modFacVenta;
    private MenuItem delFacVenta;
    private MenuItem infFacVenta;
    private MenuItem listFacVenta;
    //facturCompra
    private MenuItem newFacCompra;
    private MenuItem modFacCompra;
    private MenuItem delFacCompra;
    private MenuItem infFacCompra;
    private MenuItem listFacCompra;
    //kardex
    private MenuItem kardexMensual;
    private MenuItem kardexAnual;
    
    //cliente Nuevo
    
    private BackgroundImage fondoPrincipal;

    @Override
    public void start(Stage primaryStage) {

        fondo = new Image("file:src\\unachkardex\\multimedia\\error.jpg", 1280, 720, true, true);
        visorFondo = new ImageView(fondo);
        visorFondo.setPreserveRatio(true);

        menuPrincipal = new MenuBar();
        //Menu Inicio
        inicio = new Menu("Inicio");
        login = new MenuItem("Iniciar Sesion");
        Salir = new MenuItem("Salir");
        Salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mnSalirEventHandler(event);
            }
        });
        inicio.getItems().addAll(login, Salir);
        //Menu Inicio
        cliente = new Menu("Clientes");
        newCliente = new MenuItem("Nuevo Cliente");
        newCliente.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nClienteEventHandler(event);
            }
        });
        modCliente = new MenuItem("Modificar Cliente");
        delCliente = new MenuItem("Eliminar Cliente");
        infCliente = new MenuItem("Informacion de un Cliente");
        listCliente = new MenuItem("Listado de Clientes");
        cliente.getItems().addAll(newCliente, modCliente, delCliente, new SeparatorMenuItem(), infCliente, listCliente);
        //Menu Inicio
        FacturaVenta = new Menu("Factura Ventas");
        newFacVenta = new MenuItem("Nueva Venta");
        modFacVenta = new MenuItem("Modificar Venta");
        delFacVenta = new MenuItem("Eliminar Venta");
        infFacVenta = new MenuItem("Informacion de una Venta");
        listFacVenta = new MenuItem("Listado de Venta");
        FacturaVenta.getItems().addAll(newFacVenta, modFacVenta, delFacVenta, new SeparatorMenuItem(), infFacVenta, listFacVenta);
        //Menu Inicio
        proveedor = new Menu("Proveedores");
        newProveedor = new MenuItem("Nuevo Proveedor");
        modProveedor = new MenuItem("Modificar Proveedor");
        delProveedor = new MenuItem("Eliminar Proveedor");
        infProveedor = new MenuItem("Informacion de un Proveedor");
        listProveedor = new MenuItem("Listado Proveedor");
        proveedor.getItems().addAll(newProveedor, modProveedor, delProveedor, new SeparatorMenuItem(), infProveedor, listProveedor);
        //Menu Inicio
        facturaCompra = new Menu("Factura Compras");
        newFacCompra = new MenuItem("Nuevas Compas");
        modFacCompra = new MenuItem("Modificar Compra");
        delFacCompra = new MenuItem("Eliminar Compra");
        infFacCompra = new MenuItem("Informacion de una Compra");
        listFacCompra = new MenuItem("Listado de Compras");
        facturaCompra.getItems().addAll(newFacCompra, modFacCompra, delFacCompra, new SeparatorMenuItem(), infFacCompra, listFacCompra);
        //Menu Inicio
        kardex = new Menu("Kardex");
        kardexMensual = new MenuItem("Kardex Mensual");
        kardexAnual = new MenuItem("Kardex Anual");
        kardex.getItems().addAll(kardexMensual, kardexAnual);

        menuPrincipal.getMenus().addAll(inicio, cliente, proveedor, FacturaVenta, facturaCompra, kardex);

        fondoPrincipal=new BackgroundImage(fondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.ROUND, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        
        pntPrincipal = new VBox(10);
        pntPrincipal.getChildren().add(menuPrincipal);
        pntPrincipal.setBackground(new Background(fondoPrincipal));
        
        Scene scene = new Scene(pntPrincipal, 1200, 720);

        primaryStage.setTitle("Papeleria Academica");
        
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void mnSalirEventHandler(ActionEvent event){
        System.exit(0);
    }
    public void nClienteEventHandler(ActionEvent event){
        FormCliente nCliente=new FormCliente();
//        pntPrincipal.getChildren().add(nCliente);
    }
}
