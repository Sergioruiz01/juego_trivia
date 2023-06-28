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
   private TextField correo;
    private String correo_usuario;
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
       
        
        Stage newstage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
// metodo para verificar datos ingresados por el usuario
@FXML
public boolean confirmardatos(){
       nombusuario = nusuario.getText();
       correo_usuario = correo.getText();
       contrasena_usuario = contrasena.getText();
       confcontrasena_usuario = confcontrasena.getText();
       if(confcontrasena_usuario.equals(contrasena_usuario ))
       {    
           datoincorrecto.setText("Datos Correctos");
           return true;
       }  else if(nombusuario.isEmpty()|| correo_usuario.isEmpty()|| contrasena_usuario.isEmpty()){
           datoincorrecto.setText("Complete los espacios en blanco");
             return false;
       }       
             else{ datoincorrecto.setText("Verifique los datos ingresados");
               return false; 
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
