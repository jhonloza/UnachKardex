package unachkardex.vistas;

import java.awt.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import java.util.*;
import javafx.scene.Node;
import javafx.scene.text.Text;

public class FormCliente extends Application {

    private HBox panelInterno1;
    private Text txtCedula;
    Label campo1;
    private VBox temporal;
    
    @Override
    public void start(Stage primaryStage) {
        
        campo1 = new Label("Cedula");
        //LABELS DE LOS CAMPOS A USAR
        txtCedula = new Text("Cedula");
        txtCedula.setFont(javafx.scene.text.Font.font("Times New Roman", 25));
//        txtCedula.setFill(Color.RED);
//        labelNombres = new Label("Nombres");
//        labelApellidos = new Label("Apellidos");
//        labelFecha = new Label("Fecha de Nacimiento");
//        labelDir = new Label("Direccion");
//        labelTelf = new Label("Telefono");
//        labelEmail = new Label("E-mail");

        //PANEL INTERNO CON CAMPOS A USARSE
        panelInterno1=new HBox();
        
        panelInterno1.getChildren().add(new Text("Cedula"));
//        
        
        Scene scene = new Scene(panelInterno1);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
