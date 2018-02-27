/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao.rnegocio.vistas.formularios;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.plaf.synth.ColorType;

/**
 *
 * @author acer1
 */
public class frmPrincipal{

    static AnchorPane root;
    static BorderPane contenedor;
    private static Stage stage;

    public void start() throws Exception {
        contenedor = new BorderPane();
        contenedor.setTop(menuBar());
        contenedor.setLeft(panelIzquierdo());
        AnchorPane.setTopAnchor(contenedor, 0.0);
        AnchorPane.setRightAnchor(contenedor, 0.0);
        AnchorPane.setBottomAnchor(contenedor, 0.0);
        AnchorPane.setLeftAnchor(contenedor, 0.0);

        root = new AnchorPane();
        root.getChildren().add(contenedor);
        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().addAll(this.getClass().getResource("estilos/Principal.css").toExternalForm());
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("FACT");
        stage.getIcons().add(new Image(getClass().getResource("../img/Icono.png").toExternalForm()));
        stage.show();
    }

    public MenuBar menuBar() {
        MenuBar MBar = new MenuBar();
        {
//            Menu menuLogo = new Menu();
//            {
//                ImageView icono = new ImageView(new Image(getClass().getResourceAsStream("../imagenes/Icono.png")));
//                icono.setFitHeight(20);
//                icono.setFitWidth(20);
//                menuLogo.setGraphic(icono);
//
//            }

            /*Menu menuArchivo = new Menu("Archivo");
            {
                MenuItem itemEmpleado = new MenuItem("Empleado\t\t");
                itemEmpleado.setOnAction((t) -> {
                    empleado.launchTablas();
                });
                MenuItem itemCliente = new MenuItem("Cliente");
                itemCliente.setOnAction((t) -> {
                    cliente.launchTablas();
                });
                MenuItem itemCategoria = new MenuItem("Categoria");
                itemCategoria.setOnAction((t) -> {
                    categoria.launchTablas();
                });
                MenuItem itemProducto = new MenuItem("Producto");
                itemProducto.setOnAction((t) -> {
                    producto.launchTablas();
                });
                MenuItem itemFactura = new MenuItem("Factúra");
                menuArchivo.getItems().addAll(itemCategoria, itemCliente, itemEmpleado, itemFactura, itemProducto);
            }
            MBar.getMenus().addAll(menuArchivo);}*/
        }

        return MBar;
    }

    private static VBox panelIzquierdo() {
        VBox panel = new VBox(15);

        {
            JFXButton btnCliente = new JFXButton("Clientes");
            //btnCliente.setOnAction(btnClienteActionListener());
            JFXButton btnEmpleado = new JFXButton("Empleados");
            //btnEmpleado.setOnAction(btnEmpleadoActionListener());
            JFXButton btnProducto = new JFXButton("Productos");
            //btnProducto.setOnAction(btnProductoActionListener());
            JFXButton btnFactura = new JFXButton("Factúra");
            //btnFactura.setOnAction(btnfacturaActionListener());
            JFXButton btnCategoria = new JFXButton("Categoría");
            //btnCategoria.setOnAction(btnCategoriaActionListener());
            JFXButton btnReportes = new JFXButton("Reportes");
            //btnReportes.setOnAction(btnReportesActionListener());
            panel.getStyleClass().add("panel_izquierdo");
            panel.getChildren().addAll(btnCategoria, btnCliente, btnEmpleado, btnFactura, btnProducto,btnReportes);
        }
        return panel;
    }

    /**
     * *************************************************************************
     *                                                                         *
     * IMPLEMENTACION DE LOS EVETOS * *
     * *************************************************************************
     */
    /*public static EventHandler btnClienteActionListener() {
        EventHandler handler = (t) -> {
            cliente.formDatos(root, contenedor);
            cliente.formTablas(contenedor);
        };
        return handler;
    }

    public static EventHandler btnEmpleadoActionListener() {
        EventHandler handler = (t) -> {
            empleado.formDatos(root, contenedor);
            empleado.formTablas(contenedor);
        };
        return handler;
    }

    public static EventHandler btnfacturaActionListener() {
        EventHandler handler = (t) -> {
            IFactura sqlFactura = new FacturaImp();
            factura.formFacturacion(contenedor);
            factura.setEmpleado(cedulaEmpleado);
            try {
                factura.setNumeroFactura(sqlFactura.numero());
            } catch (Exception e) {
            }

            factura.formDatos(root, contenedor);

        };
        return handler;
    }

    public static EventHandler btnCategoriaActionListener() {
        EventHandler handler = (t) -> {
            categoria.formDatos(root, contenedor);
            categoria.formTablas(contenedor);
        };
        return handler;
    }

    public static EventHandler btnProductoActionListener() {
        EventHandler handler = (t) -> {
            producto.formDatos(root, contenedor);
            producto.formTablas(contenedor);
        };
        return handler;
    }
    private static EventHandler<ActionEvent> btnReportesActionListener(){
        EventHandler handler = (t) -> {
            try {
                frmReportes reportes = new frmReportes();
                reportes.formInsertar(root);
            } catch (Exception ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        return handler;
    }*/
}