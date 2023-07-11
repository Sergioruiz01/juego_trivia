package proyecto_trivia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    private static Stage primaryStage;
    private static List<String> categoriasSeleccionadas;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage = primaryStage;
        loadCategoriesSelectionScreen();
    }

    public static void setRoot(Parent root) {
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void setCategoriasSeleccionadas(List<String> categoriasSeleccionadas) {
        Main.categoriasSeleccionadas = categoriasSeleccionadas;
    }

    public static List<String> getCategoriasSeleccionadas() {
        return categoriasSeleccionadas;
    }

    private void loadCategoriesSelectionScreen() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ventana.fxml"));
        Parent root = loader.load();

        // Obtener el controlador de la ventana de selección de categorías
        VentanaController controller = loader.getController();
        controller.setApp(this);
        // Establecer las categorías seleccionadas en el controlador PreguntasController
         PreguntasController preguntasController = loader.getController();
         preguntasController.setCategoriasSeleccionadas(getCategoriasSeleccionadas());
       
         primaryStage.setTitle("Primera vista");
        setRoot(root);
    }

    
}
