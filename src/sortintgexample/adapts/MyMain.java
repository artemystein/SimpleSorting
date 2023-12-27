package sortintgexample.adapts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyMain {

   public static void main(String[] args) {
      int[] array = { 64, 34, 25, 12, 22, 11, 90 };
            
      BubbleSort1 bubbleSort1 = new BubbleSort1();
      BubbleSort2 bubbleSort2 = new BubbleSort2();
      BubbleSort3 bubbleSort3 = new BubbleSort3();
      BubbleSort4 bubbleSort4 = new BubbleSort4();
   
   	// Вывод методов объектов
      bubbleSort1.bubbleSort(array);
      bubbleSort2.bubbleSort(array);
      bubbleSort3.bubbleSort(array);
      bubbleSort4.bubbleSort(array);
   
    System.out.println("HUY");
   
   }

	// -----------------------------------------------------------------------------
   public static class BubbleSort1 {
   
      public void bubbleSort(int[] array) {
         TableHeaderPrinter.printTableHeader(1);
         int counter = 1;
         for (int i = 0; i < array.length; i++) {
            System.out.printf("%-5s", counter);
            for (int x = 0; x < array.length; x++) {
               Color.printNormal(array[x]);
            }
            counter++;
            System.out.println();
         }
      }
   }

	// -----------------------------------------------------------------------------
   public static class BubbleSort2 {
   
      public void bubbleSort(int[] array) {
         TableHeaderPrinter.printTableHeader(2);
         int counter = 1;
         for (int i = 0; i < array.length; i++) {
            System.out.printf("%-5s", counter);
            Color.color(array, i);
            counter++;
         }
         System.out.println();
      }
   }

	// -----------------------------------------------------------------------------
   public static class BubbleSort3 {
   
      public void bubbleSort(int[] array) {
         TableHeaderPrinter.printTableHeader(3);
         int counter = 1;
         for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
            	// Вывод № и условия сравнения
               System.out.printf("%-5s", counter);
               System.out.printf("%-20s  ", array[j] > array[j + 1] ? "a[j] > a[j+1] " + Color.GREEN + "  true " + Color.RESET
                  			: "a[j] > a[j+1] " + Color.RED + "  false" + Color.RESET);
               if (array[j] > array[j + 1]) {
                  Color.colorIfTrue(array, j);
               } else {
                  Color.colorIfFalse(array, j);
               }
               counter++;
            }
         }
      }
   }

	// -----------------------------------------------------------------------------
   public static class BubbleSort4 {
   
      public void bubbleSort(int[] array) {
         TableHeaderPrinter.printTableHeader(4);
         int counter = 1;
         for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
            	// Вывод №, массива, условия и перегрузки
               System.out.printf("%-5s", counter);
               System.out.printf("%5s  ", "a[j] > a[j+1]");
            
               if (array[j] > array[j + 1]) {
               
                  System.out.printf("%5s ", " true   ");
                  Color.colorIfTrue(array, j);
               
                  int temp = array[j];
                  array[j] = array[j + 1];
                  array[j + 1] = temp;
               
                  System.out.printf(Color.GREEN + "%29s" + Color.RESET, " swap    ");
                  Color.colorSwap(array, j);
               
               } else {
                  System.out.printf("%5s ", " false  ");
                  Color.colorIfFalse(array, j);
               
               }
               counter++;
            }
         }
      }
   }

	// -----------------------------------------------------------------------------
   public class Color {
   
   	//	ЦВЕТ - КОНСТАНТЫ
   	//	цвет текста
      public static final String RESET = "\u001B[0m";
      public static final String YELLOW = "\u001B[33m";
      public static final String RED = "\u001B[31;1m";
      public static final String GREEN = "\u001B[32m";
      public static final String BLUE = "\u001B[34m";
      public static final String MAGENTA = "\u001B[35m";
      public static final String CYAN = "\u001B[36m";
      public static final String WHITE = "\u001B[37m";
      public static final String GREY = "\u001B[90m";
   
   	//	цвет фона
      public static final String GREYBACK = "\u001B[100m";
      public static final String WHITEBACK = "\u001B[47m";
   
   
   	//	УСТАНОВКА ЦВЕТА ДЛЯ ЦИФР ВЫВОДА ТАБЛИЦ
      private static void printNormal(int value) {
         System.out.printf("%2s ", value);
      }
   
      private static void printYellow(int value) {
         System.out.printf(YELLOW + "%2s " + RESET, value);
      }
   
      private static void printRed(int value) {
         System.out.printf(RED + "%2s " + RESET, value);
      }
   
      private static void printGreen(int value) {
         System.out.printf(GREEN + "%2s " + RESET, value);
      }
   
   	// #endregion
   
   	//#region	МЕТОДЫ ДЛЯ ВЫВОДА И ПОКРАСКИ
      public static void color(int[] array, int j) {
         for (int x = 0; x < array.length; x++) {
            if (x == j || x == j + 1) {
               printYellow(array[x]);
            } else {
               printNormal(array[x]);
            }
         }
         System.out.println();
      }
   
      public static void colorIfTrue(int[] array, int j) {
      	// покраска массива
         for (int x = 0; x < array.length; x++) {
            if (x == j) {
               if (array[x] > array[x + 1]) {
                  printRed(array[x]);
               }
            } else if (x == j + 1) {
               printRed(array[x]);
            } else {
               printNormal(array[x]);
            }
         }
         System.out.println();
      }
   
      public static void colorIfFalse(int[] array, int j) {
      	// покраска массива
         for (int x = 0; x < array.length; x++) {
            if (x == j) {
               if (array[x] < array[x + 1]) {
                  printGreen(array[x]);
               }
            } else if (x == j + 1) {
               printNormal(array[x]);
            } else {
               printNormal(array[x]);
            }
         }
         System.out.println();
      }
   
      public static void colorSwap(int[] array, int j) {
      	// покраска массива
         for (int x = 0; x < array.length; x++) {
            if (x == j) {
               if (array[x] < array[x + 1]) {
                  printGreen(array[x]);
               }
            } else if (x == j + 1) {
               printGreen(array[x]);
            } else {
               printNormal(array[x]);
            }
         }
         System.out.println();
      }
   	//#endregion	
   }

	// #region ВЫВОД ЗАГОЛОВКОВ ДЛЯ ЭТАПОВ
	// -----------------------------------------------------------------------------
   public class TableHeaderPrinter {
   
      public static void printTableHeader(int stage) {
         System.out.println("\nСОРТИРОВКА ПУЗЫРЬКОМ");
         switch (stage) {
            case 1:
               printTableHeader1();
               break;
            case 2:
               printTableHeader2();
               break;
            case 3:
               printTableHeader3();
               break;
            case 4:
               printTableHeader4();
               break;
            default:
               System.out.println("Некорректный номер этапа");
         }
      }
   
      private static void printTableHeader1() {
         System.out.println("ЭТАП 1 - класс BubbleSort1 - вывод итераций массива");
         System.out.printf(Color.GREYBACK + "%-5s%-10s\n", "#", "Array" + Color.RESET);
      }
   
      private static void printTableHeader2() {
         System.out.println("ЭТАП 2 - класс BubbleSort2 - вывод цветных индексов");
         System.out.printf(Color.GREYBACK + "%-5s%-5s%-5s%-10s\n", "#", "j", "j+1", "Array" + Color.RESET);
      }
   
      private static void printTableHeader3() {
         System.out.println("ЭТАП 3 - класс BubbleSort3 - вывод цветных условий if");
         System.out.printf(Color.GREYBACK + "%-5s%-13s%-13s%-3s%-5s%-30s\n", "#", "condition", "true|false", "j",
            	"j+1", "Array" + Color.RESET);
      }
   
      private static void printTableHeader4() {
         System.out.println("ЭТАП 4 - класс BubbleSort4 - вывод цветных действий при наступлении условий if");
         System.out.printf(Color.GREYBACK + "%-5s%-13s%-13s%-3s%-5s%-30s\n", "#", "condition", "true-swap", "j",
            	"j+1", "Array" + Color.RESET);
      }
   
   }
	// #endregion
}




