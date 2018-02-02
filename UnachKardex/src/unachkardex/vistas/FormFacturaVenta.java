package unachkardex.vistas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.*;

import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.reflect.Field;

import java.text.DateFormat;
import java.text.MessageFormat;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.vistas.*;

public class FormFacturaVenta extends Application {

    private GridPane pnlCliente;
    private Text txtcedula;
    private Text txtnombres;
    
    private Text txtdireccion;
    private Text txttelefono;
    private Text txtemail;

    private TextArea cedula;
    private TextArea nombres;  
    private TextArea direccion;
    private TextArea telefono;
    private TextArea email;

    private HBox pnlCel;
    private GridPane pnlNomb;
    private GridPane pnlresto;
    private GridPane pnlmail;
    private VBox pnlprincipal;
    private VBox pnlprincipal2;
    private Button btnBuscar;
    
    //////////////////////////FACTURA VENTA
    
    private Text txtcodigofa;
    private Text txtfecha;
    
    private TextArea codigofa;
    private TextArea fecha;
    
    private GridPane pnlfac;
    
    
   

    @Override

    public void start(Stage primaryStage) {

        txtcedula = new Text("CEDULA DEL CLIENTE:                ");
        //txtcedula.setFont(javafx.scene.text.Font.font("Arial Black", 20));
        
        btnBuscar = new Button("BUSCAR");
        
        txtnombres = new Text("NOMBRE DEL CLIENTE");
        //txtnombre.setFont(javafx.scene.text.Font.font("Arial Black", 20));
        
       
        txtdireccion = new Text("DIRECCION DEL CLIENTE");
        //txtdireccion.setFont(javafx.scene.text.Font.font("Arial Black", 20));
        
        txttelefono = new Text("TELEFONO DEL CLIENTE");
       // txttelefono.setFont(javafx.scene.text.Font.font("Arial Black", 20));
        
        txtemail = new Text("MAIL DEL CLIENTE");
        //txtemail.setFont(javafx.scene.text.Font.font("Arial Black", 20));

        //cajas de texto
        cedula = new TextArea("");
        nombres = new TextArea("");
        direccion = new TextArea("");
        telefono = new TextArea("");
        email = new TextArea("");
///ingreso paneles
        pnlCel = new HBox(20);
        pnlCel.getChildren().addAll(txtcedula, cedula ,btnBuscar);
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
        
         
        ///////////////////////////////FACTURA VENTS////////////////////
        
        
        txtcodigofa = new Text("CODIGO FACTURA:    ");
        
        txtfecha = new Text("FECHA:");
        
        
        codigofa = new TextArea("");
        fecha = new TextArea("");
        
        pnlfac = new GridPane();
        pnlfac.add(txtcodigofa, 0, 0);
        pnlfac.add(codigofa, 1, 0);
        pnlfac.add(txtfecha, 0, 1 );
        pnlfac.add(fecha, 1, 1);
     //   pnlfac.setAlignment(Pos.CENTER);
        
          
        
        
        pnlprincipal = new VBox(10);
        
        pnlprincipal.getChildren().addAll(pnlCel,pnlNomb, pnlresto, pnlmail , pnlfac );
        pnlprincipal.setAlignment(Pos.CENTER);
        pnlprincipal.setPadding(new Insets(25)); 
        //pnlprincipal.setPrefSize(320, 200);
        
        
       
        
       Scene scene = new Scene(pnlprincipal, 580, 240);

        primaryStage.setTitle("FACTURA VENTA");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
