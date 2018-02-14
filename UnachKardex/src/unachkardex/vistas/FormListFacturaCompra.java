
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

public class FormListFacturaCompra{
    private TableView<FacturaCompra> tblFacturaCompra;
    private Label titulo;
    private TableColumn<FacturaCompra, Integer> cmlcodFacturaCompra;
    private TableColumn<FacturaCompra, String> cmlFecha;
    private TableColumn<FacturaCompra, Proveedor> cmlProveedor;
    private Image pFondo;
    private BackgroundImage fondo;
    private VBox pntPrincipal;
    
    public FormListFacturaCompra() {
        pFondo=new Image("file:src\\unachkardex\\multimedia\\FondoSubVentanas.jpg");
        fondo=new BackgroundImage(pFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
         titulo = new Label("LISTADO DE FACTURA COMPRA");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 30));
        tblFacturaCompra = new TableView();
        cmlcodFacturaCompra = new TableColumn<>("Codigo Fac_Com");
        cmlFecha= new TableColumn<>("Fecha");
        cmlProveedor = new TableColumn<>("Proveedor");
       
        tblFacturaCompra.getColumns().addAll(cmlcodFacturaCompra, cmlFecha, cmlProveedor);
        cargarFacturaCompra();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblFacturaCompra);
        pntPrincipal.setAlignment(Pos.CENTER);
        pntPrincipal.setPadding(new Insets(10));
        pntPrincipal.setBackground(new Background(fondo));
        pntPrincipal.setStyle("-fx-padding: 10; -fx-border-color: mediumblue; -fx-border-width: 2px");
        
    }

    public Node getPantallaP() {
        return pntPrincipal;
    }

    public void cargarFacturaCompra() {
        List<FacturaCompra> listFV = new ArrayList<>();
        IFacturaCompra fvDao = new ImplFacturaCompra();

        try {
            listFV = fvDao.obtener();
            cmlcodFacturaCompra.setCellValueFactory(new PropertyValueFactory<>("codFacturaCompra"));
            cmlFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
            cmlProveedor.setCellValueFactory(new PropertyValueFactory<>("proveedor"));
            
            tblFacturaCompra.getItems().addAll(listFV);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
