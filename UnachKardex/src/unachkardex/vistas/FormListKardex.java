
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
import javafx.util.Callback;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;

public class FormListKardex extends Application{
private Label lblProducto;
private Label lblCodigo;
private Label codigo;
    private Label lblFechaI;
    private Label lblAnio;
    private Label lblMes;
    private Label lblFecha;
    private Label lblDetalle;
    private Label lblEntrada;
    private Label lblECantidad;
    private Label lblEValorUnitario;
    private Label lblEValorTotal;
    private Label lblSalida;
    private Label lblSCantidad;
    private Label lblSValorUnitario;
    private Label lblSValorTotal;
    private Label lblExistencia;
    private Label lblExCantidad;
    private Label lblExValorunitario;
    private Label lblExValorTotal;
    private ComboBox<Producto> combProducto;
    private ObservableList<Producto> itemsP = FXCollections.observableArrayList();
    private ArrayList<Producto> listaProducto;
    private ComboBox<String> combAnio;
    private ObservableList<String> itemsA = FXCollections.observableArrayList();
    private ArrayList<String> listaAnios;
    private ComboBox<String> combMes;
    private ObservableList<String> itemsM = FXCollections.observableArrayList();
    private ArrayList<String> listaMes;
    private Button btnCalcular;
    private TableView<Kardex> tblKardex;
    private TableColumn<Kardex, String> columFecha;
    private TableColumn<Kardex, String> columTipoTrans;
    private TableColumn<Kardex, Integer> columSCant;
    private TableColumn<Kardex, Double> columSVU;
    private TableColumn<Kardex, Double> columSVT;
    private TableColumn<Kardex, Integer> columECant;
    private TableColumn<Kardex, Double> columEVU;
    private TableColumn<Kardex, Double> columEVT;
    private TableColumn<Kardex, Integer> columExCant;
    private TableColumn<Kardex, Double> columExVU;
    private TableColumn<Kardex, Double> columExVT;
    private ArrayList<Kardex> listaKardexMensual;
    private VBox pnlc1,pnlc2,pnlc3,pnlc4;
    private HBox pnlcabecera;
    private HBox pnlEPropiedades;
    private HBox pnlSPropiedades;
    private HBox pnlExPropiedades;
    private VBox pnlEntrada;
    private VBox pnlSalida;
    private VBox pnlExistencia;
    private HBox pnlCabKardex;
    private VBox pnlKardex;
    private ScrollPane pnlKardexInt;
    private VBox pnlIntKardex;
    private BorderPane pnlPrincipal;

