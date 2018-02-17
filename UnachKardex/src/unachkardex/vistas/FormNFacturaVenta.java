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

public class FormNFacturaVenta {

    private Image pFondo;
    private BackgroundImage fondo;
    private Label txtcedula;
    private Label txtnombres;
    private Label txtdireccion;
    private Label txttelefono;
    private Label txtemail;
    private TextField cedula;
    private Label nombres;
    private Label direccion;
    private Label telefono;
    private Label email;
    private VBox pnlCliente;
    private Button btnBuscar;
    private HBox pnlC1;
    private HBox pnlC2;
    private HBox pnlC3;
    private HBox pnlC4;

    /// logo ////
    Image logo;
    ImageView mostrarLogo;
    //////// Cabecera /////////
    private HBox pnlCabecera;
    private BorderPane pntPrincipal;

    public FormNFacturaVenta() {
        //PANEL SUPERIOR CLIENTE
        pFondo = new Image("file:src\\unachkardex\\multimedia\\FondoSubVentanas.jpg");
        fondo = new BackgroundImage(pFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        txtcedula = new Label("Cedula/Ruc CLiente:   ");
        txtcedula.setFont(Font.font("Berlin Sans FB Demi", 15));
        btnBuscar = new Button("Buscar");
        txtnombres = new Label("Nombre: ");
        txtnombres.setFont(Font.font("Berlin Sans FB Demi", 15));
        txtdireccion = new Label("Direccion: ");
        txtdireccion.setFont(Font.font("Berlin Sans FB Demi", 15));
        txttelefono = new Label("Telefono: ");
        txttelefono.setFont(Font.font("Berlin Sans FB Demi", 15));
        txtemail = new Label("Correo: ");
        txtemail.setFont(Font.font("Berlin Sans FB Demi", 15));
        //cajas de texto
        
        cedula = new TextField("0000000000001");
        nombres = new Label("");
        nombres.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        nombres.setMaxSize(310, 25);
        nombres.setMinSize(310, 25);
        direccion = new Label("");
        direccion.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        direccion.setMaxSize(300, 25);
        direccion.setMinSize(300, 25);
        telefono = new Label("");
        telefono.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        telefono.setMaxSize(100, 25);
        telefono.setMinSize(100, 25);
        email = new Label("");
        email.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        email.setMaxSize(150, 25);
        email.setMinSize(150, 25);
        pnlC1 = new HBox(5);
        pnlC1.getChildren().addAll(txtcedula, cedula, btnBuscar);
        pnlC1.setAlignment(Pos.CENTER);
        pnlC2 = new HBox(5);
        pnlC2.getChildren().addAll(txtnombres, nombres);
        pnlC2.setAlignment(Pos.CENTER);
        pnlC3 = new HBox(5);
        pnlC3.getChildren().addAll(txtdireccion, direccion);
        pnlC3.setAlignment(Pos.CENTER);
        pnlC4 = new HBox(5);
        pnlC4.getChildren().addAll(txttelefono, telefono, txtemail, email);
        pnlC4.setAlignment(Pos.CENTER);
        pnlCliente = new VBox(5);
        pnlCliente.getChildren().addAll(pnlC1,pnlC2,pnlC3,pnlC4);
        consumidorFinal();

        pntPrincipal = new BorderPane();
        pntPrincipal.setTop(pnlCliente);
        pntPrincipal.setPadding(new Insets(10));
        pntPrincipal.setBackground(new Background(fondo));
        pntPrincipal.setStyle("-fx-padding: 10; -fx-border-color: mediumblue; -fx-border-width: 2px");
    }

    public Node getPantallaP() {
        return pntPrincipal;
    }
    
    
    public void consumidorFinal(){
        ICliente clienteDao=new ImplCliente();
        Cliente nCliente=new Cliente();
        try {
            nCliente=clienteDao.obtener(cedula.getText());
            nombres.setText(nCliente.getNombre()+" "+nCliente.getApellido());
            direccion.setText(nCliente.getDireccion());
            telefono.setText(nCliente.getTelefono());
            email.setText(nCliente.geteMail());
        } catch (Exception e) {
        }
    }
}
