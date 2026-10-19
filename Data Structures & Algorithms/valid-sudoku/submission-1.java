class Solution {
    public boolean isValidSudoku(char[][] board) {
        //this is another way to do the ques with less time complexity
        //traverse each box and then checking the duplicacy with the help of strings
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == '.') continue;
                String row = board[i][j] + "get at row" + i;
                String box = board[i][j] + "get at box" + i/3 + j/3;
                String col = board[i][j] + "get at col" + j;
                if(set.contains(row) || set.contains(col) || set.contains(box)){
                    return false;
                }else{
                    set.add(row);
                    set.add(col);
                    set.add(box);
                }
            }
        }
        return true;
    }
}
