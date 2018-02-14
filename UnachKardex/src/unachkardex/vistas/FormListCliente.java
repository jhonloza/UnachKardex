
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
import javafx.scene.control.cell.*;
import javafx.stage.*;
import javafx.scene.image.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;

public class FormListCliente{
    private TableView<Cliente> tblCliente;
    private Label titulo;
    private TableColumn<Cliente, Integer> cmlCedula;
    private TableColumn<Cliente, String> cmlNombre;
    private TableColumn<Cliente, String> cmlApellido;
    private TableColumn<Cliente, String> cmlDireccion;
    private TableColumn<Cliente, String> cmlTelefono;
    private TableColumn<Cliente, String> cmleMail;
    private TableColumn<Cliente, String> cmlFechaNac;
    private VBox pntPrincipal;
    
    public FormListCliente() {
         titulo = new Label("LISTADO DE CLIENTES");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 30));
        tblCliente = new TableView();
        cmlCedula = new TableColumn<>("Codigo");
        cmlNombre= new TableColumn<>("Nombre");
        cmlApellido = new TableColumn<>("Apellido");
        cmlDireccion = new TableColumn<>("Direccion");
        cmlDireccion.setMaxWidth(150);
        cmlDireccion.setMinWidth(150);
        cmlTelefono = new TableColumn<>("Telefono");
        cmleMail = new TableColumn<>("Email");
        cmleMail.setMaxWidth(150);
        cmleMail.setMinWidth(150);
        cmlFechaNac = new TableColumn<>("Fecha_Nacimiento");
        tblCliente.getColumns().addAll(cmlCedula, cmlNombre, cmlApellido,cmlDireccion,cmlTelefono,cmleMail,cmlFechaNac);
        cargarClientes();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblCliente);
        pntPrincipal.setAlignment(Pos.CENTER);
    }

    public Node getPantallaP() {
        return pntPrincipal;
    }

    public void cargarClientes() {
        List<Cliente> listCliente = new ArrayList<>();
        ICliente clientDao = new ImplCliente();

        try {
            listCliente = clientDao.obtener();
            cmlCedula.setCellValueFactory(new PropertyValueFactory<>("Cedula"));
            cmlNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            cmlApellido.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
            cmlDireccion.setCellValueFactory(new PropertyValueFactory<>("Direccion"));
            cmlTelefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
            cmleMail.setCellValueFactory(new PropertyValueFactory<>("eMail"));
            cmlFechaNac.setCellValueFactory(new PropertyValueFactory<>("fechaNac"));
            tblCliente.getItems().addAll(listCliente);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
