package unachkardex.vistas;

import com.sun.javafx.geom.Area;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import javafx.scene.Node;
import javafx.scene.text.Text;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;


public class FormProveedor extends Application {
    
    private Text txtRuc;
    private Text txtNombre;
    private Text txtDireccion;
    private Text txtTelefono;
    private Text txtEmail;

    Image logo;
    ImageView visorlogo;

    private TextArea ruc;
    private TextArea nombre;
    private TextArea direccion;
    private TextArea telefono;
    private TextArea email;

    private Button btnIngresar;
    private Button btnEliminar;
    private Button btnModificar;
    private Button btnLimpiar;
    private Button btnCancelar;

    private HBox pnlRuc;
    private GridPane pnlNombDir;
    private GridPane pnlContactos;
   
    private HBox pnlBotones;
    private VBox pntPrincipal;

    @Override
    public void start(Stage primaryStage) {

//LABELS DE LOS CAMPOS A USAR
        txtRuc = new Text("RUC:      ");
        txtRuc.setFont(Font.font("Broadway", 25));
        txtRuc.setFill(Color.BLUEVIOLET);
        
        txtNombre = new Text("Nombres:");
        txtNombre.setFont(Font.font("Broadway", 20));
        txtNombre.setFill(Color.BLUEVIOLET);
        
        txtDireccion = new Text("Direccion:");
        txtDireccion.setFont(Font.font("Broadway", 20));
        txtDireccion.setFill(Color.BLUEVIOLET);
        
        txtTelefono = new Text("Telefono:");
        txtTelefono.setFont(Font.font("Broadway", 20));
        txtTelefono.setFill(Color.BLUEVIOLET);
        txtEmail = new Text("E-mail:");
        txtEmail.setFont(Font.font("Broadway", 20));
        txtEmail.setFill(Color.BLUEVIOLET);
        
        
        //CAJAS DE TEXTO PARA CAMPOS
        ruc = new TextArea("");
        nombre = new TextArea("");
        direccion = new TextArea("");
        telefono = new TextArea("");
        email = new TextArea("");
        
        //BOTONES A USAR
        btnIngresar = new Button("Ingresar");
        btnIngresar.setFont(Font.font("ALGERIAN",FontWeight.BLACK, 25));
        btnIngresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnIngresarEventHandler(event);
            }
        });
        
        
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("ALGERIAN",FontWeight.BOLD, 25));
        btnLimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnLimpiarEventHandler(event);
            }
        });
        btnCancelar = new Button("Cancelar");
        btnCancelar.setFont(Font.font("ALGERIAN",FontWeight.BOLD, 25));
//INGRESO EN PANELES
//SUPERIOR
        pnlRuc = new HBox(20);
        pnlRuc.getChildren().addAll(txtRuc, ruc);
//nombre
        pnlNombDir = new GridPane();
        pnlNombDir.setHgap(20);
        pnlNombDir.setVgap(20);
        pnlNombDir.add(txtNombre, 0, 0);
        pnlNombDir.add(nombre, 1, 0);
        pnlNombDir.add(txtDireccion, 2, 0);
        pnlNombDir.add(direccion, 3, 0);
//Contactos
        pnlContactos = new GridPane();
        pnlContactos.setHgap(20);
        pnlContactos.setVgap(10);
        pnlContactos.add(txtTelefono, 0, 0);
        pnlContactos.add(telefono, 1, 0);
        pnlContactos.add(txtEmail, 0, 1);
        pnlContactos.add(email, 1, 1);

    
//botones
        pnlBotones = new HBox(20);
        pnlBotones.getChildren().addAll(btnIngresar, btnLimpiar, btnCancelar);
        pnlBotones.setAlignment(Pos.CENTER);
        //final
        pntPrincipal = new VBox(10);
//        btnEliminar=new Button("Temporal");
//        btnEliminar.setFont(Font.font("Arial Black",40));
        logo = new Image("file:src\\unachkardex\\multimedia\\proveedorr.jpg");
        visorlogo = new ImageView();
        visorlogo.setImage(logo);
        visorlogo.setFitHeight(200);
        visorlogo.setPreserveRatio(true);
        pntPrincipal.getChildren().addAll(visorlogo, pnlRuc, pnlNombDir, pnlContactos, pnlBotones);
        pntPrincipal.setAlignment(Pos.CENTER);
        pntPrincipal.setPadding(new Insets(25));
        
        
        Scene scene = new Scene(pntPrincipal, 600, 500);

        primaryStage.setTitle("Proveedor.");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    public void btnLimpiarEventHandler(ActionEvent event){
       
            ruc.setText(null);
            nombre.setText("");
            direccion.setText(null);
            telefono.setText("");
            email.setText(null);
        }
            
   
    public void btnIngresarEventHandler(ActionEvent event){
        IProveedor proveedorDao=new ImplProveedor();
        try {
            Proveedor nuevoProveedor=new Proveedor();
            nuevoProveedor.setRuc(ruc.getText());
            nuevoProveedor.setNombre(nombre.getText());
            nuevoProveedor.setDireccion(direccion.getText());
            nuevoProveedor.setTelefono(telefono.getText());
            nuevoProveedor.seteMail(email.getText());
            
            if(proveedorDao.ingresar(nuevoProveedor)>0){
                System.out.println("Ingreso Correcto..");
            }
            else{
                System.out.println("Error de Ingreso..");
            }
        } catch (Exception e) {
            System.out.println("Error de Ingreso"+e.getMessage());
        }
    }

}
