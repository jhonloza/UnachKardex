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

    private Text txtcodigo;
    private Text txtfecha;
    private Text txtcliente;
    private TextArea codigo;
    private TextArea fecha;
    private TextArea desClien;
    private FormCliente frcli;
    private ComboBox<Cliente> listClient;

    ObservableList<Cliente> lsClientes;

    private Button btnAceptar;
    private Button btnModificar;
    private Button btnEliminar;

    private VBox pnlCliente;
    private VBox pnlfv;

    private GridPane pnlCentral;
    private GridPane pnlBotones;
    private GridPane pnlPrincipal;

    @Override

    public void start(Stage primaryStage) {
         frcli = new FormCliente();
        txtcodigo = new Text("CODIGO");
        txtcodigo.setFont(javafx.scene.text.Font.font("Arial Black", 20));
        codigo = new TextArea("");
        txtfecha = new Text("FECHA");
        txtfecha.setFont(javafx.scene.text.Font.font("Arial Black", 20));
        fecha = new TextArea("");

        txtcliente = new Text("CLIENTE");
        txtcliente.setFont(javafx.scene.text.Font.font("Arial Black", 20));

        listClient = new ComboBox<Cliente>();
        cargarClientes();
        listClient.setItems(lsClientes);
        desClien = new TextArea("");

        btnAceptar = new Button("Aceptar");
        btnAceptar.setFont(Font.font("Arial Black", 20));
        btnModificar = new Button("Modificar");
        btnModificar.setFont(Font.font("Arial Black", 20));
        btnEliminar = new Button("Eliminar");
        btnEliminar.setFont(Font.font("Arial Black", 20));

        pnlfv = new VBox();
        pnlfv.getChildren().add(txtcodigo);
        pnlfv.getChildren().add(codigo);
        pnlfv.getChildren().add(txtfecha);
        pnlfv.getChildren().add(fecha);

        pnlCliente = new VBox();
        pnlCliente.getChildren().add(txtcliente);
        pnlCliente.getChildren().add(listClient);
        pnlCliente.getChildren().add(desClien);

        pnlCentral = new GridPane();
        pnlCentral.setVgap(10);
        pnlCentral.setHgap(10);
        pnlCentral.add(pnlfv, 0, 2);
        pnlCentral.add(pnlCliente, 0, 1);

        pnlBotones = new GridPane();
        pnlBotones.setVgap(10);
        pnlBotones.setHgap(10);
        pnlBotones.add(btnAceptar, 0, 0);
        pnlBotones.setAlignment(Pos.CENTER);

        pnlPrincipal = new GridPane();
        pnlPrincipal.setVgap(10);
        pnlPrincipal.setHgap(10);
        pnlPrincipal.add(pnlCentral, 0, 0);
        pnlPrincipal.add(pnlBotones, 0, 1);
        pnlPrincipal.setPadding(new Insets(25));

        Scene scene = new Scene(pnlPrincipal, 600, 400);
        primaryStage.setTitle("FACTURA DE SALIDA");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
     public void cargarClientes() {

        ICliente cliDao = new ImplCliente();
        try {
//            lsClientes = cliDao.obtener();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CURSOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }

    }

}
