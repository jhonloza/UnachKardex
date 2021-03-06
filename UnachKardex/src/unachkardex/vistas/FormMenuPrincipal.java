
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

public class FormMenuPrincipal extends Application {

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
    private Pane escritorio;

    @Override
    public void start(Stage primaryStage) throws Exception {
        escritorio = new Pane();
        kardexMensual = new MenuItem("Kardex Mensual");
        kardexAnual = new MenuItem("Kardex Anual");
        kardex = new Menu("Kardex");
        kardex.getItems().addAll(kardexMensual, kardexAnual);
        nuevoCompra = new MenuItem("Nueva Compra");
        modificarCompra = new MenuItem("Modificar Compra");
        eliminarCompra = new MenuItem("Eliminar Compra");
        buscarCompra = new MenuItem("Buscar Compra");
        listadoCompra = new MenuItem("Listado de Compras");
        Compra = new Menu("Compra");
        Compra.getItems().addAll(nuevoCompra, modificarCompra, eliminarCompra, new SeparatorMenuItem(), buscarCompra, listadoCompra);
        nuevoVenta = new MenuItem("Nueva Venta");
        modificarVenta = new MenuItem("Modificar Venta");
        eliminarVenta = new MenuItem("Eliminar Venta");
        buscarVenta = new MenuItem("Buscar Venta");
        listadoVenta = new MenuItem("Listado de Ventas");
        Venta = new Menu("Venta");
        Venta.getItems().addAll(nuevoVenta, modificarVenta, eliminarVenta, new SeparatorMenuItem(), buscarVenta, listadoVenta);
        nuevoCategoria = new MenuItem("Nueva Categoria");
        modificarCategoria = new MenuItem("Modificar Categoria");
        eliminarCategoria = new MenuItem("Eliminar Categoria");
        buscarCategoria = new MenuItem("Buscar Categoria");
        listadoCategoria = new MenuItem("Listado de Categorias");
        Categoria = new Menu("Categoria");
        Categoria.getItems().addAll(nuevoCategoria, modificarCategoria, eliminarCategoria, new SeparatorMenuItem(), buscarCategoria, listadoCategoria);
        nuevoProducto = new MenuItem("Nuevo Producto");
        modificarProducto = new MenuItem("Modificar Producto");
        eliminarProducto = new MenuItem("Eliminar Producto");
        buscarProducto = new MenuItem("Buscar Producto");
        listadoProducto = new MenuItem("Listado de Productos");
        Producto = new Menu("Producto");
        Producto.getItems().addAll(nuevoProducto, modificarProducto, eliminarProducto, new SeparatorMenuItem(), buscarProducto, listadoProducto);
        nuevoProveedor = new MenuItem("Nuevo Proveedor");
        modificarProveedor = new MenuItem("Modificar Proveedor");
        eliminarProveedor = new MenuItem("Eilminar Proveedor");
        buscarProveedor = new MenuItem("Buscar Proveedor");
        listadoProveedor = new MenuItem("Listado de Proveedores");
        Proveedor = new Menu("Proveedor");
        Proveedor.getItems().addAll(nuevoProveedor, modificarProveedor, eliminarProveedor, new SeparatorMenuItem(), buscarProveedor, listadoProveedor);
        nuevoCliente = new MenuItem("Nuevo Cliente");
        modificarCliente = new MenuItem("Modificar Cliente");
        eliminarCliente = new MenuItem("Eliminar Cliente");
        buscarCliente = new MenuItem("Buscar Cliente");
        listadoClientes = new MenuItem("Listado de Clientes");
        Cliente = new Menu("Cliente");
        Cliente.getItems().addAll(nuevoCliente, modificarCliente, eliminarCliente, new SeparatorMenuItem(), buscarCliente, listadoClientes);
        iniciarSesion = new MenuItem("Iniciar Sesion");
        salir = new MenuItem("Salir");
        Inicio = new Menu("Inicio");
        Inicio.getItems().addAll(iniciarSesion, salir);
        BarraMenu = new MenuBar();
        BarraMenu.getMenus().addAll(Inicio, Cliente, Proveedor, Producto, Categoria, Venta, Compra, kardex);

        pntPrincipal = new BorderPane();
        pntPrincipal.setTop(BarraMenu);
        pntPrincipal.setCenter(escritorio);
        escritorio.setBackground(new Background(new BackgroundImage(new Image("file:src\\unachkardex\\multimedia\\FondoMain.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1280, 720, false, false, false, false))));
        Scene scnPrincipal = new Scene(pntPrincipal, 1280, 720);
        primaryStage.setTitle("Sistema de facturacion");
        primaryStage.setMinHeight(720);
        primaryStage.setMinWidth(1280);
        primaryStage.setMaximized(true);
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
        iniciarSesion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane usuario = new Pane();
                usuario.getChildren().add(nInicioEventHandler(event));
                usuario.setPadding(new Insets(5));
                escritorio.getChildren().add(usuario);
            }
        });
//        iniciarSesion

//        salir
        salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                salirEventHandler(event);
            }
        });
