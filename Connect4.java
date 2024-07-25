import java.util.Scanner;

public class Connect4 {
    private static final int rows = 6;
    private static final int columns = 7;

    private char[][] board;
    private char currentPlayer;

    public Connect4() {
        board = new char[rows][columns];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("1 2 3 4 5 6 7");
    }

    private boolean dropPiece(int column) {
        for (int i = rows - 1; i >= 0; i--) {
            if (board[i][column] == '-') {
                board[i][column] = currentPlayer;
                return true;
            }
        }
        System.out.println("Column is full. Try again.");
        return false;
    }

    private boolean checkWin() {
        return checkrows() || checkcolumns() || checkDiagonals();
    }

    private boolean checkrows() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns - 3; j++) {
                if (board[i][j] == currentPlayer &&
                        board[i][j + 1] == currentPlayer &&
                        board[i][j + 2] == currentPlayer &&
                        board[i][j + 3] == currentPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkcolumns() {
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == currentPlayer &&
                        board[i + 1][j] == currentPlayer &&
                        board[i + 2][j] == currentPlayer &&
                        board[i + 3][j] == currentPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < columns - 3; j++) {
                if (board[i][j] == currentPlayer &&
                        board[i + 1][j + 1] == currentPlayer &&
                        board[i + 2][j + 2] == currentPlayer &&
                        board[i + 3][j + 3] == currentPlayer) {
                    return true;
                }

                if (board[i][j + 3] == currentPlayer &&
                        board[i + 1][j + 2] == currentPlayer &&
                        board[i + 2][j + 1] == currentPlayer &&
                        board[i + 3][j] == currentPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        while (!gameWon && !isBoardFull()) {
            printBoard();

            System.out.println("Player " + currentPlayer + ", enter your move (1-7): ");
            int column = scanner.nextInt() - 1;

            if (column >= 0 && column < columns && dropPiece(column)) {
                gameWon = checkWin();
                if(gameWon == true)
                	break;
                switchPlayer();
            }
        }

        printBoard();

        if (gameWon) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else {
            System.out.println("It's a draw!");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Connect4 connectFour = new Connect4();
        System.out.println("CONNECT FOUR GAME");
        connectFour.playGame();
    }
}
