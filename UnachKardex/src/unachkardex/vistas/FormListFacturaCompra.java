
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

public class FormListFacturaCompra extends Application {
    private TableView<FacturaCompra> tblFacturaCompra;
    private Label titulo;
    private TableColumn<FacturaCompra, Integer> cmlcodFacturaCompra;
    private TableColumn<FacturaCompra, String> cmlFecha;
    private TableColumn<FacturaCompra, Proveedor> cmlProveedor;
    
    private VBox pntPrincipal;
    @Override
    public void start(Stage primaryStage) {
         titulo = new Label("LISTADO DE FACTURA COMPRA");
        titulo.setFont(Font.font("CHILLER", 30));
        tblFacturaCompra = new TableView();
        cmlcodFacturaCompra = new TableColumn<>("Codigo Fac_Com");
        cmlFecha= new TableColumn<>("Fecha");
        cmlProveedor = new TableColumn<>("Proveedor");
       
        tblFacturaCompra.getColumns().addAll(cmlcodFacturaCompra, cmlFecha, cmlProveedor);
        cargarFacturaCompra();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblFacturaCompra);
        pntPrincipal.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pntPrincipal, 425, 250);

        primaryStage.setTitle("Listado de Factura Compra");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void cargarFacturaCompra() {
        List<FacturaCompra> listFV = new ArrayList<>();
        IFacturaCompra fvDao = new ImplFacturaCompra();

        try {
            listFV = fvDao.obtener();
            cmlcodFacturaCompra.setCellValueFactory(new PropertyValueFactory<>("codFacturaCompra"));
            cmlFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
            cmlProveedor.setCellValueFactory(new PropertyValueFactory<>("proveedor"));
            
            tblFacturaCompra.getItems().addAll(listFV);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