//       Menu Cliente
//        nuevoCliente
        nuevoCliente.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane clienteNuevo = new Pane();
                clienteNuevo.getChildren().add(nClienteEventHandler(event));
                clienteNuevo.setPadding(new Insets(5));
                escritorio.getChildren().add(clienteNuevo);
            }
        });
//        modificarCliente
        modificarCliente.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane ModificarCliente = new Pane();
                ModificarCliente.getChildren().add(mClienteEventHandler(event));
                escritorio.getChildren().add(ModificarCliente);
            }
        });
//        eliminarCliente
        eliminarCliente.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane ClienteEliminar = new Pane();
                ClienteEliminar.getChildren().add(eClienteEventHandler(event));
                ClienteEliminar.setPadding(new Insets(5));
                escritorio.getChildren().add(ClienteEliminar);
            }
        });

//        buscarCliente
        buscarCliente.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane buscarClientes = new Pane();
                buscarClientes.getChildren().add(bClienteEventHandler(event));
                buscarClientes.setPadding(new Insets(5));
                escritorio.getChildren().add(buscarClientes);
            }
        });
//        listadoClientes
        listadoClientes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane listClientes = new Pane();
                listClientes.getChildren().add(lstClienteEventHandler(event));
                listClientes.setPadding(new Insets(5));
                escritorio.getChildren().add(listClientes);
            }
        });
//       Menu Proveedor
//        nuevoProveedor
        nuevoProveedor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane proveedorNuevo = new Pane();
                proveedorNuevo.getChildren().add(nProveedorEventHandler(event));
                proveedorNuevo.setPadding(new Insets(5));
                escritorio.getChildren().add(proveedorNuevo);
            }
        });
//        modificarProveedor
        modificarProveedor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane proveedorModificar = new Pane();
                proveedorModificar.getChildren().add(mProveedorEventHandler(event));
                proveedorModificar.setPadding(new Insets(5));
                escritorio.getChildren().add(proveedorModificar);
            }
        });
//        eliminarProveedor
        eliminarProveedor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane proveedorEliminar = new Pane();
                proveedorEliminar.getChildren().add(eProveedorEventHandler(event));
                proveedorEliminar.setPadding(new Insets(5));
                escritorio.getChildren().add(proveedorEliminar);
            }
        });
//        buscarProveedor
        buscarProveedor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane buscarProveedores = new Pane();
                buscarProveedores.getChildren().add(bProveedorEventHandler(event));
                buscarProveedores.setPadding(new Insets(5));
                escritorio.getChildren().add(buscarProveedores);
            }
        });
//        listadoProveedor
        listadoProveedor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane listProveedores = new Pane();
                listProveedores.getChildren().add(lstProveedorEventHandler(event));
                listProveedores.setPadding(new Insets(5));
                escritorio.getChildren().add(listProveedores);
            }
        });
//       Menu Producto
//        nuevoProducto
        nuevoProducto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane nuevoProducto = new Pane();
                nuevoProducto.getChildren().add(nProductoEventHandler(event));
                nuevoProducto.setPadding(new Insets(5));
                escritorio.getChildren().add(nuevoProducto);
            }
        });
