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
import javafx.scene.image.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;

public class FormNProducto {

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
    private Button btnAceptar;
    private Button btnLimpiar;
    private VBox pnlProducto;
    private VBox pnlCategoria;
    private GridPane pnlCentral;
    private GridPane pnlBotones;
    private GridPane pntPrincipal;

    public FormNProducto() {
        pFondo = new Image("file:src\\unachkardex\\multimedia\\FondoSubVentanas.jpg");
        fondo = new BackgroundImage(pFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        txtCodigo = new Label("Codigo");
        txtCodigo.setFont(Font.font("Berlin Sans FB Demi", 20));
        codigo = new TextField("");
        codigo = new TextField();
        codigo.setText(String.valueOf(cargarProd()+1));
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
        descrCategoria.setMaxSize(200, 200);
        descrCategoria.setMinSize(200, 200);
        descrCategoria.setFont(Font.font("Berlin Sans FB Demi", 14));
        descrCategoria.setTextFill(Color.AZURE);
        descrCategoria.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        btnAceptar = new Button("Aceptar");
        btnAceptar.setFont(Font.font("Berlin Sans FB Demi", 20));
        btnAceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnAceptarEventHandler(event);
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
    }

    public Node getPantallaP() {
        return pntPrincipal;
    }

    private void btnLimpiarEventHandler(ActionEvent event){
        codigo.setText(String.valueOf(cargarProd()+1));
        nombre.setText("");
        precio.setText("");
    }
    
    public void btnAceptarEventHandler(ActionEvent event) {
        IProducto proDao = new ImplProducto();
        try {
            Producto nuevoPro = new Producto();
            nuevoPro.setCodProducto(Integer.parseInt(codigo.getText()));
            nuevoPro.setCategoria((Categoria) cbxCategoria.getSelectionModel().getSelectedItem());
            nuevoPro.setNombre(nombre.getText());
            nuevoPro.setPrecio(Double.parseDouble(precio.getText()));
            if (proDao.insertar(nuevoPro) > 0) {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("INFORMACION DEL SISTEMA");
                alerta.setHeaderText(null);
                alerta.setContentText("Ingtreso Correcto!!");
                alerta.showAndWait();
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("INFORMACION DEL SISTEMA");
                alerta.setHeaderText(null);
                alerta.setContentText("Ingtreso Fallido!! ");
                alerta.showAndWait();
            }
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("Error: " + e.getMessage());
            alerta.showAndWait();
        }
    }

    private int cargarProd() {
        int numCateg = 0;
        listaProductos = new ArrayList<>();
        IProducto prodDao = new ImplProducto();
        try {
            listaProductos = prodDao.obtener();
            numCateg=listaProductos.size();
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("Error: " + e.getMessage());
            alerta.showAndWait();
        }
        return numCateg;
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
