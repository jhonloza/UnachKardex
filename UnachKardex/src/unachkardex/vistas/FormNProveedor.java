
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

public class FormNProveedor{
    private Label titulo;
    private Label txtRuc;
    private Label txtNombre;
    private Label txtDireccion;
    private Label txtTelefono;
    private Label txtEmail;

    private Image pFondo;
    private BackgroundImage fondo;
    private Image logo;
    private ImageView visorlogo;

    private TextField ruc;
    private TextField nombre;
    private TextField direccion;
    private TextField telefono;
    private TextField email;

    private Button btnIngresar;
    private Button btnLimpiar;

    private VBox pnlRucNom;
    private VBox pnlRN;
    private VBox pnlTitulo;
    private HBox pnlIcInfo;
    private VBox pnlTItProv;
    private VBox pnlIItProv;
    private HBox pnlSup;
    private HBox pnlInt;
    private HBox pnlBotones;
    private VBox pntPrincipal;

    public  FormNProveedor() {
        pFondo=new Image("file:src\\unachkardex\\multimedia\\FondoSubVentanas.jpg");
        fondo=new BackgroundImage(pFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        
        //Sup izq
        titulo=new Label("\" Proveedor \"");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        txtRuc = new Label("Ruc:");
        txtRuc.setFont(Font.font("Berlin Sans FB Demi", 20));
        txtNombre = new Label("Nombres:");
        txtNombre.setFont(Font.font("Berlin Sans FB Demi", 20));
        pnlRucNom=new VBox(5);
        pnlRucNom.getChildren().addAll(txtRuc,txtNombre);
        pnlRucNom.setAlignment(Pos.CENTER_RIGHT);
        txtDireccion = new Label("Direccion:");
        txtDireccion.setFont(Font.font("Berlin Sans FB Demi", 20));
        txtTelefono = new Label("Telefono:");
        txtTelefono.setFont(Font.font("Berlin Sans FB Demi", 20));
        txtEmail = new Label("E-mail:");
        txtEmail.setFont(Font.font("Berlin Sans FB Demi", 20));
        pnlTItProv=new VBox(10);
        pnlTItProv.getChildren().addAll(txtDireccion,txtTelefono,txtEmail);
        pnlTItProv.setAlignment(Pos.CENTER_RIGHT);
        //CAJAS DE TEXTO PARA CAMPOS
        ruc = new TextField("");
        nombre = new TextField("");
        pnlRN=new VBox(10);
        pnlRN.getChildren().addAll(ruc,nombre);
        pnlRN.setAlignment(Pos.CENTER);
        direccion = new TextField("");
        telefono = new TextField("");
        email = new TextField("");
        pnlIItProv=new VBox(10);
        pnlIItProv.getChildren().addAll(direccion,telefono,email);
        pnlIItProv.setAlignment(Pos.CENTER);
        //LOGO
        logo=new Image("file:src\\unachkardex\\multimedia\\iconoProveedor.png");
        visorlogo=new ImageView(logo);
        visorlogo.setFitHeight(100);
        visorlogo.setFitWidth(100);
        //BOTONES A USAR
        btnIngresar = new Button("Ingresar");
        btnIngresar.setFont(Font.font("Berlin Sans FB Demi", 15));
        btnIngresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnIngresarEventHandler(event);
            }
        });
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("Berlin Sans FB Demi", 15));
        btnLimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnLimpiarEventHandler(event);
            }
        });
        pnlIcInfo=new HBox(10);
        pnlIcInfo.getChildren().addAll(pnlRucNom,pnlRN);
        pnlIcInfo.setAlignment(Pos.CENTER);
        pnlTitulo=new VBox(10);
        pnlTitulo.getChildren().addAll(titulo,pnlIcInfo);
        pnlTitulo.setAlignment(Pos.TOP_CENTER);
        pnlSup=new HBox(10);
        pnlSup.getChildren().addAll(pnlTitulo,visorlogo);
        pnlSup.setPadding(new Insets(10));
        pnlInt=new HBox(10);
        pnlInt.getChildren().addAll(pnlTItProv,pnlIItProv);
        pnlInt.setPadding(new Insets(10));
        pnlBotones=new HBox(10);
        pnlBotones.getChildren().addAll(btnIngresar,btnLimpiar);
        pnlBotones.setAlignment(Pos.CENTER);
        pnlBotones.setPadding(new Insets(10));
        pntPrincipal=new VBox(10);
        pntPrincipal.getChildren().addAll(pnlSup,pnlInt,pnlBotones);
        pntPrincipal.setPadding(new Insets(10));
        pntPrincipal.setBackground(new Background(fondo));
        pntPrincipal.setStyle("-fx-padding: 10; -fx-border-color: mediumblue; -fx-border-width: 2px");
    }
    
    
    
    public void btnLimpiarEventHandler(ActionEvent event) {
        ruc.setText("");
        nombre.setText("");
        direccion.setText("");
        telefono.setText("");
        email.setText("");
    }
    public void btnIngresarEventHandler(ActionEvent event) {
        IProveedor proveedorDao = new ImplProveedor();
        try {
            Proveedor nuevoProveedor = new Proveedor();
            nuevoProveedor.setRuc(ruc.getText());
            nuevoProveedor.setNombre(nombre.getText());
            nuevoProveedor.setDireccion(direccion.getText());
            nuevoProveedor.setTelefono(telefono.getText());
            nuevoProveedor.seteMail(email.getText());

            if (proveedorDao.ingresar(nuevoProveedor) > 0) {
                System.out.println("Ingreso Correcto..");
            } else {
                System.out.println("Error de Ingreso..");
            }
        } catch (Exception e) {
            System.out.println("Error de Ingreso" + e.getMessage());
        }
    }

    public VBox getPntPrincipal() {
        return pntPrincipal;
    }
}
