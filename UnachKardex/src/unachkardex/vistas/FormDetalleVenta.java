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
import javafx.scene.text.Text;

public class FormDetalleVenta extends Application {

    private Label txtCodigoDV;
    private Label txtProducto;
    private Label txtfacturaV;

    private Label txtCantidad;
    private Label txtPrecioTotal;

    private TextField codigodv;
    private TextField producto;
    private TextField facturav;

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
   
    private HBox pnlBotones;
    private VBox pntPrincipal;

    @Override

    public void start(Stage primaryStage) {
        //LABELS DE LOS CAMPOS A USAR
        txtCodigoDV = new Label("CODIGO DETALLE VENTA");
        // txtProducto.setFont(Font.font("Arial Black", 20));
        // txtCedula.setFill(Color.AQUA);
        txtProducto = new Label("PRODUCTO");
        //txtfacturaV.setFont(Font.font("Arial Black", 20));
        txtfacturaV = new Label("FACTURA VENTA");
        // txtApellidos.setFont(Font.font("Arial Black", 20));
        txtCantidad = new Label("CANTIDAD");
        //txtFechaNacimiento.setFont(Font.font("Arial Black", 20));
        txtPrecioTotal = new Label("PRECIO TOTAL");
        //txtDireccion.setFont(Font.font("Arial Black", 20));
        ///////////////////////////////////////////////////

        codigodv = new TextField("");
        producto = new TextField("");
        facturav = new TextField("");
        cantidad = new TextField("");
        preciototal = new TextField("");

        /////////////////////////////////////
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

        //////////////////////////////////
        pnlced = new HBox(20);
        pnlced.getChildren().addAll(txtCodigoDV, codigodv);
        ///

        pnlNombApe = new GridPane();
        pnlNombApe.setHgap(10);
        pnlNombApe.setVgap(10);
        pnlNombApe.add(txtProducto, 0, 0);
        pnlNombApe.add(producto, 1, 0);
        pnlNombApe.add(txtfacturaV, 2, 0);
        pnlNombApe.add(facturav, 3, 0);
        pnlNombApe.setAlignment(Pos.CENTER);
        ////////////////////////////
        
        pnlFechDir=new GridPane();
        pnlFechDir.setHgap(20);
        pnlFechDir.setVgap(10);
        pnlFechDir.add(txtCantidad, 0, 0);
        pnlFechDir.add(cantidad, 1, 0);
        pnlFechDir.add(txtPrecioTotal, 0, 1);
        pnlFechDir.add(preciototal, 1, 1);
        
        pnlBotones=new HBox(20);
        pnlBotones.getChildren().addAll(btnIngresar,btnLimpiar,btnEliminar,btnCancelar);
        pnlBotones.setAlignment(Pos.CENTER);
        
        pntPrincipal=new VBox(10);
        btnEliminar=new Button("ELIMINAR");
        btnEliminar.setFont(Font.font("Arial Black",40));
        pntPrincipal.getChildren().addAll(pnlced,pnlNombApe,pnlFechDir,pnlBotones);
        pntPrincipal.setAlignment(Pos.CENTER);
        pntPrincipal.setPadding(new Insets(25));
        Scene scene = new Scene(pntPrincipal,620,420);
        
        
        primaryStage.setTitle("DETALLE VENTA");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
