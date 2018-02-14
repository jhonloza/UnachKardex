
package unachkardex.vistas;
import javafx.application.Application;
import javafx.event.ActionEvent;
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
public class FormListFacturaVenta{
    private TableView<FacturaVenta> tblFacturaVenta;
    private Label titulo;
    private TableColumn<FacturaVenta, Integer> cmlcodFacturaVenta;
    private TableColumn<FacturaVenta, String> cmlFecha;
    private TableColumn<FacturaVenta, Cliente> cmlCliente;
    
    private VBox pntPrincipal;
    
    public FormListFacturaVenta() {
         titulo = new Label("LISTADO DE FACTURA VENTA");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 30));
        tblFacturaVenta = new TableView();
        cmlcodFacturaVenta = new TableColumn<>("Codigo Fac_Vent");
        cmlFecha= new TableColumn<>("Fecha");
        cmlCliente = new TableColumn<>("Cliente");
       
        tblFacturaVenta.getColumns().addAll(cmlcodFacturaVenta, cmlFecha, cmlCliente);
        cargarFacturaVenta();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblFacturaVenta);
        pntPrincipal.setAlignment(Pos.CENTER);
    }

    public Node getPantallaP() {
        return pntPrincipal;
    }

    public void cargarFacturaVenta() {
        List<FacturaVenta> listFV = new ArrayList<>();
        IFacturaVenta fvDao = new ImplFacturaVenta();

        try {
            listFV = fvDao.obtener();
            cmlcodFacturaVenta.setCellValueFactory(new PropertyValueFactory<>("codFacturaVenta"));
            cmlFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
            cmlCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
            
            tblFacturaVenta.getItems().addAll(listFV);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
