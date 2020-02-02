package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeView {
    
    private final Scanner keyboard;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView() {
        
        /* Initialize scanner (for console keyboard) */
        
        keyboard = new Scanner(System.in);
        
    }
	
    public TicTacToeMove getNextMove(boolean isXTurn) {
        
        /* Prompt the player to enter the row and the column of their next move.
           Return as a TicTacToeMove object. */

           int[] coords = {-1, -1};
           boolean properCoords = false;

            if(isXTurn){
                System.out.println("Player 1 (X) Move: ");
            }else{
                System.out.println("Player 2 (O) Move: ");
            }

            System.out.print("Enter the row and column numbers, seperated by a space: ");
                
            for(int i = 0; i < 2; i++){
                coords[i] = keyboard.nextInt();
            }

            System.out.println("");
            
        return new TicTacToeMove(coords[0], coords[1]);
    }

    public void showInputError() {

        System.out.println("Entered location is invalid, already marked, or out of bounds.");

    }

    public void showResult(String r) {

        System.out.println(r + "!");

    }
    
    public void showBoard(String board) {
        
        System.out.println("\n\n" + board);
        
    }
	
}
