package unachkardex.vistas;

import com.sun.javafx.geom.Area;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import java.util.*;
import static javafx.application.Application.launch;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class FormDetalleCompra extends Application {

    private Label txtCodigoDC;
    private Label txtProducto;
    private Label txtFacturaC;

    private Label txtCantidad;
    private Label txtPrecioTotal;

    Image logo;
    ImageView visorlogo;

    private TextField codigodc;
    private TextField producto;
    private TextField facturac;

    private TextField cantidad;
    private TextField preciototal;

    private Button btnIngresar;
    private Button btnEliminar;
    private Button btnModificar;
    private Button btnLimpiar;
    private Button btnCancelar;

    private HBox pnlced;
    private GridPane pnlNombApe;
    private GridPane pnlFechDir;
    private GridPane pnlcontacto;
    private HBox pnlBotones;
    private VBox pntPrincipal;

    @Override

    public void start(Stage primaryStage) {
        //LABELS DE LOS CAMPOS A USAR
        txtCodigoDC = new Label("Codigo Detalle C");
        txtCodigoDC.setFont(Font.font("Arial Blaomprack", 20));
        // txtCodigoDC.setFill(Color.AQUA);
        txtProducto = new Label("Producto");
        txtProducto.setFont(Font.font("Arial Black", 20));
        txtFacturaC = new Label("Factura Compra");
        txtFacturaC.setFont(Font.font("Arial Black", 20));

        txtCantidad = new Label("Cantidad");
        txtCantidad.setFont(Font.font("Arial Black", 20));
        txtPrecioTotal = new Label("Precio Total");
        txtPrecioTotal.setFont(Font.font("Arial Black", 20));

        //CAJAS DE TEXTO PARA CAMPOS
        codigodc = new TextField("");
        producto = new TextField("");
        facturac = new TextField("");

        cantidad = new TextField("");
        preciototal = new TextField("");

        //BOTONES A USAR
        btnIngresar = new Button("Ingresar");
        btnIngresar.setFont(Font.font("Arial Black", 20));
        btnEliminar = new Button("Eliminar");
        btnEliminar.setFont(Font.font("Arial Black", 20));
        btnModificar = new Button("Modificar");
        btnModificar.setFont(Font.font("Arial Black", 20));
        btnModificar.setEventDispatcher(new EventDispatcher() {
            @Override
            public Event dispatchEvent(Event event, EventDispatchChain tail) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("Arial Black", 20));
        btnCancelar = new Button("Cancelar");
        btnCancelar.setFont(Font.font("Arial Black", 20));
        //INGRESO EN PANELES
        //SUPERIOR
        pnlced = new HBox(20);
        pnlced.getChildren().addAll(txtCodigoDC, codigodc);
        //nombre
        pnlNombApe = new GridPane();
        pnlNombApe.setHgap(20);
        pnlNombApe.setVgap(20);
        pnlNombApe.add(txtProducto, 0, 0);
        pnlNombApe.add(producto, 1, 0);
        pnlNombApe.add(txtFacturaC, 2, 0);
        pnlNombApe.add(facturac, 3, 0);
        //fecha y cantidad
        pnlFechDir = new GridPane();
        pnlFechDir.setHgap(20);
        pnlFechDir.setVgap(10);

        pnlFechDir.add(txtCantidad, 0, 1);
        pnlFechDir.add(cantidad, 1, 1);

        //Contacto        
        pnlcontacto = new GridPane();
        pnlcontacto.setHgap(20);
        pnlcontacto.setVgap(20);
        pnlcontacto.add(txtPrecioTotal, 0, 0);
        pnlcontacto.add(preciototal, 1, 0);

        //botones
        pnlBotones = new HBox(20);
        pnlBotones.getChildren().addAll(btnIngresar, btnLimpiar, btnCancelar);
        pnlBotones.setAlignment(Pos.CENTER);
        //final
        pntPrincipal = new VBox(20);
        logo = new Image("file:src\\unachkardex\\multimedia\\logo.jpg");
        visorlogo = new ImageView();
        visorlogo.setImage(logo);
        visorlogo.setFitHeight(200);
        visorlogo.setPreserveRatio(true);
        //btnEliminar = new Button("ELIMINAR");
        //btnEliminar.setFont(Font.font("Arial Black",20));
        pntPrincipal.getChildren().addAll(visorlogo, pnlced, pnlNombApe, pnlFechDir, pnlcontacto, pnlBotones);
        pntPrincipal.setAlignment(Pos.CENTER);
        pntPrincipal.setPadding(new Insets(25));
        Scene scene = new Scene(pntPrincipal, 795, 620);
        primaryStage.setResizable(false);
        primaryStage.setTitle("DDETALLE COMPRA");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
