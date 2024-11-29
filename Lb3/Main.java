import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");

        System.out.print("Enter size of the board: ");
        int size = scanner.nextInt();

        GameBoard board = new GameBoard(size);

        System.out.print("Enter name for Player 1: ");
        Player player1 = new Player(scanner.next(), 'X');

        System.out.print("Enter name for Player 2: ");
        Player player2 = new Player(scanner.next(), 'O');

        Player currentPlayer = player1;

        while (true) {
            board.displayBoard();
            currentPlayer.makeMove(board);

            if (board.checkWinner(currentPlayer.getSymbol())) {
                board.displayBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            if (board.isFull()) {
                board.displayBoard();
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }
}
