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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//Controlador pantalla registro para crear usuario o iniciar sesion 
public class FormularioregistroController implements Initializable {
    //conexion a los datos ingresados por el usuario 
 @FXML
   private TextField nusuario;
    private String nombusuario;
 @FXML
   private PasswordField contrasena;
     private String contrasena_usuario;
 @FXML
   private PasswordField confcontrasena;
     private String confcontrasena_usuario;
 @FXML
   private Label datoincorrecto;
 
   
    //conexion al boton crear usuario
 @FXML
 private Button button3;
 
 // metodo para verificar datos ingresados por el usuario
@FXML
public boolean confirmardatos(){
       nombusuario = nusuario.getText();
       contrasena_usuario = contrasena.getText();
       confcontrasena_usuario = confcontrasena.getText();
       if (nombusuario.isEmpty() || contrasena_usuario.isEmpty()) {
            datoincorrecto.setText("Complete los espacios en blanco");
            return false;
        } else if (!confcontrasena_usuario.equals(contrasena_usuario)) {
            datoincorrecto.setText("Las contraseñas no coinciden");
            return false;
        } else {
            datoincorrecto.setText("Datos Correctos");
            return true;
       }
    }      
 
 // metodo al pulsar el boton crear cuenta, redirige a inciar sesion 
 @FXML
public void crearcuenta(ActionEvent event) {
    if (!confirmardatos()){
        return;
    }
    try { Stage stage = (Stage) button3.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("iniciodesesion.fxml"));
        Parent root = loader.load();
       
        // Pasar el nombre de usuario y contrasena al controlador de inicio de sesión
    
    IniciodesesionController iniciodesesionController = loader.getController();
    iniciodesesionController.setNombreUsuario(nombusuario);
    iniciodesesionController.setContrasenaUsuario(contrasena_usuario);

        
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
