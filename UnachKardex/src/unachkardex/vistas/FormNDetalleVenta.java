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

public class FormNDetalleVenta extends Application {

    private Image pFondo;
    private BackgroundImage fondo;
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
    private Button btnLimpiar;

    private HBox pnlced;
    private GridPane pnlNombApe;
    private GridPane pnlFechDir;
   
    private HBox pnlBotones;
    private VBox pntPrincipal;

    @Override

    public void start(Stage primaryStage) {
        //LABELS DE LOS CAMPOS A USAR
        txtCodigoDV = new Label("CODIGO DETALLE VENTA");
        txtProducto = new Label("PRODUCTO");
        txtfacturaV = new Label("FACTURA VENTA");
        txtCantidad = new Label("CANTIDAD");
        txtPrecioTotal = new Label("PRECIO TOTAL");
        codigodv = new TextField("");
        producto = new TextField("");
        facturav = new TextField("");
        cantidad = new TextField("");
        preciototal = new TextField("");
        /////////////////////////////////////
        btnIngresar = new Button("Ingresar");
        btnIngresar.setFont(Font.font("Arial Black", 20));
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("Arial Black", 20));
        //////////////////////////////////
        pnlced = new HBox(20);
        pnlced.getChildren().addAll(txtCodigoDV, codigodv);
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
        pnlBotones.getChildren().addAll(btnIngresar,btnLimpiar);
        pnlBotones.setAlignment(Pos.CENTER);
        pntPrincipal=new VBox(10);
        pntPrincipal.getChildren().addAll(pnlced,pnlNombApe,pnlFechDir,pnlBotones);
        pntPrincipal.setAlignment(Pos.CENTER);
        pntPrincipal.setPadding(new Insets(10));
        pntPrincipal.setBackground(new Background(fondo));
        pntPrincipal.setStyle("-fx-padding: 10; -fx-border-color: mediumblue; -fx-border-width: 2px");
    }
    
    public Node getPantallaP() {
        return pntPrincipal;
    }

}
