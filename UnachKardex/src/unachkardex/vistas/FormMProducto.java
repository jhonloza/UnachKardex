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
import static javafx.application.Application.launch;
import javafx.beans.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.image.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;

public class FormMProducto{

    private Image pFondo;
    private BackgroundImage fondo;
    private Image icono;
    private ImageView visor;
    private Label txtCodigo;
    private Label txtCategoria;
    private Label txtNombre;
    private Label txtPrecio;
    private TextField codigo;
    private TextField nombre;
    private TextField precio;
    private Label descrCategoria;
    private ArrayList<Producto> listaProductos;
    private ComboBox<Categoria> cbxCategoria;
    private ObservableList<Categoria> items = FXCollections.observableArrayList();
    private ArrayList<Categoria> listCategorias;
    private Button btnModificar;
    private Button btnBuscar;    
    private Button btnLimpiar;
    private VBox pnlbuscar;
    private VBox pnlProducto;
    private VBox pnlCategoria;
    private GridPane pnlCentral;
    private GridPane pnlBotones;
    private GridPane pntPrincipal;

    private Producto produc;

    public void start(Stage primaryStage) throws Exception {
        pFondo = new Image("file:src\\unachkardex\\multimedia\\FondoSubVentanas.jpg");
        fondo = new BackgroundImage(pFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        txtCodigo = new Label("Codigo");
        txtCodigo.setFont(Font.font("Berlin Sans FB Demi", 20));
        codigo = new TextField("");
        codigo = new TextField();
//        codigo.setText(String.valueOf(cargarProd() + 1));
        txtNombre = new Label("Nombre");
        txtNombre.setFont(Font.font("Berlin Sans FB Demi", 20));
        nombre = new TextField("");
        txtPrecio = new Label("Precio");
        txtPrecio.setFont(Font.font("Berlin Sans FB Demi", 20));
        precio = new TextField("");
        txtCategoria = new Label("Categoria");
        txtCategoria.setFont(Font.font("Berlin Sans FB Demi", 20));
        cargarCategorias();
        cbxCategoria = new ComboBox<Categoria>(items);
        cbxCategoria.setVisible(true);
        cbxCategoria.setOnHiding(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                descrCategoria.setText(cbxCategoria.getSelectionModel().getSelectedItem().getDescripcion());
                descrCategoria.setWrapText(true);
            }
        });
        descrCategoria = new Label();
        descrCategoria.setMaxSize(200, 50);
        descrCategoria.setMinSize(200, 50);
        descrCategoria.setFont(Font.font("Berlin Sans FB Demi", 14));
        descrCategoria.setTextFill(Color.AZURE);
        descrCategoria.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        btnModificar = new Button("Aceptar");
        btnModificar.setFont(Font.font("Berlin Sans FB Demi", 20));
        btnModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnModificarEventHandler(event);
            }
        });
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("Berlin Sans FB Demi", 20));
        btnLimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnLimpiarEventHandler(event);
            }
        });
        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(Font.font("Berlin Sans FB Demi", 20));
        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnBuscarEventHandler(event);
            }
        });
        pnlProducto = new VBox(20);
        pnlProducto.getChildren().add(txtCodigo);
        pnlProducto.getChildren().add(codigo);
        pnlbuscar = new VBox(20);
        pnlbuscar.getChildren().add(btnBuscar);
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
        pnlCentral.add(pnlbuscar, 1, 0);
        pnlCentral.add(pnlProducto, 1, 1);
        pnlCentral.add(pnlCategoria, 2, 1);
        pnlBotones = new GridPane();
        pnlBotones.setVgap(10);
        pnlBotones.setHgap(10);
        pnlBotones.add(btnModificar, 0, 0);
        pnlBotones.add(btnLimpiar, 1, 0);
        pnlBotones.setAlignment(Pos.CENTER);
        pntPrincipal = new GridPane();
        pntPrincipal.setVgap(10);
        pntPrincipal.setHgap(10);
        pntPrincipal.add(pnlCentral, 0, 0);
        pntPrincipal.add(pnlBotones, 0, 1);
        pntPrincipal.setPadding(new Insets(25));
        pntPrincipal.setPadding(new Insets(10));
        pntPrincipal.setBackground(new Background(fondo));
        pntPrincipal.setStyle("-fx-padding: 10; -fx-border-color: mediumblue; -fx-border-width: 2px");

        Scene scene = new Scene(pntPrincipal, 640, 480);
        primaryStage.setTitle("Eliminar Proveedor");
        primaryStage.setScene(scene);
        primaryStage.setMaxHeight(480);
        primaryStage.setMinHeight(480);
        primaryStage.setMaxWidth(640);
        primaryStage.setMaxWidth(640);
        primaryStage.show();

    }

//    public Node getPantallaP() {
//        return pntPrincipal;
//    }

    private void btnLimpiarEventHandler(ActionEvent event) {
//        codigo.setText(String.valueOf(cargarProd() + 1));
//        nombre.setText("");
//        precio.setText("");
    }

    public void btnModificarEventHandler(ActionEvent event) {
        IProducto prodDao = new ImplProducto();

        try {

            produc.setCategoria((Categoria) cbxCategoria.getSelectionModel().getSelectedItem());
            produc.setNombre(nombre.getText());
            produc.setPrecio(Double.parseDouble(precio.getText()));
            if (prodDao.modificar(produc) > 0) {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("INFORMACION DEL SISTEMA");
                alerta.setHeaderText(null);
                alerta.setContentText("Modificacion Correcto!!");
                alerta.showAndWait();
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("INFORMACION DEL SISTEMA");
                alerta.setHeaderText(null);
                alerta.setContentText("Modificacion Fallido!! ");
                alerta.showAndWait();

            }

        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("ERROR");
            alerta.setHeaderText(null);
            alerta.setContentText("No se Pudo Modificar: " + e.getMessage());
            alerta.showAndWait();

        }
    }

    public void btnBuscarEventHandler(ActionEvent event) {
        IProducto proDao = new ImplProducto();
        Producto prove = new Producto();
        try {
            prove = proDao.obtener(Integer.parseInt(codigo.getText()));
            descrCategoria.setText(String.valueOf(prove.getCategoria()));
            nombre.setText(prove.getNombre());
            precio.setText(String.valueOf(prove.getPrecio()));
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("ERROR");
            alerta.setHeaderText(null);
            alerta.setContentText("No se encontro Registros: " + e.getMessage());
            alerta.showAndWait();

        }
    }
    
    public void cargarCategorias() {
        listCategorias = new ArrayList<>();
        ICategoria categDao = new ImplCategoria();
        try {
            listCategorias = categDao.obtener();
            for (Categoria categ : listCategorias) {
                items.add(categ);
            }
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("Error al cargar Categorias: " + e.getMessage());
            alerta.showAndWait();
        }
        
    }

}
