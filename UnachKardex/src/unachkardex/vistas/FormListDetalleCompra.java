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

public class FormListDetalleCompra extends Application {
    private TableView<DetalleCompra> tblDetalleCompra;
    private Label titulo;
    private TableColumn<DetalleCompra, Integer> cmlcodDetalleCompra;
    private TableColumn<DetalleCompra, Producto> cmlProducto;
    private TableColumn<DetalleCompra, FacturaCompra> cmlfacturaCompra;
    private TableColumn<DetalleCompra, Integer> cmlCantidad;
    private TableColumn<DetalleCompra, Double> cmlprecioTotal;
    private VBox pntPrincipal;
    
    @Override
    public void start(Stage primaryStage) {
        titulo = new Label("LISTADO DE DETALLE COMPRA");
        titulo.setFont(Font.font("CHILLER", 30));
        tblDetalleCompra = new TableView();
        
        cmlcodDetalleCompra = new TableColumn<>("Codigo Detalle_Compra");
        cmlProducto= new TableColumn<>("Producto");
        cmlfacturaCompra = new TableColumn<>("Codigo Factura_Compra");
        cmlCantidad = new TableColumn<>("Cantidad");
        cmlprecioTotal = new TableColumn<>("Precio_Total");
       
        tblDetalleCompra.getColumns().addAll(cmlcodDetalleCompra, cmlProducto, cmlfacturaCompra,cmlCantidad,cmlprecioTotal);
        cargarDetalleCompra();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblDetalleCompra);
        pntPrincipal.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pntPrincipal, 425, 250);

        primaryStage.setTitle("Listado de Detalle Compra");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void cargarDetalleCompra() {
        List<DetalleCompra> listDC = new ArrayList<>();
        IDetalleCompra dcDao = new ImplDetalleCompra();

        try {
            listDC = dcDao.obtener();
           
            cmlcodDetalleCompra.setCellValueFactory(new PropertyValueFactory<>("codDetalleCompra"));
            cmlProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
            cmlfacturaCompra.setCellValueFactory(new PropertyValueFactory<>("facturaCompra"));
            cmlCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
            cmlprecioTotal.setCellValueFactory(new PropertyValueFactory<>("precioTotal"));
            
            tblDetalleCompra.getItems().addAll(listDC);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
