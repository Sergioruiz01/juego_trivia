package proyecto_trivia;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SelecionadorcategoriasController implements Initializable {
    @FXML
    private CheckBox cultura_general;

    @FXML
    private CheckBox deportes;

    @FXML
    private CheckBox historia;

    @FXML
    private Label categoriasSeleccionadasLabel;

    @FXML
    private Button comenzar;

    @FXML
    private void seleccionar() throws IOException {
        
    
        List<String> categoriasSeleccionadas = new ArrayList<>();

        if (cultura_general.isSelected()) {
            categoriasSeleccionadas.add("Cultura General");
        }

        if (deportes.isSelected()) {
            categoriasSeleccionadas.add("Deportes");
        }

        if (historia.isSelected()) {
            categoriasSeleccionadas.add("Historia");
        }

        if (!categoriasSeleccionadas.isEmpty()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("preguntas.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la vista de preguntas
            PreguntasController preguntasController = loader.getController();

             // Inicializar la lista categoriasSeleccionadas en el controlador
             preguntasController.setCategoriasSeleccionadas(new ArrayList<>(categoriasSeleccionadas));

            Scene scene = comenzar.getScene();
            scene.setRoot(root);
}
            else {
            categoriasSeleccionadasLabel.setText("Selecciona al menos una categoría.");
            }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        categoriasSeleccionadasLabel.setText("");
    }
}
