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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;
import javafx.scene.image.*;

public class FormKardexMensual extends Application {
    private TableView<Kardex> tblKardex;
    private TableColumn<Kardex, String> cmlTransaccion;
    private TableColumn<Kardex, Date> cmlFecha;
    private TableColumn<Kardex, Integer> cmleCantidad;
    private TableColumn<Kardex, Double> cmlePu;
    private TableColumn<Kardex, Double> cmlePt;
    private TableColumn<Kardex, Integer> cmleSalida;
    private TableColumn<Kardex, Double> cmlsPu;
    private TableColumn<Kardex, Double> cmlsPt;
    private TableColumn<Kardex, Integer> cmlexCantidad;
    private TableColumn<Kardex, Double> cmlexPu;
    private TableColumn<Kardex, Double> cmlexPt;
    
    private ArrayList<Kardex> listaKardexMensual;
    private Label lblproducto;
    private Label lblcodigo;
    private Label lblfecha1;
    private Label lblt;
    private Label lblfecha2;
    private Label lblentrada;
    private Label lblecantidad;
    private Label lblepu;
    private Label lblept;
    private Label lblsalida;
    private Label lblscantidad;
    private Label lblspu;
    private Label lblspt;
    private Label lblexistencia;
    private Label lblexcantidad;
    private Label lblexpu;
    private Label lblexpt;

    private ComboBox<Producto> cmbProducto;
    private ObservableList<Producto> itemsP = FXCollections.observableArrayList();
    private ArrayList<Producto> listProducto;
    private ComboBox<String> cmbAño;
    private ObservableList<String> itemsA = FXCollections.observableArrayList();
    private ArrayList<String> listAño;
    private ComboBox<String> cmbMes;
    private ObservableList<String> itemsM = FXCollections.observableArrayList();
    private ArrayList<String> listM;

    private Label txtcodigo;
    private VBox c1;
    private VBox c2;
    private VBox c3;
    private VBox c4;
    private HBox cabecera;
    
    private VBox kv1;
    private VBox kv2;
    private VBox kv3;
    private HBox kh1;
    private HBox kh2;
    private HBox kh3;
    private HBox kh4;
    