//        modificarProducto
        modificarProducto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane modificarProducto = new Pane();
                modificarProducto.getChildren().add(mProductoEventHandler(event));
                modificarProducto.setPadding(new Insets(5));
                escritorio.getChildren().add(modificarProducto);
            }
        });
//        eliminarProducto
        eliminarProducto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane elimProductos = new Pane();
                elimProductos.getChildren().add(eliProductoEventHandler(event));
                elimProductos.setPadding(new Insets(5));
                escritorio.getChildren().add(elimProductos);
            }
        });
//        buscarProducto
        buscarProducto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane elimProductos = new Pane();
                elimProductos.getChildren().add(bsaProductoEventHandler(event));
                elimProductos.setPadding(new Insets(5));
                escritorio.getChildren().add(elimProductos);
            }
        });

//        listadoProducto
        listadoProducto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane bcarProductos = new Pane();
                bcarProductos.getChildren().add(lstProductoEventHandler(event));
                bcarProductos.setPadding(new Insets(5));
                escritorio.getChildren().add(bcarProductos);
            }
        });
//       Menu Categoria
//        nuevoCategoria
        nuevoCategoria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane nuevaCategoria = new Pane();
                nuevaCategoria.getChildren().add(nCategEventHandler(event));
                nuevaCategoria.setPadding(new Insets(5));
                escritorio.getChildren().add(nuevaCategoria);
            }
        });
//        modificarCategoria
        modificarCategoria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane modificarCategorias = new Pane();
                modificarCategorias.getChildren().add(mCategEventHandler(event));
                modificarCategorias.setPadding(new Insets(5));
                escritorio.getChildren().add(modificarCategorias);
            }
        });
//        eliminarCategoria
        eliminarCategoria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane eliminarCategorias = new Pane();
                eliminarCategorias.getChildren().add(eCategEventHandler(event));
                eliminarCategorias.setPadding(new Insets(5));
                escritorio.getChildren().add(eliminarCategorias);
            }
        });
//        buscarCategoria
        buscarCategoria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane buscarCategorias = new Pane();
                buscarCategorias.getChildren().add(bCategEventHandler(event));
                buscarCategorias.setPadding(new Insets(5));
                escritorio.getChildren().add(buscarCategorias);
            }
        });
//        listadoCategoria
        listadoCategoria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane listCategorias = new Pane();
                listCategorias.getChildren().add(lstCategEventHandler(event));
                listCategorias.setPadding(new Insets(5));
                escritorio.getChildren().add(listCategorias);
            }
        });
//       Menu Venta
//        nuevoVenta
        nuevoVenta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane nuevaVenta = new Pane();
                nuevaVenta.getChildren().add(nVentaEventHandler(event));
                nuevaVenta.setPadding(new Insets(5));
                escritorio.getChildren().add(nuevaVenta);
            }
        });
//        modificarVenta
//        eliminarVenta
//        buscarVenta
//        listadoVenta
        listadoVenta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane listVentas = new Pane();
                listVentas.getChildren().add(lstVentaEventHandler(event));
                listVentas.setPadding(new Insets(5));
                escritorio.getChildren().add(listVentas);
            }
        });
//       Menu Compra
//        nuevoCompra
        nuevoCompra.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane nuevaCompra = new Pane();
                nuevaCompra.getChildren().add(nCompraEventHandler(event));
                nuevaCompra.setPadding(new Insets(5));
                escritorio.getChildren().add(nuevaCompra);
            }
        });
//        modificarCompra
//        eliminarCompra
//        buscarCompra
//        listadoCompra
        listadoCompra.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane listCompras = new Pane();
                listCompras.getChildren().add(lstCompraEventHandler(event));
                listCompras.setPadding(new Insets(5));
                escritorio.getChildren().add(listCompras);
            }
        });
//       Menu kardex
//        kardexMensual
    kardexMensual.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane kardex = new Pane();
                kardex.getChildren().add(kardexEventHandler(event));
                kardex.setPadding(new Insets(5));
                escritorio.getChildren().add(kardex);
            }
        });
//        kardexAnual
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void btnSalirEventHandler(ActionEvent event) {
        System.exit(0);
    }

    //Metodos de las Acciones
