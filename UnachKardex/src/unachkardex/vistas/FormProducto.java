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
import javafx.stage.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;
import javafx.scene.image.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;


public class FormProducto extends Application {

    private Image icono;
    private ImageView visor;
    
    private Label txtCodigo;
    private Label txtCategoria;

    private Label txtNombre;
    private Label txtPrecio;

    private TextField codigo;
    private TextField nombre;
    private TextField precio;
    private TextField descrCategoria;

    private ComboBox<Categoria> cbxCategoria;
    private ObservableList<Categoria> items = FXCollections.observableArrayList();
    private ArrayList<Categoria> listCategorias;

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
        txtCodigo = new Label("Codigo");
        txtCodigo.setFont(javafx.scene.text.Font.font("Arial Black", 20));
        codigo = new TextField("");
        txtNombre = new Label("Nombre");
        txtNombre.setFont(javafx.scene.text.Font.font("Arial Black", 20));
        nombre = new TextField("");
        txtPrecio = new Label("Precio");
        txtPrecio.setFont(javafx.scene.text.Font.font("Arial Black", 20));
        precio = new TextField("");

        txtCategoria = new Label("Categoria");
        txtCategoria.setFont(javafx.scene.text.Font.font("Arial Black", 20));
        
        cargarCategorias();
        cbxCategoria = new ComboBox<Categoria>(items);
        cbxCategoria.setValue(items.get(0));
        cbxCategoria.setVisible(true);
        descrCategoria = new TextField("");
        
        btnAceptar = new Button("Aceptar");
        btnAceptar.setFont(Font.font("Arial Black", 20));
        btnAceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnAceptarEventHandler(event);
            }
        });
        btnModificar = new Button("Modificar");
        btnModificar.setFont(Font.font("Arial Black", 20));
        btnEliminar = new Button("Eliminar");
        btnEliminar.setFont(Font.font("Arial Black", 20));
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("Arial Black", 20));
        btnCancelar = new Button("Cancelar");
        btnCancelar.setFont(Font.font("Arial Black", 20));

        pnlProducto = new VBox(20);
        pnlProducto.getChildren().add(txtCodigo);
        pnlProducto.getChildren().add(codigo);
        pnlProducto.getChildren().add(txtNombre);
        pnlProducto.getChildren().add(nombre);
        pnlProducto.getChildren().add(txtPrecio);
        pnlProducto.getChildren().add(precio);

        pnlCategoria = new VBox(20);
        pnlCategoria.getChildren().add(txtCategoria);
        pnlCategoria.getChildren().add(cbxCategoria);
        pnlCategoria.getChildren().add(descrCategoria);

        pnlCentral = new GridPane();
        pnlCentral.setVgap(10);
        pnlCentral.setHgap(10);
        pnlCentral.add(pnlProducto, 0, 0);
        pnlCentral.add(pnlCategoria, 1, 0);

        pnlBotones = new GridPane();
        pnlBotones.setVgap(10);
        pnlBotones.setHgap(10);
        pnlBotones.add(btnAceptar, 0, 0);
        pnlBotones.add(btnLimpiar, 1, 0);
        pnlBotones.add(btnCancelar, 2, 0);
        pnlBotones.setAlignment(Pos.CENTER);

        pnlPrincipal = new GridPane();
        pnlPrincipal.setVgap(10);
        pnlPrincipal.setHgap(10);
        pnlPrincipal.add(pnlCentral, 0, 0);
        pnlPrincipal.add(pnlBotones, 0, 1);
        pnlPrincipal.setPadding(new Insets(25));

        Scene scene = new Scene(pnlPrincipal, 600, 400);
        primaryStage.setTitle("Producto");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
     public void btnAceptarEventHandler(ActionEvent event) {
        IProducto proDao = new ImplProducto();
        try {
            Producto nuevoPro = new Producto();
            nuevoPro.setCodProducto(Integer.parseInt(codigo.getText()));
          // nuevoPro.setCategoria((Categoria) cbxCategoria.getSelectionModel().getSelectedIndex());
            
            nuevoPro.setNombre(nombre.getText());
            nuevoPro.setPrecio(Double.parseDouble(precio.getText()));
            

            if (proDao.insertar(nuevoPro) > 0) {
                System.out.println("Ingreso Correcto..");
            } else {
                System.out.println("Error de Ingreso..");
            }
        } catch (Exception e) {
            System.out.println("Error de Ingreso" + e.getMessage());
        }
    }

    public void cargarCategorias() {
        listCategorias = new ArrayList<>();
        ICategoria categDao = new ImplCategoria();
        try {
            listCategorias=categDao.obtener();
            for(Categoria categ:listCategorias){
                items.add(categ);
            }
        } catch (Exception e) {
            Stage errorStage=new Stage(StageStyle.TRANSPARENT);
            Dialogs.showErrorDialog(errorStage, "No se pudo Cargar las Categorias");
        }

    }
}
