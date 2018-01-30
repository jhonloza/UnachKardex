package unachkardex.vistas;

import com.sun.javafx.geom.Area;
import java.awt.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import java.util.*;
import javafx.scene.Node;
import javafx.scene.text.Text;

public class FormCliente extends Application {

    private GridPane panelInterno1;
    private GridPane panelMedio;
    private Text txtCedula;
    private Text txtNombres;
    private Text txtApellidos;
    private Text txtFechaNacimiento;
    private Text txtDireccion;
    private Text txtTelefono;
    private Text txtEmail;

    private TextArea cedula;
    private TextField nombres;
    private TextField apellidos;
    private TextField fechaNacimiento;
    private TextField direccion;
    private TextField telefono;
    private TextField email;
    Label campo1;
    private VBox temporal;

    @Override
    public void start(Stage primaryStage) {

        campo1 = new Label("Cedula");
        //LABELS DE LOS CAMPOS A USAR
        txtCedula = new Text("Cedula");
        txtCedula.setFont(javafx.scene.text.Font.font("Arial Black", 25));
//        txtCedula.setFill(Paint.valueOf(Color.RED));
        txtNombres = new Text("Nombres");
        txtApellidos = new Text("Apellidos");
        txtFechaNacimiento = new Text("Fecha de Nacimiento");
        txtDireccion = new Text("Direccion");
        txtTelefono = new Text("Telefono");
        txtEmail = new Text("E-mail");
        
        cedula=new TextArea("");
        nombres=new TextField("");
        apellidos=new TextField("");
        fechaNacimiento=new TextField("");
        direccion=new TextField("");
        telefono=new TextField("");
        email=new TextField("");

        //PANEL INTERNO CON CAMPOS A USARSE
        panelInterno1 = new GridPane();
        panelInterno1.setVgap(10);
        panelInterno1.setHgap(10);
        panelInterno1.add(txtCedula,0,0);
        panelInterno1.add(txtNombres,0,1);
        panelInterno1.add(txtApellidos,0,2);
        panelInterno1.add(txtFechaNacimiento,0,3);
        panelInterno1.add(txtDireccion,0,4);
        panelInterno1.add(txtTelefono,0,5);
        panelInterno1.add(txtEmail,2,5);
//        
        panelMedio=new GridPane();
        panelMedio.setHgap(10);
        panelMedio.setVgap(5);
//        panelMedio.setBackground(new Background(images));
        panelMedio.add(txtCedula, 0, 0);
        panelMedio.add(panelInterno1, 1, 0);
        
        

        Scene scene = new Scene(panelMedio);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
