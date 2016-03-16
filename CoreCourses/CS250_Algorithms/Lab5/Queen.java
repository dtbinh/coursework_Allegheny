import static java.util.Arrays.*;

public class Queen{

    public static void Queen(){
    }


    public static void main(String[]args){
        int[][] board = new int[8][8];
        for(int x=0; x<8; x++ ){
            for(int y=0; y<8; y++){
                board[x][y]=0;
            }
        }

        //printSolutionAndExit(board);
        for (int row=0; row < 8; row++){
            placeQueen(board, row);
        }
    }


    public static void placeQueen(int[][] board, int row){

        for(int col = 0; col<=8; col++){
            if(isLegalPlacement(board, row, col)){
                addQueen(board, row, col);
                if(row == 7){
                    printSolutionAndExit(board);
                }else{
                    placeQueen(board, row+1);
                }//else
            }//if
        }//for
    }//placequeen

    public static boolean isLegalPlacement(int[][] board, int row, int col){

        int i, j;

        /* Check this row on left side */
        for (i = 0; i <= col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check this column */
        for(i = 0; i<=row; i++){
            if(board[i][col] == 1){
                return false;
            }
        }

        /* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i=row, j=col; j>=0 && i<8; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }


public static void addQueen(int[][] board, int row, int col){
    board[row][col] = 1;
}

public static void printSolutionAndExit(int[][] board){
    for(int z = 0; z<8; z++){
        for(int y=0; y<8; y++){
            System.out.print(board[z][y]+" ");
        }
        System.out.println();
    }
}

}
