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
    private Label titulo;
    private TableColumn<DetalleVenta, Integer> codDetalleVenta;
    private TableColumn<DetalleVenta, Producto> cmlProducto;
    private TableColumn<DetalleVenta, FacturaVenta> cmlfacturaVenta;
    private TableColumn<DetalleVenta, Integer> cmlCantidad;
    private TableColumn<DetalleVenta, Double> cmlprecioTotal;
    private VBox pntPrincipal;

    @Override
    public void start(Stage primaryStage) {
        titulo = new Label("LISTADO DE DETALLE VENTA");
        titulo.setFont(Font.font("CHILLER", 30));
        tblDetalleVenta = new TableView();
        
        codDetalleVenta = new TableColumn<>("Codigo Detalle_Venta");
        cmlProducto= new TableColumn<>("Producto");
        cmlfacturaVenta = new TableColumn<>("Codigo Factura_Venta");
        cmlCantidad = new TableColumn<>("Cantidad");
        cmlprecioTotal = new TableColumn<>("Precio_Total");
       
        codDetalleVenta.getColumns().addAll(codDetalleVenta, cmlProducto, cmlfacturaVenta,cmlCantidad,cmlprecioTotal);
        cargarDetalleVenta();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblDetalleVenta);
        pntPrincipal.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pntPrincipal, 425, 250);

        primaryStage.setTitle("Listado de Detalle Venta");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void cargarDetalleVenta() {
        List<DetalleVenta> listDV = new ArrayList<>();
        IDetalleVenta dcDao = new ImplDetalleVenta();

        try {
            listDV = dcDao.obtener();
           
            codDetalleVenta.setCellValueFactory(new PropertyValueFactory<>("codDetalleVenta"));
            cmlProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
            cmlfacturaVenta.setCellValueFactory(new PropertyValueFactory<>("facturaCompra"));
            cmlCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
            cmlprecioTotal.setCellValueFactory(new PropertyValueFactory<>("precioTotal"));
            
            tblDetalleVenta.getItems().addAll(listDV);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
