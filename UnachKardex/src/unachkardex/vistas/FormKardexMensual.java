
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
import javafx.stage.*;
import unachkardex.negocio.dao.*;
import unachkardex.negocio.entidades.*;
import unachkardex.negocio.impl.*;
import unachkardex.accesodatos.*;
import javafx.scene.image.*;

public class FormKardexMensual extends Application {
  
    private BorderPane pnlPrincipal;
    @Override
    public void start(Stage primaryStage) throws Exception {
        pnlPrincipal = new BorderPane();
        Scene scene = new Scene(pnlPrincipal, 720 , 640);
        
        primaryStage.setTitle("Sistema de facturacion");
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.show();
  }
    public static void main (String[]args ){
        launch (args);
    
}
}

