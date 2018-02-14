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

public class FormListCategoria{

    private TableView<Categoria> tblCategoria;
    private Label titulo;
    private TableColumn<Categoria, Integer> cmlCodCategoria;
    private TableColumn<Categoria, String> cmlNombreCategoria;
    private TableColumn<Categoria, String> cmlDescrCategoria;
    private VBox pntPrincipal;
private Image pFondo;
    private BackgroundImage fondo;
    
    public FormListCategoria() {

        pFondo=new Image("file:src\\unachkardex\\multimedia\\FondoSubVentanas.jpg");
        fondo=new BackgroundImage(pFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        titulo = new Label("LISTADO DE CATEGORIAS");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 30));
        tblCategoria = new TableView();
        cmlCodCategoria = new TableColumn<>("Codigo");
        cmlNombreCategoria = new TableColumn<>("Nombre");
        cmlDescrCategoria = new TableColumn<>("Descripcion");
        cmlDescrCategoria.setMaxWidth(250);
        cmlDescrCategoria.setMinWidth(250);
        tblCategoria.getColumns().addAll(cmlCodCategoria, cmlNombreCategoria, cmlDescrCategoria);
        cargarCategorias();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblCategoria);
        pntPrincipal.setAlignment(Pos.CENTER);
        pntPrincipal.setPadding(new Insets(10));
        pntPrincipal.setBackground(new Background(fondo));
        pntPrincipal.setStyle("-fx-padding: 10; -fx-border-color: mediumblue; -fx-border-width: 2px");
    }
    public Node getPantallaP() {
        return pntPrincipal;
    }
    public void cargarCategorias() {
        List<Categoria> listCategorias = new ArrayList<>();
        ICategoria categDao = new ImplCategoria();

        try {
            listCategorias = categDao.obtener();
            cmlCodCategoria.setCellValueFactory(new PropertyValueFactory<>("codCategoria"));
            cmlNombreCategoria.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            cmlDescrCategoria.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
            tblCategoria.getItems().addAll(listCategorias);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
