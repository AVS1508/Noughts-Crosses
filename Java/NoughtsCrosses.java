/**
 * Project Title  : Noughts & Crosses
 * Version        : 1.0
 * Developed By   : Aditya Vikram Singh
*/

package Java;

import java.util.Scanner;

public class NoughtsCrosses {

    public static void main(String[] args) {
        char[] initialBoard = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        displayGameBoard(initialBoard);
        System.out.println(playGame(initialBoard));
    }

    private static void displayGameBoard(char[] Board) {
        System.out.println("-------------");
        System.out.println("| " + Board[0] + " | " + Board[1] + " | " + Board[2] + " |");
        System.out.println("-------------");
        System.out.println("| " + Board[3] + " | " + Board[4] + " | " + Board[5] + " |");
        System.out.println("-------------");
        System.out.println("| " + Board[6] + " | " + Board[7] + " | " + Board[8] + " |");
        System.out.println("-------------");
    }

    private static String playGame(char[] Board) {
        Scanner input = new Scanner(System.in);
        int position;
        boolean playerOneMove = true;
        for (int i = 0; i < 9 && winState(Board) == '!'; ++i) {
            System.out.print("Player " + ((playerOneMove) ? "X" : "O") + "'s Turn- Enter the move: ");
            position = input.nextInt();
            while (Board[position - 1] == 'X' || Board[position - 1] == 'O') {
                System.out.print("Invalid move! Already occupied space, please try again: ");
                position = input.nextInt();
            }
            Board[position - 1] = (playerOneMove) ? 'X' : 'O';
            displayGameBoard(Board);
            playerOneMove = !playerOneMove;
        }
        input.close();
        if (winState(Board) != '!') {
            return (winState(Board) + " wins!");
        } else {
            return "Game drawn!";
        }
    }

    private static char winState(char[] Board) {
        for (int i = 0; i < 3; ++i) {
            if (Board[3 * i] == Board[3 * i + 1] && Board[3 * i + 1] == Board[3 * i + 2]) {
                return Board[3 * i + 1];
            }
            if (Board[i] == Board[i + 3] && Board[i + 3] == Board[i + 6]) {
                return Board[i + 3];
            }
            if (Board[i] == Board[4] && Board[4] == Board[8 - i]) {
                return Board[4];
            }
        }
        return '!';
    }
}