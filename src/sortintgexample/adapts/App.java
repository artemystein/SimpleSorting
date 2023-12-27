//  App.java


package sortintgexample.adapts;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sortintgexample.adapts.MyMain.TableHeaderPrinter;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Random;

/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Создаем массив для обхода (вставьте свои данные)
        //int[] myArray = { 9, 6, 3, 7, 4, 5, 4, 1, 2, 8 };

        // Создаем массив для обхода
        int[] myArray = generateRandomArray(100, 1, 9);

        // #region ТЕКСТОВАЯ ОБЛАСТЬ не работает цвет.

        /*
         * // Создаем текстовую область для отображения результатов
         * TextArea resultTextArea = new TextArea();
         * resultTextArea.setEditable(false);
         * 
         * // Обходим массив и добавляем результаты в текстовую область
         * for (int i = 0; i < myArray.length; i++) {
         * resultTextArea.appendText(i + ": " + myArray[i] + "\n");
         * }
         * 
         * // Создаем вертикальный контейнер и добавляем текстовую область
         * VBox root = new VBox(resultTextArea);
         * 
         * // Создаем сцену
         * Scene scene = new Scene(root, 640, 480);
         */
        // #endregion

        // #region ПРОСТО БЛОК КАКОЙ ТО
        // Создаем контейнер для результатов
        VBox resultContainer = new VBox();

        


         // Обходим массив и добавляем результаты с подсветкой
        for (int i = 0; i < myArray.length; i++) {
            Label label = new Label(i + "   : " + myArray[i]);
            if (myArray[i] % 2 == 0) {
                label.setStyle("-fx-text-fill: blue;"); // синий цвет для четных элементов
            } else {
                label.setStyle("-fx-text-fill: red;"); // красный цвет для нечетных элементов
            }
            resultContainer.getChildren().add(label);
        } 

        // Создаем ScrollPane и устанавливаем в него VBox
        ScrollPane scrollPane = new ScrollPane(resultContainer);
        // Создаем сцену
        Scene scene = new Scene(scrollPane, 640, 480);
        // #endregion

        // Устанавливаем сцену и отображаем окно
        primaryStage.setTitle("Array Traversal App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private static int[] generateRandomArray(int size, int minValue, int maxValue) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt((maxValue - minValue) + 1) + minValue;
        }

        return array;
    }

    

}