//       Menu Inicio
//        iniciarSesion
    public VentanaInterna nInicioEventHandler(ActionEvent event) {
        BorderPane NuevoI = new BorderPane();
        Label titulo = new Label("INICIO DE SESION");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        NuevoI.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormInicioSesion clienteN = new FormInicioSesion();
        NuevoI.setCenter(clienteN.getPntPrincipal());
        //Creacion de Ventana interna
        VentanaInterna ni = new VentanaInterna();
        ni.setRoot(NuevoI);
        ni.makeDragable(bTitulo.getBarra());
        ni.makeDragable(titulo);
        ni.makeResizable(20);
        ni.makeFocusable();
        ni.setCloseButton(cerrar);
        return ni;
    }
//        salir

    public void salirEventHandler(ActionEvent event) {
        System.exit(0);
    }
//       Menu Cliente
//        nuevoCliente

    public VentanaInterna nClienteEventHandler(ActionEvent event) {
        BorderPane clienteNuevo = new BorderPane();
        Label titulo = new Label("NUEVO CLIENTE");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        clienteNuevo.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormNCliente clienteN = new FormNCliente();
        clienteNuevo.setCenter(clienteN.getPntPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nCliente = new VentanaInterna();
        nCliente.setRoot(clienteNuevo);
        nCliente.makeDragable(bTitulo.getBarra());
        nCliente.makeDragable(titulo);
        nCliente.makeResizable(20);
        nCliente.makeFocusable();
        nCliente.setCloseButton(cerrar);
        return nCliente;
    }
//        modificarCliente

    public VentanaInterna mClienteEventHandler(ActionEvent event) {
        BorderPane ClienteModificar = new BorderPane();
        Label titulo = new Label("MODIFICAR CLIENTE");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        ClienteModificar.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormMCliente Modicli = new FormMCliente();
        ClienteModificar.setCenter(Modicli.getPntPrincipal());
        //Creacion de Ventana interna
        VentanaInterna Mocliente = new VentanaInterna();
        Mocliente.setRoot(ClienteModificar);
        Mocliente.makeDragable(bTitulo.getBarra());
        Mocliente.makeDragable(titulo);
        Mocliente.makeResizable(20);
        Mocliente.makeFocusable();
        Mocliente.setCloseButton(cerrar);
        return Mocliente;
    }
//        eliminarCliente

    public VentanaInterna eClienteEventHandler(ActionEvent event) {
        BorderPane ClienteEliminar = new BorderPane();
        Label titulo = new Label("ELIMINAR CLIENTE");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        ClienteEliminar.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormECliente Buscarcli = new FormECliente();
        ClienteEliminar.setCenter(Buscarcli.getPntPrincipalP());
        //Creacion de Ventana interna
        VentanaInterna bcliente = new VentanaInterna();
        bcliente.setRoot(ClienteEliminar);
        bcliente.makeDragable(bTitulo.getBarra());
        bcliente.makeDragable(titulo);
        bcliente.makeResizable(20);
        bcliente.makeFocusable();
        bcliente.setCloseButton(cerrar);
        return bcliente;
    }
//        buscarCliente

    public VentanaInterna bClienteEventHandler(ActionEvent event) {
        BorderPane ClienteBuscar = new BorderPane();
        Label titulo = new Label("BUSCAR CLIENTE");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        ClienteBuscar.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormBCliente Buscarcli = new FormBCliente();
        ClienteBuscar.setCenter(Buscarcli.getPntPrincipalP());
        //Creacion de Ventana interna
        VentanaInterna bcliente = new VentanaInterna();
        bcliente.setRoot(ClienteBuscar);
        bcliente.makeDragable(bTitulo.getBarra());
        bcliente.makeDragable(titulo);
        bcliente.makeResizable(20);
        bcliente.makeFocusable();
        bcliente.setCloseButton(cerrar);
        return bcliente;

    }

//        listadoClientes
    public VentanaInterna lstClienteEventHandler(ActionEvent event) {
        BorderPane listadoClientes = new BorderPane();
        Label titulo = new Label("LISTA CLIENTES");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        listadoClientes.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormListCliente clientesListado = new FormListCliente();
        listadoClientes.setCenter(clientesListado.getPantallaP());
        //Creacion de Ventana interna
        VentanaInterna lstClientes = new VentanaInterna();
        lstClientes.setRoot(listadoClientes);
        lstClientes.makeDragable(bTitulo.getBarra());
        lstClientes.makeDragable(titulo);
        lstClientes.makeResizable(20);
        lstClientes.makeFocusable();
        lstClientes.setCloseButton(cerrar);
        return lstClientes;
    }
//       Menu Proveedor
//        nuevoProveedor

    public VentanaInterna nProveedorEventHandler(ActionEvent event) {
        BorderPane ProveedorNuevo = new BorderPane();
        Label titulo = new Label("NUEVO PROVEEDOR");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        ProveedorNuevo.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormNProveedor NuevoProv = new FormNProveedor();
        ProveedorNuevo.setCenter(NuevoProv.getPntPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nProveedor = new VentanaInterna();
        nProveedor.setRoot(ProveedorNuevo);
        nProveedor.makeDragable(bTitulo.getBarra());
        nProveedor.makeDragable(titulo);
        nProveedor.makeResizable(20);
        nProveedor.makeFocusable();
        nProveedor.setCloseButton(cerrar);
        return nProveedor;
    }
//        modificarProveedor

    public VentanaInterna mProveedorEventHandler(ActionEvent event) {
        BorderPane ProveedorModificar = new BorderPane();
        Label titulo = new Label("MODIFICAR PROVEEDOR");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        ProveedorModificar.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormMProveedor ModificarProv = new FormMProveedor();
        ProveedorModificar.setCenter(ModificarProv.getPntPrincipal());
        //Creacion de Ventana interna
        VentanaInterna mProveedor = new VentanaInterna();
        mProveedor.setRoot(ProveedorModificar);
        mProveedor.makeDragable(bTitulo.getBarra());
        mProveedor.makeDragable(titulo);
        mProveedor.makeResizable(20);
        mProveedor.makeFocusable();
        mProveedor.setCloseButton(cerrar);
        return mProveedor;
    }
//        eliminarProveedor

    public VentanaInterna eProveedorEventHandler(ActionEvent event) {
        BorderPane ProveedorEliminar = new BorderPane();
        Label titulo = new Label("ELIMINAR PROVEEDOR");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        ProveedorEliminar.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormEProveedor EliminarProv = new FormEProveedor();
        ProveedorEliminar.setCenter(EliminarProv.getPntPrincipal());
        //Creacion de Ventana interna
        VentanaInterna eProveedor = new VentanaInterna();
        eProveedor.setRoot(ProveedorEliminar);
        eProveedor.makeDragable(bTitulo.getBarra());
        eProveedor.makeDragable(titulo);
        eProveedor.makeResizable(20);
        eProveedor.makeFocusable();
        eProveedor.setCloseButton(cerrar);
        return eProveedor;
    }
//        buscarProveedor

    public VentanaInterna bProveedorEventHandler(ActionEvent event) {
        BorderPane ProveedorBuscar = new BorderPane();
        Label titulo = new Label("BUSCAR PROVEEDOR");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        ProveedorBuscar.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormBProveedor BuscarProv = new FormBProveedor();
        ProveedorBuscar.setCenter(BuscarProv.getPntPrincipal());
        //Creacion de Ventana interna
        VentanaInterna bProveedor = new VentanaInterna();
        bProveedor.setRoot(ProveedorBuscar);
        bProveedor.makeDragable(bTitulo.getBarra());
        bProveedor.makeDragable(titulo);
        bProveedor.makeResizable(20);
        bProveedor.makeFocusable();
        bProveedor.setCloseButton(cerrar);
        return bProveedor;
    }
//        listadoProveedor

    public VentanaInterna lstProveedorEventHandler(ActionEvent event) {
        BorderPane listadoProveedores = new BorderPane();
        Label titulo = new Label("LISTA PROVEEDORES");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        listadoProveedores.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormListProveedor proveedorListado = new FormListProveedor();
        listadoProveedores.setCenter(proveedorListado.getPantallaP());
        //Creacion de Ventana interna
        VentanaInterna lstProveedores = new VentanaInterna();
        lstProveedores.setRoot(listadoProveedores);
        lstProveedores.makeDragable(bTitulo.getBarra());
        lstProveedores.makeDragable(titulo);
        lstProveedores.makeResizable(20);
        lstProveedores.makeFocusable();
        lstProveedores.setCloseButton(cerrar);
        return lstProveedores;
    }
//       Menu Producto
//        nuevoProducto

    public VentanaInterna nProductoEventHandler(ActionEvent event) {
        BorderPane productoNuevo = new BorderPane();
        Label titulo = new Label("NUEVO PRODUCTO");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        productoNuevo.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormNProducto productoN = new FormNProducto();
        productoNuevo.setCenter(productoN.getPantallaP());
        //Creacion de Ventana interna
        VentanaInterna nProducto = new VentanaInterna();
        nProducto.setRoot(productoNuevo);
        nProducto.makeDragable(bTitulo.getBarra());
        nProducto.makeDragable(titulo);
        nProducto.makeResizable(20);
        nProducto.makeFocusable();
        nProducto.setCloseButton(cerrar);
        return nProducto;
    }
//        modificarProducto

    public VentanaInterna mProductoEventHandler(ActionEvent event) {
        BorderPane modProductos = new BorderPane();
        Label titulo = new Label("MODIFICAR PRODUCTO");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        modProductos.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormMProducto productosM = new FormMProducto();
        modProductos.setCenter(productosM.getPntPrincipal());
        //Creacion de Ventana interna
        VentanaInterna MDProductos = new VentanaInterna();
        MDProductos.setRoot(modProductos);
        MDProductos.makeDragable(bTitulo.getBarra());
        MDProductos.makeDragable(titulo);
        MDProductos.makeResizable(20);
        MDProductos.makeFocusable();
        MDProductos.setCloseButton(cerrar);
        return MDProductos;
    }
//        eliminarProducto

    public VentanaInterna eliProductoEventHandler(ActionEvent event) {
        BorderPane elimProductos = new BorderPane();
        Label titulo = new Label("ELIMINAR PRODUCTO");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        elimProductos.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormEProducto productosList = new FormEProducto();
        elimProductos.setCenter(productosList.getPantallaP());
        //Creacion de Ventana interna
        VentanaInterna eliProductos = new VentanaInterna();
        eliProductos.setRoot(elimProductos);
        eliProductos.makeDragable(bTitulo.getBarra());
        eliProductos.makeDragable(titulo);
        eliProductos.makeResizable(20);
        eliProductos.makeFocusable();
        eliProductos.setCloseButton(cerrar);
        return eliProductos;
    }
//        buscarProducto

    public VentanaInterna bsaProductoEventHandler(ActionEvent event) {
        BorderPane busquedaProductos = new BorderPane();
        Label titulo = new Label("NUEVO PRODUCTO");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        busquedaProductos.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormBProducto productosBsc = new FormBProducto();
        busquedaProductos.setCenter(productosBsc.getPntPrincipalP());
        //Creacion de Ventana interna
        VentanaInterna busProductos = new VentanaInterna();
        busProductos.setRoot(busquedaProductos);
        busProductos.makeDragable(bTitulo.getBarra());
        busProductos.makeDragable(titulo);
        busProductos.makeResizable(20);
        busProductos.makeFocusable();
        busProductos.setCloseButton(cerrar);
        return busProductos;
    }
//        listadoProducto

    public VentanaInterna lstProductoEventHandler(ActionEvent event) {
        BorderPane listadoProductos = new BorderPane();
        Label titulo = new Label("LISTA DE PRODUCTOS");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        listadoProductos.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormListProducto productosList = new FormListProducto();
        listadoProductos.setCenter(productosList.getPantallaP());
        //Creacion de Ventana interna
        VentanaInterna lstProductos = new VentanaInterna();
        lstProductos.setRoot(listadoProductos);
        lstProductos.makeDragable(bTitulo.getBarra());
        lstProductos.makeDragable(titulo);
        lstProductos.makeResizable(20);
        lstProductos.makeFocusable();
        lstProductos.setCloseButton(cerrar);
        return lstProductos;
    }
//       Menu Categoria
//        nuevoCategoria

    public VentanaInterna nCategEventHandler(ActionEvent event) {
        BorderPane categNueva = new BorderPane();
        Label titulo = new Label("NUEVA CATEGORIA");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        categNueva.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormNCategoria categoriaNueva = new FormNCategoria();
        categNueva.setCenter(categoriaNueva.getPantallaP());
        //Creacion de Ventana interna
        VentanaInterna nCateg = new VentanaInterna();
        nCateg.setRoot(categNueva);
        nCateg.makeDragable(bTitulo.getBarra());
        nCateg.makeDragable(titulo);
        nCateg.makeResizable(20);
        nCateg.makeFocusable();
        nCateg.setCloseButton(cerrar);
        return nCateg;
    }
//        modificarCategoria

    public VentanaInterna mCategEventHandler(ActionEvent event) {
        BorderPane modiCategorias = new BorderPane();
        Label titulo = new Label("MODIFICAR CATEGORIA");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        modiCategorias.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormMCategorias categoriaModificar = new FormMCategorias();
        modiCategorias.setCenter(categoriaModificar.getPntPrincipal());
        //Creacion de Ventana interna
        VentanaInterna modifCategorias = new VentanaInterna();
        modifCategorias.setRoot(modiCategorias);
        modifCategorias.makeDragable(bTitulo.getBarra());
        modifCategorias.makeDragable(titulo);
        modifCategorias.makeResizable(20);
        modifCategorias.makeFocusable();
        modifCategorias.setCloseButton(cerrar);
        return modifCategorias;
    }
//        eliminarCategoria

    public VentanaInterna eCategEventHandler(ActionEvent event) {
        BorderPane eliCategorias = new BorderPane();
        Label titulo = new Label("ELIMINAR CATEGORIA");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        eliCategorias.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormECategorias categoriaEliminar = new FormECategorias();
        eliCategorias.setCenter(categoriaEliminar.getPntPrincipal());
        //Creacion de Ventana interna
        VentanaInterna elimCategorias = new VentanaInterna();
        elimCategorias.setRoot(eliCategorias);
        elimCategorias.makeDragable(bTitulo.getBarra());
        elimCategorias.makeDragable(titulo);
        elimCategorias.makeResizable(20);
        elimCategorias.makeFocusable();
        elimCategorias.setCloseButton(cerrar);
        return elimCategorias;
    }
//        buscarCategoria

    public VentanaInterna bCategEventHandler(ActionEvent event) {
        BorderPane buscarCategorias = new BorderPane();
        Label titulo = new Label("BUSCAR CATEGORIA");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        buscarCategorias.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormBCategorias categoriaBuscar = new FormBCategorias();
        buscarCategorias.setCenter(categoriaBuscar.getPntPrincipal());
        //Creacion de Ventana interna
        VentanaInterna bscCategorias = new VentanaInterna();
        bscCategorias.setRoot(buscarCategorias);
        bscCategorias.makeDragable(bTitulo.getBarra());
        bscCategorias.makeDragable(titulo);
        bscCategorias.makeResizable(20);
        bscCategorias.makeFocusable();
        bscCategorias.setCloseButton(cerrar);
        return bscCategorias;
    }

//        listadoCategoria
    public VentanaInterna lstCategEventHandler(ActionEvent event) {
        BorderPane listadoCategorias = new BorderPane();
        Label titulo = new Label("LLISTA CATEGORIA");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        listadoCategorias.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormListCategoria categoriaListado = new FormListCategoria();
        listadoCategorias.setCenter(categoriaListado.getPantallaP());
        //Creacion de Ventana interna
        VentanaInterna lstCategorias = new VentanaInterna();
        lstCategorias.setRoot(listadoCategorias);
        lstCategorias.makeDragable(bTitulo.getBarra());
        lstCategorias.makeDragable(titulo);
        lstCategorias.makeResizable(20);
        lstCategorias.makeFocusable();
        lstCategorias.setCloseButton(cerrar);
        return lstCategorias;
    }

//       Menu Venta
//        nuevoVenta
    public VentanaInterna nVentaEventHandler(ActionEvent event) {
        BorderPane ventaNueva = new BorderPane();
        Label titulo = new Label("NUEVA VENTA");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        ventaNueva.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormNFacturaVenta facturaVN = new FormNFacturaVenta();
        ventaNueva.setCenter(facturaVN.getPantallaP());
        //Creacion de Ventana interna
        VentanaInterna nFacturaV = new VentanaInterna();
        nFacturaV.setRoot(ventaNueva);
        nFacturaV.makeDragable(bTitulo.getBarra());
        nFacturaV.makeDragable(titulo);
        nFacturaV.makeResizable(20);
        nFacturaV.makeFocusable();
        nFacturaV.setCloseButton(cerrar);
        return nFacturaV;
    }

    public VentanaInterna lstVentaEventHandler(ActionEvent event) {
        BorderPane listadoVentas = new BorderPane();
        Label titulo = new Label("LISTA CATEGORIA");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        listadoVentas.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormListFacturaVenta facturasVentas = new FormListFacturaVenta();
        listadoVentas.setCenter(facturasVentas.getPantallaP());
        //Creacion de Ventana interna
        VentanaInterna lstFacturasVenta = new VentanaInterna();
        lstFacturasVenta.setRoot(listadoVentas);
        lstFacturasVenta.makeDragable(bTitulo.getBarra());
        lstFacturasVenta.makeDragable(titulo);
        lstFacturasVenta.makeResizable(20);
        lstFacturasVenta.makeFocusable();
        lstFacturasVenta.setCloseButton(cerrar);
        return lstFacturasVenta;
    }
//       Menu Compra
//        nuevoCompra

    public VentanaInterna nCompraEventHandler(ActionEvent event) {
        BorderPane compraNueva = new BorderPane();
        Label titulo = new Label("NUEVA COMPRA");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        compraNueva.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormNFacturaCompra facturaCN = new FormNFacturaCompra();
        compraNueva.setCenter(facturaCN.getPantallaP());
        //Creacion de Ventana interna
        VentanaInterna nfacturaC = new VentanaInterna();
        nfacturaC.setRoot(compraNueva);
        nfacturaC.makeDragable(bTitulo.getBarra());
        nfacturaC.makeDragable(titulo);
        nfacturaC.makeResizable(20);
        nfacturaC.makeFocusable();
        nfacturaC.setCloseButton(cerrar);
        return nfacturaC;
    }

    public VentanaInterna lstCompraEventHandler(ActionEvent event) {
        BorderPane lstCompras = new BorderPane();
        Label titulo = new Label("LISTA COMPRAS");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        lstCompras.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormListFacturaCompra lstFactC = new FormListFacturaCompra();
        lstCompras.setCenter(lstFactC.getPantallaP());
        //Creacion de Ventana interna
        VentanaInterna lstFactCompras = new VentanaInterna();
        lstFactCompras.setRoot(lstCompras);
        lstFactCompras.makeDragable(bTitulo.getBarra());
        lstFactCompras.makeDragable(titulo);
        lstFactCompras.makeResizable(20);
        lstFactCompras.makeFocusable();
        lstFactCompras.setCloseButton(cerrar);
        return lstFactCompras;
    }
//       Menu kardex
//        kardexMensual
    public VentanaInterna kardexEventHandler(ActionEvent event){
        BorderPane kardex = new BorderPane();
        Label titulo = new Label("KARDEX MENSUAL");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        kardex.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormListKardex KardexM = new FormListKardex();
        kardex.setCenter(KardexM.getPnlPrincipal());
        //Creacion de Ventana interna
        VentanaInterna lstFactCompras = new VentanaInterna();
        lstFactCompras.setRoot(kardex);
        lstFactCompras.makeDragable(bTitulo.getBarra());
        lstFactCompras.makeDragable(titulo);
        lstFactCompras.makeResizable(20);
        lstFactCompras.makeFocusable();
        lstFactCompras.setCloseButton(cerrar);
        return lstFactCompras;
    }
//        kardexAnual
}
