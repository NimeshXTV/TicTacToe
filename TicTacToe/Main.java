import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' '; 
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + " enter : ");

            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = player;

                if (gameOver == haveWon(board, player)) {
                    printBoard(board);
                    System.out.println("Player " + player + " has won!");
                    gameOver = true;
                }
                
                else if (isBoardFull(board)) {  // Check for draw
                    printBoard(board);
                    System.out.println("It's a draw!");
                    gameOver = true;  // End the game
                }
                
                else
                player = (player == 'X') ? 'O' : 'X'; 
            }
            else
            System.out.println(" Invalid Move, Try again !");
        }
        printBoard(board);
        sc.close();
    }

    public static void printBoard(char board[][]){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
               System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    public static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    return false;  // If any empty space is found, board is not full
                }
            }
        }
        return true;  // If no empty spaces, the board is full
    }
    

    public static boolean haveWon(char board[][],char player){

        //For row.
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player ) {
                return true;
            }
        }

        //For coloumn.
        for (int col = 0; col < board.length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player ) {
                return true;
            }
        }

        //For diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player ) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player ) {
            return true;
        }
        return false;
    }
}