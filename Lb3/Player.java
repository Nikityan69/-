import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void makeMove(GameBoard board) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(name + " (" + symbol + "), enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (board.makeMove(row, col, symbol)) {
                break;
            }
        }
    }
}
