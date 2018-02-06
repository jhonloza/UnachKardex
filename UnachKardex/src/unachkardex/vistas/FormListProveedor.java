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


public class FormListProveedor extends Application {
   
    
    private TableView<Proveedor> tblProveedor;
    private Label titulo;
    private TableColumn<Proveedor, Integer> cmlRuc;
    private TableColumn<Proveedor, String> cmlNombre;
    private TableColumn<Proveedor, String> cmlDireccion;
    private TableColumn<Proveedor, String> cmlTelefono;
    private TableColumn<Proveedor, String> cmlEmail;
    private VBox pntPrincipal;
    
    @Override
    public void start(Stage primaryStage) {
        
        titulo = new Label("LISTADO DE PROVEEDORES");
        titulo.setFont(Font.font("ALGERIAN", 25));
        tblProveedor = new TableView();
        cmlRuc = new TableColumn<>("Ruc");
        cmlNombre = new TableColumn<>("Nombre");
        cmlDireccion = new TableColumn<>("Direccion");
        cmlDireccion.setMaxWidth(250);
        cmlDireccion.setMinWidth(250);
        cmlTelefono = new TableColumn<>("Telefono");
        cmlEmail = new TableColumn<>("eMail");
        cmlEmail.setMaxWidth(250);
        cmlEmail.setMinWidth(250);
        tblProveedor.getColumns().addAll(cmlRuc, cmlNombre, cmlDireccion,cmlTelefono,cmlEmail);
        cargarProveedor();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblProveedor);
        pntPrincipal.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pntPrincipal, 425, 250);

        primaryStage.setTitle("Listado de Proveedores.");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void cargarProveedor() {
        List<Proveedor> listProveedor = new ArrayList<>();
        IProveedor proDao = new ImplProveedor();

        try {
            listProveedor = proDao.obtener();
            cmlRuc.setCellValueFactory(new PropertyValueFactory<>("Ruc"));
            cmlNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
            cmlDireccion.setCellValueFactory(new PropertyValueFactory<>("Direccion"));
            cmlTelefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
            cmlEmail.setCellValueFactory(new PropertyValueFactory<>("eMail"));
            tblProveedor.getItems().addAll(listProveedor);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
