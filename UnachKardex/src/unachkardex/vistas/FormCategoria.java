/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unachkardex.vistas;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import java.util.*;
import javafx.stage.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.reflect.Field;
import java.text.*;
import javafx.beans.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.stage.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;
import javafx.scene.control.*;
import javafx.scene.image.*;

public class FormCategoria extends Application {

    private Label[] txtZona; //hacer 4
    private TextField[] zona; //hacer 3
    private Image icono;
    private ImageView visor;
    private Button btnAccion;
    private Button btnLimpiar;

    private HBox[] parametro;
    private VBox[] pCategoria;
    private HBox categDatos;
    private BorderPane pntPrincipal;
    private HBox pnlbotones;
    private VBox categoria;

    @Override
    public void start(Stage primaryStage) {
        icono = new Image("file:src\\unachkardex\\multimedia\\iconoProveedor.png");
        visor = new ImageView(icono);
        visor.setFitHeight(100);
        visor.setFitWidth(100);
        parametro = new HBox[3];
        txtZona = new Label[4];
        txtZona[0] = new Label(" * Categorias * ");
        txtZona[0].setFont(Font.font("Arial Black", 20));
        txtZona[1] = new Label("Codigo:   ");
        txtZona[1].setFont(Font.font("Arial Black", 15));
        txtZona[2] = new Label("Nombre: ");
        txtZona[2].setFont(Font.font("Arial Black", 15));
        txtZona[3] = new Label("Descripcion:   ");
        txtZona[3].setFont(Font.font("Arial Black", 15));
        zona = new TextField[3];
        zona[0] = new TextField();
        zona[1] = new TextField();
        zona[2] = new TextField();
        zona[2].setMaxSize(275, 25);
        zona[2].setMinSize(275, 25);
        parametro[0] = new HBox(10);
        parametro[0].getChildren().addAll(txtZona[1], zona[0]);
        parametro[0].setAlignment(Pos.CENTER);
        parametro[1] = new HBox(10);
        parametro[1].getChildren().addAll(txtZona[2], zona[1]);
        parametro[1].setAlignment(Pos.CENTER);
        parametro[2] = new HBox(10);
        parametro[2].getChildren().addAll(txtZona[3], zona[2]);
        parametro[2].setAlignment(Pos.CENTER);
        pCategoria = new VBox[2];
        pCategoria[0] = new VBox(10);
        pCategoria[0].getChildren().addAll(parametro[0], parametro[1]);
        pCategoria[0].setAlignment(Pos.CENTER);
        pCategoria[1] = new VBox(10);
        pCategoria[1].getChildren().addAll(txtZona[0], visor);
        pCategoria[1].setAlignment(Pos.CENTER);
        categDatos = new HBox(10);
        categDatos.getChildren().addAll(pCategoria[0], pCategoria[1]);
        categDatos.setAlignment(Pos.TOP_CENTER);
        pnlbotones = new HBox(15);
        btnAccion=new Button("Ingresar");
        btnAccion.setFont(Font.font("Arial Black", 15));
        btnLimpiar=new Button("Limpiar");
        btnLimpiar.setFont(Font.font("Arial Black", 15));
        pnlbotones.getChildren().addAll(btnAccion, btnLimpiar);
        pnlbotones.setAlignment(Pos.CENTER);
        categoria=new VBox(10);
        categoria.getChildren().addAll(categDatos, parametro[2]);
        categoria.setAlignment(Pos.CENTER);
        pntPrincipal=new BorderPane();
        pntPrincipal.setCenter(categoria);
        pntPrincipal.setBottom(pnlbotones);
        pntPrincipal.setPadding(new Insets(15));
        Scene scene = new Scene(pntPrincipal, 460, 280);

        primaryStage.setTitle("Categoria");
        primaryStage.setScene(scene);
        primaryStage.show();
        btnAccion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bIngresarEventHandler(event);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void bIngresarEventHandler(ActionEvent event) {
        ICategoria categDao = new ImplCategoria();
        Categoria nCategoria = new Categoria();
        try {

            nCategoria.setCodCategoria(Integer.parseInt(zona[0].getText()));
            nCategoria.setNombre(zona[1].getText());
            nCategoria.setDescripcion(zona[2].getText());
            if (categDao.insertar(nCategoria) > 0) {
                System.out.println("Ingreso correcto");

            } else {
                System.out.println("Ingreso Incorrecto");
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());

        }
    }
}
