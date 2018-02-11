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
public class FormMenuPrincipal extends Application{
    private MenuBar BarraMenu;
      private Menu Inicio;
        private MenuItem iniciarSesion;
        private MenuItem salir;
      private Menu Cliente;
        private MenuItem nuevoCliente;
        private MenuItem modificarCliente;
        private MenuItem eliminarCliente;
        private MenuItem buscarCliente;
        private MenuItem listadoClientes;
      private Menu Proveedor;
        private MenuItem nuevoProveedor;
        private MenuItem modificarProveedor;
        private MenuItem eliminarProveedor;
        private MenuItem buscarProveedor;
        private MenuItem listadoProveedor;
      private Menu Producto;
        private MenuItem nuevoProducto;
        private MenuItem modificarProducto;
        private MenuItem eliminarProducto;
        private MenuItem buscarProducto;
        private MenuItem listadoProducto;
      private Menu Categoria;
        private MenuItem nuevoCategoria;
        private MenuItem modificarCategoria;
        private MenuItem eliminarCategoria;
        private MenuItem buscarCategoria;
        private MenuItem listadoCategoria;
      private Menu Venta;
        private MenuItem nuevoVenta;
        private MenuItem modificarVenta;
        private MenuItem eliminarVenta;
        private MenuItem buscarVenta;
        private MenuItem listadoVenta;
      private Menu Compra;
        private MenuItem nuevoCompra;
        private MenuItem modificarCompra;
        private MenuItem eliminarCompra;
        private MenuItem buscarCompra;
        private MenuItem listadoCompra;
      private Menu kardex;
        private MenuItem kardexMensual;
        private MenuItem kardexAnual;
    private BorderPane pntPrincipal;
    @Override
    public void start(Stage primaryStage) throws Exception {
        kardexMensual=new MenuItem("Kardex Mensual");
        kardexAnual=new MenuItem("Kardex Anual");
          kardex=new Menu("Kardex");
          kardex.getItems().addAll(kardexMensual, kardexAnual);
        nuevoCompra=new MenuItem("Nueva Compra");
        modificarCompra=new MenuItem("Modificar Compra");
        eliminarCompra=new MenuItem("Eliminar Compra");
        buscarCompra=new MenuItem("Buscar Compra");
        listadoCompra=new MenuItem("Listado de Compras");
          Compra=new Menu("Compra");
          Compra.getItems().addAll(nuevoCompra, modificarCompra, eliminarCompra, new SeparatorMenuItem(), buscarCompra, listadoCompra);
        nuevoVenta=new MenuItem("Nueva Venta");
        modificarVenta=new MenuItem("Modificar Venta");
        eliminarVenta=new MenuItem("Eliminar Venta");
        buscarVenta=new MenuItem("Buscar Venta");
        listadoVenta=new MenuItem("Listado de Ventas");
          Venta=new Menu("Venta");
          Venta.getItems().addAll(nuevoVenta, modificarVenta, eliminarVenta, new SeparatorMenuItem(), buscarVenta, listadoVenta);
        nuevoCategoria=new MenuItem("Nueva Categoria");
        modificarCategoria=new MenuItem("Modificar Categoria");
        eliminarCategoria=new MenuItem("Eliminar Categoria");
        buscarCategoria=new MenuItem("Buscar Categoria");
        listadoCategoria=new MenuItem("Listado de Categorias");
          Categoria=new Menu("Categoria");
          Categoria.getItems().addAll(nuevoCategoria, modificarCategoria, eliminarCategoria, new SeparatorMenuItem(), buscarCategoria, listadoCategoria);
        nuevoProducto=new MenuItem("Nuevo Producto");
        modificarProducto=new MenuItem("Modificar Producto");
        eliminarProducto=new MenuItem("Eliminar Producto");
        buscarProducto=new MenuItem("Buscar Producto");
        listadoProducto=new MenuItem("Listado de Productos");
          Producto=new Menu("Producto");
          Producto.getItems().addAll(nuevoProducto, modificarProducto, eliminarProducto, new SeparatorMenuItem(), buscarProducto, listadoProducto);
        nuevoProveedor=new MenuItem("Nueva Proveedor");
        modificarProveedor=new MenuItem("Modificar Proveedor");
        eliminarProveedor=new MenuItem("Eilminar Proveedor");
        buscarProveedor=new MenuItem("Buscar Proveedor");
        listadoProveedor=new MenuItem("Listado de Proveedores");
          Proveedor=new Menu("Proveedor");
          Proveedor.getItems().addAll(nuevoProveedor, modificarProveedor, eliminarProveedor, new SeparatorMenuItem(), buscarProveedor, listadoProveedor);
        nuevoCliente=new MenuItem("Nuevo Cliente");
        modificarCliente=new MenuItem("Modificar Cliente");
        eliminarCliente=new MenuItem("Eliminar Cliente");
        buscarCliente=new MenuItem("Buscar Cliente");
        listadoClientes=new MenuItem("Listado de Clientes");
          Cliente=new Menu("Cliente");
          Cliente.getItems().addAll(nuevoCliente, modificarCliente, eliminarCliente, new SeparatorMenuItem(), buscarCliente, listadoClientes);
        iniciarSesion=new MenuItem("Iniciar Sesion");
        salir=new MenuItem("Salir");
          Inicio=new Menu("Inicio");
          Inicio.getItems().addAll(iniciarSesion, salir);
        BarraMenu=new MenuBar();
        BarraMenu.getMenus().addAll(Inicio, Cliente, Proveedor, Producto, Categoria, Venta, Compra, kardex);
        
        pntPrincipal=new BorderPane();
        pntPrincipal.setTop(BarraMenu);
        pntPrincipal.setBackground(new Background(new BackgroundImage(new Image("file:src\\unachkardex\\multimedia\\FondoMain.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1280, 720, false, false, false, false))));
        Scene scnPrincipal=new Scene(pntPrincipal, 1280, 720);
        primaryStage.setTitle("Sistema de facturacion");
        primaryStage.setMaxHeight(720);
        primaryStage.setMaxWidth(1280);
        primaryStage.setMinHeight(720);
        primaryStage.setMinWidth(1280);
        
        primaryStage.setScene(scnPrincipal);
        primaryStage.show();
        salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnSalirEventHandler(event);
            }
        });
        //Acciones
//       Menu Inicio
//        iniciarSesion
//        salir
//       Menu Cliente
//        nuevoCliente
//        modificarCliente
//        eliminarCliente
//        buscarCliente
//        listadoClientes
//       Menu Proveedor
//        nuevoProveedor
//        modificarProveedor
//        eliminarProveedor
//        buscarProveedor
//        listadoProveedor
//       Menu Producto
//        nuevoProducto
//        modificarProducto
//        eliminarProducto
//        buscarProducto
//        listadoProducto
//       Menu Categoria
//        nuevoCategoria
            nuevoCategoria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane categoriaNueva=new Pane();
                categoriaNueva.getChildren().add(nCategEventHandler(event));
                categoriaNueva.setPadding(new Insets(5));
                pntPrincipal.setCenter(categoriaNueva);
            }
        });
