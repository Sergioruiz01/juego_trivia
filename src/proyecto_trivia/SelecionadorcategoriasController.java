
package proyecto_trivia;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


/**
 * FXML Controller class
 *
 * @author admin
 */
public class SelecionadorcategoriasController implements Initializable {

   @FXML
 private Button button7;
   
    @FXML
    private CheckBox culturageneral;
    @FXML
    private CheckBox ciencias;
    @FXML
    private CheckBox logicaymate;

  

    public List<String> obtenerCategoriasSeleccionadas() {
        List<String> categoriasSeleccionadas = new ArrayList<>();

        if (culturageneral.isSelected()) {
            categoriasSeleccionadas.add("Cultura General");
        }
        if (ciencias.isSelected()) {
            categoriasSeleccionadas.add("Ciencias");
        }
        if (logicaymate.isSelected()) {
            categoriasSeleccionadas.add("Logica y Matematica");
        }

        return categoriasSeleccionadas;
    }


       
 // metodo al pulsar el boton inicion de sesion
 @FXML
public void seleccionar(ActionEvent event) {
    try { Stage stage = (Stage) button7.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("preguntas.fxml"));
        Parent root = loader.load();

        Stage newstage = new Stage();
        newstage.setScene(new Scene(root));
        newstage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