    @Override
    public void start(Stage primaryStage) throws Exception {
        cargarProducto();
        itemsA.addAll("2016", "2017", "2018", "2019", "2020");
        itemsM.addAll("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
        lblProducto = new Label("Producto: ");
        lblProducto.setMaxSize(100, 25);
        lblProducto.setMinSize(100, 25);
        lblProducto.setAlignment(Pos.CENTER_RIGHT);
        lblProducto.setFont(Font.font("News701 BT", 15));
        lblCodigo=new Label("Codigo: ");
        lblCodigo.setAlignment(Pos.CENTER_RIGHT);
        lblCodigo.setMaxSize(100, 25);
        lblCodigo.setMinSize(100, 25);
        lblCodigo.setFont(Font.font("News701 BT", 15));
        codigo=new Label("");
        codigo.setMaxSize(265, 25);
        codigo.setMinSize(265, 25);
        codigo.setStyle("-fx-border-color: blue; -fx-border-width: 2px");
        lblFechaI = new Label("Fecha:");
        lblFechaI.setFont(Font.font("News701 BT", 15));
        lblAnio = new Label("Año: ");
        lblAnio.setMaxSize(50, 25);
        lblAnio.setMinSize(50, 25);
        lblAnio.setAlignment(Pos.CENTER_RIGHT);
        lblAnio.setFont(Font.font("News701 BT", 15));
        lblMes = new Label("Mes: ");
        lblMes.setMaxSize(50, 25);
        lblMes.setMinSize(50, 25);
        lblMes.setAlignment(Pos.CENTER_RIGHT);
        lblMes.setFont(Font.font("News701 BT", 15));
        combProducto = new ComboBox<Producto>(itemsP);
        combAnio = new ComboBox<>(itemsA);
        combMes = new ComboBox<>(itemsM);
        btnCalcular=new Button("Mostrar kardex");
        btnCalcular.setFont(Font.font("News701 BT", 15));
        btnCalcular.setAlignment(Pos.CENTER);
        pnlc1=new VBox(2);
        pnlc1.getChildren().addAll(lblProducto, lblCodigo);
        pnlc1.setAlignment(Pos.CENTER_LEFT);
        pnlc2=new VBox(2);
        pnlc2.getChildren().addAll(combProducto, codigo);
        pnlc2.setAlignment(Pos.CENTER);
        pnlc3=new VBox(2);
        pnlc3.getChildren().addAll(lblAnio, lblMes);
        pnlc3.setAlignment(Pos.CENTER);
        pnlc4=new VBox(2);
        pnlc4.getChildren().addAll(combAnio, combMes);
        pnlc4.setAlignment(Pos.CENTER_LEFT);
        pnlcabecera=new HBox(10);
        
        pnlcabecera.getChildren().addAll(pnlc1,pnlc2,pnlc3,pnlc4, btnCalcular);
        pnlcabecera.setPadding(new Insets(15));
        pnlcabecera.setMaxSize(900, 60);
        pnlcabecera.setMinSize(900, 60);
        pnlcabecera.setAlignment(Pos.CENTER);
///////////////////////////////////////
        lblFecha = new Label("Fecha");
        lblFecha.setFont(Font.font("News701 BT", 18));
        lblFecha.setMaxSize(100, 55);
        lblFecha.setMinSize(100, 55);
        lblFecha.setAlignment(Pos.CENTER);
        lblFecha.setStyle("-fx-border-color: blue; -fx-border-width: 2px");
        lblDetalle = new Label("Detalle");
        lblDetalle.setFont(Font.font("News701 BT", 18));
        lblDetalle.setMaxSize(250, 55);
        lblDetalle.setMinSize(250, 55);
        lblDetalle.setAlignment(Pos.CENTER);
        lblDetalle.setStyle("-fx-border-color: blue; -fx-border-width: 2px");
        lblEntrada = new Label("Entrada");
        lblEntrada.setFont(Font.font("News701 BT", 18));
        lblEntrada.setAlignment(Pos.CENTER);
        lblECantidad = new Label("Cant");
        lblECantidad.setFont(Font.font("News701 BT", 17));
        lblECantidad.setAlignment(Pos.CENTER);
        lblEValorUnitario = new Label("V Unit");
        lblEValorUnitario.setFont(Font.font("News701 BT", 17));
        lblEValorUnitario.setAlignment(Pos.CENTER);
        lblEValorTotal = new Label("V Tot");
        lblEValorTotal.setFont(Font.font("News701 BT", 17));
        lblEValorTotal.setAlignment(Pos.CENTER);
        lblSalida = new Label("Salida");
        lblSalida.setFont(Font.font("News701 BT", 18));
        lblSalida.setAlignment(Pos.CENTER);
        lblSCantidad = new Label("Cant");
        lblSCantidad.setFont(Font.font("News701 BT", 17));
        lblSCantidad.setAlignment(Pos.CENTER);
        lblSValorUnitario = new Label("V Unit");
        lblSValorUnitario.setFont(Font.font("News701 BT", 17));
        lblSValorUnitario.setAlignment(Pos.CENTER);
        lblSValorTotal = new Label("V Tot");
        lblSValorTotal.setFont(Font.font("News701 BT", 17));
        lblSValorTotal.setAlignment(Pos.CENTER);
        lblExistencia = new Label("Existencias");
        lblExistencia.setFont(Font.font("News701 BT", 18));
        lblExistencia.setAlignment(Pos.CENTER);
        lblExCantidad = new Label("Cant");
        lblExCantidad.setFont(Font.font("News701 BT", 17));
        lblExCantidad.setAlignment(Pos.CENTER);
        lblExValorunitario = new Label("V Unit");
        lblExValorunitario.setFont(Font.font("News701 BT", 17));
        lblExValorunitario.setAlignment(Pos.CENTER);
        lblExValorTotal = new Label("V Tot");
        lblExValorTotal.setFont(Font.font("News701 BT", 17));
        lblExValorTotal.setAlignment(Pos.CENTER);
        pnlEPropiedades = new HBox(2);
        pnlEPropiedades.getChildren().addAll(lblECantidad, lblEValorUnitario, lblEValorTotal);
        pnlEPropiedades.setAlignment(Pos.TOP_CENTER);
        pnlSPropiedades = new HBox(2);
        pnlSPropiedades.getChildren().addAll(lblSCantidad, lblSValorUnitario, lblSValorTotal);
        pnlSPropiedades.setAlignment(Pos.TOP_CENTER);
        pnlExPropiedades = new HBox(2);
        pnlExPropiedades.getChildren().addAll(lblExCantidad, lblExValorunitario, lblExValorTotal);
        pnlExPropiedades.setAlignment(Pos.TOP_CENTER);
        pnlEntrada = new VBox(5);
        pnlEntrada.getChildren().addAll(lblEntrada, pnlEPropiedades);
        pnlEntrada.setStyle("-fx-border-color: blue; -fx-border-width: 2px");
        pnlEntrada.setAlignment(Pos.TOP_CENTER);
        pnlEntrada.setMaxSize(175, 55);
        pnlEntrada.setMinSize(175, 55);
        pnlSalida = new VBox(5);
        pnlSalida.getChildren().addAll(lblSalida, pnlSPropiedades);
        pnlSalida.setStyle("-fx-border-color: blue; -fx-border-width: 2px");
        pnlSalida.setAlignment(Pos.TOP_CENTER);
        pnlSalida.setMaxSize(175, 55);
        pnlSalida.setMinSize(175, 55);
        pnlExistencia = new VBox(5);
        pnlExistencia.getChildren().addAll(lblExistencia, pnlExPropiedades);
        pnlExistencia.setStyle("-fx-border-color: blue; -fx-border-width: 2px");
        pnlExistencia.setAlignment(Pos.TOP_CENTER);
        pnlExistencia.setMaxSize(175, 55);
        pnlExistencia.setMinSize(175, 55);
        pnlCabKardex = new HBox(5);
        pnlCabKardex.getChildren().addAll(lblDetalle, lblFecha, pnlSalida, pnlEntrada, pnlExistencia);
        pnlCabKardex.setAlignment(Pos.CENTER);
        //////////////////////////
        tblKardex = new TableView();
        columFecha = new TableColumn<>("Fecha");
        columFecha.setMaxWidth(100);
        columFecha.setMinWidth(100);
        columTipoTrans = new TableColumn<>("Tipo Transaccion");
        columTipoTrans.setMaxWidth(250);
        columTipoTrans.setMinWidth(250);
        columSCant = new TableColumn<>("S Cant");
        columSCant.setMaxWidth(60);
        columSCant.setMinWidth(60);
        columSVU = new TableColumn<>("S VU");
        columSVU.setMaxWidth(60);
        columSVU.setMinWidth(60);
        columSVT = new TableColumn<>("S VT");
        columSVT.setMaxWidth(60);
        columSVT.setMinWidth(60);
        columECant = new TableColumn<>("E Cant");
        columECant.setMaxWidth(60);
        columECant.setMinWidth(60);
        columEVU = new TableColumn<>("E VU");
        columEVU.setMaxWidth(60);
        columEVU.setMinWidth(60);
        columEVT = new TableColumn<>("E VT");
        columEVT.setMaxWidth(60);
        columEVT.setMinWidth(60);
        columExCant = new TableColumn<>("Ex Cant");
        columExCant.setMaxWidth(60);
        columExCant.setMinWidth(60);
        columExVU = new TableColumn<>("Ex VU");
        columExVU.setMaxWidth(60);
        columExVU.setMinWidth(60);
        columExVT = new TableColumn<>("Ex VT");
        columExVT.setMaxWidth(60);
        columExVT.setMinWidth(60);
        tblKardex.getColumns().addAll(columTipoTrans, columFecha, columSCant, columSVU, columSVT, columECant, columEVU, columEVT, columExCant, columExVU, columExVT);
        pnlIntKardex = new VBox();
        pnlIntKardex.getChildren().add(tblKardex);
///////////////////////////////
        pnlKardexInt = new ScrollPane(pnlIntKardex);
        pnlKardexInt.setMaxSize(900, 200);
        pnlKardexInt.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        pnlKardex = new VBox();
        pnlKardex.getChildren().addAll(pnlCabKardex, pnlKardexInt);
        pnlKardex.setAlignment(Pos.TOP_CENTER);
        pnlKardex.setPadding(new Insets(10));
        pnlPrincipal = new BorderPane();
        pnlPrincipal.setTop(pnlcabecera);
        pnlPrincipal.setCenter(pnlKardex);
        pnlPrincipal.setPadding(new Insets(5));
        pnlPrincipal.setRight(null);
        pnlPrincipal.setLeft(null);
        Scene scene = new Scene(pnlPrincipal, 950, 520);
        primaryStage.setResizable(true);
        primaryStage.setTitle("EMPRESA");
        primaryStage.setScene(scene);
        primaryStage.show();
        btnCalcular.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bCalcularEventHandler(event);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void cargarProducto() {
        listaProducto = new ArrayList<>();
        IProducto productoDao = new ImplProducto();
        try {
            listaProducto = productoDao.obtener();
            for (Producto producto : listaProducto) {
                itemsP.add(producto);
            }
        } catch (Exception e) {

        }
    }
    
    public void bCalcularEventHandler(ActionEvent event){
        IKardexM kardexMDao=new ImplKardexM();
        listaKardexMensual=new ArrayList<>();
        try {
            listaKardexMensual=kardexMDao.listadoKardexFecha(combProducto.getSelectionModel().getSelectedIndex()+1, String.valueOf(combMes.getSelectionModel().getSelectedIndex()+1), combAnio.getValue());
            for(Kardex k:listaKardexMensual){
                
                if(k.getTipoTransaccion().equals("C")){
                    System.out.println("Compra: "+k.getProducto().getNombre()+"  "+k.getCodKardex()+"  "+"[   ]  [   ]  [   ]"+"  "+k.getCantEditable()+"  "+(k.getValorTotal()/k.getCantEditable())+"  "+k.getValorTotal()+"  "+k.getExistencias()+"  "+(k.getValorTotal()/k.getExistencias())+"  "+k.getValorTotal());
                    TableCell nuevaCelda = new TableCell();
                    nuevaCelda.setText(String.valueOf(k.getFechaEmision()));
                    columFecha.cellFactoryProperty().setValue((Callback<TableColumn<Kardex, String>, TableCell<Kardex, String>>) nuevaCelda);
                }
                else{
                }
            }
        } catch (Exception e) {
        }
    }
}