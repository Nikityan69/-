import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Db db = new Db();

        System.out.println("Игрок 1, введите логин:");
        String username1 = scanner.nextLine();
        System.out.println("Игрок 1, введите пароль:");
        String password1 = scanner.nextLine();

        if (!db.isUserExists(username1, password1)) {
            System.out.println("Неверные данные игрока 1!");
            db.close();
            return;
        }

        System.out.println("Игрок 2, введите логин:");
        String username2 = scanner.nextLine();
        System.out.println("Игрок 2, введите пароль:");
        String password2 = scanner.nextLine();

        if (!db.isUserExists(username2, password2)) {
            System.out.println("Неверные данные игрока 2!");
            db.close();
            return;
        }

        System.out.println("Игроки успешно авторизованы! Начинаем игру.");

        // Логика игры крестики-нолики
        char[][] board = new char[3][3];
        initializeBoard(board);
        displayBoard(board);
        char currentPlayer = 'X';
        boolean gameWon = false;

        while (!gameWon) {
            System.out.println("Ход игрока " + currentPlayer);
            int row, col;

            // Запрос ввода от игрока
            while (true) {
                System.out.print("Введите номер строки (1-3): ");
                row = scanner.nextInt() - 1;
                System.out.print("Введите номер столбца (1-3): ");
                col = scanner.nextInt() - 1;

                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                    break;
                } else {
                    System.out.println("Некорректный ход! Попробуйте снова.");
                }
            }

            // Обновляем поле
            board[row][col] = currentPlayer;
            displayBoard(board);

            // Проверка на победу
            gameWon = checkWinner(board, currentPlayer);
            if (gameWon) {
                System.out.println("Игрок " + currentPlayer + " победил!");
            } else if (isBoardFull(board)) {
                System.out.println("Ничья!");
                break;
            }

            // Меняем игрока
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        db.close();
        scanner.close();
    }

    // Инициализация игрового поля
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Вывод игрового поля
    public static void displayBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Проверка победы
    public static boolean checkWinner(char[][] board, char player) {
        // Проверка по строкам
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // Проверка по столбцам
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // Проверка по диагоналям
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    // Проверка на заполненность поля (ничья)
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
