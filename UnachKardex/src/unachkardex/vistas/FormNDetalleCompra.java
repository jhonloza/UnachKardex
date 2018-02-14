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

public class FormNDetalleCompra{

    private Label txtCodigoDC;
    private Label txtProducto;
    private Label txtFacturaC;

    private Label txtCantidad;
    private Label txtPrecioTotal;

    private Image pFondo;
    private BackgroundImage fondo;
    private Image logo;
    private ImageView visorlogo;

    private TextField codigodc;
    private TextField producto;
    private TextField facturac;

    private TextField cantidad;
    private TextField preciototal;

    private Button btnIngresar;
    private Button btnLimpiar;

    private HBox pnlced;
    private GridPane pnlNombApe;
    private GridPane pnlFechDir;
    private GridPane pnlcontacto;
    private HBox pnlBotones;
    private VBox pntPrincipal;

    public FormNDetalleCompra() {
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
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("Arial Black", 20));
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
        pnlBotones.getChildren().addAll(btnIngresar, btnLimpiar);
        pnlBotones.setAlignment(Pos.CENTER);
        //final
        pntPrincipal = new VBox(20);
        logo = new Image("file:src\\unachkardex\\multimedia\\logo.jpg");
        visorlogo = new ImageView();
        visorlogo.setImage(logo);
        visorlogo.setFitHeight(200);
        visorlogo.setPreserveRatio(true);
        pntPrincipal.getChildren().addAll(visorlogo, pnlced, pnlNombApe, pnlFechDir, pnlcontacto, pnlBotones);
        pntPrincipal.setAlignment(Pos.CENTER);
        pntPrincipal.setPadding(new Insets(10));
        pntPrincipal.setBackground(new Background(fondo));
        pntPrincipal.setStyle("-fx-padding: 10; -fx-border-color: mediumblue; -fx-border-width: 2px");
    }

    public Node getPantallaP() {
        return pntPrincipal;
    }

}
