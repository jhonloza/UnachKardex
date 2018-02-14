
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
    
    private VBox pntPrincipal;
    
    public FormListFacturaCompra() {
         titulo = new Label("LISTADO DE FACTURA COMPRA");
        titulo.setFont(Font.font("CHILLER", 30));
        tblFacturaCompra = new TableView();
        cmlcodFacturaCompra = new TableColumn<>("Codigo Fac_Com");
        cmlFecha= new TableColumn<>("Fecha");
        cmlProveedor = new TableColumn<>("Proveedor");
       
        tblFacturaCompra.getColumns().addAll(cmlcodFacturaCompra, cmlFecha, cmlProveedor);
        cargarFacturaCompra();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblFacturaCompra);
        pntPrincipal.setAlignment(Pos.CENTER);
        
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
