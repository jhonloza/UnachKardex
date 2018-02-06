
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
public class FormListFacturaVenta extends Application {
    private TableView<FacturaVenta> tblFacturaVenta;
    private Label titulo;
    private TableColumn<FacturaVenta, Integer> cmlcodFacturaVenta;
    private TableColumn<FacturaVenta, String> cmlFecha;
    private TableColumn<FacturaVenta, Cliente> cmlCliente;
    
    private VBox pntPrincipal;
    @Override
    public void start(Stage primaryStage) {
         titulo = new Label("LISTADO DE FACTURA VENTA");
        titulo.setFont(Font.font("CHILLER", 30));
        tblFacturaVenta = new TableView();
        cmlcodFacturaVenta = new TableColumn<>("Codigo Fac_Vent");
        cmlFecha= new TableColumn<>("Fecha");
        cmlCliente = new TableColumn<>("Cliente");
       
        tblFacturaVenta.getColumns().addAll(cmlcodFacturaVenta, cmlFecha, cmlCliente);
        cargarFacturaVenta();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblFacturaVenta);
        pntPrincipal.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pntPrincipal, 425, 250);

        primaryStage.setTitle("Listado de Factura Ventas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void cargarFacturaVenta() {
        List<FacturaVenta> listFV = new ArrayList<>();
        IFacturaVenta fvDao = new ImplFacturaVenta();

        try {
            listFV = fvDao.obtener();
            cmlcodFacturaVenta.setCellValueFactory(new PropertyValueFactory<>("codFacturaVenta"));
            cmlFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
            cmlCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
            
            tblFacturaVenta.getItems().addAll(listFV);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
