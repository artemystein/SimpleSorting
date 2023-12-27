// BubbleSort1.java

package sortintgexample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class BubbleSort1 extends Application{ 

    private Stage primaryStage;
    

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        

    

        // Создаем массив для обхода (вставьте свои данные)
        int[] myArray = { 9, 6, 3, 7, 4, 5, 4, 1, 2, 8 };

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

        // Устанавливаем сцену и отображаем окно
        primaryStage.setTitle("Array Traversal App");
        primaryStage.setScene(scene);
        primaryStage.show();
    } 


    public void closeWindow() {
        if (primaryStage != null) {
            primaryStage.close();
        }
    }

    @Override
    public void stop() {
        // Этот метод вызывается при закрытии приложения
        // Мы не вызываем Platform.exit(), чтобы приложение не завершалось
    }
}
