//  RunApp.java
package sortintgexample;
import javafx.application.Application;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class RunApp {

    public static void main(String[] args) {     
        try {
            UI uiCal = new UI();
            uiCal.init();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }       
    }
}