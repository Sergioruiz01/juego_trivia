
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

//Controlador primera pantalla para crear usuario o iniciar sesion 
public class VentanaController implements Initializable {
    
    //conexion a los botones
 @FXML
 private Button button1;
 @FXML
 private Button button2;
       
 // metodo al pulsar el boton inicion de sesion
 @FXML
public void iniciodesesion(ActionEvent event) {
    try { Stage stage = (Stage) button1.getScene().getWindow();
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
// metodo al pulsar el boton registrarse
public void registrarse(ActionEvent event) {
    try { Stage stage = (Stage) button2.getScene().getWindow();
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
