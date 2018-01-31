///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package unachkardex.vistas;
//
//import com.sun.javafx.geom.Area;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.text.*;
//import javafx.scene.effect.*;
//import javafx.scene.paint.*;
//import javafx.scene.control.*;
//import javafx.scene.layout.*;
//import javafx.stage.Stage;
//import javafx.geometry.*;
//import java.util.*;
//import static javafx.application.Application.launch;
//import javafx.event.Event;
//import javafx.event.EventDispatchChain;
//import javafx.event.EventDispatcher;
//import javafx.scene.Node;
//import javafx.scene.text.Text;
//
//public class FormDetalleCompra extends Poveedor {
//
//    private Text txtCedula;
//    private Text txtNombres;
//    private Text txtApellidos;
//    private Text txtFechaNacimiento;
//    private Text txtDireccion;
//    private Text txtTelefono;
//    private Text txtEmail;
//
//    
//    private TextArea cedula;
//    private TextArea nombres;
//    private TextArea apellidos;
//    private TextArea fechaNacimiento;
//    private TextArea direccion;
//    private TextArea telefono;
//    private TextArea email;
//    
//    private Button btnIngresar;
//    private Button btnEliminar;
//    private Button btnModificar;
//    private Button btnLimpiar;
//    private Button btnCancelar;
//    
//    private HBox pnlced;
//    private GridPane pnlNombApe;
//    private GridPane pnlFechDir;
//    private GridPane pnlcontacto;
//    private HBox pnlBotones;
//    private VBox pntPrincipal;
//
//    @Override
//    public void start(Stage primaryStage) {
//        //LABELS DE LOS CAMPOS A USAR
//        txtCedula = new Text("Cedula");
//        txtCedula.setFont(Font.font("Arial Black", 20));
//        txtCedula.setFill(Color.AQUA);
//        txtNombres = new Text("Nombres");
//        txtNombres.setFont(Font.font("Arial Black", 20));
//        txtApellidos = new Text("Apellidos");
//        txtApellidos.setFont(Font.font("Arial Black", 20));
//        txtFechaNacimiento = new Text("Fecha de Nacimiento");
//        txtFechaNacimiento.setFont(Font.font("Arial Black", 20));
//        txtDireccion = new Text("Direccion");
//        txtDireccion.setFont(Font.font("Arial Black", 20));
//        txtTelefono = new Text("Telefono");
//        txtTelefono.setFont(Font.font("Arial Black", 20));
//        txtEmail = new Text("E-mail");
//        txtEmail.setFont(Font.font("Arial Black", 20));
//        //CAJAS DE TEXTO PARA CAMPOS
//        cedula = new TextArea("");
//        nombres = new TextArea("");
//        apellidos = new TextArea("");
//        fechaNacimiento = new TextArea("");
//        direccion = new TextArea("");
//        telefono = new TextArea("");
//        email = new TextArea("");
//        //BOTONES A USAR
//        btnIngresar = new Button("Ingresar");
//        btnIngresar.setFont(Font.font("Arial Black", 20));
//        btnEliminar = new Button("Eliminar");
//        btnEliminar.setFont(Font.font("Arial Black", 20));
//        btnModificar = new Button("Modificar");
//        btnModificar.setFont(Font.font("Arial Black", 20));
//        btnModificar.setEventDispatcher(new EventDispatcher() {
//            @Override
//            public Event dispatchEvent(Event event, EventDispatchChain tail) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//        btnLimpiar = new Button("Limpiar");
//        btnLimpiar.setFont(Font.font("Arial Black", 20));
//        btnCancelar = new Button("Cancelar");
//        btnCancelar.setFont(Font.font("Arial Black", 20));
//        //INGRESO EN PANELES
//        //SUPERIOR
//        pnlced=new HBox(20);
//        pnlced.getChildren().addAll(txtCedula, cedula);
//        //nombre
//        pnlNombApe=new GridPane();
//        pnlNombApe.setHgap(20);
//        pnlNombApe.setVgap(20);
//        pnlNombApe.add(txtNombres, 0, 0);
//        pnlNombApe.add(nombres, 1, 0);
//        pnlNombApe.add(txtApellidos, 2, 0);
//        pnlNombApe.add(apellidos, 3, 0);
//        //fecha y direccion
//        pnlFechDir=new GridPane();
//        pnlFechDir.setHgap(20);
//        pnlFechDir.setVgap(10);
//        pnlFechDir.add(txtFechaNacimiento, 0, 0);
//        pnlFechDir.add(fechaNacimiento, 1, 0);
//        pnlFechDir.add(txtDireccion, 0, 1);
//        pnlFechDir.add(direccion, 1, 1);
//        
//        //Contacto        
//        pnlcontacto=new GridPane();
//        pnlcontacto.setHgap(20);
//        pnlcontacto.setVgap(20);
//        pnlcontacto.add(txtTelefono, 0, 0);
//        pnlcontacto.add(telefono, 1, 0);
//        pnlcontacto.add(txtEmail, 2, 0);
//        pnlcontacto.add(email, 3, 0);
//        //botones
//        pnlBotones=new HBox(20);
//        pnlBotones.getChildren().addAll(btnIngresar,btnLimpiar,btnCancelar);
//        pnlBotones.setAlignment(Pos.CENTER);
//        //final
//        pntPrincipal=new VBox(10);
//        btnEliminar=new Button("Temporal");
//        btnEliminar.setFont(Font.font("Arial Black",40));
//        pntPrincipal.getChildren().addAll(btnEliminar,pnlced,pnlNombApe,pnlFechDir,pnlcontacto,pnlBotones);
//        pntPrincipal.setAlignment(Pos.CENTER);
//        pntPrincipal.setPadding(new Insets(25));
//        Scene scene = new Scene(pntPrincipal,620,420);
//        
//        
//        primaryStage.setTitle("Cliente");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
    
//}
