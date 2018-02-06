package unachkardex.vistas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.cell.PropertyValueFactory;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;

public class FormListDetalleVenta extends Application {

    private TableView<DetalleVenta> tblDetalleVenta;
    private Label titutlo;
    private TableColumn<DetalleVenta, Integer> cmlCodDV;
    private TableColumn<DetalleVenta, Producto> cmlProducto;
    private TableColumn<DetalleVenta, FacturaVenta> cmlFacV;
    private TableColumn<DetalleVenta, Integer> cmlCantidad;
    private TableColumn<DetalleVenta, Double> cmlPrecioT;
    private VBox pntPrincipal;

    @Override
    public void start(Stage primaryStage) {

        titutlo = new Label("LISTADO DETALLE VENTA");
        tblDetalleVenta = new TableView();
        cmlCodDV = new TableColumn<>("CODIGO DETALLE VENTA");
        cmlProducto = new TableColumn<>("PRODUCTO");
        cmlFacV = new TableColumn<>("FACTURA VENTA");
        cmlCantidad = new TableColumn<>("CANTIDAD");
        cmlPrecioT = new TableColumn<>("PRECIO TOTAL");

        tblDetalleVenta.getColumns().addAll(cmlCodDV, cmlProducto, cmlFacV, cmlCantidad, cmlPrecioT);
        cargarDetalleVenta();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titutlo, tblDetalleVenta);
        pntPrincipal.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pntPrincipal, 820, 650);

        primaryStage.setTitle("Listado Detalles Ventas");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void cargarDetalleVenta(){
     List<DetalleVenta> listDV = new ArrayList<>();
     IDetalleVenta dvDao = new ImplDetalleVenta();
     
     
        try {
            listDV = dvDao.obtener();
            cmlCodDV.setCellValueFactory(new PropertyValueFactory<>("codDetalleVenta"));
            cmlProducto.setCellValueFactory(new PropertyValueFactory<>("codProducto"));
            cmlFacV.setCellValueFactory(new PropertyValueFactory<>("codFacturaVenta"));
            cmlCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
            cmlPrecioT.setCellValueFactory(new PropertyValueFactory<>("precioTotal"));
            
            tblDetalleVenta.getItems().addAll(listDV);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
            
        }
        
    }
}
