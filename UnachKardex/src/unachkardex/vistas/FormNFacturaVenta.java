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

public class FormNFacturaVenta{
    private Image pFondo;
    private BackgroundImage fondo;
    private VBox pnlCliente;
    private Label txtcedula;
    private Label txtnombres;
    private Label txtdireccion;
    private Label txttelefono;
    private Label txtemail;
    private TextField cedula;
    private TextField nombres;    
    private TextField direccion;
    private TextField telefono;
    private TextField email;
    private HBox pnlCel;
    private GridPane pnlNomb;
    private GridPane pnlresto;
    private GridPane pnlmail;
    private VBox pntPrincipal;
    private VBox pntPrincipal2;
    private Button btnBuscar;
    //////////////////////////FACTURA VENTA
    private Label txtcodigofa;
    private Label txtfecha;
    private TextField codigofa;
    private TextField fecha;
    private VBox pnlfac;
    /// logo ////
    Image logo;
    ImageView mostrarLogo;
    //////// Cabecera /////////
    private HBox pnlCabecera;
    
    public FormNFacturaVenta() {
        pFondo=new Image("file:src\\unachkardex\\multimedia\\FondoSubVentanas.jpg");
        fondo=new BackgroundImage(pFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        txtcedula = new Label("CEDULA DEL CLIENTE:");
        btnBuscar = new Button("BUSCAR");
        txtnombres = new Label("NOMBRE DEL CLIENTE");
        txtdireccion = new Label("DIRECCION DEL CLIENTE");
        txttelefono = new Label("TELEFONO DEL CLIENTE");
        txtemail = new Label("MAIL DEL CLIENTE");
        //cajas de texto
        cedula = new TextField("");
        nombres = new TextField("");
        direccion = new TextField("");
        telefono = new TextField("");
        email = new TextField("");
///ingreso paneles
        pnlCel = new HBox(20);
        pnlCel.getChildren().addAll(txtcedula, cedula, btnBuscar);
        pnlCel.setAlignment(Pos.CENTER);
        // nombres   
        pnlNomb = new GridPane();
        pnlNomb.setHgap(20);
        pnlNomb.setVgap(20);
        pnlNomb.add(txtnombres, 0, 0);
        pnlNomb.add(nombres, 1, 0);
        /////direccion 
        pnlresto = new GridPane();
        pnlresto.setHgap(20);
        pnlresto.setVgap(20);
        pnlresto.add(txtdireccion, 0, 0);
        pnlresto.add(direccion, 1, 0);
        pnlresto.add(txttelefono, 2, 0);
        pnlresto.add(telefono, 3, 0);
        pnlresto.setAlignment(Pos.CENTER);
        //////mail
        pnlmail = new GridPane();
        pnlmail.setHgap(20);
        pnlmail.setVgap(20);
        pnlmail.add(txtemail, 2, 0);
        pnlmail.add(email, 3, 0);
        pnlCliente = new VBox(10);
        pnlCliente.getChildren().addAll(pnlCel, pnlNomb, pnlresto, pnlmail);
        ///////////////////////////////FACTURA VENTS////////////////////
        txtcodigofa = new Label("          CODIGO FACTURA          ");
        txtfecha = new Label("FECHA");
        codigofa = new TextField("");
        codigofa.selectRange(750, 5);
        fecha = new TextField("");
        fecha.selectRange(750, 5);
        pnlfac = new VBox();
        pnlfac.getChildren().addAll(txtcodigofa,codigofa,txtfecha, fecha);
        pnlfac.setAlignment(Pos.CENTER);
        pnlfac.setPadding(new Insets(15));
        ////////// logo //////////
        logo = new Image("file:src\\unachkardex\\multimedia\\logo.jpg");
        mostrarLogo = new ImageView(logo);
        mostrarLogo.setFitHeight(160);
        mostrarLogo.setFitWidth(480);
        mostrarLogo.setPreserveRatio(false);
        ////////////// CABECERA /////////////
        pnlCabecera=new HBox(10);
        pnlCabecera.getChildren().addAll(pnlCliente,mostrarLogo,pnlfac);
        pnlCabecera.setPadding(new Insets(15));
        pntPrincipal = new VBox(10);
        pntPrincipal.getChildren().addAll(pnlCabecera);
        pntPrincipal.setAlignment(Pos.CENTER);
        pntPrincipal.setPadding(new Insets(10));
        pntPrincipal.setBackground(new Background(fondo));
        pntPrincipal.setStyle("-fx-padding: 10; -fx-border-color: mediumblue; -fx-border-width: 2px");
        
    }
    
    public Node getPantallaP() {
        return pntPrincipal;
    }
    
    
    
}