    private VBox pnlKardex;
    private VBox pmlIntKardex;
    private ScrollPane pnlKardexInt;
    private BorderPane pnlPrincipal;
    private  Button Calcular;
    @Override
    public void start(Stage primaryStage) throws Exception {
        cargarProducto();
        itemsA.addAll("2016","2017","2018","2019","2020");
        itemsM.addAll("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre");
        lblproducto = new Label("Producto: ");
        lblcodigo = new Label("Codigo: ");
        lblfecha1 = new Label("Fecha: ");
        txtcodigo = new Label("");
        txtcodigo.setMaxSize(100, 25);
        txtcodigo.setMinSize(100, 25);
        txtcodigo.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        cmbProducto = new ComboBox<Producto>();
        cmbProducto.setItems(itemsP);
        cmbAño = new ComboBox<String>(itemsA);
        cmbMes = new ComboBox<String>(itemsM);

        lblt=new Label("Transaccion.");
        lblfecha2=new Label("Fecha");
        lblentrada=new Label("Entrada");
        lblecantidad=new Label("Cantidad");
        lblepu=new Label("P. Unit");
        lblept=new Label("P. Total");
        lblsalida=new Label("Salida");
        lblscantidad=new Label("Cantidad");
        lblspu=new Label("P. Unit");
        lblspt=new Label("P. Total");
        lblexistencia=new Label("Existencia");
        lblexcantidad=new Label("Cantidad");
        lblexpu=new Label("P. Unit");
        lblexpt=new Label("P. Total");
    
        c1 = new VBox(5);
        c1.getChildren().addAll(lblproducto, lblcodigo);
        c1.setAlignment(Pos.CENTER);
        c2 = new VBox(5);
        c2.getChildren().addAll(cmbProducto, txtcodigo);
        c2.setAlignment(Pos.CENTER);
        c3 = new VBox(5);
        c3.getChildren().addAll(lblfecha1);
        c3.setAlignment(Pos.CENTER);
        c4 = new VBox(5);
        c4.getChildren().addAll(cmbAño, cmbMes);
        c4.setAlignment(Pos.CENTER);
        
        kh1 = new HBox(5);
        kh1.getChildren().addAll(lblecantidad, lblepu,lblept);
        kh1.setAlignment(Pos.TOP_CENTER);
        
        
        kh2 = new HBox(5);
        kh2.getChildren().addAll(lblscantidad, lblspu,lblspt);
        kh2.setAlignment(Pos.TOP_CENTER);
       
        
        
        kh3 = new HBox(5);
        kh3.getChildren().addAll(lblexcantidad, lblexpu,lblexpt);
        kh3.setAlignment(Pos.TOP_CENTER);
        

        kv1=new  VBox(5);
        kv1.getChildren().addAll(lblentrada,kh1);
        kv1.setAlignment(Pos.TOP_CENTER);
        
        kv2=new  VBox(5);
        kv2.getChildren().addAll(lblsalida, kh2);
        kv2.setAlignment(Pos.TOP_CENTER);
        
        kv3=new  VBox(5);
        kv3.getChildren().addAll(lblexistencia,kh3);
        kv3.setAlignment(Pos.TOP_CENTER);
        
                
        kh4 = new HBox(5);
        kh4.getChildren().addAll(lblt,lblfecha2,kv1,kv2,kv3);
        kh4.setAlignment(Pos.TOP_CENTER);
        
        

        Calcular= new Button("Calcular");
        cabecera = new HBox(5);
        cabecera.getChildren().addAll(c1, c2, c3, c4, Calcular);
        cabecera.setAlignment(Pos.CENTER);
        cabecera.setPadding(new Insets(25) );
        
        tblKardex=new TableView();
         cmlTransaccion=new TableColumn<>("Transaccion");
         cmlTransaccion.setMaxWidth(50);
         cmlTransaccion.setMinWidth(50);
        cmlFecha=new TableColumn<>("Fecha");
        cmlFecha.setMaxWidth(50);
        cmlFecha.setMinWidth(50);
        cmleCantidad=new TableColumn<>("Cantidad");
       cmleCantidad.setMaxWidth(50);
       cmleCantidad.setMinWidth(50);
     cmlePu = new TableColumn<>("P.Unit");
     cmlePu.setMaxWidth(50);
     cmlePu.setMinWidth(50);
     cmlePt = new TableColumn<>("P.Total");
     cmlePt.setMaxWidth(50);
     cmlePt.setMinWidth(50);
     cmleSalida = new TableColumn<>("Salida");
     cmleSalida.setMaxWidth(50);
     cmleSalida.setMinWidth(50);
     cmlsPu  = new TableColumn<>("P.Unit");
     cmlsPu.setMaxWidth(50);
     cmlsPu.setMinWidth(50);
     cmlsPt = new TableColumn<>("P.Total");
     cmlsPt.setMaxWidth(50);
     cmlsPt.setMinWidth(50);
     cmlexCantidad  = new TableColumn<>("Cantidad");
     cmlexCantidad.setMaxWidth(50);
    cmlexCantidad.setMinWidth(50);
    cmlexPu  = new TableColumn<>("P.Unit");
    cmlexPu.setMaxWidth(50);
    cmlexPu.setMinWidth(50);
    cmlexPt  = new TableColumn<>("P.Total");
    cmlexPt.setMaxWidth(50);
    cmlexPt.setMinWidth(50);
    tblKardex.getColumns().addAll(cmlTransaccion,cmlFecha, cmleCantidad, cmlePu, cmlePt, cmleSalida, cmlsPu, cmlsPt, cmlexCantidad, cmlexPu, cmlexPt);
    
    pmlIntKardex=new VBox();
    pmlIntKardex.getChildren().add(tblKardex);
        pnlKardexInt=new ScrollPane(pmlIntKardex);
        pnlKardexInt.setMaxSize(860,400 );
        pnlKardexInt.setHmin(0);
        pnlKardexInt.setHmax(0);
        pnlKardex=new VBox();
        pnlKardex.getChildren().addAll(kh4,pnlKardexInt);
    
        
        
        pnlPrincipal = new BorderPane();
        pnlPrincipal.setTop(cabecera);
        pnlPrincipal.setCenter(pnlKardex);
        
        
        Scene scene = new Scene(pnlPrincipal, 720, 640);
        primaryStage.setTitle("Sistema de facturacion");
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.show();
        cmbProducto.setOnHiding(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                llenarCodigoEventHandler(event);
                }
        });
        Calcular.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            CalcularEventHandler(event);    
            }
        });
        
    }

    public static void main(String[] args) {
        launch(args);

    }

    private void cargarProducto() {
        listProducto = new ArrayList<>();
        IProducto prodDao = new ImplProducto();
        try {
            listProducto = prodDao.obtener();
            for (Producto prod : listProducto) {
                itemsP.add(prod);
            }
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("Error al cargar Productos: " + e.getMessage());
            alerta.showAndWait();
        }
    }
    public void llenarCodigoEventHandler(Event event){
        txtcodigo.setText(String.valueOf(cmbProducto.getSelectionModel().getSelectedItem().getCodProducto()));
    }
    public void CalcularEventHandler(ActionEvent event ){
        IKardexM kardexDao = new ImplKardexM();
        listaKardexMensual= new ArrayList<>();
        try {
            listaKardexMensual= kardexDao.listadoKardexFecha(cmbProducto.getSelectionModel().getSelectedIndex()+1,String.valueOf(cmbMes.getSelectionModel().getSelectedIndex()+1),cmbAño.getValue());
            for(Kardex k: listaKardexMensual){
            if (k.getTipoTransaccion().equals("C")){
                cmlFecha.setCellValueFactory(new PropertyValueFactory<>("Fecha Emision"));
                
            
            }
            }
        } catch (Exception e) {
        }
    
    }  
}
