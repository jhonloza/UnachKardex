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
import javafx.scene.*;
import javafx.scene.Node;
import javafx.scene.text.Text;
import unachkardex.negocio.dao.ICliente;
import unachkardex.negocio.entidades.Cliente;
import unachkardex.negocio.impl.ImplCliente;

public class FormCliente extends Region {

    private Label txtCedula;
    private Label txtNombres;
    private Label txtApellidos;
    private Label txtFechaNacimiento;
    private Label txtDireccion;
    private Label txtTelefono;
    private Label txtEmail;

    Image logo;
    ImageView visorlogo;

    private TextField cedula;
    private TextField nombres;
    private TextField apellidos;
    private TextField fechaNacimiento;
    private TextField direccion;
    private TextField telefono;
    private TextField email;

    private Button btnIngresar;
    private Button btnEliminar;
    private Button btnModificar;
    private Button btnLimpiar;
    private Button btnCancelar;

    private HBox pnlced;
    private GridPane pnlNombApe;
    private GridPane pnlFechDir;
    private GridPane pnlcontacto;
    private HBox pnlBotones;
    private VBox pntPrincipal;

    public void FormCliente() throws Exception {
        
        //LABELS DE LOS CAMPOS A USAR
        txtCedula = new Label("Cedula: ");
        txtCedula.setFont(Font.font("Arial Black", 20));
        //txtCedula.setFill(Color.DARKBLUE);
        txtNombres = new Label("Nombres: ");
        txtNombres.setFont(Font.font("Arial Black", 20));
        //txtNombres.setFill(Color.DARKBLUE);
        txtApellidos = new Label("Apellidos: ");
        txtApellidos.setFont(Font.font("Arial Black", 20));
        //txtApellidos.setFill(Color.DARKBLUE);
        txtFechaNacimiento = new Label("Fecha de Nacimiento: ");
        txtFechaNacimiento.setFont(Font.font("Arial Black", 20));
        //txtFechaNacimiento.setFill(Color.DARKBLUE);
        txtDireccion = new Label("Direccion: ");
        txtDireccion.setFont(Font.font("Arial Black", 20));
        //txtDireccion.setFill(Color.DARKBLUE);
        txtTelefono = new Label("Telefono: ");
        txtTelefono.setFont(Font.font("Arial Black", 20));
        //txtTelefono.setFill(Color.DARKBLUE);
        txtEmail = new Label("E-mail: ");
        txtEmail.setFont(Font.font("Arial Black", 20));
        //txtEmail.setFill(Color.DARKBLUE);
        
        //CAJAS DE TEXTO PARA CAMPOS
        cedula = new TextField("");
        nombres = new TextField("");
        apellidos = new TextField("");
        fechaNacimiento = new TextField("");
        direccion = new TextField("");
        telefono = new TextField("");
        email = new TextField("");
        //BOTONES A USAR
        btnIngresar = new Button("Ingresar");
        btnIngresar.setFont(Font.font("Arial Black", 20));
        btnIngresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnIngresarEventHandler(event);
            }
        });
        
        
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("Arial Black", 20));
        btnCancelar = new Button("Cancelar");
        btnCancelar.setFont(Font.font("Arial Black", 20));
        //INGRESO EN PANELES
        //SUPERIOR
        pnlced = new HBox(20);
        pnlced.getChildren().addAll(txtCedula, cedula);
        //nombre
        pnlNombApe = new GridPane();
        pnlNombApe.setHgap(20);
        pnlNombApe.setVgap(20);
        pnlNombApe.add(txtNombres, 0, 0);
        pnlNombApe.add(nombres, 1, 0);
        pnlNombApe.add(txtApellidos, 2, 0);
        pnlNombApe.add(apellidos, 3, 0);
        //fecha y direccion
        pnlFechDir = new GridPane();
        pnlFechDir.setHgap(20);
        pnlFechDir.setVgap(10);
        pnlFechDir.add(txtFechaNacimiento, 0, 0);
        pnlFechDir.add(fechaNacimiento, 1, 0);
        pnlFechDir.add(txtDireccion, 0, 1);
        pnlFechDir.add(direccion, 1, 1);

        //Contacto        
        pnlcontacto = new GridPane();
        pnlcontacto.setHgap(20);
        pnlcontacto.setVgap(20);
        pnlcontacto.add(txtTelefono, 0, 0);
        pnlcontacto.add(telefono, 1, 0);
        pnlcontacto.add(txtEmail, 2, 0);
        pnlcontacto.add(email, 3, 0);
        //botones
        pnlBotones = new HBox(20);
        pnlBotones.getChildren().addAll(btnIngresar, btnLimpiar, btnCancelar);
        pnlBotones.setAlignment(Pos.CENTER);
        //final
        pntPrincipal = new VBox(10);
        logo = new Image("file:src\\unachkardex\\multimedia\\logo.jpg");
        visorlogo = new ImageView();
        visorlogo.setImage(logo);
        visorlogo.setFitHeight(200);
        visorlogo.setPreserveRatio(true);
        pntPrincipal.getChildren().addAll(visorlogo, pnlced, pnlNombApe, pnlFechDir, pnlcontacto, pnlBotones);
        pntPrincipal.setAlignment(Pos.CENTER);
        pntPrincipal.setPadding(new Insets(25));
        Scene scene = new Scene(pntPrincipal, 710, 520);
    }

    private class Delta {

        double x, y;
    }

    
    public void btnIngresarEventHandler(ActionEvent event){
        ICliente clienteDao=new ImplCliente();
        try {
            Cliente nuevoCliente=new Cliente();
            nuevoCliente.setCedula(cedula.getText());
            nuevoCliente.setNombre(nombres.getText());
            nuevoCliente.setApellido(apellidos.getText());
            nuevoCliente.setDireccion(direccion.getText());
            nuevoCliente.setTelefono(telefono.getText());
            nuevoCliente.seteMail(email.getText());
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            try {
                nuevoCliente.setFechaNac(formatoFecha.parse(fechaNacimiento.getText()));
            } catch (Exception er) {
                System.out.println("Error al insertar fecha"+er.getMessage());
            }
            if(clienteDao.insertar(nuevoCliente)>0){
                System.out.println("Ingreso Correcto");
            }
            else{
                System.out.println("Error de Ingreso");
            }
        } catch (Exception e) {
            System.out.println("Error de Ingreso"+e.getMessage());
        }
    }

}
