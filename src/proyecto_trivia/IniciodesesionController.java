package proyecto_trivia;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;


//Controlador primera pantalla para crear usuario o iniciar sesion 
public class IniciodesesionController implements Initializable {
    
    //conexion a los botones
 @FXML
 private Button button4;
 @FXML
 private Button button5;
 /* conexion a los datos ingresados por el usuario
 @FXML
   private TextField usuario_u;
    private String usuario_inicio;
 @FXML
   private PasswordField contrasena_c;
     private String contrasena_inicio;
 @FXML
  private Label datoincorrecto;
 
    private String nombusuario;
    private String contrasena_usuario;**/
       
 
// metoodo para boton de inicio
    @FXML
    public void iniciodejuego(ActionEvent event) {
        
    try { Stage stage = (Stage) button4.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("normasdeljuego.fxml"));
        Parent root = loader.load();

        Stage newstage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
// metodo al pulsar el boton no tienes cuenta, vuelve al registro 
@FXML
public void aunnotienescuenta(ActionEvent event) {
    try { Stage stage = (Stage) button5.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("formularioregistro.fxml"));
        Parent root = loader.load();

        Stage newstage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

   
  




/**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
