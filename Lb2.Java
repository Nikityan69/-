public class ChristmasTree {
    public static void main(String[] args) {
        int levels = 5;  // Задайте кількість рівнів ялинки

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
}
