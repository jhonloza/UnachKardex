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

public class FormListProveedor {

    private TableView<Proveedor> tblProveedor;
    private Label titulo;
    private TableColumn<Proveedor, String> cmlRuc;
    private TableColumn<Proveedor, String> cmlNombre;
    private TableColumn<Proveedor, String> cmlDireccion;
    private TableColumn<Proveedor, String> cmlTelefono;
    private TableColumn<Proveedor, String> cmleMail;
    private VBox pntPrincipal;

    public FormListProveedor() {

        titulo = new Label("LISTADO DE PROVEEDORES");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 30));
        tblProveedor = new TableView();
        cmlRuc = new TableColumn<>("Ruc");
        cmlNombre = new TableColumn<>("Nombre");
        cmlDireccion = new TableColumn<>("Direccion");
        cmlDireccion.setMaxWidth(250);
        cmlDireccion.setMinWidth(250);
        cmlTelefono = new TableColumn<>("Telefono");
        cmleMail = new TableColumn<>("Email");
        cmleMail.setMaxWidth(250);
        cmleMail.setMinWidth(250);
        tblProveedor.getColumns().addAll(cmlRuc, cmlNombre, cmlDireccion, cmlTelefono, cmleMail);
        cargarProveedor();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblProveedor);
        pntPrincipal.setAlignment(Pos.CENTER);
    }
    public Node getPantallaP() {
        return pntPrincipal;
    }

    public void cargarProveedor() {
        List<Proveedor> listProveedor = new ArrayList<>();
        IProveedor proDao = new ImplProveedor();

        try {
            listProveedor = proDao.obtener();
            cmlRuc.setCellValueFactory(new PropertyValueFactory<>("ruc"));
            cmlNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            cmlDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
            cmlTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
            cmleMail.setCellValueFactory(new PropertyValueFactory<>("eMail"));
            tblProveedor.getItems().addAll(listProveedor);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
