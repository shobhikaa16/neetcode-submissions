class Solution {
    public boolean isValidSudoku(char[][] board) {
        //checking all the rows
        for(int i=0; i<board.length; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0; j<board[0].length; j++){
                if((board[i][j])=='.') continue;
                if(set.contains(board[i][j])){
                    return false;
                }else{
                    set.add(board[i][j]);
                }
            }
        }
        //checking all the columns
        for(int i=0; i<board.length; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0; j<board[0].length; j++){
                if(board[j][i] == '.') continue;
                if(set.contains(board[j][i])){
                    return false;
                }else{
                    set.add(board[j][i]);
                }
            }
        }

        //checking 3*3 boxes
        
        for(int i=0; i<board.length; i+=3){
            int sr = i;
            int er = sr+2;
            for(int j=0; j< board[0].length; j+=3){
                int sc = j;
                int ec = sc+2;
                if(!traverse(board,sr,er,sc,ec)){
                    return false;
                }
            }
        }
        return true;
    
    
    }
    //making traverse function
    public boolean traverse(char[][] board, int sr, int er, int sc, int ec){
        HashSet<Character> set = new HashSet<>();
        for(int i=sr; i<=er; i++){
            for(int j=sc; j<=ec; j++){
                char num = board[i][j];
                if(num == '.') continue;
                if(set.contains(num)){
                    return false;
                }else{
                    set.add(num);
                }
            }
        }
        return true;
    }
}
