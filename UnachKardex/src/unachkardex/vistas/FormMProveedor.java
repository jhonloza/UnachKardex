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

public class FormMProveedor {
    
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

    private Button btnModificar;
    private Button btnLimpiar;
    private Button btnBuscar;

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
    private Proveedor prove;


   public FormMProveedor() {
         pFondo = new Image("file:src\\unachkardex\\multimedia\\FondoSubVentanas.jpg");
        fondo = new BackgroundImage(pFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        //Sup izq
        titulo = new Label("\" Proveedor \"");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        txtRuc = new Label("Ruc:");
        txtRuc.setFont(Font.font("Berlin Sans FB Demi", 20));
        txtNombre = new Label("Nombres:");
        txtNombre.setFont(Font.font("Berlin Sans FB Demi", 20));
        pnlRucNom = new VBox(5);
        pnlRucNom.getChildren().addAll(txtRuc, txtNombre);
        pnlRucNom.setAlignment(Pos.CENTER_RIGHT);
        txtDireccion = new Label("Direccion:");
        txtDireccion.setFont(Font.font("Berlin Sans FB Demi", 20));
        txtTelefono = new Label("Telefono:");
        txtTelefono.setFont(Font.font("Berlin Sans FB Demi", 20));
        txtEmail = new Label("E-mail:");
        txtEmail.setFont(Font.font("Berlin Sans FB Demi", 20));
        pnlTItProv = new VBox(10);
        pnlTItProv.getChildren().addAll(txtDireccion, txtTelefono, txtEmail);
        pnlTItProv.setAlignment(Pos.CENTER_RIGHT);
        //CAJAS DE TEXTO PARA CAMPOS
        ruc = new TextField("");
        ruc.setMaxSize(200, 30);
        ruc.setMinSize(200, 30);
        ruc.setFont(Font.font("Berlin Sans FB Demi", 15));
        ruc.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        
        nombre = new TextField("");
        nombre.setMaxSize(200, 30);
        nombre.setMinSize(200, 30);
        nombre.setFont(Font.font("Berlin Sans FB Demi", 15));
        nombre.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        pnlRN = new VBox(10);
        pnlRN.getChildren().addAll(ruc, nombre);
        pnlRN.setAlignment(Pos.CENTER);
        direccion = new TextField("");
        direccion.setMaxSize(200, 30);
        direccion.setMinSize(200, 30);
        direccion.setFont(Font.font("Berlin Sans FB Demi", 15));
        direccion.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        
        telefono = new TextField("");
        telefono.setMaxSize(200, 30);
        telefono.setMinSize(200, 30);
        telefono.setFont(Font.font("Berlin Sans FB Demi", 15));
        telefono.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        
        email = new TextField("");
        email.setMaxSize(200, 30);
        email.setMinSize(200, 30);
        email.setFont(Font.font("Berlin Sans FB Demi", 15));
        email.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        pnlIItProv = new VBox(10);
        pnlIItProv.getChildren().addAll(direccion, telefono, email);
        pnlIItProv.setAlignment(Pos.CENTER);
        btnBuscar=new Button();
        btnBuscar.setMaxSize(100, 30);
        btnBuscar.setMinSize(100, 30);
        //LOGO
        logo = new Image("file:src\\unachkardex\\multimedia\\iconoProveedor.png");
        visorlogo = new ImageView(logo);
        visorlogo.setFitHeight(100);
        visorlogo.setFitWidth(100);
        //BOTONES A USAR
        btnModificar = new Button("Modificar");
        btnModificar.setFont(Font.font("Berlin Sans FB Demi", 15));
        btnModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnModificarEventHandler(event);
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
        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(Font.font("Berlin Sans FB Demi", 15));
        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnBuscarEventHandler(event);
            }
        });
        
        pnlIcInfo = new HBox(10);
        pnlIcInfo.getChildren().addAll(pnlRucNom, pnlRN,btnBuscar);
        pnlIcInfo.setAlignment(Pos.CENTER);
        pnlTitulo = new VBox(10);
        pnlTitulo.getChildren().addAll(titulo, pnlIcInfo);
        pnlTitulo.setAlignment(Pos.TOP_CENTER);
        pnlSup = new HBox(10);
        pnlSup.getChildren().addAll(pnlTitulo, visorlogo);
        pnlSup.setPadding(new Insets(10));
        pnlInt = new HBox(10);
        pnlInt.getChildren().addAll(pnlTItProv, pnlIItProv);
        pnlInt.setPadding(new Insets(10));
        pnlBotones = new HBox(10);
        pnlBotones.getChildren().addAll(btnModificar, btnLimpiar);
        pnlBotones.setAlignment(Pos.CENTER);
        pnlBotones.setPadding(new Insets(10));
        pntPrincipal = new VBox(10);
        pntPrincipal.getChildren().addAll(pnlSup, pnlInt, pnlBotones);
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

    public void btnModificarEventHandler(ActionEvent event) {
        IProveedor proveedorDao=new ImplProveedor();
        
         try {
        
            prove.setNombre(nombre.getText());
            prove.setDireccion(direccion.getText());
            prove.setTelefono(telefono.getText());
            prove.seteMail(email.getText());
            if(proveedorDao.modificar(prove)>0){
                Alert alerta=new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("INFORMACION DEL SISTEMA");
                alerta.setHeaderText(null);
                alerta.setContentText("Modificacion Correcto!!");
                alerta.showAndWait();
            }
            else{
                 Alert alerta=new Alert(Alert.AlertType.ERROR);
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
         IProveedor proveedorDao=new ImplProveedor();
          prove=new Proveedor();
        try {
            prove=proveedorDao.obtener(ruc.getText());
            nombre.setText(prove.getNombre());
            direccion.setText(prove.getDireccion());
            telefono.setText(prove.getTelefono());
            email.setText(prove.geteMail());
            } catch (Exception e) {
             Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("ERROR");
            alerta.setHeaderText(null);
            alerta.setContentText("No se encontro Registros: " + e.getMessage());
            alerta.showAndWait();
           
        }
    }
    public Node getPntPrincipal() {
        return pntPrincipal;
    }
    
}
