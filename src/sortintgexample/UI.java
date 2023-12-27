// UI.java
package sortintgexample;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.io.*;

public class UI implements ActionListener {

   private final JFrame frame;

   private final JPanel panel;
   private final JPanel panelSub1;
   private final JPanel panelSub2;
   private final JPanel panelSub3;
   private final JPanel panelSub4;
   private final JPanel panelSub5;

   private final JTextArea text;
   private final JButton but[];
   private final JButton but1;

   private final String[] buttonValue = { "0", "Bubble", "2", "3", "4", "5", "6", "7", "8", "9" };

   private final Font font;
   private final Font textFont;

   public UI() {
      frame = new JFrame("Simple Sorting");

      panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      panelSub1 = new JPanel(new FlowLayout());
      panelSub2 = new JPanel(new FlowLayout());
      panelSub3 = new JPanel(new FlowLayout());
      panelSub4 = new JPanel(new FlowLayout());
      panelSub5 = new JPanel(new FlowLayout());

      font = new Font("Consolas", Font.PLAIN, 18);
      text = new JTextArea(1, 30);
      textFont = new Font("Consolas", Font.BOLD, 24);

      but1 = new JButton("BUBBLE");

      but = new JButton[10];
      for (int i = 0; i < 10; i++) {
         but[i] = new JButton(String.valueOf(i));
      }

      // Инициализируем bubbleSort1
      bubbleSort1 = new BubbleSort1();

   }

   // Initialize JavaFX Toolkit
   static {
      Platform.startup(() -> {
      });
   }

   public void init() {
      frame.setSize(450, 450);
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      text.setFont(textFont);
      text.setEditable(false);

      for (int i = 0; i < 10; i++) {
         but[i].setFont(font);
      }
      // #region КНОПКИ
      panel.add(Box.createHorizontalStrut(100));
      panelSub1.add(text);
      panel.add(panelSub1);

      panelSub2.add(but[1]);
      panelSub2.add(but[2]);
      panelSub2.add(but[3]);
      panelSub2.add(Box.createHorizontalStrut(15));
      panel.add(panelSub2);

      panelSub3.add(but[4]);
      panelSub3.add(but[5]);
      panelSub3.add(but[6]);
      panelSub3.add(Box.createHorizontalStrut(15));
      panel.add(panelSub3);

      panelSub4.add(but[7]);
      panelSub4.add(but[8]);
      panelSub4.add(but[9]);
      panelSub4.add(Box.createHorizontalStrut(15));
      panel.add(panelSub4);

      panelSub5.add(Box.createHorizontalStrut(92));
      panelSub5.add(but1);
      panelSub5.add(Box.createHorizontalStrut(210));
      panel.add(panelSub5);
      // #endregion

      for (int i = 0; i < 10; i++) {
         but[i].addActionListener(this);
      }

      frame.add(panel);
      frame.setVisible(true);
   }

   private BubbleSort1 bubbleSort1;

   @Override
   public void actionPerformed(ActionEvent e) {
      final Object source = e.getSource();

      // Use Platform.runLater for JavaFX operations
      Platform.runLater(() -> {
         // Обработка нажатия кнопки "BUBBLE"
         if (source == but[1]) {

            // Если bubbleSort1 уже создан, закройте его окно
            if (bubbleSort1 != null) {
               bubbleSort1.closeWindow();
               bubbleSort1 = null;
              
           }

           // Создайте новый экземпляр BubbleSort1
           bubbleSort1 = new BubbleSort1();

           // Создайте объект Stage для нового окна
           Stage bubbleSort1Stage = new Stage();

           // Вызовите метод start, передавая объект Stage
           bubbleSort1.start(bubbleSort1Stage);
       }

      });

      // текст отображает в поле текстовом при нажатии кнопки
      for (int i = 0; i < 10; i++) {
         if (source == but[i]) {
            text.replaceSelection(buttonValue[i]);
            return;
         }
      }
      text.selectAll();
   }

}
