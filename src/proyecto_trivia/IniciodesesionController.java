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
 @FXML
   private TextField usuario_iniciodesesion;
   private String usuario_inicio;
 @FXML
   private PasswordField contrasena_iniciodesesion;
   private String contrasena_inicio;
@FXML
   private Label datoincorrecto;   

    private String nombreUsuario; 
    private String contrasenaUsuario;

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    } 
     public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    } 


    @FXML
    public boolean verificardatos(){
       usuario_inicio = usuario_iniciodesesion.getText();
       contrasena_inicio = contrasena_iniciodesesion.getText();
       
       if (usuario_inicio.equals(nombreUsuario)&&contrasena_inicio.equals(contrasenaUsuario)) {
           
            return true;
        } else  {
            datoincorrecto.setText("Verifique los Datos o Cree una cuenta");
            return false;
        } 
    }      

// metoodo para boton de inicio
    @FXML
    public void iniciodejuego(ActionEvent event) {
        if (!verificardatos()){
        return;
    }
    try { Stage stage = (Stage) button4.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("normasdeljuego.fxml"));
        Parent root = loader.load();

        Stage newstage = new Stage();
        newstage.setScene(new Scene(root));
        newstage.show();
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
        newstage.setScene(new Scene(root));
        newstage.show();
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
