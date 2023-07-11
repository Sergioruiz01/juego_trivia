package proyecto_trivia;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.*;

public class PreguntasController implements Initializable {
    @FXML
    private Label preguntas;

    @FXML
    private Button respuesta_1;

    @FXML
    private Button respuesta_2;

    @FXML
    private Button respuesta_3;

    @FXML
    private Button respuesta_4;

    private List<String> categoriasSeleccionadas;

    private int questionIndex;
    private int correctAnswers;
    private Map<String, List<String[]>> questionsByTheme;
    private List<String[]> currentQuestions;

    public void setCategoriasSeleccionadas(List<String> categoriasSeleccionadas) {
        this.categoriasSeleccionadas = categoriasSeleccionadas;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        questionsByTheme = new HashMap<>();
        questionsByTheme.put("Cultura General", Arrays.asList(
                new String[]{"Question 1: ¿En qué año ocurrió la Revolución Francesa?", "1789"},
                new String[]{"Question 2: ¿Cuál es el autor de la obra 'Don Quijote de la Mancha'?", "Miguel de Cervantes"},
                new String[]{"Question 3: ¿Cuál es la capital de Australia?", "Canberra"}
        ));
        questionsByTheme.put("Deportes", Arrays.asList(
                new String[]{"Question 1: ¿En qué deporte de élite se utiliza una raqueta para golpear una pelota?", "Tenis"},
                new String[]{"Question 2: ¿Cuál es el país de origen del fútbol?", "Inglaterra"}
        ));
        questionsByTheme.put("Historia", Arrays.asList(
                new String[]{"Question 1: ¿En qué año se descubrió América?", "1492"},
                new String[]{"Question 2: ¿Cuál fue el primer presidente de Estados Unidos?", "George Washington"}
        ));

        questionIndex = 0;
        correctAnswers = 0;

        loadQuestions();
    }

    private void loadQuestions() {
        currentQuestions = new ArrayList<>();

        for (String categoria : categoriasSeleccionadas) {
            if (questionsByTheme.containsKey(categoria)) {
                currentQuestions.addAll(questionsByTheme.get(categoria));
            }
        }

        if (!currentQuestions.isEmpty()) {
            loadQuestion();
        } else {
            // No hay preguntas disponibles para las categorías seleccionadas
        }
    }

    private void loadQuestion() {
        if (questionIndex < currentQuestions.size()) {
            String[] currentQuestion = currentQuestions.get(questionIndex);
            preguntas.setText(currentQuestion[0]);

            String[] options = currentQuestion[1].split("\\|");

            respuesta_1.setText(options[0]);
            respuesta_2.setText(options[1]);
            respuesta_3.setText(options[2]);
            respuesta_4.setText(options[3]);

            questionIndex++;
        } else {
            // Fin del juego
        }
    }

    @FXML
    private void checkAnswer1() {
        checkAnswer(0);
    }

    @FXML
    private void checkAnswer2() {
        checkAnswer(1);
    }

    @FXML
    private void checkAnswer3() {
        checkAnswer(2);
    }

    @FXML
    private void checkAnswer4() {
        checkAnswer(3);
    }

    private void checkAnswer(int selectedOptionIndex) {
        String[] currentQuestion = currentQuestions.get(questionIndex - 1);
        String correctAnswer = currentQuestion[1].split("\\|")[0];

        if (selectedOptionIndex == 0 && respuesta_1.getText().equals(correctAnswer)) {
            correctAnswers++;
        }
        loadQuestion();
    }
}
