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
import javafx.scene.control.cell.*;
import javafx.stage.*;
import javafx.scene.image.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;

public class FormListProducto{

    private TableView<Producto> tblProducto;
    private Label titulo;
    private TableColumn<Producto, Integer> cmlCodProducto;
    private TableColumn<Producto, Categoria> cmlcodCategoria;
    private TableColumn<Producto, String> cmlNombre;
    private TableColumn<Producto, Double> cmprecio;
    private VBox pntPrincipal;

    

    public FormListProducto () {

        titulo = new Label("LISTADO DE PRODUCTOS");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 30));
        tblProducto = new TableView();
        cmlCodProducto = new TableColumn<>("Codigo Producto");
        cmlcodCategoria = new TableColumn<>("Categoria");
        cmlNombre = new TableColumn<>("Nombre");
        cmprecio = new TableColumn<>("Precio");
        tblProducto.getColumns().addAll(cmlCodProducto, cmlcodCategoria, cmlNombre, cmprecio);
        cargarProducto();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblProducto);
        pntPrincipal.setAlignment(Pos.CENTER);

    }
    public Node getPantallaP() {
        return pntPrincipal;
    }
    
    public void cargarProducto() {
        List<Producto> listProducto = new ArrayList<>();
        IProducto proDao = new ImplProducto();

        try {
            listProducto = proDao.obtener();
            cmlCodProducto.setCellValueFactory(new PropertyValueFactory<>("codProducto"));
            cmlcodCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
            cmlNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            cmprecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
            tblProducto.getItems().addAll(listProducto);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
    

}
