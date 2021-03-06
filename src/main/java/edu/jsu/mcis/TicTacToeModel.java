package edu.jsu.mcis;

public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        this.board = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */
        for(int i = 0; i < width; i++){
            for(int j = 0; j < width; j++){
                this.board[i][j] = Mark.EMPTY;
            }
        }   
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        
        if (isValidSquare(row, col) && !(isSquareMarked(row, col))){
            if(xTurn){
                board[row][col] = Mark.X;
            }else{
                board[row][col] = Mark.O;
            }

            xTurn = !xTurn;

            return true;
        }
        
        return false;
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        if (row < 0 || row >= width || col < 0 || col >= width){
            return false;
        }

        return true;
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        
        if(getMark(row, col) == Mark.EMPTY){
            return false;
        }

        return true;
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        return board[row][col];            
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        if(isMarkWin(Mark.X)){
            return Result.X;
        }else if(isMarkWin(Mark.O)){
            return Result.O;
        }else if(isTie()){
            return Result.TIE;
        }else{
            return Result.NONE;
        }
    }
	
    private boolean isMarkWin(Mark mark) {
        boolean horizontal = true, vertical = true, back = true, forward = true;
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        for(int i = 0; i < width; i++){
            horizontal = true;
            vertical = true;

            for(int j = 0; j < width; j++){ //Check for Vertical or Horizontal win
                if(board[i][j] != mark){
                    horizontal = false;
                }
                
                if(board[j][i] != mark){
                    vertical = false;
                }
            }

            if(horizontal || vertical){
                return true;
            }

            if(board[i][i] != mark){ //Check for diagonal win
                back = false;
            }
            
            if(board[width - 1 - i][i] != mark){
                forward = false;
            }
        }

        

        if(forward || back){
            return true;
        }
        
        return false;
    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        boolean isBoardFull = true;

        for(Mark[] tempArr : this.board){
            for(Mark temp : tempArr){
                if(temp == Mark.EMPTY){
                    isBoardFull = false;
                }
            }
        }
        
        if(isBoardFull && !isMarkWin(Mark.X) && !isMarkWin(Mark.O)){
            return true;
        }

        return false;
        
    }

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");

        for (int i = 0; i < width; i++){
            output.append(i);
        }

        output.append("\n");
        
        /* Output the board contents as a string (see examples) */
        
        for(int i = 0; i < width; i++){
            output.append(i + " ");

            for(int j = 0; j < width; j++){
                output.append(board[i][j]);
            }

            output.append("\n");
        }       

        return output.toString();
    }
    
}
