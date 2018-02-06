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

public class FormListProducto extends Application {

    private TableView<Producto> tblProducto;
    private Label titulo;
    private TableColumn<Producto, Integer> cmlCodProducto;
    private TableColumn<Producto, Categoria> cmlCategoria;
    private TableColumn<Producto, String> cmlNombre;
    private TableColumn<Producto, Double> cmprecio;
    private VBox pntPrincipal;

    @Override

    public void start(Stage primaryStage) {

        titulo = new Label("LISTADO DE PRODUCTOS");
        titulo.setFont(Font.font("ALGERIAN", 25));
        tblProducto = new TableView();
        cmlCodProducto = new TableColumn<>("CODIGO DE PRODUCTO");
        cmlCategoria = new TableColumn<>("CATEGORIA");
        cmlNombre = new TableColumn<>("Nombre");
        cmprecio = new TableColumn<>("PRECIO");
        tblProducto.getColumns().addAll(cmlCodProducto, cmlCategoria, cmlNombre, cmprecio);
        cargarProducto();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblProducto);
        pntPrincipal.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pntPrincipal, 425, 250);

        primaryStage.setTitle("Listado de Proveedores.");
        primaryStage.setScene(scene);
        primaryStage.show();
        

    }
    public static void main(String[] args) {
        launch(args);
    }
    
    public void cargarProducto() {
        List<Producto> listProducto = new ArrayList<>();
        IProducto proDao = new ImplProducto();

        try {
            listProducto = proDao.obtener();
            cmlCodProducto.setCellValueFactory(new PropertyValueFactory<>("CODIGO DE PRODUCTO"));
            cmlCategoria.setCellValueFactory(new PropertyValueFactory<>("CATEGORIA"));
            cmlNombre.setCellValueFactory(new PropertyValueFactory<>("NOMBRE"));
            cmprecio.setCellValueFactory(new PropertyValueFactory<>("PRECIO"));
            tblProducto.getItems().addAll(listProducto);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
    

}
