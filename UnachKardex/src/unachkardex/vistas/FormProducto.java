package unachkardex.vistas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.MessageFormat;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import unachkardex.negocio.dao.ICategoria;
import unachkardex.negocio.entidades.Categoria;
import unachkardex.negocio.impl.ImplCategoria;
public class FormProducto extends Application {
    
    private Text txtCodigo;
    private Text txtCategoria;
    private Text txtNombre;
    private Text txtPrecio;
    
    private TextArea codigo;
    private TextArea nombre;
    private TextArea precio;
    private TextArea descrCategoria;
    
    private ComboBox<Categoria> listCategorias;
    ArrayList<Categoria> lstCateg;
    
    private Button btnAceptar;
    private Button btnModificar;
    private Button btnEliminar;
    private Button btnLimpiar;
    private Button btnCancelar;
    
    private VBox pnlProducto;
    private VBox pnlCategoria;
    private GridPane pnlCentral;
    private GridPane pnlBotones;
    private GridPane pnlPrincipal;
    
    
    @Override
    public void start(Stage primaryStage) {
        txtCodigo=new Text("Codigo");
        txtCodigo.setFont(javafx.scene.text.Font.font("Arial Black",10));
        codigo=new TextArea("");
        txtNombre=new Text("Nombre");
        txtNombre.setFont(javafx.scene.text.Font.font("Callibri",15));
        nombre=new TextArea("");
        txtPrecio=new Text("Precio");
        txtPrecio.setFont(javafx.scene.text.Font.font("Times New Roman",10));
        precio=new TextArea("");
        
        txtCategoria=new Text("Categoria");
        txtCategoria.setFont(javafx.scene.text.Font.font("Arabella",10));
        listCategorias=new ComboBox<Categoria>();
        //listCategorias.setItems(lstCateg.toArray());
        descrCategoria=new TextArea("");
        
        btnAceptar=new Button("Aceptar");
        btnModificar=new Button("Modificar");
        btnEliminar=new Button("Eliminar");
        btnLimpiar=new Button("Limpiar");
        btnCancelar=new Button("Cancelar");
        
        pnlProducto=new VBox();
        pnlProducto.getChildren().add(txtCodigo);
        pnlProducto.getChildren().add(codigo);
        pnlProducto.getChildren().add(txtNombre);
        pnlProducto.getChildren().add(nombre);
        pnlProducto.getChildren().add(txtPrecio);
        pnlProducto.getChildren().add(precio);
        
        pnlCategoria=new VBox();
        pnlCategoria.getChildren().add(txtCategoria);
        pnlCategoria.getChildren().add(listCategorias);
        pnlCategoria.getChildren().add(descrCategoria);
        
        pnlCentral=new GridPane();
        pnlCentral.setVgap(10);
        pnlCentral.setHgap(10);
        pnlCentral.add(pnlProducto, 0, 0);
        pnlCentral.add(pnlCategoria, 1, 0);
        
        pnlBotones=new GridPane();
        pnlBotones.setVgap(10);
        pnlBotones.setHgap(10);
        pnlBotones.add(btnAceptar, 0, 0);
        pnlBotones.add(btnLimpiar, 1, 0);
        pnlBotones.add(btnCancelar, 2, 0);
        
        pnlPrincipal=new GridPane();
        pnlPrincipal.setVgap(10);
        pnlPrincipal.setHgap(10);
        pnlPrincipal.add(pnlCentral, 0, 0);
        pnlPrincipal.add(pnlBotones, 0, 1);
        
        
        Scene scene = new Scene(pnlPrincipal, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void CargarCursos() {

        ICategoria categDao = new ImplCategoria();
        try {
            lstCateg = categDao.obtener();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CURSOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
