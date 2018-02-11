package unachkardex.vistas;

import javafx.application.Application;
import javafx.event.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import java.util.*;
import javafx.stage.Window;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.reflect.*;
import java.text.*;
import javafx.beans.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.image.*;

public class BarraDeTitulo {
    private ImageView icono;
    private Image img;
    private BackgroundImage fondo;
    private BorderPane barra;

    public BarraDeTitulo(Node nombreVentana, Node cerrar) {
        img=new Image("file:src\\unachkardex\\multimedia\\BarraTitulo.jpg");
        fondo=new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        cerrar.setStyle("-fx-background-color: orangered");
        icono=new ImageView(new Image("file:src\\unachkardex\\multimedia\\unachLogo.png", 40, 40, true, true));
        barra = new BorderPane();
        barra.setLeft(icono);
        barra.setCenter(nombreVentana);
        barra.setRight(cerrar);
        barra.setBackground(new Background(fondo));
        barra.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
    }

    public Node getBarra() {
        return barra;
    }

}
