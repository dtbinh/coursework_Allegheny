import static java.util.Arrays.*;

public class Queen_Part2{

    public Queen_Part2(){
    }



    public static void main(String[]args){

    int N = 6;
        int[][] board = new int[N][N];

        for(int x=0; x<N; x++ ){
            for(int y=0; y<N; y++){
                board[x][y]=0;
            }
        }

        //printSolutionAndExit(board);
        for (int row=0; row < N; row++){
            placeQueen(board, row, N);
        }
    }


    public static void placeQueen(int[][] board, int row, int N){

        for(int col = 0; col<N; col++){
            if(isLegalPlacement(board, row, col, N)){
                addQueen(board, row, col);
                if(row == N){
                    printSolutionAndExit(board, N);
                }else{
                    placeQueen(board, row+1, N);
                }//else
            }//if
        }//for
    }//placequeen

    public static boolean isLegalPlacement(int[][] board, int row, int col, int N){

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
        for (i=row, j=col; j>=0 && i<N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }


public static void addQueen(int[][] board, int row, int col){
    board[row][col] = 1;
}

public static void printSolutionAndExit(int[][] board, int N){
    for(int z = 0; z<N; z++){
        for(int y=0; y<N; y++){
            System.out.print(board[z][y]+" ");
        }
        System.out.println();
    }
}

}
