import jdk.swing.interop.SwingInterOpUtils;

import java.sql.SQLOutput;
import java.util.*;
import java.lang.*;

public class NQueens {

    // Chessboard simulation
    // 0 = empty, 1 = Queen
    private int[][] board;

    // Dimensions of board
    private int size;

    public NQueens(int n) {

        size = n;
    }

    // Checks to see if size >= 1, then attempts to solve n queens on that board

    // If successful, prints board and returns true (otherwise returns false)
    public boolean placeNQueens() throws Exception {

        checkBoard();
        if (placeQueens(0)) {
            printToConsole();
            return true;
        }

    return false;
    }

    // Throws error if size < 1
    private void checkBoard() throws Exception {
        if (size < 1)
            throw new Exception("Size of board cannot be less than 1 x 1");

        else
            board = new int[size][size];
    }

    // Places queens on board
    public boolean placeQueens(int row) {


            for (int col = 0; col < size; col++) {

                // Base case: all rows checked, and have reached row after end of chess board
                if (row == size) {
                    return true;
                }
                // If a space is not attacked by an existing queen, place a queen
                if (notAttacked(row, col)) {
                    board[row][col] = 1;

                    // if you can place a queen in the next row, return true
                    // Otherwise, remove the queen and try again with the square on...
                    // ...the right
                    if (placeQueens(row + 1)) {
                        return true;
                    }
                    else {

                        board[row][col] = 0;
                    }
                }

            }
            // Case: Cannot place queens anywhere on given row

            return false;

    }

    // Checks to see if a queen is attacked by another queen
   public boolean notAttacked(int row, int col) {

        // Check for attacks from top left
        for (int i = 0; row - i >= 0 && col - i >= 0; i++) {
            if (board[row-i][col-i] == 1) {
                // System.out.println("FROM TOP LEFT");
                return false;
            }


       }

        // Check for attacks from bottom right
        for (int i = 0; row + i < size && col + i < size; i++) {
            if (board[row+i][col+i] == 1) {
                // System.out.println("FROM BOTTOM RIGHT");
                return false;
            }
        }
        // Check for attacks from bottom left
        for (int i = 0; row + i < size && col - i >= 0; i++) {
            if (board[row+i][col-i] == 1) {
                // System.out.println("FROM BOTTOM LEFT");
                return false;
            }
        }

        // Check for attacks from top right
        for (int i = 0; row - i >= 0 && col + i < size; i++) {
            if (board[row-i][col+i] == 1) {
                // System.out.println("FROM TOP RIGHT");
                return false;
            }
        }

        // Check for attacks from left or right
       for (int x = 0; x < size; x++) {

           if (board[row][x] == 1 && x != col) {
               // System.out.println("HORIZ");
               return false;
           }
       }

       // Check for attacks from above or below
        for (int y = 0; y < size; y++) {
            if (board[y][col] == 1 && y != row) {
                // System.out.println("VERT ATTACKED");
                return false;
            }
        }

        // Case: Queen not attacked
        return true;
       }

       // Prints board; 0 = empty, 1 = Queen
    public void printToConsole() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 1) {
                    System.out.print("Q\t");
                }

                else if (board[row][col] == 2) {
                    System.out.print("*\t");
                }

                else {
                    System.out.print("_\t");
                }

            }
            System.out.println();

        }
    }


}

