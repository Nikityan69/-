public class ChristmasTree {
    public static void main(String[] args) {
        int levels = 5;  // Задайте кількість рівнів ялинки

        // Виводимо ялинку
        drawChristmasTree(levels);

        // Створюємо та виводимо двовимірний масив
        int rows = 4;  // Задайте кількість рядків
        int columns = 5;  // Задайте кількість стовпців
        generateAndPrintArray(rows, columns);
    }

    // Метод для виведення ялинки
    public static void drawChristmasTree(int levels) {
        for (int i = 1; i <= levels; i++) {
            // Друкуємо пробіли
            for (int j = 0; j < levels - i; j++) {
                System.out.print(" ");
            }
            // Друкуємо зірочки
            for (int k = 0; k < 2 * i - 1; k++) {
                System.out.print("*");
            }
            // Переходимо на новий рядок
            System.out.println();
        }
    }

    // Метод для створення та виведення двовимірного масиву
    public static void generateAndPrintArray(int rows, int columns) {
        int[][] array = new int[rows][columns];
        int value = 1;  // Початкове значення

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = value;
                value += 3;  // Збільшуємо кожен елемент на 3
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();  // Перехід на новий рядок
        }
    }
}
