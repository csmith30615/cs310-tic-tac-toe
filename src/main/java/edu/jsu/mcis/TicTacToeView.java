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

           int[] coords = {0, 0};

            if(isXTurn){
                System.out.println("Player 1 (X) Move: ");
            }else{
                System.out.println("Player 2 (O) Move: ");
            }

            System.our.print("Enter the row and column numbers, seperated by a space: ");
            
            for(int i = 0; i < 2; i++){
                if(keyboard.hasNextInt()){
                    coords[i] = keyboard.nextInt();
                }else{
                    showInputError();
                }
            }
            if(keyboard.hasNextInt()){

            }
            
        keyboard.nextInt();
        return new TicTacToeMove()
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