//        modificarCategoria
//        eliminarCategoria
//        buscarCategoria
//        listadoCategoria
//       Menu Venta
//        nuevoVenta
//        modificarVenta
//        eliminarVenta
//        buscarVenta
//        listadoVenta
//       Menu Compra
//        nuevoCompra
//        modificarCompra
//        eliminarCompra
//        buscarCompra
//        listadoCompra
//       Menu kardex
//        kardexMensual
//        kardexAnual
    }
    public static void main(String[] args) {
        launch(args);
    }
    public void btnSalirEventHandler(ActionEvent event){
        System.exit(0);
    }
    //Metodos de las Acciones
//       Menu Inicio
//        iniciarSesion
//        salir
//       Menu Cliente
//        nuevoCliente
//        modificarCliente
//        eliminarCliente
//        buscarCliente
//        listadoClientes
//       Menu Proveedor
//        nuevoProveedor
//        modificarProveedor
//        eliminarProveedor
//        buscarProveedor
//        listadoProveedor
//       Menu Producto
//        nuevoProducto
//        modificarProducto
//        eliminarProducto
//        buscarProducto
//        listadoProducto
//       Menu Categoria
//        nuevoCategoria
    public VentanaInterna nCategEventHandler(ActionEvent event){
        BorderPane categNueva=new BorderPane();
        Label titulo=new Label("Nueva Categoria");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar=new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo=new BarraDeTitulo(titulo, cerrar);
        categNueva.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormNCategoria categoriaNueva=new FormNCategoria();
        categNueva.setCenter(categoriaNueva.getPantallaP());
        //Creacion de Ventana interna
        VentanaInterna nCateg=new VentanaInterna();
        nCateg.setRoot(categNueva);
        nCateg.makeDragable(bTitulo.getBarra());
        nCateg.makeDragable(titulo);
        nCateg.makeResizable(20);
        nCateg.makeFocusable();
        nCateg.setCloseButton(cerrar);
        return nCateg;
    }
//        modificarCategoria
//        eliminarCategoria
//        buscarCategoria
//        listadoCategoria
//       Menu Venta
//        nuevoVenta
//        modificarVenta
//        eliminarVenta
//        buscarVenta
//        listadoVenta
//       Menu Compra
//        nuevoCompra
//        modificarCompra
//        eliminarCompra
//        buscarCompra
//        listadoCompra
//       Menu kardex
//        kardexMensual
//        kardexAnual
}
