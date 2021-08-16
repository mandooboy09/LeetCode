class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        Sdoku sdoku = new Sdoku(n);
        
        for(int r = 0; r < n; r += 1){
            for(int c = 0; c < n; c+= 1){
                if(board[r][c] != '.'){
                    int value = Character.getNumericValue(board[r][c]);
                    sdoku.setSdoku(r+1, c+1, value);
                }
                
            }
        }
        
        // System.out.println(Arrays.deepToString(sdoku.rowsValue));
        // System.out.println(Arrays.deepToString(sdoku.colsValue));
        System.out.println(Arrays.deepToString(sdoku.groupValue));
        
        return sdoku.isValid();
        
    }
}

class Sdoku{
    int n;
    int[][] rowsValue;
    int[][] colsValue;
    int[][] groupValue;
    
    public Sdoku(int n){
        this.n = n;
        this.rowsValue = new int[n + 1][n + 1];
        this.colsValue = new int[n + 1][n + 1];
        this.groupValue = new int[n + 1][n + 1];
    }
    
    public void setSdoku(int r, int c, int value){
        rowsValue[r][value] += 1;
        colsValue[c][value] += 1;
        
        int g = ((r - 1) / 3) * 3 + (c - 1) / 3 + 1;
        groupValue[g][value] += 1;
    }
    
    public boolean isValid(){
        for(int i = 1; i <= n; i += 1){
            for(int value = 1; value <= n; value += 1){
                if(rowsValue[i][value] > 1 || colsValue[i][value] > 1 || groupValue[i][value] > 1){
                    return false;
                }
            }
        }
        return true;
    }
}