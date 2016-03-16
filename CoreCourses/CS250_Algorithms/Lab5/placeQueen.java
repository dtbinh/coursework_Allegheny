public class Queen{
    public static Queen(){}

    public static void placeQueen(int row){
        for(int col = 0; col<8; col++){
            if(isLegalPlacement(board, row, col)){
                addQueen(bard, row, col);
                if(row == 7){
                    printSolutionAndExit();
                }else{
                    placeQueen(row+1);
                }//else
            }//if
        }//for
    }//placequeen


    public static void main(String[]args){
        for (int row; row < 8; row++){
            Queen.placeQueen(row);
        }
    }

}
