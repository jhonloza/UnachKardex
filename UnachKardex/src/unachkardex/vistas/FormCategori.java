/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unachkardex.vistas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.*;
import javafx.stage.Window;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.reflect.Field;

import java.text.DateFormat;
import java.text.MessageFormat;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.StageStyle;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class FormCategori extends Application {
    private Label titulo;
    private Label txtCodigo;
    private Label txtNombre;
    private Label txtDescripcion;
    private TextField codigo;
    private TextField nombre;
    private TextField descripcion;
    private Image icono;
    private ImageView visor;
    private Button btnIngresar;
     private Button btnLimpiar;
      private Button btnCancelar;
      private VBox pnlCat1;
      private VBox pnlCat2;
      private HBox pnlcat;
      private VBox pnlICat;
      private HBox pnlSup;
      private VBox pnlInt;
      private HBox pnlBotones;
      private VBox pntPricipal;
              
    @Override
    public void start(Stage primaryStage) {
        
        
        //superior 
        titulo=new Label ("\"Categoria\"");
        titulo.setFont(Font.font("News701 BT",30));
        txtCodigo=new Label("Codigo: ");
        txtCodigo.setFont(Font.font("News701 BT",20));
        txtNombre=new Label ("Nombre :");
        txtNombre.setFont(Font.font("News701 BT",20));
        pnlCat1=new VBox(10);
        pnlCat1.getChildren().addAll(txtCodigo,txtNombre);
        pnlCat1.setAlignment(Pos.CENTER_RIGHT);
        pnlCat1.setPadding(new Insets(10));
        codigo=new TextField("");
        nombre=new TextField("");
        pnlCat2= new VBox(10);
        pnlCat2.getChildren().addAll(pnlCat1,pnlCat2);
        pnlCat2.setPadding(new Insets(10));
        pnlICat=new VBox(10);
        pnlICat.getChildren().addAll(titulo,pnlICat);
        pnlICat.setAlignment(Pos.CENTER);
        pnlSup= new HBox(10);
        icono=new Image("file:src\\unachkardex\\multimedia\\iconoProveedor.png");
        visor= new ImageView(icono);
        visor.setFitHeight(75);
        visor.setFitWidth(75);
        pnlSup.getChildren().addAll(pnlICat,visor);
        pnlSup.setAlignment(Pos.CENTER);
        txtDescripcion=new Label ("Descripcion: ");
        txtDescripcion.setFont(Font.font("News701 Bt",25));
        descripcion=new TextField("");
        descripcion.setMaxSize(350, 100);
        descripcion.setMinSize(350, 100);
        pnlInt =new VBox(10);
        pnlInt.getChildren().addAll(txtDescripcion,descripcion);
        pnlInt.setAlignment(Pos.CENTER);
        btnIngresar =new Button("Ingresar");
        btnIngresar.setFont(Font.font("News701 BT",20));
        btnIngresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               bIngresarEventHandler(event);
            }
        });
        btnLimpiar=new Button("Limpiar");
        btnLimpiar.setFont(Font.font("News701 BT",20));
        btnCancelar=new Button("Cancelar");
        btnCancelar.setFont(Font.font("News701 BT",20));
        pnlBotones=new HBox(25);
        pnlBotones.getChildren().addAll(btnIngresar,btnLimpiar,btnCancelar);
        pnlBotones.setAlignment(Pos.CENTER);
        pntPricipal=new VBox(10);
        pntPricipal.getChildren().addAll(pnlSup,pnlInt,pnlBotones);
        pntPricipal.setPadding(new Insets(10));
        
        Scene scene =new Scene(pntPricipal,420,370);
        
        primaryStage.setTitle("Categoria");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        public static void main (String[] args ){
            launch(args);
        }
        public void bIngresarEventHandler(ActionEvent event){
            ICategoria categDao =new ImplCategoria();
            Categoria nCategoria = new Categoria();
            try{
                
                nCategoria.setCodCategoria(Integer.parseInt(codigo.getText()));
                nCategoria.setNombre(nombre.getText());
                nCategoria.setDescripcion(descripcion.getText());
                if (categDao.insertar(nCategoria)>0){
                    System.out.println("Ingreso correcto");
         
                }else {
                    System.out.println("Ingreso Incorrecto");
                }
            }catch (Exception e){
                        System.out.println("Error"+e.getMessage());
                        
                        }
                }
            }
        
    
    

