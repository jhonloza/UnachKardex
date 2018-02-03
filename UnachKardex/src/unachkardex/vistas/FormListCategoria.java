package unachkardex.vistas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.*;
import unachkardex.negocio.dao.ICategoria;
import unachkardex.negocio.entidades.Categoria;
import unachkardex.negocio.impl.ImplCategoria;

public class FormListCategoria extends Application {

    private TableView tblCategoria;
    private Label titulo;
    private TableColumn cmlCodCategoria;
    private TableColumn cmlNombreCategoria;
    private TableColumn cmlDescrCategoria;
    private VBox pntPrincipal;

    @Override
    public void start(Stage primaryStage) {

        titulo = new Label("LISTADO DE CATEGORIAS");
        titulo.setFont(Font.font("ARIAL BLACK", 30));
        tblCategoria = new TableView();
        cmlCodCategoria = new TableColumn("Codigo");
        cmlNombreCategoria = new TableColumn("Nombre");
        cmlDescrCategoria = new TableColumn("Descripcion");
        cargarCategorias();
        tblCategoria.getColumns().addAll(cmlCodCategoria, cmlNombreCategoria, cmlDescrCategoria);

        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo,tblCategoria);
        pntPrincipal.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pntPrincipal, 480, 250);

        primaryStage.setTitle("Listado de Categorias");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void cargarCategorias(){
        List<Categoria> listCategorias=new ArrayList<>();
        ICategoria categDao=new ImplCategoria();
        try {
            listCategorias=categDao.obtener();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        for(Categoria categ:listCategorias){
            cmlCodCategoria.getColumns().addAll(categ.getCodCategoria());
            cmlNombreCategoria.getColumns().addAll(categ.getNombre());
            cmlDescrCategoria.getColumns().addAll(categ.getDescripcion());
        }
    }
}
