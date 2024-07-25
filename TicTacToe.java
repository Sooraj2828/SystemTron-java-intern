import java.util.*;

public class TicTacToe {
  public static void main(String[] args) {
    char[][] board = new char[3][3];
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        board[row][col] = ' ';
      }
    }

    char player = 'X';
    boolean RunGame = true;
    Scanner sc = new Scanner(System.in);

    while (RunGame) {
      printBoard(board);
      System.out.println("PLAYER " + player + ", enter your pos :");
      int row = sc.nextInt();
      int col = sc.nextInt();
      System.out.println();

      try {
        if (board[row][col] == ' ') {
          board[row][col] = player;

          RunGame = haveWon(board, player);
          if (RunGame == false) {
            System.out.println("Player " + player + " has won");;
          } else if (RunGame && isBoardFull(board)) {
            System.out.println("Game Draw !!!");
            break;
          } else {
            if (player == 'X') { //swapping the turns
              player = 'O';
            } else {
              player = 'X';
            }
          }
        } else {
          System.out.println("Invalid move .try again");
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println(e.getMessage());
      }
    }
    printBoard(board);
  }
  public static void printBoard(char[][] board) {
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        System.out.print(board[row][col] + "|");
      }
      System.out.println();
    }
  }

  public static boolean haveWon(char[][] board, char player) {
    //check the rows
    for (int row = 0; row < 3; row++) {
      if (board[row][0] == player && board[row][1] == player && board[row][2] == player)
        return false;
    }
    //check for columns
    for (int col = 0; col < 3; col++) {
      if (board[0][col] == player && board[1][col] == player && board[2][col] == player)
        return false;
    }

    //check for diagonals
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
      return false;
    if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
      return false;
    return true;
  }

  public static boolean isBoardFull(char board[][]) {
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        if (board[row][col] == ' ') {
          return false;
        }
      }
    }
    return true;
  }
}